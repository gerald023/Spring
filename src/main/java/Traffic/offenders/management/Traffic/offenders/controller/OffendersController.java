package Traffic.offenders.management.Traffic.offenders.controller;

import Traffic.offenders.management.Traffic.offenders.dto.OffenderDTO;
import Traffic.offenders.management.Traffic.offenders.modal.Offender;
import Traffic.offenders.management.Traffic.offenders.service.impliment.OffenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/offender")

public class OffendersController {
    @Autowired
    private final OffenderService offenderService;

    public OffendersController(OffenderService offenderService) {
        this.offenderService = offenderService;
    }

    @GetMapping("/getOffenders")
    public List<Offender> getOffenders(){
        return offenderService.getAllOffenders();
    }
    @PostMapping("/addOffender")
    public ResponseEntity<OffenderDTO> createOffender(@RequestBody OffenderDTO offenderDTO){
        OffenderDTO offender = offenderService.createOffenders(offenderDTO);
        return  new ResponseEntity<>(offender, HttpStatus.CREATED);
    }
    @PutMapping("/updateOffender")
    public Offender updatingOffender(@RequestBody Offender offender){
        return offenderService.updateOffender(offender);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletingOffender(@PathVariable Integer id){
        return offenderService.deleteOffender(id);
    }
}

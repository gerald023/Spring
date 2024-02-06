package Traffic.offenders.management.Traffic.offenders.service.impliment;

import Traffic.offenders.management.Traffic.offenders.dto.OffenderDTO;
import Traffic.offenders.management.Traffic.offenders.modal.Offender;
import Traffic.offenders.management.Traffic.offenders.repository.OffenderRepository;
import Traffic.offenders.management.Traffic.offenders.service.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class OffenderService implements Services {
    @Autowired
    private final OffenderRepository offenderRepository;

    public OffenderService(OffenderRepository offenderRepository) {
        this.offenderRepository = offenderRepository;
    }

    @Override
    public OffenderDTO createOffenders(OffenderDTO offenderDTO) {
        Offender offender = new Offender();
        offender.setFirstName(offenderDTO.getFirstName());
        offender.setLastName(offenderDTO.getLastName());
        offender.setAge(offenderDTO.getAge());
        offender.setGender(offenderDTO.getGender());
        offender.setNin(offenderDTO.getNin());
        offender.setOffence(offenderDTO.getOffence());

        Offender savedOffender = offenderRepository.save(offender);
        OffenderDTO registerDTO = new OffenderDTO();
        registerDTO.setFirstName(savedOffender.getFirstName());
        registerDTO.setLastName(savedOffender.getLastName());
        registerDTO.setAge(savedOffender.getAge());
        registerDTO.setGender(savedOffender.getGender());
        registerDTO.setNin(savedOffender.getNin());
        registerDTO.setOffence(savedOffender.getOffence());


        return registerDTO;
    }

    @Override
    public List<Offender> getAllOffenders() {
        return offenderRepository.findAll();
    }

    @Override
    public Offender updateOffender(@RequestBody Offender offender) {
        Offender data = offenderRepository.findById(offender.getId()).orElse(null);
        if (data != null){
            data.setFirstName(offender.getFirstName());
            data.setLastName(offender.getLastName());
            data.setAge(offender.getAge());
            data.setNin(offender.getNin());
            data.setGender(offender.getGender());
            data.setOffence(offender.getOffence());
            offenderRepository.save(data);
        }
        return data;
    }

    @Override
    public ResponseEntity<String> deleteOffender(@PathVariable Integer id) {
        offenderRepository.deleteById(Long.valueOf(id));
        String msg = "the offender with the id of " + id + " has been deleted";
        return  ResponseEntity.ok(msg);
    }


}

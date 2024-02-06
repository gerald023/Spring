package Traffic.offenders.management.Traffic.offenders.service;

import Traffic.offenders.management.Traffic.offenders.dto.OffenderDTO;
import Traffic.offenders.management.Traffic.offenders.modal.Offender;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Services {
    public OffenderDTO createOffenders(OffenderDTO offenderDTO);
    public List<Offender> getAllOffenders();

    Offender updateOffender( Offender offender);

    ResponseEntity<String> deleteOffender(Integer id);
}

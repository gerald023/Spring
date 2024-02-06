package Traffic.offenders.management.Traffic.offenders.repository;

import Traffic.offenders.management.Traffic.offenders.modal.Offender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OffenderRepository extends JpaRepository<Offender, Long> {

}

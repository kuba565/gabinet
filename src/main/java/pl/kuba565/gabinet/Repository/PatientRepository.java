package pl.kuba565.gabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.Model.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}

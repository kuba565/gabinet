package pl.kuba565.gabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.Model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByAdmin_Login(String adminUsername);

    List<Patient> findByLastName(String lastName);

    List<Patient> findByName(String name);

    List<Patient> findByPesel(String pesel);
}

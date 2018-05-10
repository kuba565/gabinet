package pl.kuba565.gabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.Model.Admin;
import pl.kuba565.gabinet.Model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByAdmin_Login(String adminUsername);

    List<Patient> findByLastNameAndAdmin(String lastName, Admin admin);

    List<Patient> findByNameAndAdmin(String name, Admin admin);

    List<Patient> findByPeselAndAdmin(String pesel, Admin admin);
}

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

    List<Patient> findByPeselAndAdminAndName(String pesel, Admin admin, String name);

    List<Patient> findByPeselAndAdminAndLastName(String pesel, Admin admin, String LastName);

    List<Patient> findByNameAndAdminAndLastName(String name, Admin admin, String lastName);

    List<Patient> findByNameAndAdminAndPeselAndLastName(String name, Admin admin,String pesel, String lastName);

    List<Patient> findAllByAdmin_LoginOrderByNextVisitDateStringAscNextVisitHourStringAsc(String adminUsername);
}

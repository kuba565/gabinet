package pl.kuba565.gabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.Model.Admin;
import pl.kuba565.gabinet.Model.Patient;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findAllByAdmin_Login(String adminUsername);

    List<Patient> findByLastNameIgnoreCaseContainingAndAdmin(String lastName, Admin admin);

    List<Patient> findByNameIgnoreCaseContainingAndAdmin(String name, Admin admin);

    List<Patient> findByPeselIgnoreCaseContainingAndAdmin(String pesel, Admin admin);

    List<Patient> findByPeselIgnoreCaseContainingAndAdminAndNameIgnoreCaseContaining(String pesel, Admin admin, String name);

    List<Patient> findByPeselIgnoreCaseContainingAndAdminAndLastNameIgnoreCaseContaining(String pesel, Admin admin, String LastName);

    List<Patient> findByNameIgnoreCaseContainingAndAdminAndLastNameIgnoreCaseContaining(String name, Admin admin, String lastName);

    List<Patient> findByNameIgnoreCaseContainingAndAdminAndPeselIgnoreCaseContainingAndLastNameIgnoreCaseContaining(String name, Admin admin,String pesel, String lastName);

    List<Patient> findAllByAdmin_LoginOrderByNextVisitDateStringAscNextVisitHourStringAsc(String adminUsername);

}

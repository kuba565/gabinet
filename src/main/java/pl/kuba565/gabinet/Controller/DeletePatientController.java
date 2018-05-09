package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class DeletePatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/delete/{id}")
    String deletePatient(@PathVariable Long id) {

        System.out.println(id);
        Patient patientToBeDeleted = patientRepository.getOne(id);
        patientRepository.delete(patientToBeDeleted);
        return "redirect:/patient/list";
    }
}

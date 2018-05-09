package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.PatientRepository;

import java.util.List;

@Controller
@RequestMapping("/patient")
public class ListPatientController {
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/list")
    public String tweetsList(Model model) {
        List<Patient> patients = patientRepository.findAll();
        model.addAttribute("patientsList", patients);

        return "patient-list";
    }


}

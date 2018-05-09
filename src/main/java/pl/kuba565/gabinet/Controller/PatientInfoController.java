package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientInfoController {
    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/info/{id}")
    public String tweetsList(Model model, @PathVariable Long id) {
        Patient patient = patientRepository.getOne(id);
        model.addAttribute("patient", patient);

        return "patient-info";
    }
}

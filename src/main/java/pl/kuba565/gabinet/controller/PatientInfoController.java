package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.PatientRepository;

@Controller
@RequestMapping("/patient")
public class PatientInfoController {


    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/info/{id}")
    public String patientsList(Model model, @PathVariable Long id) {
        Patient patient = patientRepository.getOne(id);
        model.addAttribute("patient", patient);


        return "patient-info";
    }
}

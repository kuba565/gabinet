package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/patient")
public class ListPatientController {
    @Autowired
    HttpSession session;

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/list")
    public String tweetsList(Model model) {
        String adminUsername = (String) session.getAttribute("adminUsername");
        List<Patient> patients = patientRepository.findAllByAdmin_Login(adminUsername);

        model.addAttribute("patientsList", patients);

        return "patient-list";
    }


}

package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Admin;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.AdminRepository;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;

@Controller
@RequestMapping("/patient")
public class AddPatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private HttpSession session;

    @GetMapping("/add")
    public String getPatientForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "form/add-patient";
    }

    @PostMapping("/add")
    String registration(@Valid Patient patient, BindingResult result) {

        if (result.hasErrors()) {
            return "form/add-patient";
        }

        if (!patient.getBirthDateString().equals("")) {
            Date birthDate = Date.valueOf(patient.getBirthDateString());
            patient.setBirthDate(birthDate);
        }


        String adminLogin = (String) session.getAttribute("adminUsername");
        Admin admin = adminRepository.getAdminByLogin(adminLogin);

        patient.setAdmin(admin);

        patientRepository.save(patient);
        return "redirect:/patient/list";
    }
}

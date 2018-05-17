package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kuba565.gabinet.model.Admin;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.AdminRepository;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.sql.Date;

@Controller
@RequestMapping("/patient")
public class EditPatientController {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private HttpSession session;

    @GetMapping("/edit/{id}")
    public String getPatientForm(Model model, @PathVariable String id) {

        Patient patient = patientRepository.getOne(Long.parseLong(id));
        model.addAttribute("patientToBeEdited", patient);
        return "form/edit-patient";
    }

    @PostMapping("/edit/{id}")
    String registration(@Valid Patient patient, BindingResult result) {

        if (result.hasErrors()) {
            return "form/edit-patient";
        }

        if (!patient.getBirthDateString().equals("")) {
            Date birthDate = Date.valueOf(patient.getBirthDateString());
            patient.setBirthDate(birthDate);
        }

        String nextVisitDateString = patient.getNextVisitDateString();
        String nextVisitHourString = patient.getNextVisitHourString();


        String adminLogin = (String) session.getAttribute("adminUsername");
        Admin admin = adminRepository.getAdminByLogin(adminLogin);

        patient.setNextVisitDateString(nextVisitDateString);
        patient.setNextVisitHourString(nextVisitHourString);
        patient.setAdmin(admin);

        patientRepository.save(patient);
        return "redirect:/patient/info/{id}";
    }
}

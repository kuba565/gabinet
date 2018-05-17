package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Admin;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.AdminRepository;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/patient")
public class SearchController {

    @Autowired
    HttpSession session;

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    AdminRepository adminRepository;

    @GetMapping("/search")
    public String getSearchForm(Model model) {
        model.addAttribute("patient", new Patient());
        return "form/search";
    }

    @PostMapping("/search")
    String search(@ModelAttribute Patient patient) {
        List<Patient> searchResults = new ArrayList<>();

        String adminLogin = (String) session.getAttribute("adminUsername");

        Admin admin = adminRepository.getAdminByLogin(adminLogin);

        Boolean onlyLastName = !patient.getLastName().equals("") && patient.getName().equals("") && patient.getPesel().equals("");
        Boolean onlyPesel = patient.getLastName().equals("") && patient.getName().equals("") && !patient.getPesel().equals("");
        Boolean onlyName = patient.getLastName().equals("") && !patient.getName().equals("") && patient.getPesel().equals("");

        Boolean peselAndName = patient.getLastName().equals("") && !patient.getName().equals("") && !patient.getPesel().equals("");
        Boolean peselAndLastName = !patient.getLastName().equals("") && patient.getName().equals("") && !patient.getPesel().equals("");
        Boolean NameAndLastName = !patient.getLastName().equals("") && !patient.getName().equals("") && patient.getPesel().equals("");

        Boolean peselAndNameAndLastName = !patient.getLastName().equals("") && !patient.getName().equals("") && !patient.getPesel().equals("");

        String patientLastName = patient.getLastName();
        String patientPesel = patient.getPesel();
        String patientName = patient.getName();

        if (onlyLastName) {
            searchResults = patientRepository.findByLastNameIgnoreCaseContainingAndAdmin(patientLastName, admin);
        } else if (onlyName) {
            searchResults = patientRepository.findByNameIgnoreCaseContainingAndAdmin(patientName, admin);
        } else if (onlyPesel) {
            searchResults = patientRepository.findByPeselIgnoreCaseContainingAndAdmin(patientPesel, admin);
        } else if (peselAndName) {
            searchResults = patientRepository.findByPeselIgnoreCaseContainingAndAdminAndNameIgnoreCaseContaining(patientPesel, admin, patientName);
        } else if (peselAndLastName) {
            searchResults = patientRepository.findByPeselIgnoreCaseContainingAndAdminAndLastNameIgnoreCaseContaining(patientPesel, admin, patientLastName);
        } else if (NameAndLastName) {
            searchResults = patientRepository.findByNameIgnoreCaseContainingAndAdminAndLastNameIgnoreCaseContaining(patientName, admin, patientLastName);
        } else if (peselAndNameAndLastName) {
            searchResults = patientRepository.findByNameIgnoreCaseContainingAndAdminAndPeselIgnoreCaseContainingAndLastNameIgnoreCaseContaining(patientName, admin, patientPesel, patientLastName);
        }

        session.setAttribute("searchResults", searchResults);
        return "redirect:/patient/search/result";
    }

}

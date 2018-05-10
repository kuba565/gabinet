package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Admin;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.AdminRepository;
import pl.kuba565.gabinet.Repository.PatientRepository;

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

        if (!patient.getLastName().equals("")) {
            searchResults = patientRepository.findByLastNameAndAdmin(patient.getLastName(), admin);
        }
        if (!patient.getName().equals("")) {
            searchResults = patientRepository.findByNameAndAdmin(patient.getName(), admin);
        }
        if (!patient.getPesel().equals("")) {
            searchResults = patientRepository.findByPeselAndAdmin(patient.getPesel(), admin);
        }
        session.setAttribute("searchResults", searchResults);
        return "redirect:/patient/search/result";
    }

}

package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

@Controller
@RequestMapping("/patient")
public class AddVisitController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/info/{id}/add-visit")
    public String visitForm(Model model, @PathVariable Long id) {
        Patient patient = patientRepository.getOne(id);
        model.addAttribute("patient", patient);

        return "form/add-visit";
    }

    @PostMapping("/info/{id}/add-visit")
    public String addVisit(@PathVariable Long id, HttpServletRequest request) {

        Patient patientToBeEdited = patientRepository.getOne(id);

        String nextVisitDateString = request.getParameter("nextVisitDateString");
        String nextVisitHourString = request.getParameter("nextVisitHourString");

        patientToBeEdited.setNextVisitDateString(nextVisitDateString);
        patientToBeEdited.setNextVisitHourString(nextVisitHourString);

        patientRepository.save(patientToBeEdited);
        return "redirect:/patient/info/{id}";
    }
}

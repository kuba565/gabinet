package pl.kuba565.gabinet.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.kuba565.gabinet.Model.Admin;
import pl.kuba565.gabinet.Model.Patient;
import pl.kuba565.gabinet.Repository.PatientRepository;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.Date;


@Controller
@RequestMapping("/patient")
public class EditPatientHistoryController {

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/info/edit-history/{id}")
    public String getPatient(Model model, @PathVariable Long id) {
        Patient patient = patientRepository.getOne(id);
        model.addAttribute("patient", patient);

        return "form/patient-history";
    }

    @PostMapping("/info/edit-history/{id}")
    String editPatient(@PathVariable Long id, HttpServletRequest request) {

        Patient patientToBeEdited = patientRepository.getOne(id);
        String medHist = (String) request.getParameter("medicalhistory");

        patientToBeEdited.setMedicalHistory(medHist);

        patientRepository.save(patientToBeEdited);
        return "redirect:/patient/list";
    }


}

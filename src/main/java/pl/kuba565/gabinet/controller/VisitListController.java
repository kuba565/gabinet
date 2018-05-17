package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Patient;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/visit")
public class VisitListController {
    @Autowired
    HttpSession session;

    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/list")
    public String getVisits(Model model) {
        String adminUsername = (String) session.getAttribute("adminUsername");
        List<Patient> patients = patientRepository.findAllByAdmin_LoginOrderByNextVisitDateStringAscNextVisitHourStringAsc(adminUsername);

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, -1);
        dt = c.getTime();
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        patients.removeIf(o -> o.getNextVisitDateString() == null);

        for (Iterator<Patient> it = patients.iterator(); it.hasNext(); ) {
            String userDateString = it.next().getNextVisitDateString();

            Date userDate = null;
            try {
                userDate = format.parse(userDateString);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            if (userDate.before(dt))
                it.remove();
        }


        model.addAttribute("visitsList", patients);
        return "visits";
    }

}

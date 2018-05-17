package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.repository.PatientRepository;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/patient")
public class SearchResultController {

    @Autowired
    HttpSession session;

    @Autowired
    private PatientRepository patientRepository;

    @RequestMapping("/search/result")
    public String tweetsList() {
        return "search-results";
    }


}


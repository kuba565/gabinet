package pl.kuba565.gabinet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class LogoutController {


    @Autowired
    private HttpSession session;

    @GetMapping("/logout")
    String loginForm() {
        session.invalidate();
        return "home";
    }


}

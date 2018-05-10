package pl.kuba565.gabinet.Controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.Model.Admin;
import pl.kuba565.gabinet.Repository.AdminRepository;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class LoginController {

    @Autowired
    private AdminRepository adminRepository;

    @Autowired
    private HttpSession session;

    @GetMapping("/login")
    String loginForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "form/login";
    }

    @PostMapping("/login")
    String login(@Valid Admin admin) {

        Admin checkAdmin = adminRepository.getAdminByLogin(admin.getLogin());

        if (BCrypt.checkpw(admin.getPassword(), checkAdmin.getPassword())) {

            session.invalidate();
            session.setAttribute("adminUsername", checkAdmin.getLogin());
            session.setAttribute("admin", checkAdmin);
            return "redirect:/";
        } else {
            return "form/login";
        }
    }
}

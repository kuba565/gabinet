package pl.kuba565.gabinet.controller;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kuba565.gabinet.model.Admin;
import pl.kuba565.gabinet.repository.AdminRepository;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin")
public class RegisterController {


    @Autowired
    private AdminRepository adminRepository;

    @GetMapping("/registration")
    String registrationForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "form/registration";
    }

    @PostMapping("/registration")
    String registration(@Valid Admin admin, BindingResult result) {

        if (result.hasErrors()) {
            return "form/registration";
        }
        Admin check = adminRepository.getAdminByLogin(admin.getLogin());

        if (check == null) {
            String hashed = BCrypt.hashpw(admin.getPassword(), BCrypt.gensalt());
            admin.setPassword(hashed);
            adminRepository.save(admin);
            return "redirect:/";
        }


        return "form/registration";
    }
}

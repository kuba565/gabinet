package pl.kuba565.gabinet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/visit")
public class VisitListController {

    @GetMapping("/list")
    public String getVisits() {
        return "visits";
    }
}

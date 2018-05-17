package pl.kuba565.gabinet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin getAdminByLogin(String login);



}

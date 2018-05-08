package pl.kuba565.gabinet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kuba565.gabinet.Model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin getAdminByLogin(String login);



}

package pl.kuba565.gabinet.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String birthDateString;

    private String nextVisitString;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date nextVisit;

    private String medicalHistory;


    public Patient() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Admin admin;

    public String getBirthDateString() {
        return birthDateString;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public void setBirthDateString(String birthDateString) {
        this.birthDateString = birthDateString;
    }

    public String getNextVisitString() {
        return nextVisitString;
    }

    public void setNextVisitString(String nextVisitString) {
        this.nextVisitString = nextVisitString;
    }


    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getNextVisit() {
        return nextVisit;
    }

    public void setNextVisit(Date nextVisit) {
        this.nextVisit = nextVisit;
    }
}

package pl.kuba565.gabinet.Model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String pesel;

    private String phoneNumber;

    private String address;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date birthDate;

    private String birthDateString;

    private String nextVisitDateString;

    private String nextVisitHourString;


    private String medicalHistory;


    public Patient() {
    }

    @ManyToOne(fetch = FetchType.EAGER)
    private Admin admin;

    public String getNextVisitDateString() {
        return nextVisitDateString;
    }

    public void setNextVisitDateString(String nextVisitDateString) {
        this.nextVisitDateString = nextVisitDateString;
    }

    public String getNextVisitHourString() {
        return nextVisitHourString;
    }

    public void setNextVisitHourString(String nextVisitHourString) {
        this.nextVisitHourString = nextVisitHourString;
    }

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

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package com.personal.javaresume.entities;

import com.personal.javaresume.utilities.annotations.UniqueDomain;
import com.personal.javaresume.utilities.annotations.UniqueEmail;
import com.personal.javaresume.utilities.annotations.UniquePhone;
import com.personal.javaresume.utilities.annotations.UniqueUsername;
import com.personal.javaresume.utilities.enums.Gender;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Personal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "Shobhit", defaultValue = "Shobhit", required = true)
    @Column(nullable = false, length = 25)
    @NotBlank(message = "Please enter first name")
    private String firstName;

    @Schema(example = "Raj", defaultValue = "Raj")
    @Column(length = 25)
    private String midName;

    @Schema(example = "Sharma", defaultValue = "Sharma", required = true)
    @Column(nullable = false, length = 25)
    @NotBlank(message = "Please enter last name")
    private String lastName;

    @Schema(example = "9041155693", defaultValue = "9041155693", required = true)
    @Column(nullable = false, unique = true, length = 10)
    @NotBlank(message = "Please enter phone number")
    @UniquePhone
    private String phone;

    @Schema(example = "Shobhit", defaultValue = "Shobhit", required = true)
    @Column( nullable = false, unique = true, length = 85)
    @Email(message = "Please enter valid email id")
    @NotBlank(message = "Please enter email id")
    @UniqueEmail
    private String email;

    @Schema(example = "shobhit90", defaultValue = "shobhit90", required = true)
    @Column(nullable = false, unique = true, length = 25)
    @NotBlank(message = "Please enter username, that should unique")
    @UniqueUsername
    private String username;

    @Schema(example = "MALE", defaultValue = "MALE", required = true)
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "ENUM('MALE', 'FEMALE', 'TRANSGENDER', 'OTHER') default 'MALE'", nullable = false)
    @NotNull(message = "Please choose your gender")
    private Gender gender;

    @Schema(example = "2005-05-06", defaultValue = "2005-05-06", required = true)
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    @NotNull(message = "Please enter your date of birth")
    private Date birthDate;

    @Schema(example = "www.example.com", defaultValue = "www.example.com")
    @Column(unique = true)
    @UniqueDomain
    private String website;

    @Schema(example = "123456", defaultValue = "123456", required = true)
    @Column(length = 1000)
    @NotBlank(message = "Please enter password")
    private String password;

    @Column(columnDefinition = "boolean default FALSE", nullable = false)
    private boolean isMasterUser;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @OneToMany(mappedBy = "personal", orphanRemoval = true)
    private List<Address> addresses;

    @OneToMany(mappedBy = "personal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Education> educations;

    @OneToMany(mappedBy = "personal", orphanRemoval = true)
    private List<Certification> certifications;

    @OneToMany(mappedBy = "personal", orphanRemoval = true)
    private List<Experience> experiences;

    @OneToMany(mappedBy = "personal", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRequest> userRequests;

    public List<UserRequest> getUserRequests() {
        return userRequests;
    }

    public void setUserRequests(List<UserRequest> userRequests) {
        this.userRequests = userRequests;
    }

    public List<Experience> getExperiences() {
        return experiences;
    }

    public void setExperiences(List<Experience> experiences) {
        this.experiences = experiences;
    }

    public List<Certification> getCertifications() {
        return certifications;
    }

    public void setCertifications(List<Certification> certifications) {
        this.certifications = certifications;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

package com.personal.javaresume.entities;

import com.personal.javaresume.utilities.enums.AddressType;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Schema(example = "TEMP", defaultValue = "TEMP", required = true)
    @Enumerated(value = EnumType.STRING)
    @Column(columnDefinition = "ENUM('TEMP', 'PERM', 'OTHER') default 'TEMP'", nullable = false)
    @NotNull(message = "Please choose your address type")
    private AddressType addressType;

    @Schema(example = "A1", defaultValue = "A1", required = true)
    @Column(nullable = false, length = 10)
    @NotBlank(message = "Please enter your house number")
    private String house;

    @Schema(example = "Jalandhar", defaultValue = "Jalandhar", required = true)
    @Column( nullable = false, length = 100)
    @NotBlank(message = "Please enter your city name")
    private String city;

    @Schema(example = "Punjab", defaultValue = "Punjab", required = true)
    @Column( nullable = false, length = 100)
    @NotBlank(message = "Please enter your state/province name")
    private String state;

    @Schema(example = "no-area", defaultValue = "no-area")
    @Column(length = 50)
    private String area;

    @Schema(example = "Mandir", defaultValue = "Mandir")
    @Column(length = 100, columnDefinition = "")
    private String landmark;

    @Schema(example = "India", defaultValue = "India", required = true)
    @Column(nullable = false, length = 100, columnDefinition = "VARCHAR(100) default 'India'")
    private String country;


    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false, insertable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdAt;

    @ManyToOne
    @JoinColumn()
    private Personal personal;

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

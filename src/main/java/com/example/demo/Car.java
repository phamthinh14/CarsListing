package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank
    @Size(min = 2, message = "Manufacture information should have more detail")
    private String manufacture;

    @NotBlank
    @Size(min = 2, message = "Model information should have more detail")
    private String model;

    @NotBlank
    @Size(min = 2, message = "Year information should have more detail")
    private String year;

    private String headShot;

    @ManyToOne(fetch = FetchType.EAGER)
    private Catergory catergory;

    public Car() {
    }

    public Car(@NotBlank @Size(min = 2, message = "Manufacture information should have more detail") String manufacture, @NotBlank @Size(min = 2, message = "Model information should have more detail") String model, @NotBlank @Size(min = 2, message = "Year information should have more detail") String year) {
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
    }

    public Car(@NotBlank @Size(min = 2, message = "Manufacture information should have more detail") String manufacture, @NotBlank @Size(min = 2, message = "Model information should have more detail") String model, @NotBlank @Size(min = 2, message = "Year information should have more detail") String year, String headShot) {
        this.manufacture = manufacture;
        this.model = model;
        this.year = year;
        this.headShot = headShot;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Catergory getCatergory() {
        return catergory;
    }

    public void setCatergory(Catergory catergory) {
        this.catergory = catergory;
    }

    public String getHeadShot() {
        return headShot;
    }

    public void setHeadShot(String headShot) {
        this.headShot = headShot;
    }
}


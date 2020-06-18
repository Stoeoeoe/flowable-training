package com.flowable.training.dp.dataobject;


import javax.persistence.*;

/**
 * Simple Entity/POJO that maps to the Address data object.
 * Here, we use the default mappings.
 * You could map your columns with @Column.
 */
@Entity(name = "ADDRESS")
public class Address {

    public static final String DATA_OBJECT_KEY = "DEMO-DOB1";
    public static final String FIELD_TITLE = "title";
    public static final String FIELD_NAME = "name";
    public static final String FIELD_STREET = "street";
    public static final String FIELD_CITY = "city";
    public static final String FIELD_ZIP_CODE = "zipCode";
    public static final String FIELD_COUNTRY = "country";

    @javax.persistence.Id
    private String id;

    private String title;
    private String name;
    private String street;
    private String city;
    private String zipCode;
    private String country;


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getZipCode() { return zipCode; }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
}

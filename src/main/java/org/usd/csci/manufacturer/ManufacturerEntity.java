/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.usd.csci.manufacturer;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * This class has the following set of features:
 * 1. Enforces the following validation rules:
 *  - Manufacture Id should be a Primary Key and an integer
 *  - Manufacturer Name should have a size of 30 characters and must begin with an upper case letter and only contain letters and a space
 *  - City must have a maximum size of 25 characters
 *  - Address line 1 must have a maximum size of 30 characters
 *  - Address line 2 must have a maximum size of 30 characters
 *  - State must only contain two upper case characters
 *  - Zipcode must only contain five digits
 *  - Phone and Fax should have a format of xxx-xxx-xxxx
 * 2. Implements Comparable<ManufacuturerEntity> interface
 * 3. Overrides the default equals, hashCode, and toString methods in order to compare the manufactures with their names. 
 * 
 * 
 * 
 * @author Joseph Mammo
 */
@Entity
@Table(name = "MANUFACTURER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ManufacturerEntity.findAll", query = "SELECT m FROM ManufacturerEntity m"),
    @NamedQuery(name = "ManufacturerEntity.findByManufacturerId", query = "SELECT m FROM ManufacturerEntity m WHERE m.manufacturerId = :manufacturerId"),
    @NamedQuery(name = "ManufacturerEntity.findByName", query = "SELECT m FROM ManufacturerEntity m WHERE m.name = :name"),
    @NamedQuery(name = "ManufacturerEntity.findByAddressline1", query = "SELECT m FROM ManufacturerEntity m WHERE m.addressline1 = :addressline1"),
    @NamedQuery(name = "ManufacturerEntity.findByAddressline2", query = "SELECT m FROM ManufacturerEntity m WHERE m.addressline2 = :addressline2"),
    @NamedQuery(name = "ManufacturerEntity.findByCity", query = "SELECT m FROM ManufacturerEntity m WHERE m.city = :city"),
    @NamedQuery(name = "ManufacturerEntity.findByState", query = "SELECT m FROM ManufacturerEntity m WHERE m.state = :state"),
    @NamedQuery(name = "ManufacturerEntity.findByZip", query = "SELECT m FROM ManufacturerEntity m WHERE m.zip = :zip"),
    @NamedQuery(name = "ManufacturerEntity.findByPhone", query = "SELECT m FROM ManufacturerEntity m WHERE m.phone = :phone"),
    @NamedQuery(name = "ManufacturerEntity.findByFax", query = "SELECT m FROM ManufacturerEntity m WHERE m.fax = :fax"),
    @NamedQuery(name = "ManufacturerEntity.findByEmail", query = "SELECT m FROM ManufacturerEntity m WHERE m.email = :email"),
    @NamedQuery(name = "ManufacturerEntity.findByRep", query = "SELECT m FROM ManufacturerEntity m WHERE m.rep = :rep")})
public class ManufacturerEntity implements Serializable, Comparable<ManufacturerEntity> {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull(message= "Manucafurer ID required!")
    @Column(name = "MANUFACTURER_ID")
    private Integer manufacturerId;
    @Pattern(regexp = "\\b[A-Z].*?\\b| |\\b[a-z].*?\\b", message = "Must begin with upper case character [A-Z]. Contain only characters A-Z,a-z and space. ")//Must begin with upper case character [A-Z]. Contain only characters A-Z,a-z and space. Here is my code: http://rubular.com/r/krtxYFCLdT
    @NotNull(message= "Name is required!")
    @Size(max = 30)
    @Column(name = "NAME")
    private String name;
    @NotNull(message= "ADDRESSLINE1 is required!")
    @Size(max = 30)
    @Column(name = "ADDRESSLINE1")
    private String addressline1;
    @NotNull(message= "ADDRESSLINE2 is required!")
    @Size(max = 30)
    @Column(name = "ADDRESSLINE2")
    private String addressline2;
    @NotNull(message= "City is required!")
    @Size(max = 25)
    @Column(name = "CITY")
    private String city;
    @Pattern(regexp = "(([A-Z]+[A-Z]){1})", message = "Invalid State. Must be two upper case characters")//Must only contain two upper case letters
    @NotNull(message= "State is required!")
    @Size(max = 2)
    @Column(name = "STATE")
    private String state;
    @Pattern(regexp = "^\\d{5}", message = "Must be 5 digits")//Must only contain five integers
    @NotNull(message= "Zipcode is required!")
    @Size(max = 10)
    @Column(name = "ZIP")
    private String zip;
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @NotNull(message= "Phone number is required!")
    @Size(max = 12)
    @Column(name = "PHONE")
    private String phone;
    @Pattern(regexp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message = "Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @NotNull(message= "Fax number is required!")
    @Size(max = 12)
    @Column(name = "FAX")
    private String fax;
    @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @NotNull(message= "Email is required!")
    @Size(max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 30)
    @Column(name = "REP")
    private String rep;


    
    
    /**
     *
     */
    public ManufacturerEntity() {
    }

    /**
     *
     * @param manufacturerId
     */
    public ManufacturerEntity(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    /**
     *
     * @return
     */
    public Integer getManufacturerId() {
        return manufacturerId;
    }

    /**
     *
     * @param manufacturerId
     */
    public void setManufacturerId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }
    

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public String getAddressline1() {
        return addressline1;
    }

    /**
     *
     * @param addressline1
     */
    public void setAddressline1(String addressline1) {
        this.addressline1 = addressline1;
    }

    /**
     *
     * @return
     */
    public String getAddressline2() {
        return addressline2;
    }

    /**
     *
     * @param addressline2
     */
    public void setAddressline2(String addressline2) {
        this.addressline2 = addressline2;
    }

    /**
     *
     * @return
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     */
    public String getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getZip() {
        return zip;
    }

    /**
     *
     * @param zip
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     *
     * @return
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     */
    public String getFax() {
        return fax;
    }

    /**
     *
     * @param fax
     */
    public void setFax(String fax) {
        this.fax = fax;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public String getRep() {
        return rep;
    }

    /**
     *
     * @param rep
     */
    public void setRep(String rep) {
        this.rep = rep;
    }

    /**
     * Overrides the default compareTo method. Checks if the Manufacturers are
     * equal by checking if their names are equal
     *
     * @param other
     * @return
     */
    @Override
    public int compareTo(ManufacturerEntity other) {
        return this.name.compareTo(other.getName());
    }

    /**
     * Overrides the default hashCode method and checks if the Manufacturers are
     * equal by checking if their names are equal.
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    /**
     * Overrides the default equals method and checks if the Manufacturers are
     * equal by checking if their names are equal.
     *
     * @param object
     * @return
     */
    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ManufacturerEntity)) {
            return false;
        }
        ManufacturerEntity other = (ManufacturerEntity) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    /**
     * Overrides the default toString method and returns the name of the
     * Manufacturer
     *
     * @return
     */
    @Override
    public String toString() {
        return this.name;
    }

}

package com.kaba.planner.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Employee entity class
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
@Entity
@Table(name = "employee")
@XmlRootElement
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;

    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;

    @Lob
    @Column(name = "address")
    private String address;

    @Column(name = "zip_code")
    private String zipCode;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "country")
    private String country;

    @Column(name = "phone")
    private String phone;

    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;

    @Basic(optional = false)
    @Column(name = "contract_start_date")
    @Temporal(TemporalType.DATE)
    private Date contractStartDate;

    @Column(name = "contract_end_date")
    @Temporal(TemporalType.DATE)
    private Date contractEndDate;

    @Basic(optional = false)
    @Column(name = "contract_type")
    private String contractType;

    @Basic(optional = false)
    @Column(name = "id_type")
    private String idType;

    @Column(name = "id_start_date")
    @Temporal(TemporalType.DATE)
    private Date idStartDate;

    @Column(name = "id_end_date")
    @Temporal(TemporalType.DATE)
    private Date idEndDate;

    @Basic(optional = false)
    @Column(name = "citizenship")
    private String citizenship;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employee", fetch = FetchType.LAZY)
    private Collection<Schedule> scheduleCollection;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "employeeCollection", fetch = FetchType.LAZY)
    private Collection<City> cityCollection;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String firstName, String lastName, Date contractStartDate, String contractType, String idType, String citizenship) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contractStartDate = contractStartDate;
        this.contractType = contractType;
        this.idType = idType;
        this.citizenship = citizenship;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Date getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(Date contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public Date getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(Date contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public String getContractType() {
        return contractType;
    }

    public void setContractType(String contractType) {
        this.contractType = contractType;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public Date getIdStartDate() {
        return idStartDate;
    }

    public void setIdStartDate(Date idStartDate) {
        this.idStartDate = idStartDate;
    }

    public Date getIdEndDate() {
        return idEndDate;
    }

    public void setIdEndDate(Date idEndDate) {
        this.idEndDate = idEndDate;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @XmlTransient
    public Collection<Schedule> getScheduleCollection() {
        return scheduleCollection;
    }

    public void setScheduleCollection(Collection<Schedule> scheduleCollection) {
        this.scheduleCollection = scheduleCollection;
    }

    @XmlTransient
    public Collection<City> getCityCollection() {
        return cityCollection;
    }

    public void setCityCollection(Collection<City> cityCollection) {
        this.cityCollection = cityCollection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Employee)) {
            return false;
        }
        
        Employee other = (Employee) object;
        
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kaba.planner.entity.Employee[ id=" + id + " ]";
    }

}

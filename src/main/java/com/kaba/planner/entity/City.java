package com.kaba.planner.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * City entity
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
@Entity
@Table(name = "city")
@XmlRootElement
public class City implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    @Basic(optional = false)
    @Column(name = "country")
    private String country;

    @JoinTable(name = "city_has_employee",
            joinColumns = {
                @JoinColumn(name = "city_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "employee_id", referencedColumnName = "id")
            })
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Collection<Employee> employeeCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "city", fetch = FetchType.LAZY)
    private Collection<Workplace> workplaceCollection;

    public City() {
    }

    public City(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Collection<Employee> getEmployeeCollection() {
        return employeeCollection;
    }

    public void setEmployeeCollection(Collection<Employee> employeeCollection) {
        this.employeeCollection = employeeCollection;
    }

    @XmlTransient
    public Collection<Workplace> getWorkplaceCollection() {
        return workplaceCollection;
    }

    public void setWorkplaceCollection(Collection<Workplace> workplaceCollection) {
        this.workplaceCollection = workplaceCollection;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof City)) {
            return false;
        }

        City other = (City) object;
        
        if (!Objects.equals(id, other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return String.format("City[ id = %d, Name = %s , Country = %s ]\n", id, name, country);
    }

}

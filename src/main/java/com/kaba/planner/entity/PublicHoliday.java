/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaba.planner.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * PublicHoliday entity class
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
@Entity
@Table(name = "public_holiday")
@XmlRootElement
public class PublicHoliday implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;

    @Basic(optional = false)
    @Column(name = "day")
    @Temporal(TemporalType.DATE)
    private Date day;

    @Lob
    @Column(name = "description")
    private String description;

    public PublicHoliday() {
    }

    public PublicHoliday(Integer id) {
        this.id = id;
    }

    public PublicHoliday(Integer id, Date day) {
        this.id = id;
        this.day = day;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof PublicHoliday)) {
            return false;
        }
        PublicHoliday other = (PublicHoliday) object;

        if (!Objects.equals(id, other.id)) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "com.kaba.planner.entity.PublicHoliday[ id=" + id + " ]";
    }

}

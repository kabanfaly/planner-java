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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Schedule entity class
 *
 * @author Kaba N'faly
 * @since 12/02/2016
 * @version 2.0
 */
@Entity
@Table(name = "schedule")
@XmlRootElement
public class Schedule implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    
    private Integer id;
    @Basic(optional = false)
    @Column(name = "start_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    
    @Basic(optional = false)
    @Column(name = "end_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    
    @Column(name = "break_time")
    @Temporal(TemporalType.TIME)
    private Date breakTime;
    
    @Column(name = "day_hours")
    @Temporal(TemporalType.TIME)
    private Date dayHours;
    
    @Column(name = "night_hours")
    @Temporal(TemporalType.TIME)
    private Date nightHours;
    
    @Column(name = "sunday_day_hours")
    @Temporal(TemporalType.TIME)
    private Date sundayDayHours;
    
    @Column(name = "sunday_night_hours")
    @Temporal(TemporalType.TIME)
    private Date sundayNightHours;
    
    @Column(name = "public_holiday_day_hours")
    @Temporal(TemporalType.TIME)
    private Date publicHolidayDayHours;
    
    @Column(name = "public_holiday_night_hours")
    @Temporal(TemporalType.TIME)
    private Date publicHolidayNightHours;
    
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    @ManyToOne(optional = false)    
    private Employee employee;
    
    @JoinColumn(name = "workplace_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Workplace workplace;

    public Schedule() {
    }

    public Schedule(Integer id) {
        this.id = id;
    }

    public Schedule(Integer id, Date startTime, Date endTime) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getBreakTime() {
        return breakTime;
    }

    public void setBreakTime(Date breakTime) {
        this.breakTime = breakTime;
    }

    public Date getDayHours() {
        return dayHours;
    }

    public void setDayHours(Date dayHours) {
        this.dayHours = dayHours;
    }

    public Date getNightHours() {
        return nightHours;
    }

    public void setNightHours(Date nightHours) {
        this.nightHours = nightHours;
    }

    public Date getSundayDayHours() {
        return sundayDayHours;
    }

    public void setSundayDayHours(Date sundayDayHours) {
        this.sundayDayHours = sundayDayHours;
    }

    public Date getSundayNightHours() {
        return sundayNightHours;
    }

    public void setSundayNightHours(Date sundayNightHours) {
        this.sundayNightHours = sundayNightHours;
    }

    public Date getPublicHolidayDayHours() {
        return publicHolidayDayHours;
    }

    public void setPublicHolidayDayHours(Date publicHolidayDayHours) {
        this.publicHolidayDayHours = publicHolidayDayHours;
    }

    public Date getPublicHolidayNightHours() {
        return publicHolidayNightHours;
    }

    public void setPublicHolidayNightHours(Date publicHolidayNightHours) {
        this.publicHolidayNightHours = publicHolidayNightHours;
    }

    public Employee getEmployeeId() {
        return employee;
    }

    public void setEmployeeId(Employee employeeId) {
        this.employee = employeeId;
    }

    public Workplace getWorkplaceId() {
        return workplace;
    }

    public void setWorkplaceId(Workplace workplaceId) {
        this.workplace = workplaceId;
    }

    @Override
    public int hashCode() {
       return Objects.hash(id);
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Schedule)) {
            return false;
        }
        
        Schedule other = (Schedule) object;
        
        if (!Objects.equals(id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.kaba.planner.entity.Schedule[ id=" + id + " ]";
    }
    
}

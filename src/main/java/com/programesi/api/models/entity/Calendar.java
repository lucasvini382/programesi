package com.programesi.api.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pgs_cal_calendar")
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cal_id")
    private Long id;

    @Column(name = "cal_date")
    private LocalDate date;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "cal_time_work_id", referencedColumnName = "tiw_id")
    private Timework timework;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Timework getTimework() {
        return timework;
    }

    public void setTimework(Timework timework) {
        this.timework = timework;
    }
}

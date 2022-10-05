package com.programesi.api.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "pgs_tiw_time_work")
public class Timework {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tiw_id")
    private Long id;

    @Column(name = "tiw_entry_hour")
    private String entryHour;

    @Column(name = "tiw_exit_hour")
    private String exitHour;

    @Column(name = "tiw_description")
    private String description;

    @Column(name = "tiw_initials")
    private String initials;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tiw_user_id", referencedColumnName = "usr_id")
    private User user;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "cal_time_work_id")
    private List<Calendar> calendars;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEntryHour() {
        return entryHour;
    }

    public void setEntryHour(String entryHour) {
        this.entryHour = entryHour;
    }

    public String getExitHour() {
        return exitHour;
    }

    public void setExitHour(String exitHour) {
        this.exitHour = exitHour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public void setCalendars(List<Calendar> calendars) {
        this.calendars = calendars;
    }
}

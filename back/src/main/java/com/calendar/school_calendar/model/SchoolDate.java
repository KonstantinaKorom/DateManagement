package com.calendar.school_calendar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "schooldate")
public class SchoolDate {

    @Id
    @Column(name = "date")
    private Date date;

    @NonNull
    @ManyToOne
    @JoinColumn(name = "holiday")
    private Status status ;
}

package com.calendar.school_calendar.repository;

import com.calendar.school_calendar.model.SchoolDate;
import com.calendar.school_calendar.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface SchoolDateRepo extends JpaRepository<SchoolDate, Date> {

    SchoolDate findSchoolDateByDate(Date date);


    List<SchoolDate> findSchoolDateByStatus(Status status);
}

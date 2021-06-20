package com.calendar.school_calendar.service;

import com.calendar.school_calendar.model.SchoolDate;
import com.calendar.school_calendar.model.Status;
import com.calendar.school_calendar.repository.SchoolDateRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Year;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@AllArgsConstructor
@Service
public class SchoolDateService {

    private final SchoolDateRepo schoolDateRepo;

    public void saveSchoolDate(SchoolDate schoolDate) {
        schoolDateRepo.save(schoolDate);
    }


    public List<SchoolDate> getAllSchoolDates() {
        return schoolDateRepo.findAll();
    }

    public SchoolDate getSchoolDateByDate(Date date) {
        return schoolDateRepo.findSchoolDateByDate(date);
    }


    public List<SchoolDate> getAllHolidays() {
        Status status = new Status("holiday");
        return schoolDateRepo.findSchoolDateByStatus(status);
    }

    public void saveHoliday(SchoolDate schoolDate) {
        schoolDateRepo.save(schoolDate);
    }

}

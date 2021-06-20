package com.calendar.school_calendar.controller;

import com.calendar.school_calendar.model.SchoolDate;
import com.calendar.school_calendar.model.Status;
import com.calendar.school_calendar.repository.SchoolDateRepo;
import com.calendar.school_calendar.service.SchoolDateService;
import com.calendar.school_calendar.service.StatusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping(value = "api/dates")
public class SchoolDateController {

    private final SchoolDateService schoolDateService;
    private final SchoolDateRepo schoolDateRepo;
    private final StatusService statusService;

    @GetMapping
    public List<SchoolDate> getAllSavedDates() {
        return schoolDateService.getAllSchoolDates();
    }

    @GetMapping(value = "/holidays")
    public List<SchoolDate> getHolidays() {
        return schoolDateService.getAllHolidays();
    }

    @PostMapping(value = "/holidays/new")
    public ResponseEntity<SchoolDate> saveNewHoliday(@RequestBody SchoolDate schoolDate) {
        if (schoolDateRepo.existsById(schoolDate.getDate()) == true) {
            return new ResponseEntity(schoolDate, HttpStatus.CONFLICT);
        }
        schoolDateService.saveHoliday(schoolDate);
        return new ResponseEntity(schoolDate, HttpStatus.OK);
    }

//  primary key is "date", status only can change
    @PutMapping("/holidays/update/{date}")
    public ResponseEntity<SchoolDate> updateSchoolDate(@RequestBody SchoolDate schoolDate, @PathVariable(value = "date") Date date){
        SchoolDate schoolDateToUpdate = schoolDateRepo.findById(date).get();
        schoolDateToUpdate.setStatus(schoolDate.getStatus());
        schoolDateRepo.save(schoolDateToUpdate);
        return ResponseEntity.ok(schoolDateToUpdate);
    }

    @DeleteMapping(value = "/holidays/{date}")
    public ResponseEntity<String> deleteSchoolDate(@PathVariable(value = "date") Date date) {
        SchoolDate schoolDateToDelete = schoolDateRepo.findById(date).get();
        schoolDateRepo.delete(schoolDateToDelete);
        String message = "Date: " + date + " successfully deleted!";
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }


// For future usage. If status !== "holiday"
//    @GetMapping(value = "/{status}")
//    public List<SchoolDate> getSchoolDatesByStatus(Status status){
//       return schoolDateService.getSchoolDatesByStatus(status);
//    }

}

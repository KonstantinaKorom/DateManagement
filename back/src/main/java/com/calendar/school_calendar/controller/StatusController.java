package com.calendar.school_calendar.controller;

import com.calendar.school_calendar.model.Status;
import com.calendar.school_calendar.service.StatusService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@AllArgsConstructor
@RestController
@RequestMapping(value = "api/status")
public class StatusController {

    private final StatusService statusService;

    @GetMapping
    public List<Status> getAllStatus() {
        return statusService.getAllStatus();
    }

}

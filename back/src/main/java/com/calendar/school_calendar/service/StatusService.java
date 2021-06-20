package com.calendar.school_calendar.service;

import com.calendar.school_calendar.model.Status;
import com.calendar.school_calendar.repository.StatusRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class StatusService {

    private final StatusRepo statusRepo;

    public List<Status> getAllStatus() {
        return statusRepo.findAll();
    }

    public Status getHolidayStatus() {
        return statusRepo.getOne("holiday");
    }


}

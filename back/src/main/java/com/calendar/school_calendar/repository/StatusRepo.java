package com.calendar.school_calendar.repository;

import com.calendar.school_calendar.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepo extends JpaRepository<Status, String> {
}

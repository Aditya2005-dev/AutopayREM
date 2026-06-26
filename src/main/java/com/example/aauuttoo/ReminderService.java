package com.example.aauuttoo;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReminderService {

    @Autowired
    private Datarepo repo;

    // Save data
    public Model add(Model model) {
        return repo.save(model);
    }

    // Remaining seconds
    public long getRemainingSeconds(Model model) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime due = model.getDueDateTime();

        return Duration.between(now, due).getSeconds();
    }

    // Remaining days
    public long getRemainingDays(Model model) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime due = model.getDueDateTime();

        return Duration.between(now, due).toDays();
    }

    // Check if expired
    public boolean isExpired(Model model) {

        return LocalDateTime.now().isAfter(model.getDueDateTime());
    }
}
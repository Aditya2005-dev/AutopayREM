package com.example.aauuttoo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Controller {

    @Autowired
    private ReminderService service;

    @PostMapping("/set")
    public Model addReminder(@RequestBody Model model) {

        return service.add(model);

    }
}
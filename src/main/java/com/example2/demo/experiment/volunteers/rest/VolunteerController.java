package com.example2.demo.experiment.volunteers.rest;

import com.example2.demo.experiment.volunteers.service.VolunteerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VolunteerController {

    @Autowired
    private VolunteerService volunteerService;

    @PostMapping("/volunteer")
    public void createVolunteer(@RequestBody Volunteer volunteer) {
        volunteerService.createVolunteer(volunteer);
    }

    @GetMapping("/volunteers")
    public List<Volunteer> getVolunteers() {
        return volunteerService.getVolunteers();
    }

    @PutMapping("/add-experiment/{idVolunteer}/{idExperiment}")
    public void addExperiment(@PathVariable Integer idVolunteer, @PathVariable Integer idExperiment) {
        volunteerService.addExperiment(idVolunteer, idExperiment);
    }

    @DeleteMapping("/delete-volunteer")
    public void deleteVolunteer(@RequestParam Integer id) {
        volunteerService.deleteVolunteer(id);
    }

}

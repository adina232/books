package com.example2.demo.experiment.experiments.rest;

import com.example2.demo.experiment.experiments.service.ExperimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExperimentController {

    @Autowired
    private ExperimentService experimentService;

    @PostMapping("/experiment")
    public void createExperiment(@RequestBody Experiment experiment) {
        experimentService.createExperiment(experiment);
    }

    @GetMapping("/experiments")
    public List<Experiment> getExperiments() {
        return experimentService.getExperiments();
    }

    @DeleteMapping("/delete-experiment")
    public void deleteExperiment(@RequestParam(value = "id") Integer id) {
        experimentService.deleteExperiment(id);
    }

}

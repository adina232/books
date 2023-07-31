package com.example2.demo.experiment.experiments.service;

import com.example2.demo.experiment.experiments.repository.ExperimentEntity;
import com.example2.demo.experiment.experiments.repository.ExperimentRepository;
import com.example2.demo.experiment.experiments.rest.Experiment;
import com.example2.demo.experiment.volunteers.repository.VolunteerEntity;
import com.example2.demo.experiment.volunteers.repository.VolunteerRepository;
import com.example2.demo.experiment.volunteers.rest.Volunteer;
import com.example2.demo.university.student.repository.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExperimentService {

    @Autowired
    private ExperimentRepository experimentRepository;
    @Autowired
    private VolunteerRepository volunteerRepository;

    public void createExperiment(Experiment experiment) {

        ExperimentEntity experimentEntity = new ExperimentEntity();

        experimentEntity.setId(experiment.getId());
        experimentEntity.setName(experiment.getName());

        experimentRepository.save(experimentEntity);
    }


    public List<Experiment> getExperiments() {

        List<ExperimentEntity> experimentEntityList =
                (List<ExperimentEntity>) experimentRepository.findAll();
        List<Experiment> experimentList = new ArrayList<>();
        for (ExperimentEntity experimentEntity : experimentEntityList) {
            Experiment experiment = new Experiment();
            experiment.setId(experimentEntity.getId());
            experiment.setName(experimentEntity.getName());

            List<VolunteerEntity> volunteerEntityList = experimentEntity.getVolunteerEntityList();
            List<Volunteer> volunteerList = new ArrayList<>();
            for (VolunteerEntity volunteerEntity : volunteerEntityList) {
                Volunteer volunteer = new Volunteer();
                volunteer.setId(volunteerEntity.getId());
                volunteer.setName(volunteerEntity.getName());

                volunteerList.add(volunteer);
            }

            experiment.setVolunteerList(volunteerList);
            experimentList.add(experiment);
        }
        return experimentList;
    }

    public void deleteExperiment(Integer idExperiment) {
        Optional<ExperimentEntity> experimentEntity = experimentRepository.findById(idExperiment);
        if (experimentEntity.isPresent()) {

            List<VolunteerEntity> volunteerEntityList = experimentEntity.get().getVolunteerEntityList();
            for (VolunteerEntity volunteerEntity : volunteerEntityList) {
                volunteerEntity.getExperimentEntityList().remove(experimentEntity.get());

                volunteerRepository.save(volunteerEntity);
            }

            experimentRepository.deleteById(idExperiment);
        }


    }
}

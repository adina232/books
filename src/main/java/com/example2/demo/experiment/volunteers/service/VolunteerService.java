package com.example2.demo.experiment.volunteers.service;

import com.example2.demo.experiment.experiments.repository.ExperimentEntity;
import com.example2.demo.experiment.experiments.repository.ExperimentRepository;
import com.example2.demo.experiment.experiments.rest.Experiment;
import com.example2.demo.experiment.volunteers.repository.VolunteerEntity;
import com.example2.demo.experiment.volunteers.repository.VolunteerRepository;
import com.example2.demo.experiment.volunteers.rest.Volunteer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VolunteerService {

    @Autowired
    private VolunteerRepository volunteerRepository;
    @Autowired
    private ExperimentRepository experimentRepository;


    public void createVolunteer(Volunteer volunteer) {
        VolunteerEntity volunteerEntity = new VolunteerEntity();
        volunteerEntity.setId(volunteer.getId());
        volunteerEntity.setName(volunteer.getName());

        volunteerRepository.save(volunteerEntity);
    }


    public List<Volunteer> getVolunteers() {
        List<VolunteerEntity> volunteerEntityList = (List<VolunteerEntity>)
                volunteerRepository.findAll();
        List<Volunteer> volunteerList = new ArrayList<>();
        for (VolunteerEntity volunteerEntity : volunteerEntityList) {
            Volunteer volunteer = new Volunteer();
            volunteer.setId(volunteerEntity.getId());
            volunteer.setName(volunteerEntity.getName());


            List<ExperimentEntity> experimentEntityList = volunteerEntity.getExperimentEntityList();
            List<Experiment> experimentList = new ArrayList<>();
            for (ExperimentEntity experimentEntity : experimentEntityList) {
                Experiment experiment = new Experiment();
                experiment.setId(experimentEntity.getId());
                experiment.setName(experimentEntity.getName());

                experimentList.add(experiment);
            }
            volunteer.setExperimentList(experimentList);


            volunteerList.add(volunteer);
        }
        return volunteerList;
    }

    public void addExperiment(Integer idVolunteer, Integer idExperiment) {
        Optional<VolunteerEntity> volunteerEntity = volunteerRepository.findById(idVolunteer);
        if (volunteerEntity.isPresent()) {
            Optional<ExperimentEntity> experimentEntity = experimentRepository.findById(idExperiment);
            if (experimentEntity.isPresent()) {


                experimentEntity.get().getVolunteerEntityList().add(volunteerEntity.get());

                experimentRepository.save(experimentEntity.get());


            } else throw new RuntimeException("Experiment not on the list");

        } else throw new RuntimeException("Volunteer not on the list");
    }

    public void deleteVolunteer(Integer idVolunteer) {
        Optional<VolunteerEntity> volunteerEntity = volunteerRepository.findById(idVolunteer);
        if (volunteerEntity.isPresent()) {
            List<ExperimentEntity> experimentEntityList =
                    (List<ExperimentEntity>) experimentRepository.findAll();

            for (ExperimentEntity experimentEntity : experimentEntityList) {
                experimentEntity.getVolunteerEntityList().remove(volunteerEntity.get());
                experimentRepository.save(experimentEntity);
            }



            volunteerRepository.deleteById(idVolunteer);
        }
    }
}

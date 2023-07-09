package com.example.subjects;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
@Component
@Scope("singleton")
public class SubjectsDatabase {
    private List <Subjects> subjectsList = new ArrayList<>();

    public List<Subjects> getSubjectsList() {

        return subjectsList;
    }

    public List<Subjects> getSubjectsList(Integer  ects, String name, Integer sala, Boolean egzamin) {
        if (ects == null && name == null && sala == null && egzamin == null) {
            return subjectsList;
        } else if (ects == null && name == null && sala == null) {
            List<Subjects> filteredEgzaminSubjects = new ArrayList<>();
            for (Subjects subject : subjectsList) {
                if (subject.getEgzamin().equals(egzamin)) {
                    filteredEgzaminSubjects.add(subject);
                }
            }
            return filteredEgzaminSubjects;
        } else if (ects == null && name == null && egzamin == null) {
            List<Subjects> filteredSalaSubjects = new ArrayList<>();
            for (Subjects subject : subjectsList) {
                if (subject.getSala().equals(sala)) {
                    filteredSalaSubjects.add(subject);
                }
            }
            return filteredSalaSubjects;
        } else if (ects == null && sala == null && egzamin == null) {
            List<Subjects> filteredNameSubjects = new ArrayList<>();
            for (Subjects subject : subjectsList) {
                if (subject.getName().equals(name)) {
                    filteredNameSubjects.add(subject);
                }
            }
            return filteredNameSubjects;
        } else if (name == null && sala == null && egzamin == null) {
            List<Subjects> filteredEctsSubjects = new ArrayList<>();
            for (Subjects subject : subjectsList) {
                if (subject.getEcts().equals(ects)) {
                    filteredEctsSubjects.add(subject);
                }
            }
            return filteredEctsSubjects;
        } else if (name == null && ects == null) {
        List<Subjects> filteredSalaEgzaminSubjects = new ArrayList<>();
        for (Subjects subject : subjectsList) {
            if (subject.getSala().equals(sala) && subject.getEgzamin().equals(egzamin)) {
                filteredSalaEgzaminSubjects.add(subject);
            }
        }
            return filteredSalaEgzaminSubjects;
        }
        else {
            List<Subjects> filteredAllSubjects = new ArrayList<>();
            for (Subjects subject : subjectsList) {
                if (subject.getEgzamin().equals(egzamin) && subject.getName().equals(name) && subject.getEcts().equals(ects) && subject.getSala().equals(sala)) {
                    filteredAllSubjects.add(subject);
                }
            }
            return filteredAllSubjects;
        }
    }
    private Integer SubjectsIndex = 1;

    public void addSubjects(Subjects element) {
        element.setId(SubjectsIndex);
        subjectsList.add(element);
        SubjectsIndex ++;
    }

    public void deleteAll() {
        subjectsList.clear();
    }

    public boolean deleteById(Integer id) {
        Subjects subjectToDelete = null;
        for (Subjects element : subjectsList) {
            if (element.getId().equals(id)) {
                subjectToDelete = element;
            }
        }
        if (subjectToDelete == null) {
            return false;
        }
        subjectsList.remove(subjectToDelete);
        return true;
    }

    public Subjects getSubjectById(Integer id) {
        for (Subjects element : subjectsList) {
            if (element.getId().equals(id)) {
                return element;
            }
        }
        return null;
    }
}

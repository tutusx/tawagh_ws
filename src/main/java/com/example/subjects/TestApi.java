package com.example.subjects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("api")
public class TestApi {

    @Autowired
    private SubjectsDatabase subjectsDatabase;

    @PostMapping(value = "subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public void addSubject(@RequestBody Subjects element) {
        subjectsDatabase.addSubjects(element);
    }

    @GetMapping(value = "subjects",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Subjects> getSubjectsList(@Nullable @RequestParam("ects") Integer ects, @Nullable @RequestParam("sala") Integer sala,
                                          @Nullable @RequestParam("egzamin") Boolean egzamin, @Nullable @RequestParam("name") String name) {
        return subjectsDatabase.getSubjectsList(ects, name, sala, egzamin);
    }
    @DeleteMapping(value = "subjects")
    public void deleteAll(){
        subjectsDatabase.deleteAll();
    }

    @DeleteMapping(value = "subjects/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id){
        if (subjectsDatabase.deleteById(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping(value = "subjects/{id}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getSubjectsById(@PathVariable("id") Integer id) {
       Subjects element =  subjectsDatabase.getSubjectById(id);
        if  (element == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(element);
    }
}

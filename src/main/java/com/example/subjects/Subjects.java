package com.example.subjects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

@JsonSerialize
@Data
public class Subjects {
    @JsonProperty("id")
    private Integer id;

    @JsonProperty("nazwa")
    private String name;

    @JsonProperty("ects")
    public Integer  ects;

    @JsonProperty("sala")
    public Integer sala;

    @JsonProperty("egzamin")
    public Boolean egzamin;
}

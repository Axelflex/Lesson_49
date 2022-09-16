package com.example.lesson49.model;

import com.fasterxml.jackson.annotation.JsonTypeId;
import lombok.Data;

@Data
public class Candidate {
    private Integer id;
    private String name;
    private String photo;
    private int votes;
    private int allVotes;
    private double percentVotes;

    public void getVoted(Candidate candidate){
        candidate.setVotes(candidate.getVotes() + 1);
    }
}

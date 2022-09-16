package com.example.lesson49.controller;

import com.example.lesson49.model.Candidate;
import com.example.lesson49.service.FileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class CandidateController {
    List<Candidate> candidates = FileService.readCandidates();

    @GetMapping("/candidates")
    public String allCandidates(Model model){
        AtomicInteger count = new AtomicInteger(1);
        for (Candidate candidate : candidates) {
            candidate.setId(count.get());
            count.getAndIncrement();
        }
        model.addAttribute("candidates", candidates);
        return "candidates";
    }
    @PostMapping(value = "/thankyou")
    public String getSingleCandidate(Integer id, Model model){
        Candidate candidate = null;
        for (Candidate candidate1 : candidates) {
            if (candidate1.getId() == id) {
                candidate = candidate1;
                candidate1.getVoted(candidate1);
            }
        }
        
        candidate.setPercentVotes(12);
        model.addAttribute("candidate", candidate);
        return "thankyou";
    }
    @GetMapping("/votes")
    public String allVotes(Model model){
        model.addAttribute("candidates", candidates);
        return "votes";
    }




}

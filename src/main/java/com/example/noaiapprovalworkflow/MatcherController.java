package com.example.noaiapprovalworkflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MatcherController {

    @GetMapping("/matcher")
    public String match(@RequestParam String input) {
        FuzzyMatcher fuzzyMatcher = new FuzzyMatcher();
        return fuzzyMatcher.getLevenshteinDistance(input);
//        return fuzzyMatcher.
    }
}

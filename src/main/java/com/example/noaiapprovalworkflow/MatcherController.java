package com.example.noaiapprovalworkflow;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.util.Tuple;

import java.io.IOException;

@RestController
public class MatcherController {

    @GetMapping("/matcherScore")
    public Integer matchScore(@RequestParam String input) throws IOException {
        FuzzyMatcher fuzzyMatcher = new FuzzyMatcher();
        return fuzzyMatcher.getLevenshteinDistance(input)._1();
    }

    @GetMapping("/matcher")
    public Boolean matcher(@RequestParam String input) throws IOException {
        FuzzyMatcher fuzzyMatcher = new FuzzyMatcher();
        return fuzzyMatcher.getLevenshteinDistance(input)._1() <= 1;
    }

    @GetMapping("/matcherDetailed")
    public String matcherDetailed(@RequestParam String input) throws IOException {
        FuzzyMatcher fuzzyMatcher = new FuzzyMatcher();
        var match = fuzzyMatcher.getLevenshteinDistance(input);
        return String.format("Fuzzy-matched on <strong>%s</strong> with a <a href=\"https://en.wikipedia.org/wiki/Levenshtein_distance\">Levenshtein Distance</a> of <strong>%s</strong> <br /><br /><i>(1 is exact match, 2 is close match, >2 should be discarded)</i>",
                match._2(),
                match._1());
    }
}

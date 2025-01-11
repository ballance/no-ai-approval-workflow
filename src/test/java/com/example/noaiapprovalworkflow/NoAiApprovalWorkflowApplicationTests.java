package com.example.noaiapprovalworkflow;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.util.Tuple;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class NoAiApprovalWorkflowApplicationTests {

    public FuzzyMatcher fuzzyMatcher;


    public NoAiApprovalWorkflowApplicationTests() throws IOException {
        fuzzyMatcher = new FuzzyMatcher();
        fuzzyMatcher.loadDictionary("dictionary.txt");
    }

    @Test
    void contextLoads() {
    }

    @Test
    void successMatchingEggplant() throws IOException {
        Tuple<Integer, String> distance = fuzzyMatcher.getLevenshteinDistance("eggplant");
        assertTrue(distance._2().equals("eggplant") && distance._1() <= 1, "Levenshtein distance should be <= 1");
    }

    @Test
    void failsMatchingEggplant() throws IOException {
        Tuple<Integer, String> distance = fuzzyMatcher.getLevenshteinDistance("eggsalad");
        assertFalse(distance._1() <= 1, "Levenshtein distance should be <= 1");
    }
}

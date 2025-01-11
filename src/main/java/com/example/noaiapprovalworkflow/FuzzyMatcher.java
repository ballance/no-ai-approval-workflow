package com.example.noaiapprovalworkflow;

import org.apache.commons.text.similarity.LevenshteinDistance;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class FuzzyMatcher {
    private Set<String> dictionary;
    private LevenshteinDistance levenshtein;

    private CosineSimilarity cosineSimilarity;

    public FuzzyMatcher() {
        dictionary = new HashSet<>();
        levenshtein = new LevenshteinDistance();
        cosineSimilarity = new CosineSimilarity();
    }

    public void loadDictionary(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()))) {
            dictionary = reader.lines()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());
        }
    }

    public String fuzzyMatch(String input) {
        input = input.toLowerCase();
        String bestMatch = "";
        int bestDistance = Integer.MAX_VALUE;

        for (String word : dictionary) {
            int distance = levenshtein.apply(input, word);
            if (distance < bestDistance) {
                bestDistance = distance;
                bestMatch = word;
            }
        }
        if (bestDistance <= 2) {
            String.format(input + "' is '%s' with a distance of %s", bestMatch, bestDistance);
        }
        return String.format("no match, best distance of %d", bestDistance);
    }

    public String getLevenshteinDistance(String input)
    {
        try {
            FuzzyMatcher matcher = new FuzzyMatcher();
            matcher.loadDictionary("dictionary.txt");

            String match = matcher.fuzzyMatch(input);
            return String.format("Fuzzy match result: %s ", match);

        } catch (IOException e) {
            return "error";
        }
    }
}
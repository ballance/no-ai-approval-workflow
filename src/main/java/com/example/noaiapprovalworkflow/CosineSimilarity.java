package com.example.noaiapprovalworkflow;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;

import java.util.HashMap;
import java.util.Map;

public class CosineSimilarity {
    private static double calculateCosineSimilarity(RealVector v1, RealVector v2) {
        double dotProduct = v1.dotProduct(v2);
        double magnitude = v1.getNorm() * v2.getNorm();
        return (magnitude == 0) ? 0 : dotProduct / magnitude;
    }

    private static Map<String, Integer> getNgramFrequencyMap(String str, int n) {
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i <= str.length() - n; i++) {
            String ngram = str.substring(i, i + n);
            frequencyMap.put(ngram, frequencyMap.getOrDefault(ngram, 0) + 1);
        }
        return frequencyMap;
    }

    private static RealVector toRealVector(Map<String, Integer> source, Map<String, Integer> target) {
        double[] vector = new double[target.size()];
        int index = 0;

        for (String key : target.keySet()) {
            vector[index++] = source.getOrDefault(key, 0);
        }

        return new ArrayRealVector(vector);
    }
}

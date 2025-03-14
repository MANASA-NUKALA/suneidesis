package com.harium.suneidesis.math;

import java.util.Scanner;

public class SequenceSolver implements SequenceDetector {

    @Override
    public String detectPattern(String... terms) {
        if (terms.length < 2) {
            return "Insufficient data";
        }

        int[] sequence = new int[terms.length];
        try {
            for (int i = 0; i < terms.length; i++) {
                sequence[i] = Integer.parseInt(terms[i]);
            }
        } catch (NumberFormatException e) {
            return "Invalid input: Sequence should contain only numbers.";
        }

        boolean isArithmetic = true;
        boolean isGeometric = true;
        int commonDifference = sequence[1] - sequence[0];
        double commonRatio = (double) sequence[1] / sequence[0];

        for (int i = 1; i < sequence.length; i++) {
            if (sequence[i] - sequence[i - 1] != commonDifference) {
                isArithmetic = false;
            }
            if ((double) sequence[i] / sequence[i - 1] != commonRatio) {
                isGeometric = false;
            }
        }

        if (isArithmetic) {
            int nextTerm = sequence[sequence.length - 1] + commonDifference;
            return "Arithmetic Progression\nOperation: Sum\nFactor: " + commonDifference + "\nNext Term: " + nextTerm;
        } else if (isGeometric) {
            double nextTerm = sequence[sequence.length - 1] * commonRatio;
            return "Geometric Progression\nOperation: Multiply\nFactor: " + commonRatio + "\nNext Term: " + nextTerm;
        } else {
            return "Unknown pattern.";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SequenceDetector solver = new SequenceSolver();

        System.out.println("Enter the number of terms in the sequence:");
        int n = scanner.nextInt();
        scanner.nextLine();  // Consume the newline

        if (n < 2) {
            System.out.println("Insufficient data");
            return;
        }

        String[] terms = new String[n];
        System.out.println("Enter the sequence numbers separated by space:");
        terms = scanner.nextLine().split(" ");

        System.out.println(solver.detectPattern(terms));

        scanner.close();
    }
}

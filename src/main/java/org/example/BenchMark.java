package org.example;

import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;

public class BenchMark {
    static int numberOfTests = 8;
    private static ArrayList<String> testNames = new ArrayList<>();
    private static ArrayList<String> testAnsNames = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i <= 12; i++) {
            testNames.add("src/main/resources/test" + i + ".txt");
            testAnsNames.add("src/main/resources/test" + i + "_ans.txt");
        }
        getTimeMin();
        getTimeMax();
        getTimeSum();
        getTimeMult();
    }

    static void getTimeMin() {
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.nanoTime();
            NumbersOperations.findMin(testName);
            long endTime = System.nanoTime();

            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " findMin took " + (endTime - startTime) + " ns");
        }
    }

    static void getTimeMax() {
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.nanoTime();
            NumbersOperations.findMax(testName);
            long endTime = System.nanoTime();

            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " findMax took " + (endTime - startTime) + " ns");
        }
    }

    static void getTimeSum() {
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.nanoTime();
            NumbersOperations.getSum(testName);
            long endTime = System.nanoTime();

            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " getSum took " + (endTime - startTime) + " ns");
        }
    }

    static void getTimeMult() {
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.nanoTime();
            NumbersOperations.findMin(testName);
            long endTime = System.nanoTime();

            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1)  + " getMult took " + (endTime - startTime) + " ns");
        }
    }
}

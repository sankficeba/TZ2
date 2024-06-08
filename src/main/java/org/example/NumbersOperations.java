package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;

public class NumbersOperations {
    // Метод для получения списка чисел из файла
    static ArrayList<BigInteger> getNumbersFromFile(String filename) {
        ArrayList<BigInteger> numbers = new ArrayList<>();
        String failedNumberString = "";
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line = br.readLine();
            if (line != null) {
                String[] numberStrings = line.trim().split("\\s+");
                for (String numberString : numberStrings) {
                    failedNumberString = numberString;
                    numbers.add(new BigInteger(numberString));
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid number: " + failedNumberString);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("Error reading " + filename);
            throw new RuntimeException("Error reading file: " + filename);
        }

        return numbers;
    }

    // Метод для поиска минимального числа в файле
    static BigInteger findMin(String filename) {
        ArrayList<BigInteger> numbers = NumbersOperations.getNumbersFromFile(filename);
        if (numbers.isEmpty()) {
            throw new RuntimeException("No numbers found in file: " + filename);
        }
        BigInteger min = numbers.getFirst();
        for (BigInteger number : numbers) {
            if (number.compareTo(min) < 0) {
                min = number;
            }
        }
        return min;
    }

    // Метод для поиска максимального числа в файле
    static BigInteger findMax(String filename) {
        ArrayList<BigInteger> numbers = NumbersOperations.getNumbersFromFile(filename);
        if (numbers.isEmpty()) {
            throw new RuntimeException("No numbers found in file: " + filename);
        }
        BigInteger max = numbers.getFirst();
        for (BigInteger number : numbers) {
            if (number.compareTo(max) > 0) {
                max = number;
            }
        }
        return max;
    }

    // Метод для получения суммы чисел из файла
    static BigInteger getSum(String filename) {
        ArrayList<BigInteger> numbers = NumbersOperations.getNumbersFromFile(filename);
        if (numbers.isEmpty()) {
            throw new RuntimeException("No numbers found in file: " + filename);
        }
        BigInteger sum = BigInteger.ZERO;
        for (BigInteger number : numbers) {
            sum = sum.add(number);
        }
        return sum;
    }

    // Метод для получения произведения чисел из файла
    static BigInteger getMult(String filename) {
        ArrayList<BigInteger> numbers = NumbersOperations.getNumbersFromFile(filename);
        if (numbers.isEmpty()) {
            throw new RuntimeException("No numbers found in file: " + filename);
        }
        BigInteger mult = BigInteger.ONE;
        for (BigInteger number : numbers) {
            mult = mult.multiply(number);
        }
        return mult;
    }
}

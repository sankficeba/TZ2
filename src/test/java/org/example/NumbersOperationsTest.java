package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;
import java.time.Duration;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NumbersOperationsTest {
    private static ArrayList<String> testNames = new ArrayList<>();
    private static ArrayList<String> testAnsNames = new ArrayList<>();
    static int numberOfTests = 8;
    @BeforeAll
    static void init() {
        // Заполняем списки имен файлов тестов и ожидаемых результатов
        for (int i = 1; i <= 12; i++) {
            testNames.add("src/main/resources/test" + i + ".txt");
            testAnsNames.add("src/main/resources/test" + i + "_ans.txt");
        }
    }
    @Test
    void findMin() {
        // Тестируем метод поиска минимального значения
        System.out.println("\n" + "==============================" + "\n");
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testNames.get(i);
            BigInteger expected = NumbersOperations.getNumbersFromFile(testAnsName).get(0);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.currentTimeMillis();
            BigInteger actual = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> NumbersOperations.findMin(testName));
            long endTime = System.currentTimeMillis();

            assertEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " findMin took " + (endTime - startTime) + " ns");
        }
    }

    @Test
    void findMax() {
        // Тестируем метод поиска максимального значения
        System.out.println("\n" + "==============================" + "\n");
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);
            BigInteger expected = NumbersOperations.getNumbersFromFile(testAnsName).get(1);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.currentTimeMillis();
            BigInteger actual = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> NumbersOperations.findMax(testName));
            long endTime = System.currentTimeMillis();

            assertEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " findMax took " + (endTime - startTime) + " ns");
        }
    }

    @Test
    void getSum() {
        // Тестируем метод получения суммы чисел
        System.out.println("\n" + "==============================" + "\n");
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);
            BigInteger expected = NumbersOperations.getNumbersFromFile(testAnsName).get(2);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.currentTimeMillis();
            BigInteger actual = assertTimeoutPreemptively(Duration.ofSeconds(2), () -> NumbersOperations.getSum(testName));
            long endTime = System.currentTimeMillis();

            assertEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1) + " getSum took " + (endTime - startTime) + " ns");
        }
    }

    @Test
    void getMult() {
        // Тестируем метод получения произведения чисел
        System.out.println("\n" + "==============================" + "\n");
        for (int i = 0; i < numberOfTests; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);
            BigInteger expected = NumbersOperations.getNumbersFromFile(testAnsName).get(3);

            // Засекаем время выполнения и проверяем, что метод возвращает ожидаемый результат
            long startTime = System.currentTimeMillis();
            BigInteger actual = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.getMult(testName));
            long endTime = System.currentTimeMillis();

            assertEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1)  + " getMult took " + (endTime - startTime) + " ns");
        }
    }

    @Disabled
    @Test
    void fileSizeIncrease() {
        // Тестируем увеличение размера файла
        System.out.println("\n" + "SIZEINCREASE==============================" + "\n");
        for (int i = 8; i <= 9; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);
            BigInteger[] expected = NumbersOperations.getNumbersFromFile(testAnsName).toArray(new BigInteger[0]);

            // Засекаем время выполнения и проверяем, что методы возвращают ожидаемые результаты
            long startTime = System.currentTimeMillis();
            BigInteger[] actual = new BigInteger[4];
            actual[0] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.findMin(testName));
            actual[1] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.findMax(testName));
            actual[2] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.getSum(testName));
            actual[3] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.getMult(testName));
            long endTime = System.currentTimeMillis();

            assertArrayEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1)  + " took " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void fileBigIntegerMillion() {
        // Тестируем работу с большими целыми числами
        System.out.println("\n" + "BIGINTEGER==============================" + "\n");
        for (int i = 11; i <= 11; i++) {
            String testName = testNames.get(i);
            String testAnsName = testAnsNames.get(i);
            BigInteger[] expected = NumbersOperations.getNumbersFromFile(testAnsName).toArray(new BigInteger[0]);

            // Засекаем время выполнения и проверяем, что методы возвращают ожидаемые результаты
            long startTime = System.currentTimeMillis();
            BigInteger[] actual = new BigInteger[4];
            actual[0] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.findMin(testName));
            actual[1] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.findMax(testName));
            actual[2] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.getSum(testName));
            actual[3] = assertTimeoutPreemptively(Duration.ofSeconds(3), () -> NumbersOperations.getMult(testName));
            long endTime = System.currentTimeMillis();

            assertArrayEquals(expected, actual);
            System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1)  + " took " + (endTime - startTime) + " ms");
        }
    }

    @Test
    void testThrowsException() {
        // Метод тестирования выбрасывания исключения при некорректном имени файла
        String invalidFileName = "src/main/resources/invalid_test.txt";
        assertThrows(RuntimeException.class, () -> NumbersOperations.findMin(invalidFileName));
        assertThrows(RuntimeException.class, () -> NumbersOperations.findMin(invalidFileName));
        assertThrows(RuntimeException.class, () -> NumbersOperations.getSum(invalidFileName));
        assertThrows(RuntimeException.class, () -> NumbersOperations.getMult(invalidFileName));
    }

//    @Disabled
//    @Test
//    void timeLimit() {
//        String testName = testNames.get(12);
//        String testAnsName = testAnsNames.get(12);
//        BigInteger[] expected = NumbersOperations.getNumbersFromFile(testAnsName).toArray(new BigInteger[0]);
//
//        long startTime = System.currentTimeMillis();
//        BigInteger[] actual = new BigInteger[4];
//        actual[0] = assertTimeoutPreemptively(Duration.ofSeconds(300), () -> NumbersOperations.findMin(testName));
//        actual[1] = assertTimeoutPreemptively(Duration.ofSeconds(300), () -> NumbersOperations.findMax(testName));
//        actual[2] = assertTimeoutPreemptively(Duration.ofSeconds(300), () -> NumbersOperations.getSum(testName));
//        actual[3] = assertTimeoutPreemptively(Duration.ofSeconds(300), () -> NumbersOperations.getMult(testName));
//        long endTime = System.currentTimeMillis();
//
//        assertArrayEquals(expected, actual);
//        System.out.println(testName.substring(0, testName.lastIndexOf('.')).substring(testName.lastIndexOf('/') + 1)  + " took " + (endTime - startTime) + " ms");
//    }
}
package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {
        write();
        //writeRandom(1000000, 12);
        print(13);
    }

    static void print(int test) throws IOException {
        String filename = "TZ2/src/main/resources/test" + test + ".txt";

        System.out.println("Min " + NumbersOperations.findMin(filename));
        System.out.println("Max " + NumbersOperations.findMax(filename));
        System.out.println("Sum " + NumbersOperations.getSum(filename));
        //System.out.println("Mult " + NumbersOperations.getMult(filename));

        String filenameAns = "TZ2/src/main/resources/test" + test + "_ans.txt";
        byte[] buffer = (NumbersOperations.findMin(filename).toString() + ' ' + NumbersOperations.findMax(filename) + ' ' + NumbersOperations.getSum(filename) + ' ' + '0').getBytes();
        FileOutputStream outputStream = new FileOutputStream(filenameAns);
        outputStream.write(buffer);
    }

    static void write() throws IOException {
        File myFile = new File("TZ2/src/main/resources/test13.txt");
        FileOutputStream outputStream = new FileOutputStream(myFile);
//        System.out.println(Arrays.toString(BigInteger.TEN.toString().getBytes())**);

        BigInteger bigInteger = new BigInteger("199999999999999999");
        for (BigInteger bi = bigInteger; bi.compareTo(bigInteger.add(new BigInteger("1000000"))) < 0; bi = bi.add(BigInteger.ONE)) {
            byte[] buffer = bi.toString().getBytes();
            outputStream.write(buffer);
            outputStream.write(" ".getBytes());
        }
        outputStream.close();
    }

    static void writeRandom(long count, int test) throws IOException {
        File myFile = new File("TZ2/src/main/resources/test" + test + ".txt");
        FileOutputStream outputStream = new FileOutputStream(myFile);
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            Long randLong = random.nextLong();
            byte[] buffer = randLong.toString().getBytes();
            outputStream.write(buffer);
            outputStream.write(" ".getBytes());
        }
        outputStream.close();
    }
}

package com.company;

import java.io.*;
import java.lang.String;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static List<Integer> readfileToInteger(String messungen) throws IOException {
        return Files.lines(Paths.get(messungen))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<String> readFileToString(String messungen) throws IOException {
        return Files.lines(Paths.get(messungen))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) throws IOException {
        // 1. Türchen
        String messungen = "src/com/company/Measurements";
        CastNumbers castNumbers = new CastNumbers();
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        List<Integer> messungInt = readfileToInteger(messungen);
        castNumbers.incrDecr(messungInt);
        System.out.println("oO.-.-.<^>.-.-.Oo");
        System.out.println(" ");
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        castNumbers.threeMeasurementSliding(messungInt);
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");


        // 2. Türchen
        String linkDiving = "src/com/company/DivingData";
        Dive dive = new Dive();
        List<String> file2 = readFileToString(linkDiving);
        int horizontal = 0;     // positiv ist vorwärts und negativ rückwärts
        int depht = 0;        // + = runter, - = hoch
        int aim = 0;
        List<Integer> distance = dive.calculateDistance(file2);
        List<String> direction = dive.calculateDirection(file2);

        for (int i = 0; i < distance.size(); i++) {
            switch (direction.get(i)) {
                case "f" -> {
                    horizontal += distance.get(i);
                    depht += distance.get(i) * aim;
                }
                case "u" -> {
                    aim -= distance.get(i);
                }
                case "d" -> {
                    aim += distance.get(i);
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction.get(i));
            }
        }
        int ergebnis = depht * horizontal;
        System.out.println("Position:      " + ergebnis);
        System.out.println("Wir haben uns " + depht + " schritte abwärts und ");
        System.out.println("      " + horizontal + " Schritte vorwärts bewegt!");
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");

        // 3. Türchen
        String link = "src/com/company/Binaries";
        BinaryDiagnosticZwei binZwei = new BinaryDiagnosticZwei();
        System.out.println("The powerconsumption of our submarine is: ");
        System.out.print("             ==> ");
        System.out.print(
                binZwei.turnInDezimal(
                        binZwei.calcEpsilonRate(
                                binZwei.calcDeltaRate(
                                        readFileToString(link)))) * binZwei.turnInDezimal(
                        binZwei.calcDeltaRate(
                                readFileToString(link))));
        System.out.print(" <==");
    }
}



package com.company;

import java.io.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // 1. Türchen
        CastNumbers castNumbers = new CastNumbers();
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        int[] messungInt = castNumbers.parseToInt(castNumbers.readfile(), 2000);
        castNumbers.IncrDecrOut(messungInt);
        System.out.println("oO.-.-.<^>.-.-.Oo");
        System.out.println(" ");
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        castNumbers.threeMeasurementSliding(messungInt);
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");


        // 2. Türchen
        Dive dive = new Dive();
        String[] file2 = dive.readFile();
        int horizontal = 0;     // positiv ist vorwärts und negativ rückwärts
        int depht = 0;        // + = runter, - = hoch
        int aim = 0;
        int[] distance = castNumbers.parseToInt(dive.calculateDistance(file2), 1000);
        String[] direction = dive.calculateDirection(file2);

        for (int i = 0; i < distance.length; i++) {
            switch (direction[i]) {
                case "f" -> {
                    horizontal += distance[i];
                    depht += distance[i] * aim;
                }
                case "u" -> {
                    aim -= distance[i];
                }
                case "d" -> {
                    aim += distance[i];
                }
                default -> throw new IllegalStateException("Unexpected value: " + direction[i]);
            }
        }
        int ergebnis = depht * horizontal;
        System.out.println("Position:      " + ergebnis);
        System.out.println("Wir haben uns " + depht + " schritte abwärts und ");
        System.out.println("      " + horizontal + " Schritte vorwärts bewegt!");
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");

    }
}



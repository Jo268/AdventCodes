package com.company;

import java.io.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        CastNumbers castNumbers = new CastNumbers();
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        int[] messungInt = castNumbers.parseToInt(castNumbers.readfile());
        castNumbers.IncrDecrOut(messungInt);
        System.out.println("oO.-.-.<^>.-.-.Oo");
        System.out.println(" ");
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
        castNumbers.threeMeasurementSliding(messungInt);
        System.out.println("oO.-.-.-.-.-.-.-.-<<^>>-.-.-.-.-.-.-.-.Oo");
    }
}



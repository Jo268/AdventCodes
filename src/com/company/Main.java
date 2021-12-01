package com.company;

import java.io.*;
import java.text.*;
import java.util.*;
import java.lang.String;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        CastNumbers castNumbers = new CastNumbers();
        int[] messungInt = castNumbers.parseToInt(castNumbers.readfile());
        int decrease = 0;
        int increase = 0;

        for (int i = 0; i < messungInt.length - 1; i++) {
            if (messungInt[i] < messungInt[i + 1]) {
                increase += 1;
                continue;
            } else {
                decrease += 1;
            }
            // System.out.println(increase);
            // System.out.println(decrease);
        }
        System.out.println("Eine Steigerung in den Messdaten war: " + increase + " mal zu verzeichnen.");
        System.out.println("Und "+ decrease + " Abstiege.");

        // Stern zwei
        int incrCounter = 0;
        int noChangeCounter = 0;
        int decCounter = 0;

        for (int i = 0; i < messungInt.length - 2; i++) {
            int dreierSumme = 0;
            int vergleichsSumme = 0;
            int start = i;
            int end = start + 3;
            int[] erstenDrei = Arrays.copyOfRange(messungInt, start, end);

            for (int k = 0; k < erstenDrei.length; k++) {
                dreierSumme += erstenDrei[k];
            }
            int[] naechstenDrei = Arrays.copyOfRange(messungInt, start + 1, end + 1);
            for (int j : naechstenDrei) {
                vergleichsSumme += j;
            }

            if (dreierSumme < vergleichsSumme) {
                incrCounter += 1;
            } else if (dreierSumme == vergleichsSumme) {
                noChangeCounter += 1;
            } else {
                decCounter += 1;
            }
        }
        System.out.println("Die Messungen waren: " + incrCounter + " mal höher.\nDie Messungen waren: " + decCounter + " mal niedriger.");
        System.out.println("Und Messungen waren: " + noChangeCounter + " mal gleich");
    }
}



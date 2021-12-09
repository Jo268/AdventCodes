package com.company;

import java.util.List;

public class CastNumbers {

    String[] array = new String[2000];


    public int[] parseToInt(String[] messung, int grosse) {
        int size = grosse;
        int [] intArray = new int [size];
        for(int i=0; i<size; i++) {
            intArray[i] = Integer.parseInt(messung[i]);
        }
        return intArray;
    }

    public void incrDecr(List<Integer> messung) {
        int decrease = 0;
        int increase = 0;

        for (int i = 0; i < messung.size() - 1; i++) {
            if (messung.get(i) < messung.get(i + 1)) {
                increase += 1;
            } else {
                decrease += 1;
            }
        }
        System.out.println("Eine Steigerung in den Messdaten war: " + increase + " mal zu verzeichnen.");
        System.out.println("Und " + decrease + " Abstiege.");
    }

    public void threeMeasurementSliding(List<Integer> messung) {
        // Stern zwei
        int incrCounter = 0;
        int noChangeCounter = 0;
        int decCounter = 0;

        for (int start = 0; start < messung.size() - 3; start++) {
            int dreierSumme = 0;
            int vergleichsSumme = 0;

            List<Integer> erstenDrei = messung.subList(start, start + 3);
            for (int value : erstenDrei) {
                dreierSumme += value;
            }

            List<Integer> naechstenDrei = messung.subList(start + 1, start + 4);
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
        System.out.println("  Die Messungen waren: " + incrCounter + " mal höher.\n Die Messungen waren: " + decCounter + " mal niedriger.");
        System.out.println("  Und Messungen waren: " + noChangeCounter + " mal gleich");

    }
}

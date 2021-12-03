package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;

public class CastNumbers {

    String[] array = new String[2000];
    String messungen = "/Users/admin/Desktop/DevFun/AdventCode/src/com/company/Measurements";

    public String[] readfile() throws FileNotFoundException {
        FileReader fr = new FileReader(messungen);
        BufferedReader br = new BufferedReader(fr);
        try {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                array[i] = line;
                //System.out.println(array[i]);
                i++;
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public int[] parseToInt(String[] messung, int grosse) {

        int size = grosse;
        int [] intArray = new int [size];
        for(int i=0; i<size; i++) {
            intArray[i] = Integer.parseInt(messung[i]);
        }
        return intArray;
    }

    public void IncrDecrOut(int[] messung) {
        int[] messungInt = messung;
        int decrease = 0;
        int increase = 0;

        for (int i = 0; i < messungInt.length - 1; i++) {
            if (messungInt[i] < messungInt[i + 1]) {
                increase += 1;
                continue;
            } else {
                decrease += 1;
            }
        }
        System.out.println("Eine Steigerung in den Messdaten war: " + increase + " mal zu verzeichnen.");
        System.out.println("Und " + decrease + " Abstiege.");
    }

    public void threeMeasurementSliding (int[] messung) {
        int[] messungInt = messung;
        // Stern zwei
        int incrCounter = 0;
        int noChangeCounter = 0;
        int decCounter = 0;

        for (int start = 0; start < messungInt.length - 2; start++) {
            int dreierSumme = 0;
            int vergleichsSumme = 0;

            int[] erstenDrei = Arrays.copyOfRange(messungInt, start, start + 3);
            for (int value : erstenDrei) {
                dreierSumme += value;
            }

            int[] naechstenDrei = Arrays.copyOfRange(messungInt, start + 1, start + 4);
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

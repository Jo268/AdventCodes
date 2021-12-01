package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class CastNumbers {

    String[] array = new String[2000];
    String messungen = "/Users/admin/Desktop/DevFun/AdventCode/src/com/company/Measurements";

    public String[] readfile() throws FileNotFoundException {
        FileReader fr = new FileReader(messungen);
        BufferedReader br = new BufferedReader(fr);
        try {
            String line;
            int i = 0;
            while ((line =br.readLine()) != null) {
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
    public int[] parseToInt(String[] messung) {

        int size = 2000;
        int [] intArray = new int [size];
        for(int i=0; i<size; i++) {
            intArray[i] = Integer.parseInt(messung[i]);
        }
        return intArray;
    }
}

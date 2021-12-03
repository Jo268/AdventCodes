package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Dive {

    static String[] array = new String[1000];

    public String[] readFile() throws FileNotFoundException {
        FileReader fr = new FileReader("/Users/admin/Desktop/DevFun/AdventCode/src/com/company/DivingData");
        BufferedReader br = new BufferedReader(fr);
        try {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                array[i] = line;
                //  System.out.println(array[i]);
                i++;
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return array;
    }

    public String[] calculateDistance(String[] diveIn) {
        String[] distance = new String[1000];
        String memory;
        for (int i = 0; i < diveIn.length; i++) {
            memory = diveIn[i];
            distance[i] = memory.substring(memory.length() - 1);
            //System.out.println(distance[i]);
        }
        return distance;
    }

    public String[] calculateDirection(String[] diveIn) {
        String[] direction = new String[1000];
        String memory;
        for (int i = 0; i < diveIn.length; i++) {
            memory = diveIn[i];
            direction[i] = memory.substring(0, 1);
            // System.out.println(direction[i]);
        }
        return direction;
    }
}

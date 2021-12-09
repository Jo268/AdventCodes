package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Dive {

    static String[] array = new String[1000];

    public List<Integer> calculateDistance(List<String> diveIn) {
        List<Integer> distance = new ArrayList<>();
        String memory;
        for (String s : diveIn) {
            memory = s;
            distance.add(Integer.parseInt(memory.substring(memory.length() - 1)));
            //System.out.println(distance[i]);
        }
        return distance;
    }

    public List<String> calculateDirection(List<String> diveIn) {
        List<String> direction = new ArrayList<>();
        String memory;
        for (String s : diveIn) {
            memory = s;
            direction.add(memory.substring(0, 1));
            // System.out.println(direction[i]);
        }
        return direction;
    }
}

package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryDiagnosticZwei {

    public List<Integer> calcDeltaRate(List<String> file) {
        List<String> columns = new ArrayList<>();
        int laenge = file.get(0).length();
        List<Integer> columnsInt = new ArrayList<>();
        for (int j = 0; j < laenge; j++) {
            int nullCounter = 0;
            int einsCounter = 0;
            for (int i = 0; i < file.size(); i++) {
                if (file.get(i).charAt(j) == '0') {
                    nullCounter += 1;
                } else einsCounter += 1;
            }
            if (nullCounter > (file.size() / 2)) {
                columns.add(j, "0");
            } else if (einsCounter > (file.size()) / 2) {
                columns.add(j, "1");
            }

        }
        for (String c : columns) columnsInt.add(Integer.valueOf(c));
        //System.out.println(columnsInt);
        return columnsInt;

    }

    public List<Integer> calcEpsilonRate(List<Integer> delta) {
        List<Integer> epsilonRate = new ArrayList<>();
        for (int i : delta) {
            if (Objects.equals(delta.get(i), 1)) {
                epsilonRate.add(0);
            } else if (Objects.equals(delta.get(i), 0)) {
                epsilonRate.add(1);
            }
        }
        //System.out.println(epsilonRate);
        return epsilonRate;
    }

    public int turnInDezimal(List<Integer> rate) {
        String wrapList = rate.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(",", "")
                .replace(" ", "");
        int dezimal = Integer.parseInt(wrapList, 2);
        //System.out.println(dezimal);
        return dezimal;
    }
}


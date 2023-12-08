package aoc2023;

import bo.NumberPosition_D3;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D3 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> gearStrList = Arrays.stream(content.split("\r\n")).toList();

        String[] lines = content.split("\n");
        char[][] map = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            map[i] = lines[i].toCharArray();
        }
        int sum = 0;
        for (int i = 0; i < gearStrList.size(); i++) {
            String[] gearNumberList = gearStrList.get(i).split("[^0-9]");
            int index = 0;
            for (String gearNumber : gearNumberList) {
                //print gearNumber if it is not empty
                if (!gearNumber.isEmpty()) {
                    System.out.print(gearNumber + ",");
                    int start = gearStrList.get(i).indexOf(gearNumber, index);
                    index = gearStrList.get(i).indexOf(gearNumber, index) + gearNumber.length();
                    NumberPosition_D3 numberPosition = new NumberPosition_D3(map);

                    for (int j = 0; j < gearNumber.length(); j++) {
//                        System.out.print(String.format("%s,%s",i,start+j));
//                        System.out.println();
                        numberPosition.getPositionList().add(String.format("%s,%s", i, start + j));
                    }
                    numberPosition.setValue(Integer.parseInt(gearNumber));
                    numberPosition.checkListSurrounding();
//                    System.out.print(numberPosition.isAdjacentToASymbol() + "; ");
                    System.out.print("["+numberPosition.getPositionList().get(0) + "]");
                    System.out.print(numberPosition.isAdjacentToASymbol()+", ");
                    sum += numberPosition.isAdjacentToASymbol() ? numberPosition.getValue() : 0;
                }
            }
            System.out.println();
        }
        System.out.println(sum);
    }
}

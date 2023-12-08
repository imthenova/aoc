package aoc2023;

import bo.NumberPosition_D3;
import bo2023.MapInstruction;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D8 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";
    static int LENGTH = 6;
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> strList = Arrays.stream(content.split("\r\n")).toList();
        String instractionStr = strList.get(0);
        char[] instractionStrCharArray = instractionStr.toCharArray();
        Map<String, MapInstruction> mapInstructionMap = new HashMap<>();
        MapInstruction[] startPoints = new MapInstruction[LENGTH];
        for (int i = 2; i < strList.size(); i++) {
            String key = strList.get(i).substring(0, 3);
            String L = strList.get(i).substring(7, 10);
            String R = strList.get(i).substring(12, 15);
            MapInstruction mapInstruction = new MapInstruction(key, L, R, mapInstructionMap);
            if (key.equals("XVA")) {
                startPoints[0] = mapInstruction;
            } else if (key.equals("GGA")) {
                startPoints[1] = mapInstruction;
            } else if (key.equals("DXA")) {
                startPoints[2] = mapInstruction;
            } else if (key.equals("LTA")) {
                startPoints[3] = mapInstruction;
            } else if (key.equals("BJA")) {
                startPoints[4] = mapInstruction;
            } else if (key.equals("AAA")) {
                startPoints[5] = mapInstruction;
            }
//
//            if (key.equals("11A")) {
//                startPoints[0] = mapInstruction;
//            } else if (key.equals("22A")) {
//                startPoints[1] = mapInstruction;
//            }
            mapInstructionMap.put(key, mapInstruction);
        }
        int count = 0;
        int i = 0;
        MapInstruction[] nextMapIntractions = new MapInstruction[LENGTH];
        for (int j = 0; j < nextMapIntractions.length; j++) {
            nextMapIntractions[j] = startPoints[j];
            System.out.print(nextMapIntractions[j] + " " + instractionStrCharArray[i] + ",");
        }
        System.out.println();
        while (!isArrive(nextMapIntractions)) {
//            if(count>100){break;}
            count++;
            for (int j = 0; j < nextMapIntractions.length; j++) {
                nextMapIntractions[j] = nextMapIntractions[j].move(instractionStrCharArray[i]);
//                System.out.print(nextMapIntractions[j] + " " + instractionStrCharArray[i] + ",");
            }
//            System.out.println();
            isOneArrive(nextMapIntractions);
            i++;
            if (i == instractionStrCharArray.length) {
                i = 0;
            }
        }

        System.out.println(count);
    }
    private static boolean isArrive(MapInstruction[] nextMapIntractions){
        for (int i = 0; i < nextMapIntractions.length; i++) {
            if(!nextMapIntractions[i].isArrive()){
                return false;
            }
        }
        return true;
    }
    private static void isOneArrive(MapInstruction[] nextMapIntractions){
        int count=0;
        for (int i = 0; i < nextMapIntractions.length; i++) {
            if(nextMapIntractions[i].isArrive()){
                count++;
            }
        }
        if(count>3){
            for (int j = 0; j < nextMapIntractions.length; j++) {
                System.out.print(nextMapIntractions[j].getName() + ",");
            }
            System.out.println();
        }
    }
}

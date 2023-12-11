package aoc2023;

import bo2023.MapInstruction;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D11 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";
    static int LENGTH = 6;

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\r\n");
        //get map
        char[][] map = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            map[i] = lines[i].toCharArray();
        }
        //expanse map
        map = expanseRow(map);
        map = expanseCol(map);
        //get # coordinates list
        List<String> coordinatesList = new ArrayList<>();
        for (int i = 0; i < map.length; i++) {//y
            for (int j = 0; j < map[i].length; j++) {//x
                if (map[i][j] == '#') {
                    coordinatesList.add(String.format("%s,%s", i, j));
                }
            }
        }
        //print map
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
        //print coordinatesList
        for (int i = 0; i < coordinatesList.size(); i++) {
            System.out.print(coordinatesList.get(i) + ";");
        }
        System.out.println();
        int sumDistance = 0;
        for (int i = 0; i < coordinatesList.size(); i++) {
            sumDistance += getSumDistanceOfPreviousCoordinates(i, coordinatesList);
        }
        System.out.println(sumDistance);
    }

    //expanse rows with .
    private static char[][] expanseRow(char[][] oldMap) {
        //if all chars in a row is '.', then add a new row with '.'
        List<Integer> addedRowList = new ArrayList<>();
        for (int i = 0; i < oldMap.length; i++) {
            boolean allDot = true;
            for (int j = 0; j < oldMap[i].length; j++) {
                if (oldMap[i][j] != '.') {
                    allDot = false;
                    break;
                }
            }
            if (allDot) {
                addedRowList.add(i);
            }
        }
        for (int i = 0; i < addedRowList.size(); i++) {
            oldMap = addRow(oldMap, addedRowList.get(i) + i);
        }
        return oldMap;
    }

    //expanse cols with .
    private static char[][] expanseCol(char[][] oldMap) {
        //if all chars in a col is '.', then add a new col with '.'
        List<Integer> addedColList = new ArrayList<>();
        for (int i = 0; i < oldMap[0].length; i++) {
            boolean allDot = true;
            for (int j = 0; j < oldMap.length; j++) {
                if (oldMap[j][i] != '.') {
                    allDot = false;
                    break;
                }
            }
            if (allDot) {
                addedColList.add(i);
            }
        }
        for (int i = 0; i < addedColList.size(); i++) {
            oldMap = addCol(oldMap, addedColList.get(i) + i);
        }
        return oldMap;
    }

    private static char[][] addCol(char[][] oldMap, int i) {
        //add a new col
        char[][] newMap = new char[oldMap.length][oldMap[0].length + 1];
        for (int j = 0; j < newMap[0].length; j++) {//y
            for (int k = 0; k < newMap.length; k++) {//x
                if (j < i) {
                    newMap[k][j] = oldMap[k][j];
                } else if (j > i) {
                    newMap[k][j] = oldMap[k][j - 1];
                } else {
                    newMap[k][j] = '.';
                }
            }
        }
        return newMap;
    }

    private static char[][] addRow(char[][] oldMap, int i) {
        char[] newRow = new char[oldMap[i].length];
        Arrays.fill(newRow, '.');
        //add a new row
        char[][] newMap = new char[oldMap.length + 1][];
        for (int j = 0; j < i; j++) {
            newMap[j] = oldMap[j];
        }
        newMap[i] = newRow;
        for (int j = i + 1; j < oldMap.length + 1; j++) {
            newMap[j] = oldMap[j - 1];
        }
        return newMap;
    }

    private static int getDistance(String coordinate1, String coordinate2) {
        int x1 = Integer.parseInt(coordinate1.split(",")[0]);
        int y1 = Integer.parseInt(coordinate1.split(",")[1]);
        int x2 = Integer.parseInt(coordinate2.split(",")[0]);
        int y2 = Integer.parseInt(coordinate2.split(",")[1]);
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    private static int getSumDistanceOfPreviousCoordinates(int index, List<String> coordinatesList) {
        int sum = 0;
        String coordinate = coordinatesList.get(index);
        for (int i = 0; i < index; i++) {
            sum += getDistance(coordinate, coordinatesList.get(i));
        }
        return sum;
    }
}

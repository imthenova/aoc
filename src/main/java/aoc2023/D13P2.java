package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class D13P2 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] parts = content.split("\r\n\r\n");
        int score = 0;
        for (int k = 0; k < parts.length; k++) {
            String[] lines = parts[k].split("\r\n");
            D13P2 game = new D13P2();
            char[][] map = new char[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                map[i] = lines[i].toCharArray();
            }
            //print map
            for (int i = 0; i < map.length; i++) {
                System.out.println(map[i]);
            }
            System.out.println("--------");
            //print map switch row and col
            for (int i = 0; i < map[0].length; i++) {
                for (int j = 0; j < map.length; j++) {
                    System.out.print(map[j][i]);
                }
                System.out.println();
            }



            int result = game.findHorizontalReflection(map);
            if (result == -1) {
                result = game.fineVerticalReflection(map);
                if(result==-1){
                    result=0;
                }
                score += result;
                System.out.println(result);
            } else {
                score += 100 * result;
                System.out.println(100 * result);
            }


        }
        System.out.println(score);
    }

    public int findHorizontalReflection(char[][] map) {
        for (int i = 1; i < map.length; i++) {
            int diffCount = 0;
            //diffCount = map[i] and map[i-1] different item counts
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] != map[i - 1][j]) {
                    diffCount++;
                }
                if (diffCount>1){
                    break;
                }
            }
            if(diffCount<=1 && validateHorizontalReflection(map, i,diffCount)){
                return i;
            }
        }
        return -1;
    }

    public int fineVerticalReflection(char[][] map) {
        for (int i = 1; i < map[0].length; i++) {
            int diffCount = 0;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] != map[j][i - 1]) {
                    diffCount++;
                }
                if (diffCount>1){
                    break;
                }
            }
            if (diffCount<=1 && validateVerticalReflection(map, i,diffCount)) {
                return i;
            }
        }
        return -1;
    }

    public boolean validateHorizontalReflection(char[][] map, int index,int diffCount) {
        for (int i = 1; i < index; i++) {
            if (index + i == map.length || index - i - 1 < 0) {
                return diffCount==1;
            }
            //diffCount = map[i] and map[i-1] different item counts
            for (int j = 0; j < map[i].length; j++) {
                if (map[index + i][j] != map[index - i - 1][j]) {
                    diffCount++;
                }
                if (diffCount>1){
                    return false;
                }
            }
        }
        return diffCount==1;
    }

    public boolean validateVerticalReflection(char[][] map, int index,int diffCount) {
        for (int i = 1; i < index; i++) {
            if (index + i == map[0].length || index - i - 1 < 0) {
                return diffCount==1;
            }
            for (int j = 0; j < map.length; j++) {
                if (map[j][index + i] != map[j][index - i - 1]) {
                    diffCount++;
                }
                if (diffCount>1){
                    return false;
                }
            }
        }
        return diffCount==1;
    }
}

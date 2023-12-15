package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D13 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] parts = content.split("\r\n\r\n");
        int score = 0;
        for (int k = 0; k < parts.length; k++) {
            String[] lines = parts[k].split("\r\n");
            D13 game = new D13();
            char[][] map = new char[lines.length][];
            for (int i = 0; i < lines.length; i++) {
                map[i] = lines[i].toCharArray();
            }
            //print map
            for (int i = 0; i < map.length; i++) {
                System.out.println(map[i]);
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
            if (Arrays.equals(map[i], map[i - 1])) {
                if (validateHorizontalReflection(map, i)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int fineVerticalReflection(char[][] map) {
        for (int i = 1; i < map[0].length; i++) {
            boolean equal = true;
            for (int j = 0; j < map.length; j++) {
                if (map[j][i] != map[j][i - 1]) {
                    equal = false;
                    break;
                }
            }
            if (equal && validateVerticalReflection(map, i)) {
                return i;
            }
        }
        return -1;
    }

    public boolean validateHorizontalReflection(char[][] map, int index) {
        for (int i = 1; i < index; i++) {
            if (index + i == map.length || index - i - 1 < 0) {
                return true;
            }
            if (!Arrays.equals(map[index + i], map[index - i - 1])) {
                return false;
            }
        }
        return true;
    }

    public boolean validateVerticalReflection(char[][] map, int index) {
        for (int i = 1; i < index; i++) {
            if (index + i == map[0].length || index - i - 1 < 0) {
                return true;
            }
            for (int j = 0; j < map.length; j++) {
                if (map[j][index + i] != map[j][index - i - 1]) {
                    return false;
                }
            }
        }
        return true;
    }
}

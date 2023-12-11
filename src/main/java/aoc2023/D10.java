package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D10 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\r\n");
        //get map
        char[][] map = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            map[i] = lines[i].toCharArray();
        }
        //print map
        for (int y = 0; y < map.length; y++) {//y
            for (int x = 0; x < map[y].length; x++) {//x
                System.out.print(map[y][x]);
            }
            System.out.println();
        }
        D10 game = new D10();
        String startPoint = game.findStartPoint(map);
        System.out.println(startPoint + " S");
        String prePoint = startPoint;
        String firstMovePoint = "99,90";
        System.out.println(firstMovePoint + " " + map[99][90]);
        int sum = 0 ;
        while (firstMovePoint != null) {
            String tempPoint = firstMovePoint;
            firstMovePoint = game.findNextPoint(firstMovePoint, prePoint, map);
            prePoint = tempPoint;
//            System.out.println(firstMovePoint);
            sum++;
        }
        System.out.println(sum);
    }

    private String findStartPoint(char[][] map) {
        for (int i = 0; i < map.length; i++) {//y
            for (int j = 0; j < map[i].length; j++) {//x
                if (map[i][j] == 'S') {
                    return String.format("%s,%s", i, j);
                }
            }
        }
        return null;
    }

    private String findNextPoint(String position, String prePosition, char[][] map) {
        String[] positionArray = position.split(",");
        int y = Integer.parseInt(positionArray[0]);
        int x = Integer.parseInt(positionArray[1]);
        String[] prePositionArray = prePosition.split(",");
        int pre_y = Integer.parseInt(prePositionArray[0]);
        int pre_x = Integer.parseInt(prePositionArray[1]);
        String result = null;
        if (map[y][x] == '|') {//vertical
            if (y > pre_y) {//down
                result = String.format("%s,%s", y + 1, x);
            } else {//up
                result = String.format("%s,%s", y - 1, x);
            }
        } else if (map[y][x] == '-') {//horizontal
            if (x > pre_x) {//right
                result = String.format("%s,%s", y, x + 1);
            } else {//left
                result = String.format("%s,%s", y, x - 1);
            }
        } else if (map[y][x] == 'L') {//90-degree bend connecting north and east
            if (y > pre_y) {//down
                result = String.format("%s,%s", y, x + 1);
            } else {//up
                result = String.format("%s,%s", y - 1, x);
            }
        } else if (map[y][x] == 'J') {//90-degree bend connecting north and west
            if (y > pre_y) {//down
                result = String.format("%s,%s", y, x - 1);
            } else {//up
                result = String.format("%s,%s", y -1 , x);
            }
        } else if (map[y][x] == 'F') {//90-degree bend connecting south and east
            if (y < pre_y) {//down
                result = String.format("%s,%s", y, x + 1);
            } else {//up
                result = String.format("%s,%s", y + 1, x);
            }
        } else if (map[y][x] == '7') {//90-degree bend connecting south and west
            if (y < pre_y) {//down
                result = String.format("%s,%s", y, x - 1);
            } else {//up
                result = String.format("%s,%s", y + 1, x);
            }
        }
        //print position & map[y][x]
        if(result!=null){
            String[] resultPositionArray = result.split(",");
            int result_y = Integer.parseInt(resultPositionArray[0]);
            int result_x = Integer.parseInt(resultPositionArray[1]);
            System.out.println(result + " " + map[result_y][result_x]);
        }

        return result;
    }
}

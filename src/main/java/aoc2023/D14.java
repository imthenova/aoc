package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class D14 {
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
        D14 game = new D14();
    }
}

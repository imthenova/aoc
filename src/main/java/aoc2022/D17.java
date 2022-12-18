package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D17 {
    static String PATH = "/Users/marmao/Documents/input"+"2";
    static int[][] ROCK1 = {{0,0,1,1,1,1,0}};
    static int[][] ROCK2 = {{0,0,0,1,0,0,0},{0,0,1,1,1,0,0},{0,0,0,1,0,0,0}};
    static int[][] ROCK3 = {{0,0,0,0,1,0,0},{0,0,0,0,1,0,0},{0,0,1,1,1,0,0}};
    static int[][] ROCK4 = {{0,0,1,0,0,0,0},{0,0,1,0,0,0,0},{0,0,1,0,0,0,0},{0,0,1,0,0,0,0}};
    static int[][] ROCK5 = {{0,0,1,1,0,0,0},{0,0,1,1,0,0,0}};
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\n")).toList();
        int totalScore = 0;
        D17 d2 = new D17();
        d2.printRock(ROCK1);
        d2.printRock(ROCK2);
        d2.printRock(ROCK3);
        d2.printRock(ROCK4);
        d2.printRock(ROCK5);

        System.out.println(totalScore);
    }

    public void printRock(int[][] rock){
        for (int i = 0; i < rock.length; i++) {
            for (int j = 0; j < rock[i].length; j++) {
                if(rock[i][j]==0){
                    System.out.print(".");
                }else{
                    System.out.print("@");
                }
            }
            System.out.println();
        }
        System.out.println("---------");
    }


}

package aoc2022;

import bo.RockBO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D17 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    static public int INDEX = 0;
    static public List<int[][]> ROCK_LIST = new ArrayList<>();
    static final int[][] ROCK1 = {{0,0,1,1,1,1,0}};
    static final int[][] ROCK2 = {{0,0,0,1,0,0,0},{0,0,1,1,1,0,0},{0,0,0,1,0,0,0}};
    static final int[][] ROCK3 = {{0,0,1,1,1,0,0},{0,0,0,0,1,0,0},{0,0,0,0,1,0,0}};
    static final int[][] ROCK4 = {{0,0,1,0,0,0,0},{0,0,1,0,0,0,0},{0,0,1,0,0,0,0},{0,0,1,0,0,0,0}};
    static final int[][] ROCK5 = {{0,0,1,1,0,0,0},{0,0,1,1,0,0,0}};
    static public int[][] ROCK_MAP = new int[4000][7];
    public static void main(String[] args) throws IOException {
        ROCK_LIST.add(ROCK1);
        ROCK_LIST.add(ROCK2);
        ROCK_LIST.add(ROCK3);
        ROCK_LIST.add(ROCK4);
        ROCK_LIST.add(ROCK5);
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n")).toList();
        int totalScore = 0;
        D17 d2 = new D17();
//        d2.printRock(ROCK1);
//        d2.printRock(ROCK2);
//        d2.printRock(ROCK3);
//        d2.printRock(ROCK4);
//        d2.printRock(ROCK5);
        RockBO rockBO = new RockBO();

        rockBO.init();
        d2.printRock(rockBO.getPosition());
        rockBO.fall();
        d2.printRock(rockBO.getPosition());
        rockBO.fall();
        d2.printRock(rockBO.getPosition());
        rockBO.fall();
        d2.printRock(rockBO.getPosition());
    }

    public void printRock(int[][] rock){
        for (int i = rock.length-1; i >= 0; i--) {
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

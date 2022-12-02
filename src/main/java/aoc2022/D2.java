package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D2 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n")).toList();
        int totalScore = 0;
        D2 d2 = new D2();
        for (String round:roundList) {
            totalScore += d2.calcScore(round.charAt(0),round.charAt(2));
        }

        System.out.println(totalScore);
    }

    public int calcScore(char enemy, char self){
        int diff = (int)self-(int) enemy;
        int score = 0;
        int bon = (int)self-87;
        if (diff==23){
            //draw
            score=3;
        }else if(diff==24 || diff==21){
            //win
            score=6;
        }else{
            //lose
            score=0;
        }
        System.out.println(score+bon);
        return score+bon;

    }

}

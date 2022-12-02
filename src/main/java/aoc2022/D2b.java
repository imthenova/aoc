package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D2b {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n")).toList();
        int totalScore = 0;
        D2b d2 = new D2b();
        for (String round:roundList) {
            totalScore += d2.calcScore(round.charAt(0),
                    d2.calcSelf(round.charAt(0),round.charAt(2))
            );
        }
        System.out.println(totalScore);
    }
    public char calcSelf(char enemy, char strategy){
        char self;
        int diff = 23;
        if(strategy=='X'){
            diff=25;
        }else if(strategy=='Z'){
            diff=24;
        }
        int selfInt = enemy+diff;
        if(selfInt - (int)'Z' == 1){
            self='X';
        }else if(selfInt - (int)'Z' == 2){
            self='Y';
        }else{
            self = (char)selfInt;
        }
        return self;
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
        return score+bon;

    }

}

package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D5 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        int lineNumber = 3;
        int rowNumber = 3;
        List<String> parts = Arrays.stream(content.split("\r\n\r\n")).toList();
        List<String> rowList = Arrays.stream(parts.get(0).split("\r\n")).toList();
        Map<Integer,Stack> stackMap = new HashMap();
        for (int i = 0; i < rowList.size(); i++) {

            String row = rowList.get(i);
            for (int j = 1; j < row.length(); j+=4) {
                Stack stack = stackMap.get(j);
                if(stack==null){
                    stack = new Stack();
                    stackMap.put(j,new Stack());
                }
                if(row.charAt(j)!=' '){
                    stack.push(row.charAt(j));
                    System.out.println(row.charAt(j));
                }
            }
        }
        int totalScore = 0;
        D5 d2 = new D5();

//        System.out.println(totalScore);
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

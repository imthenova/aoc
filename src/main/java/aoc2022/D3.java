package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D3 {
    static String PATH = "/Users/marmao/Documents/input"+"3";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\n")).toList();
        D3 d3 = new D3();
        int totalScore = 0;
        for (int i = 0; i <roundList.size() ; i+=3) {
            char sameChar = d3.getSameChar(roundList,i);
//            System.out.println(sameChar);
            int score = d3.getScore(sameChar);
//            System.out.println(score);
            totalScore+=score;
        }
        System.out.println(totalScore);
    }
    char getSameChar(List<String> roundList, int index){
        String row = roundList.get(index);
        String row2 = roundList.get(index+1);
        String row3 = roundList.get(index+2);
        char sameChar = 0;
        for (int i = 0; i < row.length(); i++) {
            for (int j = 0; j < row2.length(); j++) {
                if(row.charAt(i)==row2.charAt(j)){
                    for (int k = 0; k < row3.length(); k++) {
                        if (row.charAt(i)==row3.charAt(k)){
                            sameChar =   row.charAt(i);
                            break;
                        }
                    }
                }
            }

        }
        return sameChar;
    }
    int getScore(char a){
        int score = a-96;
        if(score<0){
            score=a-64+26;
        }
        return score;
    }

}

package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class D10b {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input" + "2";
    static int current_score = 1;
    static int step = 0;

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = new ArrayList<>();
        String[] strs = content.split("\r\n");
        for (int i = 0; i < strs.length; i++) {
            roundList.add(strs[i]);
        }
        for (int i = roundList.size() - 1; i >= 0; i--) {
            if (roundList.get(i).startsWith("addx")) {
                roundList.add(i, "noop");
            }
        }
        for (int i = 0; i < roundList.size(); i++) {
//            System.out.println(roundList.get(i));
        }
        char[] chars = new char[240];
        chars[0]='#';
        for (int i = 1; i < 240; i++) {
            step++;
            if(step%40==0){
                current_score+=40;
            }
            if(Math.abs(current_score-step)<=1){
                chars[i]='#';
            }else{
                chars[i]='.';
            }

            move(roundList);
        }
        for (int i = 0; i < 240; i++) {
            if(i%40==0){
                System.out.println();
            }
            System.out.print(chars[i]);

        }
    }

    public static void move(List<String> roundList) {
        if (roundList.get(step).startsWith("addx")) {
            current_score += Integer.parseInt(roundList.get(step).split(" ")[1]);
        }

    }


}

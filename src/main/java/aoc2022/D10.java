package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D10 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input" + "2";

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
        int score = 0;
        score += calcScoreAtStep(20, roundList);
        score += calcScoreAtStep(60, roundList);
        score += calcScoreAtStep(100, roundList);
        score += calcScoreAtStep(140, roundList);
        score += calcScoreAtStep(180, roundList);
        score += calcScoreAtStep(220, roundList);
        System.out.println(score);
    }

    public static int calcScoreAtStep(int step, List<String> roundList) {
        int score = 1;
        for (int i = 0; i < step-1; i++) {
//            System.out.println(roundList.get(i));
            if (roundList.get(i).startsWith("addx")) {
                score += Integer.parseInt(roundList.get(i).split(" ")[1]);
            }
        }
        return score * step;
    }


}

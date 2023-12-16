package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D18 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input" + "2";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n")).toList();
        int count = 0;
        D18 d18 = new D18();
        for (int i = 0; i < roundList.size() - 1; i++) {
            for (int j = i; j < roundList.size(); j++) {
                if (d18.isConnected(roundList.get(i), roundList.get(j))) {
                    count++;
                }
            }
        }
        System.out.println(roundList.size() * 6 - count * 2);
    }

    public boolean isConnected(String aStr, String bStr) {
        String[] aStrs = aStr.split(",");
        String[] bStrs = bStr.split(",");
        StringBuilder newStr = new StringBuilder();
        int[] numbers = new int[3];
        int count = 0;
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(aStrs[i]) - Integer.parseInt(bStrs[i]);
            newStr.append(numbers[i]);
            if (i < 2) {
                newStr.append(",");
            }
            if (numbers[i] == 0) {
                count++;
            }
        }
        if (count == 2) {
            int sum = Math.abs(Arrays.stream(Arrays.stream(numbers).toArray()).sum());
            if (sum == 1) {
                return true;
            }
        }
        return false;
    }

}

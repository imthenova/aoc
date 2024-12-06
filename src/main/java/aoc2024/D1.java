package aoc2024;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D1 {
    static final String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> records = Arrays.asList(content.split("\n"));
        int sum = 0;
        long sum2 = 0;
        List<Integer> leftList = new ArrayList<>();
        List<Integer> rightList = new ArrayList<>();
        Map<Integer,Integer> leftMap = new HashMap<>();
        Map<Integer,Integer> rightMap = new HashMap<>();

        for (String record : records) {
            String[] recordParts = record.trim().split("\\s+");
            int leftNumber = Integer.parseInt(recordParts[0]);
            int rightNumber = Integer.parseInt(recordParts[1]);
            leftMap.put(leftNumber,leftMap.getOrDefault(leftNumber,0)+1);
            rightMap.put(rightNumber,rightMap.getOrDefault(rightNumber,0)+1);
            leftList.add(leftNumber);
            rightList.add(rightNumber);
        }
        for (Map.Entry<Integer, Integer> leftEntry : leftMap.entrySet()) {
            int key = leftEntry.getKey();
            int leftExistTimes = leftEntry.getValue();
            int matchTimes = rightMap.getOrDefault(key,0);
            sum2 += key * matchTimes * leftExistTimes;
        }

        leftList.sort(Integer::compareTo);
        rightList.sort(Integer::compareTo);

        for (int i = 0; i < leftList.size(); i++) {
            sum += Math.abs(leftList.get(i) - rightList.get(i));
        }
        System.out.println(sum);
        System.out.println(sum2);

    }
}

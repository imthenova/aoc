package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D8b {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input2";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> rows = Arrays.stream(content.split("\r\n")).toList();
        int size = 99;
//        int size = 5;
        boolean[][] booleans = new boolean[size][size];
        int[][] sees = new int[size][size];
        int[][] heights = new int[size][size];
        Map<String, Long> seeMap = new HashMap<>();
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                booleans[i][j] = true;
//            }
//        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                heights[i][j] = Integer.parseInt(rows.get(i).charAt(j) + "");
            }
        }

        for (int i = 1; i < size-1; i++) {
            for (int j = 1; j < size-1; j++) {
                if(i==27 && j==14){
                    System.out.println(123);
                }
                //scan left
                for (int k = j-1; k >= 0; k--) {
                    if(heights[i][k]>=heights[i][j] || k==0){
                        seeMap.put(i+","+j,(long)j-(long)k);
                        break;
                    }
                }
                //scan top
                for (int k = i-1; k >= 0; k--) {
                    if(heights[k][j]>=heights[i][j] || k==0){
                        seeMap.put(i+","+j,(i-k)*seeMap.get(i+","+j));
                        break;
                    }
                }
                //scan right
                for (int k = j+1; k <= size-1; k++) {
                    if(heights[i][k]>=heights[i][j] || k==size-1){
                        seeMap.put(i+","+j,(k-j)*seeMap.get(i+","+j));
                        break;
                    }
                }
                //scan bottom
                for (int k = i+1; k <= size-1; k++) {
                    if(heights[k][j]>=heights[i][j] || k==size-1){
                        seeMap.put(i+","+j,(k-i)*seeMap.get(i+","+j));
                        break;
                    }
                }
            }
        }
        System.out.println(seeMap.values().stream().max(Long::compare));
        for (Map.Entry<String,Long> entry:seeMap.entrySet()
             ) {
//            if (entry.getValue()>=108864){
            if (entry.getValue()>=58864){
                System.out.println(entry.getKey()+"  "+entry.getValue());
            }
        }
    }
}

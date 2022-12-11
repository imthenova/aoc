package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D8 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> rows = Arrays.stream(content.split("\r\n")).toList();
        int size = 99;
        boolean[][] booleans = new boolean[size][size];
        int[][] heights = new int[size][size];
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                booleans[i][j] = true;
//            }
//        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                heights[i][j] = Integer.parseInt(rows.get(i).charAt(j)+"");
            }           
        }
        //scan left
        for (int i = 0; i < size; i++) {
            int tallestLeft = -1;
            for (int j = 0; j < size; j++) {
//                if(!booleans[i][j]){
                    if(tallestLeft<heights[i][j]){
                        tallestLeft = heights[i][j];
                        booleans[i][j] = true;
                    }
//                }
            }
        }
        int back = size-1;
        for (int i = 0; i < size; i++) {
            int tallestRight = -1;
            for (int j = 0; j < size; j++) {
//                if(!booleans[back-i][back-j]){
                    if(tallestRight<heights[back-i][back-j]){
                        tallestRight = heights[back-i][back-j];
                        booleans[back-i][back-j] = true;
                    }
//                }
            }
        }

//        scan top
        for (int i = 0; i < size; i++) {
            int tallestTop = -1;
            for (int j = 0; j < size; j++) {
//                if(!booleans[j][i]){
                    if(tallestTop<heights[j][i]){
                        tallestTop = heights[j][i];
                        booleans[j][i] = true;
                    }
//                }
            }
        }


        for (int i = 0; i < size; i++) {
            int tallestRight = -1;
            for (int j = 0; j < size; j++) {
//                if(!booleans[back-i][back-j]){
                if(tallestRight<heights[back-j][back-i]){
                    tallestRight = heights[back-j][back-i];
                    booleans[back-j][back-i] = true;
                }
//                }
            }
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(booleans[i][j]) {
//                    System.out.print("1");
                    count++;
                }
                else{
//                    System.out.print('_');
                }
            }
//            System.out.println();
        }
        System.out.println(count);
    }
}

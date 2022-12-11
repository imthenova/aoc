package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D6 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < content.length()-13; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 14; j++) {
                set.add(content.charAt(i+j));
            }

            if(set.size()==14){
                System.out.println(i+13+1);
                break;
            }
        }
    }


}

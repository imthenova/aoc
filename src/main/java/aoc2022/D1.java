package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D1 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input1";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> elfList = Arrays.stream(content.split("\r\n\r\n")).toList();
        int max = 0;
        List<Integer> sumList = new ArrayList<>();
        for (String elf:elfList) {
            int sum = Arrays.stream(elf.split("\r\n")).mapToInt(x->Integer.parseInt(x)).sum();
            if(sum>max){
                max=sum;
            }
            sumList.add(sum);
        }
        sumList.sort(Integer::compare);
        for (int i = 0; i < sumList.size(); i++) {
            System.out.println(sumList.get(i));
        }
        System.out.println(71023+68034+67232);
    }
}

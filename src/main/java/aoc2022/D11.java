package aoc2022;

import bo.MoneyBO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D11 {
    static String PATH = "/Users/marmao/Documents/input"+"2";
    public static List<MoneyBO> moneyBOS = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\n\n")).toList();
        for (int i = 0; i < roundList.size(); i++) {
            MoneyBO moneyBO = new MoneyBO(roundList.get(i));
            moneyBOS.add(moneyBO);
        }
        for (int j = 0; j < 400; j++) {
            for (int i = 0; i < moneyBOS.size(); i++) {
                moneyBOS.get(i).test();
            }
            for (int i = 0; i < moneyBOS.size(); i++) {
                System.out.println("Monkey "+i+": "+moneyBOS.get(i));
            }
        }

        for (int i = 0; i < moneyBOS.size(); i++) {
            System.out.println("Monkey "+i+": "+moneyBOS.get(i).inspectTimes);
        }
    }



}

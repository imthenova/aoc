package aoc2022;

import bo.MoneyBO;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D11 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n\r\n")).toList();
        List<MoneyBO> moneyBOS = new ArrayList<>();
        for (int i = 0; i < roundList.size(); i++) {
            MoneyBO moneyBO = new MoneyBO(roundList.get(0));
            moneyBOS.add(moneyBO);
        }
        System.out.println(moneyBOS);
    }



}

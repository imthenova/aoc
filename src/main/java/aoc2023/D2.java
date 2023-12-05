package aoc2023;

import bo.Game_D2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D2 {
    static String PATH = "/Users/marmao/Documents/aoc/input";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> records = Arrays.stream(content.split("\n")).toList();
        int sum = 0;
        for (String record : records) {
            Game_D2 game = new Game_D2(record);
            sum += game.highestNumber();
        }
        System.out.println(sum);


    }
}

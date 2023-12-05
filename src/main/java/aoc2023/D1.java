package aoc2023;

import aoc2022.D17;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D1 {
    static String PATH = "/Users/marmao/Documents/aoc/input";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> records = Arrays.stream(content.split("\n")).toList();
        int sum = 0;
        for (String record : records) {
            String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
            //find from the end
            int lastIndex = -1;
            String lastNumber = null;
            for (String number : numbers) {
                int currentIndex = record.lastIndexOf(number);
                if (currentIndex > lastIndex) {
                    lastIndex = currentIndex;
                    lastNumber = number;
                }
            }
            //find from the start
            int firstIndex = 999999999;
            String firstNumber = null;
            for (String number : numbers) {
                int currentIndex = record.indexOf(number);
                if (currentIndex > -1 && currentIndex < firstIndex) {
                    firstIndex = currentIndex;
                    firstNumber = number;
                }
            }

            System.out.print(record + " ");

            String result = replaceNumbers(firstNumber);
            result += replaceNumbers(lastNumber);


            //print the start
            if (firstIndex != 999999999) {
                System.out.print("Found: " + firstNumber);
            } else {
                System.out.print("Not Found");
            }
            //print the end
            if (lastIndex != -1) {
                System.out.print("  Found: " + lastNumber);
            } else {
                System.out.print("Not Found");
            }
            System.out.println("  result: " + result);
            sum+=Integer.parseInt(result);
        }
        System.out.println(sum);

    }

    public static String replaceNumbers(String input) {
        String[] words = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] digits = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        for (int i = 0; i < words.length; i++) {
            input = input.replace(words[i], digits[i]);
        }

        return input;
    }
}

package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\r\n");
        D9 game = new D9();
        BigInteger bi = new BigInteger("0");
        for (int i = 0; i < lines.length; i++) {
            //split each line into a list of integers
            List<Integer> integerList = new ArrayList<>();
            String[] numbers = lines[i].split(" ");
            for (String number : numbers) {
                integerList.add(Integer.parseInt(number));
            }
            int result = game.predictNextNumber(integerList,0);
//            System.out.println(result);
            bi = bi.add(new BigInteger(String.valueOf(result)));

        }
        System.out.println(bi);
    }
    private boolean validateZero(List<Integer> integerList) {
        //check if all numbers are zero
        for (Integer integer : integerList) {
            if (integer != 0) {
                return false;
            }
        }
        return true;
    }

    private int predictNextNumber(List<Integer> integerList,int sum) {
        //predict Next Number
        List<Integer> diffList = new ArrayList<>();
        for (int i = 0; i < integerList.size() - 1; i++) {
            diffList.add(integerList.get(i + 1) - integerList.get(i));
        }
        if (!validateZero(diffList)) {
            return integerList.get(0) - predictNextNumber(diffList,sum);
        }
        return integerList.get(0) - diffList.get(0);

    }


}

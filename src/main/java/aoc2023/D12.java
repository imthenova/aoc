package aoc2023;

import bo2023.MapInstruction;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.*;

public class D12 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";
    static BigInteger COUNT = BigInteger.valueOf(0);
    static int eachCount = 0;
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> strList = Arrays.stream(content.split("\r\n")).toList();
        D12 game = new D12();
        List<Integer> eachCountList = new ArrayList<>();
        List<Integer> unfoldedCountList = new ArrayList<>();
        for (int i = 0; i < strList.size(); i++) {
            String rawRow = strList.get(i);

            eachCount = 0;
            game.generateCombinations(rawRow,0,"");
            eachCountList.add(eachCount);

            rawRow = game.unfold(rawRow);
//            System.out.println(rawRow);
            eachCount = 0;
            game.generateCombinations(rawRow,0,"");
            unfoldedCountList.add(eachCount);

            System.out.println(i);
        }
        for (int i = 0; i < eachCountList.size(); i++) {
            BigInteger bigInteger = BigInteger.valueOf(unfoldedCountList.get(i)/eachCountList.get(i));
            bigInteger = bigInteger.pow(4).multiply(BigInteger.valueOf(eachCountList.get(i)));
            System.out.println(eachCountList.get(i)+" "+bigInteger);
            COUNT = COUNT.add(bigInteger);
        }
        System.out.println(COUNT);
    }
    private boolean validate(String str){
        String[] parts = str.split(" ");
        String content = parts[0];
        String amount = parts[1];
        String[] contentList = Arrays.stream(content.split("\\.")).filter(s->!s.isEmpty()).toArray(String[]::new);
        String[] amountList = amount.split(",");
        if (contentList.length!= amountList.length){
            return false;
        } else{
            for (int i = 0; i < contentList.length; i++) {
                if(contentList[i].length() != Integer.parseInt(amountList[i]) ){
                    return false;
                }
            }
        }
        return true;
    }

    public void generateCombinations(String input, int index, String current) {
        if (index == input.length()) {
            if(validate(current)){
//                COUNT++;
                eachCount++;
//                System.out.println(current);
            }
            return;
        }

        if (input.charAt(index) == '?') {
            generateCombinations(input, index + 1, current + '.');
            generateCombinations(input, index + 1, current + '#');
        } else {
            generateCombinations(input, index + 1, current + input.charAt(index));
        }
    }
    public String unfold(String str){
        String[] parts = str.split(" ");
        String result = "";
        String resultAmount = "";
        String content = parts[0];
        String amount = parts[1];
        //content = 5 times content
        for (int i = 0; i < 2; i++) {
            result+="?"+content;
            resultAmount+=","+amount;
        }
        //delete the first char in resultAmount
        result = result.substring(1);
        resultAmount = resultAmount.substring(1);
        return result+" "+resultAmount;
    }
}

package aoc2023;

import bo2023.CamelCards;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class D7 {
    static String PATH = "/Users/marmao/Documents/aoc/input";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\n");
        List<CamelCards> camelCardsList = new ArrayList<>();
        //print lines
        for (String line : lines) {
            CamelCards camelCards = new CamelCards(line);
            camelCardsList.add(camelCards);
//            System.out.println(camelCards);
        }
        Collections.sort(camelCardsList);
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < camelCardsList.size(); i++) {
            camelCardsList.get(i).setRank(i+1);
            System.out.println(camelCardsList.get(i));
            sum = sum.add(camelCardsList.get(i).getScore());
        }
        System.out.println(sum);

    }
}

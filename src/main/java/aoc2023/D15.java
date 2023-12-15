package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class D15 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        D15 game = new D15();
        String content = FileUtils.readFileToString(new File(PATH));
        String[] parts = content.split(",");
        //loop parts and sum calcHash(part)
        /*
        int sum = 0;
        for (int i = 0; i < parts.length; i++) {
            sum += game.calcHash(parts[i]);
            System.out.println(sum);
        }*/
        System.out.println("rn," + game.calcHash("rn"));
        System.out.println("cm," + game.calcHash("cm"));
        //qp
        System.out.println("qp," + game.calcHash("qp"));
        //pc
        System.out.println("pc," + game.calcHash("pc"));
        //ot
        System.out.println("ot," + game.calcHash("ot"));
        //ab
        System.out.println("ab," + game.calcHash("ab"));

    }
    public long calcHash(String s){
        long hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
            hash *= 17;
            hash %= 256;
        }
        return hash;
    }


}

package aoc2023;

import bo2023.MapInstruction;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class D8p2 {
    public static void main(String[] args) throws IOException {
        BigInteger[] bigIntegers = {new BigInteger("32542"),new BigInteger("48506"),new BigInteger("26402"),new BigInteger("28858"),new BigInteger("36226"),new BigInteger("44822")};
        BigInteger[] bigDiffs = {new BigInteger("16324"),new BigInteger("24332"),new BigInteger("13244"),new BigInteger("14476"),new BigInteger("18172"),new BigInteger("22484")};
        String str = ".###...##..#";
        String[] strs = Arrays.stream(str.split("\\.")).filter(s->!s.isEmpty()).toArray(String[]::new);
        System.out.println(Arrays.toString(strs));

//        while (!new D8p2().allEqual(bigIntegers)){
//            for (int i = 0; i < bigIntegers.length; i++) {
//                bigIntegers[i] = bigIntegers[i].add(bigDiffs[i]);
//            }
//            System.out.println(bigIntegers[0]);
//        }
//        System.out.println(bigIntegers[0]);
    }
    public boolean allEqual(BigInteger[] bigIntegers){
        //return all euqal or not
        for (int i = 0; i < bigIntegers.length-1; i++) {
            if(!bigIntegers[i].equals(bigIntegers[i+1])){
                return false;
            }
        }
        return true;
    }
}

package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class BNP {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\BFEP2.UOSS3.K0416140.D231208.T130015.S001";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\n");
        System.out.println(lines);
    }
}

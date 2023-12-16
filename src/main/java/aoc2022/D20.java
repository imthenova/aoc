package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D20 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input" + "2";

    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> roundList = Arrays.stream(content.split("\r\n")).toList();
        List<String> reOrderList = new ArrayList<String>();
        roundList.stream().forEachOrdered(n -> reOrderList.add(n));
        D20 d20 = new D20();
//        for (int j = 0; j < reOrderList.size(); j++) {
//            if(j==reOrderList.size()-1){
//                System.out.print(reOrderList.get(j));
//            }else {
//                System.out.print(reOrderList.get(j) + ", ");
//            }
//
//        }
        System.out.println();
        for (int i = 0; i < roundList.size(); i++) {
            d20.move(roundList.get(i),reOrderList);
//            for (int j = 0; j < reOrderList.size(); j++) {
//                if(j==reOrderList.size()-1){
//                    System.out.print(reOrderList.get(j));
//                }else {
//                    System.out.print(reOrderList.get(j) + ", ");
//                }
//            }
//            System.out.println();
        }


        System.out.println();
        int index0 = d20.find("0",reOrderList);
//        System.out.println(index0);
        int index1000 = 1000%reOrderList.size()+index0;
        index1000%=reOrderList.size();
        int v1 = Integer.parseInt(reOrderList.get(index1000));
        System.out.println(v1);

        int index2000 = 2000%reOrderList.size()+index0;
        index2000%=reOrderList.size();
        int v2 = Integer.parseInt(reOrderList.get(index2000));
        System.out.println(v2);

        int index3000 = 3000%reOrderList.size()+index0;
        index3000%=reOrderList.size();
        int v3 = Integer.parseInt(reOrderList.get(index3000));
        System.out.println(v3);

        System.out.println(v1+v2+v3);
    }

    public void move(String n, List<String> reOrderList) {
        int index = find(n, reOrderList);
        int newIndex = index + Integer.parseInt(n);
        newIndex %= reOrderList.size()-1;
//        if (newIndex >= reOrderList.size()-1) {
//            newIndex+=newIndex/reOrderList.size();
//        }
        if (newIndex < 0) {
            newIndex += reOrderList.size() - 1;
        }
        if(Integer.parseInt(n)<0 && newIndex==0){
            newIndex += reOrderList.size() - 1;
        }
        if(Integer.parseInt(n)>0 && newIndex==reOrderList.size() - 1){
            newIndex = 0;
        }

        reOrderList.remove(index);
        reOrderList.add(newIndex, n);
    }

    public int find(String n, List<String> reOrderList) {
        for (int i = 0; i < reOrderList.size(); i++) {
            if (reOrderList.get(i).equals(n)) {
                return i;
            }
        }
        return -1;
    }
}

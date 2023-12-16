package aoc2023;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D15 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";

    public static void main(String[] args) throws IOException {
        D15 game = new D15();
        String content = FileUtils.readFileToString(new File(PATH));
        String[] parts = content.split(",");
        List<HashMap<String, Integer>>[] boxes = new List[256];
        //init boxes with empty list
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = new ArrayList<>();
        }
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            char operation;
            int lens=-1;
            int index;
            String key;
            if (part.indexOf("-") > 0) {
                operation = part.charAt(part.length() - 1);
                index = game.calcHash(part.substring(0, part.length() - 1));
                key = part.substring(0, part.length() - 1);

                System.out.print(key);
                System.out.print(operation);
                System.out.print(",index=" + index);
                System.out.println();
            } else {
                lens = Integer.parseInt(part.substring(part.length() - 1));
                operation = part.charAt(part.length() - 2);
                index = game.calcHash(part.substring(0, part.length() - 2));
                key = part.substring(0, part.length() - 2);
                System.out.print(key);
                System.out.print(operation);
                System.out.print(lens);
                System.out.print(",index=" + index);
                System.out.println();
            }
            Object obj = null;
            List<HashMap<String, Integer>> box = boxes[index];
            //loop box find Map.key=key
            for (int j = 0; j < box.size(); j++) {
                Map<String, Integer> map = box.get(j);
                if (map.containsKey(key)) {
                    obj = map;
                    break;
                }
            }
            if(operation=='-'){
                if (obj != null) {
                    //remove obj from box
                    box.remove(obj);
                }
            }else{
                if (obj == null) {
                    //add new map to box
                    HashMap<String, Integer> map = new HashMap<>();
                    map.put(key,lens);
                    box.add(map);
                }else{
                    //update obj
                    Map<String, Integer> map = (Map<String, Integer>) obj;
                    map.put(key,lens);
                }
            }


        }
        System.out.println(boxes);
        long sum = 0;
        for (int i = 0; i < boxes.length; i++) {
            List<HashMap<String, Integer>> box = boxes[i];
            for (int j = 0; j < box.size(); j++) {
                Map<String, Integer> map = box.get(j);
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    sum += (i+1) * (j+1) * entry.getValue();
                }
            }
        }
        System.out.println(sum);
    }


    public int calcHash(String s) {
        int hash = 0;
        for (int i = 0; i < s.length(); i++) {
            hash += s.charAt(i);
            hash *= 17;
            hash %= 256;
        }
        return hash;
    }


}

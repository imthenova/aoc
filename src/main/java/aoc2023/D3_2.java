package aoc2023;

import bo.NumberPosition_D3;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class D3_2 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input.txt";
    static List<String> startPositionList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int sum = 0;
        String content = FileUtils.readFileToString(new File(PATH));
        String[] lines = content.split("\n");
        char[][] map = new char[lines.length][];
        for (int i = 0; i < lines.length; i++) {
            map[i] = lines[i].toCharArray();
        }
        List<String> gearStrList = Arrays.stream(content.split("\r\n")).toList();
        for (int i = 0; i < gearStrList.size(); i++) {
            int index = 0;
            while (gearStrList.get(i).indexOf('*', index) > -1) {
                String position = String.format("%s,%s", i, gearStrList.get(i).indexOf('*', index));
                startPositionList.add(position);
                index = gearStrList.get(i).indexOf('*', index) + 1;
            }
        }
        //print startPositionList
        for (String position : startPositionList) {
            String allowString = "0123456789";
            String[] positionArray = position.split(",");
            int x = Integer.parseInt(positionArray[0]);
            int y = Integer.parseInt(positionArray[1]);
            int count = 0;
            Set<String> positionSet = new HashSet<>();
            for (int i = Math.max(0, x - 1); i <= Math.min(map.length - 1, x + 1); i++) {
                for (int j = Math.max(0, y - 1); j <= Math.min(map[i].length - 1, y + 1); j++) {
                    if (i == x && y == j) {
                        continue;
                    }
                    if (allowString.indexOf(map[i][j]) > -1) {
                        count++;
                        positionSet.add("" + i + "," + j);
                    }
                }
            }
            if (count >= 2) {
                Set<String> tempSet = new HashSet<>();
                for (String positionStr : positionSet) {
                    String[] parts = positionStr.split(",");
                    int i = Integer.parseInt(parts[0]);
                    int j = Integer.parseInt(parts[1]);
                    if (j > 0 && allowString.indexOf(map[i][j - 1]) > -1) {
                        tempSet.add(i + "," + (j - 1));
                        //one step lefter
                        if (j - 1 > 0 && allowString.indexOf(map[i][j - 2]) > -1) {
                            tempSet.add(i + "," + (j - 2));
                            //one step lefter
                            if (j - 2 > 0 && allowString.indexOf(map[i][j - 3]) > -1) {
                                tempSet.add(i + "," + (j - 3));
                            }
                        }
                    }
                    if (j < map[i].length - 1 && allowString.indexOf(map[i][j + 1]) > -1) {
                        tempSet.add(i + "," + (j + 1));
                        //one step righter
                        if (j < map[i].length - 2 && allowString.indexOf(map[i][j + 2]) > -1) {
                            tempSet.add(i + "," + (j + 2));
                            //one step righter
                            if (j < map[i].length - 3 && allowString.indexOf(map[i][j + 3]) > -1) {
                                tempSet.add(i + "," + (j + 3));
                            }
                        }
                    }
                }
                positionSet.addAll(tempSet);

                List<String> list = positionSet.stream().collect(Collectors.toCollection(ArrayList::new));
                Collections.sort(list, new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        int result = o1.split(",")[0].compareTo(o2.split(",")[0]);
                        if (result == 0) {
                            result = o1.split(",")[1].compareTo(o2.split(",")[1]);
                        }
                        return result;
                    }

                });
                int xPrint = -1;
                int yPrint = -1;
                StringBuilder sb = new StringBuilder();
                for (String str : list) {
                    //print map value at position
                    if (xPrint != -1 && xPrint != Integer.parseInt(str.split(",")[0])
                            || yPrint != -1 && Integer.parseInt(str.split(",")[1]) - yPrint > 1) {
//                        System.out.print(",");
                        sb.append(",");
                    }
                    xPrint = Integer.parseInt(str.split(",")[0]);
                    yPrint = Integer.parseInt(str.split(",")[1]);
//                    System.out.print(map[Integer.parseInt(str.split(",")[0])][Integer.parseInt(str.split(",")[1])]);
                    sb.append(map[Integer.parseInt(str.split(",")[0])][Integer.parseInt(str.split(",")[1])]);
                }
//                System.out.println("  " + x + "," + y);
//                sb.append("  " + x + "," + y);
//                sum += sb.toString().split(",").length == 2 ? Integer.parseInt(sb.toString().split(",")[0]) * Integer.parseInt(sb.toString().split(",")[1]) : 0;
                System.out.print(sb+"    ");
                System.out.print(sb.toString().split(",").length == 2 ? Integer.parseInt(sb.toString().split(",")[0]) * Integer.parseInt(sb.toString().split(",")[1]) : 0);
                sum+=sb.toString().split(",").length == 2 ? Integer.parseInt(sb.toString().split(",")[0]) * Integer.parseInt(sb.toString().split(",")[1]) : 0;
                System.out.print("  " + x + "," + y+"  ");
                System.out.println(sum);
            }

        }
        System.out.println(sum);
    }


}

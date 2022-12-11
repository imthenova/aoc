package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D9b {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    static int size = 1000;
    static int xH = size/2;
    static int yH = size/2;
    static int preXT = size/2;
    static int preYT = size/2;
    static int[] xTs = new int[9];
    static int[] yTs = new int[9];
    static int position = 8;
    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 9; i++) {
            xTs[i]=size/2;
            yTs[i]=size/2;
        }
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> stepList = Arrays.stream(content.split("\r\n")).toList();
        List<int[][]> tailMovesList = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int[][] tailMoves = new int[size][size];
            tailMovesList.add(tailMoves);
        }
        int[][] nineTailMoves = tailMovesList.get(position);
        System.out.println(xTs[position]+","+yTs[position]);
        nineTailMoves[xTs[position]][yTs[position]]=1;
        int[][] headMoves = new int[size][size];
        D9b d9 = new D9b();
        for (int i = 0; i < stepList.size(); i++) {
            d9.move(stepList.get(i),headMoves,tailMovesList);
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(nineTailMoves[i][j]);
                if(nineTailMoves[i][j]>0){
                    count++;
                }
            }
            System.out.println();
        }
        System.out.println(count);
    }

    public void move(String stepStr,int[][] headMoves,List<int[][]> tailMovesList){
        char direction = stepStr.charAt(0);
        int steps = Integer.parseInt(stepStr.split(" ")[1]);
        for (int i = 0; i < steps; i++) {
            switch(direction){
                case 'U':
                    xH-=1;
                    break;
                case 'D':
                    xH+=1;
                    break;
                case 'L':
                    yH-=1;
                    break;
                case 'R':
                    yH+=1;
                    break;
            }
            headMoves[xH][yH] += 1;
            follow(tailMovesList);
        }

    }
    public void follow(List<int[][]> tailMovesList){
        for (int i = 0; i < tailMovesList.size(); i++) {
            if(i==0){
                preXT=xH;
                preYT=yH;
            }else{
                preXT=xTs[i-1];
                preYT=yTs[i-1];
            }
            if(Math.abs(preXT-xTs[i])>=2 || Math.abs(preYT-yTs[i])>=2){
                if(preXT>xTs[i]){
                    xTs[i]++;
                }else if(preXT<xTs[i]){
                    xTs[i]--;
                }
                if(preYT>yTs[i]){
                    yTs[i]++;
                }else if(preYT<yTs[i]){
                    yTs[i]--;
                }
                tailMovesList.get(i)[xTs[i]][yTs[i]] += 1;
            }
        }

    }
//    public void follow(List<int[][]> tailMovesList){
//        for (int i = 0; i < tailMovesList.size(); i++) {
//            if(i==0){
//                preXT=xH;
//                preYT=yH;
//            }else{
//                preXT=xTs[i-1];
//                preYT=yTs[i-1];
//            }
//            if(Math.abs(preXT-xTs[i])>=2 || Math.abs(preYT-yTs[i])>=2){
//                if(preXT-xTs[i]>=2){
//                    xTs[i] = preXT - 1;
//                    yTs[i] = preYT;
//                }else if(xTs[i]-preXT>=2){
//                    xTs[i] = preXT + 1;
//                    yTs[i] = preYT;
//                }if(preYT-yTs[i]>=2){
//                    yTs[i] = preYT - 1;
//                    xTs[i] = preXT;
//                }else if(yTs[i]-preYT>=2){
//                    yTs[i] = preYT + 1;
//                    xTs[i] = preXT;
//                }
//                tailMovesList.get(i)[xTs[i]][yTs[i]] += 1;
//            }
//        }
//
//    }

}

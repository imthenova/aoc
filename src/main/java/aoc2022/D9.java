package aoc2022;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class D9 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    static int size = 500;
    static int xH = size/2;
    static int yH = size/2;
    static int xT = size/2;
    static int yT = size/2;
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> stepList = Arrays.stream(content.split("\r\n")).toList();
        int[][] tailMoves = new int[size][size];
        tailMoves[xT][yT]=1;
        int[][] headMoves = new int[size][size];
        D9 d9 = new D9();
        for (int i = 0; i < stepList.size(); i++) {
//            System.out.println(i);
            d9.move(stepList.get(i),headMoves,tailMoves);
        }
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
//                System.out.print(tailMoves[i][j]);
                if(tailMoves[i][j]>0){
                    count++;
                }
            }
//            System.out.println();
        }
        System.out.println(count);
    }

    public void move(String stepStr,int[][] headMoves,int[][] tailMoves){
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
            System.out.println(xH+","+yH);
            headMoves[xH][yH] += 1;
            follow(tailMoves);
        }

    }
    public void follow(int[][] tailMoves){
        if(Math.abs(xH-xT)>=2 || Math.abs(yH-yT)>=2){
            if(xH>xT){
                xT++;
            }else if(xH<xT){
                xT--;
            }
            if(yH>yT){
                yT++;
            }else if(yH<yT){
                yT--;
            }
            tailMoves[xT][yT] += 1;
        }
    }
//    public void follow(int[][] tailMoves){
//        if(Math.abs(xH-xT)>=2 || Math.abs(yH-yT)>=2){
//            if(xH-xT>=2){
//                xT = xH - 1;
//                yT = yH;
//            }else if(xT-xH>=2){
//                xT = xH + 1;
//                yT = yH;
//            }if(yH-yT>=2){
//                yT = yH - 1;
//                xT = xH;
//            }else if(yT-yH>=2){
//                yT = yH + 1;
//                xT = xH;
//            }
//            tailMoves[xT][yT] += 1;
//        }
//    }
}

package aoc2022;

import bo.FileBO;
import bo.Folder;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class D7 {
    static String PATH = "C:\\Users\\imthe\\Documents\\aoc\\input"+"2";
    public static long FOLDER_SIZE = 0;
    public static List<Long> FOLDER_SIZE_List = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String content = FileUtils.readFileToString(new File(PATH));
        List<String> rowList = Arrays.stream(content.split("\r\n")).toList();
        Folder rootFolder = new Folder();
        rootFolder.setFolderNanme("/");

        Folder currentFolder = null;
        for (int i = 0; i < rowList.size(); i++) {
            if(rowList.get(i).equals("$ ls")){
//                System.out.println(rowList.get(i));
                long size = 0;
                int j = 1;
                while (i+j<rowList.size() && !rowList.get(i+j).startsWith("$ cd") ){
//                    System.out.println(rowList.get(i+j));
                    if(!rowList.get(i+j).startsWith("dir ")){
                        FileBO file = new FileBO(Long.parseLong(rowList.get(i+j).split(" ")[0]));
                        currentFolder.getFileBOList().add(file);
                    }else{
                        Folder subFolder = new Folder();
                        String subFolderName = rowList.get(i+j).split(" ")[1];
                        subFolder.setFolderNanme(subFolderName);
                        subFolder.setParentFolder(currentFolder);
                        currentFolder.getFolderList().put(subFolderName,subFolder);
                    }
                    j++;
                }
            }else if(rowList.get(i).startsWith("$ cd")){
//                System.out.println(rowList.get(i));
                String dirName = rowList.get(i).substring(5);
                if(dirName.equals("/")){
                    currentFolder = rootFolder;
                }else if(dirName.equals("..")){
                    currentFolder = currentFolder.getParentFolder();
                }else{
                    currentFolder = currentFolder.getFolderList().get(dirName);
                }
            }
        }
        long sum = 0;
        System.out.println(rootFolder.calcSize());
        System.out.println(D7.FOLDER_SIZE_List.stream().min(Long::compareTo));

    }


}

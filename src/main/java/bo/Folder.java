package bo;

import aoc2022.D7;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Folder {
    Map<String,Folder> folderList = new HashMap<>();
    List<FileBO> fileBOList = new ArrayList<>();
    String folderNanme;
    Folder parentFolder;
    public long calcSize(){
        long size = folderList.values().stream().mapToLong(Folder::calcSize).sum() + fileBOList.stream().mapToLong(FileBO::getSize).sum();
        if(size>=2805968){
            D7.FOLDER_SIZE_List.add(size);
        }
        return size;
    }

    public String getFolderNanme() {
        return folderNanme;
    }

    public void setFolderNanme(String folderNanme) {
        this.folderNanme = folderNanme;
    }

    public Map<String, Folder> getFolderList() {
        return folderList;
    }

    public void setFolderList(Map<String, Folder> folderList) {
        this.folderList = folderList;
    }

    public List<FileBO> getFileBOList() {
        return fileBOList;
    }

    public void setFileBOList(List<FileBO> fileBOList) {
        this.fileBOList = fileBOList;
    }

    public Folder getParentFolder() {
        return parentFolder;
    }

    public void setParentFolder(Folder parentFolder) {
        this.parentFolder = parentFolder;
    }
}

package bo;

import java.util.ArrayList;
import java.util.List;

public class FileBO {
    long size;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public FileBO(long size) {
        this.size = size;
    }
}

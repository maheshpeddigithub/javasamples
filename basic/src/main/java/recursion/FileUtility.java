package recursion;


import java.io.File;

public class FileUtility {

    public static int getFileCount(File directory) {
        int fileCount = 0;
        File[] fileList = directory.listFiles();
        for (File file : fileList) {
            if (file.isFile()) {
                fileCount++;
            } else {
                fileCount += getFileCount(file);
            }
        }
        return fileCount;
    }

}

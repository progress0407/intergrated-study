package test.grammer.iozz;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.Date;

import static java.lang.System.out;

public class FileIoOldVerSample {

    private static String pathName = "";

    private static void init() {
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("user.dir");
        sb.append(property);
        sb.append(File.separator);
        sb.append("file_io_test");
        out.println("sb = " + sb);
        pathName = sb.toString();
    }

    public static void main(String[] args) {
        init();
        FileIoOldVerSample sample = new FileIoOldVerSample();
//        sample.test1();
//        sample.test2();
//        sample.test3();
        sample.test4();
    }

    private void test4() {
        File[] filesWithFilter = new File(pathName).listFiles(new CustomFileFiler());
        for (File file : filesWithFilter) {
            out.println("file = " + file);
        }
    }

    private void test3() {
        File path = new File(pathName);
        File[] listRoots = File.listRoots();
        for (File listRoot : listRoots) {
            out.println("listRoot = " + listRoot); // C:\
        }
    }

    static class CustomFileFiler implements FileFilter {

        @Override
        public boolean accept(File pathname) {
            String fileName = pathname.getName();
            if(fileName.endsWith(".txt"))
                return true;
            return false;
        }
    }
    
    private void test2() {
        String newFileName = "newText.txt";
        File file = new File(pathName, newFileName);

        try {
            out.println("Create Result = " + file.createNewFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void test1() {
        File path = new File(pathName);
        File[] files = path.listFiles();
        for (File file : files) {
            out.println("file.getName() = " + file.getName());
            if (file.isHidden())
                out.println(file.getName() + " is hidden");
            out.println("Date file.lastModified() = " + new Date(file.lastModified()));
        }

        out.println("path.getParentFile() = " + path.getParentFile());
    }


}

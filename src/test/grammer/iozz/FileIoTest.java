package test.grammer.iozz;

import java.io.File;
import java.io.IOException;

import static java.lang.System.out;

public class FileIoTest {

    public static void main(String[] args) throws IOException {
        // Pathname of the current Working Directory

        String pwd = System.getProperty("user.dir") + "/src/test/grammer/iozz";

        File path = new File(pwd);

        File[] files = path.listFiles();

        if(files.length < 1) return;

        for (File file : files) {

            String fileNameWithExtension = file.getName();
            int extensionPosition = fileNameWithExtension.lastIndexOf(".");

            String extension = fileNameWithExtension.substring(extensionPosition, fileNameWithExtension.length());
            String fileName = fileNameWithExtension.substring(0, extensionPosition);
            String decFileName = fileName + "_dec" + extension;

            out.println("fileName = " + fileName);
            out.println("extension = " + extension);
            out.println("decFileName = " + decFileName);

        }

    }

}

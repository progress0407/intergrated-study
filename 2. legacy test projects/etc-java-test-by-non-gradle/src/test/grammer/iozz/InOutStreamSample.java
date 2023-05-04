package test.grammer.iozz;

import java.io.*;
import java.util.Scanner;

import static java.io.File.separator;
import static java.lang.System.out;

public class InOutStreamSample {

    private static String pathName = "";

    private static void init() {
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("user.dir");
        sb.append(property);
        sb.append(separator);
        sb.append("file_io_test");
        out.println("sb = " + sb);
        pathName = sb.toString();
    }

    public static void main(String[] args) {

        init();

        InOutStreamSample sample = new InOutStreamSample();

        int MAX_CNT = 1_000_000;
        String fullPath = pathName + separator + "newWritingText.txt";

        long t1 = System.currentTimeMillis();
//        sample.writeWithBuffer(fullPath, MAX_CNT); // 126
//        sample.writeWithoutBuffer(fullPath, MAX_CNT); // 155
//        sample.readFileWithBuffer(fullPath); // 4246
//        sample.readFileWithoutBuffer(fullPath);
        sample.readFileWithScanner(fullPath); // 4274
        long t2 = System.currentTimeMillis();

        out.println("(t2-t1) = " + (t2 - t1));
    }

    private void readFileWithScanner(String fullPath) {
        File file = new File(fullPath);
        Scanner scanner = null;

        try {
            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }



    }

    /*private void readFileWithoutBuffer(String fullPath) {
        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fullPath);

            String data;

            while ((data = fileReader.read()) != -1) {
                out.println("data = " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        out.println("Read Success !!");

    }*/

    private void readFileWithBuffer(String fullPath) {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            fileReader = new FileReader(fullPath);
            bufferedReader = new BufferedReader(fileReader);

            String data;

            while ((data = bufferedReader.readLine()) != null) {
                out.println("data = " + data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        out.println("Read Success !!");

    }
    
    private void writeWithoutBuffer(String fullPath, int MAX_CNT) {

        FileWriter fileWriter = null;

        try {
            fileWriter = new FileWriter(fullPath);
            for (int i = 0; i < MAX_CNT; i++) {
                fileWriter.write(Integer.toString(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void writeWithBuffer(String fullPath, int MAX_CNT) {

        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;


        try {
            fileWriter = new FileWriter(fullPath);
            bufferedWriter = new BufferedWriter(fileWriter);

            for (int i = 0; i < MAX_CNT; i++) {
                bufferedWriter.write(Integer.toString(i));
                bufferedWriter.newLine();
            }

            out.println("Success Write !! ");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

package io.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * Author: deceiver
 * Date: 2019-06-04
 * Time: 17:17
 */
public class ListAllFiles {

    // dir level
    private static int level;

    public static void listAll(File file) {
        if (file.isFile() || file.listFiles().length == 0) {
            return;
        } else {
            File[] files = file.listFiles();
            files = sortFiles(files);
            for (File f : files) {
                StringBuilder sb = new StringBuilder();

                sb.append(getTab(level));
                sb.append(f.getName());
                if (f.isDirectory()) {
                    sb.append(":");
                }
                System.out.println(sb);

                if (f.isDirectory()) {
                    level++;
                    listAll(f);
                    level--;
                }
            }
        }


    }

    private static File[] sortFiles(File[] files) {
        List<File> list = new ArrayList<>();

        // dir first and file last by order
        for (File file : files) {
            if (file.isDirectory()) {
                list.add(file);
            }
        }
        for (File file : files) {
            if (file.isFile()) {
                list.add(file);
            }
        }

        return list.toArray(new File[files.length]);
    }

    private static String getTab(int level) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < level; i++) {
            sb.append("\t");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        listAll(new File("/Users/deceiver/Desktop/Java"));
    }
}

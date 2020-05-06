package cmd;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author janka
 */
public class Dir extends Command {

    @Override
    public String execute(File actualDir) {
        File[] files;
        if (params.length == 1) {
            files = actualDir.listFiles();
            return dirToString(files);
        }
        if (params.length == 2) {
            if (params[1].equals("-o")) {
                files = actualDir.listFiles();
                Arrays.sort(files);
                return dirToString(files);
            }

        }
        if (params.length == 3) {
            if (params[1].equals("-e")) {
                files = getDirOfExtention(actualDir.listFiles(), params[2]);

                return dirToString(files);
            }
            if (params[1].equals("-s")) {
                files = getDirOfSize(actualDir.listFiles(), Integer.parseInt(params[2]));
                return dirToString(files);
            }

        }
        return null;
    }

    private String dirToString(File[] files) {
        StringBuilder sb = new StringBuilder("");
        for (File file : files) {
            if (file.isDirectory()) {
                sb.append(String.format("%s%n", file.getName()));
            } else {
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }

    private File[] getDirOfSize(File[] d, int size) {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : d) {
            if (file.length() >= size) {
                files.add(file);
            }
        }
        File[] fileArray = new File[files.size()];
        files.toArray(fileArray);
        return fileArray;
    }

    private File[] getDirOfExtention(File[] d, String ext) {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : d) {

            if (file.getName().endsWith(ext)) {

                files.add(file);
            }
        }
        File[] fileArray = new File[files.size()];
        files.toArray(fileArray);
        return fileArray;
    }

}

package cmd;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

/**
 *
 * @author janka
 */
public class Recdir extends Command {

    @Override
    public String execute(File actualDir) {
        
        if (params.length == 1) {
            
            return dirToString(actualDir,0);
        }
        return null;
    }
    
    

    private String dirToString(File fileDir, int inside) {
        int in = inside;
        StringBuilder sb = new StringBuilder("");
        File[] files = fileDir.listFiles();
        
        
        
        for (File file : files) {
            if (file.isDirectory()) {
                for(int i = 0; i<=in; i++){
                sb.append("-");
                }
                sb.append(String.format("%s%n", file.getName()));
                sb.append(dirToString(new File(fileDir.getAbsolutePath()+"\\"+file.getName()),in+1));
                
            } else {
                for(int i = 0; i<=in; i++){
                sb.append("-");
                }
                sb.append(String.format("%-20s%6d", file.getName(), file.length()));
                sb.append(new Date(file.lastModified())).append("\n");
            }
        }
        return sb.toString();
    }

}

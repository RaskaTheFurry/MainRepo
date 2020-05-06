package cmd;

import java.io.File;

/**
 *
 * @author janka
 */
public class CmdEditor implements CmdInterface {
    private boolean isRunning;
    private File actualDir;
    private Command command;    
    
    public CmdEditor(){
        isRunning = true;
        actualDir = new File(System.getProperty("user.dir"));
        
    }
    
    @Override
    public boolean isRunning() {
        return isRunning;
    }

    @Override
    public String getActualDir() {
        return actualDir.getAbsolutePath();
    }
    
    

    @Override
    public String parseAndExecute(String line) {
        //parse
        command = Parser.parse(line);
        //execute 
        if(command.params[0].equals("cd")){
            //System.out.println("CD");
            executeCd();
        }
        //isRunning = false;
        return command.execute(actualDir);
    }
    

    public void executeCd() {
        if(command.params.length == 2){
            if(command.params[1].equals("..")){
                
                //System.out.println(actualDir.getParent());
//                actualDir.renameTo(new File(actualDir.getParent()));
                actualDir = new File(actualDir.getParent());
                
            }else{
                System.out.println(command.params[1]);
            //System.out.println(actualDir.getAbsolutePath());
//            actualDir.renameTo(new File(actualDir.getAbsolutePath()+"\\"+command.params[1]));
            File newFile = new File(actualDir.getAbsolutePath()+"\\"+command.params[1]);
            if(newFile.exists() && newFile.isDirectory()){
                actualDir = new File(actualDir.getAbsolutePath()+"\\"+command.params[1]);
            }else{
                System.out.println("Složka neexistuje");
            }
            
            
            }
        }
        
    }
}

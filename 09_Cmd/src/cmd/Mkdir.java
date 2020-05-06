/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;

/**
 *
 * @author Uzivatel
 */
public class Mkdir extends Command{

    @Override
    public String execute(File actualDir) {
        File file = new File("New_Folder");
        File newFile = file;
        if(params.length == 1){
            
            int i = 1;
            while(newFile.exists()){
                newFile = new File(file.getName()+"_"+i);
                i++;
            }
            newFile.mkdir();
            return "Byla vytvořena složka "+newFile.getName();
        }
        if(params.length == 2){
            file = new File(params[1]);
            int i = 1;
            while(newFile.exists()){
                newFile = new File(file.getName()+"_"+i);
                i++;
            }
            newFile.mkdir();
            file.mkdir();
            return "Byla vytvořena složka "+newFile.getName();
        }
        return null;
    }
    
}

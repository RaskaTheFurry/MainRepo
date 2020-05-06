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
public class Renameto extends Command {

    @Override
    public String execute(File actualDir) {
        if(params.length == 3){
            File file = new File(params[1]);
            if(file.exists()){
                if(file.renameTo(new File(params[2]))){
                    return "Soubor/složka "+params[1]+" byla přejmenována na "+params[2];
                }else{
                    return "Složka/soubor již existuje, nelze přejmenovat";
                }
            }
        }
        return null;
    }
    
    
    
}

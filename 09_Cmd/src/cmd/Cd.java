/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmd;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Uzivatel
 */
public class Cd extends Command{

    
    @Override
    public String execute(File actualDir) {
        return "";
    }
//    @Override
//    public String execute(File actualDir) {
//        if(params.length == 2){
//            if(params[1].equals("..")){
//                //System.out.println(actualDir.getParent());
//                actualDir.renameTo(new File(actualDir.getParent()));
//                
//            }else{
//            //System.out.println(actualDir.getAbsolutePath());
//            actualDir.renameTo(new File(actualDir.getAbsolutePath()+"\\"+params[1]));
//            
//            }
//        }
//        return null;
//    }
    
}

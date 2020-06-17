/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package competition.filehandling;

import competition.app.Runner;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalTime;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Uzivatel
 */
public class BinaryReader {
    
    
    public static void main(String[] args) {
        try {
            List<Runner> runners = getRunners("data/result.dat");
                for (Runner runner : runners) {
                    System.out.println(runner.toString());
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
    }

    private static List<Runner> getRunners(String resultFilepath) throws IOException {
        List<Runner> runners = new ArrayList<>();
        
        try(DataInputStream dis = new DataInputStream(new FileInputStream(resultFilepath))){
            System.out.println(dis.readUTF());
            boolean ended = false;
            while(!ended){
                try{
                    int number = dis.readInt();
                    String firstName = dis.readUTF();
                    String lastName = dis.readUTF();
                    LocalTime time = LocalTime.ofNanoOfDay(number);
                    Runner runner = new Runner(number, firstName, lastName);
                    runner.setResultTime(time);
                    runners.add(runner);
                }catch(EOFException e){
                    ended = true;
                }
            }
        }
        return runners;
    }
    
    
}

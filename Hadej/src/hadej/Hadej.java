package hadej;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Uzivatel
 */
public class Hadej {
    public static int Min = 0;
    public static int Max = 100;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int choice;
        boolean end = false;
        
        
        while(!end){
        DisplayMenu();
        choice = readChoice();
        switch(choice){
            case 0: end = true;break;
            case 1: UserGuesses();break;
            case 2: comuperGuesses();break;
            case 3: System.out.println("Napište 2 čísla ( minimum, maximum ):");changeRange(readChoice(),readChoice());break;
            
            
            default: System.out.println("WRONG NUMBAH");
        }
        
        }
    }
    
    private static void DisplayMenu(){
        System.out.println("******************************");
        System.out.println("*1. Uživatel hledá           *");
        System.out.println("*2. Počítač hledá            *");
        System.out.println("*3. Změn rozsah              *");
        System.out.println("*0. Konec                    *");
        System.out.println("******************************");
    }
    
    private static int readChoice(){
        
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    private static void changeRange(int min, int max){
        if(min>=max){
            System.out.println("ERROR minimum je větší nebo rovno jak maximum");
        }else{
        Min = min;
        Max = max;
        }
    }
    
    private static void UserGuesses(){
        Random rnd = new Random();
        Boolean Done = false;
        int guess;
        int times = 0;
        int ChoiceMade = rnd.nextInt(Max-Min)+Min;
        while(!Done){
            System.out.println("Hádej od "+Min+" do "+Max);
            guess = readChoice();
            if(guess<ChoiceMade){
                System.out.println("Číslo je vyšší");
                times++;
            }else{
                if(guess>ChoiceMade){
                    System.out.println("Číslo je menší");
                    times++;
                }else{
                    System.out.println("To je to číslo, dobrá práce");
                    times++;
                    Done = true;
                    System.out.println("zvládl jsi to na "+times+". pokus");
                }
            }
            
        }
    }
    
    private static void comuperGuesses(){
        int min = Min,max = Max;
        int CGuess = (Max+Min)/2;
        System.out.println("je to "+CGuess+"?");
        boolean found = false;
        int vysl;
        int times = 0;
        System.out.println("**************************");
        System.out.println("*1 = vyšší               *");
        System.out.println("*0 = vyhrál              *");
        System.out.println("*-1 = nyžší              *");
        System.out.println("**************************");
        while(!found && min<=max){
        
        vysl = readChoice();
        if(vysl >= 1){
            min = CGuess+1;
            times++;
        }else{
            if(vysl <= -1){
                max = CGuess-1;
                times++;
            }else{
                System.out.println("Vyhrál jsem");
                found = true;
                times++;
                System.out.println("Dosáhl jsem toho za "+times+" pokusů");
            }
        }
        if(!found){
            CGuess = (max+min)/2;
            System.out.println("je to "+CGuess+"?");
        }
        }
    }
    
}

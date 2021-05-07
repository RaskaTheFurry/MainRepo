package numbermind;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Uzivatel
 */
public class NumberMind {

    private static Random rnd = new Random();
    private static Scanner sc = new Scanner(System.in);
    private static int[][] rules;
    private static int[] correct;
    private Random end = new Random();
    private static int seed = 0;
    

    public static void main(String[] args) {
        boolean end1 = false;
        String s;
        String[] strArr;
        int[] corr;
        int[][] nums;
        while (!end1) {
            System.out.println("1 for game\n"
                    + "2 for bruteforced Euiler problem\n"
                    + "3 for better solving of Euiler Problem");
            switch (sc.nextInt()) {
                case 1:
                    boolean end = false;
                    while (!end) {
                        System.out.println("Choose size: ");
                        int size = sc.nextInt();
                        if (size < 1) {
                            end = true;
                        } else {
                            int[] pole = generate(size);
                            boolean isWon = false;
                            int tmp;
                            int pokus = 1;
                            while (!isWon) {
                                int rightGuesses = 0;
                                String guessed = "";
                                System.out.println("List your guess: ");
                                for (int i = 0; i < size; i++) {

                                    tmp = sc.nextInt();
                                    guessed += tmp;
                                    if (tmp == pole[i]) {
                                        rightGuesses++;
                                    }
                                }
                                System.out.println("You Guessed: " + guessed + " And got " + rightGuesses + " right");
                                if (rightGuesses == size) {
                                    isWon = true;
                                    System.out.println("Zabralo ti to " + pokus + " pokusů");
                                } else {
                                    pokus++;
                                }
                            }
                        }
                    }
                    break;
                case 2:
                    s = "5616185650518293 ;2 correct\n"
                            + "3847439647293047 ;1 correct\n"
                            + "5855462940810587 ;3 correct\n"
                            + "9742855507068353 ;3 correct\n"
                            + "4296849643607543 ;3 correct\n"
                            + "3174248439465858 ;1 correct\n"
                            + "4513559094146117 ;2 correct\n"
                            + "7890971548908067 ;3 correct\n"
                            + "8157356344118483 ;1 correct\n"
                            + "2615250744386899 ;2 correct\n"
                            + "8690095851526254 ;3 correct\n"
                            + "6375711915077050 ;1 correct\n"
                            + "6913859173121360 ;1 correct\n"
                            + "6442889055042768 ;2 correct\n"
                            + "2321386104303845 ;0 correct\n"
                            + "2326509471271448 ;2 correct\n"
                            + "5251583379644322 ;2 correct\n"
                            + "1748270476758276 ;3 correct\n"
                            + "4895722652190306 ;1 correct\n"
                            + "3041631117224635 ;3 correct\n"
                            + "1841236454324589 ;3 correct\n"
                            + "2659862637316867 ;2 correct";
                    strArr = s.split("\n");
                    corr = new int[22];
                    nums = new int[22][16];
                    for (int j = 0; j < 22; j++) {
                        strArr[j] = strArr[j].trim().substring(0, strArr[j].length() - 7);
//                        System.out.println(strArr[j].split(";").length);
                        corr[j] = Integer.parseInt(strArr[j].split(";")[1].trim());
                        for (int i = 0; i < 16; i++) {

                            nums[j][i] = Integer.parseInt(strArr[j].trim().split(";")[0].trim().split("\\B")[i].trim());
                        }
                    }

                    int[] fin = getUniqueNumberBrute(nums, corr);

                    Arrays.toString(fin);

                    break;
                case 3:
                    s = "5616185650518293 ;2 correct\n"
                            + "3847439647293047 ;1 correct\n"
                            + "5855462940810587 ;3 correct\n"
                            + "9742855507068353 ;3 correct\n"
                            + "4296849643607543 ;3 correct\n"
                            + "3174248439465858 ;1 correct\n"
                            + "4513559094146117 ;2 correct\n"
                            + "7890971548908067 ;3 correct\n"
                            + "8157356344118483 ;1 correct\n"
                            + "2615250744386899 ;2 correct\n"
                            + "8690095851526254 ;3 correct\n"
                            + "6375711915077050 ;1 correct\n"
                            + "6913859173121360 ;1 correct\n"
                            + "6442889055042768 ;2 correct\n"
                            + "2321386104303845 ;0 correct\n"
                            + "2326509471271448 ;2 correct\n"
                            + "5251583379644322 ;2 correct\n"
                            + "1748270476758276 ;3 correct\n"
                            + "4895722652190306 ;1 correct\n"
                            + "3041631117224635 ;3 correct\n"
                            + "1841236454324589 ;3 correct\n"
                            + "2659862637316867 ;2 correct";
                    
//                    s = "90342 ;2 correct\n" +
//"70794 ;0 correct\n" +
//"39458 ;2 correct\n" +
//"34109 ;1 correct\n" +
//"51545 ;2 correct\n" +
//"12531 ;1 correct";               //Test one works perfectly
                    
                    
//                    s = "228569150065 ;1 correct\n" +
//"907564288621 ;0 correct\n" +
//"496954400043 ;0 correct\n" +
//"713459943615 ;0 correct\n" +
//"211421327491 ;1 correct\n" +
//"258317293172 ;0 correct\n" +
//"919252724339 ;1 correct\n" +
//"197103476352 ;0 correct\n" +
//"151173430038 ;0 correct\n" +
//"063794395936 ;0 correct\n" +
//"504759866532 ;1 correct\n" +
//"502906565456 ;0 correct\n" +
//"790539816536 ;0 correct\n" +
//"595873942664 ;1 correct\n" +
//"346602334981 ;0 correct\n" +
//"988808475766 ;1 correct\n" +
//"559203789779 ;0 correct\n" +
//"498580144863 ;1 correct\n" +
//"441454897857 ;1 correct\n" +
//"622818801178 ;0 correct";
                    
                    strArr = s.split("\n");
                    corr = new int[strArr.length];
                    String[] numz = new String[corr.length];
                    for (int j = 0; j < strArr.length; j++) {
                        strArr[j] = strArr[j].trim().substring(0, strArr[j].length() - 7);
//                        System.out.println(strArr[j].split(";").length);
                        corr[j] = Integer.parseInt(strArr[j].split(";")[1].trim());
                        numz[j] = strArr[j].trim().split(";")[0].trim();
                        
                    }
//                    System.out.println(Arrays.toString(numz));
                    add(numz,corr);
                    
                    
                    int numDigits = rules[0].length;
                    int[] current = new int[numDigits];
                    for (int i = 0; i < current.length; i++) {
                        current[i] = Rand(10);
                    }
                    
                    for (int i = 0; i < current.length; i++) {
                        current[i] = shuffle(current[i]);
                    }
                    
                    
                    final int maxRoundsWithoutImprovement = 20;
                    int quietRounds = 0;
                    
                    int errors = distance(current);
                    int previous = errors;
                    while(errors != 0){
                        
                        for(int i = 0;i<current.length;i++){
//                            System.out.println(Arrays.toString(current));
                            int previousDigit = current[i];
                            do{
                                current[i] = shuffle(current[i]);
                            }while(current[i] == previousDigit);
                            int modified = distance(current);
                            if(modified<=errors){
                                errors = modified;
                            }else{
                            current[i] = previousDigit;
                            }
                        }
//                        System.out.println(Arrays.toString(current));
                        if(errors == previous){
                            quietRounds++;
                            if(quietRounds == maxRoundsWithoutImprovement){
                                int ran = Rand(current.length);
                                current[ran] = shuffle(current[ran]);
                                errors = distance(current);
                                quietRounds = 0;
                            }
                            
                        }else{
                            quietRounds = 0;
                            previous = errors;
                        }
                        
                    }
                    System.out.println("");
                    for(int c:current){
                        System.out.print(c);
                    }
                    System.out.println("");
                    break;
            }
        }
    }
    
//    private static int[] BetterEuiler(){
//        
//        
//        
//        return null;
//    }
    
    private static int Rand(int modulo){
        
        
        return rnd.nextInt(modulo);
    }
    private static int shuffle(int digit){
        int old = digit;
        do{
            digit = Rand(10);
        }while(Character.getNumericValue(digit) == old);
        return digit;
    }
    
    private static void add(String[] guess, int[] matches){
        String[] s;
        int[][] it = new int[guess.length][guess[0].split("").length];
        for (int i = 0; i < guess.length; i++) {
            s = guess[i].split("");
            for (int j = 0; j < s.length; j++) {
                it[i][j] = Integer.parseInt(s[j]);
            }
        }
        rules = it;
        correct = matches;
    }
    
    private static int distance(int[] current){
        int errors = 0;
        for (int i = 0; i < rules.length; i++) {
            int same = 0;
            for (int j = 0; j < current.length; j++) {
                if(current[j]==rules[i][j]){
                    same++;
                }
            }
            if(same > correct[i]){
                errors+=same-correct[i];
                
            }else{
                errors+=correct[i]-same;
                
            }
        }
        return errors;
    }
    
    
    
    
    
    
    
    
    
    
    

    /*
    dont do brute force, technically works, but is useless
     */
    private static int[] getUniqueNumberBrute(int[][] num, int[] correct) {
        int[] tmp = new int[num[0].length];
        int rightGuess = 0;
//        for (int i = 0; i < tmp.length; i++) {
//            tmp[i] = 0;
//        }
        long x = 0;
        String k = "";
        boolean end = false;
        while (!end) {
            k = "";
            System.out.println(("" + x));
            for (int j = 0; j < tmp.length - (("" + x).length()); j++) {
                k += 0;
            }
            k += x;
            for (int i = 0; i < k.length(); i++) {
                tmp[i] = Integer.parseInt(k.split("")[i]);
            }
            for (int i = 0; i < num.length; i++) {
                rightGuess = 0;
                for (int j = 0; j < num[i].length; j++) {

//                    System.out.println(num[i].length);
                    if (num[i][j] == tmp[j]) {
                        rightGuess++;
                    }
                }
                System.out.println(Arrays.toString(tmp));
                if (rightGuess != correct[i]) {
                    break;
                }

                if (rightGuess == correct[i] && i == num.length - 1) {
                    end = true;

                }
            }
            x++;
        }
        return tmp;
    }

    private static int[] generate(int size) {
        int[] pole = new int[size];
        for (int i = 0; i < size; i++) {
            pole[i] = rnd.nextInt(10);
        }
        return pole;
    }

}



/*

            Credit goes to StephanBrumme for the algorithm, that i moved to Java

*/
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kalendar;

/**
 *
 * @author Uzivatel
 */
public class KalendarArray {
    private final int[] DAYS_OF_YEAR = {31,28,31,30,31,30,31,31,30,31,30,30};
    private int day,month,year;
    private int[][] calendar = new int[6][7];
    public KalendarArray(int day, int month, int year){
        if(month>12 || month<0){
            System.out.println("error: Invalid month");
        }else{
            int i = 0;
            if(prestupny()){
                i = 1;
            }
            if(month == 2){
                if(day<0 || day>DAYS_OF_YEAR[month-1]+i){
                System.out.println("error: Invalid day");
                }else{
                    this.day = day;
                    this.month = month;
                    this.year = year;
                }
            }else{
                if(day<0 || day>DAYS_OF_YEAR[month-1]){
                System.out.println("error: Invalid day");
                }else{
                    this.day = day;
                    this.month = month;
                    this.year = year;
                }
            }
        }
        calcCurrentMonth();
    }
    // Otestuje přestupný rok
    private boolean prestupny(){
        if(this.year%4 == 0){
            if(this.year%100 == 0 && !(this.year%400 == 0)){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
    // zjistí jaký den je první v měsíci
    private int calcFirstDay(){
        
        return R(1+5*R(this.year-1,4)+4*R(this.year-1,100)+6*R(year-1,400),7);
    }
    
    private int R(int y, int m){
        return y%m;
    }
    private int getC(){
        return year/100;
    }
    private int getY(){
        return year-getC()*100;
    }

    public int[][] getCalendar() {
        return calendar;
    }
    //zvýší měsíc
    public void raiseMonth(){
        if(this.month>11){
            this.month = 1;
            this.year++;
        }else{
            this.month++;
        }
        calcCurrentMonth();
    }
    // sníží měsíc
    public void lowerMonth(){
        if(this.month<0){
            this.month = 12;
            this.year--;
        }else{
            this.month--;
        }
        calcCurrentMonth();
    }
    // kalkulace nynějšího měsíce
    public void calcCurrentMonth(){
        for(int i = 0;i<calendar.length;i++){
            for(int j = 0;j<calendar[i].length;j++){
                calendar[i][j] = 0;
            }
        }
        

        int firstDay;
        System.out.println(calcFirstDay());
//        if(calcFirstDay() == 0 ){
//            firstDay = 6;
//            for(int i = 0;i<this.month-1;i++){
//                firstDay+=DAYS_OF_YEAR[i]-firstDay;
//                firstDay=firstDay%7;
//            }
//        }else{
            firstDay = calcFirstDay()-1;
//            System.out.println(firstDay);
            for(int i = 1;i<this.month;i++){
                firstDay+=DAYS_OF_YEAR[i-1];
                //System.out.println(firstDay);
                firstDay=firstDay%7;
            }
            firstDay=firstDay%7;
//        }
        //System.out.println(firstDay);
        int days = 1;
        for(int i = firstDay; i<calendar[0].length;i++){
            calendar[0][i] = days;
            days++;
        }
        
        for(int i = 1; i<calendar.length;i++){
            for(int j = 0;j<calendar[i].length && j+i*7-firstDay-1<DAYS_OF_YEAR[this.month-1];j++){
                calendar[i][j] = days;
                days++;
            }
        }
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
    
    
    
}

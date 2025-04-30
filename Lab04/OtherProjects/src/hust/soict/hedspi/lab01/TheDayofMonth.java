package hust.soict.hedspi.lab01;

import java.util.Scanner;
public class TheDayofMonth{
    public static void main(String[] args){
        Scanner keyboard= new Scanner(System.in);
        int year=-1,month=-1,day;
         while (true) {
            System.out.print("Please enter a year:");
            String Stryear= keyboard.nextLine().trim();
            try {
                year =Integer.parseInt(Stryear);
                if (year< 0){
                    System.out.println("Invalid,Please enter a valid year,Try again!");
                    continue;
                }
            }catch (NumberFormatException e) {
                System.out.println("Invalid,Please enter a valid year,Try again!");
                continue;
            }
            break;
         }
        do{
        System.out.print("Please enter a month:");
        String Strmonth;
        Strmonth= keyboard.nextLine().trim();
        month= checkmonth(Strmonth);
        if(month==-1){
            System.out.println("Invalid month,Try again");
        }
    }while(month==-1);
    day=check(month,year);
    System.out.print("The day of month is:"+day);
    keyboard.close();
    }
public static int checkmonth(String Strmonth){
    switch(Strmonth.toLowerCase())
    {
        case "january":
        case "jan.":
        case "jan":
        case "1":
            return 1;
        case "february":
        case "feb.":
        case "feb":
        case "2":
            return 2;
        case "march":
        case "mar.":
        case "mar":
        case "3":
            return 3;
        case "april":
        case "apr.":
        case "apr":
        case "4":
            return 4;
        case "may":
        case "5":
            return 5;
        case "june":
        case "jun":
        case "6":
            return 6;
        case "july":
        case "jul":
        case "7":
            return 7;
        case "august":
        case "aug.":
        case "aug":
            return 8;
        case "september":
        case "sept.":
        case "sep":
        case "9":
            return 9;
        case "october":
        case "oct.":
        case "oct":
        case "10":
            return 10;
        case "november":
        case "nov.":
        case "nov":
        case "11":
            return 11;
        case "december":
        case "dec.":
        case "dec":
        case "12":
           return 12;
        default:
            return -1;
        }
    }
public static int check(int month,int year){
    switch(month){
        case 1:
        case 3:
        case 5:
        case 7:
        case 8:
        case 10:
        case 12:
            return 31;
        case 4:
        case 6:
        case 9:
        case 11:
            return 30;
        case 2:
            if(checkyear(year)==1) return 29;
            else return 28;
        default: return -1;
    }
}
public static int checkyear(int year){
    if((year%4==0&&year%10!=0)||(year%400==0)) return 1;
    else return 0;
}
    }
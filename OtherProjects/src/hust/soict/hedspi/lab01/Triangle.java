package hust.soict.hedspi.lab01;

import java.util.Scanner;
public class Triangle{
    public static void main(String[] args){
        Scanner keyboard= new Scanner(System.in);
        System.out.println("Please input the value of n");
        int n=keyboard.nextInt();
        int k=0;
       while(n>0){
        for(int i=1;i<=n-1;i++){
            System.out.print(" ");
            }
        for(int j=1;j<=2*k+1;j++){
            System.out.print("*");
        }
        System.out.print("\n");
        n=n-1;
        k=k+1;
    }
    System.exit(0);
}
}
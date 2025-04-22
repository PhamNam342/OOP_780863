package hust.soict.hedspi.lab01;

import java.util.Scanner;
public class Array{
    public static void main(String[] args){
        Scanner keyboard= new Scanner(System.in);
        System.out.print("Please enter the value of length:");
        int n= keyboard.nextInt();
        int numbers[]=new int[n];
        double sum=0.0;
        for(int i=0;i<n;i++){
            System.out.print("Please enter the value of "+(i+1)+": ");
            numbers[i]= keyboard.nextInt();
            sum+=numbers[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(numbers[i]>numbers[j]){
                    int tmp=numbers[i];
                    numbers[i]=numbers[j];
                    numbers[j]=tmp;
                }
            }
        }
        System.out.print("Array after sorting is: ");
        for(int i=0;i<n;i++){
            System.out.print(numbers[i]+ " ");
        }
        System.out.print("\n");
        double average=sum/n;
        System.out.println("Sum of array is: "+ sum);
        System.out.println("Average of array is: "+ average);
        keyboard.close();
    } 
}
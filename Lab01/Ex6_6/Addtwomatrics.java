import java.util.Scanner;
public class Addtwomatrics{
    public static void main(String[] args){
        Scanner keyboard= new Scanner(System.in);
        int row,col;
        System.out.print("Please enter the size of row: ");
        row= keyboard.nextInt();
        System.out.print("Please enter the size of col: ");
        col= keyboard.nextInt();
        int matric1[][]=new int[row+1][col+1];
        int matric2[][]=new int[row+1][col+1];
        int matric[][]=new int[row+1][col+1];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Please enter the value of matric1"+"["+(i+1)+"]"+"["+(j+1)+"]"+": ");
                matric1[i][j]=keyboard.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print("Please enter the value of matric2"+"["+(i+1)+"]"+"["+(j+1)+"]"+": ");
                matric2[i][j]=keyboard.nextInt();
            }
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                matric[i][j]=matric1[i][j]+matric2[i][j];
            }
        }
        System.out.println("Sum of two matrics:");
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                System.out.print(matric[i][j]+" ");
            }
            System.out.print("\n");
        }
        keyboard.close();
    }    
}
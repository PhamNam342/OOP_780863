package hust.soict.hedspi.lab01;

import javax.swing.JOptionPane;
class firstDegreeEquation1{
    public static void main(String[] args){
        String Strnum1,Strnum2;
        Strnum1=JOptionPane.showInputDialog(null,"Please input the first number:","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        Strnum2=JOptionPane.showInputDialog(null,"Please input the second number:","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double num1=Double.parseDouble(Strnum1);
        double num2=Double.parseDouble(Strnum2);
        if(num1==0){
            if(num2==0){
                JOptionPane.showMessageDialog(null,"Infinite solutions","RESULTS",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"No solution","RESULT",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            double root=(-num2)/num1;
            JOptionPane.showMessageDialog(null,"ROOT IS:"+root,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        }   
    System.exit(0);
    }
}
class firstDegreeEquation2{
    public static void main(String[] args){
        String Strnum12,Strnum11,Strnum21,Strnum22,Strnuma,Strnumb;
        Strnum11=JOptionPane.showInputDialog(null,"Please input the value of a11: ","Input the a11 ",JOptionPane.INFORMATION_MESSAGE);
        Strnum12=JOptionPane.showInputDialog(null,"Please input the value of a12: ","Input the a12 ",JOptionPane.INFORMATION_MESSAGE);
        Strnum21=JOptionPane.showInputDialog(null,"Please input the value of a21: ","Input the a21 ",JOptionPane.INFORMATION_MESSAGE);
        Strnum22=JOptionPane.showInputDialog(null,"Please input the value of a22: ","Input the a22 ",JOptionPane.INFORMATION_MESSAGE);
        Strnuma=JOptionPane.showInputDialog(null,"Please input the value of b1: ","Input the a ",JOptionPane.INFORMATION_MESSAGE);
        Strnumb=JOptionPane.showInputDialog(null,"Please input the value of b2","Input the b ",JOptionPane.INFORMATION_MESSAGE);
        double a11=Double.parseDouble(Strnum11);
        double a12=Double.parseDouble(Strnum12);
        double a21=Double.parseDouble(Strnum21);
        double a22=Double.parseDouble(Strnum22);
        double b1=Double.parseDouble(Strnuma);
        double b2=Double.parseDouble(Strnumb);
        double d=a11*a22 - a21*a12;
        double d1=b1*a22 - b2*a12;
        double d2=a11*b2 - a21*b1;
        if(d==0&&d1==0){
            JOptionPane.showMessageDialog(null,"infinite many solutions","RESULT",JOptionPane.INFORMATION_MESSAGE);
        }
        if(d==0&&d1!=0){
            JOptionPane.showMessageDialog(null,"No solution","RESULT",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            double x=d1/d;
            double y=d2/d;
            JOptionPane.showMessageDialog(null, "solution:\n\tx = " + x + "\n\ty = " + y,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        }
         System.exit(0);
    }
}
class secondDegreeEquation{
    public static void main(String[] args){
        String Strnuma,Strnumb,Strnumc;
        Strnuma=JOptionPane.showInputDialog(null,"Please input the value of a ","Input the a ",JOptionPane.INFORMATION_MESSAGE);
        Strnumb=JOptionPane.showInputDialog(null,"Please input the value of b: ","Input the b ",JOptionPane.INFORMATION_MESSAGE);
        Strnumc=JOptionPane.showInputDialog(null,"Please input the value of c: ","Input the c ",JOptionPane.INFORMATION_MESSAGE);
        double a=Double.parseDouble(Strnuma);
        double b=Double.parseDouble(Strnumb);
        double c=Double.parseDouble(Strnumc);
        double delta=b*b - 4*a*c;
        if(a==0){
            if(b==0){
                if(c==0){
                    JOptionPane.showMessageDialog(null,"Infinite solutions","RESULTS",JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane.showMessageDialog(null,"No solution","RESULTS",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else{
                double x=(-c)/b;
                JOptionPane.showMessageDialog(null,"Only one solution: "+x,"RESULTS",JOptionPane.INFORMATION_MESSAGE);
            }
        }
        else{
            if(delta>0){
                double x1=(-b+Math.sqrt(delta))/(2*a);
                double x2=(-b-Math.sqrt(delta))/(2*a);
                JOptionPane.showMessageDialog(null,"The first root is"+x1+"\nThe second root is"+x2,"RESULTS",JOptionPane.INFORMATION_MESSAGE);
            }
            else if(delta==0){
                double x3=(-b)/(2*a);
                JOptionPane.showMessageDialog(null,"Only one root is:"+x3,"RESULTS",JOptionPane.INFORMATION_MESSAGE);
            }
            else{
                JOptionPane.showMessageDialog(null,"The equation has no solution","RESULTS",JOptionPane.INFORMATION_MESSAGE);
            }
        }
         System.exit(0);
        }
    }
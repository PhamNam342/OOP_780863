import javax.swing.JOptionPane;
public class Calculate{
    public static void main(String[] args){
        String Num1,Num2;
        Num1= JOptionPane.showInputDialog(null,"Please input the first number","Input the first number",JOptionPane.INFORMATION_MESSAGE);
        Num2= JOptionPane.showInputDialog(null,"Please input the second number","Input the second number",JOptionPane.INFORMATION_MESSAGE);
        double so1=Double.parseDouble(Num1);
        double so2=Double.parseDouble(Num2);
        double sum= so1 + so2;
        double product= so1*so2;
        double difference= so1 - so2;
        JOptionPane.showMessageDialog(null,"Sum of two numbers is:"+ sum,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Product of two numbers is:"+ product,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null,"Difference of two numbers is:"+ difference,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        if(so2!=0){
            double quotient=so1/so2;
            JOptionPane.showMessageDialog(null,"Quotient of two numbers is:"+ quotient,"RESULT",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Cannot perform","ERROR",JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
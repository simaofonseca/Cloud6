import java.util.Scanner;

public class Calculadora2 {
    
        public static void main(String[] args){
            
  
                
            Scanner scanner = new Scanner(System.in);
             
            System.out.print("Enter first number:");
            int a = scanner.nextInt();

            System.out.println("Enter Action:");
            char c = scanner.next().charAt(0) ;
    
            System.out.print("Enter second number:");
            int b = scanner.nextInt();

     
            scanner.close();

            
           Metodoscalc metodoscalc = new Metodoscalc();
         //   System.out.print("Soma= " + Metodoscalc.sum(a, b));
         //   System.out.print("Sub= " + Metodoscalc.sub(a, b));

            switch (c) {
                case  '+':
                System.out.print("Soma= " + Metodoscalc.sum(a, b));                
                break;
                case '-':
                System.out.print("Subtracao= " + Metodoscalc.sub(a, b));
                break;
                case '/':
                System.out.print("Divisao= " + Metodoscalc.div(a, b));
                break;
                case '*':
                System.out.print("Multiplicação= " + Metodoscalc.mult(a, b));
                break;

            
                default:
                    break;
            }
            

        }
}
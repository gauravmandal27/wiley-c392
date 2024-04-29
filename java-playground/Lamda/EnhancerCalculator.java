package Lamda;

interface MathematicalOperation{
    public int doOperation(int a,int b);
}
public class EnhancerCalculator {
    static int calculate(int a,int b,MathematicalOperation op){
        return op.doOperation(a,b);
    }
    public static void main(String[] args) {
        var result=calculate(40,39,(a,b)->a+b);
        System.out.println(result);
        System.out.println("Multiplication of A & B is "+calculate(40,39,(a,b)->a*b));
        System.out.println("Max of A or B is "+calculate(40,39,(a,b)->Math.max(a,b)));
    }
}

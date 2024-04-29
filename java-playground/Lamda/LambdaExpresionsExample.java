package Lamda;
interface Length{
  int getLength(String a);
    }
interface Empty{
    boolean isItEmpty(String a);
}

interface Max{
    int isItMax(int a,int b);
}


public class LambdaExpresionsExample {
    public static void main(String[] args) {
        Length ex = (a)->+a.length();
        System.out.println("String Length="+ex.getLength("Hello There"));

        Empty blank = (a)->a.isEmpty();
        System.out.println("Is the STring EMpty "+blank.isItEmpty("msngjk"));

        Max max =(a,b)->(a>b)?a:b;
        System.out.println("The Max Val is "+max.isItMax(10,30));
    }
}

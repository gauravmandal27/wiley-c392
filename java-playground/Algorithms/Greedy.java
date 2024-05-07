package Algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Greedy {
    public static ArrayList<Integer> greedyApproach(int[] arr,int amount){
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        int i=arr.length-1,result=0;
        while(result!=amount && i>=0){
            if(result+arr[i]<=amount){
                result+=arr[i];
                list.add(arr[i]);
            }
            else{
                i--;
            }
        }
        return list;
    }
    public static void main(String[] args) {
        int[] arr ={1,5,10,25};
        System.out.println("Enter the amount");
        Scanner sc= new Scanner(System.in);
        int amount=sc.nextInt();
        System.out.println(greedyApproach(arr,amount));
    }
}

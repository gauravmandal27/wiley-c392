import java.util.ArrayList;
import java.util.List;

public class DuplicateCheck {
    public static int countDuplicated(ArrayList<Integer> arr1, ArrayList<Integer> arr2){
        int count=0;
        for(var number:arr1){
            if(arr2.contains(number)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        ArrayList<Integer> arr1=new ArrayList<>(List.of(2,5,3,6,7));
        ArrayList<Integer>  arr2=new ArrayList<>(List.of(4,2,6,8,9));
        System.out.println(countDuplicated(arr1,arr2));
    }
}

public class BinarySearchExample {
    public static int BinarySearch(int arr[],int key){
        int p=0,r=arr.length,q;
        while(p<=r){
            q=(p+r)/2;
            if(arr[q]==key){
                return q;
            }
            else if(arr[q]<key){
                p=q+1;
            }
            else{
                r=q-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array= new int[]{3, 4, 2, 5, 6, 7, 10, 49, 59};
        System.out.println(BinarySearch(array,10));
        System.out.println(BinarySearch(array,4));
        System.out.println(BinarySearch(array,3));
        System.out.println(BinarySearch(array,49));
        System.out.println(BinarySearch(array,50));

    }
}

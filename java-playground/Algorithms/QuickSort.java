package Algorithms;

public class QuickSort {
    public void quickSort(int[] arr,int p,int r){
        if(p<r){
            int q=partition(arr,p,r);
            quickSort(arr,p,q-1);
            quickSort(arr,q+1,r);
        }
    }
    public int partition(int[] arr,int p,int r){
        int pivot=arr[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<=pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;

        return i+1;
    }
    public static void main(String[] args) {
        int[] array= new int[]{3, 4, 2, 5, 6, 7, 10, 49, 59};
        QuickSort qs = new QuickSort();
        qs.quickSort(array,0,array.length-1);
        for (int j : array) System.out.println(j);

    }
}

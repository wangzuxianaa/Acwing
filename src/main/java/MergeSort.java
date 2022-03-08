import java.util.*;
import java.io.*;

public class MergeSort {
    private static int N = 100010;
    private static int[] temp = new int[N];
    public static void mergeSort(int[] arr, int l, int r) {
        if(l >= r)
            return;
        int mid = l + r >> 1;
        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);

        int i = l, j = mid + 1, k = 0;
        while(i <= mid && j <= r) {
            if(arr[i] <= arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }
        while(i <= mid) {
            temp[k++] = arr[i++];
        }
        while(j <= r) {
            temp[k++] = arr[j++];
        }
        for(i = l, j = 0; i <= r; i++,j++)
            arr[i] = temp[j];
    }
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        String[] strs = reader.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
            //System.out.print(arr[i] + " "); 
        }
        mergeSort(arr, 0, n-1);
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        reader.close();
    }
}
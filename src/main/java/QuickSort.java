import java.io.BufferedInputStream;
import java.util.Scanner;

public class QuickSort {
    public static void quick_sort(int[] q, int l, int r) {
        if(l >= r)
            return;
        int i = l-1, j = r+1, x = q[l];
        while(i < j) {
            do i++; while(q[i] < x);
            do j--; while(q[j] > x);
            if(i < j) {
                int temp = q[i];
                q[i] = q[j];
                q[j] = temp;
            }
        }
        quick_sort(q, l, j);
        quick_sort(q, j+1, r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        quick_sort(arr, 0, n-1);

        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

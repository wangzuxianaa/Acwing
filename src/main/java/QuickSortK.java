import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class QuickSortK {
    public static void quick_sort_k(int[] arr, int l, int r, int k) {

        if(l >= r)
            return;

        // 快排模板
        int i = l-1, j = r+1, q = arr[l];
        while(i < j) {
            do i++; while(arr[i] < q);
            do j--; while(arr[j] > q);

            if(i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // 如果k是在左边序列，则只需排序左边即可，若是在右边则要注意此时搜索的是第k-sl的数
        int sl = j-l+1;
        if(k <= sl)
            quick_sort_k(arr, l, j, k);
        else
            quick_sort_k(arr, j+1, r, k-sl);
    }
    public static void main(String[] args) throws IOException {
        // 创建读入类
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // 将其保存到字符串数组里面
        String[] strs = reader.readLine().split(" ");
        int n = Integer.parseInt(strs[0]);
        int k = Integer.parseInt(strs[1]);
        int[] arr = new int[n];

        strs = reader.readLine().split(" ");
        for(int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }
        // 通过快排实现快速选择算法
        quick_sort_k(arr, 0, n-1, k);
        System.out.print(arr[k-1]);
    }
}

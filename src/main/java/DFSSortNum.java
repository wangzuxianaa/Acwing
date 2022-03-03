import java.util.Scanner;

public class DFSSortNum {
    private static int N = 10;
    private static int n;
    private static int[] path = new int[N];
    private static boolean[] visited = new boolean[N];

    public static void  dfs(int u)
    {
        if(u == n) {
            for(int i = 0; i < n; i++) System.out.print(path[i] + " ");
            System.out.println();
            return;
        }
        for(int i = 1; i <= n; i++) {
            if(!visited[i-1]) {
                path[u] = i;
                visited[i-1] = true;
                dfs(u+1);
                visited[i-1] = false;
                path[u] = 0;
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dfs(0);
        return;
    }
}

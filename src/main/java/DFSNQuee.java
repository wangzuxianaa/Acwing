import java.util.Scanner;

public class DFSNQuee {
    private static int N = 20;
    private static int n;
    private static char[][] path = new char[N][N];
    private static boolean[] col = new boolean[N];
    private static boolean[] dg = new boolean[N];
    private static boolean[] udg = new boolean[N];

    public static void dfs(int u)
    {
        //到达最底行，将结果输出
        if(u == n) {
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    System.out.print(path[i][j]);
                }
                System.out.println();
            }
            return;
        }

        //扫描一整列
        for(int i = 0; i < n; i++) {
            //如果列所在列，列所在对角线和列所在的反对角线都没有被访问过
            if(!col[i] && !dg[i-u+n] && !udg[i+u]) {
                //置为Q
                path[u][i] = 'Q';
                col[i] = dg[i-u+n] = udg[i+u] = true;
                dfs(u+1);
                //回溯
                col[i] = dg[i-u+n] = udg[i+u] = false;
                path[u][i] = '.';
            }
        }
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        //初始化
        for(int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                path[i][j] = '.';
        dfs(0);
    }
}

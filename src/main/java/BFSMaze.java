import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSMaze {
    private static int N = 110;
    private static int[][] map = new int[N][N];
    //用一个数组记录是否访问过相应的点
    private static boolean[][] visited = new boolean[N][N];

    //输入迷宫的行数与列数
    public static int bfs(int m, int n) {
        //使用队列保存每一次搜索到的值
        Queue<int[]> queue = new LinkedList<>();
        //分别是四个方向(-1, 0),(0, 1),(1, 0),(0, -1)
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        //记录距离记录到达点m-1，n-1的距离
        int[][] d = new int[N][N];

        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        d[0][0] = 0;

        while(!queue.isEmpty()) {
            int[] q = queue.poll();
//            if(q[0] == m-1 && q[1] == n-1)
//                break;
            //四个方向循环
            for(int i = 0; i < 4; i++) {
                int x = q[0] + dx[i];
                int y = q[1] + dy[i];
                //不能访问的情形，有阻碍，访问过的或者出界了
                if(x >= 0 && x < m && y >= 0 && y < n && map[x][y] != 1 && !visited[x][y]) {
                    queue.offer(new int[]{x, y});
                    d[x][y] = d[q[0]][q[1]] + 1;
                    visited[x][y] = true;
                }
            }
        }
        //返回距离
        return d[m-1][n-1];

    }
    public static void  main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                map[i][j] = in.nextInt();
            }
        }
        System.out.println(bfs(m, n));

    }
}

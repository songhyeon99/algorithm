class Solution {
    static int[][] dp;
    static int M;
    static int N;
    static int[] dx = {1, 0};
    static int[] dy = {0, 1};
    static boolean[][] puddleMap;

    public int solution(int M, int N, int[][] puddles) {
        this.M = M;
        this.N = N;
        dp = new int[M][N];
        puddleMap = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        for (int[] puddle : puddles) {
            puddleMap[puddle[0] - 1][puddle[1] - 1] = true;
        }

        return dfs(0,0);
    }

    static int dfs(int x, int y) {
        if (x == M - 1 && y == N - 1) {
            return 1;
        }

        if (puddleMap[x][y]) {
            return 0;
        }

        if (dp[x][y] != -1) {
            return dp[x][y] % 1000000007;
        }

        dp[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                dp[x][y] += dfs(nx, ny) % 1000000007;
            }
        }

        return dp[x][y] % 1000000007;
    }
}
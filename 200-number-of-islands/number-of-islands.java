class Solution {
    // Direction arrays for moving Up, Down, Left, Right
    int[] x = {-1, 1, 0, 0};
    int[] y = {0, 0, -1, 1};

    // Boundary check helper
    boolean valid(int i, int j, int n, int m) {
        if (i < 0 || i >= n || j < 0 || j >= m) return false;
        return true;
    }

    // DFS traversal
    void dfs(char[][] a, int n, int m, int i, int j, boolean[][] vis) {
        vis[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int row = i + x[k];
            int col = j + y[k];

            if (valid(row, col, n, m) && a[row][col] == '1' && !vis[row][col]) {
                dfs(a, n, m, row, col, vis);
            }
        }
    }

    public int numIslands(char[][] a) {
        if (a == null || a.length == 0) return 0;

        int n = a.length;
        int m = a[0].length;
        int res = 0;
        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (a[i][j] == '1' && !vis[i][j]) {
                    dfs(a, n, m, i, j, vis);
                    res++;
                }
            }
        }
        return res;
    }
}
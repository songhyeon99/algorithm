class Solution {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        for(int i = 0; i<sizes.length; i++) {
            int tempRow = Math.min(sizes[i][0], sizes[i][1]);
            int tempCol = Math.max(sizes[i][0], sizes[i][1]);
        
            row = Math.max(row, tempRow);
            col = Math.max(col, tempCol);
        }
        return row * col;
    }
}
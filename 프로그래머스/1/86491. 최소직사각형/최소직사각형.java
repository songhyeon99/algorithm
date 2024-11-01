import java.util.*;
class Solution {
    public int solution(int[][] sizes) {
        int row = 0;
        int col = 0;
        
        for(int i = 0; i<sizes.length; i++){
            int r = Math.max(sizes[i][0], sizes[i][1]);
            int c = Math.min(sizes[i][0], sizes[i][1]);
            
            row = Math.max(r, row);
            col = Math.max(c, col);
        }
        return row * col;
    }
}
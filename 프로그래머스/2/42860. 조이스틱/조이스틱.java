class Solution {
    public int solution(String name) {
        int nameSize = name.length();
        int count = 0;
        int idx;
        int move = nameSize-1;
            for(int i = 0; i < nameSize; i++){
                count += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i)+1);
                
                idx = i + 1;
                while(idx < nameSize && name.charAt(idx) == 'A') { 
                    idx++;
                }
                move = Math.min(move, i * 2 + nameSize - idx);
                move = Math.min(move, (nameSize - idx) * 2 + i);
            }
        return count + move;
        }
    }
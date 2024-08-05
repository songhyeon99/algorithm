import java.util.*;
class Solution {
    static boolean isDone;
    static boolean[] visited;
    static int result = 0, count = 0;
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        List<String> list  = List.of(words);
		if(!list.contains(target)){
			return 0;
		}else {
			dfs(begin, target, words);
			return result;
		}
    }
    
    static int dfs(String word, String target, String[] words){
		for (int i = 0; i < words.length; i++) {
			if(!visited[i]) {
				if(compare(word, target) == 1){
					result++;
					isDone = true;
					return result;
				}
				if (compare(word, words[i]) == 1) {
					visited[i] = true;
					result++;
					dfs(words[i], target, words);
					if(isDone) return result;
				}
			}
		}
        return result;
    }
    
    static int compare(String current, String word){
		int count = 0;
		for (int j = 0; j < word.length(); j++) {
			if (current.charAt(j) != word.charAt(j)) {
				count++;
			}
		}
		return count;
	}
}
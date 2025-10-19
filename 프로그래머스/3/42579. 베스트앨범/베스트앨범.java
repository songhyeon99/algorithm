import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        Map<String, PriorityQueue<Integer>> genresMap = new HashMap<>();
        Map<String, Integer> sum = new HashMap<>();
        
        for(int i = 0; i<genres.length; i++){
                        genresMap.computeIfAbsent(genres[i], k -> new PriorityQueue<>(
                    (a, b) -> plays[b] - plays[a]
            )).add(i);

            sum.put(genres[i], sum.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        List<String> sortedGenres = sum.entrySet().stream()
                .sorted((e1, e2) -> e2.getValue() - e1.getValue())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        
        List<Integer> answerList = new ArrayList<>();
        for(int i = 0; i< sortedGenres.size(); i++) {
            PriorityQueue<Integer> genre = genresMap.get(sortedGenres.get(i));
            if (genre != null && !genre.isEmpty()) answerList.add(genre.poll());
            if (genre != null && !genre.isEmpty()) answerList.add(genre.poll());
        }
        
        
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
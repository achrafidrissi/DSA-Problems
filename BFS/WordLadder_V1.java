package BFS;

// =====================================================
// 127. Word Ladder
// =====================================================

import java.util.*;

public class WordLadder_V1 {
    public int ladderLength(String beginWord,String endWord, List<String> wordList ){
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord))
            return 0;

        Queue<String> queue = new LinkedList<>();
        int shortestPath = 1;
        queue.offer(beginWord);
        while (!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i<size;i++){
                String currentWord = queue.poll();
                Iterator<String> iterator = wordSet.iterator();
                while (iterator.hasNext()){
                    String wordToCompare = iterator.next();
                    if(DifferenceNumber(currentWord, wordToCompare) == 1 ){
                        if(wordToCompare.equals(endWord)){
                            return shortestPath+1;
                        }
                        queue.offer(wordToCompare);
                        iterator.remove();
                    }
                }
            }
            shortestPath++;
        }
        return 0;
    }
    public int DifferenceNumber(String firstWord, String secondWord){
        int count = 0;
        if(firstWord.length()!=secondWord.length()) return -1;
        for (int i = 0 ; i<firstWord.length(); i++){
            if(firstWord.charAt(i)!=secondWord.charAt(i)){
                count++;
            }
        }
        return count;
    }
}

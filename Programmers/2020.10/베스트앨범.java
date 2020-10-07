import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class Programmers {    
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	String[] genres = {"classic", "pop", "classic", "classic", "pop"};
    	int[] plays = {500, 600, 150, 800, 2500};
    	int[] answer = solution(genres, plays);
    	
    	for (int i = 0; i < answer.length; i++) {
    		System.out.println(answer[i]);
    	}
    }
    
    public static int[] solution(String[] genres, int[] plays) {
        int len = genres.length;
        HashMap<String,Integer> map = new HashMap<String,Integer>();
        Song[] songs = new Song[len];
        
        for (int i = 0; i < len; i++) {
            String genre = genres[i];
            int play = plays[i];
            
            if (map.containsKey(genre)) {
                int sum  = map.get(genre);
                map.put(genre, sum + play);
            }
            else {
                map.put(genre, play);
            }
            
            songs[i] = new Song(i, play, genre);
        }
        
        ArrayList<String> keySetList = new ArrayList<String>(map.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int a = map.get(o1);
                int b = map.get(o2);
                if (a > b) {
                    return -1;
                }
                if (a < b) {
                    return 1;
                }
                return 0;	
            }
        });
        
        ArrayList<Integer> best = new ArrayList<Integer>();
        len = keySetList.size();
        
        for (int i = 0; i < len; i++) {
            String genre = keySetList.get(i);
            ArrayList<Song> list = new ArrayList<Song>();
            
            for (int j = 0; j < songs.length; j++) {
                if (genre.equals(songs[j].genre)) {
                    list.add(songs[j]);
                }
            }
            
            if (list.size() == 1) {
                best.add(list.get(0).num);
            }
            else {
                Collections.sort(list, new Comparator<Song>() {
                    @Override
                    public int compare(Song o1, Song o2) {
                        if (o1.play > o2.play) {
                            return -1;
                        }
                        else if (o1.play < o2.play) {
                            return 1;
                        }
                        else {
                            if (o1.num > o2.num) {
                                return 1;
                            }
                            else {
                                return -1;
                            }
                        }
                    }
                });
                best.add(list.get(0).num);
                best.add(list.get(1).num);
            }
        }
        
        len = best.size();
        int[] answer = new int[len];
        for (int i = 0; i < len; i++) {
            answer[i] = best.get(i);
        
        }
        return answer;
    }
}
class Song {
    int num;
    int play;
    String genre;
    
    public Song (int num, int play, String genre) {
        this.num = num;
        this.play = play;
        this.genre = genre;
    }
}
package sm.ptfs.week1;

import java.util.HashMap;

public class Task {
    public static void Run(){
        // bear minimum approach XD
        HashMap<String, Integer> leaderboard = new HashMap<>();
        leaderboard.put("Agnieszka Cieślak", 0);
        leaderboard.put("Grzegorz Kasperski", 0);
        leaderboard.put("Kamil Leśniak", 0);
        leaderboard.put("Marcin Janczurewicz", 0);
        leaderboard.put("Michał Surowiec", 0);

        for(String key : leaderboard.keySet())
            System.out.printf("%s -> %d%n", key, leaderboard.get(key));
    }
}

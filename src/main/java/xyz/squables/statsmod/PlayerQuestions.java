package xyz.squables.statsmod;

import java.util.HashMap;
import java.util.Map;

public class PlayerQuestions {
    private Map<String, String> playerMap = new HashMap<>();

    public boolean isPlayerOccupied(String s) {
        return playerMap.containsKey(s);
    }

    public void clearMap(String s) {
        Map<String, String> newMap = new HashMap<>();
        for(Map.Entry<String, String> e : newMap.entrySet()) {
            if(!e.getKey().equals(s)) newMap.put(e.getKey(), e.getValue());
        }
        this.playerMap = newMap;
    }

    public String getAnswer(String usn) {
        if(!isPlayerOccupied(usn)) return null;
        return this.playerMap.get(usn);
    }

    public void setQuestionAnswer(String usn, String answer) {
        this.clearMap(usn);
        this.playerMap.put(usn, answer);
    }
}

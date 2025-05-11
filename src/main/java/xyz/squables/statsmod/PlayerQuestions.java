package xyz.squables.statsmod;

import xyz.squables.statsmod.question.types.Question;

import java.util.HashMap;
import java.util.Map;

public class PlayerQuestions {
    private Map<String, Question<?>> playerMap = new HashMap<>();

    public boolean isPlayerOccupied(String s) {
        return playerMap.containsKey(s);
    }

    public void clearMap(String s) {
        Map<String, Question<?>> newMap = new HashMap<>();
        for(Map.Entry<String, Question<?>> e : newMap.entrySet()) {
            if(!e.getKey().equals(s)) newMap.put(e.getKey(), e.getValue());
        }
        this.playerMap = newMap;
    }

    public Question<?> getQuestion(String usn) {
        if(!isPlayerOccupied(usn)) return null;
        return this.playerMap.get(usn);
    }

    public void setQuestionAnswer(String usn, Question<?> answer) {
        this.clearMap(usn);
        this.playerMap.put(usn, answer);
    }
}

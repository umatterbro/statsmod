package xyz.squables.statsmod.question.options.chapters.chp4;

import org.apache.commons.lang3.NotImplementedException;
import org.bukkit.Bukkit;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.Answers;
import xyz.squables.statsmod.question.options.QuestionOptions;
import xyz.squables.statsmod.question.options.variables.VariableOptions;
import xyz.squables.statsmod.question.options.variables.VariableType;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.options.variables.types.dependent.DependentIntOptions;
import xyz.squables.statsmod.question.types.QuestionType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// reference #18
/*
You want to take an SRS of 50 of the 816 students who live in a dormitory on campus. You label the students
001 to 816 in alphabetical order. In the table of random digits you read the entries
95592 94007 69769 33547 72450 16632 81194 14873
The first three students in your sample have labels
    a. 955, 929, and 400.
    b. 400, 769, and 769.
    c. 559, 294, and 007.
    d. 929, 400, and 769.
    e. 400, 769, and 335.
*/
public class SRSRandomSelectionOptions extends QuestionOptions {
    protected final IntOptions personCount = new IntOptions("Person count", 200, 600);
    protected final IntOptions srsSize = new IntOptions("SRS size", new Integer[] {
            50, 75, 100, 125, 150
    });
    protected List<Integer> randomDigits = Util.generateRandomDigits(8);

    public int getSrsSize() { return srsSize.getValue(); }
    public int getPersonCount() { return personCount.getValue(); }
    public List<Integer> getRandomDigits() { return randomDigits; }

    public SRSRandomSelectionOptions() {
        super(QuestionType.SRSRANDOMSELECTION);
    }

    private List<Integer> findValidDigits(List<Integer> ints, int intLimit, int listLimit) {
        List<Integer> newInts = new ArrayList<>();
        for(int i : ints) {
            if(i <= intLimit) newInts.add(i);
            if(newInts.size() == listLimit) break;
        }
        return newInts;
    }

    private List<Integer> generateWrongAnswer(List<Integer> ints) {
        List<Integer> newInts = new ArrayList<>();
        while(true) {
            for(int i = 0; i < 3; i++) newInts.add(ints.get(Util.generateRandomInt(0, ints.size())));

            int j = 0;
            for(int i : newInts) {
                if(i <= this.personCount.getValue()) j++;
            }

            if(j < 2) break;
            else newInts.clear();
        }

        return newInts;
    }

    @Override
    public <T> Answers<T> generateAnswers(QuestionType qt, Class<T> tClass) {
        if(qt.type == VariableType.STRING) {
            String answer;
            List<Integer> rdsVals;
            while(true) {
                String rds = String.join("", Util.numberGenericListToStringList(this.randomDigits));
                List<String> rdsValsStrs = Util.splitInto(rds, 3, false);
                rdsVals = Util.stringListToIntList(rdsValsStrs);
                List<Integer> answerList = findValidDigits(rdsVals, personCount.getValue(), 3);
                answer = String.join(", ", Util.numberGenericListToStringList(answerList));
                if(answerList.size() == 3) break;
            }

            List<T> answers = new ArrayList<>();
            Bukkit.getConsoleSender().sendMessage(this.srsSize.getValue() + ", " + this.personCount.getValue());
            Bukkit.getConsoleSender().sendMessage("got answer: " + answer);

            for(int i = 0; i < 4; i++) {
                answers.add(tClass.cast(String.join(", ", Util.numberGenericListToStringList(this.generateWrongAnswer(rdsVals)))));
            }

            T cc = tClass.cast(answer);
            answers.addFirst(cc);
            Collections.shuffle(answers);
            return new Answers<>(answers, cc);
        } else {
            throw new NotImplementedException("nope");
        }
    }
}

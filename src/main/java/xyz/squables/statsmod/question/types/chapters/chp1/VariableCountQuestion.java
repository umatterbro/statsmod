package xyz.squables.statsmod.question.types.chapters.chp1;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.chapters.chp1.VariableCountOptions;
import xyz.squables.statsmod.question.options.variables.types.IntOptions;
import xyz.squables.statsmod.question.options.variables.types.dependent.DependentStringOptions;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.question.types.QuestionType;

// reference #6
// You measure the age (years), weight (pounds), and marital status (single, married, divorced, or widowed)
// of 1400 women. How many variables did you measure?
public class VariableCountQuestion extends Question<VariableCountOptions> {
    // this is a certified #chatgpt moment
    // only used AI for this because im too lazy to think of examples :(
    private String[] templates = new String[] {
            "You measure the %s of %d people. How many variables did you measure?"
    };

    private String randomTemplate() {
        return templates[Util.generateRandomInt(0, templates.length)];
    }

    public VariableCountQuestion() {
        super(QuestionType.VARIABLECOUNT, new VariableCountOptions());
        this.template = randomTemplate();
    }

    protected DependentStringOptions variables = new DependentStringOptions("Variables", new String[] {
            "height", "weight", "eye color", "hair color", "skin tone", "body type", "blood type", "age", "sex", "facial features", "voice pitch", "vision", "shoe size", "heart rate", "blood pressure", "bmi"
    });

    protected IntOptions personCount = new IntOptions("Person count", new Integer[] {
            10, 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500
    });

    @Override
    public void send(Player p, boolean useTextComponents) {
        String vars = Util.joinAndAddAnd(variables.generateAmount(((int) this.answers.getCorrectAnswer())));
        p.sendMessage(this.formatTemplate(vars, personCount.generateRandom()));
        for(int i = 0; i < this.answers.getAnswerOptions().size(); i++) {
            var ans = this.answers.getAnswerOptions().get(i);
            TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&l" + Util.intToColor(i) + (i+1) + "&r&8]: &f" + ans));
            if(useTextComponents) {
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(ans.toString())));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/answer " + ans));
            }
            p.sendMessage(tc);
        }
    }
}

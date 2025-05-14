package xyz.squables.statsmod.question.types.chapters.chp3;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.chapters.chp2.PercentileOfPopulationAnswers;
import xyz.squables.statsmod.question.options.chapters.chp3.LSLRPredictOptions;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.question.types.QuestionType;

// reference #42
/*
A study gathers data on the outside temperature during the winter, in degrees Fahrenheit, and the amount of
natural gas a household consumes, in cubic feet per day. Call the temperature x and gas consumption y. The
house is heated with gas, so x helps explain y. The least-squares regression line for predicting y from x is
y=1344-19x. On a day when the temperature is 20F, the regression line predicts that gas used will be
about
    a. 1724 cubic feet.
    b. 1383 cubic feet.
    c. 1325 cubic feet.
    d. 964 cubic feet.
    e. none of these.*/
public class LSLRPredictQuestion extends Question<LSLRPredictOptions> {
    private String[] templates = new String[] {
            "A study gathers data on the outside temperature during the winter, in degrees Fahrenheit, and the amount of natural gas a household consumes, in cubic feet per day. Call the temperature x and gas consumption y. The house is heated with gas, so x helps explain y. The least-squares regression line for predicting y from x is y=%d-%dx. On a day when the temperature is %dF, the regression line predicts that gas used will be about"
    };

    private String randomTemplate() {
        return templates[Util.generateRandomInt(0, templates.length)];
    }

    public LSLRPredictQuestion() {
        super(QuestionType.LSLRPREDICT, new LSLRPredictOptions(), null);
        this.template = randomTemplate();
    }

    @Override
    public void send(Player p, boolean useTextComponents) {
        p.sendMessage(this.formatTemplate(this.options.getSlope(), this.options.getYInt(), this.options.getXVal()));
        for(int i = 0; i < this.answers.getAnswerOptions().size(); i++) {
            var ans = this.answers.getAnswerOptions().get(i);
            TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&l" + Util.intToColor(i) + (i+1) + "&r&8]: &f" + ans));
            if(useTextComponents) {
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text(this.options.getSlope() + "+(" + this.options.getYInt() + "*" + this.options.getXVal() + ") = " + ans.toString())));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/answer " + ans));
            }
            p.sendMessage(tc);
        }
    }
}

package xyz.squables.statsmod.question.types.chapters.chp2;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.answer.chapters.chp2.PercentileOfPopulationAnswers;
import xyz.squables.statsmod.question.options.chapters.chp1.VariableCountOptions;
import xyz.squables.statsmod.question.options.chapters.chp2.PercentileOfPopulationOptions;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.question.types.QuestionType;

// reference #2
/*
The 35th percentile of a population is the number x such that
    a. 35% of the population scores are above x.
    b. 65% of the population scores are above x.
    c. 35% of the population scores equal x.
    d. x is 35% of the population median.
    e. x is 35% of the population mean.*/
public class PercentileOfPopulationQuestion extends Question<PercentileOfPopulationOptions> {
    public PercentileOfPopulationQuestion() {
        super(QuestionType.PERCENTILEOFPOPULATION, new PercentileOfPopulationOptions());
        this.template = "The %dth percentile of a population is the number x such that";
    }

    @Override
    public void send(Player p, boolean useTextComponents) {
        p.sendMessage(this.formatTemplate(((PercentileOfPopulationAnswers<?>) this.answers).getPercentile()));
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

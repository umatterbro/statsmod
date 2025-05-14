package xyz.squables.statsmod.question.types.chapters.chp4;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.chapters.chp4.SRSRandomSelectionOptions;
import xyz.squables.statsmod.question.types.Question;
import xyz.squables.statsmod.question.types.QuestionType;

public class SRSRandomSelectionQuestion extends Question<SRSRandomSelectionOptions> {
    private String[] templates = new String[] {
            "You want to take an SRS of %d of the %d students who live in a dormitory on campus. You label the students 001 to %d in alphabetical order. In the table of random digits you read the entries %s. The first three students in your sample have labels",
    };

    private String randomTemplate() {
        return templates[Util.generateRandomInt(0, templates.length)];
    }

    public SRSRandomSelectionQuestion() {
        super(QuestionType.SRSRANDOMSELECTION, new SRSRandomSelectionOptions());
        this.template = randomTemplate();
    }

    @Override
    public void send(Player p, boolean useTextComponents) {
        p.sendMessage(this.formatTemplate(this.options.getSrsSize(), this.options.getPersonCount(), this.options.getPersonCount(), String.join(" ", Util.numberGenericListToStringList(this.options.getRandomDigits()))));
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

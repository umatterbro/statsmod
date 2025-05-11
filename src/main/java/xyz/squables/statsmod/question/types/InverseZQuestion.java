package xyz.squables.statsmod.question.types;

import net.kyori.adventure.text.ComponentBuilder;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.Question;
import xyz.squables.statsmod.question.QuestionType;
import xyz.squables.statsmod.question.options.InverseTOptions;

import java.util.ArrayList;
import java.util.List;

public class InverseTQuestion extends Question<InverseTOptions> {
    public InverseTQuestion() {
        super(QuestionType.InverseT, new InverseTOptions(), "Find the T-Score with area=%.3f and df=%d");
    }

    @Override
    public void send(Player p) {
        InverseTOptions opts = ((InverseTOptions)this.getOptions());

        p.sendMessage(this.formatTemplate(opts.getArea(), opts.getDf()));
        for(int i = 0; i < this.answers.getAnswerOptions().size(); i++) {
            var ans = this.answers.getAnswerOptions().get(i);
            TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&l" + Util.intToColor(i) + (i+1) + "&r&8]: &f" + ans));
            tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("invt(" + Util.roundToN(this.options.getArea(), 3) + ", " + Util.roundToN(this.options.getDf(), 3) + ") = " + ans)));
            tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/answer " + ans));
            p.sendMessage(tc);
        }
    }
}

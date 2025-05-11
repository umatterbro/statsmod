package xyz.squables.statsmod.question.types;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.InverseZOptions;

public class InverseZQuestion extends Question<InverseZOptions> {
    public InverseZQuestion() {
        super(QuestionType.INVERSET, new InverseZOptions(), "Find the Z-Score with area=%.3f, μ=%.3f and σ=%.3f");
    }

    @Override
    public void send(Player p, boolean useTextComponents) {
        InverseZOptions opts = ((InverseZOptions)this.getOptions());

        p.sendMessage(this.formatTemplate(opts.getArea(), opts.getMean(), opts.getSD()));
        for(int i = 0; i < this.answers.getAnswerOptions().size(); i++) {
            var ans = this.answers.getAnswerOptions().get(i);
            TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&l" + Util.intToColor(i) + (i+1) + "&r&8]: &f" + ans));
            if(useTextComponents) {
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("invNorm(" + this.options.getArea() + ", " + this.options.getMean() + ", " + this.options.getSD() + ") ?= " + ans)));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/answer " + ans));
            }
            p.sendMessage(tc);
        }
    }
}

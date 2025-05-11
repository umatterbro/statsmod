package xyz.squables.statsmod.question.types;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.chat.hover.content.Text;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import xyz.squables.statsmod.Util;
import xyz.squables.statsmod.question.options.EventProbOptions;

public class EventProbQuestion extends Question<EventProbOptions> {
    // this is a certified #chatgpt moment
    // only used AI for this because im too lazy to think of examples :(
    private String[] templates = new String[] {
            "Emily takes %d free throws and usually makes %d percent of them. What is the probability she will make %d shots? (round to 5th decimal place)",
            "Carlos practices his guitar riffs %d times and nails them %d percent of the time. What is the probability he gets it right %d times? (round to 5th decimal place)",
            "Sarah flips a coin %d times and lands on heads %d percent of the time. What is the probability she calls %d flips? (round to 5th decimal place)",
            "Liam attempts %d math problems and usually gets them right %d percent of the time. What is the likelihood he solves %d correctly? (round to 5th decimal place)",
            "Jasmine takes %d three-point shots and has a success rate of %d percent. What is the chance she scores %d times? (round to 5th decimal place)",
            "Ethan throws a dart at a bullseye %d times and hits it %d percent of the time. What is the probability he hits it %d times? (round to 5th decimal place)",
            "Ava submits %d job applications and usually hears back from %d percent of them. What are the chances she hears back from %d places? (round to 5th decimal place)",
            "Noah takes %d photos, his camera gets a clear shot %d percent of the time. What is the probability %d of his photos are clear? (round to 5th decimal place)",
            "Olivia tries to solve %d puzzles with a success rate of %d percent. What is the probability she finishes exactly %d puzzles? (round to 5th decimal place)",
            "Mason sends %d cold emails, with a response rate is %d percent. What is the probability he gets %d responses? (round to 5th decimal place)",
    };

    private String randomTemplate() {
        return templates[Util.generateRandomInt(0, templates.length)];
    }

    public EventProbQuestion() {
        super(QuestionType.EVENTPROB, new EventProbOptions());
        this.template = randomTemplate();
    }

    @Override
    public void send(Player p, boolean useTextComponents) {
        EventProbOptions opts = ((EventProbOptions)this.getOptions());

        p.sendMessage(this.formatTemplate(opts.getTrialCount(), Math.round(opts.getChance()*100), opts.getSuccessfulTrialReq()));
        for(int i = 0; i < this.answers.getAnswerOptions().size(); i++) {
            var ans = this.answers.getAnswerOptions().get(i);
            TextComponent tc = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&8[&l" + Util.intToColor(i) + (i+1) + "&r&8]: &f" + ans));
            if(useTextComponents) {
                tc.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, new Text("(" + opts.getTrialCount() + "/" + opts.getSuccessfulTrialReq() + ")(" + opts.getChance() + ")^" + opts.getSuccessfulTrialReq() + "(" + (1-opts.getChance()) + ")^" + (opts.getTrialCount()-opts.getSuccessfulTrialReq()) + " ?= " + ans)));
                tc.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/answer " + ans));
            }
            p.sendMessage(tc);
        }
    }
}

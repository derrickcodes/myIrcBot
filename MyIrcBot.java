/**
 * Created by aderrick on 3/27/14.
 */
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import org.jibble.pircbot.*;

public class MyIrcBot extends PircBot {
    public MyIrcBot() {
        this.setName("ElephantSeal");
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {
        if (message.contains("jenn")) {
            sendMessage(channel, "Oh hai, "+ sender + "!! Thanks for talking about me, let's talk about Violet!");
        }

        if (message.contains("lead")) {
            sendMessage(channel, "I should be the lead, " + sender + "! I'm going to tell Ryan that too!");
        }

        if (message.contains("train")) {
            sendMessage(channel, "I want to be the only one who trains, so everyone learns to do things right.");
        }

        if (message.contains("sohrab")) {
            sendMessage(channel, "Hey Sohrab, do you think I should call them?  Okay, whatever.  What *I* think " +
                    "I should do is talk over you.");
        }

        if (message.contains("ryan")) {
            sendMessage(channel, "Ryan is here!  I need to go to his office and make a big deal about this!");
        }

        if (message.contains("food")) {
            sendMessage(channel, "Did someone say food?! I sure could use a 20 piece chicken McNuggets.");
        }

        if (message.equalsIgnoreCase("!fake")) {
            sendMessage(channel, "I'm going to use my sweetest voice while I say condescending things!");
        }

        if (message.contains("cca")) {
            sendMessage(channel, "Ryan needs to help me reorganize the cca group. We did it better at AT&T!");
        }

        if (message.equalsIgnoreCase("!2.0")) {
            sendMessage(channel, "I haven't eaten any cake since my little spawn was born.");
        }

        if (message.contains("sharyn")) {
            sendMessage(channel, "I fucking hate that catty bitch Sharyn!  My asthma is legit!!");
        }

        if (message.contains("AJ")) {
            sendMessage(channel, "I can't believe they promoted AJ over me!");
        }

        if (message.contains("tier1")) {
            sendMessage(channel, "I'm going to do everything a tier1 asks, maybe that will get me promoted!");
        }

        if (message.equalsIgnoreCase("!wiki")) {
            sendMessage(channel, "This is our best wiki page.  I wrote it.");
        }

        if (message.equalsIgnoreCase("!fantasy")) {
            sendMessage(channel, "My fantasy is to get naked with AJ, and to feed each other Cadbury cream eggs!");
        }

        if (message.contains("3.0")) {
            sendMessage(channel, "https://www.youtube.com/watch?v=DU4xW79ASsg");
        }

        if (message.contains("?8ball")) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(12);
            switch(randomInt) {
                case 1:
                    sendMessage(channel, "Violet likes that.");
                    break;
                case 2:
                    sendMessage(channel, "Is there bacon grease involved?");
                    break;
                case 3:
                    sendMessage(channel, "Ryan likes it, so no.");
                    break;
                case 4:
                    sendMessage(channel, "No.  That was in a Lamb of God song.");
                    break;
                case 5:
                    sendMessage(channel, "Sharyn says no.  I say yes.  I know better.");
                    break;
                case 6:
                    sendMessage(channel, "That's not how *I* would've asked that question.");
                    break;
                case 7:
                    sendMessage(channel, "Of course.");
                    break;
                case 8:
                    sendMessage(channel, "Are you crazy?!");
                    break;
                case 9:
                    sendMessage(channel, "NO!");
                    break;
                case 10:
                    sendMessage(channel, "Maybe.");
                    break;
                case 11:
                    sendMessage(channel, "Anyone can write the NOC, but not everyone is authorized to request things.");
                    break;
                default:
                    sendMessage(channel, "There's an error in my switch code if this line prints, tell dman!");
            }
        }

        if(message.contains("!slap")) {
            sendAction(channel, "slaps " + message.replace("!slap", "that fucker"));
        }

        if(message.contains("!kick")) {
            sendAction(channel, "kicks " + message.replace("!kick", "that old fart") + " in the ass.");
        }

        if(message.contains("!sniff")) {
            sendAction(channel, "sniffs " + message.replace("!sniff", "that smelly turd"));
        }

        if(message.contains("!wink")) {
            sendAction(channel, "winks " + message.replace("!wink", "at that cutie"));
        }

        if (message.equalsIgnoreCase("list")) {
          sendMessage(channel, "OH: 'jenn, lead, sohrab, food, tier1, 3.0 ?8ball, cca, train, ryan, sharyn, AJ");
          sendMessage(channel, "commands: !fake !2.0 !wiki !fantasy !slap !kick !sniff !wink");
        }

    }

    public void onKick(String channel, String kickerNick, String login, String hostname, String recipientNick, String reason) {
        if (recipientNick.equalsIgnoreCase(getNick())) {
            joinChannel("#sef-noc", "acssucks");
        }
    }

}

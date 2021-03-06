/**
 * Created by aderrick on 3/27/14.
 * This is an IRC bot I was asked to write to make an IRC channel more interesting
 * I keep adding functionality to it as people suggest things to me
 */

import java.util.Random;
import org.jibble.pircbot.*;

public class MyIrcBot extends PircBot {
    public MyIrcBot() {
        this.setName("ElephantSeal");
    }

    public void onMessage(String channel, String sender, String login, String hostname, String message) {

        /**
         * This section includes words the bot will react to anywhere in a sentence
         * It is not necessary to precede them with "!"
         * The bot will simply respond to any mention of these words in channel
         */
        if (message.contains("food")) {
            sendMessage(channel, "Did someone say food?! I sure could use a 20 piece chicken McNuggets.");
        }

        if (message.contains("jenn")) {
            sendMessage(channel, "Oh hai, "+ sender + "!! Thanks for talking about me, let's talk about Violet!");
        }

        if (message.contains("lead")) {
            sendMessage(channel, "I should be the lead, " + sender + "! I'm going to tell the boss that too!");
        }

        if (message.contains("sharyn")) {
            sendMessage(channel, "I hate that catty cow Sharyn!  My asthma is legit!!");
        }

        if (message.contains("sohrab")) {
            sendMessage(channel, "Anything Sohrab can do, I can do better!  I can do anything better than him!");
        }

        if (message.contains("train")) {
            sendMessage(channel, "I want to be the only one who trains, so everyone learns to do things right.");
        }

        /**
         * These are all commands the bot will respond to
         * The bot will respond to the use of "!<command>" anywhere in the sentence
         * example: I think that guy !AJ is really cool <--- will trigger the "!AJ" response
         * It does not have to be the first or only word in the sentence
         */
        if (message.contains("!2.0")) {
            sendMessage(channel, "http://i.imgur.com/frXVCPB.gif");
        }

        if (message.contains("!3.0")) {
            sendMessage(channel, "https://www.youtube.com/watch?v=DU4xW79ASsg");
        }

        if (message.contains("!AJ")) {
            sendMessage(channel, "I can't believe they promoted AJ over me!");
        }

        if (message.contains("!cake")) {
            sendMessage(channel, "I haven't eaten cake since my little spawn was born.");
        }

        if (message.contains("!cca")) {
            sendMessage(channel, "Ryan needs to help me reorganize our group. We did it better at AT&T!");
        }

        if (message.contains("!fake")) {
            sendMessage(channel, "I'm going to use my fake sweetest voice while I say condescending things!");
        }

        if (message.contains("!godzilla")) {
            sendMessage(channel, "RAWR!  I can eat this whole Vegas buffet in one sitting!!");
        }

        if (message.equalsIgnoreCase("!help")) {
            sendMessage(channel, "OH: food, jenn, lead, sharyn, sohrab, train");
            sendMessage(channel, "requires (!): !2.0 !3.0 !AJ !cake !cca !ES !fake !godzilla !help " +
                    "!ryan !tier1 !wiki");
            sendMessage(channel, "interactive: !fart !highfive !kick !punch");
        }

        if (message.contains("!ryan")) {
            sendMessage(channel, "Ryan is here!  I need to go to his office and make a big deal about this!");
        }

        if (message.contains("!tier1")) {
            sendMessage(channel, "I'm going to do everything any tier1 asks, maybe that will get me promoted!");
        }

        if (message.contains("!wiki")) {
            sendMessage(channel, "This is our best wiki page.  I wrote it.");
        }

        /**
         * This works like an 8 ball.  The bot will answer questions with a random answer.
         * The question must begin with "!ES" and end with "?" for it to work
         */
        if (message.startsWith("!ES")) {
            if(message.endsWith("?")) {
                Random randomGenerator = new Random();
                int randomInt = randomGenerator.nextInt(12);
                switch (randomInt) {
                    case 0:
                        sendMessage(channel, "Did someone say cake?");
                        break;
                    case 1:
                        sendMessage(channel, "Yes, Violet likes that.");
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
                } // end switch
            } // end endsWith
        } // end startsWith

        /**
         * These are commands the bot will do interactively.  Like kicking someone in the channel
         * example: !kick <person> will result in the bot emoting it kicked <person>
         */
        if(message.contains("!fart")) {
          sendAction(channel, "farts " + message.replace("!fart", "at the dbag"));
        }

        if(message.contains("!highfive")) {
            sendAction(channel, "highfives " + message.replace("!highfive", "that cool cat"));
        }

        if(message.contains("!kick")) {
            sendAction(channel, "kicks " + message.replace("!kick", "that old fart") + " in the shins.");
        }

        if(message.contains("!punch")) {
            sendAction(channel, "punches " + message.replace("!punch", "that douchewaffle") + " right in the throat!");
        }


    } // end onMessage

    /**
     * The bot will rejoin the channel if it is kicked out
     * @param channel sef-noc
     * @param kickerNick the person who kicked the bot out
     * @param login unused
     * @param hostname unused
     * @param recipientNick the victim who was kicked out (checks to see if it's self "the bot")
     * @param reason the reason given for kicking out the victim
     */
    public void onKick(String channel, String kickerNick, String login, String hostname, String recipientNick, String reason) {
        if (recipientNick.equalsIgnoreCase(getNick())) {
            joinChannel("#constantbullshit", "inapb$");
        }
    } // end onKick

} // end class MyIrcBot

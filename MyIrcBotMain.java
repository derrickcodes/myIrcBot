/**
 * Created by aderrick on 3/27/14.
 */

public class MyIrcBotMain {
    public static void main(String[] args) throws Exception {

        // start bot
        MyIrcBot bot = new MyIrcBot();

        // enable debbugging output
        bot.setVerbose(true);

        // identify with bot's password
        bot.identify("friday13");

        // connect to the irc server
        bot.connect("irc.freenode.net");

        // join the #sef-noc channel (will fail)
        bot.joinChannel("#sef-noc", "acssucks");

     }
}

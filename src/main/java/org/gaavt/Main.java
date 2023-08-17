package org.gaavt;

import org.gaavt.config.DiscordConfig;

public class Main {

    private static final DiscordConfig discordConfig = new DiscordConfig();
    private static final MyBot bot = new MyBot();
    public static void main(String[] args) {
       bot.initializeBot();
    }
}
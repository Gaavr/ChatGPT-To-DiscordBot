package org.gaavt.config;

import lombok.Getter;
import lombok.Setter;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Getter
@Setter
public class DiscordConfig {

    private String discordToken;
    private String defaultStartMessage = "!ask";

    public DiscordConfig() {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("src/main/resources/application.properties"));

            this.discordToken = properties.getProperty("discord.token");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

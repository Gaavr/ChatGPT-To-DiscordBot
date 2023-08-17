package org.gaavt;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.gaavt.config.DiscordConfig;

public class MyBot extends ListenerAdapter {

    DiscordConfig discordConfig = new DiscordConfig();

    public void initializeBot() {
        try {
            JDABuilder builder = JDABuilder.create(discordConfig.getDiscordToken(), GatewayIntent.GUILD_MESSAGES, GatewayIntent.MESSAGE_CONTENT);

            builder.addEventListeners(this);
            builder.build();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        String content = msg.getContentRaw();

        // Проверка на команды (предполагается, что команды начинаются с символа '!')
        if (content.startsWith("!")) {
            String command = content.substring(1); // Удаляем символ '!' в начале

            switch (command) {
                case "hello":
                    event.getChannel().sendMessage("Привет!").queue();
                    break;
                case "help":
                    event.getChannel().sendMessage("Здесь список всех команд...").queue();
                    break;
                case "ask":
                    event.getChannel().sendMessage("Тут будет ответ от ChatGPT").queue();
                    break;
                case "привет":
                    event.getChannel().sendMessage("Здравствуйте Ваше Величество!").queue();
                    break;
                case "димас":
                    event.getChannel().sendMessage("с@сал").queue();
                    break;
                // ... добавьте другие команды здесь
                default:
                    event.getChannel().sendMessage("Я не знаю такой команды :(").queue();
            }
        }
    }
}



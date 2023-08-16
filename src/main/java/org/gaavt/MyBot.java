package org.gaavt;

import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MyBot extends ListenerAdapter {

    public static void main(String[] args) throws Exception {
        JDABuilder builder = JDABuilder.createDefault("YOUR_DISCORD_BOT_TOKEN");
        builder.addEventListeners(new MyBot());
        builder.build();
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message msg = event.getMessage();
        if (msg.getContentRaw().startsWith("!ask")) {
            // Здесь вы можете добавить ваш код для общения с ChatGPT
            String response = "Тут будет ответ от ChatGPT";
            event.getChannel().sendMessage(response).queue();
        }
    }
}


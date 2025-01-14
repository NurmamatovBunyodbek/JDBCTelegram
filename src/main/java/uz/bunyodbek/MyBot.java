package uz.bunyodbek;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class MyBot extends TelegramLongPollingBot {

    private MyBotService myBotService = new MyBotService();
    private MyDatabase myDatabase = new MyDatabase();

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {
            Long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();

            User user = new User(chatId,text);

            myDatabase.create(user);

            if (text.equals("/start")) {
                try {
//                    execute(myBotService.sendMessage(chatId));
                    execute(myBotService.jdbcMenu(chatId));
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }

            if (text.equals("Create")) {
                myDatabase.create(user);
            }

            if (text.equals("Read")) {
                myDatabase.read(user);
            }

            if (text.equals("Update")) {
                myDatabase.update(user);
            }

            if (text.equals("Delete")) {
                myDatabase.delete(user);
            }

        }


    }

    @Override
    public String getBotUsername() {
        return "Javaqoshimcha1910Bot";
    }

    @Override
    public String getBotToken() {
        return "8051563921:AAEYzktombWT6e_YJNpIAk9Xd4dCmdRPnTM";
    }
}

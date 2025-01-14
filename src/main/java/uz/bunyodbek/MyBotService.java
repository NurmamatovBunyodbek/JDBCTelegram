package uz.bunyodbek;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public class MyBotService {

    public SendMessage sendMessage(Long chatId) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText("HEllo");
        return sendMessage;
    }

}

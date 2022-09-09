package ru.MessageListener;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.httpclient.HttpTransportClient;

public class MessageListener{
    TransportClient transportClient = new HttpTransportClient();
    VkApiClient vk = new VkApiClient(transportClient);
    /**
    public void onMessageReceived(MessageReceivedEvent event)
    {

        //Убираем чувстительность к регистру (БоТ, бОт и т.д.)
        String message = event.getMessage().toLowerCase();
        if (message.startsWith("бот"))
        {
            try
            {
                //получим массив {"Бот", "(команду)", "аргумент1", "аргумент2",... "аргументN"};
                String[] args = message.split(" ");
                //Для удобства уберем "бот" и отделим команду от аргументов
                String command = args[1].toLowerCase();
                String[] nArgs = Arrays.copyOfRange(args, 2, args.length);
                //Получили command = "(команда)"; nArgs = {"аргумент1", "аргумент2",..."аргументN"};
                //Данный массив может быть пустым
            }
            catch (ArrayIndexOutOfBoundsException e)
            {
                //Вывод списка команд или какого-либо сообщения
                //В случае если просто написать "Бот"
            }
        }
    }
     **/
}

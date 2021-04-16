package com.ifmo.jjd.hw13.message;

import java.util.*;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int[] msgCount = new int[Message.MessagePriority.values().length];
        for (Message message : messageList) {
            msgCount[message.getPriority().ordinal()] ++;
        }
        for (int i = 0; i < msgCount.length; i++) {
            System.out.println("Кол-во сообщений для приоритета " + Message.MessagePriority.getPriority(i) + " равно " + msgCount[i]);
        }
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        int[] msgCount = new int[10];
        for (Message message : messageList) {
            msgCount[message.getCode()] ++;
        }
        for (int i = 0; i < msgCount.length; i++) {
            System.out.println("Количество сообщений для кода " + i + " равно " + msgCount[i]);
        }
    }

    public static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> original = new HashSet<>(messageList);
        System.out.println("Количество оригинальных сообщений " + original.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]
        LinkedHashSet<Message> original = new LinkedHashSet<>(messageList);
        List<Message> myMessage = new ArrayList<>(original);
        return myMessage;
    }

    public static List<Message> copyEach(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на каждое сообщение с заданным приоритетом
        //  метод должен вернуть новую коллекцию
        List<Message> myMessage = new ArrayList<>();
        for (Message message : messageList) {
            if (message.getPriority().equals(priority)) myMessage.add(message);
        }
        return myMessage;
    }

    public static List<Message> copyOther(List<Message> messageList, Message.MessagePriority priority) {
        // TODO: создать коллекцию и передать в нее ссылки на все сообщения, кроме тех, которые имеют заданный приоритет
        //  метод должен вернуть новую коллекцию
        List<Message> myMessage = new ArrayList<>();
        for (Message message : messageList) {
            if (!message.getPriority().equals(priority)) myMessage.add(message);
        }
        return myMessage;
    }

    public static void main(String[] args) {
        List<Message> messages = Message.MessageGenerator.generate(34);
        System.out.println(messages);
        // вызов методов
        MessageTask.countEachPriority(messages);
        MessageTask.countEachCode(messages);
        MessageTask.uniqueMessageCount(messages);
        System.out.println(MessageTask.uniqueMessagesInOriginalOrder(messages));
        System.out.println(MessageTask.copyEach(messages, Message.MessagePriority.HIGH));
        System.out.println(MessageTask.copyOther(messages, Message.MessagePriority.HIGH));
    }
}

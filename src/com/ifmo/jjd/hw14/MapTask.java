package com.ifmo.jjd.hw14;

import java.util.*;

import static java.lang.Character.isWhitespace;

public class MapTask {
    public static void main(String[] args) {
        // TODO:: написать статический метод, который принимает на вход мапу (например, firstTaskMap) и город (например, city),
        //  формирует и возвращает список (List) логинов, которые соответствуют переданному городу

        HashMap<String, String> firstTaskMap = new HashMap<>();
        firstTaskMap.put("qwe", "Тверь");
        firstTaskMap.put("asd", "Тверь");
        firstTaskMap.put("zxc", "Москва");
        firstTaskMap.put("rty", "Тверь");
        firstTaskMap.put("fgh", "Магадан");

        String city = "Тверь";

        //System.out.println(loginInCity(firstTaskMap, city));


        // TODO:: дан список слов (например, words).
        //  Написать статический метод, который будет возвращать количество одинаковых слов с списке
        //  в виде Map<String, Integer>, где String - слово и Integer - количество повторений

        List<String> words = new ArrayList<>();
        words.add("may");
        words.add("august");
        words.add("june");
        words.add("may");
        words.add("may");
        words.add("july");
        words.add("may");
        words.add("august");
        words.add("august");

        System.out.println(equalWords(words).toString());


        // TODO:: дана мапа (например, customerMap).
        //  Написать статический метод, который принимает на вход аргументы int from и int to и возвращает
        //  новую мапу, в которую войдут все покупатели, возраст которых находится в диапазоне [from, to)

        HashMap<String, Customer> customerMap = new HashMap<>();
        customerMap.put("1", new Customer("Павел", "1", 23));
        customerMap.put("2", new Customer("Олег", "2", 17));
        customerMap.put("3", new Customer("Максим", "3", 48));
        customerMap.put("4", new Customer("Евгения", "4", 67));

        System.out.println(ageGate(18, 65, customerMap));


        // TODO:: Задания по тексту (text). На каждый пункт - минимум один метод:
        //  1. написать метод, принимающий на вход слово и возвращающий частоту
        //  встречаемости данного слова в тексте
        //  2. написать метод, который собирает все слова в группы
        //  по количеству букв:
        //  например, в одну группу попадут слова:
        //  3 - [the, war, jar, get, met...],
        //  в другую 2 - [on, up, no, of...] и тд
        //  результат сохранить в Map<Integer, ArrayList>
        //  3. написать метод, который выводит в консоль топ 10 самых частых слов
        //  4. вывести частоту встречаемости букв английского алфавита в данном тексте. Вывести в процентах для каждой буквы

        // в тексте содержатся только буквы и пробельные символы
        String text = "It is a uncover long established fact that a reader will be distracted uncover by the readable content of a page " +
                "when looking at its layout The point of using uncover Lorem Ipsum is that sites it has a more-or-less normal distribution of letters" +
                "as uncover opposed to still using Content here humour uncover content here making it look like readable English Many desktop publishing " +
                "packages and web page editors now use Lorem Ipsum as their default model text and a search for lorem ipsum will " +
                "uncover many web sites still uncover in their infancy Various versions uncover have evolved over the years uncover sometimes by accident" +
                " sometimes on purpose injected humour and the like";
        System.out.println(wordInText("still", text));
        System.out.println(groupByLength(text));
        topTenWords(text);
        alphabetStat(text);

    }
  /*  public static List<String> loginInCity(HashMap<String, String> firstTaskMap, String citi ){
        List<String> inCity = new ArrayList<>();
        for (Map.Entry<String, String> stringStringEntry : firstTaskMap.entrySet()) {
            if (stringStringEntry.getValue().equals(citi)) inCity.add(stringStringEntry.getKey());
        }
        return inCity;
    }*/

    //  1. написать метод, принимающий на вход слово и возвращающий частоту
    //  встречаемости данного слова в тексте
    public static Map<String, Integer> equalWords(List<String> words){
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            wordsCount.put(word, wordsCount.getOrDefault(word, 0) + 1);
        }
        return wordsCount;
    }

    public static Map<String, Customer> ageGate(int from, int to, Map<String, Customer> inMap){
        Map<String, Customer> outMap = new HashMap<>();
        for (Map.Entry<String, Customer> stringCustomerEntry : inMap.entrySet()) {
            if (stringCustomerEntry.getValue().getAge() > from && stringCustomerEntry.getValue().getAge() < to) outMap.put(stringCustomerEntry.getKey(), stringCustomerEntry.getValue());
        }
        return outMap;
    }

    public static int wordInText(String word, String text){
        List<String> myWordsList = new ArrayList<> (Arrays.asList(text.split(" ")));
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : myWordsList) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        return wordsCount.get(word);
    }

    public static Map<Integer, ArrayList<String>> groupByLength (String text){
        HashSet<String> originalWords = new HashSet<>(Arrays.asList(text.split(" ")));
        Map<Integer, ArrayList<String>> myGroups = new HashMap<>();
        for (String originalWord : originalWords) {
            if (myGroups.get(originalWord.length()) == null) {
                myGroups.put(originalWord.length(), new ArrayList<String>());
            }
            myGroups.get(originalWord.length()).add(originalWord);

        }
        return myGroups;
    }

    public static void topTenWords (String text){
        List<String> myWordsList = new ArrayList<> (Arrays.asList(text.split(" ")));
        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : myWordsList) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }
        TreeMap<Integer,ArrayList<String>> topList = new TreeMap<>(Collections.reverseOrder());
        for (Map.Entry<String, Integer> stringIntegerEntry : wordsCount.entrySet()) {
            if (topList.get(stringIntegerEntry.getValue()) == null){
                topList.put(stringIntegerEntry.getValue(), new ArrayList<String>());
            }
            topList.get(stringIntegerEntry.getValue()).add(stringIntegerEntry.getKey());
        }
        int count = 1;
        for (Map.Entry<Integer, ArrayList<String>> integerArrayListEntry : topList.entrySet()) {
            if(count > 10) break;
            System.out.println("Место " + count + " слова " + integerArrayListEntry.getValue() + " всего " + integerArrayListEntry.getKey());
            count++;
        }
    }

    public static void alphabetStat(String text){
        int totalChar = 0;
        TreeMap<Character, Integer> topChar= new TreeMap<>();
        for (int i = 0; i < text.length(); i++) {
            if(!isWhitespace(text.charAt(i))) {
                topChar.put(text.charAt(i), topChar.getOrDefault(text.charAt(i), 0) + 1);
                totalChar++;
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : topChar.entrySet()) {
            double percent = characterIntegerEntry.getValue() / (double) totalChar * 100;
            System.out.println( "Буква " + characterIntegerEntry.getKey() + " - " + percent + " %");
        }
    }
}
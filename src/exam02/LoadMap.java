package exam02;

import java.io.*;
import java.util.HashMap;

public class LoadMap {
    public static String loadMap(HashMap<String, Point> pointMap){
//
// Здесь должна быть куча проверок но, т.к. времени нет, понадеемся на создателя файла points.txt
//
        InputStream resourceMap = StartGame.class.getResourceAsStream("/points.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(resourceMap))){
            String startKey = new String();
            String tempString;
            boolean firstFlag = true;
            int i = 1;
            while((tempString = reader.readLine()) != null){
                if(firstFlag){
                    startKey= tempString;
                    firstFlag = false;
                }
                Point point = new Point(reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine(),reader.readLine());
                pointMap.put(tempString, point);

            }
            return startKey;
        } catch (FileNotFoundException e) {
            System.out.println("Ошибочка! Файл points.txt не найден.");
            return null;
        } catch (IOException e) {
            System.out.println("Ошибочка! Не читается файл");
            return null;
        }

    }
}

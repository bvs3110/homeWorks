package com.ifmo.jjd.hw23;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.*;
import java.util.Arrays;
import java.util.Properties;

public class AnnotationApp {
    public static void main(String[] args){
        Class<Point> pointClass = Point.class;
        Properties properties = new Properties();
        try (InputStream input = AnnotationApp.class.getClassLoader().getResourceAsStream("point.properties")){
            properties.load(input);
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл");
        }
        if(pointClass.isAnnotationPresent(Component.class)) {
            try {
                Constructor<Point> oneConstructor = pointClass.getDeclaredConstructor();
                Point point = oneConstructor.newInstance();
                Field[] fields = pointClass.getDeclaredFields();
                for (Field field : fields) {
                    if(field.isAnnotationPresent(Required.class)){
                        Method method = pointClass.getDeclaredMethod("set"+field.getName().toUpperCase(), field.getClass());
                        method.invoke(point, Integer.parseInt((String)properties.getProperty(field.getName()))); //Проверить тип поля и парсить в этот тип
                    }
                }
                toString(point);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        Message myMessage = new Message("Some text here");
        Text myText = new Text("Some text here to");
        int[] arr = {12, 13, 14};
        SomeThing someThing = new SomeThing(myMessage, arr);
        System.out.println("___________________________________________________________________________");
        toString(myMessage);
        System.out.println("___________________________________________________________________________");
        toString(myText);
        System.out.println("___________________________________________________________________________");
        toString(someThing);
    }
    public static void toString(Object o){
        Class<?> oClass = o.getClass();
        Field[] fields = oClass.getDeclaredFields();
        for (Field field : fields) {
            if(!field.isAccessible()){
                field.setAccessible(true);
            }
            if(!Modifier.isTransient(field.getModifiers())){
                if(!field.getType().isArray()){
                    try {
                        System.out.println(field.getName() + " " + field.getType() + " " + field.get(o));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                } else {
                    try {
                        System.out.println("massive " + field.get(o));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }
}


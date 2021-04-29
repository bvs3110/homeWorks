package com.ifmo.jjd.hw18;

import java.io.File;
import java.nio.charset.StandardCharsets;

public class EncodeDecodeApp {
    public static void main(String[] args) {
        String text = "The String class represents character strings. All string literals in Java programs";
        CryptHandler toEncode = new CryptHandler(new File("encoded.txt"));
        if(toEncode.encodeToFile(text.getBytes())) System.out.println("Успешно закодирован");;

        String fromFile = new String(toEncode.decodeFromFile());
        System.out.println(fromFile);

    }
}

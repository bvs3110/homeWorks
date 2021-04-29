package com.ifmo.jjd.hw18;

import java.io.*;

public class CryptHandler {
    private File file;

    public CryptHandler(File file) {setFile(file);}

    public void setFile(File file){
        if (file == null || !file.getName().endsWith("txt") || file.isDirectory()) {
            this.file = new File("default.txt");
        } else {
            this.file = file;
        }
        try {
            if (this.file.createNewFile()) {
                System.out.println(this.file.getName() + " создан");
            } else {
                System.out.println(this.file.getName() + " существует");
            }
        } catch (IOException e) {
            System.out.println("Невозможно создать файл" + e.getMessage());  // если не создали и прочитать нельзя!
        }
    }

    public boolean encodeToFile(byte[] data){
        boolean result = false;
        try (FileOutputStream outputStream = new FileOutputStream(file); Encode encodeArray = new Encode(outputStream)){
            encodeArray.write(data);
            result = true;
        } catch (FileNotFoundException e) {
            System.out.println("Файл для записи не найден");
        } catch (IOException e) {
            System.out.println("Ошибка записи в файл");
        }
        return result;
    }

    public byte[] decodeFromFile(){
        byte[] result = null;
        try (FileInputStream fileInput = new FileInputStream(file); Decode decodeArray = new Decode(fileInput); ByteArrayOutputStream byteArray = new ByteArrayOutputStream()){
            byte[] buf = new byte[512];
            int readCount;
            while ((readCount = decodeArray.read(buf)) != -1){
                byteArray.write(buf, 0, readCount);
            }
            result = byteArray.toByteArray();
        } catch (FileNotFoundException e) {
            System.out.println("Файл для чтения не найден");
        } catch (IOException e) {
            System.out.println("Ошибка чтения");
        }
        return result;
    }

}

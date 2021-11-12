package com.akbar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;

public class FileService implements FileSeriveInterface {

    private String filePath = "c:\\ios\\";

    @Override
    public void write(String fileName, String content) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath + fileName);
            fileOutputStream.write(content.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String read(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(new File(filePath + fileName)));

            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return stringBuilder.toString();
    }
}

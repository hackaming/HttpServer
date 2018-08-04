package com.bjsxt.HttpServer;

import java.io.Closeable;
import java.io.IOException;

public class CloseUtil {
    public static void closeIO(Closeable ... io){
        for (Closeable i:io) {
            try {
                i.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

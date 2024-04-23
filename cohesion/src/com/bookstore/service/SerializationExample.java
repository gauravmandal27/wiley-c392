package com.bookstore.service;

import java.io.*;

public class SerializationExample {

    public static void serializeObject(Object object) {
        try(OutputStream outputStream = new FileOutputStream("shoppingCart.ser");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)){
            objectOutputStream.writeObject(object);
        }
        catch (IOException ex){
            System.err.println(ex);
        }

    }

    public static Object deSerializeObject(String filename){
        try(InputStream inputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            return objectInputStream.readObject();
        }
        catch (Exception ex){
            throw new RuntimeException(ex.getMessage());
        }
    }

}

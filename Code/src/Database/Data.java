package Database;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Vector;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Data implements Serializable {

	
	public Data() {
	}
	

	
	public void serialize(Data database) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data.ser"))) {
            oos.writeObject(database);
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Failed to serialize data: " + e.getMessage());
        }
    }

    public Data deserialize() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data.ser"))) {
            Data newData = (Data) ois.readObject();
            return newData;
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("Failed to deserialize data: " + e.getMessage());
        }
        return null;
    }
}

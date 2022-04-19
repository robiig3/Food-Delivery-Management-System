package data;

import business.DeliveryService;
import business.MenuItem;
import business.Order;
import model.Account;
import model.Admin;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class Serializator {

    public static void AdminSerialization(Admin a, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(a);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Object has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Admin AdminDeserialization(String fileName){

        Admin b = null;

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);
            b = (Admin) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Object has been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    public static void ClientListSerialization(List<Account> clientList, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(clientList);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Client list has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<Account> ClientListDeserialization(String fileName){

        List<Account> list = new ArrayList<>();

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            list = (List<Account>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Client List has been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void MenuSerialization(List<MenuItem> menu, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(menu);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("Menu has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static List<MenuItem> MenuDeserialization(String fileName){

        List<MenuItem> list = new ArrayList<>();

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            list = (List<MenuItem>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("Menu has been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public static void OrderSerialization(Map<Order, List<MenuItem>> orders, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(orders);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("The orders have been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Map<Order, List<MenuItem>> OrderDeserialization(String fileName){

        Map<Order, List<MenuItem>> orders = new Hashtable<>();

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            orders = (Map<Order, List<MenuItem>>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("The orders have been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return orders;
    }

    public static void DeliveryServiceSerialization(DeliveryService deliveryService, String filename){

        try {
            FileOutputStream fileOutputStream
                    = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream
                    = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.reset();
            objectOutputStream.writeObject(deliveryService);
            objectOutputStream.close();
            fileOutputStream.close();

            System.out.println("The delivery service has been serialized");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DeliveryService DeliveryServiceDeserialization(String fileName){

        DeliveryService deliveryService = new DeliveryService();

        try
        {
            // Reading the object from a file
            FileInputStream fileInputStream
                    = new FileInputStream(fileName);
            ObjectInputStream objectInputStream
                    = new ObjectInputStream(fileInputStream);

            deliveryService = (DeliveryService) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();

            System.out.println("The delivery service has been deserialized ");
        }catch (Exception e) {
            e.printStackTrace();
        }

        return deliveryService;
    }
}

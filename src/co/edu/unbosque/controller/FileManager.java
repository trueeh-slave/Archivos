package co.edu.unbosque.controller;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void main(String[] args) {
        try{
            boolean salir = false;
            do{
                int menu = Integer.parseInt(JOptionPane.showInputDialog("""
                        Ingrese la opcion que desea realizar\s
                         1. Unir el archivo 1 y 2\s
                         2. Intersección entre 1 y 2\s
                         3. Archivo 1 - Archivo 2\s
                         4. Archivo 2 - Archivo 1\s
                         5. Salir"""));

                switch (menu) {
                    case 1 -> {
                        merge();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                        salir = true;
                    }
                    case 2 -> {
                        intersection();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                        salir = true;
                    }
                    case 3 -> {
                        differenceBetween1And2();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                        salir = true;
                    }
                    case 4 -> {
                        differenceBetween2And1();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                        salir = true;
                    }
                    case 5 ->{
                        JOptionPane.showMessageDialog(null, "Que tenga una feliz tarde :D");
                        salir = true;
                    }
                }
            }while (!salir);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void merge() throws IOException {
        PrintWriter pw = new PrintWriter("archivo.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while (line != null) {
            pw.println(line);
            line = br.readLine();
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        while(line != null) {
            pw.println(line);
            line = br.readLine();
        }

        pw.flush();
        br.close();
        pw.close();

    }

    public static void intersection() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("archivo.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }


        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));
        line = br.readLine();

        while(line != null) {
            line = br.readLine();
            archivo2.add(line);
        }

        for(String linea : archivo1){
            if(archivo2.contains(linea)){
                archivo3.add(linea);
            }
        }

        for(String cadaLinea : archivo3){
            writer.write(cadaLinea + System.lineSeparator());
            System.out.println(cadaLinea);
        }
        writer.close();
        br.close();
    }

    public static void differenceBetween1And2() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("archivo.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));
        line = br.readLine();

        while(line != null) {
            line = br.readLine();
            archivo2.add(line);
        }

        for(String linea : archivo1){
            if(!archivo2.contains(linea)){
                archivo3.add(linea);
            }
        }

        for(String cadaLinea : archivo3){
            writer.write(cadaLinea + System.lineSeparator());
            System.out.println(cadaLinea);
        }
        writer.close();
        br.close();
    }

    public static void differenceBetween2And1() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("archivo.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        while(line != null) {
            line = br.readLine();
            archivo2.add(line);
        }

        for(String linea : archivo2){
            if(!archivo1.contains(linea)){
                archivo3.add(linea);
            }
        }

        for(String cadaLinea : archivo3){
            writer.write(cadaLinea + System.lineSeparator());
            System.out.println(cadaLinea);
        }
        writer.close();

        System.out.println("termino todo");
    }


}

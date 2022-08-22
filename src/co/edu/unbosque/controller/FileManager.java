package co.edu.unbosque.controller;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class FileManager {

    public static void main(String[] args) throws IOException {
        boolean salir = false;
        do{
            int menu = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la opcion que desea realizar " +
                    "\n 1. Unir el archivo 1 y 2 " +
                    "\n 2. Intersección entre 1 y 2 " +
                    "\n 3. Archivo 1 - Archivo 2 " +
                    "\n 4. Archivo 2 - Archivo 1"));

            switch (menu){
                case 1:
                    merge();
                    break;
                case 2:
                    intersection();
                    break;
                case 3:
                    differenceBetween1And2();
                    break;
                case 4:
                    differenceBetween2And1();
                    break;
            }
        }while (!salir);
    }
    public static void merge() throws IOException {
        // PrintWriter object for file3.txt
        PrintWriter pw = new PrintWriter("file3.txt");

        // BufferedReader object for file1.txt
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        // loop to copy each line of
        // file1.txt to  file3.txt
        while (line != null)
        {
            pw.println(line);
            line = br.readLine();
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        // loop to copy each line of
        // file2.txt to  file3.txt
        while(line != null)
        {
            pw.println(line);
            line = br.readLine();
        }

        pw.flush();

        // closing resources
        br.close();
        pw.close();

        System.out.println("Merged file1.txt and file2.txt into file3.txt");
    }

    public static void intersection() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("file3.txt");
//        PrintWriter pw = new PrintWriter("file3.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        // loop to copy each line of
        // file2.txt to  file3.txt
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

        System.out.println("termino todo");


    }

    public static void differenceBetween1And2() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("file3.txt");
//        PrintWriter pw = new PrintWriter("file3.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        // loop to copy each line of
        // file2.txt to  file3.txt
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

        System.out.println("termino todo");
    }

    public static void differenceBetween2And1() throws IOException {
        ArrayList<String> archivo1 = new ArrayList<>();
        ArrayList<String> archivo2 = new ArrayList<>();
        ArrayList<String> archivo3 = new ArrayList<>();

        FileWriter writer = new FileWriter("file3.txt");
//        PrintWriter pw = new PrintWriter("file3.txt");
        BufferedReader br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo1.txt"));

        String line = br.readLine();

        while(line != null){
            line = br.readLine();
            archivo1.add(line);
        }

        br = new BufferedReader(new FileReader("E:\\Projects\\Archivos\\archivo2.txt"));

        line = br.readLine();

        // loop to copy each line of
        // file2.txt to  file3.txt
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

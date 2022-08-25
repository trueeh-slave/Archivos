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
                        Ingrese la opción que desea realizar\s
                         1. Unir el archivo 1 y 2\s
                         2. Intersección entre 1 y 2\s
                         3. Archivo 1 - Archivo 2\s
                         4. Archivo 2 - Archivo 1\s
                         5. Borrar resultado.txt\s
                         6. Salir
                         \s
                         Nota: si desea realizar una nueva opción, debe eliminar el archivo"""));

                switch (menu) {
                    case 1 -> {
                        merge();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                    }
                    case 2 -> {
                        intersection();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                    }
                    case 3 -> {
                        differenceBetween1And2();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                    }
                    case 4 -> {
                        differenceBetween2And1();
                        JOptionPane.showMessageDialog(null, "Archivo resultado.txt creado exitosamente");
                    }
                    case 5 -> deleteTxt();
                    case 6 ->{
                        JOptionPane.showMessageDialog(null, "Que tenga una feliz tarde :D");
                        salir = true;
                    }
                }
            }while (!salir);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void merge() {

        try{
            PrintWriter pw = new PrintWriter("resultado.txt");
            BufferedReader br = new BufferedReader(new FileReader("archivo1.txt"));

            String line = br.readLine();

            while (line != null) {
                pw.println(line);
                line = br.readLine();
            }

            br = new BufferedReader(new FileReader("archivo2.txt"));

            line = br.readLine();

            while(line != null) {
                pw.println(line);
                line = br.readLine();
            }

            pw.flush();
            br.close();
            pw.close();

        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error en el método merge");
        }

    }

    public static void intersection() {

        try{

            ArrayList<String> archivo1 = new ArrayList<>();
            ArrayList<String> archivo2 = new ArrayList<>();
            ArrayList<String> archivo3 = new ArrayList<>();

            FileWriter writer = new FileWriter("resultado.txt");
            BufferedReader br = new BufferedReader(new FileReader("archivo1.txt"));

            String line = br.readLine();

            while(line != null){
                line = br.readLine();
                archivo1.add(line);
            }


            br = new BufferedReader(new FileReader("archivo2.txt"));
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

        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error en el método intersection");
        }
    }

    public static void differenceBetween1And2() {

        try{
            ArrayList<String> archivo1 = new ArrayList<>();
            ArrayList<String> archivo2 = new ArrayList<>();
            ArrayList<String> archivo3 = new ArrayList<>();

            FileWriter writer = new FileWriter("resultado.txt");
            BufferedReader br = new BufferedReader(new FileReader("archivo1.txt"));

            String line = br.readLine();

            while(line != null){
                line = br.readLine();
                archivo1.add(line);
            }

            br = new BufferedReader(new FileReader("archivo2.txt"));
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

        } catch (IOException e){
            JOptionPane.showMessageDialog(null,"Error en el método differenceBetween1And2");
        }
    }

    public static void differenceBetween2And1() throws IOException {

        try{

            ArrayList<String> archivo1 = new ArrayList<>();
            ArrayList<String> archivo2 = new ArrayList<>();
            ArrayList<String> archivo3 = new ArrayList<>();

            FileWriter writer = new FileWriter("resultado.txt");
            BufferedReader br = new BufferedReader(new FileReader("archivo1.txt"));

            String line = br.readLine();

            while(line != null){
                line = br.readLine();
                archivo1.add(line);
            }

            br = new BufferedReader(new FileReader("archivo2.txt"));

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
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error en el método differenceBetween2And1");
        }
    }

    public static void deleteTxt(){
        try{
            File file = new File("resultado.txt");
            if(file.exists()){
                file.delete();
            }

            JOptionPane.showMessageDialog(null,"Archivo eliminado correctamente");
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error, compruebe si el archivo existe e intente nuevamente");
        }
    }
}

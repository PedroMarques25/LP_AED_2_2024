package edu.ufp.inf.projeto.JavaFXStuff;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    public static void writeArtigosToFile(List<Artigo> artigos, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Artigo artigo : artigos) {
                writer.write(artigo.toString()); // Certifique-se de que o método toString() de Artigo está implementado
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeAutoresToFile(List<Autor> autores, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Autor autor : autores) {
                writer.write(autor.toString()); // Certifique-se de que o método toString() de Autor está implementado
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

     public static void writeArtigosToBinaryFile(List<Artigo> artigos, String fileName) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(artigos);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void writeAutoresToBinaryFile(List<Autor> autores, String fileName) {
            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                 ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
                objectOutputStream.writeObject(autores);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static List<Artigo> readArtigosFromBinaryFile(String fileName) {
            try (FileInputStream fileInputStream = new FileInputStream(fileName);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (List<Artigo>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }

        public static List<Autor> readAutoresFromBinaryFile(String fileName) {
            try (FileInputStream fileInputStream = new FileInputStream(fileName);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                return (List<Autor>) objectInputStream.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
            return new ArrayList<>();
        }
    }
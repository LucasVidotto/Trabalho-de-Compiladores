package br.edu.utfpr.cc.compiladores.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;


public class FileManager {

    public FileReader getFileReaderByFile(File file) throws IOException {
        return new FileReader(file);
    }

    public void closeFileReader(FileReader file) throws IOException {
        file.close();
    }

    public FileWriter getFileWriterByFile(File file) throws IOException {
        return new FileWriter(file);
    }

    public void closeFileWriter(FileWriter file) throws IOException {
        file.close();
    }

    public void addContent(String str, FileWriter fw) throws IOException {
        try {
            fw.write(str);
            fw.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readContent(FileReader file ) throws IOException {
        var result = "";
        var linha = "";
        var input = new BufferedReader(file);
        try {
            while (true) {
                linha = input.readLine();
                if (linha == null) {
                    break;
                }
                result += linha + "\n";
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

}

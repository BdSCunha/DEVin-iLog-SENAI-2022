package devinhouseilog.excecoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CheckedExceptions {
    public static void main(String[] args) throws IOException {
        try {
            Path path = Paths.get("teste.txt");
            Files.createFile(path);
        } catch (FileAlreadyExistsException exception) {
            throw new FileAlreadyExistsException("File Already exists.");
        }

        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
        } catch (IOException exception) {
            throw new IOException("Not possible to write to file because it does not exist.");
        }

        try {
            File myObj = new File("filename.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Not possible to find file.");
        }
    }
}

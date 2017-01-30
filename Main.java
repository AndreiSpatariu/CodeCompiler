import InputOutput.Input;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Andrei Spatariu on 12/22/2016.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        PrintWriter writer = new PrintWriter("outputfilename.out");

        BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Andrei Spatariu\\IdeaProjects\\Tema3\\src\\arbore3.in"));

        String line;

        while((line = bufferedReader.readLine()) != null){
            line = line.replace(line.substring(line.length() - 1), "");

            Input.ReadLine(line, writer);
        }

        writer.close();
    }
}

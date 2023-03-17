package ejercicio1;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class Main {

    public static void main(String[] args){

        Path dir = Path.of(args[0]);
        try (DirectoryStream<Path> stream =
                     Files.newDirectoryStream(dir)) {
            Arrays.sort(new DirectoryStream[]{stream});

            for (Path entry: stream) {
                System.out.println(entry.getFileName());
            }
        } catch (IOException x) {
            // IOException can never be thrown by the iteration.
            // In this snippet, it can // only be thrown by newDirectoryStream.
            System.err.println(x);
        }
    }
}
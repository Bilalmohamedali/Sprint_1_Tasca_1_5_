package ejercicio2;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {

        File dir = new File(args[0]);

        System.out.println("Listando archivos y directorios " + dir.getCanonicalPath() + " indicando si es fichero o directorio y fecha de ultima modiifcacion");

        Iterator<File> fileIterator = FileUtils.iterateFilesAndDirs(dir, TrueFileFilter.INSTANCE,TrueFileFilter.INSTANCE);

        while(fileIterator.hasNext()){
            File file = fileIterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            String modificado = sdf.format(file.lastModified());

            if(file.isDirectory()){
                System.out.println("D-- " + file + " ---- Ultima modificacion: " + modificado);
            }
            if(file.isFile()){
                System.out.println("F---- " + file + " ---- Ultima modificacion: " + modificado);
            }
        }
    }
}

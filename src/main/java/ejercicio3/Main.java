import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.TrueFileFilter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) throws IOException {
        File dir = new File(args[0]);

        System.out.println("Listando archivos y directorios " + dir.getCanonicalPath() + " indicando si es fichero o directorio y fecha de ultima modiifcacion");

        Iterator<File> fileIterator = FileUtils.iterateFilesAndDirs(dir, TrueFileFilter.INSTANCE, TrueFileFilter.INSTANCE);
        StringBuilder sb = new StringBuilder();
        while (fileIterator.hasNext()) {
            File file = fileIterator.next();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
            String modificado = sdf.format(file.lastModified());

            String mensaje;
            if (file.isDirectory()) {
                mensaje = ("D-- " + file + " ---- Ultima modificacion: " + modificado);
            } else {
                mensaje = ("F---- " + file + " ---- Ultima modificacion: " + modificado);
            }
            sb.append(mensaje).append("\n");
        }

        guardarInformacionEnArchivo(sb.toString());
    }

    private static void guardarInformacionEnArchivo(String informacion) {
        try {
            String ruta = "C:\\Users\\usuario\\Desktop\\Proyectos\\Java\\curso_it_academy\\Informacion.txt";
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(informacion);
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

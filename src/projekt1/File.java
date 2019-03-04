package projekt1;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

/**
 * Klasa obsługująca plik podany w linii komend
 */
public class File {
    protected Charset charset = Charset.defaultCharset();
    protected List <String> lines = new ArrayList<>();

    /**
     * Wczytywanie pliku i jego zawartości do listy linii lines
     * @param path ścieżka dostępu do pliku
     */
    public void loadFile(String path){
        try{
            Path bibFile = Paths.get(path);
            lines = Files.readAllLines(bibFile);
        }
        catch(IOException ex){
            System.out.println("IO Exception: " + ex);
        }
    }

    /**
     * @return lista linii z pliku
     */
    public List<String> getLines() {
        return lines;
    }
}

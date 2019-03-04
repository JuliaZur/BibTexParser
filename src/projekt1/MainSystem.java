package projekt1;

import java.util.List;
import java.lang.String;

/**
 * @author Julia Żur
 */
public class MainSystem {
    /**
     *
     * Wywołanie metod i helpa
     * @see RecordParser#toObject
     * @see File#loadFile
     * @see File#getLines
     * @see CommandLineParser#getOptions
     * @see Table#printTable
     * @param args String[] linii komend
     */
    public static void main(String[] args){
        if (args.length==0){
            System.out.println("nazwa pliku + opcjonalnie\n-l załaduj cały plik \n-t wyszukiwanie po typie \n-a wyszukiwanie po autorach oddzielonych przecinkami \n-r znak obramowania (domyslnie *)");
            return;
        }

        File bib = new File();
        String arg = args[0];

        bib.loadFile(arg);
        List <String> lines = bib.getLines();

        RecordParser parser = new RecordParser(lines);
        parser.toObject();

        CommandLineParser commandLine  = new CommandLineParser();
        commandLine = commandLine.getOptions(args);
        Table t = new Table();
        t.printTable(parser.records,commandLine.cframe,commandLine);

    }
}

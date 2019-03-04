package projekt1;

import java.util.ArrayList;
import java.util.List;

/**
 *  Klasa obsługująca linię komend
 *  Sprawdza obecność opcji
 *  przypisuje wartości ramki,
 *  listy autorów
 *  i listy typów
 */
public class CommandLineParser {
    boolean flagWholeFile=false;
    char cframe='*';
    boolean flagFrame=false;
    List <String> type =new ArrayList<>();
    boolean flagType=false;
    List <String> author = new ArrayList<>();
    boolean flagField=false;

    /**
     *  Zwraca informacje o opcjach w linii komend
     *  ustawia flagi
     *  uzupełnia listy autorów
     *  i typów
     * @param commandLine lista String[] linii komend
     * @return zwraca options, który zawiera flagi dotyczące opcji i ich wartości, gdzie autorzy i typy są w listach
     */
    public CommandLineParser getOptions(String[] commandLine) {
        CommandLineParser options = new CommandLineParser();
        for (int i=0; i<commandLine.length; i++){
            if (commandLine[i].equals("-l")){
                options.flagWholeFile = true;
                for (int j=i; j<commandLine.length; j++){
                    String frame = "";
                    if (commandLine[j].equals("-r")){
                        try {
                            frame = commandLine[j+1];
                        }
                        catch (ArrayIndexOutOfBoundsException e){
                            System.out.println("Niepoprawne dane dla ramki");
                        }
                        options.cframe = frame.charAt(0);
                        options.flagFrame = true;
                    }
                }
                return options;
            }

            if (commandLine[i].equals("-t")){
                String stype="";
                options.flagType = true;
                int j = i;
                try {
                    while (!commandLine[j + 1].contains("-")) {
                        stype = commandLine[j + 1];
                        options.type.add(stype);
                        j++;
                        if (j + 1 == commandLine.length) break;
                    }
                }
                catch (ArrayIndexOutOfBoundsException f) {
                System.out.println("Niepoprawne dane dla typu");
                }
            }
            if (commandLine[i].equals("-a")){
                options.flagField = true;
                int j = i;
                String sfield = "";
                try {
                    while (!commandLine[j+1].contains("-")) {
                        if (j + 2 != commandLine.length) sfield = sfield + commandLine[j + 1] + " ";
                        else sfield += commandLine[j + 1];
                        j++;
                        if (j + 1 == commandLine.length) break;
                    }
                    String[] parts = sfield.split(",");
                    for (int p=1; p<parts.length; p++){
                        parts[p] = parts[p].substring(1);
                    }
                    for (int k=0; k<parts.length; k++){
                        options.author.add(parts[k]);
                    }
                }
                catch (ArrayIndexOutOfBoundsException f) {
                    System.out.println("Niepoprawne dane dla autora");
                }
            }
            if (commandLine[i].equals("-r")){
                String frame = "*";
                try {
                    frame = commandLine[i+1];
                }
                catch (ArrayIndexOutOfBoundsException e){
                    System.out.println("Niepoprawne dane dla ramki, domyślnie *");
                }
                options.cframe = frame.charAt(0);
                options.flagFrame = true;
            }
        }
        if (!options.flagFrame){
            options.cframe = '*';
        }
        return options;
    }

}

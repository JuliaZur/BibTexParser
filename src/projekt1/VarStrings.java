package projekt1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa obsługująca zmienne napisowe
 * znajduje wartość zmiennej
 * zmienna jest dodawana do listy zmiennych
 * @see RecordParser
 */
public class VarStrings {
    String var="";
    String valVar = "";
    boolean flag = false;

    public VarStrings(String var, String valVar){
        this.var = var;
        this.valVar = valVar;
    }

    /**
     *  zwracany gdy w linii nie ma zmiennej napisowej
     */
    public VarStrings(){
        /** no instance
         *
         */
    }

    public boolean isPresent(){
        return flag;
    }

    public void setFlag(){
        flag = true;
    }

    private String varString = "(?i)@STRING";
    private Pattern vS = Pattern.compile(varString);

    /**
     * Metoda do przypisania wartości występującej przed znakiem @String, czyli zmiennej napisowej
     * @param line linia z pliku
     * @return zmienna napisowa
     */
    public String takeVar(String line){
        for (int i=0; i<line.length(); i++){
            while (line.charAt(i)!='{') {
                i++;
            }
            if (line.charAt(i) == '{'){
                i++;
                while (line.charAt(i)!= '=' && i<line.length()){
                    char c = line.charAt(i);
                    if (c == ' ') var = var;
                    else var = var + c;
                    i++;
                }
                break;
            }
        }
        return var;
    }

    /**
     * Metoda służąca do przypisania wartości zmiennej napisowej, po znaku @String
     * @param line linia z pliku
     * @return wartość zmiennej napisowej
     */
    public String takeValVar(String line){
        for (int i=0; i<line.length(); i++){
            while (line.charAt(i)!='=') {
                i++;
            }
            if (line.charAt(i) == '='){
                i++;
                i++;
                i++;
                while (line.charAt(i)!= '"' && i<line.length()){
                    char c = line.charAt(i);
                    valVar = valVar + c;
                    i++;
                }
                break;
            }
        }
        return valVar;
    }

    /**
     * Matcher dla zmiennej napisowej, ustawie flagę i wartości, jeśli w linii występuje zmienna napisowa
     * @see Pattern
     * @param line linia z pliku
     * @return zmienna napisowa z wartością i flagą
     */
    public VarStrings patternVariableString(String line){
        Matcher varStringMatcher = vS.matcher(line);
        VarStrings variable;
        if (varStringMatcher.find()){
            variable = new VarStrings(takeVar(line),takeValVar(line));
            variable.setFlag();
            return variable;
        }
        else{
            variable = new VarStrings();
            return variable;
        }
    }
}

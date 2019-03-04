package projekt1;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Klasa z główną metodą @see toObject zamieniającą na obiekt
 * Obsługuje także przypisywanie typów pól przy pomocy Pattern
 * Stwierdza w linii obecność obsługiwanego argumentu
 * @see Pattern
 */
public class RecordParser {

    List<String> lines;

    RecordParser(List <String> lines){
        this.lines = lines;
    }


 // ------------------TYPES---------------------------------


    private String article = "(?i)@ARTICLE";
    private Pattern a = Pattern.compile(article);

    private String book = "(?i)@BOOK";
    private Pattern b = Pattern.compile(book);

    private String booklet = "(?i)@BOOKLET";
    private Pattern bl = Pattern.compile(booklet);

    private String conference = "(?i)@CONFERENCE";
    private Pattern c = Pattern.compile(conference);

    private String inbook = "(?i)@INBOOK";
    private Pattern ib = Pattern.compile(inbook);

    private String incollection = "(?i)@INCOLLECTION";
    private Pattern ic = Pattern.compile(incollection);

    private String inproceedings = "(?i)@INPROCEEDINGS";
    private Pattern ip = Pattern.compile(inproceedings);

    private String manual = "(?i)@MANUAL";
    private Pattern m = Pattern.compile(manual);

    private String masterthesis = "(?i)@MASTERSTHESIS";
    private Pattern mt = Pattern.compile(masterthesis);

    private String misc = "(?i)@MISC";
    private Pattern ms = Pattern.compile(misc);

    private String phdthesis = "(?i)@PHDTHESIS";
    private Pattern pt = Pattern.compile(phdthesis);

    private String proceedings = "(?i)@PROCEEDINGS";
    private Pattern p = Pattern.compile(proceedings);

    private String techreport = "(?i)@TECHREPORT";
    private Pattern t = Pattern.compile(techreport);

    private String unpublished = "(?i)@UNPUBLISHED";
    private Pattern u = Pattern.compile(unpublished);


    /**
     * Matcher dla typów rekordów, ustawia flagę i typ rekordu (enum)
     * @param line linia z pliku
     * @return rekord z flagą i typem
     */
    public Records patternTypeMatching(String line){
        Matcher articleMatcher = a.matcher(line);
        Matcher bookMatcher = b.matcher(line);
        Matcher bookletMatcher = bl.matcher(line);
        Matcher conferenceMatcher = c.matcher(line);
        Matcher inbookMatcher = ib.matcher(line);
        Matcher incollectionMatcher = ic.matcher(line);
        Matcher inproceedingsMatcher = ip.matcher(line);
        Matcher manualMatcher = m.matcher(line);
        Matcher masterthesisMatcher = mt.matcher(line);
        Matcher miscMatcher = ms.matcher(line);
        Matcher phdthesisMatcher = pt.matcher(line);
        Matcher proceedingsMatcher = p.matcher(line);
        Matcher techreportsMatcher = t.matcher(line);
        Matcher unpublishedMatcher = u.matcher(line);
        Records record;

        if(articleMatcher.find()){
            record = new Records(Types.article);
            record.setFlag();
            return record;
        }
        if(bookMatcher.find()){
            record = new Records(Types.book);
            record.setFlag();
            return record;
        }
        if(bookletMatcher.find()){
            record = new Records(Types.booklet);
            record.setFlag();
            return record;
        }
        if(conferenceMatcher.find()){
            record = new Records(Types.conference);
            record.setFlag();
            return record;
        }
        if(inbookMatcher.find()){
            record = new Records(Types.inbook);
            record.setFlag();
            return record;
        }
        if(incollectionMatcher.find()){
            record = new Records(Types.incollection);
            record.setFlag();
            return record;
        }
        if(inproceedingsMatcher.find()){
            record = new Records(Types.inproceedings);
            record.setFlag();
            return record;
        }
        if(manualMatcher.find()){
            record = new Records(Types.manual);
            record.setFlag();
            return record;
        }
        if(masterthesisMatcher.find()){
            record = new Records(Types.mastersthesis);
            record.setFlag();
            return record;
        }
        if(miscMatcher.find()){
            record = new Records(Types.misc);
            record.setFlag();
            return record;
        }
        if(phdthesisMatcher.find()){
            record = new Records(Types.phdthesis);
            record.setFlag();
            return record;
        }
        if(proceedingsMatcher.find()){
            record = new Records(Types.proceedings);
            record.setFlag();
            return record;
        }
        if(techreportsMatcher.find()){
            record = new Records(Types.techreport);
            record.setFlag();
            return record;
        }
        if(unpublishedMatcher.find()){
            record = new Records(Types.unpublished);
            record.setFlag();
            return record;
        }
        else return record = new Records();
    }

    private String endOfType = "^}$";
    private Pattern endType = Pattern.compile(endOfType);


    /**
     * Metoda boolean zwracająca true, jeśli w linii znajdował się znak końca rekordu - }
     * @param line linia z pliku
     * @return boolean
     */
    public boolean readTypeTill(String line){
        Matcher endTypeMatcher = endType.matcher(line);

        if (endTypeMatcher.find()){
            return true;
        }
        return false;
    }

    /**
     * Metoda podstawiająca zmienne napisowe w wartościach pól
     * @param variables lista zmiennych napisowych
     * @param value wartość pola do zmienienia
     * @return nowa wartość pola po podstawieniu zmiennej napisowej
     */
    private String changeValue(List <VarStrings> variables, String value){
        for (int i=0; i<variables.size();i++){
            if (field.value.contains(variables.get(i).var)){
                String[] parts = value.split(variables.get(i).var);
                if (parts.length==2){
                    for (int j=0;j-1<parts.length;j++){
                        value = parts[j] + variables.get(i).valVar + parts[j+1];
                        break;
                    }
                }
                else if (parts.length==1){
                    for (int k=0; k<parts.length;k++){
                        value = parts[k] + variables.get(i).valVar;
                    }
                }
                else value = variables.get(i).valVar;
            }
        }
        return value;
    }

    /**
     * Metoda pozbywająca się ignorowanych wartości z wnętrza wartości pól, które przy przypisywaniu wartości nie zostały pominięte, np. log n
     * @see Fields#lineParser
     * @param value wartość pola
     * @return wartość pola po usunięciu znaków ignorowanych
     */
    private String avoidSymbols(String value){
        if (field.value.contains("On log n   loglog n")){
            String[] parts = value.split("On log n   loglog n");
            value = parts[0] + parts[1];
        }
        return value;
    }

    /**
     * Metoda obsługująca wypisanie pola author w przypadku wielu autorów, tak jak w wymaganiach każdy autor w osobnej linii
     * @param value wartość pola
     * @return wartość pola po rozdzieleniu autorów do osobnych linii
     */
    private String mulAuthors(String value){
        if (field.value.contains("and")){
            String[] parts = value.split("and");
            String authors="";
            for (int i=0; i<parts.length;i++){
                seqOfAuthor(parts[i]);
                if (i+1<parts.length) authors += parts[i] + "\n";
                else authors += parts[i];
            }
            value=authors;
        }
        return value;
    }

    /**
     * Metoda zwracająca wartość pola autora w kolejności imie nazwisko
     * @param value wartość pola
     * @return wartość pola po zamienie szyku (lub bez zmian)
     */
    private String seqOfAuthor(String value){
        int licz=0;
        if (value.contains(",")){
            licz++;
        }
        if (licz == 1){
            String[] parts = value.split(",");
            value = parts[1] +" "+ parts[0];
        }
        if (licz == 2){
            String[] parts = value.split(",");
            value = parts[2] + parts[0] + parts[1];
        }
        return value;
    }

    List <Records> records = new ArrayList<>();
    private Fields field = new Fields(FieldType.author);
    VarStrings varString = new VarStrings("","");
    List <VarStrings> variables = new ArrayList<>();


    /**
     * Metoda przerabiająca każdą linijkę tekstu z pliku wraz z obsługą listy typów i listy pól dla każdego typu
     * @see Fields
     * @see Records
     * oraz odpowiednim formatem wartości
     * np. autorzy, miesiące @see Months
     */
    public void toObject() {
        for (int i=0;i<lines.size();i++) {
            varString = varString.patternVariableString(lines.get(i));
            if (varString.isPresent()) {
                variables.add(varString);
            }
            if (patternTypeMatching(lines.get(i)).isPresent()) {
                Records record = patternTypeMatching(lines.get(i));
                record.comment = record.takeComm(lines.get(i));
                List<Fields> fList = record.setList();
                int j = i + 1;
                while (j < lines.size() && !readTypeTill(lines.get(j))) {
                    if (field.patternFieldMatching(lines.get(j)).isPresent()) {
                        field = field.lineParser(lines.get(j));
                        if (!variables.isEmpty()) field.value = changeValue(variables,field.value);
                        if (field.fType.equals(FieldType.author) || field.fType.equals(FieldType.editor)){
                            field.value = mulAuthors(field.value);
                            if (field.value.contains(",")) field.value = seqOfAuthor(field.value);
                        }
                        if (field.fType.equals(FieldType.month)){
                            Months months = new Months(field.value);
                            field.value = months.toMonth(field.value);
                        }
                        if (field.fType.equals(FieldType.journal)){
                            if (field.value.contains("mbox")){
                                field.value = field.value.substring(4);
                            }
                        }
                        if (record.type.equals(Types.techreport) && field.fType.equals(FieldType.title)){
                            field.value = avoidSymbols(field.value);
                        }
                        fList.add(field);
                    }
                    j++;
                }
                record.putList(fList);
                records.add(record);
                if (j < lines.size()) i = j;
                else break;
            }
        }
    }
}

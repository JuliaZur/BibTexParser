package projekt1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa obsługująca pola przy pomocy Pattern
 * Zawiera listę pól dla każdego rekrodu record w pliku
 * oraz wartość pola value
 */
public class Fields {
    FieldType fType;
    String value = "";

    public boolean flag = false;

    /**
     * Zwraca stan flagi, która określa obecność pola w linii
     * @return flaga
     */
    public boolean isPresent() {
        return flag;
    }

    /**
     * Metoda do ustawiania flagi na wartość true
     */
    public void setFlag() {
        flag = true;
    }

    /**
     * Konstruktor typu pola
     * @param fType wartość enum FieldType @see FieldType
     */
    public Fields(FieldType fType) {
        this.fType = fType;
    }

    /**
     *  zwracany w przypadku braku Pattern w linii przez Matcher
     */
    public Fields() {
        /**
         * no instance
         */
    }

    //------------FIELDS------------------------------------

    private String author = "(?i)author";
    private Pattern aut = Pattern.compile(author);

    private String editor = "(?i)editor";
    private Pattern ed = Pattern.compile(editor);

    private String title = "(?i)title";
    private Pattern titl = Pattern.compile(title);

    private String year = "(?i)year";
    private Pattern y = Pattern.compile(year);

    private String journal = "(?i)journal";
    private Pattern j = Pattern.compile(journal);

    private String publisher = "(?i)publisher";
    private Pattern pub = Pattern.compile(publisher);

    private String booktitle = "(?i)booktitle";
    private Pattern bt = Pattern.compile(booktitle);

    private String chapter = "(?i)chapter";
    private Pattern chap = Pattern.compile(chapter);

    private String pages = "(?i)pages";
    private Pattern pag = Pattern.compile(pages);

    private String school = "(?i)school";
    private Pattern shl = Pattern.compile(school);

    private String institution = "(?i)institution";
    private Pattern inst = Pattern.compile(institution);

    private String note = "(?i)note";
    private Pattern nt = Pattern.compile(note);

    private String volume = "(?i)volume";
    private Pattern v = Pattern.compile(volume);

    private String number = "(?i)number";
    private Pattern num = Pattern.compile(number);

    private String month = "(?i)month";
    private Pattern mon = Pattern.compile(month);

    private String key = "(?i)key";
    private Pattern k = Pattern.compile(key);

    private String series = "(?i)series";
    private Pattern ser = Pattern.compile(series);

    private String address = "(?i)address";
    private Pattern ad = Pattern.compile(address);

    private String edition = "(?i)edition";
    private Pattern edit = Pattern.compile(edition);

    private String howpublished = "(?i)howpublished";
    private Pattern hp = Pattern.compile(howpublished);

    private String organization = "(?i)organization";
    private Pattern org = Pattern.compile(organization);

    private String type = "(?i)type";
    private Pattern typ = Pattern.compile(type);

    /** Matcher do patternów wszystkich pól rekordów, ustawia flagę i rodzaj pola
     * @see Matcher
     * @param line pojedyncza linia z pliku
     * @return pojedyncze pole z ustawionym typem i flagą
     */
    public Fields patternFieldMatching(String line) {
        Matcher authorMatcher = aut.matcher(line);
        Matcher editorMatcher = ed.matcher(line);
        Matcher titleMatcher = titl.matcher(line);
        Matcher yearMatcher = y.matcher(line);
        Matcher journalMatcher = j.matcher(line);
        Matcher publisherMatcher = pub.matcher(line);
        Matcher booktitleMatcher = bt.matcher(line);
        Matcher chapterMatcher = chap.matcher(line);
        Matcher pagesMatcher = pag.matcher(line);
        Matcher schoolMatcher = shl.matcher(line);
        Matcher institutionMatcher = inst.matcher(line);
        Matcher noteMatcher = nt.matcher(line);
        Matcher volumeMatcher = v.matcher(line);
        Matcher numberMatcher = num.matcher(line);
        Matcher monthMatcher = mon.matcher(line);
        Matcher keyMatcher = k.matcher(line);
        Matcher seriesMatcher = ser.matcher(line);
        Matcher addressMatcher = ad.matcher(line);
        Matcher editionMatcher = edit.matcher(line);
        Matcher howpublishedMatcher = hp.matcher(line);
        Matcher organizationMatcher = org.matcher(line);
        Matcher typeMatcher = typ.matcher(line);
        Fields field;

        if (authorMatcher.find()) {
            field = new Fields(FieldType.author);
            field.setFlag();
            return field;
        }
        if (editorMatcher.find()) {
            field = new Fields(FieldType.editor);
            field.setFlag();
            return field;
        }
        if (booktitleMatcher.find()) {
            field = new Fields(FieldType.booktitle);
            field.setFlag();
            return field;
        }
        if (titleMatcher.find()) {
            field = new Fields(FieldType.title);
            field.setFlag();
            return field;
        }
        if (yearMatcher.find()) {
            field = new Fields(FieldType.year);
            field.setFlag();
            return field;
        }
        if (journalMatcher.find()) {
            field = new Fields(FieldType.journal);
            field.setFlag();
            return field;
        }
        if (publisherMatcher.find()) {
            field = new Fields(FieldType.publisher);
            field.setFlag();
            return field;
        }
        if (chapterMatcher.find()) {
            field = new Fields(FieldType.chapter);
            field.setFlag();
            return field;
        }
        if (pagesMatcher.find()) {
            field = new Fields(FieldType.pages);
            field.setFlag();
            return field;
        }
        if (schoolMatcher.find()) {
            field = new Fields(FieldType.school);
            field.setFlag();
            return field;
        }
        if (institutionMatcher.find()) {
            field = new Fields(FieldType.institution);
            field.setFlag();
            return field;
        }
        if (noteMatcher.find()) {
            field = new Fields(FieldType.note);
            field.setFlag();
            return field;
        }
        if (volumeMatcher.find()) {
            field = new Fields(FieldType.volume);
            field.setFlag();
            return field;
        }
        if (numberMatcher.find()) {
            field = new Fields(FieldType.number);
            field.setFlag();
            return field;
        }
        if (monthMatcher.find()) {
            field = new Fields(FieldType.month);
            field.setFlag();
            return field;
        }
        if (keyMatcher.find()) {
            field = new Fields(FieldType.key);
            field.setFlag();
            return field;
        }
        if (seriesMatcher.find()) {
            field = new Fields(FieldType.series);
            field.setFlag();
            return field;
        }
        if (addressMatcher.find()) {
            field = new Fields(FieldType.address);
            field.setFlag();
            return field;
        }
        if (editionMatcher.find()) {
            field = new Fields(FieldType.edition);
            field.setFlag();
            return field;
        }
        if (howpublishedMatcher.find()) {
            field = new Fields(FieldType.howpublished);
            field.setFlag();
            return field;
        }
        if (organizationMatcher.find()) {
            field = new Fields(FieldType.organization);
            field.setFlag();
            return field;
        }
        if (typeMatcher.find()) {
            field = new Fields(FieldType.type);
            field.setFlag();
            return field;
        } else return field = new Fields();
    }

    /** Parser linii tekstu przeznaczony do wyszukiwania wartości pól
     * Ustawia wartość pól i ignoruje zbędne elementy (nie pola itp.)
     * @see Pattern
     * @param line pojedyncza linia z pliku
     * @return zwraca pole, które ma zostać dodane do listy pól danego rekordu
     */
    public Fields lineParser(String line) {
        Fields fType = patternFieldMatching(line);
        String fvalue = "";
        if (fType.isPresent()) {
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '=') {
                    i++;
                    i++;
                    int j = 0;
                    while (i < line.length()) {
                        char c = line.charAt(i);
                        if (line.charAt(i) != '\n' && line.charAt(i) != '}' && line.charAt(i) != '{' && line.charAt(i) != '"') {
                            if (c == ',' && i + 1 == line.length()) fvalue = fvalue;
                            else if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9') || c == 39 || c == '-' || c == '+' || c == ' ' || c == '.' || c == ','){
                                if (fType.fType.equals(FieldType.year)){
                                    if (c >= '0' && c <= '9'){
                                        if (j<4) fvalue = fvalue + c;
                                        else if (j==4) fvalue = fvalue + " " + c;
                                        else fvalue = fvalue + c;
                                        j++;
                                    }
                                    else fvalue = fvalue;
                                }
                                else if (fType.fType.equals(FieldType.author)){
                                    if (c != 39) fvalue = fvalue + c;
                                    else fvalue = fvalue;
                                }
                                else fvalue = fvalue + c;
                            }
                            else fvalue = fvalue;
                        }
                        i++;
                    }
                }
            }
        }
        fType.value = fvalue;
        return fType;
    }
}

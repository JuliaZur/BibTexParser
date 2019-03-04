package projekt1;

import java.util.ArrayList;
import java.util.List;

/**
 * Klasa obsługująca typy rekordów
 * Inicjalizuje listę pól wymaganych, później obsługiwaną w Requirements
 * @see Requirements
 */
public class Records {
    List <FieldType> requiredFields;
    List <Fields> list;
    Types type;
    boolean flag = false;
    String comment="";

    /**
     * Metoda zwracająca stan flagi, która określa obecność rekordu w linii
     * @return flaga
     */
    public boolean isPresent() {
        return flag;
    }

    /**
     * Metoda ustawiająca flagę na wartość true
     */
    public void setFlag() {
        flag = true;
    }

    /**
     * Konstruktor typu rekordu
     * @param type wartość enum Types @see Types
     */
    public Records(Types type) {
        this.type = type;
    }

    /**
     * zwracany w przpadku braku obecności typu rekordu w linii
     */
    public Records() {
        /** no instance
         *
         */
    }

    /**
     * Metoda inicjalizująca listę pól dla typu oraz listę pól wymaganych dla odpowiedniego typu rekordu
     * @return pusta lista dla pól rekordu
     */
    public List <Fields> setList() {
        list = new ArrayList<>();
        if (type == Types.article) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.journal);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.book) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.editor);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.publisher);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.booklet) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
        }
        if (type == Types.conference) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.booktitle);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.inbook) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.editor);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.chapter);
            requiredFields.add(FieldType.pages);
            requiredFields.add(FieldType.publisher);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.incollection) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.booktitle);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.inproceedings) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.booktitle);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.manual) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.title);
        }
        if (type == Types.mastersthesis) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.school);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.misc){
            requiredFields = new ArrayList<>(0);
        }
        if (type == Types.phdthesis) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.school);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.proceedings) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.techreport) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.institution);
            requiredFields.add(FieldType.year);
        }
        if (type == Types.unpublished) {
            requiredFields = new ArrayList<>();
            requiredFields.add(FieldType.author);
            requiredFields.add(FieldType.title);
            requiredFields.add(FieldType.note);

        }
        return list;
    }

    /**
     * Metoda przypisująca zmiennej typu Records, czyli pojedynczemu rekordowi, jego listę pól
     * @param list lista pól (wszystkich)
     */
    public void putList(List list){
        this.list = list;
    }

    /**
     * Metoda wyciągająca z linii komentarz do typu rekordu w postaci Stringa
     * np. (article-minimal) oraz obsługa ignorowania wartości takich jak IEEE
     * @param line linia z pliku zawierająca rekord
     * @return napis znajdujący się po deklaracji @typ
     */
    public String takeComm(String line){
        for (int i=0;i<line.length();i++){
            if (line.charAt(i)=='{') {
                i++;
                while (line.charAt(i) != ',' && i<line.length()) {
                    char c = line.charAt(i);
                    comment = comment + c;
                    i++;
                }
            }
        }
        comment = comment;
        String[] parts = comment.split(":");
        if (parts.length == 0) return comment;
        else{
            for (int j=1; j<parts.length; j++) comment += parts[j];
        }
        return comment;
    }
}
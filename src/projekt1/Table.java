package projekt1;


import java.util.List;

/**
 * Klasa obsługująca tworzenie tabelii wyników
 *
 */
public class Table {

    /**
     * Metoda wypisująca w postaci tabelki pojedynczy rekord z obsługą formatu pól autor i editor
     * @param record rekord z listy rekordów
     * @param frame znak obramowania tabelii wczytany z linii komend lub domyślny *
     */
    public void printRecord(Records record, char frame) {
        char c = '■';
        String positioningFields = (frame + " %-35s " + frame + " %-106s" + frame + "%n");
        String positioningFirstAuthorEditor = (frame + " %-36s" + frame + " " + c + " %-104s" + frame + "%n");
        String positioningAuthors = (frame + "%-37c" + frame + " " + c + " %-104s" + frame + " %n");
        String positioningType = (frame + " %-144s" + frame + "%n");
        for (int f = 0; f < 73; f++) {
            System.out.format("%c ", frame);
        }
        System.out.println(frame);
        System.out.format(positioningType, record.type + " (" + record.comment + ")");
        for (int i = 0; i < record.list.size(); i++) {
            if (!record.list.get(i).value.isEmpty()) {
                for (int f = 0; f < 73; f++) {
                    System.out.format("%c ", frame);
                }
                System.out.println(frame);
                if (record.list.get(i).fType.equals(FieldType.author) || record.list.get(i).fType.equals(FieldType.editor)) {
                    String[] parts = record.list.get(i).value.split("\n");
                    if (parts.length == 1)
                        System.out.format(positioningFields, record.list.get(i).fType, record.list.get(i).value);
                    else System.out.format(positioningFirstAuthorEditor, record.list.get(i).fType, " "+parts[0]);
                    for (int j = 1; j < parts.length; j++) {
                        System.out.format(positioningAuthors, ' ', parts[j]);
                    }
                }
                else System.out.format(positioningFields, record.list.get(i).fType, record.list.get(i).value);
            }
        }
    }


    /**
     * Metoda obsługująca listę rekordów i ich wypisywanie przez odwołanie
     * @see Table#printRecord
     * generownie warningów w przypadku braku pól wymaganych
     * obsługa opcji wpisanych w linii komend
     * @param records lista wszystkich rekordów wraz z polami i ich wartościami
     * @param frame znak obramowania wczytany z linii komend lub domyślny *
     * @param commandLine String[] linii komend
     */
    public void printTable(List <Records> records, char frame, CommandLineParser commandLine){
        int licz = 0;
        Requirements requirements = new Requirements(false);
        if (commandLine.flagWholeFile || (!commandLine.flagType && !commandLine.flagField && !commandLine.flagWholeFile)) {
            for (Records record : records) {
                requirements = requirements.meetRequirements(record);
                if (requirements.requirementFlag()) {
                    printRecord(record, frame);
                    licz++;
                    for (int f = 0; f < 73; f++) {
                        System.out.format("%c ", frame);
                    }
                    System.out.println(frame);
                    System.out.println("");
                }
                else{
                    System.out.println("Brak pól wymaganych dla rekordu typu " + record.type.type + "\n");
                }
            }
            if (licz == 0) System.out.println("Brak wyników dla zadanego kryterium");
        }
        if (commandLine.flagType && !commandLine.flagField) {
            for (Records record : records) {
                for (String tp : commandLine.type) {
                    if (record.type.type.equals(tp)) {
                        requirements = requirements.meetRequirements(record);
                        if (requirements.requirementFlag()) {
                            printRecord(record, frame);
                            licz++;
                            for (int f = 0; f < 73; f++) {
                                System.out.format("%c ", frame);
                            }
                            System.out.println(frame);
                            System.out.println("");
                        } else
                            System.out.println("Brak pól wymaganych dla rekordu typu" + record.type.type);
                    }
                }
            }
            if (licz == 0) System.out.println("Brak wyników dla zadanego kryterium");
        }
        if (commandLine.flagType && commandLine.flagField) {
            for (Records record : records) {
                for (String tp : commandLine.type) {
                    if (record.type.type.equals(tp)) {
                        for (int j = 0; j < commandLine.author.size(); j++) {
                            for (int i=0; i<record.list.size(); i++) {
                                if (record.list.get(i).value.contains(commandLine.author.get(j))) {
                                    requirements = requirements.meetRequirements(record);
                                    if (requirements.requirementFlag()) {
                                        printRecord(record, frame);
                                        licz++;
                                        for (int f = 0; f < 73; f++) {
                                            System.out.format("%c ", frame);
                                        }
                                        System.out.println(frame);
                                        System.out.println("");
                                    }
                                    else
                                        System.out.println("Brak pól wymaganych dla rekordu typu" + record.type.type);
                                }
                            }
                        }
                    }
                }
            }
            if (licz == 0) System.out.println("Brak wyników dla zadanego kryterium");
        }

        if (!commandLine.flagType && commandLine.flagField) {
            for (Records record : records) {
                        for (int j = 0; j < commandLine.author.size(); j++) {
                            for (int i=0; i<record.list.size(); i++) {
                                if (record.list.get(i).value.contains(commandLine.author.get(j))) {
                                    requirements = requirements.meetRequirements(record);
                                    if (requirements.requirementFlag()) {
                                        printRecord(record, frame);
                                        licz++;
                                        for (int f = 0; f < 73; f++) {
                                            System.out.format("%c ", frame);
                                        }
                                        System.out.println(frame);
                                        System.out.println("");
                                    }
                                    else
                                        System.out.println("Brak pól wymaganych dla rekordu typu" + record.type.type);
                                }
                            }
                        }
                    }
            if (licz == 0) System.out.println("Brak wyników dla zadanego kryterium");
        }
    }
}

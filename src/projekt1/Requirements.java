package projekt1;

/**
 * Klasa obsługująca pola wymagane
 */
public class Requirements {

    boolean flag = false;

    public Requirements(boolean flag){
        this.flag = flag;
    }

    public boolean requirementFlag(){
        return flag;
    }

    private void setFlag(){
        flag = true;
    }

    /**
     *  Metoda weryfikująca obecność pól wymaganych
     *  porównuje wielkość tablicy pól wymaganych
     *  z liczbą pól znalezionych (tylko wymaganych)
     * @param record rekord z listy rekordów
     * @return typ z ustawioną flagą, true - wymagane pola spełnione
     */
    public Requirements meetRequirements(Records record){
        int licz = 0;
        Requirements requirements = new Requirements(false);
        for(int i=0; i<record.requiredFields.size(); i++){
            for (int j=0; j<record.list.size(); j++){
                if (record.requiredFields.get(i).equals(record.list.get(j).fType)){
                    if (!record.list.get(j).value.isEmpty()){
                        licz++;
                        break;
                    }
                }
            }
        }
        if (record.type.equals(Types.book)){
            if (licz >= record.requiredFields.size()-1) requirements.setFlag();
        }
        if (record.type.equals(Types.inbook)){
            if (licz >= record.requiredFields.size()-2) requirements.setFlag();
        }
        else if (licz == record.requiredFields.size()) requirements.setFlag();
        return requirements;
    }
}


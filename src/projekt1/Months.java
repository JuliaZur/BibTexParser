package projekt1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Klasa obsługująca zamianę skrótów miesięcy przy pomocy pattern matching
 */
public class Months {
    String vMonth="";
    boolean flag = false;


    public Months(String vMonth){
        this.vMonth = vMonth;
    }

    private String january = "jan";
    private Pattern jan = Pattern.compile(january);

    private String february = "feb";
    private Pattern feb = Pattern.compile(february);

    private String march = "mar";
    private Pattern mar = Pattern.compile(march);

    private String april = "apr";
    private Pattern apr = Pattern.compile(april);

    private String may = "may";
    private Pattern mayy = Pattern.compile(may);

    private String june = "jun";
    private Pattern jun = Pattern.compile(june);

    private String july = "jul";
    private Pattern jul = Pattern.compile(july);

    private String august = "aug";
    private Pattern aug = Pattern.compile(august);

    private String september = "sep";
    private Pattern sep = Pattern.compile(september);

    private String october = "oct";
    private Pattern oct = Pattern.compile(october);

    private String november = "nov";
    private Pattern nov = Pattern.compile(november);

    private String december = "dec";
    private Pattern dec = Pattern.compile(december);

    /**
     * Matcher dla skrótów miesięcy, ustawia flagę i przypisuje pełną nazwę miesiąca
     * @param val wartość pola month
     * @return nowa wartość po zamianie skrótu
     */
    public String patternMonthMatcher(String val){
        Matcher janMatcher = jan.matcher(val);
        Matcher febMatcher = feb.matcher(val);
        Matcher marMatcher = mar.matcher(val);
        Matcher aprMatcher = apr.matcher(val);
        Matcher mayMatcher = mayy.matcher(val);
        Matcher junMatcher = jun.matcher(val);
        Matcher julMatcher = jul.matcher(val);
        Matcher augMatcher = aug.matcher(val);
        Matcher sepMatcher = sep.matcher(val);
        Matcher octMatcher = oct.matcher(val);
        Matcher novMatcher = nov.matcher(val);
        Matcher decMatcher = dec.matcher(val);
        String vMonth="";
        if (janMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", january";
                if (val.contains("-")) vMonth += "-january";
            }
            else {
                vMonth += "january";
                flag = true;
            }
        }
        if (febMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", february";
                if (val.contains("-")) vMonth += "-february";
            }
            else {
                vMonth += "february";
                flag = true;
            }
        }
        if (marMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", march";
                if (val.contains("-")) vMonth += "-march";
            }
            else {
                vMonth += "march";
                flag = true;
            }
        }
        if (aprMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", april";
                if (val.contains("-")) vMonth += "-april";
            }
            else {
                vMonth += "april";
                flag = true;
            }
        }
        if (mayMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", may";
                if (val.contains("-")) vMonth += "-may";
            }
            else {
                vMonth += "may";
                flag = true;
            }
        }
        if (junMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", june";
                if (val.contains("-")) vMonth += "-june";
            }
            else {
                vMonth += "june";
                flag = true;
            }
        }
        if (julMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", july";
                if (val.contains("-")) vMonth += "-july";
            }
            else {
                vMonth += "july";
                flag = true;
            }
        }
        if (augMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", august";
                if (val.contains("-")) vMonth += "-august";
            }
            else {
                vMonth += "august";
                flag = true;
            }
        }
        if (sepMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", september";
                if (val.contains("-")) vMonth += "-september";
            }
            else {
                vMonth += "september";
                flag = true;
            }
        }
        if (octMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", october";
                if (val.contains("-")) vMonth += "-october";
            }
            else {
                vMonth += "october";
                flag = true;
            }
        }
        if (novMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", november";
                if (val.contains("-")) vMonth += "-november";
            }
            else {
                vMonth += "november";
                flag = true;
            }
        }
        if (decMatcher.find()){
            if (flag){
                if (val.contains(",")) vMonth += ", december";
                if (val.contains("-")) vMonth += "-december";
            }
            else {
                vMonth += "december";
                flag = true;
            }
        }
        return vMonth;
    }

    /**
     * Metoda obsługująca zamianę skrótów miesięcy na pełne nazwy
     * @see Months#patternMonthMatcher
     * @param month wartość pola month
     * @return nowa wartość pola month
     */
    public String toMonth(String month){
        vMonth = patternMonthMatcher(month);
        return vMonth;
    }
}

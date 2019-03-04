package projekt1;

/** Typ wyliczeniowy zawierający typ pola
 * oraz String pola - np. (author "author")
 */
public enum FieldType {
    author("author"),
    editor("editor"),
    title("title"),
    year("year"),
    journal("journal"),
    publisher("publisher"),
    booktitle("booktitle"),
    chapter("chapter"),
    pages("pages"),
    school("school"),
    institution("institution"),
    note("note"),
    volume("volume"),
    number("numer"),
    month("month"),
    key("key"),
    series("series"),
    address("address"),
    edition("edition"),
    howpublished("howpublished"),
    organization("organization"),
    type("type");

    String field;

    /**
     * @param field String pola
     */
    FieldType(String field){
        this.field = field;
    }

}

package projekt1;

/**
 * Typ wyliczeniowy zawierający typ rekordu
 * oraz String typu - np. (article "article")
 */
public enum Types {
    article ("article"),
    book ("book"),
    booklet ("booklet"),
    conference ("conference"),
    inbook ("inbook"),
    incollection ("incollection"),
    inproceedings ("inproceedings"),
    manual ("manual"),
    mastersthesis ("masterthesis"),
    misc ("misc"),
    phdthesis ("phdthesis"),
    proceedings ("proceedings"),
    techreport ("techreport"),
    unpublished ("unpublished");

    String type;

    Types(String type){
        this.type = type;
    }
}

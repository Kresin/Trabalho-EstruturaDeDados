package model.tag;

public enum SingletonTagsEnum {

    META("<meta>"),
    BASE("<base>"),
    BR("<br>"),
    COL("<col>"),
    COMMAND("<command>"),
    EMBED("<embed>"),
    HR("<hr>"),
    IMG("<img>"),
    INPUT("<input>"),
    LINK("<link>"),
    PARAM("<param>"),
    SOURCE("<source>"),
    DOCTYPE("<!DOCTYPE>");
    
    private final String value;

    private SingletonTagsEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
    
}

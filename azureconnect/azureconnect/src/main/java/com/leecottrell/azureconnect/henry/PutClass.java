package com.leecottrell.azureconnect.henry;

public class PutClass {
    private String BookCode;
    private String Field;
    private String Value;


    public PutClass() {
    }

    public PutClass(String BookCode, String Field, String Value) {
        this.BookCode = BookCode;
        this.Field = Field;
        this.Value = Value;
    }

    public String getBookCode() {
        return this.BookCode;
    }

    public void setBookCode(String BookCode) {
        this.BookCode = BookCode;
    }

    public String getField() {
        return this.Field;
    }

    public void setField(String Field) {
        this.Field = Field;
    }

    public String getValue() {
        return this.Value;
    }

    public void setValue(String Value) {
        this.Value = Value;
    }

    @Override
    public String toString() {
        return "{" +
            " BookCode='" + BookCode + "'" +
            ", Field='" + Field + "'" +
            ", Value='" + Value + "'" +
            "}";
    }

}

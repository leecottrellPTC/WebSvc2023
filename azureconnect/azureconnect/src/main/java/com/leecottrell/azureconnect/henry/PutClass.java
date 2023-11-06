package com.leecottrell.azureconnect.henry;
import java.util.Objects;

public class PutClass {
    private String primaryKey;
    private String fieldName;
    private String value;
    //setters getters constructors


    public PutClass() {
    }

    public PutClass(String primaryKey, String fieldName, String value) {
        this.primaryKey = primaryKey;
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getPrimaryKey() {
        return this.primaryKey;
    }

    public void setPrimaryKey(String primaryKey) {
        this.primaryKey = primaryKey;
    }

    public String getFieldName() {
        return this.fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public PutClass primaryKey(String primaryKey) {
        setPrimaryKey(primaryKey);
        return this;
    }

    public PutClass fieldName(String fieldName) {
        setFieldName(fieldName);
        return this;
    }

    public PutClass value(String value) {
        setValue(value);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof PutClass)) {
            return false;
        }
        PutClass putClass = (PutClass) o;
        return Objects.equals(primaryKey, putClass.primaryKey) && Objects.equals(fieldName, putClass.fieldName) && Objects.equals(value, putClass.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(primaryKey, fieldName, value);
    }

    @Override
    public String toString() {
        return "{" +
            " primaryKey='" + getPrimaryKey() + "'" +
            ", fieldName='" + getFieldName() + "'" +
            ", value='" + getValue() + "'" +
            "}";
    }
    
}

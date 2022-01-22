package com.java_advanced.exceptions;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(String entity, String field, String value) {
    super(String.format("No item found for %s with field %S value = %s", entity, field, value));
    }
}

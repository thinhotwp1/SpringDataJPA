package com.example.springjpa.rest;

public class ResponseData<T> {
    private T data;

    public ResponseData(T data) {
        this.data = data;
    }

    public ResponseData(String error) {
        this.error = error;
    }

    private String description;
    private String error;
}

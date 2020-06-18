package com.flowable.training.externalapp.feedback;

public class CustomerFeedback {

    private String name;
    private String clientId;
    private String category;
    private String subcategory;
    private String message;
    private String email;

    public CustomerFeedback() {
    }

    public CustomerFeedback(String name, String clientId, String category, String subcategory, String message, String email) {
        this.name = name;
        this.clientId = clientId;
        this.category = category;
        this.subcategory = subcategory;
        this.message = message;
        this.email = email;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getClientId() {
        return clientId;
    }
    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public String getSubcategory() {
        return subcategory;
    }
    public void setSubcategory(String subcategory) {
        this.subcategory = subcategory;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}

package com.hng.internship.classifier;

public class Response {

    private String status;
    private Data data;

    public Response(Data data){
        status = "success";
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}

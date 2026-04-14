package com.hng.internship.classifier;

public class Data {

    private String name;
    private String gender;
    private double probability;
    private int sample_size;
    private boolean isConfident;
    private String processed_at;

    public String getName() {
        return name;
    }

    public int getSample_size() {
        return sample_size;
    }

    public boolean isConfident() {
        return sample_size >= 100 && probability >= 0.7;
    }

    public double getProbability() {
        return probability;
    }

    public String getGender() {
        return gender;
    }

    public String getProcessed_at() {
        return processed_at;
    }


    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public void setProcessed_at(String processed_at) {
        this.processed_at = processed_at;
    }

    public void setSample_size(int sample_size) {
        this.sample_size = sample_size;
    }
}

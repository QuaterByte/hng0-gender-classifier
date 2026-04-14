package com.hng.internship.classifier;

public class Genderize {

    private int count;
    private String name;
    private double probability;
    private  String gender;

    public void setProbability(double probability) {
        this.probability = probability;
    }

    public String getGender() {
        return gender;
    }

    public double getProbability() {
        return probability;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}

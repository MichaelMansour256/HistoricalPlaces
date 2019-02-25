package com.example.fr3on.historicalplaces.model;

public class place {
    private  String name;
    private  String country;
    private  String description;
    private  int image;
    private  int rate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public place(String name, String country, String description, int image) {
        this.name = name;
        this.country = country;
        this.description = description;
        this.image = image;
        rate = 0;

    }
}

package com.example.yiupang.freefoodfinder;

import java.util.Date;

public class Event
{
    public long eventId;
    public long userId;
    private String name;
    public Date time;
    private String foodType;
    private String description;
    private double latitude;
    private double longitude;

    public String getName() {
        return name;
    }

    public boolean setName(String name) {
        if (name.length() > 3 && name.length() < 31) {
            this.name = name;
            return true;
        } else {
            return false;
        }
    }

    public String getFoodType() {
        return foodType;
    }

    public boolean setFoodType(String foodType){
        if(foodType.length() > 3 && foodType.length() <31) {
            this.foodType = foodType;
            return true;
        }
        else{
            return false;
        }
    }

    public double getLatitude(){
        return latitude;
    }

    public boolean setLatitude(double latitude){
        if(latitude >= -90.0 && latitude <= 90.0){
            this.latitude = latitude;
            return true;
        }
        else{
            return false;
        }
    }

    public double getLongitude(){
        return longitude;
    }

    public boolean setLongitude(double longitude){
        if(latitude >= -90.0 && latitude <= 90.0){
            this.longitude = longitude;
            return true;
        }
        else{
            return false;
        }
    }

    public String getDescription(){return this.description;}


    public Event(String name, String foodType, String description)
    {
        this.name = name;
        this.foodType = foodType;
        this.description = description;
    }
}



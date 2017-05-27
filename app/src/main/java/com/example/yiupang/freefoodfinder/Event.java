package com.example.yiupang.freefoodfinder;

import java.util.Date;

public class Event
{
    private long eventId;
    private long userId;
    private String name;
    private Date time;
    private String foodType;
    private String description;
    private double lat;
    private double lng;

    public Event(){
        //Empty Constructor
    }

    public Event(String name, String foodType, String description)
    {
        this.name = name;
        this.foodType = foodType;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public long getEventId() { return eventId;}
    public void setEventId(long id) { eventId = id; }

    public long getUserId(){ return userId; }
    public void setUserId(long id){ userId = id; }

    public Date getTime(){ return time; }
    public void setTime(Date d){ time = d; }

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

    public double getLat(){
        return lat;
    }

    public boolean setLatitude(double latitude){
        if(latitude >= -90.0 && latitude <= 90.0){
            this.lat = latitude;
            return true;
        }
        else{
            return false;
        }
    }

    public double getLng(){
        return lng;
    }

    public boolean setLongitude(double longitude){
        if(longitude >= -180.0 && longitude <= 180.0){
            this.lng = longitude;
            return true;
        }
        else{
            return false;
        }
    }

    public String getDescription(){return this.description;}
    public void setDescription(String desc){description = desc;}

    @Override
    public String toString(){
        return "name: " + this.name;
    }

}



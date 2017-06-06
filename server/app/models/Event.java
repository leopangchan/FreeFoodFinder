package models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Event
{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long eventId;
    private long userId;
    private Date time;
    private String name;
    private String place;
    private String foodType;
    private String description;
    private double lat;
    private double lng;

    public void setEventId(long id)
    {
    	eventId = id;
    }

    public long getEventId()
    {
    	return eventId;
    }

    public void setUserId(long id)
    {
    	userId = id;
    }

    public long getUserId()
    {
    	return userId;
    }

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getFoodType() {
		return foodType;
	}

	public void setFoodType(String foodType) {
		this.foodType = foodType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLng() {
		return lng;
	}

	public void setLng(double lng) {
		this.lng = lng;
	}
}

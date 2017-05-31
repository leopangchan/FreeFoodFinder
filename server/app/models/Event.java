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
    public long eventId;
    public long userId;
    public String name;
    public Date time;
    public String foodType;
    public String description;
    public double lat;
    public double lng;
}

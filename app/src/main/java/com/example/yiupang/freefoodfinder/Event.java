import java.util.date;

@Entity
public class Event
{
    @Id
    public long eventId;
    public long userId;
    public String name;
    public Date time;
    public String foodType;
    public String description;
    public double lat;
    public double lng;
}

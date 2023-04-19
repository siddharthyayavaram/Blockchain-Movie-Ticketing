import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

public class Shows {
    private int seats;
    private String movie_name;
    private int price;
    private Date time;
    private int showid;
    private static final AtomicInteger count = new AtomicInteger(0);

    public Shows(int seats, String movie_name, int price, Date time) {
        this.seats = seats;
        this.movie_name = movie_name;
        this.price = price;
        this.time = time;
        showid = count.incrementAndGet();
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void updateseats(int i){
        this.seats -= i;
    }

    public String getMovieName() {
        return movie_name;
    }

    public void setMovieName(String movie_name) {
        this.movie_name = movie_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getShowID() {
        return showid;
    }

    public void setShowID(int showid) {
        this.showid = showid;
    }

    @Override
    public String toString() {
        return "Show ID: " + showid + "\nMovie Name: " + movie_name + "\nTime: " + time + "\nTicket Price: " + price + "\nSeats Available: " + seats;
    }
}

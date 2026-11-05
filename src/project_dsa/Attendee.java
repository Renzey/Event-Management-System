package project_dsa;


public class Attendee {

    private int id;
    private String name;
    private String email;
    private int eventId;
    private String priority;   
    private boolean checkedIn;
    private int rating;        
    private long arrival;      

    public Attendee(int id, String name, String email, int eventId, String priority) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.eventId = eventId;
        this.priority = priority;
    }

   
    public int getPriorityRank() {
        if (priority.equalsIgnoreCase("VIP")) {
            return 0;
        } else if (priority.equalsIgnoreCase("Member")) {
            return 1;
        }
        return 2;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public int getEventId() { return eventId; }
    public String getPriority() { return priority; }
    public boolean isCheckedIn() { return checkedIn; }
    public int getRating() { return rating; }
    public long getArrival() { return arrival; }

    public void setCheckedIn(boolean checkedIn) { this.checkedIn = checkedIn; }
    public void setRating(int rating) { this.rating = rating; }
    public void setArrival(long arrival) { this.arrival = arrival; }
}
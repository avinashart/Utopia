package adapter;


public class events_list_adapter {

    String day,eventName,coordinator,numberOfEntries,venue,message;

    public void setMessage(String message) {
        this.message = message;
    }

    public events_list_adapter(String day, String eventName, String coordinator, String numberOfEntries, String venue,String message) {
        this.day = day;
        this.eventName = eventName;
        this.coordinator = coordinator;
        this.numberOfEntries = numberOfEntries;
        this.venue = venue;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }

    public void setNumberOfEntries(String numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDay() {
        return day;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCoordinator() {
        return coordinator;
    }

    public String getNumberOfEntries() {
        return numberOfEntries;
    }

    public String getVenue() {
        return venue;
    }
}

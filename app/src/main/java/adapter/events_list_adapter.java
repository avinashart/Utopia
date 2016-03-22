package adapter;


public class events_list_adapter {

    String eventName,coordinator;
    String day;
    public events_list_adapter(String eventName, String coordinator,String day) {
        this.day = day;
        this.eventName = eventName;
        this.coordinator = coordinator;

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



    public String getDay() {
        return day;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCoordinator() {
        return coordinator;
    }
}

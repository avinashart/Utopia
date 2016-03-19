package adapter;


public class events_list_adapter {

    String eventName,coordinator;
    int day;


    public events_list_adapter(int day, String eventName, String coordinator) {
        this.day = day;
        this.eventName = eventName;
        this.coordinator = coordinator;

    }


    public void setDay(int day) {
        this.day = day;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setCoordinator(String coordinator) {
        this.coordinator = coordinator;
    }



    public int getDay() {
        return day;
    }

    public String getEventName() {
        return eventName;
    }

    public String getCoordinator() {
        return coordinator;
    }


}

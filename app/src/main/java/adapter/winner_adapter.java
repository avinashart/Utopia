package adapter;

/**
 * Created by avinashk on 20/03/16.
 */
public class winner_adapter {

    String eventName,winnerName,teamName;


    public winner_adapter(String eventName, String winnerName, String teamName) {
        this.eventName = eventName;
        this.winnerName = winnerName;
        this.teamName = teamName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public void setWinnerName(String winnerName) {
        this.winnerName = winnerName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getEventName() {
        return eventName;
    }

    public String getWinnerName() {
        return winnerName;
    }

    public String getTeamName() {
        return teamName;
    }
}

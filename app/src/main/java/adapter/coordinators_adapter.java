package adapter;

/**
 * Created by avinashk on 18/03/16.
 */
public class coordinators_adapter  {

    String name;
    String number;

    public coordinators_adapter(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

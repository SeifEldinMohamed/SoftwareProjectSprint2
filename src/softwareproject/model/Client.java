package softwareproject.model;

import java.util.ArrayList;

public class Client extends User {

    public ArrayList<Ride> getFinishedRides() {
        return finishedRides;
    }

    public boolean setFinishedRides(ArrayList<Ride> finishedRides) {
        this.finishedRides = finishedRides;
        return true;
    }

    public Boolean getClientStatus() {
        return clientStatus;
    }

    public boolean setClientStatus(Boolean clientStatus) {
        this.clientStatus = clientStatus;
        return true;
    }

    public int getCount() {
        return count;
    }

    ArrayList<Ride> finishedRides = new ArrayList<>();
    Boolean clientStatus=true;
    int count = 0 ;

    public boolean setCount(int count) {
        this.count = count;
        return true;
    }


    public Client(String userName, String password) {
        super(userName, password);
    }

    public Boolean getStatus() {
        return clientStatus;
    }

    public boolean setStatus ( Boolean status ) {
        return this.clientStatus = status;
    }


}
package softwareproject.controler;

import softwareproject.model.Client;
import softwareproject.model.DataBaseSystem;
import softwareproject.model.Event;
import softwareproject.model.Ride;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClientController {
    DataBaseSystem dataBaseSystem= DataBaseSystem.getInstance();

    public boolean PickRide(String sourceRide , String destination, Client client) {
        Ride clientRide = new Ride( sourceRide ,destination );
        dataBaseSystem.addRideRequest ( clientRide ,client );
        if ( dataBaseSystem.matchRidesWithDrivers ( ) ) {
            System.out.println ( " Looking for drivers " );
            return true;

        } else {
            System.out.println ( " There are no drivers available right now please try again later " );
            return false;
        }

            }
    public Ride searchForClientRide(Client client)
    {
        return dataBaseSystem.searchForClientRide ( client );

    }
    public boolean addDriverRate(int rateValue, Ride clientRide)
    {
        return dataBaseSystem.addDriverRate(rateValue, clientRide.getDriver());

    }
    public Double avgDriverRate(Ride clientRide)
    {
        return(dataBaseSystem.avgDriverRate(clientRide.getDriver()));
    }
    public boolean getFinishedRides(Ride clientRide)
    {
        return dataBaseSystem.getFinishedRides().remove(clientRide);
    }
    public boolean acceptOffer(Ride clientRide) throws InterruptedException {
        clientRide.getClient().setCount(1);
        clientRide.getDriver().setIsAvailable(false); // assign driver to this ride
        clientRide.getDriver().getRequestedRides().remove(clientRide); // to delete the accepted ride from the driver list
        System.out.println("Driver is coming to you..");

        // date and adding event
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Event clientAcceptOfferEvent = new Event("client accepts driver offer", dtf.format(now));
        clientAcceptOfferEvent.setClientName(clientRide.getClient().getUserName());
        dataBaseSystem.getRideEvents().add(clientAcceptOfferEvent);

        Thread.sleep(5000);
        System.out.println("Driver arrived to your location");

        // date and adding event
        DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now2 = LocalDateTime.now();
        Event driverArrivedToUserLocationEvent = new Event("driver arrived to user location", dtf2.format(now2));
        driverArrivedToUserLocationEvent.setClientName(clientRide.getClient().getUserName());
        driverArrivedToUserLocationEvent.setDriverName(clientRide.getDriver().getUserName());
        dataBaseSystem.getRideEvents().add(driverArrivedToUserLocationEvent);


        clientRide.setFinished( true);
        dataBaseSystem.getFinishedRides().add(clientRide);
        dataBaseSystem.getRideRequests().remove(clientRide);
        return  true;
    }
    public boolean removeRideRequestFromDriverRides(Ride clientRide)
    {
        return dataBaseSystem.getRideRequests().remove ( clientRide );

    }

}





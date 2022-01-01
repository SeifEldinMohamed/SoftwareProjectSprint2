package softwareproject.controler;

import softwareproject.model.DataBaseSystem;
import softwareproject.model.Driver;
import softwareproject.model.Event;
import softwareproject.model.Ride;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DriverController {
    DataBaseSystem dataBaseSystem= DataBaseSystem.getInstance();
    public boolean addFavouriteArea(Driver driver, String driverFavouritePlace)
    {
        driver.addFavouriteArea ( driverFavouritePlace );
        return true;
    }
    public boolean showMatchedRides(Driver driver)
    {
        return dataBaseSystem.showMatchedRides(driver);
    }
    public boolean showUserRate(Driver driver)
    {
        return dataBaseSystem.showUserRate(driver);
    }
    public boolean driverOffer(Ride ride, Driver driver, double driverOffer)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Event driverOfferEvent = new Event("Driver offer price to ride",dtf.format(now));
        driverOfferEvent.setDriverName(driver.getUserName());
        driverOfferEvent.setRidePrice(driverOffer);

        ride.setPrice(driverOffer);
        dataBaseSystem.getRideEvents().add(driverOfferEvent);
        ride.setDriver(driver);
        driver.setCurrentRide(ride);
        return true;
    }
    public boolean DriverArrivedToUserDestinationEvent(Driver driver){
        // date and adding event
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Event DriverArrivedToUserDestinationEvent = new Event("driver arrived to user destination", dtf.format(now));
        DriverArrivedToUserDestinationEvent.setClientName(driver.getCurrentRide().getClient().getUserName());
       DriverArrivedToUserDestinationEvent.setDriverName(driver.getUserName());
        dataBaseSystem.getRideEvents().add(DriverArrivedToUserDestinationEvent);
        return true ;
    }
        }


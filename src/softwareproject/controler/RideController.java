package softwareproject.controler;

import softwareproject.model.DataBaseSystem;
import softwareproject.model.Ride;

public class RideController {
    DataBaseSystem dataBaseSystem = DataBaseSystem.getInstance();
    public boolean checkDestinationWithDiscountAreas(Ride ride){
       if (dataBaseSystem.getDiscountAreas().contains(ride.getDestination())){
           return true;
       }
       return false;
    }
    public double tenPercentageDiscount(Ride ride){
        return ride.getPrice() * 0.9 ;
    }
}

package softwareproject.view;

import softwareproject.controler.AdminController;
import softwareproject.controler.ClientController;
import softwareproject.controler.DriverController;
import softwareproject.model.Admin;
import softwareproject.model.Client;
import softwareproject.model.DataBaseSystem;
import softwareproject.model.Driver;

public class SignIn {
    DataBaseSystem dataBaseSystem= DataBaseSystem.getInstance();
    DriverController driverOption=new DriverController();
    ClientController clientOption=new ClientController();
    AdminController adminOption=new AdminController();
    public Client clientSignIN(String userName, String password)
    {
        Client client = dataBaseSystem.searchForClient ( new Client ( userName ,password ) );
        if ( client.getUserName ( ).equals ( "-1" ) ) {

            return null;
        }
        else
        {
            return client;
        }
    }
    public Driver driverSignIN(String userName, String password)
    {
        Driver driver = dataBaseSystem.searchForDriver ( new Driver ( userName ,password ) );
        if ( dataBaseSystem.searchForUser ( driver ) ) {

            return driver;
        }
        else {

            return null;
        }
    }
    public Admin adminSignIN (String userName, String password )
    {
        Admin admin = new Admin ( userName ,password );
        if ( dataBaseSystem.searchForUser ( admin ) ) {
            return admin ;
        }
        else {
            System.out.println ( "not found" );
            return null;
        }
    }
}

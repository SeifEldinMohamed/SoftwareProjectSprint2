package softwareproject.view;

import softwareproject.model.Client;
import softwareproject.model.DataBaseSystem;
import softwareproject.model.Driver;

public class SignUp {
    DataBaseSystem dataBaseSystem= DataBaseSystem.getInstance();
    public void clientSignUp(String userName, String email, String password)
    {
        Client client1 = new Client ( userName ,password );
        client1.setEmail ( email );
        dataBaseSystem.addClient ( client1 );
        System.out.println ( "" );
    }
    public void driverSignUp(String userName, String email , String password , String nationalId , String driverLicense )
    {

        Driver driver1 = new Driver ( userName ,password ,nationalId ,driverLicense );
        driver1.setEmail ( email );
        dataBaseSystem.addDriver ( driver1 ); // add to pending list



    }
}

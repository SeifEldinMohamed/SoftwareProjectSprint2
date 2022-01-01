package softwareproject.controler;

import softwareproject.model.DataBaseSystem;

public class AdminController {

    DataBaseSystem dataBaseSystem = DataBaseSystem.getInstance();

    public boolean showClientList() {
        return dataBaseSystem.showClientsList();
    }

    public boolean showActiveDrivers() {
        return dataBaseSystem.showActiveDrivers();
    }

    public boolean suspendClient(Integer index) {
        return dataBaseSystem.getClients().get(index - 1).setStatus(false);
    }

    public boolean unSuspendClient(Integer index) {
        return dataBaseSystem.getClients().get(index - 1).setStatus(true);
    }

    public boolean suspendDriver(Integer index) {
        return dataBaseSystem.getActiveDrivers().get(index - 1).setDriverStatus(false);
    }

    public boolean unSuspendDriver(Integer index) {
        return dataBaseSystem.getActiveDrivers().get(index - 1).setDriverStatus(true);
    }

    public boolean acceptDriverRequest(Integer index) {
        if (dataBaseSystem.getPendingDrivers().get(index - 1).setDriverStatus(true)) {
            dataBaseSystem.getActiveDrivers().add(dataBaseSystem.getPendingDrivers().get(index - 1));
            dataBaseSystem.getPendingDrivers().remove(index - 1);
            return true;
        }

        return false;
    }

    public boolean rejectDriverRequest(Integer index) {
        dataBaseSystem.getPendingDrivers().remove(index - 1);
        return true;
    }

    public boolean showRideEvents() {
        if(dataBaseSystem.getRideEvents().isEmpty()){
            return false;
        }
            for (int i = 0; i < dataBaseSystem.getRideEvents().size(); i++) {
                System.out.println(++i + "- " + dataBaseSystem.getRideEvents().get(--i));
            }
       return true;
    }
    public boolean addToDiscountAreas(String areaName){
        dataBaseSystem.getDiscountAreas().add(areaName);
        return true;
    }


}
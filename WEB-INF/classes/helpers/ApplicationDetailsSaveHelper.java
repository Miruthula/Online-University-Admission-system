package helpers;

import databasequeries.GetUserApplicationDetails;
import databasequeries.SaveUserApplicationDetails;
import model.UserDetails;

public class ApplicationDetailsSaveHelper {
    
    GetUserApplicationDetails getUserApplicationDetails = new GetUserApplicationDetails();
    SaveUserApplicationDetails saveUserApplicationDetails = new SaveUserApplicationDetails();

    public void insertNewApplication(UserDetails usrDetails)
    {
        int newApplnId = getUserApplicationDetails.getMaxApplicationId();
        usrDetails.getCurrentApplication().setApplnId(String.valueOf(newApplnId));
        saveUserApplicationDetails.insertApplication(usrDetails, newApplnId);
        
    }
    
    public void updateApplications(UserDetails usrDetails)
    {
        //int newApplnId = getUserApplicationDetails.getMaxApplicationId();
        
        saveUserApplicationDetails.updateApplication(usrDetails);
        
    }
    
    
    
    
}

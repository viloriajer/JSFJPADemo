package dmit2015.jviloria.review03.view;

import dmit2015.jviloria.review03.model.Covid19Data;
import dmit2015.jviloria.review03.service.Covid19DataService;
import lombok.Getter;
import org.omnifaces.util.Messages;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class Covid19DataCreateAndListController implements Serializable {

    @Getter
    private Covid19Data currentData = new Covid19Data();

    @Inject
    private Covid19DataService dataService;

    public List<Covid19Data> GetData() {
        return dataService.findAll();
    }

    public String addData() {
        // Add the bill to the system
        dataService.add(currentData);
        // Send a feedback message that indicates operation was successful
        Messages.addGlobalInfo("Successfully created Data log.");
        // Create another bill to add
        currentData = new Covid19Data();
        // Return navigation to the same page
        return "";
    }

    public void deleteData(long id) {
        // Delete the game from the system
        dataService.remove(id);
        // Send a feedback message to indicates operation was successful
        Messages.addGlobalInfo("Successfully removed Data Information.");
    }

}

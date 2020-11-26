package dmit2015.jviloria.review03.view;

import dmit2015.jviloria.review03.model.Covid19Data;
import dmit2015.jviloria.review03.service.Covid19DataService;
import lombok.Getter;
import org.omnifaces.util.Faces;
import org.omnifaces.util.Messages;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Optional;

@Named
@ViewScoped
public class Covid19DataEditController implements Serializable {

    @Inject
    @ManagedProperty("#{param.editId}")
    private Long editId;

    @Getter
    private Covid19Data existingData;

    @Inject
    private Covid19DataService dataService;

    @PostConstruct  // executes after all @Inject is completed
    public void init() {
        if (!Faces.isPostback()) {
            Optional<Covid19Data> optionalData = dataService.findById(editId);
            if (optionalData.isPresent()) {
                existingData = optionalData.get();
            }
        }

    }

    public String updateBill() {
        dataService.update(existingData);
        Messages.addFlashGlobalInfo("Successfully updated Data.");
        return "manageData?faces-redirect=true";
    }

    public String deleteBill() {
        dataService.remove(existingData.getId());
        Messages.addFlashGlobalInfo("Successfully deleted Data.");
        return "manageData?faces-redirect=true";
    }
}

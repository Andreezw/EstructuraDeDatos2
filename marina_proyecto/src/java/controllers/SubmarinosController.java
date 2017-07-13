package controllers;

import models.Submarinos;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "submarinosController")
@ViewScoped
public class SubmarinosController extends AbstractController<Submarinos> {

    @Inject
    private BarcoController idBarcoController;

    public SubmarinosController() {
        // Inform the Abstract parent controller of the concrete Submarinos Entity
        super(Submarinos.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idBarcoController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the Barco controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdBarco(ActionEvent event) {
        if (this.getSelected() != null && idBarcoController.getSelected() == null) {
            idBarcoController.setSelected(this.getSelected().getIdBarco());
        }
    }
}

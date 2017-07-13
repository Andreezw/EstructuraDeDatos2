package controllers;

import models.Destructores;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "destructoresController")
@ViewScoped
public class DestructoresController extends AbstractController<Destructores> {

    @Inject
    private BarcoController idBarcoController;

    public DestructoresController() {
        // Inform the Abstract parent controller of the concrete Destructores Entity
        super(Destructores.class);
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

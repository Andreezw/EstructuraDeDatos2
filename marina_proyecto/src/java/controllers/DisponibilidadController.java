package controllers;

import models.Disponibilidad;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;

@Named(value = "disponibilidadController")
@ViewScoped
public class DisponibilidadController extends AbstractController<Disponibilidad> {

    @Inject
    private BarcoController idBarcoController;

    public DisponibilidadController() {
        // Inform the Abstract parent controller of the concrete Disponibilidad Entity
        super(Disponibilidad.class);
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

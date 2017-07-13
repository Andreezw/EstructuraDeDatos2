package controllers;

import models.Barco;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

@Named(value = "barcoController")
@ViewScoped
public class BarcoController extends AbstractController<Barco> {

    public BarcoController() {
        // Inform the Abstract parent controller of the concrete Barco Entity
        super(Barco.class);
    }

    /**
     * Sets the "items" attribute with a collection of Corbeta entities that are
     * retrieved from Barco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Corbeta page
     */
    public String navigateCorbetaCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Corbeta_items", this.getSelected().getCorbetaCollection());
        }
        return "/corbeta/index";
    }

    /**
     * Sets the "items" attribute with a collection of Disponibilidad entities
     * that are retrieved from Barco?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Disponibilidad page
     */
    public String navigateDisponibilidadCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Disponibilidad_items", this.getSelected().getDisponibilidadCollection());
        }
        return "/disponibilidad/index";
    }

    /**
     * Sets the "items" attribute with a collection of Destructores entities
     * that are retrieved from Barco?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for Destructores page
     */
    public String navigateDestructoresCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Destructores_items", this.getSelected().getDestructoresCollection());
        }
        return "/destructores/index";
    }

    /**
     * Sets the "items" attribute with a collection of Fragata entities that are
     * retrieved from Barco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Fragata page
     */
    public String navigateFragataCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Fragata_items", this.getSelected().getFragataCollection());
        }
        return "/fragata/index";
    }

    /**
     * Sets the "items" attribute with a collection of Submarinos entities that
     * are retrieved from Barco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Submarinos page
     */
    public String navigateSubmarinosCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Submarinos_items", this.getSelected().getSubmarinosCollection());
        }
        return "/submarinos/index";
    }

    /**
     * Sets the "items" attribute with a collection of Rutas entities that are
     * retrieved from Barco?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Rutas page
     */
    public String navigateRutasCollection() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Rutas_items", this.getSelected().getRutasCollection());
        }
        return "/rutas/index";
    }

}

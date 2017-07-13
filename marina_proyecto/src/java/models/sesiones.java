package models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpSession;

import models.usuarios;


public class sesiones {
    private String usuario;
    private String clave;
    private String msg;
    private boolean logeado;
    private HttpSession User;

    public sesiones() {
        this.usuario = "";
        this.clave = "";
        this.logeado = false;
    }

    public sesiones(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
        this.logeado = true;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isLogeado() {
        return logeado;
    }

    public void setLogeado(boolean logeado) {
        this.logeado = logeado;
    }

    public boolean getLogeado() {
        return this.logeado;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   
}

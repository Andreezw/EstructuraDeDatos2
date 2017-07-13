/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="usuarios")
@NamedQuery(name="usuarios.findAll", query="SELECT a FROM usuarios a")
public class usuarios implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    private String correo;
    private String usuario;
    private String clave;

    private static String busqueda = "";
    private static String criterio = "";
    private static String msg = "";

    public usuarios() {
    }
    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
    public usuarios(String correo, String usuario, String clave) {
        this.correo = correo;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getCorreo() {
        return this.correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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

    public static String getMsg() {
        return msg;
    }

    public static void setMsg(String msg) {
        usuarios.msg = msg;
    }

    public void setUser( List user)  {
    	usuarios us;
    	us = (usuarios)user.get(0);
        this.setCorreo(us.getCorreo());
        this.setUsuario(us.getUsuario());
        this.setClave(us.getClave());
    }
    public boolean Login(String user, String pass) {
    	EntityManagerFactory emf=Persistence.createEntityManagerFactory("marina_proyectoPU");
		EntityManager em=emf.createEntityManager();
        boolean ok=false;
        String sql="";
		String parametro="";
		try{
			Query q =em.createNamedQuery("usuarios.findAll");
			sql = "SELECT u FROM usuarios u where u.usuario = :p and u.clave = :q ";
			q = em.createQuery(sql);
			q.setParameter("p", user);
			q.setParameter("q", this.sha256(pass));
			@SuppressWarnings("rawtypes")
			List list = q.getResultList();
			if(!list.isEmpty()){
				usuarios u = new usuarios();
				u.setUser(list);
				ok=true;
			}	
			return ok;
		} catch (Exception e){
			System.out.println("Error" + e.getMessage());
		}
		finally{
			em.close();
			emf.close();
		}
        return ok;
    }
    public String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }
public static void Insertar(String usuario,String clave, String correo){
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("marina_proyectoPU");
		EntityManager em=emf.createEntityManager();
		try {
			usuarios user=new usuarios(correo, usuario,clave);
			//empieza la transacion
			em.getTransaction().begin();
			em.persist(user);//guardando datos
			em.getTransaction().commit();//guardo la transacion
			System.out.println("el proceso de grabado fue un exito");
			
		} catch (Exception e) {
			em.getTransaction().rollback();//si existe error la transacion hace rollbacks
			System.out.println("error"+e.getMessage());
			
		}
		finally{
			em.close();
			emf.close();
		}
	}
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.usuarios;

@WebServlet(name = "controlInicioFinSesion", urlPatterns = {"/log"})
public class controlInicioFinSesion extends HttpServlet {

    HttpSession session;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = "";
        if (request.getParameter("accion") != null) {
            accion = request.getParameter("accion");
            switch (accion) {
                case "login":
                    System.out.println("Iniciando");
                    this.IniciarSesion(request, response);
                    System.out.println("Fin");
                    break;
                case "registro":
                    System.out.println("registro");
                    this.Registro(request, response);
                    break;
                case "salir":
                    this.cerrarSesion(request, response);
                    break;
                default:
                    response.sendRedirect("index.jsp");
                    break;
            }
        } else {
            response.sendRedirect("index.jsp");
        }
    }

    protected void IniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("marina_proyectoPU");
        EntityManager em = emf.createEntityManager();
        ArrayList errores = new ArrayList();
        String strusuario = request.getParameter("usuario");
        String strclave = request.getParameter("password");
        RequestDispatcher vista;
        if (strusuario == null) {
            errores.add("Ingrese usuario\n");
        }
        if (strclave == null) {
            errores.add("Ingrese clave\n");
        }

        if (errores.isEmpty()) {

            usuarios user = new usuarios();
            System.out.println("Error vacio");
            if (user.Login(strusuario, strclave)) {
                session = request.getSession(true);
                System.out.println("Logeado");
                session.setAttribute("logged", true);
                session.setAttribute("user", user);
                response.sendRedirect("index.xhtml");
            } else {
                errores.add("Error de usuario o clave\n");
                request.setAttribute("errores", errores);
                vista = request.getRequestDispatcher("index.jsp");
                vista.include(request, response);
            }
        } else {
            request.setAttribute("errores", errores);
            vista = request.getRequestDispatcher("index.jsp");
            vista.include(request, response);
        }
    }

    protected void Registro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        String correo = request.getParameter("txtcorreo");
        String usuario = request.getParameter("txtusuario");
        String clave = request.getParameter("txtclave");

        String mensaje = "";
        ArrayList errores = new ArrayList();
        if (correo == null) {
            errores.add("Ingrese correo\n");
        }
        if (usuario == null) {
            errores.add("Ingrese usuario\n");
        }
        if (clave == null) {
            errores.add("Ingrese una clave\n");
        }
        if (errores.isEmpty()) {
            usuarios objUsuario = new usuarios();
            String sha256clave = "";
            sha256clave = objUsuario.sha256(clave);
            objUsuario.Insertar(usuario, sha256clave, correo);
            request.setAttribute("mensaje", mensaje);
        } else {
            request.setAttribute("mensaje", errores);
        }
        System.out.println(mensaje.length());
        response.sendRedirect("registro.jsp");
    }

    protected void cerrarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        session = request.getSession();
        session.removeAttribute("logged");
        session.removeAttribute("user");
        session.invalidate();
        response.sendRedirect("index.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

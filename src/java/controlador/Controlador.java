/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Consejo;
import modelo.ConsejoDAO;

@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {

    ConsejoDAO dao = new ConsejoDAO();
    Consejo c = new Consejo();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion.equals("Listar")) {
            List<Consejo> lista = dao.listar();
            request.setAttribute("datos", lista);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else if (accion.equals("Agregar")) {
            String titulo = request.getParameter("txtTitulo");
            String cat = request.getParameter("txtCategoria");
            String desc = request.getParameter("txtDescripcion");
            String prio = request.getParameter("txtPrioridad");
            
            c.setTitulo(titulo);
            c.setCategoria(cat);
            c.setDescripcion(desc);
            c.setPrioridad(prio);
            
            dao.agregar(c);
            // Después de agregar, volvemos a listar para ver el nuevo registro
            request.getRequestDispatcher("Controlador?accion=Listar").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
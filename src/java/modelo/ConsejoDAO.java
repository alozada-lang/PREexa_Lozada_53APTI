/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ConsejoDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    // Método para CONSULTAR (Listar)
    public List listar() {
        ArrayList<Consejo> lista = new ArrayList<>();
        String sql = "SELECT * FROM consejos";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Consejo c = new Consejo();
                c.setId(rs.getInt("id"));
                c.setTitulo(rs.getString("titulo_consejo"));
                c.setCategoria(rs.getString("categoria"));
                c.setDescripcion(rs.getString("descripcion"));
                c.setPrioridad(rs.getString("nivel_prioridad"));
                lista.add(c);
            }
        } catch (Exception e) {
            System.err.println("Error al listar: " + e);
        }
        return lista;
    }

    // Método para ALTAS (Agregar)
    public int agregar(Consejo c) {
        String sql = "INSERT INTO consejos(titulo_consejo, categoria, descripcion, nivel_prioridad) VALUES(?,?,?,?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getTitulo());
            ps.setString(2, c.getCategoria());
            ps.setString(3, c.getDescripcion());
            ps.setString(4, c.getPrioridad());
            ps.executeUpdate();
        } catch (Exception e) {
            System.err.println("Error al agregar: " + e);
        }
        return 1;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    Connection con;
    // Datos de tu base de datos en XAMPP
    String url = "jdbc:mysql://localhost:3306/bd_safenet_asi";
    String user = "root";
    String pass = ""; // Por defecto XAMPP no tiene contraseña

    public Connection getConnection() {
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.err.println("Error de conexión: " + e);
        }
        return con;
    }
}
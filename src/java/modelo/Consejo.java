/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Consejo {
    private int id;
    private String titulo;
    private String categoria;
    private String descripcion;
    private String prioridad;

    // Constructor vacío
    public Consejo() {
    }

    // Constructor con parámetros
    public Consejo(int id, String titulo, String categoria, String descripcion, String prioridad) {
        this.id = id;
        this.titulo = titulo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
    }

    // Getters y Setters (los necesitamos para que el Servlet lea los datos)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getPrioridad() { return prioridad; }
    public void setPrioridad(String prioridad) { this.prioridad = prioridad; }
}
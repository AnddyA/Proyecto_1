/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import controlador.lista.ListaControl;
import controlador.lista.NodoLista;

/**
 *
 * @author andy
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaControl <Venta> venta = new ListaControl<>();
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " " + id;
    }
    
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


import controlador.lista.ListaControl;

/**
 *
 * @author andy
 */
public class Sucursal {
    private Integer id;
    private String nombre;
    private ListaControl<Venta> ventas;
    //private HistorialVentas historial;

    public Sucursal() {
        ventas = new ListaControl<>();
    }

    public Sucursal(String nombreS) {
        this.nombre = nombreS;
        ventas = new ListaControl<>();
        //historial = new HistorialVentas();
    }
    
    public void agregarVenta(Venta venta){
        ventas.insertar(venta);
        //historial.agregarVenta(venta);
    }

    public ListaControl<Venta> getVentas() {
        return ventas;
    }
    
    public void setVentas(ListaControl<Venta> ventas) {
        this.ventas = ventas;
    }
    
/*
    public HistorialVentas getHistorial() {
        return historial;
    }

    public void setHistorial(HistorialVentas historial) {
        this.historial = historial;
    }
*/    

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

    public Object getMes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public ListaControl<Venta> getHistorialVentas() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}


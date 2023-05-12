/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.lista.ListaControl;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author andy
 */
public class SucursalControl {
    private ListaControl sig;
    private Sucursal sucursal;
    private Venta venta;

    
    public SucursalControl(){
        sig = null; 
    }    
    
    public Sucursal getSucursal() {
        if(sucursal == null){
            sucursal = new Sucursal();
        }
        
        return sucursal;
        
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }
    
    
    
    
    
}

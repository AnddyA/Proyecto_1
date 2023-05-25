/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.SucursalControl;
import controlador.exception.EspacioException;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;

/**
 *
 * @author andy
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws VacioException, PosicionException {

        SucursalControl control = new SucursalControl();

        try {
            control.getSucursal().setId(1);
            control.getSucursal().setNombre("Any");
            control.getSucursal().getVentas();
            control.registrar();
            control.setSucursal(null);

            control.getSucursal().setId(2);
            control.getSucursal().setNombre("Andy");
            control.registrar();
            control.setSucursal(null);

            control.getSucursal().setId(3);
            control.getSucursal().setNombre("ns");
            control.registrar();
            control.setSucursal(null);

            System.out.println("Sucursales registradas:");
            control.getSucursales().imprimir();
            
        } catch (EspacioException e) {
            System.out.println("Error al registrar las sucursales: " + e.getMessage());
        }
    }

}



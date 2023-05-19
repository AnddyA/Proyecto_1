/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.SucursalControl;
import controlador.exception.EspacioException;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import controlador.util.Utilidades;
import modelo.Sucursal;

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
            control.getSucursal().setNombre("Sucursal 1");
            control.registrar();
            control.setSucursal(null);

            control.getSucursal().setId(2);
            control.getSucursal().setNombre("Sucursal 2");
            control.registrar();
            control.setSucursal(null);

            control.getSucursal().setId(3);
            control.getSucursal().setNombre("Sucursal 3");
            control.registrar();
            control.setSucursal(null);

            System.out.println("Sucursales registradas:");
            control.getSucursales().imprimir();
        } catch (EspacioException e) {
            System.out.println("Error al registrar las sucursales: " + e.getMessage());
        }
    }

}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.util;

import controlador.SucursalControl;
import controlador.lista.ListaControl;
import controlador.lista.NodoLista;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author andy
 */
public class Utilidades {
    public static <E> void imprimir(ListaControl<E> obj) {
        System.out.println("Lista de " + obj.getClass().getSimpleName());

        NodoLista<E> actual = obj.getCabecera();
        while (actual != null) {
            if (actual.getInfo() != null) {
                System.out.println(actual.getInfo().toString());
            }
            actual = actual.getSig();
        }
    }

    public static Double sumarVentas(Sucursal s) {
        if (s.getVentas() != null) {
            Double ventas = 0.0;
            NodoLista<Venta> actual = s.getVentas().getCabecera();
            while (actual != null) {
                ventas += actual.getInfo().getValor();
                actual = actual.getSig();
            }
            return ventas;
        }
        return 0.0;
    }

    public static Double mediaVentas(Sucursal s) {
        Double suma = sumarVentas(s);
        Integer cantidadVentas = s.getVentas().size();

        if (cantidadVentas == 0) {
            return 0.0;
        }

        return suma / cantidadVentas;
    }
}



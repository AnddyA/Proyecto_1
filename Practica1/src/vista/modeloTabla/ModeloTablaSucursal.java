/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import controlador.util.Utilidades;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;

/**
 *
 * @author andy
 */
public class ModeloTablaSucursal extends AbstractTableModel {
    private ListaControl<Sucursal> datos = new ListaControl<>();

    public ListaControl<Sucursal> getDatos() {
        return datos;
    }

    public void setDatos(ListaControl<Sucursal> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Sucursal s = null;
        try {
            s = datos.get(row);
        } catch (VacioException ex) {
            Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) { 
            Logger.getLogger(ModeloTablaSucursal.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (column) {
            case 0:
                return (s != null) ? s.getNombre() : "NO DEFINIDO";
            case 1:
                return (s != null) ? Utilidades.sumarVentas(s) : 0.0;
            case 2:
                return (s != null) ? Utilidades.mediaVentas(s) : 0.0;

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Sucursal";
            case 1:
                return "Ventas Anual";
            case 2:
                return "Venta Promedio";

            default:
                return null;
        }
    }
}

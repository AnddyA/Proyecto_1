/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author andy
 */
public class ModeloTablaVentas extends AbstractTableModel {
    private ListaControl<Venta> datos = new ListaControl<>();
    
    
    public ListaControl<Venta> getDatos() {
        return datos;
    }

    public void setDatos(ListaControl<Venta> datos) {
        this.datos = datos;
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public int getRowCount() {
        return datos.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Venta v = null;
        try {
            v = datos.get(row);
        } catch (VacioException ex) {
            Logger.getLogger(ModeloTablaVentas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaVentas.class.getName()).log(Level.SEVERE, null, ex);
        }
        switch (column) {
            case 0:
                return (v != null) ? v.getMes().toString() : "NO DEFINIDO";
            case 1:
                return (v != null) ? v.getValor() : 0.0;

            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Mes";
            case 1:
                return "Valor";

            default:
                return null;
        }
    }
}

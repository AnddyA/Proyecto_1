/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import controlador.pila.PilaI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author andy
 */
public class ModeloTablaHistorial extends AbstractTableModel {
    private PilaI<String> historial;

    public PilaI<String> getHistorial() {
        return historial;
    }

    public void setHistorial(PilaI<String> historial) {
        this.historial = historial;
    }

    public int getColumnCount() {
        return 1;
    }

    public int getRowCount() {
        return historial.size();
    }

    @Override
    public Object getValueAt(int i, int i1) {
        
        try {
            String h = historial.get(i);
            
            return h;
        } catch (VacioException ex) {
            Logger.getLogger(ModeloTablaPetisiones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaPetisiones.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public String getColumnName(int column){
        return "Historial";
        
    }

}

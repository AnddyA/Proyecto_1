/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista.modeloTabla;

import controlador.cola.ColaI;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import modelo.Peticiones;

/**
 *
 * @author andy
 */
public class ModeloTablaPetisiones extends AbstractTableModel{
    private ColaI<Peticiones> peticion;

    public ColaI<Peticiones> getPeticion() {
        return peticion;
    }

    public void setPeticion(ColaI<Peticiones> peticion) {
        this.peticion = peticion;
    }
    
    public int getColumnCount() {
        return 1;
    }

    public int getRowCount() {
        return peticion.size();
    }
    

    @Override
    public Object getValueAt(int i, int i1) {
      
        try {
            Peticiones p = peticion.get(i);
            
            return p.getMeng();
        } catch (VacioException ex) {
            Logger.getLogger(ModeloTablaPetisiones.class.getName()).log(Level.SEVERE, null, ex);
        } catch (PosicionException ex) {
            Logger.getLogger(ModeloTablaPetisiones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    public String getColumnName(int column){
        return "Peticiones";
    }
}

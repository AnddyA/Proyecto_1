/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO.historiales;

import controlador.pila.PilaI;
import java.io.IOException;

/**
 *
 * @author andy
 */
public interface InterfazHistorial<T> {
    /**
     * 
     * @param obj
     * @throws IOException 
     */
    public void guardarHistorial(T obj) throws IOException;
    /**
     * 
     * @return
     * @throws IOException 
     */
    public PilaI<T> listar() throws IOException;
    
}

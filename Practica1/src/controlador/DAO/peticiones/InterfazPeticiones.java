/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package controlador.DAO.peticiones;

import controlador.cola.ColaI;
import java.io.IOException;

/**
 *
 * @author andy
 */
public interface InterfazPeticiones<T> {
    /**
     * 
     * @param obj
     * @throws IOException 
     */
    public void guardarPeticion(T obj) throws IOException;
    /**
     * 
     * @param obj
     * @throws IOException 
     */
     public void modificarPeticion(T obj) throws IOException;
     
     public ColaI<T> listar() throws IOException;
    
}

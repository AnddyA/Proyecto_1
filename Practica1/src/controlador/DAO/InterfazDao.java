/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import java.io.IOException;

/**
 *
 * @author andy
 */
public interface InterfazDao<T> {
    /**
     * Metodo que permite realizar el guardado
     * @param obj Objeto del modelo
     */
    public void guardar(T obj) throws IOException;
    
    /**
     * Permite modificar los datos en u repositorio de datos
     * @param obj Objeto a modificar
     * @param pos posicion del arreglo
     */
    public void modificar(T obj, Integer pos) throws IOException, PosicionException;
    public ListaControl<T> listar();
    public T obtener(Integer id);
}

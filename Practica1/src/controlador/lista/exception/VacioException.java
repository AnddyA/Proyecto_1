/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista.exception;

/**
 *
 * @author andy
 */
public class VacioException extends Exception{

    public VacioException(){
        super("Lista vacia");
    }

    public VacioException(String msg) {
        super(msg);
    }
}
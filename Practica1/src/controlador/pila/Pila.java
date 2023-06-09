/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.pila;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;

/**
 *
 * @author andy
 */
public class Pila<E> extends ListaControl<E>{
    
    private int top;

    public Pila(int top) {
        this.top = top;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    
    public boolean isFull(){
        return (size() >= top);
    }
    
    public void push(E info) throws VacioException{
        if(isFull()){
            throw new VacioException();
        }
        insertarInicio(info);
    }
    
    public E pop() throws VacioException, PosicionException{
        E data = null;
        if(isEmpty()){
            throw new VacioException();
        }else{
            throw new PosicionException();
        }
    }

    public int getCima() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

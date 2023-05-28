/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.pila;

import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;

/**
 *
 * @author andy
 */
public class PilaI<E> {
    
    private Pila<E> pilai;

    public PilaI(int top){
        pilai = new Pila<>(top);
    } 
    
    public void push(E obj) throws VacioException{
        pilai.push(obj);
    }
    
    public E pop() throws VacioException, PosicionException{
        return pilai.pop();
    }
    
    public int getPila(){
        return pilai.getTop();
    }
    
    public int size(){
        return pilai.size();
    }
    
    public E get(int pos) throws VacioException, PosicionException{
        return pilai.get(pos);
    }
    
    
}

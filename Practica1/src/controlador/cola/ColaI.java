/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.cola;

import controlador.exception.EspacioException;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;

/**
 *
 * @author andy
 */
public class ColaI<E> {

    private Cola<E> cola;

    public ColaI(int top) {
        cola = new Cola(top);
    }

    public void queue(E obj) throws VacioException{
        cola.queue(obj);
    }

    public E dequeue() throws VacioException, PosicionException {
        return cola.dequeue();
    }

    public int getTop() {
        return cola.getTop();
    }

    public E get(int pos) throws VacioException, PosicionException {
        return cola.get(pos);
    }
    
    public int size() {
        return cola.size();
    }
}

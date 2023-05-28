/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.lista;

import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;


/**
 *
 * @author andy
 */
public class ListaControl<E> {
    private NodoLista<E> cabecera;
    private Integer size = 0;

    public NodoLista<E> getCabecera() {
        return cabecera;
    }

    public void setCabecera(NodoLista<E> cabecera) {
        this.cabecera = cabecera;
    }

    public boolean isEmpty() {
        return cabecera == null;
    }

    public boolean insertar(E info) {
        NodoLista<E> nuevo = new NodoLista<>(info, null);
        if (isEmpty()) {
            this.cabecera = nuevo;
            this.size++;
        } else {
            NodoLista<E> aux = cabecera;
            while (aux.getSig() != null) {
                aux = aux.getSig();
            }
            aux.setSig(nuevo);
            this.size++;
        }
        return true;
    }

    public void imprimir() throws VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            NodoLista<E> aux = cabecera;
            System.out.println("----------LISTA----------");

            for (int i = 0; i < size(); i++) {
                System.out.println(aux.getInfo() + " ");
                aux = aux.getSig();
            }
            System.out.println("");
            System.out.println("---------LISTA FIN--------");
        }
    }

    public void deleteAll() {
        this.cabecera = null;
        this.size = 0;
    }

    public void insertarInicio(E info) {
        if (isEmpty()) {
            insertar(info);
        } else {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            nuevo.setSig(cabecera);
            cabecera = nuevo;
            size++;
        }
    }

    public void insertarPosicion(E info, Integer pos) throws PosicionException {
        if (isEmpty()) {
            insertar(info);
        } else if (pos >= 0 && pos < size() && pos == 0) {
            insertarInicio(info);
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> nuevo = new NodoLista<>(info, null);
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < (pos - 1); i++) {
                aux = aux.getSig();
            }
            NodoLista<E> sig = aux.getSig();
            aux.setSig(nuevo);
            nuevo.setSig(sig);
            size++;
        } else {
            throw new PosicionException();
        }
    }

    public E get(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < pos; i++) {
                        aux = aux.getSig();
                    }
                    dato = aux.getInfo();
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }

    public E delete(Integer pos) throws VacioException, PosicionException {
        if (isEmpty()) {
            throw new VacioException();
        } else {
            E dato = null;
            if (pos >= 0 && pos < size()) {
                if (pos == 0) {
                    dato = cabecera.getInfo();
                    cabecera = cabecera.getSig();
                    size--;
                } else {
                    NodoLista<E> aux = cabecera;
                    for (int i = 0; i < (pos - 1); i++) {
                        aux = aux.getSig();
                    }

                    NodoLista<E> aux1 = aux.getSig();
                    dato = aux1.getInfo();
                    
                    NodoLista<E> proximo = aux1.getSig();
                    aux.setSig(proximo);
                    size--;
                }
            } else {
                throw new PosicionException();
            }
            return dato;
        }
    }
    
    public Integer getSize() {
        return size;
    }
    
    public void setSize(Integer size) {
        this.size = size;
    }
    
    public Integer size() {
        return size;
    }

    public void set(Integer pos, E info) throws PosicionException {
        if (isEmpty()) {
            throw new PosicionException();
        } else if (pos >= 0 && pos < size()) {
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSig();
            }
            aux.setInfo(info);
        } else {
            throw new PosicionException();
        }
    }
    
    public void modificar(Integer pos, E info) throws PosicionException, VacioException {
        if (isEmpty()) {
            throw new VacioException();
        } else
            if (pos >= 0 && pos < size()) {
                System.out.println("aqui");
            NodoLista<E> aux = cabecera;
            for (int i = 0; i < pos; i++) {
                aux = aux.getSig();
            }
            aux.setInfo(info);
        } else {
                System.out.println("aqui no");
            throw new PosicionException();
        }
    }

    public Integer getCapacidad() {
        return size;
    }
    
//    public void modificar(Integer pos, E info) throws VacioException, PosicionException{
//        if(isEmpty()){
//            throw new VacioException();
//        }else{
//            if(pos >= 0 && pos < size()){
//                if(pos == 0){
//                    this.cabecera.setInfo(info);
//                }else{
//                    NodoLista<E> aux = cabecera;
//                    for(int i = 0; i < pos; i++){
//                        aux = aux.getSig();
//                    }
//                    aux.setInfo(info);
//                }
//            }else{
//                throw new PosicionException();
//            }
//        }
//    }
    
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO;

import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Sucursal;

/**
 *
 * @author andy
 */
public class AdaptadorDao implements InterfazDao<Sucursal>{
    
    private Conexion conexion;
    private Class clazz;
    private String url;
    
    public AdaptadorDao(Class clazz){
        this.conexion = new Conexion();
        this.clazz = clazz;
        this.url = Conexion.URL+clazz.getSimpleName().toLowerCase()+".json";
    }

    @Override
    public void guardar(Sucursal obj) throws IOException {
        ListaControl<Sucursal> lista = listar();
        lista.insertar(obj);
        conexion.getXStream().alias(lista.getClass().getName(), ListaControl.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public void modificar(Sucursal obj, Integer pos) throws IOException, PosicionException {
        ListaControl<Sucursal> lista = listar();
        
        try {
            lista.modificar(pos, obj);
        } catch (VacioException ex) {
            Logger.getLogger(AdaptadorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        conexion.getXStream().alias(lista.getClass().getName(), ListaControl.class);
        conexion.getXStream().toXML(lista, new FileWriter(url));
    }

    @Override
    public ListaControl<Sucursal> listar() {
        ListaControl<Sucursal> lista = new ListaControl<>();
        try {
            lista = (ListaControl<Sucursal>)conexion.getXStream().fromXML(new File(url));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lista;
    }

    @Override
    public Sucursal obtener(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

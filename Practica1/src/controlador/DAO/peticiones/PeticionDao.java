/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO.peticiones;

import controlador.DAO.Conexion;
import controlador.cola.ColaI;
import controlador.lista.exception.VacioException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Peticiones;

/**
 *
 * @author andy
 */
public class PeticionDao implements InterfazPeticiones<Peticiones> {

    private Conexion conexion;
    private Class clazz = Peticiones.class;
    private String url;

    public PeticionDao() {
        this.conexion = new Conexion();
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    public void guardarPeticion(Peticiones obj) throws IOException {
        ColaI<Peticiones> peticiones = listar();

        try {
            peticiones.queue(obj);
        } catch (VacioException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        conexion.getXStream().alias(clazz.getSimpleName().toLowerCase(), clazz);
        conexion.getXStream().toXML(peticiones, new FileWriter(url));

    }

    @Override
    public void modificarPeticion(Peticiones obj) throws IOException {

    }

    @Override
    public ColaI<Peticiones> listar() {
        ColaI<Peticiones> peticiones = new ColaI<>(20);

        conexion.getXStream().alias(clazz.getSimpleName().toLowerCase(), clazz);
        try {
            peticiones = (ColaI<Peticiones>) conexion.getXStream().fromXML(new FileReader(url));
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return peticiones;
    }

//    public static void main(String[] args){
//        SucursalDao sd = new SucursalDao();
//        
//        sd.getSucursal().setNombre("Alice");
//        sd.getSucursal().setId(sd.generarId());
//        
//        Venta v = new Venta();
//        v.setMes(EnuMes.MAYO);
//        v.setValor(10080.0);
//        sd.getSucursal().getVentas().insertar(v);
//        
//        try {
//            sd.guardar(sd.getSucursal());
//            System.out.println(sd.listar());
//            sd.listar().imprimir();
//        } catch (Exception e) {
//            System.out.println(e);
//            e.printStackTrace();
//        }
//        
//    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador.DAO.historiales;

import controlador.DAO.Conexion;
import controlador.lista.exception.VacioException;
import controlador.pila.PilaI;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author andy
 */
public class HistorialDao implements InterfazHistorial<String> {

    private Conexion conexion;
    private Class clazz = String.class;
    private String url;

    public HistorialDao() {
        this.conexion = new Conexion();
        this.url = Conexion.URL + clazz.getSimpleName().toLowerCase() + ".json";
    }

    public void guardarHistorial(String obj) throws IOException {
        PilaI<String> historial = listar();

        try {
            historial.push(obj);
        } catch (VacioException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        conexion.getXStream().alias(clazz.getSimpleName().toLowerCase(), clazz);
        conexion.getXStream().toXML(historial, new FileWriter(url));
    }

    public PilaI<String> listar() {
        PilaI<String> historial = new PilaI<>(20);

        try {
            conexion.getXStream().alias(clazz.getSimpleName().toLowerCase(), clazz);
            historial = (PilaI<String>) conexion.getXStream().fromXML(new FileReader(url));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(HistorialDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        return historial;
    }

}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import controlador.exception.EspacioException;
import controlador.lista.ListaControl;
import controlador.lista.exception.PosicionException;
import controlador.lista.exception.VacioException;
import modelo.EnuMes;
import modelo.Sucursal;
import modelo.Venta;

/**
 *
 * @author andy
 */
public class SucursalControl {

    public ListaControl<Sucursal> sucursales;
    private Sucursal sucursal;
    private Venta venta;

    public SucursalControl() {
        sucursales = new ListaControl<>();
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public Sucursal getSucursal() {
        if (sucursal == null) {
            sucursal = new Sucursal();
        }

        return sucursal;
    }

    public void setSucursal(Sucursal sucursal) {
        this.sucursal = sucursal;
    }

    public ListaControl<Sucursal> getSucursales() {
        return sucursales;
    }

    public void setSucursales(ListaControl<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    public boolean registrar() throws EspacioException, VacioException, PosicionException {


        sucursal.setVentas(new ListaControl<>());
        for (EnuMes mes : EnuMes.values()) {
            Venta venta = new Venta();
            venta.setId(mes.ordinal() + 1);
            venta.setMes(mes);
            venta.setValor(0.0);
            sucursal.getVentas().insertar(venta);
        }


        sucursales.insertar(sucursal);
        return true;
    }

    public boolean guardarVentas(Integer posVenta, Double valor) throws EspacioException, VacioException, PosicionException {
    if (this.sucursal != null) {
        ListaControl<Venta> ventas = this.sucursal.getVentas();
        if (posVenta >= 0 && posVenta < ventas.size()) {
            Venta venta = ventas.get(posVenta);
            venta.setValor(valor);
        } else {
            throw new EspacioException();
        }
    } else {
        throw new NullPointerException("Debe seleccionar una sucursal");
    }

    return true;
}


}

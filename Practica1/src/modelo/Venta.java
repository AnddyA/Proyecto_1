/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author andy
 */
public class Venta {
    private Integer id;
    private Double valor;
    private EnuMes mes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public EnuMes getMes() {
        return mes;
    }
    
    
    public void setMes(EnuMes mes) {
        this.mes = mes;
    }

    @Override
    public String toString() {
        return mes.toString() + " " + valor;
    }
}


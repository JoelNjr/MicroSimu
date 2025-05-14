/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
/**
 *
 * @author User
 */


public class Transaccion {
    
    private String tipo; // Compra o Venta
    private Producto producto;
    private int cantidad;
    private Date fecha;
    private double total;

    public Transaccion(String tipo, Producto producto, int cantidad) 
    {
        this.tipo = tipo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = new Date();
        this.total = producto.getPrecio() * cantidad;
    }
    
    //Encapsulamiento: Métodos públicos para acceder/controlar atributos

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public String toString() {
        return tipo + ": " + producto.getNombre() + " x" + cantidad + " | $" + total + " | " + fecha;
    }
}


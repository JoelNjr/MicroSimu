/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.util.Date;
import java.io.Serializable;
/**
 *
 * @author User
 */


public class Transaccion implements Serializable {
    
    private String tipo; // Compra o Venta
    private String IDtransaccion;
    private Empleado empleado;
    private Producto producto;
    private int cantidad;
    private Date fecha;
    private double total;

    public Transaccion(String tipo, String IDtransaccion, Empleado empleado, Producto producto, int cantidad, Date fecha, double total) {
        this.tipo = tipo;
        this.IDtransaccion = IDtransaccion;
        this.empleado = empleado;
        this.producto = producto;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.total = producto.getPrecioventa()* cantidad;
    }
    
    //Encapsulamiento: Métodos públicos para acceder/controlar atributos

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIDtransaccion() {
        return IDtransaccion;
    }

    public void setIDtransaccion(String IDtransaccion) {
        this.IDtransaccion = IDtransaccion;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
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
    
    



//Abstracción: toString() muestra la información útil del objeto
    @Override
    public String toString() {
        return "Transaccion{" +
                "ID='" + IDtransaccion + '\'' +
                ", Empleado='" + empleado + '\'' +
                ", Producto='" + producto + '\'' +
                ", Cantidad='" + cantidad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", Total=" + total +
                '}';
    }
}


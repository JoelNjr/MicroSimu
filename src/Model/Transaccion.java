/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
/**
 *
 * @author User
 */


public class Transaccion implements Serializable {
    
    private String id;
    private String tipo;
    private String producto;
    private int cantidad;
    private String empleado;
    private String fecha;
    private double total;

    public Transaccion(String tipo, String producto, int cantidad, String empleado, double total) {
        this.id = generarID(); // ID único automático
        this.fecha = obtenerFechaActual(); // Fecha actual automática
        this.tipo = tipo;
        this.producto = producto;
        this.cantidad = cantidad;
        this.empleado = empleado;
        this.total = total;
    }

    private String generarID() {
        return UUID.randomUUID().toString().substring(0, 8); // ID corto único
    }

    private String obtenerFechaActual() {
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formato.format(new Date());
    }

    // Getters y setters
    public String getId() { return id; }
    public String getTipo() { return tipo; }
    public String getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public String getEmpleado() { return empleado; }
    public String getFecha() { return fecha; }
    public double getTotal() { return total; }
    
    



//Abstracción: toString() muestra la información útil del objeto
    @Override
    public String toString() {
        return "Transaccion{" +
                "ID='" + id + '\'' +
                ", Empleado='" + empleado + '\'' +
                ", Producto='" + producto + '\'' +
                ", Cantidad='" + cantidad + '\'' +
                ", fecha='" + fecha + '\'' +
                ", Total=" + total +
                '}';
    }
}


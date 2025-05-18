/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author joel.vasquez
 */
public class Producto {
    
    private String codigo;
    private String nombre;
    private int stock;
    private double preciocompra;
    private double precioventa;

    public Producto(String codigo, String nombre, int stock, double preciocompra, double precioventa) 
    {
        this.codigo = codigo;
        this.nombre = nombre;
        this.stock = stock;
        this.preciocompra = preciocompra;
        this.precioventa = precioventa;
    }
    
    //Encapsulamiento: Métodos públicos para acceder/controlar atributos

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPreciocompra() {
        return preciocompra;
    }

    public void setPreciocompra(double preciocompra) {
        this.preciocompra = preciocompra;
    }

    public double getPrecioventa() {
        return precioventa;
    }

    public void setPrecioventa(double precioventa) {
        this.precioventa = precioventa;
    }

 
    
    //Abstracción: Métodos que representan acciones del mundo real

    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }

    public boolean reducirStock(int cantidad) {
        if (cantidad <= stock) {
            stock -= cantidad;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", Precio Compra: " + preciocompra +
               ", Precio Venta: " + precioventa + ", Stock: " + stock;
    }
}

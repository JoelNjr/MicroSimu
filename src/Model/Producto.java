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
    
    private String nombre;
    private int stock;
    private double precio;

    public Producto(String nombre, int stock, double precio) 
    {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }
    
    //Encapsulamiento: Métodos públicos para acceder/controlar atributos

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
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
        return nombre + " | Stock: " + stock + " | Precio: $" + precio;
    }
}

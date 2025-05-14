/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author User
 */
import java.util.*;

public class Empresa {
    private List<Empleado> empleados;
    private List<Producto> inventario;
    private Stack<Transaccion> historial;

    public Empresa() {
        empleados = new ArrayList<>(); //Se están usando momentaneamente librerias de java para poder ejercutar las pruebas mas rapido
        inventario = new ArrayList<>();//Empleados e inventario seran listas enlazadas dobles, e historial sera una pila 
        historial = new Stack<>();
    }

    // Empleados
    public void contratarEmpleado(Empleado emp) {
        empleados.add(emp);
    }

    public void despedirEmpleado(String nombre) {
        empleados.removeIf(e -> e.getNombre().equalsIgnoreCase(nombre));
    }

    public List<Empleado> getEmpleados() {
        return empleados;
    }

    // Productos
    public void agregarProducto(Producto p) {
        inventario.add(p);
    }

    public List<Producto> getInventario() {
        return inventario;
    }

    // Transacciones
    public boolean registrarVenta(String nombreProducto, int cantidad) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto) && p.reducirStock(cantidad)) {
                Transaccion t = new Transaccion("Venta", p, cantidad);
                historial.push(t);
                return true;
            }
        }
        return false;
    }

    public boolean registrarCompra(String nombreProducto, int cantidad) {
        for (Producto p : inventario) {
            if (p.getNombre().equalsIgnoreCase(nombreProducto)) {
                p.agregarStock(cantidad);
                Transaccion t = new Transaccion("Compra", p, cantidad);
                historial.push(t);
                return true;
            }
        }
        return false;
    }

    public Transaccion deshacerUltimaTransaccion() {
        if (!historial.isEmpty()) {
            return historial.pop();
        }
        return null;
    }

    public Stack<Transaccion> getHistorial() {
        return historial;
    }

    public double calcularGanancias() {
        double ventas = 0, compras = 0;
        for (Transaccion t : historial) {
            if (t.getTipo().equalsIgnoreCase("Venta")) {
                ventas += t.getTotal();
            } else {
                compras += t.getTotal();
            }
        }
        return ventas - compras;
    }
}

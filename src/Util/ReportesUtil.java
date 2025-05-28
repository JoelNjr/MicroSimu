/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.io.Serializable;
import java.io.*;
import Model.*;
import Controller.ListaDobleProducto;
import Controller.ListaDobleEmpleado;
import Controller.ColaTransaccion;
import Controller.ColaTransaccion;
import Controller.ListaDobleProducto;
import Controller.PersistenciaDatos;
import View.DatosEmpresa;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author User
 */
public class ReportesUtil {
    

    public static String generarInventario(ListaDobleProducto productos, ColaTransaccion transacciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("📦 INVENTARIO ACTUAL:\n");

        NodoProducto actual = productos.getCabeza();
        while (actual != null) {
            Producto prod = actual.getProducto();
            sb.append("ID: ").append(prod.getCodigo())
              .append(" | Nombre: ").append(prod.getNombre())
              .append(" | Stock: ").append(prod.getStock()).append("\n");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }

    public static String empleadoEstrella(ColaTransaccion transacciones) {
        HashMap<String, Integer> contador = new HashMap<>();
        NodoTransaccion actual = transacciones.getPrimero();

        while (actual != null) {
            Transaccion t = actual.getTransaccion();
            String empleado = t.getEmpleado();
            contador.put(empleado, contador.getOrDefault(empleado, 0) + 1);
            actual = actual.getSiguiente();
        }

        String estrella = null;
        int max = 0;
        for (String nombre : contador.keySet()) {
            if (contador.get(nombre) > max) {
                max = contador.get(nombre);
                estrella = nombre;
            }
        }

        return "🏅 Empleado Estrella: " + (estrella != null ? estrella + " con " + max + " transacciones" : "No hay transacciones registradas.");
    }

    public static String productoPopular(ColaTransaccion transacciones) {
        HashMap<String, Integer> contador = new HashMap<>();
        NodoTransaccion actual = transacciones.getPrimero();

        while (actual != null) {
            Transaccion t = actual.getTransaccion();
            String idProducto = t.getProducto();
            contador.put(idProducto, contador.getOrDefault(idProducto, 0) + t.getCantidad());
            actual = actual.getSiguiente();
        }

        String popular = null;
        int max = 0;
        for (String id : contador.keySet()) {
            if (contador.get(id) > max) {
                max = contador.get(id);
                popular = id;
            }
        }

        return "🔥 Producto más vendido: " + (popular != null ? "ID " + popular + " con " + max + " unidades vendidas" : "No hay transacciones.");
    }

    public static String totalVentasCompras(ColaTransaccion transacciones) {
        int totalVentas = 0, totalCompras = 0;
        NodoTransaccion actual = transacciones.getPrimero();

        while (actual != null) {
            Transaccion t = actual.getTransaccion();
            if (t.getTipo().equalsIgnoreCase("venta")) {
                totalVentas += t.getTotal();
            } else if (t.getTipo().equalsIgnoreCase("compra")) {
                totalCompras += t.getTotal();
            }
            actual = actual.getSiguiente();
        }

        return "💰 Totales:\nVentas: $" + totalVentas + "\nCompras: $" + totalCompras;
    }

    public static String advertenciasInventario(ListaDobleProducto productos, ColaTransaccion transacciones) {
        StringBuilder sb = new StringBuilder();
        sb.append("⚠️ Advertencias de Inventario:\n");

        NodoProducto actual = productos.getCabeza();
        while (actual != null) {
            Producto prod = actual.getProducto();
            if (prod.getStock() <= 5) {
                sb.append("Producto ").append(prod.getNombre()).append(" (Codigo: ")
                  .append(prod.getCodigo()).append(") está bajo de stock: ")
                  .append(prod.getStock()).append(" unidades\n");
            }
            actual = actual.getSiguiente();
        }

        return sb.toString();
    }
}

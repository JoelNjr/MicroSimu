/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Model.Empresa;
import Model.Empleado;
import Model.Producto;
import Model.Transaccion;
import Model.NodoEmpleado;
import Model.NodoProducto;
import Model.NodoTransaccion;
import Controller.ListaDobleProducto;
import Controller.ListaDobleEmpleado;
import Controller.ColaTransaccion;
import Controller.PersistenciaDatos;
import static View.DatosEmpresa.listaEmpleados;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Util.ReportesUtil;
/**
 *
 * @author User
 */
public class Transacciones extends javax.swing.JFrame {
    
    private Transacciones gestionartransacciones;
    private Empresa empresa;

    /**
     * Creates new form Transacciones
     */
    public Transacciones(Empresa empresa) {
        initComponents();
        actualizarTabla();
        this.setLocationRelativeTo(null);
        this.empresa = empresa;
    }
    
    private void actualizarTabla() {
    DefaultTableModel modelo = (DefaultTableModel) tablaTransacciones.getModel();
    modelo.setRowCount(0); // Limpiar

    NodoTransaccion aux = DatosEmpresa.colaTransacciones.getPrimero();
    while (aux != null) {
        Transaccion t = aux.getTransaccion();
        modelo.addRow(new Object[] {
            t.getId(),
            t.getTipo(),
            t.getProducto(),
            t.getCantidad(),
            t.getFecha(),
            t.getEmpleado(),
            t.getTotal()
        });
        aux = aux.getSiguiente();
    }
}
    
    public static String generarReportes() {
        StringBuilder reporte = new StringBuilder();

        if (DatosEmpresa.colaTransacciones == null || DatosEmpresa.colaTransacciones.estaVacia()) {
            return "No hay transacciones registradas.";
        }

        // HashMaps para conteo
        HashMap<String, Integer> compras = new HashMap<>();
        HashMap<String, Integer> ventas = new HashMap<>();
        HashMap<String, Integer> porProducto = new HashMap<>();
        HashMap<String, Integer> porEmpleado = new HashMap<>();

        // Recorrer las transacciones
        NodoTransaccion actual = DatosEmpresa.colaTransacciones.getPrimero();
        while (actual != null) 
        {
            
            Transaccion t = actual.getTransaccion();

            // Clasificar por tipo
            if (t.getTipo().equalsIgnoreCase("Compra")) {
                compras.put(t.getProducto(), compras.getOrDefault(t.getProducto(), 0) + t.getCantidad());
            } else if (t.getTipo().equalsIgnoreCase("Venta")) {
                ventas.put(t.getProducto(), ventas.getOrDefault(t.getProducto(), 0) + t.getCantidad());
            }

            // Contar todas las transacciones por producto (sin importar tipo)
            porProducto.put(t.getProducto(), porProducto.getOrDefault(t.getProducto(), 0) + 1);

            // Contar por empleado
            porEmpleado.put(t.getEmpleado(), porEmpleado.getOrDefault(t.getEmpleado(), 0) + 1);

            actual = actual.getSiguiente();
            
        }
        

        // 📌 Producto con más ventas
        String prodMasVendido = maximo(ventas);
        reporte.append("🛒 Producto más vendido: ").append(prodMasVendido).append(" (").append(ventas.get(prodMasVendido)).append(" unidades)\n");

        // 📦 Producto con más compras
        String prodMasComprado = maximo(compras);
        reporte.append("📦 Producto más comprado: ").append(prodMasComprado).append(" (").append(compras.get(prodMasComprado)).append(" unidades)\n");

        // 🔁 Productos con más de 5 transacciones
        reporte.append("📈 Productos con más de 5 transacciones:\n");
        for (Map.Entry<String, Integer> entry : porProducto.entrySet()) {
            if (entry.getValue() > 5) {
                reporte.append("- ").append(entry.getKey()).append(" (").append(entry.getValue()).append(" transacciones)\n");
            }
        }

        // 💼 Empleado con más transacciones
        String empleadoTop = maximo(porEmpleado);
        reporte.append("🏅 Empleado con más transacciones: ").append(empleadoTop).append(" (").append(porEmpleado.get(empleadoTop)).append(" transacciones)\n");

        return reporte.toString();
    }

    // Método auxiliar para obtener el nombre con mayor cantidad
    private static String maximo(HashMap<String, Integer> mapa) {
        String maxClave = null;
        int maxValor = -1;

        for (Map.Entry<String, Integer> entry : mapa.entrySet()) {
            if (entry.getValue() > maxValor) {
                maxValor = entry.getValue();
                maxClave = entry.getKey();
            }
        }

        return maxClave != null ? maxClave : "Ninguno";
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTransacciones = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnRegistrarVenta = new javax.swing.JButton();
        btnVerReportesAutomaticos = new javax.swing.JButton();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 153));

        jLabel1.setFont(new java.awt.Font("Roboto Black", 2, 36)); // NOI18N
        jLabel1.setText("Transacciones");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagenes/10789376.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/View/Imagenes/transaccionesssssssssdddd.png"))); // NOI18N
        jLabel4.setText("jLabel4");

        tablaTransacciones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo", "Producto", "Cantidad", "Fecha", "Empleado", "Total"
            }
        ));
        jScrollPane1.setViewportView(tablaTransacciones);

        btnVolver.setBackground(new java.awt.Color(255, 255, 115));
        btnVolver.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnRegistrarVenta.setBackground(new java.awt.Color(255, 255, 115));
        btnRegistrarVenta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnRegistrarVenta.setText("Registrar Transaccion");
        btnRegistrarVenta.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnRegistrarVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarVentaActionPerformed(evt);
            }
        });

        btnVerReportesAutomaticos.setBackground(new java.awt.Color(255, 255, 115));
        btnVerReportesAutomaticos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnVerReportesAutomaticos.setText("Ver Reportes Automaticos");
        btnVerReportesAutomaticos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnVerReportesAutomaticos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerReportesAutomaticosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(81, 81, 81)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnVolver)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnRegistrarVenta)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVerReportesAutomaticos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(btnVolver))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegistrarVenta, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVerReportesAutomaticos, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        Dashboard dashboard = new Dashboard(empresa);
        dashboard.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnVerReportesAutomaticosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerReportesAutomaticosActionPerformed
        // TODO add your handling code here:
    ReportesTransacciones ventana = new ReportesTransacciones(empresa,DatosEmpresa.listaProductos,DatosEmpresa.colaTransacciones);
    ventana.setVisible(true);
    ventana.setLocationRelativeTo(null); // Centrado
    }//GEN-LAST:event_btnVerReportesAutomaticosActionPerformed

    private void btnRegistrarVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarVentaActionPerformed
        // TODO add your handling code here:
        
        RegistrarTransaccion registrartransaccion = new RegistrarTransaccion(empresa,this);
        registrartransaccion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarVentaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        Empresa empresaprueba = new Empresa("Prueba");
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transacciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transacciones(empresaprueba).setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarVenta;
    private javax.swing.JButton btnVerReportesAutomaticos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTransacciones;
    // End of variables declaration//GEN-END:variables
}

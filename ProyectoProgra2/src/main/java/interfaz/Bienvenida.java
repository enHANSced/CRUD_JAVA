package interfaz;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.util.Locale;

import javax.swing.JPanel;

import funcionalidad.FuncionesDB;

public class Bienvenida extends javax.swing.JPanel {

    public Bienvenida() {
        initComponents();
        establecerSaludo();
        establecerFecha();
    }

    
    private void initComponents() {

        saludoLabel = new javax.swing.JLabel();
        fechaLabel = new javax.swing.JLabel();
        imagenLabel = new javax.swing.JLabel();
        contenedorNegocio = new javax.swing.JPanel();
        negocioLabel = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        contenedorBotones = new javax.swing.JPanel();
        ventaAccesoRapido = new javax.swing.JButton();
        inventarioAccesoRapido = new javax.swing.JButton();

        saludoLabel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        saludoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        saludoLabel.setText("KENNER, BUENAS NOCHES");

        fechaLabel.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        fechaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        fechaLabel.setText("Hoy es martes 16 de marzo de 2023");

        imagenLabel.setBackground(new java.awt.Color(204, 204, 204));
        imagenLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagenLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/logo.png"))); // NOI18N

        negocioLabel.setFont(new java.awt.Font("P052", 1, 24)); // NOI18N
        negocioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        negocioLabel.setText("ROYAL TECH");

        javax.swing.GroupLayout contenedorNegocioLayout = new javax.swing.GroupLayout(contenedorNegocio);
        contenedorNegocio.setLayout(contenedorNegocioLayout);
        contenedorNegocioLayout.setHorizontalGroup(
            contenedorNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorNegocioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(negocioLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, contenedorNegocioLayout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(separador)
                .addGap(100, 100, 100))
        );
        contenedorNegocioLayout.setVerticalGroup(
            contenedorNegocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorNegocioLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(negocioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(separador, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        contenedorBotones.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Acceso Rápido", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("SF Pro Display", 0, 13), new java.awt.Color(102, 102, 102))); // NOI18N

        ventaAccesoRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ventaIcon.png"))); // NOI18N
        ventaAccesoRapido.setText("Nueva Venta");
        ventaAccesoRapido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ventaAccesoRapidoActionPerformed(evt);
            }
        });

        inventarioAccesoRapido.setIcon(new javax.swing.ImageIcon(getClass().getResource("/inventarioIcon.png"))); // NOI18N
        inventarioAccesoRapido.setText("Mostrar Inventario");
        inventarioAccesoRapido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventarioAccesoRapidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout contenedorBotonesLayout = new javax.swing.GroupLayout(contenedorBotones);
        contenedorBotones.setLayout(contenedorBotonesLayout);
        contenedorBotonesLayout.setHorizontalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(ventaAccesoRapido, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                .addGap(30, 30, 30)
                .addComponent(inventarioAccesoRapido, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(67, 67, 67))
        );
        contenedorBotonesLayout.setVerticalGroup(
            contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(contenedorBotonesLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(contenedorBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ventaAccesoRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inventarioAccesoRapido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedorNegocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(contenedorBotones, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(saludoLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(fechaLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contenedorNegocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(saludoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(fechaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(contenedorBotones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagenLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );
    }



    


//----------------------------------------------Eventos--------------------------------------------

    private void ventaAccesoRapidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ventaAccesoRapidoActionPerformed
        Transaccion ventaAccesoRapido = new Transaccion();
        ventaAccesoRapido.adaptarAVenta();
        ventaAccesoRapido.setSize(550, 570);
        ventaAccesoRapido.setLocation(0, 0);
       
        JPanel panelActual = (JPanel)this.getParent();

        panelActual.removeAll();
        panelActual.add(ventaAccesoRapido);
        panelActual.revalidate();
        panelActual.repaint();
    }//GEN-LAST:event_ventaAccesoRapidoActionPerformed

    private void inventarioAccesoRapidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventarioAccesoRapidoActionPerformed
        InventarioTodo inventarioAccesoRapido = new InventarioTodo();
        FuncionesDB.actualizarProductos(inventarioAccesoRapido.getTablaProductos());
        inventarioAccesoRapido.setSize(550, 570);
        inventarioAccesoRapido.setLocation(0, 0);
       
        JPanel panelActual = (JPanel)this.getParent();
        
        panelActual.removeAll();
        panelActual.add(inventarioAccesoRapido);
        panelActual.revalidate();
        panelActual.repaint();
    }

    private void establecerFecha() {
        LocalDate now = LocalDate.now();
        //Locale spanishLocale = new Locale("es", "ES");
        fechaLabel.setText(now.format(DateTimeFormatter.ofPattern("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy")));
    }

    private void establecerSaludo(){
        String nombreUsuario = System.getProperty("user.name");
        String texto = "Bienvenido, "+nombreUsuario;
        texto=texto.toUpperCase();
        saludoLabel.setText(texto);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel contenedorBotones;
    private javax.swing.JPanel contenedorNegocio;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel imagenLabel;
    private javax.swing.JButton inventarioAccesoRapido;
    private javax.swing.JLabel negocioLabel;
    private javax.swing.JLabel saludoLabel;
    private javax.swing.JSeparator separador;
    private javax.swing.JButton ventaAccesoRapido;
    // End of variables declaration//GEN-END:variables
}

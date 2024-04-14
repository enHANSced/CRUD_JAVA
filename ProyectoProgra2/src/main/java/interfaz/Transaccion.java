package interfaz;

import javax.swing.AbstractAction;

import funcionalidad.FuncionesDB;

public class Transaccion extends javax.swing.JPanel {

    public Transaccion() {
        initComponents();
    }

    private void initComponents() {

        codigoText = new javax.swing.JTextField();
        cantidadText = new javax.swing.JTextField();
        eliminarButton = new javax.swing.JButton();
        venderButton = new javax.swing.JButton();
        agregarButton = new javax.swing.JButton();
        codigoLabel = new javax.swing.JLabel();
        cantidadLabel = new javax.swing.JLabel();
        nombreProductoLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLista = new javax.swing.JTable();
        tituloLista = new javax.swing.JLabel();
        tituloLabel = new javax.swing.JLabel();
        comprarButton = new javax.swing.JButton();


        codigoText.addActionListener(new AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTextActionPerformed(evt);
            }
        });

        eliminarButton.setText("Eliminar de la Lista");
        eliminarButton.setToolTipText("Eliminar producto de la transacción actual.");
        eliminarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarButtonActionPerformed(evt);
            }
        });

        venderButton.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        venderButton.setText("Vender");
        venderButton.setToolTipText("Generar factura, la cantidad de los productos actuales se reducirán del inventario.");
        venderButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                venderButtonActionPerformed(evt);
            }
        });


        agregarButton.setText("Agregar a la Lista");
        agregarButton.setToolTipText("Agrega el producto actual a la lista de compra o venta.");
        agregarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarButtonActionPerformed(evt);
            }
        });


        codigoLabel.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        codigoLabel.setText("Código:");

        cantidadLabel.setFont(new java.awt.Font("SF Pro Display", 0, 14)); // NOI18N
        cantidadLabel.setText("Cantidad:");

        cantidadText.setText("1");

        nombreProductoLabel.setFont(new java.awt.Font("SF Pro Display", 2, 14)); // NOI18N
        nombreProductoLabel.setText("Cuando ingrese el código presione Enter y aqui aparecerá el nombre.");

        tablaLista.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Producto", "Precio Unitario", "Cantidad", "Precio Total"
            }
        ));
        jScrollPane1.setViewportView(tablaLista);

        tituloLista.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        tituloLista.setText("Productos en esta transacción");

        tituloLabel.setFont(new java.awt.Font("SF Pro Display", 1, 16)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("NUEVA TRANSACCIÓN");

        comprarButton.setFont(new java.awt.Font("SF Pro Display", 1, 14)); // NOI18N
        comprarButton.setText("Comprar");
        comprarButton.setToolTipText("Comprar los productos de la lista actual, las cantidades se sumarán al inventario.");
        comprarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tituloLista)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130)
                                .addComponent(comprarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(venderButton, javax.swing.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)))
                        .addGap(44, 44, 44))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(cantidadLabel))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(codigoLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(nombreProductoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codigoText, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cantidadText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(209, 209, 209))))
            .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(tituloLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(nombreProductoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cantidadLabel)
                    .addComponent(cantidadText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(agregarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(tituloLista)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eliminarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(venderButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comprarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(17, 17, 17))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void adaptarAVenta(){
        comprarButton.setVisible(false);
        tituloLabel.setText("NUEVA VENTA");
        tituloLista.setText("Productos en esta venta:");
        
    }
    






    //---------------------------------------Eventos--------------------------------------------


    private void comprarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        FuncionesDB.realizarCompra(tablaLista);
    }//GEN-LAST:event_editarBtnActionPerformed
    
    private void venderButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        FuncionesDB.realizarVenta(tablaLista);
    }//GEN-LAST:event_editarBtnActionPerformed

    private void agregarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        FuncionesDB.agregarALista(tablaLista, cantidadText, codigoText,nombreProductoLabel);
    }//GEN-LAST:event_editarBtnActionPerformed

    private void eliminarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        FuncionesDB.eliminarDeLista(tablaLista);
    }//GEN-LAST:event_editarBtnActionPerformed

    private void codigoTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editarBtnActionPerformed
        FuncionesDB.buscarPorCodigo(tablaLista,codigoText, nombreProductoLabel);
    }




    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregarButton;
    private javax.swing.JLabel cantidadLabel;
    private javax.swing.JTextField cantidadText;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JTextField codigoText;
    private javax.swing.JButton comprarButton;
    private javax.swing.JButton eliminarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nombreProductoLabel;
    private javax.swing.JTable tablaLista;
    private javax.swing.JLabel tituloLabel;
    private javax.swing.JLabel tituloLista;
    private javax.swing.JButton venderButton;
    // End of variables declaration//GEN-END:variables
}

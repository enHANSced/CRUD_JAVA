package interfaz;

import javax.swing.JTextField;

import funcionalidad.FuncionesDB;

public class InventarioCategoria extends javax.swing.JPanel {

    public InventarioCategoria() {
        initComponents();
    }

    private void initComponents() {

        tituloLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        categoriasTabla = new javax.swing.JTable();
        selectorCategoria = new javax.swing.JComboBox<>();
        buscarButton = new javax.swing.JButton();
        editarButton = new javax.swing.JButton();
        borraButton = new javax.swing.JButton();

        tituloLabel.setFont(new java.awt.Font("SF Pro Display", 1, 16)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("PRODUCTOS POR CATEGORÍA");

        categoriasTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Producto", "Precio (L)", "Categoría", "Existencias"
            }
        ));
        jScrollPane1.setViewportView(categoriasTabla);

        selectorCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoría a buscar","Televisión", "Celulares", "Tablets", "Computadoras",  "Audio", "Videojuegos", "Electrodomésticos", "Accesorios"}));
        selectorCategoria.setSelectedIndex(0);

        buscarButton.setText("Buscar");
        buscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarButtonActionPerformed(evt);
            }
        });

        editarButton.setText("Editar");
        editarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarButtonActionPerformed(evt);
            }
        });

        borraButton.setText("Borrar");
        borraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borraButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selectorCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(buscarButton)))
                                .addGap(20, 20, 20))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(72, 72, 72)
                                .addComponent(editarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(borraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(111, 111, 111))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectorCategoria)
                    .addComponent(buscarButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(editarButton, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(borraButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(20, 20, 20))
        );
    }






    //----------------------------------------------Eventos--------------------------------------------

    private void buscarButtonActionPerformed(java.awt.event.ActionEvent evt) {
       FuncionesDB.buscarPorCategoria(categoriasTabla, selectorCategoria);
    }

    private void editarButtonActionPerformed(java.awt.event.ActionEvent evt) {
        AgregarEditar ventanaEditar = new AgregarEditar();
        ventanaEditar.setVisible(true);
        JTextField[] componentesTexto = {ventanaEditar.getCodigoText(),ventanaEditar.getNombreText(), ventanaEditar.getPrecioText(), ventanaEditar.getExistenciasText()};
        FuncionesDB.editarProductos(categoriasTabla,componentesTexto, ventanaEditar.getCategoriaComboBox(),ventanaEditar.getAceptarButton());
    }

    private void borraButtonActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.borrarProductos(categoriasTabla);
    }


    public javax.swing.JTable getCategoriasTabla() {
        return categoriasTabla;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borraButton;
    private javax.swing.JButton buscarButton;
    private javax.swing.JTable categoriasTabla;
    private javax.swing.JButton editarButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> selectorCategoria;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}

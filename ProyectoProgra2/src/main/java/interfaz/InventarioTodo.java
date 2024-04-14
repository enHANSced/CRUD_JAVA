package interfaz;

import funcionalidad.FuncionesDB;

import javax.swing.AbstractAction;
import javax.swing.JTextField;

public class InventarioTodo extends javax.swing.JPanel {

    public InventarioTodo() {
        initComponents();
    }

   
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaProductos = new javax.swing.JTable();
        tituloLabel = new javax.swing.JLabel();
        nuevoBtn = new javax.swing.JButton();
        buscarTxt = new javax.swing.JTextField();
        buscarBtn = new javax.swing.JButton();
        editarBtn = new javax.swing.JButton();
        borrarBtn = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 500));

        tablaProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Nombre", "Precio (L)", "Categoría", "Existencias"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        
        jScrollPane1.setViewportView(tablaProductos);

        tituloLabel.setFont(new java.awt.Font("SF Pro Display", 1, 16)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("TODOS LOS PRODUCTOS");

        nuevoBtn.setText("Nuevo");
        nuevoBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoBtnActionPerformed(evt);
            }
        });

        buscarTxt.setText("Escriba el nombre del producto a buscar");
        buscarTxt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                buscarTxtKeyTyped(evt);
            }
        });
        buscarTxt.addActionListener(new AbstractAction() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarTxtActionPerformed(evt);
            }
        });

        buscarBtn.setText("Buscar");
        buscarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscarBtnActionPerformed(evt);
            }
        });

        editarBtn.setText("Editar");
        editarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editarBtnActionPerformed(evt);
            }
        });

        borrarBtn.setText("Borrar");
        borrarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tituloLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buscarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 319, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buscarBtn))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(nuevoBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(38, 38, 38)
                        .addComponent(editarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                        .addGap(32, 32, 32)
                        .addComponent(borrarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buscarTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                    .addComponent(buscarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nuevoBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(editarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(borrarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
    }





    //----------------------------------------------Eventos--------------------------------------------

    private void editarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AgregarEditar ventanaEditar = new AgregarEditar();
        ventanaEditar.setVisible(true);
        JTextField[] componentesTexto = {ventanaEditar.getCodigoText(),ventanaEditar.getNombreText(), ventanaEditar.getPrecioText(), ventanaEditar.getExistenciasText()};
        FuncionesDB.editarProductos(tablaProductos,componentesTexto, ventanaEditar.getCategoriaComboBox(),ventanaEditar.getAceptarButton());
        
    }

    private void nuevoBtnActionPerformed(java.awt.event.ActionEvent evt) {
        AgregarEditar ventanaAgregar = new AgregarEditar();
        ventanaAgregar.setVisible(true);
        JTextField[] componentesTexto = {ventanaAgregar.getCodigoText(),ventanaAgregar.getNombreText(), ventanaAgregar.getPrecioText(), ventanaAgregar.getExistenciasText()};
        FuncionesDB.agregarProductos(tablaProductos, componentesTexto, ventanaAgregar.getCategoriaComboBox(), ventanaAgregar.getAceptarButton());
        
    }

    private void buscarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.buscarPorNombre(tablaProductos, buscarTxt);
    }

    private void borrarBtnActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.borrarProductos(tablaProductos);
    }
    
        boolean hecho=false;
    private void buscarTxtKeyTyped(java.awt.event.KeyEvent evt) {

        while(!hecho){
        buscarTxt.setText("");
        hecho=true;
        }

    }

    private void buscarTxtActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.buscarPorNombre(tablaProductos,buscarTxt);
    }
    
    public javax.swing.JTable getTablaProductos() {
        return tablaProductos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarBtn;
    private javax.swing.JButton buscarBtn;
    private javax.swing.JTextField buscarTxt;
    private javax.swing.JButton editarBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton nuevoBtn;
    private javax.swing.JTable tablaProductos;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}

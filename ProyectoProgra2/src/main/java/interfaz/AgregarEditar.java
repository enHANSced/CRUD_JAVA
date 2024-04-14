package interfaz;

import javax.swing.JComboBox;
import javax.swing.JTextField; 

public class AgregarEditar extends javax.swing.JFrame {
    
    public AgregarEditar() {   
        initComponents();
        setLocationRelativeTo(null);
        
    }

    private void initComponents() {

        tituloLabel = new javax.swing.JLabel();
        codigoLabel = new javax.swing.JLabel();
        nombreLabel = new javax.swing.JLabel();
        categoriaLabel = new javax.swing.JLabel();
        precioLabel = new javax.swing.JLabel();
        existenciasLabel = new javax.swing.JLabel();
        codigoText = new javax.swing.JTextField();
        nombreText = new javax.swing.JTextField();
        categoriaComboBox = new javax.swing.JComboBox<>();
        precioText = new javax.swing.JTextField();
        existenciasText = new javax.swing.JTextField();
        aceptarButton = new javax.swing.JButton();
        cancelarButton = new javax.swing.JButton();


        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Editor de Productos");
        setResizable(false);
        setAlwaysOnTop(true);
        

        tituloLabel.setFont(new java.awt.Font("SF Pro Rounded", 1, 16)); // NOI18N
        tituloLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloLabel.setText("Rellene todos los campos");

        codigoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        codigoLabel.setText("Código:");

        nombreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        nombreLabel.setText("Nombre:");

        categoriaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaLabel.setText("Categoria:");

        precioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        precioLabel.setText("Precio:");

        existenciasLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        existenciasLabel.setText("Existencias:");

        codigoText.setText("");
        codigoText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                codigoTextActionPerformed(evt);
            }
        });

        nombreText.setText("");
        nombreText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreTextActionPerformed(evt);
            }
        });

        categoriaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione la categoría", "Televisión", "Celulares", "Tablets", "Computadoras",  "Audio", "Videojuegos", "Electrodomésticos", "Accesorios"}));
        categoriaComboBox.setSelectedIndex(0);

        precioText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precioTextActionPerformed(evt);
            }
        });

        existenciasText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                existenciasTextActionPerformed(evt);
            }
        });

        aceptarButton.setText("Aceptar");


        cancelarButton.setText("Cancelar");
        cancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                        .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(categoriaLabel)
                            .addComponent(codigoLabel)
                            .addComponent(existenciasLabel)
                            .addComponent(precioLabel)
                            .addComponent(nombreLabel))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(codigoText)
                            .addComponent(nombreText)
                            .addComponent(categoriaComboBox, 0, 191, Short.MAX_VALUE)
                            .addComponent(precioText)
                            .addComponent(existenciasText))))
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tituloLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoLabel)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombreLabel)
                    .addComponent(nombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoriaLabel)
                    .addComponent(categoriaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precioLabel)
                    .addComponent(precioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(existenciasLabel)
                    .addComponent(existenciasText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );

        pack();
    }







    //------------------------------------Eventos-------------------------------------------

    private void cancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {
       setVisible(false);
    }
    
    private void codigoTextActionPerformed(java.awt.event.ActionEvent evt) {
        
    }
    
    private void nombreTextActionPerformed(java.awt.event.ActionEvent evt) {
      
    }

    private void precioTextActionPerformed(java.awt.event.ActionEvent evt) {
        
    }

    private void existenciasTextActionPerformed(java.awt.event.ActionEvent evt) {
        
    }


    //Getters
    





    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarEditar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        


        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarEditar().setVisible(true);
                
            }
        });
    }

    public JComboBox<String> getCategoriaComboBox() {
        return categoriaComboBox;
    }

    public JTextField getCodigoText() {
        return codigoText;
    }

    public JTextField getExistenciasText() {
        return existenciasText;
    }

    public JTextField getNombreText() {
        return nombreText;
    }

    public JTextField getPrecioText() {
        return precioText;
    }

    public javax.swing.JButton getAceptarButton() {
        return aceptarButton;
    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aceptarButton;
    private javax.swing.JButton cancelarButton;
    private javax.swing.JComboBox<String> categoriaComboBox;
    private javax.swing.JLabel categoriaLabel;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JTextField codigoText;
    private javax.swing.JLabel existenciasLabel;
    private javax.swing.JTextField existenciasText;
    private javax.swing.JLabel nombreLabel;
    private javax.swing.JTextField nombreText;
    private javax.swing.JLabel precioLabel;
    private javax.swing.JTextField precioText;
    private javax.swing.JLabel tituloLabel;
    // End of variables declaration//GEN-END:variables
}

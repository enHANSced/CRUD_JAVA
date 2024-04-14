package interfaz;


import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import funcionalidad.FuncionesDB;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;


public class VentanaPrincipal extends javax.swing.JFrame {

    public VentanaPrincipal() {
        initComponents();
        initStyles();
        setLocationRelativeTo(null);
        modoClaroItem.setVisible(false);
        showPanel(new Bienvenida());
    }
    
    
    public final void initStyles(){
        UIManager.put( "Button.arc", 999 );
        UIManager.put( "Component.arc", 999 );
        UIManager.put( "ProgressBar.arc", 999 );
        UIManager.put( "TextComponent.arc", 999 );
        UIManager.put( "Component.arrowType", "triangle" );
    }


    private void initComponents() {

        contenedor = new javax.swing.JPanel();
        barraMenu = new javax.swing.JMenuBar();
        opcionesMenu = new javax.swing.JMenu();
        inicioItem = new javax.swing.JMenuItem();
        actualizarItem = new javax.swing.JMenuItem();
        modoClaroItem = new javax.swing.JMenuItem();
        modoOscuroItem = new javax.swing.JMenuItem();
        salirItem = new javax.swing.JMenuItem();
        mostrarMenu = new javax.swing.JMenu();
        inventarioMenu = new javax.swing.JMenu();
        todoItem = new javax.swing.JMenuItem();
        categoriaItem = new javax.swing.JMenuItem();
        transaccionMenu = new javax.swing.JMenu();
        nuevaTransaccionItem = new javax.swing.JMenuItem();
        ayudaMenu = new javax.swing.JMenu();
        manualUsuarioItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(570, 630));
        

        contenedor.setPreferredSize(new java.awt.Dimension(570, 630));
        contenedor.setLayout(new java.awt.BorderLayout());

        opcionesMenu.setText("Opciones");

        inicioItem.setText("Inicio");
        inicioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioItemActionPerformed(evt);
            }
        });
        opcionesMenu.add(inicioItem);

        actualizarItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        actualizarItem.setText("Actualizar");
        actualizarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    actualizarItemActionPerformed(evt);
                } catch (BadLocationException e) {
                    e.printStackTrace();
                }
            }
        });
        opcionesMenu.add(actualizarItem);

        modoClaroItem.setText("Modo Claro");
        modoClaroItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoClaroItemActionPerformed(evt);
            }
        });
        opcionesMenu.add(modoClaroItem);

        modoOscuroItem.setText("Modo Oscuro");
        modoOscuroItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modoOscuroItemActionPerformed(evt);
            }
        });
        opcionesMenu.add(modoOscuroItem);

        salirItem.setText("Salir");
        salirItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirItemActionPerformed(evt);
            }
        });
        opcionesMenu.add(salirItem);

        barraMenu.add(opcionesMenu);

        mostrarMenu.setText("Mostrar");

        inventarioMenu.setText("Inventario");

        todoItem.setText("Todo");
        todoItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                todoItemActionPerformed(evt);
            }
        });
        inventarioMenu.add(todoItem);

        categoriaItem.setText("Por Categorías");
        categoriaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoriaItemActionPerformed(evt);
            }
        });
        inventarioMenu.add(categoriaItem);

        mostrarMenu.add(inventarioMenu);

        barraMenu.add(mostrarMenu);

        transaccionMenu.setText("Transacción");

        nuevaTransaccionItem.setText("Nueva Transacción");
        nuevaTransaccionItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevaTransaccionItemActionPerformed(evt);
            }
        });
        transaccionMenu.add(nuevaTransaccionItem);

        barraMenu.add(transaccionMenu);

        ayudaMenu.setText("Ayuda");

        manualUsuarioItem.setText("Manual de Usuario");
        manualUsuarioItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualUsuarioItemActionPerformed(evt);
            }
        });
        ayudaMenu.add(manualUsuarioItem);

        barraMenu.add(ayudaMenu);

        setJMenuBar(barraMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(contenedor, javax.swing.GroupLayout.DEFAULT_SIZE, 481, Short.MAX_VALUE)
        );

        pack();
    }





    

//----------------------------------------------Eventos--------------------------------------------

    InventarioTodo panelInventarioTodo=new InventarioTodo();
    InventarioCategoria panelCategoria=new InventarioCategoria();

    private void todoItemActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.actualizarProductos(panelInventarioTodo.getTablaProductos());
        showPanel(panelInventarioTodo);
    }

    private void inicioItemActionPerformed(java.awt.event.ActionEvent evt) {
        showPanel(new Bienvenida());
    }

    private void salirItemActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void actualizarItemActionPerformed(java.awt.event.ActionEvent evt) throws BadLocationException {

        //showPanel((JPanel)contenedor.getComponent(0));

        if (contenedor.getComponent(0).getClass().getSimpleName().equals("InventarioTodo")) {
            FuncionesDB.actualizarProductos(panelInventarioTodo.getTablaProductos());
            showPanel(panelInventarioTodo);
        }

        if (contenedor.getComponent(0).getClass().getSimpleName().equals("InventarioCategoria")) {
            FuncionesDB.actualizarProductos(panelCategoria.getCategoriasTabla());
            showPanel(panelCategoria);
        }

        if (contenedor.getComponent(0).getClass().getSimpleName().equals("ManualDeUsuario")) {
            showPanel(new ManualDeUsuario());
        }
    }

    private void categoriaItemActionPerformed(java.awt.event.ActionEvent evt) {
        FuncionesDB.actualizarProductos(panelCategoria.getCategoriasTabla());
        showPanel(panelCategoria);
    }

    private void nuevaTransaccionItemActionPerformed(java.awt.event.ActionEvent evt) {
       showPanel(new Transaccion());
    }

    private void modoOscuroItemActionPerformed(java.awt.event.ActionEvent evt) {
        int res=JOptionPane.showConfirmDialog(this, "La aplicación se reiniciará y volverá a la pantalla de inicio.\nLos cambios no guardados se perderán.", "Cuidado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        System.out.println(res);
        if (res==0){
        FlatMacDarkLaf.setup();
        dispose();

        VentanaPrincipal nuevoFrame=new VentanaPrincipal();
        nuevoFrame.modoOscuroItem.setVisible(false);
        nuevoFrame.modoClaroItem.setVisible(true);
        nuevoFrame.setVisible(true);
        
        }
    }

    private void modoClaroItemActionPerformed(java.awt.event.ActionEvent evt) {
       int res=JOptionPane.showConfirmDialog(this, "La aplicación se reiniciará y volverá a la pantalla de inicio.\nLos cambios no guardados se perderán.", "Cuidado", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
        System.out.println(res);
        if (res==0){
            FlatMacLightLaf.setup();
            dispose();
            VentanaPrincipal nuevoFrame=new VentanaPrincipal();
            nuevoFrame.modoOscuroItem.setVisible(true);
            nuevoFrame.setVisible(true);
        }
    }

    private void manualUsuarioItemActionPerformed(java.awt.event.ActionEvent evt) {

        try {
            showPanel(new ManualDeUsuario());
        } catch (BadLocationException e) {
            
            e.printStackTrace();
        }
    }

    
    public final void showPanel(javax.swing.JPanel p){
        p.setSize(570, 630);
        p.setLocation(0, 0);
       
        contenedor.removeAll();
        contenedor.add(p, BorderLayout.CENTER);
        contenedor.revalidate();
        contenedor.repaint();
    }
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        FlatMacLightLaf.setup();

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem actualizarItem;
    private javax.swing.JMenu ayudaMenu;
    private javax.swing.JMenuBar barraMenu;
    private javax.swing.JMenuItem categoriaItem;
    private javax.swing.JPanel contenedor;
    private javax.swing.JMenuItem inicioItem;
    private javax.swing.JMenu inventarioMenu;
    private javax.swing.JMenuItem manualUsuarioItem;
    private javax.swing.JMenuItem modoClaroItem;
    private javax.swing.JMenuItem modoOscuroItem;
    private javax.swing.JMenu mostrarMenu;
    private javax.swing.JMenuItem nuevaTransaccionItem;
    private javax.swing.JMenu opcionesMenu;
    private javax.swing.JMenuItem salirItem;
    private javax.swing.JMenuItem todoItem;
    private javax.swing.JMenu transaccionMenu;
    // End of variables declaration//GEN-END:variables

}

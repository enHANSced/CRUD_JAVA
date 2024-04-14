package funcionalidad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;


public class FuncionesDB {

    //--------------------------------Sección Mostrar-----------------------------------------
   //   columnas de tabla = "Código", "Nombre", "Precio", "Categoría", "Existencias"

   //categorias = "Televisión", "Celulares", "Tablets", "Computadoras",  "Audio", "Videojuegos", "Electrodomésticos", "Accesorios"
    
    //  con f5 actualizamos los datos de las tablas cuando hacemos cambios en el txt

    public static void actualizarProductos(JTable tablaProductos) {

        String [] nombresdeColumna=new String[tablaProductos.getColumnCount()];
        for (int i = 0; i < tablaProductos.getColumnCount(); i++) {
            nombresdeColumna[i]=tablaProductos.getColumnName(i);
        }
        
        DefaultTableModel model = new DefaultTableModel(nombresdeColumna, 0){
            public boolean isCellEditable(int row, int column)
                {
                    return false;//This causes all cells to be not editable
                }
        };

        File f = new File("productos.txt"); 
        
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();
            System.out.println();

            while(linea != null){
                String[] lineSplit=linea.split(";");
                model.addRow(lineSplit);
            
                linea = br.readLine();
            }
            br.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        
        tablaProductos.setModel(model);

        tablaProductos.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaProductos.getColumnModel().getColumn(1).setPreferredWidth(190);
        tablaProductos.getColumnModel().getColumn(3).setPreferredWidth(115);
        tablaProductos.getColumnModel().getColumn(4).setPreferredWidth(50);

    }


/////////////////////////////////////////////////////////////////////////////////PAMELA
    public static void borrarProductos(JTable tablaProductos) {
        int[] filasSeleccionadas = tablaProductos.getSelectedRows();
        
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione uno o varios productos de la tabla para poder borrarlos.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{



            //-------------------Mensaje de confirmación-------------------------
            //ahora se puede decidir si realmente se quieren borrar los productos, se pueden borrar varios productos.

            int n = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar los productos seleccionados?", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (n==0) {
                    File archivo = new File("productos.txt");
                    
                    try {
                        File temporal = new File("temporal.txt");
                        FileWriter writer = new FileWriter(temporal);
                        FileReader reader = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(reader);
                        
                        String linea = br.readLine();
                        
                        while (linea != null) {
                            boolean seleccionada = false;
                            for (int i = 0; i < filasSeleccionadas.length; i++) {
                                int filaSeleccionada = filasSeleccionadas[i];
                                String[] datosFila = linea.split(";");
                                String codigoFila = datosFila[0];
                                
                                if (tablaProductos.getValueAt(filaSeleccionada, 0).equals(codigoFila)) {
                                    seleccionada = true;
                                    break;
                                }
                            }
                            if (!seleccionada) {
                                writer.write(linea + "\n");
                            }
                            
                            linea = br.readLine();
                        }
                    
                        br.close();
                        reader.close();
                        writer.close();
                        archivo.delete();
                        temporal.renameTo(archivo);
                        
                        JOptionPane.showMessageDialog(null, "El/Los producto(s) se borraron correctamente","Exito",0);
                        actualizarProductos(tablaProductos);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de borrarr productos.");
                        e.printStackTrace();
                    }
            }
            
        }     
        
    }
    


    public static void buscarPorNombre(JTable tablaProductos, JTextField nombre) {
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablaProductos.setRowSorter(sorter);
    
        String nombreBusqueda = nombre.getText();
    
        if (nombreBusqueda.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + nombreBusqueda, 1);
            sorter.setRowFilter(rowFilter);
        }
    }

    public static void buscarPorCategoria(JTable tablaProductos, JComboBox<String> categoria) {
        DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        tablaProductos.setRowSorter(sorter);
    
        String categoriaBusqueda = categoria.getSelectedItem().toString();
    
        if (categoriaBusqueda.trim().length() == 0) {
            sorter.setRowFilter(null);
        } else {
            RowFilter<DefaultTableModel, Object> rowFilter = RowFilter.regexFilter("(?i)" + categoriaBusqueda, 3);
            sorter.setRowFilter(rowFilter);
        }
    }



    //-------------------------ventana editar y agregar productos-------------------------
   
    //indices de campos de texto
        // codigo = 0
        // nombre = 1
        // precio = 2
        // existencias = 3

        /////////////////////////////////////////////////////////////////////////////////PAMELA
        
        
        //--------------------------------Listos----------------------------------
        //Ahora esto nos crea un objeto de tipo Producto en el que si se crea correctamente
        // se añade al archivo de texto si no, le dice al usuario que los valores que ingresó no son validos.
        // ahora el manejo de errores es mucho mejor.

        public static void agregarProductos(JTable tablaProductos, JTextField[] camposDeTexto, JComboBox<String> seleccionCategoria, JButton botonAceptar) {

            botonAceptar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
          
            String nuevoCodigo = camposDeTexto[0].getText();
            String nuevoNombre = camposDeTexto[1].getText();
            if (nuevoNombre.equals("")) {
                JOptionPane.showMessageDialog(botonAceptar.getParent(), "Establezcale un nombre al producto.");
            }
            else{
                String nuevoPrecio = camposDeTexto[2].getText();
                String nuevasExistencias = camposDeTexto[3].getText();
                String nuevaCategoria = (String) seleccionCategoria.getSelectedItem();


                try {
                    Producto objProducto = new Producto(Integer.parseInt(nuevoCodigo), nuevoNombre, Double.parseDouble(nuevoPrecio), nuevaCategoria, Integer.parseInt(nuevasExistencias));

                    try {
                        FileWriter escritor = new FileWriter("productos.txt",true);
                        escritor.write(objProducto.toString());  
            
                        escritor.close();
                    
                        objProducto=null;

                        JOptionPane.showMessageDialog(botonAceptar.getParent(), "Producto guardado correctamente.","Exito",JOptionPane.INFORMATION_MESSAGE);
                        JFrame frame = (JFrame)SwingUtilities.getRoot(botonAceptar);
                        frame.dispose();
                        actualizarProductos(tablaProductos);
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(botonAceptar.getParent(), "Hubo un error al ingresar, el sistema no puede encontrar el archivo especificado.","Error",JOptionPane.INFORMATION_MESSAGE);
                        e.printStackTrace();
                    }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(botonAceptar.getParent(), "Hubo un error al guardar el producto, los valores ingresados no son válidos.","Error",JOptionPane.ERROR_MESSAGE);
                    }

                }
                }
                
            });
        }

    

////////////////////////////////////////////////////////////////////////////////////////////PAMELA
//el bonton se llamaba botonAceptar y eso me confundia asi que lo cambie por botonEditar 
////////////////////EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-EDITAR-
public static void editarProductos(JTable tablaProductos, JTextField[] camposDeTexto, JComboBox<String> seleccionCategoria, JButton botonEditar) {
    int filaSeleccionada = tablaProductos.getSelectedRow();

    if (filaSeleccionada == -1) {
        JFrame frame = (JFrame)SwingUtilities.getRoot(botonEditar);
        frame.dispose();
        JOptionPane.showMessageDialog(botonEditar.getParent(), "Seleccione un producto de la tabla para poder editarlo.");
        
        return;
    }else{

    String codigo = tablaProductos.getValueAt(filaSeleccionada, 0).toString();
    String nombre = tablaProductos.getValueAt(filaSeleccionada, 1).toString();
    String precio = tablaProductos.getValueAt(filaSeleccionada, 2).toString();
    String categoria = tablaProductos.getValueAt(filaSeleccionada, 3).toString();
    String existencias = tablaProductos.getValueAt(filaSeleccionada, 4).toString();

    precio = precio.replace(",", "");

    camposDeTexto[0].setText(codigo);
    camposDeTexto[1].setText(nombre);
    camposDeTexto[2].setText(precio);
    camposDeTexto[3].setText(existencias);
    seleccionCategoria.setSelectedItem(categoria);


    botonEditar.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent arg0) {

            String nuevoCodigo = camposDeTexto[0].getText();
            String nuevoNombre = camposDeTexto[1].getText();
            if (nuevoNombre.equals("")) {
                JOptionPane.showMessageDialog(botonEditar.getParent(), "Establezca un nombre de producto.");
            }else{
            String nuevoPrecio = camposDeTexto[2].getText();
            String nuevasExistencias = camposDeTexto[3].getText();
            String nuevaCategoria = (String) seleccionCategoria.getSelectedItem();


            try {
                Producto objProducto = new Producto(Integer.parseInt(nuevoCodigo), nuevoNombre, Double.parseDouble(nuevoPrecio), nuevaCategoria, Integer.parseInt(nuevasExistencias));

            File archivoProductos = new File("productos.txt");
            File archivoTemporal = new File("productos.tmp");
            try {
                BufferedReader lector = new BufferedReader(new FileReader(archivoProductos));
                FileWriter escritor = new FileWriter(archivoTemporal);
                String linea;
                while ((linea = lector.readLine()) != null) {
                    String[] campos = linea.split(";");
                    if (campos[0].equals(codigo)) {
                            escritor.write(objProducto.toString());  
                       
                    } else {
                        escritor.write(linea + "\n");
                    }
                }
                lector.close();
                escritor.close();
                archivoProductos.delete();
                archivoTemporal.renameTo(archivoProductos);

                objProducto=null;

                JOptionPane.showMessageDialog(botonEditar.getParent(), "El producto se editó correctamente.","Exito",JOptionPane.INFORMATION_MESSAGE);
                JFrame frame = (JFrame)SwingUtilities.getRoot(botonEditar);
                frame.dispose();
                actualizarProductos(tablaProductos);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(botonEditar.getParent(), "Hubo un error al editar el producto, el sistema no puede encontrar el archivo especificado.","Error",JOptionPane.INFORMATION_MESSAGE);
                e.printStackTrace();
            }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(botonEditar.getParent(), "Hubo un error al editar el producto, los valores ingresados no son válidos.","Error",JOptionPane.ERROR_MESSAGE);
            }

        }
    }
    });
    
}
}


















//------------------------------------------Realizar Transacciones---------------------------------

//Aquí se buscaran los productos por código y se pasaran la cantidades a comprar o vender
// esas cantidades son las que tenemos que modificar de nuestras existencias, restarlas cuando es venta y sumarlas cuando es compra
// mostrar una factura con todos los elementos de la tabla de transacciones.


public static void buscarPorCodigo(JTable tablaProductos, JTextField codigo, JLabel nombreProductoLabel) {
    //DefaultTableModel model = (DefaultTableModel) tablaProductos.getModel();
    String codigoBusqueda = codigo.getText();
    boolean encontrado = false;
    try (FileReader fr = new FileReader("productos.txt");
         BufferedReader br = new BufferedReader(fr)) {
        String linea = br.readLine();
        while (linea != null) {
            String[] datos = linea.split(";");
            if (datos[0].equals(codigoBusqueda)) {
                encontrado = true;
                nombreProductoLabel.setText(datos[1]);
                break;
            }
            linea = br.readLine();
        }
        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró un producto con ese código.", "Producto no encontrado", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (IOException e) {
        JOptionPane.showMessageDialog(null, "Error al leer el archivo de productos.", "Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}










    static int codigo=0;
    static String nombre="";
    static double precio=0;

    public static void agregarALista(JTable tablaLista, JTextField cantidadText, JTextField codigoText, JLabel nombreLabel) {

        if (codigoText.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningun producto", "Error", 0);
        }
        else{
        int codigoSeleccionado = Integer.parseInt(codigoText.getText());

        boolean codigoEncontrado=false;
        

        String [] nombresdeColumna=new String[tablaLista.getColumnCount()];

        for (int i = 0; i < tablaLista.getColumnCount(); i++) {

            nombresdeColumna[i]=tablaLista.getColumnName(i);

        }
        

        DefaultTableModel model = new DefaultTableModel(nombresdeColumna, 0){
            public boolean isCellEditable(int row, int column)
                {
                    return false;//This causes all cells to be not editable
                }
        };

        File f = new File("productos.txt"); 
        int codigoComparar;
        try{
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            
            String linea = br.readLine();

            while(linea != null){
                String[] lineSplit=linea.split(";");

                codigoComparar=Integer.parseInt(lineSplit[0]);

                if (codigoSeleccionado==codigoComparar) {
                    codigoEncontrado=true;
                    codigo = Integer.parseInt(lineSplit[0]);
                    nombre = lineSplit[1];
                    precio = Double.parseDouble(lineSplit[2].replace(",", ""));
                    break;
                }
            
                linea = br.readLine();
            }
            br.close();

            if (codigoEncontrado) {
                int cantidad=Integer.parseInt(cantidadText.getText());
                double precioTotal = cantidad*precio;

                FileWriter escritor = new FileWriter("transacciones.txt",true);
                escritor.write(String.valueOf(codigo)+";"+nombre+";"+String.valueOf(precio)+";"+String.valueOf(cantidad)+";"+String.valueOf(precioTotal)+"\n");  

                escritor.close();

        for (int i = 0; i < tablaLista.getColumnCount(); i++) {
            nombresdeColumna[i]=tablaLista.getColumnName(i);
        }
        
        codigoText.setText("");
        cantidadText.setText("");
        nombreLabel.setText("Cuando ingrese el código presione Enter y aqui aparecerá el nombre.");
    } 
    else{
        JOptionPane.showMessageDialog(null, "Código de producto no encontrado.","Error",JOptionPane.ERROR_MESSAGE);
    }   


        //Leer archivo y actualizar la tabla

        File archivoTransaccion = new File("transacciones.txt"); 
        
        try{

            FileReader frTransaccion = new FileReader(archivoTransaccion);
       
            BufferedReader brTransaccion = new BufferedReader(frTransaccion);

             linea = brTransaccion.readLine();


            while(linea != null){
                String[] lineSplit=linea.split(";");
                model.addRow(lineSplit);
            
                linea = brTransaccion.readLine();
            }
            brTransaccion.close();

        }catch (IOException e){
            e.printStackTrace();
        }
        
        tablaLista.setModel(model);
        tablaLista.getColumnModel().getColumn(1).setPreferredWidth(190);
        tablaLista.getColumnModel().getColumn(3).setPreferredWidth(50);
             

        }catch (IOException e){
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad.");
            e.printStackTrace();
        }      
        tablaLista.setModel(model);
    }
}













    public static void eliminarDeLista(JTable tablaLista) {
        int[] filasSeleccionadas = tablaLista.getSelectedRows();
        
        if (filasSeleccionadas.length == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione uno o varios productos de la tabla para poder borrarlos.", "Error", JOptionPane.INFORMATION_MESSAGE);
            return;
        }else{



            //-------------------Mensaje de confirmación-------------------------
            //ahora se puede decidir si realmente se quieren borrar los productos, se pueden borrar varios productos.

            int n = JOptionPane.showConfirmDialog(null, "¿Seguro que desea borrar de la lista los productos seleccionados?\nNo se eliminarán del inventario", "Advertencia", JOptionPane.YES_NO_OPTION);

            if (n==0) {
                    File archivo = new File("transacciones.txt");
                    
                    try {
                        File temporal = new File("temporal.txt");
                        FileWriter writer = new FileWriter(temporal);
                        FileReader reader = new FileReader(archivo);
                        BufferedReader br = new BufferedReader(reader);
                        
                        String linea = br.readLine();
                        
                        while (linea != null) {
                            boolean seleccionada = false;
                            for (int i = 0; i < filasSeleccionadas.length; i++) {
                                int filaSeleccionada = filasSeleccionadas[i];
                                String[] datosFila = linea.split(";");
                                String codigoFila = datosFila[0];
                                
                                if (tablaLista.getValueAt(filaSeleccionada, 0).equals(codigoFila)) {
                                    seleccionada = true;
                                    break;
                                }
                            }
                            if (!seleccionada) {
                                writer.write(linea + "\n");
                            }
                            
                            linea = br.readLine();
                        }
                    
                        br.close();
                        reader.close();
                        writer.close();
                        archivo.delete();
                        temporal.renameTo(archivo);
                        
                        JOptionPane.showMessageDialog(null, "El/Los producto(s) se eliminaron de la lista","Exito",0);
                        
                    } catch (IOException e) {
                        JOptionPane.showMessageDialog(null, "Ha ocurrido un error al tratar de borrarr productos.");
                        e.printStackTrace();
                    }
            }
            

            ////////////////////////////Actualizar la tabla
            File archivoTransaccion = new File("transacciones.txt"); 
        
            String [] nombresdeColumna=new String[tablaLista.getColumnCount()];
        
                for (int i = 0; i < tablaLista.getColumnCount(); i++) {
        
                    nombresdeColumna[i]=tablaLista.getColumnName(i);
        
                }
        
            DefaultTableModel model = new DefaultTableModel(nombresdeColumna, 0){
                public boolean isCellEditable(int row, int column)
                    {
                        return false;//This causes all cells to be not editable
                    }
            };
                try{
        
                    FileReader frTransaccion = new FileReader(archivoTransaccion);
               
                    BufferedReader brTransaccion = new BufferedReader(frTransaccion);
        
                    String linea = brTransaccion.readLine();
        
        
                    while(linea != null){
                        String[] lineSplit=linea.split(";");
                        model.addRow(lineSplit);
                    
                        linea = brTransaccion.readLine();
                    }
                    brTransaccion.close();
        
                }catch (IOException e){
                    e.printStackTrace();
                }
                
                tablaLista.setModel(model);
                tablaLista.getColumnModel().getColumn(1).setPreferredWidth(190);
                tablaLista.getColumnModel().getColumn(3).setPreferredWidth(50);
       
        }
    }




















    public static void realizarCompra(JTable tablaLista) {
        // Obtener la fila seleccionada
        int filaSeleccionada = tablaLista.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para completar la compra.");
            return;
        }
        
        // Obtener el código del producto seleccionado
        String codigo = tablaLista.getValueAt(filaSeleccionada, 0).toString();
        
   
        String cantidadString = tablaLista.getValueAt(filaSeleccionada, 3).toString();

        
        try {
            int cantidad = Integer.parseInt(cantidadString);
            ArrayList<String> lineas = new ArrayList<String>();
            File archivo = new File("productos.txt");
            FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
            br.close();
            fr.close();
            
            boolean encontrado = false;

            for (int i= 0; i < lineas.size(); i++) {
                String[] datosProducto = lineas.get(i).split(";");
                String codigoProducto = datosProducto[0];
                int existenciasProducto = Integer.parseInt(datosProducto[4]);
                if (codigoProducto.equals(codigo)) {
                    encontrado = true;
                   
                    existenciasProducto += cantidad;
                    datosProducto[4] = String.valueOf(existenciasProducto);
                    lineas.set(i, String.join(";", datosProducto));
                    break;
                }
            }
        
            if (!encontrado) {
                JOptionPane.showMessageDialog(null, "El código de producto no fue encontrado.");
                return;
            }
            
            FileWriter fw = new FileWriter(archivo);
            for (int i = 0; i < lineas.size(); i++) {
                fw.write(lineas.get(i) + "\n");
            }
            fw.close();
           
        
    JOptionPane.showMessageDialog(null, "La compra fue realizada con exito.\nLos productos seleccionados han sido cargados al inventario.", "Compra", JOptionPane.INFORMATION_MESSAGE);
    
            
            // Actualizar tabla
            reiniciarTabla();
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar realizar la compra.");
            return;
        }
    } 













    

    public static void realizarVenta(JTable tablaLista) {
         //Editar el txt y bajar las existencias, presentar la factura en un JDialog o JOptionPane
       double precioTotal;
       // Obtener la fila seleccionada
       int filaSeleccionada = tablaLista.getSelectedRow();
       if (filaSeleccionada == -1) {
           JOptionPane.showMessageDialog(null, "Debe seleccionar un producto para realizar la venta.");
           return;
       }
       
       // Obtener el código del producto seleccionado
       String codigo = tablaLista.getValueAt(filaSeleccionada, 0).toString();
       
       // Pedir al usuario que ingrese la cantidad de productos que desea vender
       String cantidadString = JOptionPane.showInputDialog("Ingrese la cantidad de productos a vender:");
       if (cantidadString == null || cantidadString.trim().length() == 0) {
           JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.");
           return;
       }
       
       try {
           int cantidad = Integer.parseInt(cantidadString);
           ArrayList<String> lineas = new ArrayList<String>();
           File archivo = new File("productos.txt");
           FileReader fr = new FileReader(archivo);
           BufferedReader br = new BufferedReader(fr);
           String linea;
           while ((linea = br.readLine()) != null) {
               lineas.add(linea);
           }
           br.close();
           fr.close();
           
           boolean encontrado = false;
           
           for (int i = 0; i < lineas.size(); i++) {
               String[] datosProducto = lineas.get(i).split(";");
               String codigoProducto = datosProducto[0];
               int existenciasProducto = Integer.parseInt(datosProducto[4]);
               if (codigoProducto.equals(codigo)) {
                   encontrado = true;
                   if (existenciasProducto < cantidad) {
                       JOptionPane.showMessageDialog(null, "No hay suficientes existencias del producto para realizar la venta.");
                       return;
                   }
                   existenciasProducto += cantidad;
                   datosProducto[4] = String.valueOf(existenciasProducto);
                   lineas.set(i, String.join(";", datosProducto));
                   break;
               }
           }
           
           if (!encontrado) {
               JOptionPane.showMessageDialog(null, "El código de producto no fue encontrado.");
               return;
           }
           
           FileWriter fw = new FileWriter(archivo);
           for (int i = 0; i < lineas.size(); i++) {
               fw.write(lineas.get(i) + "\n");
           }
           fw.close();
           precioTotal= precio*cantidad;
          
       
           String factura = "<html><body><h1>FACTURA</h1>"
                  + "<table>"
                  + "<tr><td><b>Producto:</b></td><td>" + nombre + "</td></tr>"
                  + "<tr><td><b>Cantidad:</b></td><td>" + cantidad + "</td></tr>"
                  + "<tr><td><b>Precio:</b></td><td>" + precio + " lps.</td></tr>"
                  + "<tr><td><b>Total:</b></td><td>" + precioTotal + " lps.</td></tr>"
                  + "</table></body></html>";
   JOptionPane.showMessageDialog(null, factura, "Venta realizada con éxito", JOptionPane.INFORMATION_MESSAGE);
   
           
           // Actualizar tabla
            reiniciarTabla();
           
       } catch (NumberFormatException e) {
           JOptionPane.showMessageDialog(null, "Debe ingresar una cantidad válida.");
           return;
       } catch (IOException e) {
           e.printStackTrace();
           JOptionPane.showMessageDialog(null, "Hubo un error al intentar realizar la venta.");
           return;
       }
   } 







   //////para que cuando le demos comprar se nos borren los datos d ela lista y evitar que se repitan
   public static void reiniciarTabla(){
        File archivo = new File("transacciones.txt");
        archivo.delete();
        File nuevoArchivo = new File("transa-cciones.txt");
        nuevoArchivo.renameTo(nuevoArchivo);
   }

    //End of class
}


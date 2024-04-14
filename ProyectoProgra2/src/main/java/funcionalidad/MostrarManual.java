
package funcionalidad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JEditorPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLEditorKit;

public class MostrarManual {
 
    private static File archivo = new File("textoManual.html");
    
    public static void escribirManual(JEditorPane jp) throws FileNotFoundException, BadLocationException{
            
            jp.setEditable(false);
            jp.setEditorKit(new HTMLEditorKit());
            
            java.net.URL fileURL = null;
            try{
                fileURL = archivo.toURI().toURL();
            
                jp.setPage(fileURL);
                
            } catch (IOException ex){
                ex.printStackTrace();
            }
    }
}

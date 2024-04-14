package funcionalidad;

import java.util.Locale;

public class Producto {
    private int codigo;
    private String nombre;
    private double precio;
    private String categoria;
    private int existencias;
    
    public Producto(int codigo, String nombre, double precio, String categoria, int existencias) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.categoria = categoria;
        this.existencias = existencias;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setExistencias(int existencias) {
        this.existencias = existencias;
    }

    private String formatoPrecio(){
        return String.format(Locale.US, "%,9.2f", precio);
    }

    @Override
    public String toString() {
        return codigo + ";" + nombre + ";" + formatoPrecio() + ";" + categoria
                + ";" + existencias + "\n";
    }

    

}
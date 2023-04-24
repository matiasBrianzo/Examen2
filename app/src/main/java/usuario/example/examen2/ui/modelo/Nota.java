package usuario.example.examen2.ui.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Nota implements Serializable {
    private String nombre;
    private String descripcion;
    private String nota;


    public Nota(String nombre, String descripcion, String nota) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nota = nota;

    }

    public Nota() {

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public List<Nota> getListadoNota() {
        ArrayList<Nota> lista = new ArrayList<>();
        lista.add(new Nota("Matias", "Materia : Matematica", " 10"));
        lista.add(new Nota("juan", "Materia : Lengua", " 10"));
        lista.add(new Nota("Pedro", "Materia : Computacion", " 10"));
        lista.add(new Nota("Tomas", "Materia : Lenguaje de Programacion", " 10"));
        lista.add(new Nota("Fe", "Materia : Historia de la Computaciom", " 10"));
        return lista;
    }
}
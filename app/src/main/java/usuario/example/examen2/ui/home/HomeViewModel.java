package usuario.example.examen2.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

import usuario.example.examen2.ui.modelo.Nota;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Nota>> ListadoNota;
  private  ArrayList<Nota>  notaArrayList;
    public HomeViewModel() {
        notaArrayList = new ArrayList<>();
    }

    public LiveData<ArrayList<Nota>> getLista() {
        if (ListadoNota == null) {
            ListadoNota = new MutableLiveData<>();
        }
        return ListadoNota;
    }

     public void crearListadoNota(){

         notaArrayList.add(new Nota("Matias", "Materia : Matematica", " 10"));
         notaArrayList.add(new Nota("juan", "Materia : Lengua", " 10"));
         notaArrayList.add(new Nota("Pedro", "Materia : Computacion", " 10"));
         notaArrayList.add(new Nota("Tomas", "Materia : Lenguaje de Programacion", " 10"));
         notaArrayList.add(new Nota("Fe", "Materia : Historia de la Computaciom", " 10"));

       //  ListadoNota.getValue().clear();
         ListadoNota.setValue(notaArrayList);



    }
}
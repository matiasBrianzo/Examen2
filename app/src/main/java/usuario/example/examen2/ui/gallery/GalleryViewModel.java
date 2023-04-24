package usuario.example.examen2.ui.gallery;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import usuario.example.examen2.databinding.FragmentGalleryBinding;
import usuario.example.examen2.ui.modelo.Nota;

public class GalleryViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public GalleryViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is gallery fragment");
    }
    public void CargarListaConDetalle(FragmentGalleryBinding binding, Nota nota)
    {
        binding.tvNombreAlumno.setText(nota.getNombre());
        binding.tvDescripcion.setText(nota.getDescripcion());
        binding.tvNota.setText(nota.getNota());

    }

    public LiveData<String> getText() {
        return mText;
    }
}
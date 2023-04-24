package usuario.example.examen2.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import usuario.example.examen2.databinding.FragmentGalleryBinding;
import usuario.example.examen2.ui.modelo.Nota;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    private Nota nota;
    private GalleryViewModel vm ;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm =new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (getArguments() != null) {
            nota = (Nota) getArguments().getSerializable("actividad");
            vm.CargarListaConDetalle(binding,nota);
        }
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
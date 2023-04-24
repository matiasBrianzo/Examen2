package usuario.example.examen2.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Date;

import usuario.example.examen2.R;
import usuario.example.examen2.databinding.FragmentHomeBinding;
import usuario.example.examen2.ui.modelo.Nota;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    private HomeViewModel vm;
  private View root;
    private RecyclerView rvLista;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(HomeViewModel.class);
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        root = binding.getRoot();

        rvLista = root.findViewById(R.id.rvLista);

        GridLayoutManager grilla = new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false);
        rvLista.setLayoutManager(grilla);
        vm.getLista().observe(getViewLifecycleOwner(), new Observer<ArrayList<Nota>>() {
            @Override
            public void onChanged(ArrayList<Nota> notas) {
                ListaNotasAdapter adapter = new ListaNotasAdapter(getContext(), notas, getLayoutInflater());
                rvLista.setAdapter(adapter);
            }
        });
        vm.crearListadoNota();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
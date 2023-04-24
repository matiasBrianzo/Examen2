package usuario.example.examen2.ui.home;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import usuario.example.examen2.R;
import usuario.example.examen2.ui.modelo.Nota;

public class ListaNotasAdapter extends RecyclerView.Adapter<ListaNotasAdapter.ViewHolder> {

    private Context context;
    private List<Nota> notas;
    private LayoutInflater inflater;

    public ListaNotasAdapter(Context context, List<Nota> notas, LayoutInflater inflater) {
        this.context = context;
        this.notas = notas;
        this.inflater = inflater;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = inflater.inflate(R.layout.item_actividad, parent, false);
        return new ViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Nota nota = notas.get(position);
        holder.nombre.setText(nota.getNombre());
        holder.tvNota.setText(nota.getNota());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Abrir el fragmento de detalle y pasar la información de la actividad
                Fragment fragment = new HomeFragment();
                Bundle args = new Bundle();
                args.putSerializable("actividad", nota);
                fragment.setArguments(args);
                FragmentTransaction transaction = ((FragmentActivity) context).getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameLayout2, fragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

    }

    @Override
    public int getItemCount() {
        return notas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nombre, tvNota, hora;
        Button btnDetalleActividad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombreAlumno);
            tvNota = itemView.findViewById(R.id.tvNota);
            btnDetalleActividad = itemView.findViewById(R.id.btnDetalleActividad);

            btnDetalleActividad.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Abrir la vista de detalles de la actividad
                    Bundle args = new Bundle();
                    args.putSerializable("actividad", notas.get(getAdapterPosition()));
                    Log.d("salida" , args+"");
                    Navigation.findNavController((Activity) context, R.id.nav_host_fragment_content_main).navigate(R.id.nav_gallery, args);
                }
            });
        }
    }
}

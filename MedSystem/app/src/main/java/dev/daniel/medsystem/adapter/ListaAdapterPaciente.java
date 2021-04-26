package dev.daniel.medsystem.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import dev.daniel.medsystem.Classes.Paciente;
import dev.daniel.medsystem.R;

public class ListaAdapterPaciente  extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Paciente> pacientes;
    private static ClickListener clickListener;

    public ListaAdapterPaciente(Context context, ArrayList<Paciente> pacientes) {

        this.context = context;
        this.pacientes = pacientes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.linhapaciente,
                parent, false);
        ViewHolder holder =  new ViewHolder(view);
        return holder;

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        ViewHolder h = (ViewHolder) holder;
        Paciente paciente = pacientes.get(position);
        h.tvnome.setText(paciente.getNome());
        h.tvcodigo.setText(paciente.getId());

    }

    @Override
    public int getItemCount() {
        return pacientes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        private TextView tvnome;
        private TextView tvcodigo;

        public ViewHolder(View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);

            tvnome = (TextView) itemView.findViewById(R.id.tvnome);
            tvcodigo = (TextView) itemView.findViewById(R.id.tvid);

        }
        @Override
        public void onClick(View view) {
            clickListener.onItemClick(getAdapterPosition(), view);
        }

        @Override
        public boolean onLongClick(View view) {
            clickListener.onItemLongClick(getAdapterPosition(), view);
            return true;
        }


    }

    public void setOnItemClickListener(ClickListener clickListener) {
        ListaAdapterPaciente.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(int position, View v);
        void onItemLongClick(int position, View v);
    }
}

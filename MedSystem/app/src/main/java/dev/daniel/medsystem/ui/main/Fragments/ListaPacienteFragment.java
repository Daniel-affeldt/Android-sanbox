package dev.daniel.medsystem.ui.main.Fragments;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import dev.daniel.medsystem.Classes.Paciente;
import dev.daniel.medsystem.DAO.PacienteSQL;
import dev.daniel.medsystem.R;
import dev.daniel.medsystem.adapter.ListaAdapterPaciente;

import static android.widget.Toast.LENGTH_SHORT;


public class ListaPacienteFragment extends Fragment {

    private RecyclerView recyclerViewEditaClientes;
    private ListaAdapterPaciente adapterpaciente;
    private ArrayList<Paciente> listapaciente;
    PacienteSQL pacienteSQL;

    Button btnConsultar;

    public void Fragment_editar_cliente() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_paci_fragment, container, false);
        pacienteSQL = new PacienteSQL(getContext());
        pacienteSQL.abrirBanco();

        recyclerViewEditaClientes = (RecyclerView) view.findViewById(R.id.RecyclerViewPaciente);
        listapaciente = new ArrayList<>();
        adapterpaciente = new ListaAdapterPaciente(getContext(), listapaciente);
        recyclerViewEditaClientes.setAdapter(adapterpaciente);
        recyclerViewEditaClientes.setHasFixedSize(true);
        recyclerViewEditaClientes.setLayoutManager(new LinearLayoutManager(getContext()));

        btnConsultar = (Button) view.findViewById(R.id.BtnPesquisarPaciente);
        btnConsultar.requestFocus();

        EditText editConsulta = (EditText) view.findViewById(R.id.EdtTextPaciente);

        editConsulta.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                String filtro = editConsulta.getText().toString().trim();
                listapaciente.clear();
                listapaciente.addAll(pacienteSQL.listaTodosPacientes(filtro, getContext()));
                adapterpaciente.notifyDataSetChanged();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PacienteSQL pacienteSQL = new PacienteSQL(getContext());
                String filtro = editConsulta.getText().toString().trim();

                listapaciente.clear();
                listapaciente.addAll(pacienteSQL.listaTodosPacientes(filtro, getContext()));
                adapterpaciente.notifyDataSetChanged();
      }
        });


        adapterpaciente.setOnItemClickListener(new ListaAdapterPaciente.ClickListener() {

            @Override
            public void onItemClick(int position, View v) {

                //Toast.makeText(getActivity(),"botão", LENGTH_SHORT).show();
                //Toast.makeText(getActivity(),"botão"+getContext().toString(), LENGTH_SHORT).show();
                //SolicitaDadosClientesDetalhe(listaCLientes.get(position));

            }

            @Override
            public void onItemLongClick(int position, View v) {

                new AlertDialog.Builder(getContext())
                        .setTitle("O que deseja fazer com o cliente ?")
                        .setMessage("Editar ou excluir o cliente: " + listapaciente.get(position).getNome())

                        .setPositiveButton("editar", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int which) {

                                Bundle b = new Bundle();

                                b.putString("nome", listapaciente.get(position).getNome());
                                b.putString("id", listapaciente.get(position).getId());
                                b.putString("cpf", listapaciente.get(position).getCpf());
                                b.putString("rg", listapaciente.get(position).getRg());
                                b.putString("nascimento", listapaciente.get(position).getNascimento());
                                b.putString("estadocivil", listapaciente.get(position).getEstadocivil());
                                b.putString("telefone", listapaciente.get(position).getTelefone());
                                b.putString("email", listapaciente.get(position).getEmail());
                                b.putString("endereco", listapaciente.get(position).getEndereco());

                                PacienteFragment frag = new PacienteFragment();
                                frag.setArguments(b);

                                FragmentManager fragmentManager = getParentFragmentManager();
                                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                fragmentTransaction.replace(R.id.framepacientefragment, frag);

                                fragmentTransaction.addToBackStack(null);
                                fragmentTransaction.commit();
                                ViewPager viewPager = (ViewPager) getActivity().findViewById(R.id.view_pager);
                                viewPager.setCurrentItem(0);


                            }
                        })
                        .setNegativeButton("excluir", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Log.d("exc", "excluir");

                                PacienteSQL pacienteSQL = new PacienteSQL(getContext());
                                pacienteSQL.excluiPaciente(listapaciente.get(position).getId());

                            }
                        })
                        .show();
            }
        });

        return view;

    }
}






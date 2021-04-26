package dev.daniel.medsystem.ui.main.Fragments;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


import com.google.android.material.snackbar.Snackbar;

import dev.daniel.medsystem.Classes.Paciente;
import dev.daniel.medsystem.DAO.PacienteSQL;
import dev.daniel.medsystem.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PacienteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PacienteFragment extends Fragment {

    EditText edtclientenome;
    EditText edttextcpf;
    EditText edttextrg;
    EditText edtnascimento;
    Spinner edtestadocivil;
    EditText edttelefone;
    EditText edtemail;
    EditText edtendereco;


    String nomepaciente;
    String id, nascimento, endereco, telefone, cpf, rg, estadocivil, email;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PacienteFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentPaciente.
     */
    // TODO: Rename and change types and number of parameters
    public static PacienteFragment newInstance(String param1, String param2) {
        PacienteFragment fragment = new PacienteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);

        }
        Bundle bundle = this.getArguments();

        if (bundle != null) {

            nomepaciente = bundle.getString("nome");
            id = bundle.getString("id");
            cpf = bundle.getString("cpf");
            rg = bundle.getString("rg");
            nascimento = bundle.getString("nascimento");
            estadocivil = bundle.getString("estadocivil");
            telefone = bundle.getString("telefone");
            email = bundle.getString("email");
            endereco = bundle.getString("endereco");

            bundle.clear();
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_paciente, container, false);

        edtclientenome = (EditText) view.findViewById(R.id.editnomepaciente);
        edttextcpf = (EditText) view.findViewById(R.id.edttextcpf);
        edttextrg = (EditText) view.findViewById(R.id.edttextrg);
        edtnascimento = (EditText) view.findViewById(R.id.edtnascimento);
        edtestadocivil = (Spinner) view.findViewById(R.id.spnestadocivil);
        edttelefone = (EditText) view.findViewById(R.id.editTexTelefone);
        edtemail = (EditText) view.findViewById(R.id.edtemail);
        edtendereco = (EditText) view.findViewById(R.id.edtendereco);


        if (id != null) {

            edtclientenome.setText(nomepaciente);
            edtendereco.setText(endereco);
            edttelefone.setText(telefone);
            edtnascimento.setText(nascimento);
            edtclientenome.setText(nomepaciente);
            edttextcpf.setText(cpf);
            edttextrg.setText(rg);
            edtnascimento.setText(nascimento);
            edtemail.setText(email);

            switch (estadocivil) {

                case "Solteiro(a)":
                    edtestadocivil.setSelection(0);
                    break;
                case "Divorciado(a)":
                    edtestadocivil.setSelection(1);
                    break;
                case "Casado(a)":
                    edtestadocivil.setSelection(2);
                    break;
            }


        }

        Button buttonsalvar = (Button) view.findViewById(R.id.buttonsalvar);

        buttonsalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(view, "Botao listener", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Paciente paciente = new Paciente();


                paciente.setNome(edtclientenome.getText().toString());
                paciente.setCpf(edttextcpf.getText().toString());
                paciente.setRg(edttextrg.getText().toString());
                paciente.setNascimento(edtnascimento.getText().toString());
                paciente.setEstadocivil(edtestadocivil.getSelectedItem().toString());
                paciente.setTelefone(edttelefone.getText().toString());
                paciente.setEmail(edtemail.getText().toString());
                paciente.setEndereco(edtendereco.getText().toString());

                PacienteSQL pacienteSQL = new PacienteSQL(getContext());


                if (id != null) {
                    paciente.setId(id);
                    pacienteSQL.updtPaciente(paciente);
                } else {
                    paciente.setId(null);
                    pacienteSQL.addPaciente(paciente);
                }

                edtclientenome.setText("");
                edtendereco.setText("");
                edttelefone.setText("");
                edtnascimento.setText("");
                edtclientenome.setText("");
                edttextcpf.setText("");
                edttextrg.setText("");
                edtnascimento.setText("");
                edtestadocivil.setSelection(0);
                edtemail.setText("");


            }
        });

        return view;
    }


}
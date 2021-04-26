package dev.daniel.medsystem.DAO;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.daniel.medsystem.Classes.Paciente;

public class PacienteSQL {

    PacienteDB pacienteDB = new PacienteDB();

    private SQLiteDatabase database;
    private BancoDados dbHelper;

    public PacienteSQL(Context context) {
        dbHelper = new BancoDados(context);
    }

    public void abrirBanco() {
        database = dbHelper.getWritableDatabase();
    }

    ;

    public void fecharBanco() {
        dbHelper.close();
    }


    public List<Paciente> listaTodosPacientes(String filtro, Context context) {
        List<Paciente> listaPacientes = new ArrayList<>();

        String query = "SELECT * FROM " + pacienteDB.getTabelaPaciente();

        if (!filtro.isEmpty()) {
            query = query + " where " + pacienteDB.getColunaNome() + " like '%" + filtro + "%' OR "
                    + pacienteDB.getColunaIdPaciente() + " like '%" + filtro + "%'";

        }

        abrirBanco();
        Cursor c = database.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {

                Paciente pacienteResult = new Paciente();
                pacienteResult.setId(c.getString(0));
                pacienteResult.setNome(c.getString(1));
                pacienteResult.setCpf(c.getString(2));
                pacienteResult.setRg(c.getString(3));
                pacienteResult.setNascimento(c.getString(4));
                pacienteResult.setEstadocivil(c.getString(5));
                pacienteResult.setEmail(c.getString(6));
                pacienteResult.setEndereco(c.getString(7));
                pacienteResult.setTelefone(c.getString(8));

                listaPacientes.add(pacienteResult);
            } while (c.moveToNext());
        }
        fecharBanco();
        c.close();

        return listaPacientes;
    }

    public void addPacientes(ArrayList<Paciente> pacientes) {
        ContentValues values = new ContentValues();
        abrirBanco();

        for (Paciente pacie : pacientes) {

            values.put(pacienteDB.getColunaIdPaciente(), pacie.getId());
            values.put(pacienteDB.getColunaNome(), pacie.getNome());
            values.put(pacienteDB.getColunaCpf(), pacie.getCpf());
            values.put(pacienteDB.getColunaRg(), pacie.getRg());
            values.put(pacienteDB.getColunaEmail(), pacie.getEmail());

            values.put(pacienteDB.getColunaTelefone(), pacie.getTelefone());
            values.put(pacienteDB.getColunaEndereco(), pacie.getEndereco());
            values.put(pacienteDB.getColunaNascimento(), pacie.getNascimento());
            values.put(pacienteDB.getColunaEstadocivil(), pacie.getEstadocivil());

            database.insert(pacienteDB.getTabelaPaciente(), null, values);
        }
        database.close();
        fecharBanco();
    }


    public void addPaciente(Paciente pacie) {

        abrirBanco();
        ContentValues values = new ContentValues();

        values.put(pacienteDB.getColunaIdPaciente(), pacie.getId());
        values.put(pacienteDB.getColunaNome(), pacie.getNome());
        values.put(pacienteDB.getColunaCpf(), pacie.getCpf());
        values.put(pacienteDB.getColunaRg(), pacie.getRg());
        values.put(pacienteDB.getColunaEmail(), pacie.getEmail());

        values.put(pacienteDB.getColunaTelefone(), pacie.getTelefone());
        values.put(pacienteDB.getColunaEndereco(), pacie.getEndereco());
        values.put(pacienteDB.getColunaNascimento(), pacie.getNascimento());
        values.put(pacienteDB.getColunaEstadocivil(), pacie.getEstadocivil());

        database.insert(pacienteDB.getTabelaPaciente(), null, values);

        database.close();
        fecharBanco();
    }

    public void updtPaciente(Paciente pacie) {

        abrirBanco();
        ContentValues values = new ContentValues();

        values.put(pacienteDB.getColunaIdPaciente(), pacie.getId());
        values.put(pacienteDB.getColunaNome(), pacie.getNome());
        values.put(pacienteDB.getColunaCpf(), pacie.getCpf());
        values.put(pacienteDB.getColunaRg(), pacie.getRg());
        values.put(pacienteDB.getColunaEmail(), pacie.getEmail());

        values.put(pacienteDB.getColunaTelefone(), pacie.getTelefone());
        values.put(pacienteDB.getColunaEndereco(), pacie.getEndereco());
        values.put(pacienteDB.getColunaNascimento(), pacie.getNascimento());
        values.put(pacienteDB.getColunaEstadocivil(), pacie.getEstadocivil());
        database.update(pacienteDB.getTabelaPaciente(), values, pacienteDB.getColunaIdPaciente() + "=?", new String[]{pacie.getId()});

        database.close();
        fecharBanco();
    }

    public Paciente pacienteDetalhe(Paciente paciente, Context context) {

        String query = "SELECT * FROM " + pacienteDB.getTabelaPaciente() + " where " + pacienteDB.getColunaIdPaciente() + " = '" + paciente.getId() + "'";

        abrirBanco();
        Cursor c = database.rawQuery(query, null);

        if (c.moveToFirst()) {
            do {

                paciente.setId(c.getString(0));
                paciente.setNome(c.getString(1));
                paciente.setNascimento(c.getString(2));
                paciente.setTelefone(c.getString(3));
                paciente.setEndereco(c.getString(4));
                paciente.setEmail(c.getString(5));


            } while (c.moveToNext());
        }
        fecharBanco();
        c.close();
        return paciente;
    }

    public boolean excluiPaciente(String codigo) {
        abrirBanco();
        String queryitem = "DELETE FROM " + PacienteDB.getTabelaPaciente() + " where " +
                PacienteDB.getColunaIdPaciente() + "='" + codigo + "'";
        Cursor c = database.rawQuery(queryitem, null);
        c.moveToFirst();

        return true;
    }
}


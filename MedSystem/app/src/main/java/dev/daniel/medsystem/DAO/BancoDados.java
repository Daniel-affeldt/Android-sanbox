package dev.daniel.medsystem.DAO;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDados extends SQLiteOpenHelper {

    private static final int VERSAO_BANCO = 1;
    private static final String BANCO_CONSULTA = "prontuario.db";

    PacienteDB pacienteDB = new PacienteDB();
    ProntuarioDB prontuarioDB = new ProntuarioDB();

    public BancoDados(Context context) {
        super(context, BANCO_CONSULTA, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String QUERYCRIATABELA = " CREATE TABLE " + pacienteDB.getTabelaPaciente() + " ( " +

                pacienteDB.getColunaIdPaciente() + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                pacienteDB.getColunaNome() + " VARCHAR(35), " +
                pacienteDB.getColunaCpf() + " VARCHAR(35), " +
                pacienteDB.getColunaRg() + " VARCHAR(35), " +
                pacienteDB.getColunaNascimento() + " VARCHAR(35), " +
                pacienteDB.getColunaEstadocivil() + " VARCHAR(35), " +
                pacienteDB.getColunaEmail() + " VARCHAR(35), " +
                pacienteDB.getColunaEndereco() + " VARCHAR(35), " +
                pacienteDB.getColunaTelefone() + " VARCHAR(35), " +
                pacienteDB.getColunaObservacao() + " VARCHAR(35)) ";

        db.execSQL(QUERYCRIATABELA);
//
//        String QUERY_CRIATABELA = "CREATE TABLE " + ProntuarioDB.getTabelaProntuario() + " ( "
//                + prontuarioDB.getColunaIdprontuario() + " INTEGER PRIMARY KEY AUTOINCREMENT , "
//                + prontuarioDB.getColunaIdnome() + " VARCHAR(35), "
//                + prontuarioDB.getColunaIdcliente() + " VARCHAR(35), "
//                + prontuarioDB.getCOLUNA_data() + " VARCHAR(35), "
//
//
//                + prontuarioDB.getCOLUNA_l_od_esph() + "  VARCHAR(35), "
//                + prontuarioDB.getCOLUNA_l_od_cyl() + "  VARCHAR(35), "
//                + prontuarioDB.getCOLUNA_l_od_ax() + "  VARCHAR(35), "
//                + prontuarioDB.getCOLUNA_l_od_a1() + " VARCHAR(35) ";
//
//        db.execSQL(QUERY_CRIATABELA);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }


}





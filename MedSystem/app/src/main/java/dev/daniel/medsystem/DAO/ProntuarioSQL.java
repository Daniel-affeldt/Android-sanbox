package dev.daniel.medsystem.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import dev.daniel.medsystem.Classes.Prontuario;


public class ProntuarioSQL {

    

        ProntuarioDB ProntuarioDB = new ProntuarioDB();

        private SQLiteDatabase database;
        private BancoDados pront;

        public ProntuarioSQL(Context context){  pront = new BancoDados(context); }

        public void abrirBanco(){database = pront.getWritableDatabase();};
        public void fecharBanco(){
            pront.close();
        }


        public List<Prontuario> listaTodosProntuario(String filtro, Context context){
            List<Prontuario> listaProntuario = new ArrayList<>();

            String query = "SELECT * FROM " + ProntuarioDB.getTabelaProntuario();

            if (!filtro.isEmpty()){
                query = query + " where " +  ProntuarioDB.getColunaIdnome() +" like '%"+filtro+"%' OR "
                        + ProntuarioDB.getColunaIdcliente()+" like '%"+filtro+"%'";

            }

            abrirBanco();
            Cursor c = database.rawQuery(query, null);

            if(c.moveToFirst()){
                do {

                    Prontuario prontuarioResult = new Prontuario();
                    prontuarioResult.setId(c.getString(0));
                    prontuarioResult.setClienteid(c.getString(2));
                    prontuarioResult.setClientenome(c.getString(1));
                    prontuarioResult.setData(c.getString(3));

                    prontuarioResult.setL_od_esph(c.getString(4));
                    prontuarioResult.setL_od_cyl(c.getString(5));
                    prontuarioResult.setL_od_ax(c.getString(6));
                    prontuarioResult.setL_od_a1(c.getString(7));
                    prontuarioResult.setL_od_a2(c.getString(8));
                    prontuarioResult.setL_od_sc(c.getString(9));
                    prontuarioResult.setL_od_cc(c.getString(10));


                    prontuarioResult.setL_oe_a1(c.getString(11));
                    prontuarioResult.setL_oe_a2(c.getString(12));
                    prontuarioResult.setL_oe_ax(c.getString(13));
                    prontuarioResult.setL_oe_cyl(c.getString(14));
                    prontuarioResult.setL_oe_esph(c.getString(15));
                    prontuarioResult.setL_oe_sc(c.getString(16));
                    prontuarioResult.setL_oe_cc(c.getString(17));

                    prontuarioResult.setQ_od1(c.getString(18));
                    prontuarioResult.setQ_od2(c.getString(19));
                    prontuarioResult.setQ_od_g(c.getString(20));
                    prontuarioResult.setQ_oe1(c.getString(21));
                    prontuarioResult.setQ_oe2(c.getString(22));
                    prontuarioResult.setQ_oe_g(c.getString(23));

                    prontuarioResult.setP_lente(c.getString(24));
                    prontuarioResult.setAdd(c.getString(25));
                    prontuarioResult.setDp(c.getString(26));

                    listaProntuario.add(prontuarioResult);
                } while (c.moveToNext());
            }
            fecharBanco();
            c.close();
            return  listaProntuario;
        }

        public void addprontuario(Prontuario pront){
            ContentValues values = new ContentValues();
            abrirBanco();



                values.put(ProntuarioDB.getColunaIdcliente(), pront.getClienteid());
                values.put(ProntuarioDB.getColunaIdnome(), pront.getClientenome());
                values.put(ProntuarioDB.getColunaIdprontuario(), pront.getId());
                values.put(ProntuarioDB.getCOLUNA_data(), pront.getData());

                values.put(ProntuarioDB.getCOLUNA_l_od_a1(), pront.getL_od_a1());
                values.put(ProntuarioDB.getCOLUNA_l_od_a2(), pront.getL_od_a2());
                values.put(ProntuarioDB.getCOLUNA_l_od_ax(), pront.getL_od_ax());
                values.put(ProntuarioDB.getCOLUNA_l_od_cyl(), pront.getL_od_cyl());
                values.put(ProntuarioDB.getCOLUNA_l_od_esph(), pront.getL_od_esph());
                values.put(ProntuarioDB.getCOLUNA_l_od_sc(), pront.getL_od_sc());
                values.put(ProntuarioDB.getCOLUNA_l_od_cc(), pront.getL_od_cc());


                values.put(ProntuarioDB.getCOLUNA_l_oe_a1(), pront.getL_oe_a1());
                values.put(ProntuarioDB.getCOLUNA_l_oe_a2(), pront.getL_oe_a2());
                values.put(ProntuarioDB.getCOLUNA_l_oe_ax(), pront.getL_oe_ax());
                values.put(ProntuarioDB.getCOLUNA_l_oe_cyl(), pront.getL_oe_cyl());
                values.put(ProntuarioDB.getCOLUNA_l_oe_esph(), pront.getL_oe_esph());
                values.put(ProntuarioDB.getCOLUNA_l_oe_sc(), pront.getL_oe_sc());
                values.put(ProntuarioDB.getCOLUNA_l_oe_cc(), pront.getL_oe_cc());


                values.put(ProntuarioDB.getCOLUNA_q_od1(), pront.getQ_od1());
                values.put(ProntuarioDB.getCOLUNA_q_od2(), pront.getQ_od2());
                values.put(ProntuarioDB.getCOLUNA_q_od_g(), pront.getQ_od_g());
                values.put(ProntuarioDB.getCOLUNA_q_oe1(),  pront.getQ_oe1());
                values.put(ProntuarioDB.getCOLUNA_q_oe2(), pront.getQ_oe2());
                values.put(ProntuarioDB.getCOLUNA_q_oe_g(), pront.getQ_oe_g());

                values.put(ProntuarioDB.getCOLUNA_p_lente(), pront.getP_lente());
                values.put(ProntuarioDB.getCOLUNA_add(), pront.getAdd());
                values.put(ProntuarioDB.getCOLUNA_dp(), pront.getDp());

                database.insert(ProntuarioDB.getTabelaProntuario(),null, values);

            database.close();
            fecharBanco();
        }





        public Prontuario ProntuarioDetalhe(Prontuario prontuario, Context context){

            String query = "SELECT * FROM " + ProntuarioDB.getTabelaProntuario() + " where "+ ProntuarioDB.getColunaIdcliente()+" = '"+prontuario.getId()+"'";

            abrirBanco();
            Cursor c = database.rawQuery(query, null);

            if(c.moveToFirst()){
                do {


                    Prontuario prontuarioResult = new Prontuario();
                    prontuarioResult.setId(c.getString(0));
                    prontuarioResult.setClienteid(c.getString(2));
                    prontuarioResult.setClientenome(c.getString(1));
                    prontuarioResult.setData(c.getString(3));

                    prontuarioResult.setL_od_esph(c.getString(4));
                    prontuarioResult.setL_od_cyl(c.getString(5));
                    prontuarioResult.setL_od_ax(c.getString(6));
                    prontuarioResult.setL_od_a1(c.getString(7));
                    prontuarioResult.setL_od_a2(c.getString(8));
                    prontuarioResult.setL_od_sc(c.getString(9));
                    prontuarioResult.setL_od_cc(c.getString(10));


                    prontuarioResult.setL_oe_a1(c.getString(11));
                    prontuarioResult.setL_oe_a2(c.getString(12));
                    prontuarioResult.setL_oe_ax(c.getString(13));
                    prontuarioResult.setL_oe_cyl(c.getString(14));
                    prontuarioResult.setL_oe_esph(c.getString(15));
                    prontuarioResult.setL_oe_sc(c.getString(16));
                    prontuarioResult.setL_oe_cc(c.getString(17));

                    prontuarioResult.setQ_od1(c.getString(18));
                    prontuarioResult.setQ_od2(c.getString(19));
                    prontuarioResult.setQ_od_g(c.getString(20));
                    prontuarioResult.setQ_oe1(c.getString(21));
                    prontuarioResult.setQ_oe2(c.getString(22));
                    prontuarioResult.setQ_oe_g(c.getString(23));

                    prontuarioResult.setP_lente(c.getString(24));
                    prontuarioResult.setAdd(c.getString(25));
                    prontuarioResult.setDp(c.getString(26));





                } while (c.moveToNext());
            }
            fecharBanco();
            c.close();
            return  prontuario;
        }
}


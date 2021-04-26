package dev.daniel.medsystem.DAO;





public class ProntuarioDB {


    private static final String TABELA_PRONTUARIO = "tb_prontuario";//
    private static final String COLUNA_IDPRONTUARIO = "IDPRONTUARIO"; //0
    private static final String COLUNA_IDNOME ="IDNOME"; //1
    private static final String COLUNA_IDCLIENTE ="IDCLIENTE"; //2

    private static final String COLUNA_l_od_esph ="l_od_esph"; //3
    private static final String COLUNA_l_od_cyl ="l_od_cyl";   //4
    private static final String COLUNA_l_od_ax ="l_od_ax";     //5
    private static final String COLUNA_l_od_a1 ="l_od_a1";     //6
    private static final String COLUNA_l_od_sc ="l_od_sc";     //7
    private static final String COLUNA_l_od_cc ="l_od_cc";     //8
    private static final String COLUNA_l_od_a2 ="l_od_a2";     //9
    private static final String COLUNA_l_oe_esph ="l_oe_esph"; //10
    private static final String COLUNA_l_oe_cyl ="l_oe_cyl";   //11
    private static final String COLUNA_l_oe_ax ="l_oe_ax";     //12
    private static final String COLUNA_l_oe_a1 ="l_oe_a1";     //13
    private static final String COLUNA_l_oe_sc ="l_oe_sc";     //14
    private static final String COLUNA_l_oe_cc ="l_oe_cc";     //15
    private static final String COLUNA_l_oe_a2 ="l_oe_a2";     //16
    private static final String COLUNA_q_od1 ="q_od1";         //17
    private static final String COLUNA_q_od2 ="q_od2";         //18
    private static final String COLUNA_q_od_g ="q_od_g";       //19
    private static final String COLUNA_q_oe1 ="q_oe1";         //20
    private static final String COLUNA_q_oe2 ="q_oe2";         //21
    private static final String COLUNA_q_oe_g ="q_oe_g";       //22
    private static final String COLUNA_p_lente ="p_lente";     //23
    private static final String COLUNA_data ="data";           //24
    private static final String COLUNA_add ="L_add";           //25
    private static final String COLUNA_dp ="dp";               //26





    public static String getColunaIdprontuario() {
        return COLUNA_IDPRONTUARIO;
    }

    public static String getColunaIdcliente() {
        return COLUNA_IDCLIENTE;
    }

    public static String getColunaIdnome() {
        return COLUNA_IDNOME;
    }

    public static String getCOLUNA_l_od_esph() {
        return COLUNA_l_od_esph;
    }

    public static String getCOLUNA_l_od_cyl() {
        return COLUNA_l_od_cyl;
    }

    public static String getCOLUNA_l_od_ax() {
        return COLUNA_l_od_ax;
    }

    public static String getCOLUNA_l_od_a1() {
        return COLUNA_l_od_a1;
    }

    public static String getCOLUNA_l_od_sc() {
        return COLUNA_l_od_sc;
    }

    public static String getCOLUNA_l_od_a2() {
        return COLUNA_l_od_a2;
    }

    public static String getCOLUNA_l_oe_esph() {
        return COLUNA_l_oe_esph;
    }

    public static String getCOLUNA_l_oe_cyl() {
        return COLUNA_l_oe_cyl;
    }

    public static String getCOLUNA_l_oe_ax() {
        return COLUNA_l_oe_ax;
    }

    public static String getCOLUNA_l_oe_a1() {
        return COLUNA_l_oe_a1;
    }

    public static String getCOLUNA_l_oe_sc() {
        return COLUNA_l_oe_sc;
    }

    public static String getCOLUNA_l_oe_a2() {
        return COLUNA_l_oe_a2;
    }

    public static String getCOLUNA_q_od1() {
        return COLUNA_q_od1;
    }

    public static String getCOLUNA_q_od2() {
        return COLUNA_q_od2;
    }

    public static String getCOLUNA_q_od_g() {
        return COLUNA_q_od_g;
    }

    public static String getCOLUNA_q_oe1() {
        return COLUNA_q_oe1;
    }

    public static String getCOLUNA_q_oe2() {
        return COLUNA_q_oe2;
    }

    public static String getCOLUNA_q_oe_g() {
        return COLUNA_q_oe_g;
    }

    public static String getCOLUNA_p_lente() {
        return COLUNA_p_lente;
    }

    public static String getCOLUNA_data() {
        return COLUNA_data;
    }

    public static String getTabelaProntuario() {
        return TABELA_PRONTUARIO;
    }

    public static String getCOLUNA_add() {
        return COLUNA_add;
    }

    public static String getCOLUNA_dp() {
        return COLUNA_dp;
    }


    public static String getCOLUNA_l_od_cc() {
        return COLUNA_l_od_cc;
    }

    public static String getCOLUNA_l_oe_cc() {
        return COLUNA_l_oe_cc;
    }

}

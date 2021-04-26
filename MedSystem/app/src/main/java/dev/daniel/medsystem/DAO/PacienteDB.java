package dev.daniel.medsystem.DAO;

public class PacienteDB {


    private static final String TABELA_PACIENTE = "TBPACIENTE";
    private static final String COLUNA_IDPACIENTE = "ID";
    private static final String COLUNA_NOME = "NOME";
    private static final String COLUNA_CPF = "CPF";
    private static final String COLUNA_RG = "RG";
    private static final String COLUNA_NASCIMENTO = "NASCIMENTO";
    private static final String COLUNA_ESTADOCIVIL = "ESTADOCIVIL";
    private static final String COLUNA_EMAIL = "EMAIL";
    private static final String COLUNA_ENDERECO = "ENDERECO";
    private static final String COLUNA_TELEFONE = "TELEFONE";
    private static final String COLUNA_OBSERVACAO = "OBSERVACAO";


    public static String getColunaCpf() {
        return COLUNA_CPF;
    }

    public static String getColunaRg() {
        return COLUNA_RG;
    }

    public static String getColunaEmail() {
        return COLUNA_EMAIL;
    }

    public static String getColunaIdpaciente() {
        return COLUNA_IDPACIENTE;
    }



    public static String getColunaIdPaciente() {
        return COLUNA_IDPACIENTE;
    }

    public static String getTabelaPaciente() {
        return TABELA_PACIENTE;
    }

    public static String getColunaEstadocivil() {
        return COLUNA_ESTADOCIVIL;
    }

//    public static String getTabelaCliente() {
//        return TABELA_CLIENTE;
//    }

//    public static String getColunaIdcliente() {
//        return COLUNA_IDCLIENTE;
//    }

    public static String getColunaNome() {
        return COLUNA_NOME;
    }

    public static String getColunaEndereco() {
        return COLUNA_ENDERECO;
    }

    public static String getColunaTelefone() {
        return COLUNA_TELEFONE;
    }

    public static String getColunaNascimento() {
        return COLUNA_NASCIMENTO;
    }

    public static String getColunaObservacao() {
        return COLUNA_OBSERVACAO;
    }
}

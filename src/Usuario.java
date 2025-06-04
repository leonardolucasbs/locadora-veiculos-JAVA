import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usuario {
    protected String nome;
    protected String cpf;
    protected String data_criacao;

    private String FormataData(LocalDate data){
        DateTimeFormatter formatandoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String data_formatada = formatandoData.format(data);
        return data_formatada;
    }

    public Usuario(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        String data_atual = FormataData(LocalDate.now());
    }

    public void exibirUsuario(){
        System.out.println("Nome: " +nome+ " | CPF: " +cpf+ " | data criacao: " +data_criacao+ "\n");
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getData_criacao() {
        return data_criacao;
    }

}

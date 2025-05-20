public class Clientes {
    String nome;
    String cpf;
    String telefone;

    public Clientes(String nome, String cpf, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
      
    }
    public void exibircliente(){
        System.out.println("Nome: " +nome+ " | CPF: " +cpf+ " | Telefone: " +telefone+ "\n");
    }
   
    
}

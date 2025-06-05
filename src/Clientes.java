public class Clientes extends Usuario {
    private String email;
    private String telefone;
    
    public Clientes(String nome,String cpf,String email,String telefone){
        super(nome, cpf);
        this.email = email;
        this.telefone = telefone;
      
    }
    public void exibircliente(){
        System.out.println("Nome: " +super.nome+ " | CPF: " +super.cpf+ " | Telefone: " +telefone+ "\n");
    }
    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
   
    
}

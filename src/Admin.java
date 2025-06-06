public class Admin extends Usuario{
    private String email;
    private String telefone;

    public Admin(String nome,String cpf,String email,String telefone){
        super(nome, cpf);
        this.email = email;
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }
    public String getTelefone() {
        return telefone;
    }
    
}

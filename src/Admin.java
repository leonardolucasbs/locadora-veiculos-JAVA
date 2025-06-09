public class Admin extends Usuario{
    private static final int senha = 12345;

    public Admin(String nome,String cpf){
        super(nome, cpf);
        
    }

    public static int getSenha(){
        return senha;
    }
    public String getNomeadm(){
        return super.getNome();
    }
    public String getCPFadm(){
        return super.getCpf();
    }
   
    
}

import java.util.ArrayList;
import java.util.Scanner;

public class ControllerAdmin{
    private Admin admin;
    private ArrayList<Veiculos> listaVeiculos;
    private ArrayList<Aluguel> listaAluguels;
    private ArrayList<Clientes> listaClientes;
    public ControllerAdmin() {
        this.listaVeiculos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaAluguels = new ArrayList<>();
        this.admin = new Admin("admin", "88888888");
    }

    private int getSenha(){
        return Admin.getSenha();
    }
    private String getNome(){
        return admin.getNomeadm();
    }
    private String getCpf(){
        return admin.getCpf();
    }

    public void authenticador(Scanner input) {
        while (true) {
            try {
                
                System.out.println("Nome de usuário: ");
                String nomeDigitado = input.nextLine();

                System.out.println("CPF: ");
                String cpfDigitado = input.nextLine();

                System.out.println("Senha: ");
                String senhaDigitadaStr = input.nextLine();

                
                int senhaNumerica = Integer.parseInt(senhaDigitadaStr);

                
                if (getNome().equalsIgnoreCase(nomeDigitado) &&
                    getCpf().equals(cpfDigitado) &&
                    getSenha() == senhaNumerica){
                    
                    System.out.println("\nAutenticação bem-sucedida!");
                    break; 
                } else {
        
                    System.err.println("\nNome de usuário, CPF ou senha incorretos. Tente novamente.");
                }

            } catch (NumberFormatException e) {
               
                System.err.println("\nFormato de senha inválido. A senha deve ser numérica. Tente novamente.");
            }
            
            System.out.println("Pressione Enter para continuar...");
            input.nextLine();

        }
            

    }


    public void adicionarAluguel(Aluguel aluguel){
        listaAluguels.add(aluguel);
    }

    public void adicionarVeiculo(Veiculos veiculo) {
        listaVeiculos.add(veiculo);
    }
    public void removerVeiculo(Veiculos veiculo) {
        listaVeiculos.remove(veiculo);
    }

    public Boolean validaPlacaVeiculo(String placa){
        if(placa.length() != 7){
            return true;
        }
        for(Veiculos veiculo : listaVeiculos){
            if(veiculo.getPlaca().equals(placa)){
                return true;
            }
        }
        return false;
    }
        public Veiculos PegaVeiculo(String placa){
        for(Veiculos veiculo : listaVeiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public boolean listarVeiculos(){
        if (listaVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado.");
            return false;
        } else {
            for (Veiculos v : listaVeiculos) {
                v.exibirveiculo();
            }
            return true;
        }
    }

    public boolean listaAluguels(){
        if (listaAluguels.isEmpty()) {
            System.out.println("Nenhum Aluguel cadastrado.");
            return false;
        }else {
            for (Aluguel aluguel : listaAluguels) {
                aluguel.exibirAlugueis();
            }
            return true;
        }
    }

    public void adicionarCliente(Clientes cliente) {
        listaClientes.add(cliente);
    }


    public boolean listarClientes(){
        if (listaClientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
             return false;
        }else {
            for (Clientes c : listaClientes) {
                c.exibircliente();
            }
            return true;
        }
    }

    public Clientes PegaCliente(String cpf){
        for(Clientes cliente : listaClientes){
            if(cliente.getCpf().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public boolean ValidaCpf(String cpf){
        for(Clientes cliente : listaClientes){
            if(cliente.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    
}

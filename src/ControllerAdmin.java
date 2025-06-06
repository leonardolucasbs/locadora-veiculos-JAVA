import java.util.ArrayList;

public class ControllerAdmin{
    private ArrayList<Veiculos> listaVeiculos;
    private ArrayList<Aluguel> listaAluguels;
    private ArrayList<Clientes> listaClientes;
    private static final int senha = 12345;
    public ControllerAdmin() {
        this.listaVeiculos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaAluguels = new ArrayList<>();
    }
    private int getSenha(){
        return senha;
    }
    public boolean authenticador(int senhaDigitada) {
        if(senhaDigitada == getSenha()){
            System.out.println("Autenticação de administrador bem-sucedida!");
            return true;
        } else {
            System.out.println("Senha incorreta!");
            return false;
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

import java.util.ArrayList;

public class ControllerCliente{

    private ArrayList<Clientes> listaClientes;

    public ControllerCliente() {
        this.listaClientes = new ArrayList<>();
    }

    public void adicionarCliente(Clientes cliente) {
        listaClientes.add(cliente);
    }


    public boolean listaClientes(){
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
            if(cliente.getEmail().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public boolean ValidaCpf(String cpf){
        for(Clientes cliente : listaClientes){
            if(cliente.getEmail().equals(cpf)){
                
                return true;
            }
        }
        return false;
    }
}

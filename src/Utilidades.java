import java.util.Scanner;
public class Utilidades {
    public void menu(){
        System.out.println("-------------------------------");
                System.out.println("java-Motors");
                System.out.println("[1] - Cadastro de Veículos");
                System.out.println("[2] - Cadastro de Clientes");
                System.out.println("[3] - Registrar Aluguel");
                System.out.println("[4] - Contratos de Aluguéis");
                System.out.println("[5] - Listagem de Veículos");
                System.out.println("[6] - Listagem de Clientes");
                System.out.println("[7] - Log out"); // authenticado cliente = False
                System.out.println("[0] - Sair");
                
                System.out.println("-------------------------------");
                System.out.print("Opção: ");
    }
    public String lerTelefone(Scanner input){
        while (true) {
            System.out.print("Digite o telefone (10 ou 11 dígitos): ");
            String telefone = input.nextLine().replaceAll("[^0-9]", "");
            if (telefone.length() == 10 || telefone.length() == 11) {
                return telefone;
            }
            System.out.println("Erro: Telefone deve ter 10 (fixo) ou 11 (celular) dígitos.");
        }
    
    }
    public String lerDadoNumerico(Scanner input, String mensagem, int tamanho) {
        while (true) {
            System.out.print(mensagem);
            String dado = input.nextLine().replaceAll("[^0-9]", ""); // Remove não-numéricos
            if (dado.length() == tamanho) {
                return dado;
            }
            System.out.println("Erro: Deve ter exatamente " + tamanho + " dígitos. Tente novamente.");
        }
    }
    
    public  boolean Continuar(){
        Scanner input = new Scanner(System.in);
        System.out.println("Deseja continuar: ");
        System.out.println("[1]-Sim");
        System.out.println("[2]-Nao");
        int resposta = input.nextInt();
        if(resposta==1){
            return true;
        }
        return false;
    }
}

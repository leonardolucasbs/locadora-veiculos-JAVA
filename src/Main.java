import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class Main {

    // Método auxiliar para ler dados numéricos com tamanho fixo (CPF/Telefone)
    public static String lerDadoNumerico(Scanner input, String mensagem, int tamanho) {
        while (true) {
            System.out.print(mensagem);
            String dado = input.nextLine().replaceAll("[^0-9]", ""); // Remove não-numéricos
            if (dado.length() == tamanho) {
                return dado;
            }
            System.out.println("Erro: Deve ter exatamente " + tamanho + " dígitos. Tente novamente.");
        }
    }

    // Método auxiliar para validar telefone (10 ou 11 dígitos)
    public static String lerTelefone(Scanner input) {
        while (true) {
            System.out.print("Digite o telefone (10 ou 11 dígitos): ");
            String telefone = input.nextLine().replaceAll("[^0-9]", "");
            if (telefone.length() == 10 || telefone.length() == 11) {
                return telefone;
            }
            System.out.println("Erro: Telefone deve ter 10 (fixo) ou 11 (celular) dígitos.");
        }
    }

    public static Boolean validaPlacaVeiculo(String placa,ArrayList<Veiculos> listaVeiculos){
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
    public static boolean ValidaCpf(String cpf,ArrayList<Clientes> listaClientes){
        for(Clientes cliente : listaClientes){
            if(cliente.getEmail().equals(cpf)){
                return true;
            }
        }
        return false;
    }
    public static Clientes PegaCliente(String cpf,ArrayList<Clientes> listaClientes){
        for(Clientes cliente : listaClientes){
            if(cliente.getEmail().equals(cpf)){
                return cliente;
            }
        }
        return null;
    }

    public static Veiculos PegaVeiculo(String placa,ArrayList<Veiculos> listaVeiculos){
        for(Veiculos veiculo : listaVeiculos){
            if(veiculo.getPlaca().equals(placa)){
                return veiculo;
            }
        }
        return null;
    }

    public static boolean listaVeiculos(ArrayList<Veiculos> listaVeiculos){
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

    public static boolean listaClientes(ArrayList<Clientes> listaClientes){
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
    public static boolean listaAluguels(ArrayList<Aluguel> listaAluguels){
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
    public static boolean Continuar(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Deseja continuar: ");
        System.out.println("[1]-Sim");
        System.out.println("[2]-Nao");
        int resposta = teclado.nextInt();
        if(resposta==1){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        ArrayList<Veiculos> listaVeiculos = new ArrayList<>();
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        ArrayList<Aluguel> listaAluguels = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean continua = true;

        try {
            while (continua) {
                System.out.println("-------------------------------");
                System.out.println("java-Motors");
                System.out.println("[1] - Cadastro de Veículos");
                System.out.println("[2] - Cadastro de Clientes");
                System.out.println("[3] - Registrar Aluguel");
                System.out.println("[4] - Contratos de Aluguéis");
                System.out.println("[5] - Listagem de Veículos");
                System.out.println("[6] - Listagem de Clientes");
                System.out.println("[0] - Sair");
                System.out.println("-------------------------------");
                System.out.print("Opção: ");

                try {
                    int opcao = input.nextInt();
                    input.nextLine(); // Limpar buffer

                    switch (opcao) {
                        case 1:
                            System.out.println("\nÁrea de cadastro de veículos");
                            System.out.println("-------------------------------");

                            System.out.print("Digite o modelo do veículo: ");
                            String modelo = input.nextLine().trim();

                            System.out.print("Digite a placa do veículo: ");
                            String placa = input.nextLine();
                            boolean valida_placa = validaPlacaVeiculo(placa, listaVeiculos);
                            while(valida_placa){
                                System.out.print("OPS!Placa invalida\nDigite a placa do  novamente veículo: ");
                                placa = input.nextLine().trim();
                                valida_placa = validaPlacaVeiculo(placa, listaVeiculos);
                            }
                            // Validação do ano
                            int ano = 0;
                            while (true) {
                                System.out.print("Digite o ano do veículo (1769-" + (anoAtual + 1) + "): ");
                                try {
                                    ano = Integer.parseInt(input.nextLine());
                                    if (ano >= 1769 && ano <= anoAtual + 1) {
                                        break;
                                    }
                                    System.out.println("Erro: Ano inválido.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Erro: Digite apenas números.");
                                }
                            }

                            // Validação do valor
                            double valor = 0.0;
                            while (true) {
                                System.out.print("Digite o valor da diária (R$): ");
                                try {
                                    valor = Double.parseDouble(input.nextLine());
                                    if (valor > 0) {
                                        break;
                                    }
                                    System.out.println("Erro: Valor deve ser positivo.");
                                } catch (NumberFormatException e) {
                                    System.out.println("Erro: Digite um número válido (ex: 150.50).");
                                }
                            }
                            listaVeiculos.add(new Veiculos(modelo, placa, ano, valor));
                            System.out.println("\n " + modelo + " com placa: " +placa+ " cadastrado com sucesso!");
                            break;

                        case 2:
                            System.out.println("\nÁrea de cadastro de clientes");
                            System.out.println("-------------------------------");

                            // Validação do nome
                            String nome;
                            while (true) {
                                System.out.print("Digite o nome do cliente: ");
                                nome = input.nextLine().trim();
                                if (!nome.isEmpty()) {
                                    break;
                                }
                                System.out.println("Erro: Nome não pode ser vazio.");
                            }

                            // CPF (11 dígitos) - usando método auxiliar
                            String cpf = lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                            String email =  input.nextLine();
                            // Telefone (10 ou 11 dígitos) - usando método auxiliar
                            String telefone = lerTelefone(input);
                            
                            listaClientes.add(new Clientes(nome, cpf, email, telefone));
                            System.out.println("\n " + nome + " cadastrado com sucesso!");
                            break;

                        case 3:
                            System.out.println("\nÁrea de registro de aluguel");
                            System.out.println("-------------------------------");
                            // pegando veiculo
                            System.out.println("Veiculos cadastrados:");
                            if(!listaVeiculos(listaVeiculos)){
                                break;
                            }
                            System.out.println("-------------------------------");
                            System.out.println("Digite a placa do veiculo que deseja alugar:");
                            placa = input.nextLine();
                            if(validaPlacaVeiculo(placa,listaVeiculos)){
                                Veiculos veiculo = PegaVeiculo(placa,listaVeiculos);
                                System.out.println("Veiculo encontrado!");
                                System.out.println("Informacoes do veiculo:\nModelo-> "+veiculo.getModelo()+" Ano-> "+veiculo.getAno()+" Placa-> "+veiculo.getPlaca());
                                if(!Continuar()){
                                    break;
                                }
                            }else{
                                System.out.println("Placa invalida ou nao existe!");
                                break;
                            }   
                        
                            System.out.println("-------------------------------");
                            // pegando veiculo
                            System.out.println("Clientes cadastrados:");
                            if(!listaClientes(listaClientes)){
                                break;
                            }
                            System.out.println("-------------------------------");
                            System.out.println("Digite o cpf do cliente que esta fazendo o aluguel: ");
                            cpf = lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                            if(ValidaCpf(cpf,listaClientes)){
                                Clientes cliente = PegaCliente(cpf,listaClientes);
                                System.out.println("Cliente encontrado!");
                                System.out.println("Informacoes do cliente:\ncpf-> "+cliente.getEmail()+" Nome-> "+cliente.getNome()+" Telefone-> "+cliente.getTelefone());
                                if(!Continuar()){
                                    break;
                                }
                            }else{
                                System.out.println("Cpf invalido ou nao existe!");
                                break;
                                }
                            System.out.println("-------------------------------");
                            //Criando o aluguel;
                            System.out.println("Digite a quantidade de dias do aluguel");
                            int quantidade_dias = input.nextInt();
                            Clientes cliente = PegaCliente(cpf,listaClientes);
                            Veiculos veiculo = PegaVeiculo(placa,listaVeiculos);
                            listaAluguels.add(new Aluguel(quantidade_dias,cliente,veiculo));
                            LimpaTela.limpatela();
                            System.out.println("Aluguel criado com sucesso");
                            System.out.println("-------------------------------");
                            break;
                        case 4:
                            System.out.println("\nContratos de aluguéis");
                            System.out.println("-------------------------------");
                            listaAluguels(listaAluguels);
                            // (Implementação futura)
                            break;

                        case 5:
                            System.out.println("\nVeículos cadastrados:");
                            System.out.println("-------------------------------");
                            listaVeiculos(listaVeiculos);
                            break;

                        case 6:
                            System.out.println("\nClientes cadastrados:");
                            System.out.println("-------------------------------");
                            listaClientes(listaClientes);
                            break;

                        case 0:
                            continua = false;
                            System.out.println("\nSaindo do sistema...");
                            break;

                        default:
                            System.out.println("\n Opção inválida. Tente novamente.");
                    }
                } catch (Exception e) {
                    System.out.println("\n Erro: Entrada inválida. Tente novamente.");
                    input.nextLine(); // Limpar buffer
                }
            }
        } finally {
            if (input != null) {
                input.close(); // Garante que o Scanner seja fechado
            }
        }
    }
}
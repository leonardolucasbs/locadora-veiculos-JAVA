import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

    public static void main(String[] args) {
        int anoAtual = LocalDate.now().getYear();
        Utilidades util = new Utilidades();
        ControllerAdmin controller_admin = new ControllerAdmin();
        ControllerCliente controller_clientes = new ControllerCliente();
        Scanner input = new Scanner(System.in);
        boolean continua = true;
        boolean modoAdmin = false;
        try {
            
            while (continua) {
                System.out.println("-------------------------------");
                System.out.println("Bem vindo!\nComo deseja se registrar?\n[1]-Cliente\n[2]-Admin");
                int tipo_usuario = input.nextInt();
                input.nextLine(); // Limpar buffer
                System.out.println("-------------------------------");
                switch (tipo_usuario) {
                    case 1:
                    LimpaTela.limpatela();
                    System.out.println("-------------------------------");
                    System.out.println("-Registrar como Cliente-\nComplete as informacoes a baixo:");
                    System.out.println("Digite seu Nome:");
                    String nome_cliente = input.nextLine();
                    System.out.println("Digite seu cpf:");
                    String cpf = util.lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                    System.out.println("Digite seu telefone:");
                    String telefone = util.lerTelefone(input);
                    System.out.println("Digite seu Email (Nao e obrigatorio pode apenas apertar a tecla [ENTER]):");
                    String email = input.nextLine();
                    modoAdmin = false;
                    continua = false;
                    System.out.println("-------------------------------");
                    
                    break;
                    case 2:
                    LimpaTela.limpatela();
                    System.out.println("-------------------------------");
                    System.out.println("Senha: ");
                    int senha = input.nextInt();
                    modoAdmin = controller_admin.authenticador(senha);
                    System.out.println("-------------------------------");
                    continua = false;
                    break;
                    default:
                    break;
                    } 
                }
                //
                util.menu();
                try {
                    int opcao = input.nextInt();
                    input.nextLine(); // Limpar buffer
                    switch (opcao) {
                        case 1:
                            if (!modoAdmin) {
                                System.out.println("Apenas administradores podem fazer isso!");
                                input.nextLine(); 
                                break;  
                                }    
                                System.out.println("\nÁrea de cadastro de veículos");
                                System.out.println("-------------------------------");
                                
                                System.out.print("Digite o modelo do veículo: ");
                                String modelo = input.nextLine().trim();
                                
                                System.out.print("Digite a placa do veículo: ");
                                String placa = input.nextLine();
                                boolean valida_placa = controller_admin.validaPlacaVeiculo(placa);
                                while(valida_placa){
                                    System.out.print("OPS!Placa invalida\nDigite a placa do  novamente veículo: ");
                                    placa = input.nextLine().trim();
                                    valida_placa = controller_admin.validaPlacaVeiculo(placa);
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
                            controller_admin.adicionarVeiculo(new Veiculos(modelo, placa, ano, valor));
                            System.out.println("\n " + modelo + " com placa: " +placa+ " cadastrado com sucesso!");
                            System.out.println("-------------------------------");
                            break;
                        
                        case 2:
                            if (!modoAdmin) {
                                    System.out.println("Apenas administradores podem fazer isso!");
                                    break;
                                } 
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
                                String cpf = util.lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                                String email =  input.nextLine();
                                // Telefone (10 ou 11 dígitos) - usando método auxiliar
                                String telefone = util.lerTelefone(input);
                                
                                //listaClientes.add(new Clientes(nome, cpf, email, telefone));
                                controller_clientes.adicionarCliente(new Clientes(nome, cpf, email, telefone));
                                System.out.println("\n " + nome + " cadastrado com sucesso!");
                            break;
                            
                            case 3:
                                System.out.println("\nÁrea de registro de aluguel");
                                System.out.println("-------------------------------");
                                // pegando veiculo
                                System.out.println("Veiculos cadastrados:");
                                if(!controller_admin.listaVeiculos()){
                                    break;
                                }
                                System.out.println("-------------------------------");
                                System.out.println("Digite a placa do veiculo que deseja alugar:");
                                placa = input.nextLine();
                                if( controller_admin.validaPlacaVeiculo(placa)){
                                    Veiculos veiculo = controller_admin.PegaVeiculo(placa);;
                                    System.out.println("Veiculo encontrado!");
                                    System.out.println("Informacoes do veiculo:\nModelo-> "+veiculo.getModelo()+" Ano-> "+veiculo.getAno()+" Placa-> "+veiculo.getPlaca());
                                    if(!util.Continuar()){
                                        break;
                                    }
                                }else{
                                    System.out.println("Placa invalida ou nao existe!");
                                    break;
                                }   
                                
                                System.out.println("-------------------------------");
                                // pegando veiculo
                                System.out.println("Clientes cadastrados:");
                                if(controller_admin.listaClientes()){
                                    break;
                                }
                                System.out.println("-------------------------------");
                                System.out.println("Digite o cpf do cliente que esta fazendo o aluguel: ");
                                cpf = util.lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                                if(controller_clientes.ValidaCpf(cpf)){
                                    Clientes cliente = controller_clientes.PegaCliente(cpf);
                                    System.out.println("Cliente encontrado!");
                                    System.out.println("Informacoes do cliente:\ncpf-> "+cliente.getEmail()+" Nome-> "+cliente.getNome()+" Telefone-> "+cliente.getTelefone());
                                    if(!util.Continuar()){
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
                                Clientes cliente = controller_clientes.PegaCliente(cpf);
                                Veiculos veiculo = controller_admin.PegaVeiculo(placa);
                                controller_admin.adicionarAluguel(new Aluguel(quantidade_dias,cliente,veiculo));
                                controller_admin.removerVeiculo(veiculo);
                                LimpaTela.limpatela();
                                System.out.println("Aluguel criado com sucesso");
                                System.out.println("-------------------------------");
                            break;
                            case 4:
                            if (!modoAdmin) {
                                System.out.println("Apenas administradores podem fazer isso!");
                                input.nextLine(); // Limpa o buffer
                                ; 
                            } 
                                System.out.println("\nContratos de aluguéis");
                                System.out.println("-------------------------------");
                                controller_admin.listaAluguels();
                                // (Implementação futura)
                            break;
                            
                            case 5:

                                System.out.println("\nVeículos cadastrados:");
                                System.out.println("-------------------------------");
                                controller_admin.listaVeiculos();
                            break;
                            
                            case 6:
                            if (!modoAdmin) {
                                
                            } 
                                System.out.println("\nClientes cadastrados:");
                                System.out.println("-------------------------------");
                                controller_clientes.listaClientes();
                            break;
                            
                            case 7:
                                System.out.println("\nLOGOUT");
                                System.out.println("-------------------------------");
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
                
            } finally {
                System.out.println("eu sou gay");
                if (input != null) {
                    input.close(); // Garante que o Scanner seja fechado
                }
            }
        }
    
    /*
     public Boolean validaPlacaVeiculo(String placa,ArrayList<Veiculos> listaVeiculos){
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
 */
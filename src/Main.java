
import java.util.Scanner;
import java.time.LocalDate;
public class Main{
    public static void main(String[] args) {

        int anoAtual = LocalDate.now().getYear();
        boolean continua = true;
        boolean modoAdmin = false;
        
        Utilidades util = new Utilidades();
        ControllerAdmin controller_admin = new ControllerAdmin();
        Scanner input = new Scanner(System.in);

        while (continua) {
            System.out.println("-------------------------------");
            System.out.println("Bem vindo!\nComo deseja se registrar?\n[1]-Cliente\n[2]-Admin");
            int tipo_usuario = input.nextInt();
            input.nextLine();
            System.out.println("-------------------------------");
            switch (tipo_usuario) {
                case 1:
                    LimpaTela.limpatela();
                    System.out.println("-------------------------------");
                    System.out.println("-Registrar como Cliente-\nComplete as informacoes a baixo:");
                    
                    String nome;
                        while (true) {
                            System.out.print("Digite o seu nome: ");
                            nome = input.nextLine().trim();
                            if (!nome.isEmpty()) {
                                break;
                            }
                            System.out.println("Erro: Nome não pode ser vazio.");
                        }
                        
                        
                        String cpf = util.lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                        String email =  input.nextLine();
                        String telefone = util.lerTelefone(input);
                        controller_admin.adicionarCliente(new Clientes(nome, cpf, email, telefone));
                        System.out.println("\n " + nome + " cadastrado com sucesso!");
                        modoAdmin = false;
                    break;
                case 2:
                    System.out.println("-------------------------------");
                    System.out.println("BEM-VINDO AO SISTEMA");
                    System.out.println("-------------------------------");
                    
                    controller_admin.authenticador(input);

                    System.out.println("\nLogin efetuado. Acessando o menu principal do administrador...");
                    modoAdmin = true;
                    break;
                
                }
                boolean continua2 = true;
                while (continua2){
                    util.menu();
                    int opcao = input.nextInt();
                    input.nextLine(); 
                    switch (opcao) {
                        case 1:
                        if (!modoAdmin) {
                            System.out.println("Apenas administradores podem fazer isso!");
                            break;
                        } else{   
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
                            System.out.print("Digite o ano do veículo (1886-" + (anoAtual + 1) + "): ");
                            try {
                                ano = Integer.parseInt(input.nextLine());
                                if (ano >= 1886 && ano <= anoAtual + 1) {
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
                    }
                    break;
                    case 2:
                        if (!modoAdmin) {
                            System.out.println("Apenas administradores podem fazer isso!");
                            break;
                        }else{
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
                            
                            String cpf = util.lerDadoNumerico(input, "Digite o CPF (11 dígitos): ", 11);
                            String email =  input.nextLine();
                            
                            String telefone = util.lerTelefone(input);
                            
                            controller_admin.adicionarCliente(new Clientes(nome, cpf, email, telefone));
                            System.out.println("\n " + nome + " cadastrado com sucesso!");
                            break;
                        }   
                    case 3:
                        System.out.println("\nÁrea de registro de aluguel");
                        System.out.println("-------------------------------");
                        // pegando veiculo
                        System.out.println("Veiculos cadastrados:");
                        if(!controller_admin.listarVeiculos()){
                            break;
                        }
                        System.out.println("-------------------------------");
                        System.out.println("Digite a placa do veiculo que deseja alugar:");
                        String placa = input.nextLine();
                        if(controller_admin.validaPlacaVeiculo(placa)){
                            Veiculos veiculo = controller_admin.PegaVeiculo(placa);
                            System.out.println("Veiculo encontrado!");
                            System.out.println("Informacoes do veiculo:\nModelo-> "+veiculo.getModelo()+" Ano-> "+veiculo.getAno()+" Placa-> "+veiculo.getPlaca() + "Preço-> "+ veiculo.getValor());
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
                        if(!controller_admin.listarClientes()){
                            break;
                        }
                        System.out.println("-------------------------------");
                        System.out.println("Digite o cpf do cliente que esta fazendo o aluguel: ");
                        String cpf = input.nextLine();
                        if(controller_admin.ValidaCpf(cpf)){
                            System.out.println("Cliente encontrado!");
                            Clientes cliente = controller_admin.PegaCliente(cpf);
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
                        Clientes cliente = controller_admin.PegaCliente(cpf);
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
                            input.nextLine(); 
                            ; 
                        } 
                        System.out.println("\nContratos de aluguéis");
                        System.out.println("-------------------------------");
                        controller_admin.listaAluguels();
                     
                        break;
                    
                    case 5:
                        
                        System.out.println("\nVeículos cadastrados:");
                        System.out.println("-------------------------------");
                        controller_admin.listarVeiculos();
                        break;
                    
                    case 6:
                        if(!modoAdmin){
                            System.out.println("Somente administradores podem utilizar esta area!");
                            break;
                        }else {
                            System.out.println("\nClientes cadastrados:");
                            System.out.println("-------------------------------");
                            controller_admin.listarClientes();
                        }
                        break;
                    case 7:
                        System.out.println("\nLOGOUT...");
                        continua2 = false;
                        System.out.println("-------------------------------");
                        break;
                    
                    case 0:
                        continua = false;
                        continua2 = false;
                        System.out.println("\nSaindo do sistema...");
                        break;
                    
                    default:
                        System.out.println("\n Opção inválida. Tente novamente.");
                    
                } //switch
            }// while
        }                      
    }//main
}//main
    
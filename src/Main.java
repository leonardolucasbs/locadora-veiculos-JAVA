import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;
public class Main {
    public static void main(String[] args){
        int data = LocalDate.now().getYear();
        ArrayList<Veiculos> listaVeiculos = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean continua = true;
        while(continua){
            System.out.println("java-Motors");
            System.out.println("[1] - Cadastro de Veículos");
            System.out.println("[2] - Cadastro de Clientes");
            System.out.println("[3] - Registrar Aluguel");
            System.out.println("[4] - Calcular preço do Aluguel");
            System.out.println("[5] - Contratos de Aluguéis");
            System.out.println("[6] - Listagem de Veículos");
            System.out.println("[7] - Listagem de Clientes");
            System.out.println("[0] - Sair");
            System.out.println("Utilize os índices [x] para poder acessar as funcionalidade!");
            try { 

                int opcao = input.nextInt();
                input.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Area de cadastro de veículos\n");
                        System.out.println("-------------------------------");
                        
                        System.out.println("Digite o modelo do veículo");
                        String modelo = input.next();
                        input.nextLine();
                        int ano = 0;
                        while (true) {
                            System.out.println("Digite o ano do veículo: ");
                            try {
                                ano = Integer.parseInt(input.nextLine());
    
                                if (ano < 1769 || ano > data) {
                                    System.out.println("Ano inválido. O ano deve ser entre 1900 e " + data + ".\n");
                                    continue;
                                } else {
                                    break; 
                                }
    
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Digite apenas números.\n");
                            }
                            
                        }
    
                        Double valor = 0.0;
                        while (true) {
                            System.out.println("Digite o valor da diária do veículo");
                             try {
                                    valor = Double.parseDouble(input.nextLine());
                                    if (valor < 0) {
                                        System.out.println("Valor inválido. Digite um número positivo.");
                                    } else {
                                        break;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Entrada inválida. Digite um número com ponto (.) se necessário.\n");
                                }
                        }
    
                        listaVeiculos.add(new Veiculos(modelo, ano, valor));
                        LimpaTela.limpatela();
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                    break;
                    case 6:
                     System.out.println("\nVeículos cadastrados:");
                        if (listaVeiculos.isEmpty()) {
                            System.out.println("Nenhum veículo cadastrado.");
                        } else {
                            for (Veiculos v : listaVeiculos) {
                                v.exibirveiculo();
                            }
                        }
                        break;
                    case 7:
                        break;
                    case 0:
                    continua = false;
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
                input.nextLine(); 
            }

        }

        input.close();
    }
}

import java.util.Scanner;
import java.util.ArrayList;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        int data = LocalDate.now().getYear();
        ArrayList<Veiculos> listaVeiculos = new ArrayList<>();
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean continua = true;

        while (continua) {
            System.out.println("-------------------------------\n");
            System.out.println("java-Motors");
            System.out.println("[1] - Cadastro de Veículos");
            System.out.println("[2] - Cadastro de Clientes");
            System.out.println("[3] - Registrar Aluguel");
            System.out.println("[4] - Calcular preço do Aluguel");
            System.out.println("[5] - Contratos de Aluguéis");
            System.out.println("[6] - Listagem de Veículos");
            System.out.println("[7] - Listagem de Clientes");
            System.out.println("[0] - Sair");
            System.out.println("Utilize os índices [x] para poder acessar as funcionalidades!");
            System.out.println("-------------------------------\n");
            try {
                int opcao = input.nextInt();
                input.nextLine();

                switch (opcao) {
                    case 1:
                        System.out.println("Área de cadastro de veículos");
                        System.out.println("-------------------------------\n");

                        System.out.println("Digite o modelo do veículo:");
                        String modelo = input.nextLine();

                        int ano = 0;
                        while (true) {
                            System.out.print("Digite o ano do veículo: ");
                            try {
                                ano = Integer.parseInt(input.nextLine());

                                if (ano < 1769 || ano > data) {
                                    System.out.println("Ano inválido. O ano deve ser entre 1769 e " + data + ".\n");
                                } else {
                                    break;
                                }

                            } catch (NumberFormatException e) {
                                System.out.println("Entrada inválida. Digite apenas números.\n");
                            }
                        }

                        double valor = 0.0;
                        while (true) {
                            System.out.print("Digite o valor da diária do veículo: ");
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
                        System.out.println(modelo +" cadastrado com sucesso!");
                        System.out.println("-------------------------------\n");
                        break;

                    case 2:
                        System.out.println("Área de cadastro de clientes");
                        System.out.println("-------------------------------\n");

                        String nome = "";
                        while (true) {
                            System.out.print("Digite o nome do cliente: ");
                            nome = input.nextLine().trim();
                            if (nome.isEmpty()) {
                                System.out.println("Nome não pode estar vazio. Tente novamente.");
                            } else {
                                break;
                            }
                        }

                        // Tratamento simplificado para CPF
                        String cpf = "";
                        while (true) {
                            System.out.print("Digite o CPF do cliente (11 dígitos): ");
                            cpf = input.nextLine().replaceAll("[^0-9]", ""); // Remove não numéricos
                            
                            if (cpf.length() == 11) {
                                break;
                            }
                            System.out.println("CPF deve conter 11 dígitos numéricos.");
                        }

                        // Tratamento simplificado para telefone
                        String telefone = "";
                        while (true) {
                            System.out.print("Digite o telefone do cliente (10 ou 11 dígitos): ");
                            telefone = input.nextLine().replaceAll("[^0-9]", ""); // Remove não numéricos
                            
                            if (telefone.length() == 10 || telefone.length() == 11) {
                                break;
                            }
                            System.out.println("Telefone deve conter 10 ou 11 dígitos.");
                        }

                        listaClientes.add(new Clientes(nome, cpf, telefone));
                        System.out.println(nome +" cadastrado com sucesso!");
                        System.out.println("-------------------------------\n");
    
                        break;

                    case 3:
                        // Registrar aluguel
                        break;

                    case 4:
                        // Calcular aluguel
                        break;

                    case 5:
                        // Listar contratos
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
                        System.out.println("\nClientes cadastrados:");
                        if (listaClientes.isEmpty()) {
                            System.out.println("Nenhum cliente cadastrado.");
                        } else {
                            for (Clientes c : listaClientes) {
                                c.exibircliente();
                            }
                        }
                        break;

                    case 0:
                        continua = false;
                        break;

                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }

            } catch (Exception e) {
                System.out.println("Opção inválida. Tente novamente.");
                input.nextLine(); // limpar buffer
            }
        }

        input.close();
    }
}

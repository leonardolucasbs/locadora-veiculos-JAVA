import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
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
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
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
                break;
                case 7:
                break;
                case 0:
                continua = false;
                break;
            }
        }


    }
}

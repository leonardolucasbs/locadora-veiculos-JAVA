import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluguel {
    int quantidade_dias;
    String data_aluguel;
    String final_aluguel;
    Clientes cliente;
    Veiculos veiculo;
    double preco_aluguel;
    
    private LocalDate CalculaDataFinal(int quantidade_dias,LocalDate data_aluguel){
        int dia_atual = data_aluguel.getDayOfMonth();
        int dia_final = quantidade_dias + dia_atual;
        LocalDate final_aluguel = LocalDate.now();
        final_aluguel = final_aluguel.plusDays(dia_final);
        return final_aluguel;
    }

    private String FormataData(LocalDate data){
        DateTimeFormatter formatandoData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String data_formatada = formatandoData.format(data);
        return data_formatada;
    }

    public Aluguel(int quantidade_dias, Clientes cliente, Veiculos veiculo){
        this.quantidade_dias = quantidade_dias;
        this.cliente = cliente;
        this.veiculo = veiculo;
        String data_atual = FormataData(LocalDate.now());
        this.data_aluguel = data_atual;
        this.final_aluguel =  FormataData(CalculaDataFinal(quantidade_dias, LocalDate.now()));
        this.preco_aluguel = quantidade_dias * veiculo.valor;
    }
    public void exibirAlugueis(){
        System.out.println("Cliente-CPF: " +cliente.cpf+ " | Veiculo: " +veiculo.modelo+" "+ veiculo.ano + "\n" + " | Data aluguel" + data_aluguel + " | Final do aluguel" + final_aluguel + " | Preco do aluguel: " + preco_aluguel);
    }
}

public class Veiculos {
    String modelo;
    int ano;
    double valor;
    public Veiculos(String modelo, int ano, double valor ){
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
    }
    public void exibirveiculo(){
        System.out.println("Modelo: " +modelo+ " | Ano: " +ano+ " | Valor: " +valor+ "\n");
    }
}

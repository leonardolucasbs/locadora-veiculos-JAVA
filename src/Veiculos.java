public class Veiculos {
    String modelo;
    String placa;
    int ano;
    double valor;
    public Veiculos(String modelo, String placa, int ano, double valor){
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.placa = placa;
    }
    public void exibirveiculo(){
        System.out.println("Modelo: " +modelo+ " | Ano: " +ano+ " | Valor: " +valor+ " | Placa: " +placa+ "\n");
    }
    public String getPlaca() {
        return placa;
    }
}

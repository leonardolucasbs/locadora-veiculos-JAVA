public class Veiculos {
    private String modelo;
    private String placa;
    private int ano;
    private double valor;
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
    public String getModelo() {
        return modelo;
    }
    public int getAno() {
        return ano;
    }
    public double getValor() {
        return valor;
    }
}

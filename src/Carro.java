import java.util.Objects;

public class Carro implements IDado {
    private String placa;
    private Lista usos;

    public Carro(String placa) {
        this.placa = placa;
        this.usos = new Lista();
    }

    public String getPlaca() {
        return this.placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Lista getUsos() {
        return this.usos;
    }

    @Override
    public int hashCode() {
        char a = this.placa.charAt(2);
        int b = Integer.parseInt(this.placa.substring(4));
        int result = a * b;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Carro)) {
            return false;
        }
        Carro carro = (Carro) o;
        return Objects.equals(placa, carro.placa);
    }

    @Override
    public String toString() {
        return "{" + " placa='" + getPlaca() + "'" + "}";
    }

    @Override
    public int compareTo(IDado o) {
        Carro veiculo = (Carro) o;
        int comparacao = this.placa.substring(0, 3).compareTo(veiculo.placa.substring(0, 3));
        if (comparacao == 0) {
            comparacao = this.placa.substring(4).compareTo(veiculo.placa.substring(4));
        }
        return comparacao;
    }

}
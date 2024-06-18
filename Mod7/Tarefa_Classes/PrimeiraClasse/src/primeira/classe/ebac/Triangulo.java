package primeira.classe.ebac;

public class Triangulo {

	// Atributos da classe
    private double base;
    private double altura;

    // Construtor da classe
    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    // Método para calcular a área do triângulo
    public double calcularArea() {
        return (base * altura) / 2;
    }

    // Métodos getters para obter os valores de base e altura
    public double getBase() {
        return base;
    }

    public double getAltura() {
        return altura;
    }

    // Métodos setters para definir os valores de base e altura
    public void setBase(double base) {
        this.base = base;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
	
}

public class Circulo {
    /* Crie a classe Circulo, contendo os seguintes métodos:
     * - float getRaio()
     * - void setRaio(float raio)
     * - float getArea()
     * - float getCircunferencia()
     *
     * A classe deve possuir o construtor Circulo(float raio)
     * Você pode assumir que o valor de PI é 3.14159
     * Não será testado nenhum caso com valores inválidos atribuídos a raio através do método setter.
     */

    public Circulo(float raio) {
        this.raio = raio;
    }

    public float getRaio() {
        return raio;
    }

    public float getArea() {
        return (float) (2 * 3.14159 * Math.pow(getRaio(), 2));
    }

    public float getCircunferencia() {
        return (float) (2 * 3.14159 * getRaio());
    }

    public void setRaio(float raio) {
        this.raio = raio;
    }

    private float raio;
}
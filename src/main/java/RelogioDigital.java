public class RelogioDigital {
    /* Crie a classe RelogioDigital, contendo os seguintes atributos:
     * - int hora
     * - int minuto
     *
     * A classe deve possuir apenas o construtor padrão RelogioDigital() que inicializa hora = 12 e minuto = 20
     *
     * Sua classe deve possuir os getters e setters para hora e minuto e, além disso, o método tick(),
     * que avança o tempo atual em 1 minuto.
     *
     * Atente para a situação em que o avanço de 1 minuto também ocasiona o avanço da hora. Por exemplo:
     * - 04:59 -> tick() -> 05:00
     * - 23:59 -> tick() -> 00:00
     *
     * Não será testado nenhum caso com valores inválidos atribuídos a hora e minutos através dos métodos setters.
     */

    private int hora;
    private int minuto;

    public RelogioDigital() {
        this.hora = 12;
        this.minuto = 20;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        this.minuto = minuto;
    }

    public void tick() {
        if (getMinuto() == 59) {
            setMinuto(0);
            if (getHora() == 23) {
                setHora(0);
            } else {
                setHora(getHora() + 1);
            }
        } else {
            setMinuto(getMinuto() + 1);
        }
    }
}
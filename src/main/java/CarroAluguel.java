public class CarroAluguel {
    /* Crie a classe CarroAluguel com o construtor CarroAluguel(float valorPorKm), onde o parâmetro valorPorKm define o
     * valor cobrado por km. Um objeto CarroAluguel recém instanciado está disponível, tem R$0 de débito e não tem
     * sinistro.
     * A classe possui os seguintes métodos:
     * - void setValorPorKm(float valor), que define o valor cobrado por km.
     * - float getValorPorKm(), que retorna o valor cobrado por km
     * - void setDistanciaPercorrida(int distancia), que define a distância percorrida pelo carro. Um carro disponível
     *   está parado, logo não pode ter distância percorrida e a exceção CarroDisponivelException é lançada nesse caso.
     * - float getDistanciaPercorrida(), que retorna a distância percorrida.
     * - void alugar(), que muda o estado de um carro de "disponivel" para "indisponível". Um carro "indisponível" não
     *   pode ser alugado e, nesse caso, a exceção CarroIndisponivelException é lançada.
     * - void devolver(), que muda o estado de um carro de "indisponivel" para "disponível". Um carro "disponível" não
     *   pode ser devolvido e, nesse caso, a exceção CarroDisponivelException é lançada. Após ser devolvido, um carro não
     *   deve ter sinistro e deve ter sua distância percorrida zerada. Antes de ser devolvido, o
     *   carro precisa ter seus débitos zerados. Caso contrário, a exceção CarroNaoPagoException é lançada.
     * - boolean isDisponivel(), que retorna o estado do carro: true, quando disponível e false, quando indisponível.
     * - boolean hasSinistro(), que retorna true, quando houve sinistro e o seguro precisa ser acionado e false, caso
     *   contrário
     * - float getDebito(), que retorna o valor a ser pago pelo aluguel do carro. O valor é calculado multiplicando o
     *   valor cobrado por km * distância percorrida. Se há sinistro, soma-se mais 60% do débito ao valor total. Após
     *   pago, não haverá mais sinistro no carro.
     * - void pagar(), que paga (zera) o valor devido pelo aluguel. Um carro que não teve distância percorrida não terá
     *   débitos. Um carro disponível não pode ser pago e lança uma exceção CarroDisponivelException nesse caso.
     *
     * Outros getters e setters não serão testados.
     *
     * Mensagens das exceções:
     * - CarroDisponivelException -> "O carro está disponível."
     * - CarroNaoPagoException -> "O carro não foi pago."
     * - CarroIndisponivelException -> "O carro está indisponível."
     */

    public float getValorPorKm() {
        return valorPorKm;
    }

    public void setValorPorKm(float valorPorKm) {
        this.valorPorKm = valorPorKm;
    }

    public int getDistanciaPercorrida() {
        return distanciaPercorrida;
    }

    public void setDistanciaPercorrida(int distanciaPercorrida) {
        this.distanciaPercorrida = distanciaPercorrida;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void alugar() throws CarroIndisponivelException {
        if (isDisponivel()) {
            setDisponivel(false);
        } else {
            throw new CarroIndisponivelException();
        }
    }

    public void devolver() throws CarroDisponivelException, CarroNaoPagoException {
        if (isDisponivel()) {
            throw new CarroDisponivelException();
        } else {
            if (getDebito() > 0) {
                throw new CarroNaoPagoException();
            }
            setDisponivel(true);
            setSinistro(false);
            setDistanciaPercorrida(0);
        }
    }

    public boolean hasSinistro() {
        return sinistro;
    }

    public float getDebito() {
        if (hasSinistro()) {
            return 1.6f * getValorPorKm() * getDistanciaPercorrida();
        } else {
            return getValorPorKm() * getDistanciaPercorrida();
        }
    }

    public void setSinistro(boolean sinistro) {
        this.sinistro = sinistro;
    }

    public void pagar() throws CarroDisponivelException {
        setDistanciaPercorrida(0);
        setSinistro(false);
    }

    private int distanciaPercorrida;
    private float valorPorKm;
    private boolean disponivel;
    private boolean sinistro;

    public CarroAluguel(float valorPorKm) {
        this.valorPorKm = valorPorKm;
        setDisponivel(true);
    }
}

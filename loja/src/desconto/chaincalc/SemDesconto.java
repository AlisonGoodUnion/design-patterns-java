package desconto.chaincalc;

import orcamento.Orcamento;

import java.math.BigDecimal;

/**
 * Final do fluxo Chain
 */
public class SemDesconto extends Desconto {

    public SemDesconto() {
        super(null);
    }

    @Override
    public BigDecimal efetuarCalculo(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    public boolean deveAplicar(Orcamento orcamento) {
        return true;
    }
}

package imposto;

import imposto.strategycalc.Imposto;
import orcamento.Orcamento;

import java.math.BigDecimal;

public class CalculadoraDeImpostos {

    //Problematica: hoje podemos utilizar apenas 1 imposto
    //mas agora precisamos passar mais de 1 como resolver?
    public BigDecimal calcular(Orcamento orcamento, Imposto tipoImposto) {

        //Solucao: ao inves de usar switch, if, etc..
        //podemos usar uma interface, com metodo efetuarCalculo
        //que cada imposto deve implementar.

        //Agora se caso surgir um novo imposto, cada classe imposto tera a sua implementacao.
        //deixando essa classe com uma responsabilidade unica
        //e deixando tambem cada imposto com sua responsabilidade unica

        return tipoImposto.calcular(orcamento);
    }
}

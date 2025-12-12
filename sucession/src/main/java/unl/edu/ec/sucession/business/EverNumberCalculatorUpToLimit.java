package unl.edu.ec.sucession.business;

import unl.edu.ec.sucession.domain.Sucessionable;

/**
 * Representa el calculo de la Serie numeros Pares hasta Limite N.
 * S = 2 + 4 + 6 + 8 + .... N
 * @author chimbocamila29 (Camila Chimbo)
 */

public class EverNumberCalculatorUpToLimit implements Sucessionable {

    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public EverNumberCalculatorUpToLimit(Number limit){
        this(0, limit);
    }

    public EverNumberCalculatorUpToLimit(Number start, Number limit){
        if (start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = (start.intValue() % 2 != 0) ? start.intValue() + 1 : start.intValue();
        printableTerms = new StringBuilder("S = ");
    }



    @Override
    public Number nextTerm(Number currentTerm) {
        return currentTerm.intValue() + 2;
    }

    @Override
    public void setLimit(Number limit) {
        this.limit = limit.intValue();
        if (limit.intValue() < 0){
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        long result = 0;
        this.currentTerm = nextTerm(this.currentTerm).intValue();
        while (currentTerm <= limit){
            this.printableTerms.append(this.currentTerm).append(" + ");
            result = result + this.currentTerm;
            this.currentTerm = nextTerm(this.currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {
        return this.printableTerms.toString();
    }
}

package unl.edu.ec.sucession.business;

import unl.edu.ec.sucession.domain.Sucessionable;

/**
 * Representa el calculo de la Serie de primos elevados al cubo hasta un limite.
 * S = 1^3 + 3^3 + 5^3 + 7^3 + 11^3 + 13^3 ... + N^3 =
 * @author chimbocamila29 (Camila Chimbo)
 * @author Ethan Soto.
 * @author Victor Macas.
 */

public class PrimeNumberCalculatorCubeUpToLimit implements Sucessionable {

    private Integer limit;
    private Integer currentTerm;
    private final StringBuilder printableTerms;

    public PrimeNumberCalculatorCubeUpToLimit(Integer limit) {
        this(0, limit);
    }

    public PrimeNumberCalculatorCubeUpToLimit(Number start, Number limit) {
        if(start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        for (int i = 2; i < number; i++){
            if (number % i == 0){
                return  false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrime = false;
        while (!isPrime){
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime){
                currentTerm = currentTerm.intValue() +1;
            }
        }
        return currentTerm;
    }

    @Override
    public void setLimit(Number limit) {
        if (limit.intValue() < 0) {
            throw new IllegalArgumentException("Limit must be greater than 0");
        }
        this.limit = limit.intValue();
    }

    @Override
    public Number calculate() {
        Integer result = 0;
        int counterTerm = 0;
        int exponent = 3;

        currentTerm = this.currentTerm > 0 ? this.currentTerm - 1 : 0;
        currentTerm = nextTerm(currentTerm).intValue();
        while (currentTerm <= limit) {
            this.printableTerms.append(currentTerm).append("^(")
                    .append(exponent).append(") + ");
            result = result + (currentTerm * currentTerm * currentTerm);
            counterTerm++;
            currentTerm = nextTerm(currentTerm).intValue();
        }
        return result;
    }

    @Override
    public String print() {

        return printableTerms.toString();
    }



}

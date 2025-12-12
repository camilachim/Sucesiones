package unl.edu.ec.sucession.business;

import unl.edu.ec.sucession.domain.Sucessionable;

/**
 * Represente el calculo de la serie numeros Primos elevado a la potencia inversa del numero primo hasta N terminos.
 * (S = 1^(1/1) + 3^(1/3) + 5^(1/5) + 7^(1/7) + 11^(1/11) + 13^(1/13)):
 * @author chimbocamila29 (Camila Chimbo)
 * @author Ethan Soto.
 * @autor Victor Macas.
 */

public class PrimeNumberWithPowCalculatorWithTerm implements Sucessionable {

    private Integer currentTerm;
    private Integer limit;
    private StringBuilder printableTerms;

    public PrimeNumberWithPowCalculatorWithTerm(Number limit) {
        this(0, limit);
    }

    public PrimeNumberWithPowCalculatorWithTerm(Number start, Number limit) {
        if (start.intValue() < 0){
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        this.currentTerm = start.intValue();
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number){
        if(number < 1){
            return false;
        }
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
        Double result = 0.0;
        int counterTerm = 0;
        int exponent = 1;
        currentTerm = this.currentTerm > 0 ? this.currentTerm - 1 : 0;
        while(counterTerm < limit){
            currentTerm =nextTerm(currentTerm).intValue();
            this.printableTerms.append(currentTerm).append("^(1/")
                    .append(exponent).append(") + ");
            result = result + Math.pow(currentTerm, 1.0 / exponent);
            counterTerm++;
            exponent +=2;
        }

        return result;
    }

    @Override
    public String print() {

        return printableTerms.toString();
    }
}

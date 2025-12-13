package edu.unl.cc.jbeginners.sucession.business;

import edu.unl.cc.jbeginners.math.domine.Sucessionable;

public class PrimeEvenRootSeriesUpToLimit implements Sucessionable {
    private Integer limit;
    private Integer currentTerm;
    private Integer evenIndex;
    private final StringBuilder printableTerms;

    public PrimeEvenRootSeriesUpToLimit(Number limit) {
        this(0, limit);
    }

    public PrimeEvenRootSeriesUpToLimit(Number start, Number limit) {
        if (start.intValue() < 0) {
            throw new IllegalArgumentException("Start must be greater than 0");
        }
        setLimit(limit);
        currentTerm = nextTerm(start).intValue();
        evenIndex = 2;
        this.printableTerms = new StringBuilder("S = ");
    }

    private boolean isPrime(Integer number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        while (!isPrime(currentTerm.intValue())) {
            currentTerm = currentTerm.intValue() + 1;
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
        double result = 0;
        int counter = 0;

        while (counter < limit) {
            double exponent = 1.0 / evenIndex;
            double value = Math.pow(currentTerm, exponent);

            printableTerms
                    .append(currentTerm)
                    .append("^(1/")
                    .append(evenIndex)
                    .append(") + ");

            result += value;

            currentTerm = nextTerm(currentTerm).intValue();
            evenIndex += 2;
            counter++;
        }
        return result;
    }

    @Override
    public String print() {
        return printableTerms.substring(0, printableTerms.length() - 3);
    }
}

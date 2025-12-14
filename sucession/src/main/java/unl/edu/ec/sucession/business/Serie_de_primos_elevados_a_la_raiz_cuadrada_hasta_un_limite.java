/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package edu.unl.cc.serie_de_primos_elevados_a_la_raiz_cuadrada_hasta_un_limite;

/**
 * Serie de primos elevados a la raíz cuadrada hasta un límite
 * S = 1^(1/2) + 3^(1/2) + 5^(1/2) + 7^(1/2) + 11^(1/2) + 13^(1/2)+ .. + N^(1/2)
 * @author Camila Chimbo
 * @author Ethan Soto (Ethxn)
 * @author Victor Macas
 */

import unl.edu.cc.sucession.interfaces.Successionable;

public class Serie_de_primos_elevados_a_la_raiz_cuadrada_hasta_un_limite
        implements Successionable {

    private int limit;
    public void setLimit(Number limit) {
        this.limit = limit.intValue();
    }

    public Number nextTerm(Number currentTerm) {
        currentTerm = currentTerm.intValue() + 1;
        boolean isPrime = false;

        while (!isPrime) {
            isPrime = isPrime(currentTerm.intValue());
            if (!isPrime) {
                currentTerm = currentTerm.intValue() + 1;
            }
        }
        return currentTerm;
    }

    public Number calculate() {
        double sum = 0;

        for (int i = 1; i <= limit; i++) {
            if (isPrime(i)) {
                sum += Math.pow(i, 1.0 / 2.0);
            }
        }
        return sum;
    }

    private boolean isPrime(Integer number) {
        if (number < 2) return false;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Serie de primos elevados a la raíz cuadrada hasta un límite";
    }
}

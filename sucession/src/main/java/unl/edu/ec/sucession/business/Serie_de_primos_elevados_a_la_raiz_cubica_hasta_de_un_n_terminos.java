/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package unl.edu.cc.sucession.business;
/**
 * Serie de primos elevados a la raíz cúbica hasta un n términos
 * S = 1^(1/3) + 3^(1/3) + 5^(1/3) + 7^(1/3) + 11^(1/3) + 13^(1/3)
 *
 * @author Camila Chimbo
 * @author Ethan Soto (Ethxn)
 * @author Victor Macas
 */
import unl.edu.cc.sucession.interfaces.Successionable;

public class Serie_de_primos_elevados_a_la_raiz_cubica_hasta_un_n_terminos
        implements Successionable {

    private int nTerms;
    public void setLimit(Number limit) {
        this.nTerms = limit.intValue();
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
        int count = 0;
        int current = 1;
        double sum = 0;

        while (count < nTerms) {
            if (isPrime(current)) {
                sum += Math.pow(current, 1.0 / 3.0);
                count++;
            }
            current++;
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
        return "Serie de primos elevados a la raíz cúbica hasta un n términos";
    }
}

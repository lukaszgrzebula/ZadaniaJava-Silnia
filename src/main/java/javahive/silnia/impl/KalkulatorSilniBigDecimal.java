package javahive.silnia.impl;


import java.math.BigDecimal;

import javahive.silnia.KalkulatorSilni;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 *
 * @author Marcin Grabowiecki
 * 
 * proszę zaimplementować algorytm analogiczny jak dla SzybkaSilnia
 * jednak należy się oprzeć na na typie BigDecimal
 * 
 */

public class KalkulatorSilniBigDecimal implements KalkulatorSilni {
	public BigDecimal liczLong(int podstawa) {
		BigDecimal zero = BigDecimal.ZERO;
		BigDecimal jeden = BigDecimal.ONE;
		BigDecimal podst = BigDecimal.valueOf(podstawa);
		if (podstawa == 0) {
			return jeden;
		} else {
			while (podst.compareTo(BigDecimal.ONE) == 1) {
				jeden = jeden.multiply(podst);
				podst = podst.subtract(BigDecimal.ONE);
			}
			return jeden;
		}
	}

	public String licz(int arg) {
		if (arg < 0) {
			throw new ArithmeticException();
		}
		// wynik działania rekrurencyjnej metody rzutowany jest na String,
		// Bo string przechowa bez problemu duże liczby
		return "" + liczLong(arg);
	}
}

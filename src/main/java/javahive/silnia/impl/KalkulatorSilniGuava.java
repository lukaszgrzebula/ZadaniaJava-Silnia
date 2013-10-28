package javahive.silnia.impl;

import java.math.BigInteger;

import com.google.common.math.BigIntegerMath;

import javahive.silnia.KalkulatorSilni;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 *
 * @author mgr
 */
public class KalkulatorSilniGuava implements KalkulatorSilni {

	public String licz(int arg) {

		BigInteger wynik = BigIntegerMath.factorial(arg);
		Integer jeden = 1;

		if (arg < 0) {
			throw new ArithmeticException();
		} else if (arg == 0) {
			return jeden.toString();
		} else {
			return wynik.toString();
		}
	}
}

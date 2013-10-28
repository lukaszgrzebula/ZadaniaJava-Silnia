package javahive.silnia.impl;

import javahive.silnia.KalkulatorSilni;



public class OptymalnyKalkulatorSilni implements KalkulatorSilni {

	private static int MAKSYMALNY_ARGUMENT_DLA_LONG = 12;

	public String licz(int podstawa) {
		KalkulatorSilni i = null;
		if(podstawa>12){
			KalkulatorSilni kalk=new KalkulatorSilniBigDecimal();
			return kalk.licz(podstawa);
		}
		else{
			KalkulatorSilni kalk2=new SzybkiKalkulatorSilni();
			return kalk2.licz(podstawa);
		}
	}
}

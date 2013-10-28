package javahive.silnia;


import javahive.silnia.KalkulatorSilni;
import javahive.silnia.impl.KalkulatorSilniGuava;
import javahive.silnia.impl.KalkulatorSilniBigDecimal;
import javahive.silnia.impl.KalkulatorSilniNieRekurencyjny;
import javahive.silnia.impl.OptymalnyKalkulatorSilni;
import javahive.silnia.impl.SzybkiKalkulatorSilni;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author Marcin Grabowiecki
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SilniaTest {
	
    // to jest prosty test, który sprawdza implementację dostarczonego algorytmu,
    // liczącego w oparciu o typy long
    @Test
    public void t001PodstawowaImplementacjaPowinnaPoprawnieLiczycSilnie(){
        //given
    		final KalkulatorSilni kalkulatorSilni=new SzybkiKalkulatorSilni(); 
            final int silnia=10;
        //when
            String wynik=kalkulatorSilni.licz(silnia);
        //then
            Assert.assertEquals("3628800",wynik);
    }
    
    /*
     * test warunku brzegowego - liczby ujemne
     * 
     * pierwsze zdanie - uzupełnić algorytm w klasie SzybkiKalkulatorSilni o wykrywanie czy argument
     * nie jest ujemny. Jeśli jest - należy zwrócić wyjątek
     * Jak widać - test oczekuje że pojawi się wyjątek
     * 
     */
    
    @Test(expected = ArithmeticException.class)
    public void t002ArgumentyUjemnePowinnyWyrzucacWyjatek(){
        //given
    		final KalkulatorSilni kalkulatorSilni=new SzybkiKalkulatorSilni();
            final int silnia=-1;
        //when
            String wynik=kalkulatorSilni.licz(silnia);
        //then
            Assert.fail();
    }    
    
    /*
     * drugie zadanie - zaimplementować metodę licz w KalkulatorzeSilnikBigDecimal
     * tak by do jej liczenia były używane BigDecimal-e 
     */
    
    @Test
    public void t003KalkulatorPowinienLiczycPoprawnieDlaDuzychArgumentow(){
        //given
    		final KalkulatorSilni kalkulatorSilni=new KalkulatorSilniBigDecimal();
    		final int silnia=50;
        //when
            String wynik=kalkulatorSilni.licz(silnia);
        //then
            //w teście sprawdzam tylko pierwsze 10 cyfr
            Assert.assertEquals(wynik.substring(0,10), "3041409320");
    }

    
     /*
     * Zaimplementować algorytm w OptymalnymKalkulatorzeSilni tak, by algorytm automatycznie rozpoznawał
     * czy do liczenia użyć Szybkiej silni (małe argumenty) czy BigDecimalSilnia
     * (dla dużych argumentów)
     */
    
    @Test
    public void t004KalkulatorOptymalnejSilniPowinienPoprawnieLiczyc(){
        //given
    		final KalkulatorSilni kalkulatorSilni=new OptymalnyKalkulatorSilni();
    		final int silnia=50;
        //when
            String wynik=kalkulatorSilni.licz(silnia);
        //then
            Assert.assertEquals(wynik.substring(0,10), "3041409320");
    }

    
     /* 
     * Czasem zamiast odrywać Amerykę na nowo wystarczy poszukać dobrej biblioteki
     * zmodyfikuj pom.xml i zmodyfikuj GuavaSilnia tak by test kończył się sukcesem
     */
    
    @Test
    public void t005KalkulatorGuavaPowinienZwracacPoprawnyWynik(){
        //given
    		final KalkulatorSilni kalkulatorSilni=new KalkulatorSilniGuava();
            final int silnia=50;
        //when
            String wynik=kalkulatorSilni.licz(silnia);
        //then
            Assert.assertEquals(wynik.substring(0,10), "3041409320");
    }
    
    
    //test wszystkich algorytmów liczenia silni

    @Test
    public void t007WszystkieKalkulatorySilniPowinnyZwracacTenSamWynik(){
        //given
    		KalkulatorSilni[]wszytkieKalkulatory={
    				new SzybkiKalkulatorSilni(),
    				new OptymalnyKalkulatorSilni(),
    				new KalkulatorSilniGuava(),
    				new KalkulatorSilniBigDecimal(),
    				new KalkulatorSilniNieRekurencyjny()
    		};
            final int silnia=9;
        
        for(KalkulatorSilni kalkulator:wszytkieKalkulatory){
        //when
            String wynik=kalkulator.licz(silnia);
        //then
            Assert.assertEquals("362880", wynik);
        }
    }
    
    @Test
    public void WszystkieKalkulatorySilniPowinnyLiczycZero(){
    	KalkulatorSilni kalk=new SzybkiKalkulatorSilni();
    	Integer liczyZero=0;
    	String wynik=kalk.licz(0);
    	if(wynik.contains("1")){
    		liczyZero++;
    	}
    	else{
    		liczyZero=liczyZero;
    	}
    	
    	KalkulatorSilni kalk1=new OptymalnyKalkulatorSilni();
    	String wynik2=kalk.licz(0);
    	if(wynik.contains("1")){
    		liczyZero++;
    	}
    	else{
    		liczyZero=liczyZero;
    	}
    	
    	KalkulatorSilni kalk3=new KalkulatorSilniGuava();
    	String wynik3=kalk.licz(0);
    	if(wynik.contains("1")){
    		liczyZero++;
    	}
    	else{
    		liczyZero=liczyZero;
    	}
    	
    	KalkulatorSilni kalk4=new KalkulatorSilniBigDecimal();
    	String wynik4=kalk.licz(0);
    	if(wynik.contains("1")){
    		liczyZero++;
    	}
    	else{
    		liczyZero=liczyZero;
    	}
    	
    	KalkulatorSilni kalk5=new KalkulatorSilniNieRekurencyjny();
    	String wynik5=kalk.licz(0);
    	if(wynik.contains("1")){
    		liczyZero++;
    	}
    	else{
    		liczyZero=liczyZero;
    	}
    	
    	if(liczyZero==5){
    		// ;)
    	}
    	else{
    		Assert.fail();
    	}
    }
    

}
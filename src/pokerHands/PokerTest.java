package pokerHands;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import pokerHands.Hand;

public class PokerTest {
	
	@Test
	public void pokerKrolewski(){
		Hand h = new Hand("QD JD TD KD AD 7D 2S 5D 3S AC");			

		assertEquals(14, (int)Hand.poker(h.graczPierwszy).get(0));
		assertEquals(1, Hand.poker(h.graczPierwszy).size());
	}
	@Test
	public void poker(){
		Hand h = new Hand("6c 3c 5c 4c 7c 7D 2S 5D 3S AC");			
		int wartosc= Hand.poker(h.graczPierwszy).get(0); 	

		assertEquals(7, wartosc);
		assertEquals(1, Hand.poker(h.graczPierwszy).size());
	}
	
	@Test
	public void kareta(){
		Hand h = new Hand("9D 9S 9D 9S AC 7D 2S 5D 3S AC");			

		assertEquals(9, (int)Hand.kareta(h.graczPierwszy).get(0));
		assertEquals(14, (int)Hand.kareta(h.graczPierwszy).get(1));
		assertEquals(2, Hand.kareta(h.graczPierwszy).size());
	}
	@Test
	public void full(){
		Hand h = new Hand("6c Kd Ks 6s Kh 7D 2S 5D 3S AC");				

		assertEquals(13,(int)Hand.ful(h.graczPierwszy).get(0)); //wartoscTrojkiWrece
		assertEquals(6, (int)Hand.ful(h.graczPierwszy).get(1));//wartoscParyWrece		
		assertEquals(2, Hand.ful(h.graczPierwszy).size());
	}
	@Test
	public void kolor(){
		Hand h = new Hand("6c 3c Qc 2c Kc 7D 2S 5D 3S AC");			
				
		assertEquals(13, (int)Hand.kolor(h.graczPierwszy).get(0));
		assertEquals(12, (int)Hand.kolor(h.graczPierwszy).get(1));
		assertEquals(6, (int)Hand.kolor(h.graczPierwszy).get(2));
		assertEquals(3, (int)Hand.kolor(h.graczPierwszy).get(3));
		assertEquals(2, (int)Hand.kolor(h.graczPierwszy).get(4));
		assertEquals(5, Hand.kolor(h.graczPierwszy).size());
	}
	@Test
	public void stritAsJakoNiskaKarta(){
		Hand h = new Hand("2d 3h 5s 4h Ac 7D 2S 5D 3S Ad");			
		int wartosc= Hand.strit(h.graczPierwszy).get(0); 	

		assertEquals(5, wartosc);
		assertEquals(1, Hand.strit(h.graczPierwszy).size());
	}
	@Test
	public void strit(){
		Hand h = new Hand("8d 5h 6s 7h 4c 7D 2S 5D 3S Ad");			

		assertEquals(8, (int)Hand.strit(h.graczPierwszy).get(0));		
		assertEquals(1, Hand.strit(h.graczPierwszy).size());
	}
	@Test
	public void trojka(){
		Hand h = new Hand("8d 5h 8s 7h 8c 7D 2S 5D 3S Ad");			

		assertEquals(8, (int)Hand.trojka(h.graczPierwszy).get(0));
		assertEquals(7, (int)Hand.trojka(h.graczPierwszy).get(1));	
		assertEquals(5, (int)Hand.trojka(h.graczPierwszy).get(2));	
		assertEquals(3, Hand.trojka(h.graczPierwszy).size());
	}
	@Test
	public void dwiePary(){
		Hand h = new Hand("8d 5h 8s 5h 2c 7D 2S 5D 3S Ad");			

		assertEquals(8, (int)Hand.dwiePary(h.graczPierwszy).get(0));
		assertEquals(5, (int)Hand.dwiePary(h.graczPierwszy).get(1));	
		assertEquals(2, (int)Hand.dwiePary(h.graczPierwszy).get(2));	
		assertEquals(3, Hand.dwiePary(h.graczPierwszy).size());
	}
	@Test
	public void para(){
		Hand h = new Hand("QS JS QD KS AS 7D 2S 5D 3S AC");			
		int wartosc= Hand.para(h.graczPierwszy).get(0); 	

		assertEquals(12, wartosc);
		assertEquals(4, Hand.para(h.graczPierwszy).size());
	}
	@Test
	public void remisKart2graczy(){
		Hand h = new Hand("8C TS KC 9H 4S 8D 9S 4D KS TC");	
		
assertFalse(h.iloscWygranychGraczaPierwszego());
assertFalse(h.iloscWygranychGraczaDrugiego());
	}
	@Test
	public void porownanieWysokichKart2graczy(){
		Hand h = new Hand("8C TS KC 9H 4S 7D 2S 5D 3S JC");	
		
assertTrue(h.iloscWygranychGraczaPierwszego());
	}
	@Test
	public void porownanieKart2graczy1Poker2strit(){
		Hand h = new Hand("6c 3c 5c 4c 7c 6S 3H 5D 4D 7S");	
		
assertTrue(h.iloscWygranychGraczaPierwszego());
	}
	@Test
	public void kolorPorownanieKart2graczy1Kolor2Kolor(){
		Hand h = new Hand("6c 3c Qc 4c Kc 6S 3S QS 2S KS");	
		
assertTrue(h.iloscWygranychGraczaPierwszego());
	}

	
	

}
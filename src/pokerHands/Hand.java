package pokerHands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Hand {
	static final int ILOSC_KART = 5;
	Card[] graczPierwszy;
	Card[] graczDrugi;

	public Hand(String string) {
		
		graczPierwszy = new Card[ILOSC_KART];
		graczDrugi = new Card[ILOSC_KART];
		String[] karty = string.split(" ");
		for (int i = 0; i < ILOSC_KART; i++) {
			graczPierwszy[i] = new Card(karty[i]);
		}
		for (int i = 0; i < ILOSC_KART; i++) {
			graczDrugi[i] = new Card(karty[i + ILOSC_KART]);
		}
		
	}

	boolean iloscWygranychGraczaPierwszego() {
		Boolean wynik = null;
		if (wynik == null) {
			wynik = compare(poker(graczPierwszy), poker(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(kareta(graczPierwszy), kareta(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(ful(graczPierwszy), ful(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(kolor(graczPierwszy), kolor(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(strit(graczPierwszy), strit(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(trojka(graczPierwszy), trojka(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(dwiePary(graczPierwszy), dwiePary(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(para(graczPierwszy), para(graczDrugi));
		}
		if (wynik == null) {
			wynik = compare(wysokaKarta(graczPierwszy), wysokaKarta(graczDrugi));
		}

		return wynik;
	}
	boolean iloscWygranychGraczaDrugiego() {
		Boolean wynik = null;
		if (wynik == null) {
			wynik = compareGraczDrugi(poker(graczDrugi), poker(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(kareta(graczDrugi), kareta(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(ful(graczDrugi), ful(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(kolor(graczDrugi), kolor(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(strit(graczDrugi), strit(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(trojka(graczDrugi), trojka(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(dwiePary(graczDrugi), dwiePary(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(para(graczDrugi), para(graczPierwszy));
		}
		if (wynik == null) {
			wynik = compareGraczDrugi(wysokaKarta(graczDrugi), wysokaKarta(graczPierwszy));
		}

		return wynik;
	}

	public Boolean compare(List<Integer> kartyGraczaPierwszego, List<Integer> kartyGraczaDrugiego) {
		if (kartyGraczaPierwszego == null && kartyGraczaDrugiego == null) {
			return null;
		}
		if (kartyGraczaPierwszego == null) {
			return false;
		}
		if (kartyGraczaDrugiego == null) {
			return true;
		}
		for (int i = 0; i < kartyGraczaPierwszego.size(); i++) {
			if (kartyGraczaPierwszego.get(i) > kartyGraczaDrugiego.get(i)) {
				return true;
			}
			if (kartyGraczaPierwszego.get(i) < kartyGraczaDrugiego.get(i)) {
				return false;
			}
			
		}
		return false;
	}
	public Boolean compareGraczDrugi(List<Integer> kartyGraczaPierwszego, List<Integer> kartyGraczaDrugiego) {
		if (kartyGraczaPierwszego == null && kartyGraczaDrugiego == null) {
			return null;
		}
		if (kartyGraczaPierwszego == null) {
			return false;
		}
		if (kartyGraczaDrugiego == null) {
			return true;
		}
		for (int i = 0; i < kartyGraczaPierwszego.size(); i++) {
			if (kartyGraczaPierwszego.get(i) > kartyGraczaDrugiego.get(i)) {
				return true;
			}
			if (kartyGraczaPierwszego.get(i) < kartyGraczaDrugiego.get(i)) {
				return false;
			}

		}
		return false;
	}

	public static  List<Integer> poker(Card[] hand) {
		if (kolor(hand) != null) {
			return strit(hand);
		}

		return null;
	}

	public static List<Integer> kareta(Card[] hand) {
		List<Integer> wielkoscFigury = wysokaKarta(hand);
		if (wielkoscFigury.get(0) == wielkoscFigury.get(3) || wielkoscFigury.get(1) == wielkoscFigury.get(4)) {
			List<Integer> wynik = new ArrayList<Integer>();
			wynik.add(wielkoscFigury.get(1));
			wynik.add(wielkoscFigury.get(wielkoscFigury.get(0) == wielkoscFigury.get(1) ? 4 : 0));//jezeli prawda dodaj  add(wielkoscFigur.get(4))
			return wynik;
		}
		return null;
	}

	public static List<Integer> ful(Card[] hand) {
		List<Integer> wielkoscFigur = wysokaKarta(hand);
		if ((wielkoscFigur.get(2) == wielkoscFigur.get(0) && wielkoscFigur.get(3) == wielkoscFigur.get(4))
				|| (wielkoscFigur.get(2) == wielkoscFigur.get(4) && wielkoscFigur.get(1) == wielkoscFigur.get(0))) {
			List<Integer> wynik = new ArrayList<Integer>();
			wynik.add(wielkoscFigur.get(2));
			wynik.add(wielkoscFigur.get(wielkoscFigur.get(2) == wielkoscFigur.get(0) ? 4 : 0)); //jezeli prawda dodaj wielkoscFigur.get(4)
			return wynik;
		}

		return null;
	}

	public static List<Integer> kolor(Card[] hand) {
		for (int i = 1; i < hand.length; i++) {
			if (hand[0].kolor != hand[i].kolor) {
				return null;
			}
		}
		return wysokaKarta(hand);
	}

	public static List<Integer> strit(Card[] hand) {
		List<Integer> wielkoscFigury = wysokaKarta(hand);

		// aces can be used as either high or low in a straight.
		if (wielkoscFigury.get(0) == 14 && wielkoscFigury.get(1) == 5) {
			wielkoscFigury.remove(0);
			wielkoscFigury.add(1);
		}

		for (int i = 0; i < wielkoscFigury.size() - 1; i++) {
			if (wielkoscFigury.get(i) - 1 != wielkoscFigury.get(i + 1)) {
				return null;
			}
		}

		return wielkoscFigury.subList(0, 1); // pierwszy element
	}

	
	public static List<Integer> trojka(Card[] hand) {
		List<Integer> wynik = para(hand);
		if (wynik == null) {
			return wynik;
		}
		for (int i = 1; i < wynik.size(); i++) {
			if (wynik.get(0) == wynik.get(i)) {
				wynik.remove(i);
				return wynik;
			}
		}
		return null;
	}

	public static List<Integer> dwiePary(Card[] hand) {
		List<Integer> wynik = para(hand);
		if (wynik == null) {
			return null;
		}
		for (int i = 1; i < wynik.size() - 1; i++) {
			if (wynik.get(i) == wynik.get(i + 1)) {
				int wielkoscFiguryWparze = wynik.get(i);
				wynik.remove(i + 1);
				wynik.remove(i);
				wynik.add((wielkoscFiguryWparze > wynik.get(0) ? 0 : 1), wielkoscFiguryWparze);//jezeli prawda  add(0,wielkoscFiguryWparze)
				return wynik;
			}
		}
		return null;
	}

	public static List<Integer> para(Card[] hand) {
		List<Integer> wynik = wysokaKarta(hand);
		for (int i = 0; i < wynik.size() - 1; i++) {
			if (wynik.get(i) == wynik.get(i + 1)) {
				int pairRank = wynik.get(i);
				wynik.remove(i + 1);
				wynik.remove(i);
				wynik.add(0, pairRank);
				return wynik;
			}
		}
		return null;
	}

	public static List<Integer> wysokaKarta(Card[] hand) {
		List<Integer> wynik = new ArrayList<Integer>();
		for (Card c : hand) {
			wynik.add(c.wielkoscFigury);
		}
		Collections.sort(wynik);
		Collections.reverse(wynik);
		return wynik; // uporzadkowany zbior kart od najwiekszej
	}	

}

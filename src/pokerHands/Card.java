package pokerHands;


public class Card
{
	int wielkoscFigury;
	char kolor;

	Card(String s)
	{
		switch (s.charAt(0))
		{
		case 'A':
			wielkoscFigury = 14;
			break;
		case 'K':
			wielkoscFigury = 13;
			break;
		case 'Q':
			wielkoscFigury = 12;
			break;
		case 'J':
			wielkoscFigury = 11;
			break;
		case 'T':
			wielkoscFigury = 10;
			break;
		default:
			wielkoscFigury = Integer.parseInt(s.substring(0, 1));
		}

		this.kolor = s.charAt(1);
	}

}



























//public class Card
//{
//  private Kolor kolor;
//  private WysokoscKarty wysokoscKarty;
// 
//  public Card (WysokoscKarty wysokoscKarty, Kolor kolor)
//  {
//    this.wysokoscKarty = wysokoscKarty;
//    this.kolor = kolor;
//  }
// 
//  public Kolor getKolor()
//  {
//    return kolor;
//  }
// 
//  public void setKolor(Kolor kolor)
//  {
//    this.kolor = kolor;
//  }
// 
//  public WysokoscKarty getWysokoscKarty()
//  {
//    return wysokoscKarty;
//  }
// 
//  public void setWysokoscKarty(WysokoscKarty wysokoscKarty)
//  {
//    this.wysokoscKarty = wysokoscKarty;
//  }
//}

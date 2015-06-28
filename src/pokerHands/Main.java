package pokerHands;



public class Main {
	public static void main(String[] args) throws Exception	{
		System.out.println("Wygrane gracza Pierwszego: "+new iloscWygranychPrzezGraczaPierwszego().ileWygranych("poker.txt"));
		System.out.println("Wygrane gracza Drugiego: "+new iloscWygranychPrzezGraczaDrugiego().ileWygranych("poker.txt"));
	}	

}

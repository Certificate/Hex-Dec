/* Tämä harjoitus on tehty OS X käyttöjärjestelmällä käyttäen Sublime Text 3-sovellusta.
* Harjoituksen teki Valtteri Vuori
* vuori.valtteri.j@student.uta.fi
*/
 
public class Hex2Dec2Hex{
   //Vakioita.
   private static final char JOO = 'y';         
   private static final char EI = 'n';
   private static final int FROMHEX = 10; 
   private static final int FROMDEC = 16; 
   private static final String VIRHE = "Error!"; 
   public static void main(String[] args){
      System.out.println("Hello! I am your friendly number converter.");
      runko();
   }

   //"Varsinainen" ohjelman runko, josta kaikki lähtee. Helpottaa myös uudelleensuorittamista.
   public static void runko(){   
      System.out.println("Enter the target base (16/10):");
      int valinta = In.readInt();
      boolean ok = valinta == FROMHEX||valinta == FROMDEC;
      
      // Ilmiselvä silmukka oikean syötteen saamiseksi.
      while(!ok)       
      {
         System.out.println(VIRHE);
         System.out.println("Enter the target base (16/10):");
         valinta = In.readInt();
         ok = valinta == FROMHEX||valinta == FROMDEC;
      }

      if(valinta == FROMHEX)
         hex2Dec();
      else if (valinta == FROMDEC)
         dec2Hex();
   }
   
   public static void dec2Hex(){
      //Kysytään käyttäjältä syöte
      System.out.println("Enter a decimal number:");       
      int numero = In.readInt();

      //Silmukka oikean syötteen saamiseksi.
      do{                                                 
        if(numero < 0){
          System.out.println(VIRHE);
          System.out.println("Enter a decimal number:");
          numero = In.readInt();
        }
      }
      while(numero < 0);

      // Laskun lopputulos
      String tulos="";  

      // Määritellään heksadesimaaliluvut.               
      String hex = "0123456789ABCDEF";

      // Jakojäännös laskua varten 
      int jakoJ;   

      // Ja itse laskuri                    
      while(numero>0)                 
      {
        jakoJ = numero % 16; 
        tulos = hex.charAt(jakoJ) + tulos; 
        numero = numero / 16;
      }

      // Lopputuloksen julistus.
      System.out.println("As hexadecimal: "+tulos); 

      //Kysytään haluaako käyttäjä jatkaa.  (Sama koodipätkä myöhemmin koodissa uudestaan.)
      System.out.println("Continue (y/n)?");         
      char vastaus = In.readChar();
      boolean ok3 = (vastaus == JOO || vastaus == EI);
      while(!ok3)
      {
         System.out.println(VIRHE);
         System.out.println("Continue (y/n)?");
         vastaus = In.readChar();
         ok3 = (vastaus == JOO || vastaus == EI);
      }
      if(vastaus == EI)
         System.out.println("See you soon.");
      else if(vastaus == JOO)
         runko();
    }
   
   public static void hex2Dec(){

      //Kysytään käyttäjältä syöte.
      System.out.println("Enter a hexadecimal number:");
      String input = In.readString();
      boolean onkoHex = onHeksadesimaali(input);
      if(onkoHex)
      {}
      else{
      do{
         System.out.println(VIRHE);
         System.out.println("Enter a hexadecimal number:");
         input = In.readString();
         onkoHex = onHeksadesimaali(input);
      }
      while(!onkoHex);
      }
      int k = input.length();
      int j = input.length()-1;
      int summa = 0;

      //Silmukka, jossa lasketaan itse laskutoimitukset. Kommentit silmukan toiminnasta vain ensimäisessä if-ehdossa.
      for (int a = 0; a <= j; a++){

         // ^ muuttuja j on syötteen pituus - 1 koska indeksiarvot alkavat 0123 kun taas sana.length 1234 koska järki?
         //On luettu käyttäjän syöte, niin tämä luuppi lukee kirjain kirjaimelta mitä syötteessä on.
         if(input.charAt(a) == '1')
            summa = summa + 1 * (int)Math.pow(16, k-1); //Jos lukijan eteen sattuu kirjain 1, niin se suorittaa laskutoimituksen.                    
         else if(input.charAt(a) == '2')
            summa = summa + 2 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '3')
            summa = summa + 3 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '4')
            summa = summa + 4 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '5')
            summa = summa + 5 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '6')
            summa = summa + 6 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '7')
            summa = summa + 7 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '8')
            summa = summa + 8 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '9')
            summa = summa + 9 * (int)Math.pow(16, k-1);           
         else if (input.charAt(a)== 'A') 
            summa = summa + 10 * (int)Math.pow(16, k-1);
         else if (input.charAt(a)== 'B') 
            summa = summa + 11 * (int)Math.pow(16, k-1);
         else if (input.charAt(a)== 'C') 
            summa = summa + 12 * (int)Math.pow(16, k-1);
         else if (input.charAt(a)== 'D')
            summa = summa + 13 * (int)Math.pow(16, k-1);
         else if (input.charAt(a)== 'E')
            summa = summa + 14 * (int)Math.pow(16, k-1);
         else if (input.charAt(a)== 'F') 
            summa = summa + 15 * (int)Math.pow(16, k-1);
         else if(input.charAt(a) == '0')
            summa = summa + 0 * (int)Math.pow(16, k-1);

         //Heksadesimaaleja muuttaessa 16:sta potenssi laskee aina yhdellä.
         k = k-1;                                      
      }
      //Tulostetaan lopullinen arvo.
      System.out.println("As decimal: "+summa); 

      //Kysytään jatkoa.     
      System.out.println("Continue (y/n)?");         
      char vastaus = In.readChar();
      boolean ok3 = (vastaus == JOO || vastaus == EI);
      while(!ok3)
      {
         System.out.println(VIRHE);
         System.out.println("Continue (y/n)?");
         vastaus = In.readChar();
         ok3 = (vastaus == JOO || vastaus == EI);
      }
      if(vastaus == EI)
         System.out.println("See you soon.");
      else if(vastaus == JOO)
         runko();
   }

   // Heksadesimaalitarkistaja
   public static boolean onHeksadesimaali(String input){
         for(int i = 0; i < input.length(); i++){
            char merkki = input.charAt(i);
            if((merkki < 'A' || merkki > 'F') && (merkki < '0' || merkki > '9')){
               return false;
         }
      }
      return true;  
   }
}

import java.io.*;
import java.security.acl.LastOwnerException;
import java.util.*;
import javax.security.auth.callback.LanguageCallback;

/**
 * 
 * @author Chloé BANCHET, Dania KAAKATI
 *
 */

public class LaunchMe {
	
	//Cardinalité n
	static int n;
	
	//Bornes minimales et maximales des 2 attributs du QID
	static int borneMin;
	static int borneMax;
	
	//Paramètre de confidentialité k pour le k-Anonymat
	static int k;
	
	//Intervalles des QUID
	int quid1min = 0;
	int quid1max = 10;
	int quid2min = 20;
	int quid2max = 40;
	
	
	//Liste des maladies, données sensibles SD
	static String[] str = {"Angine Rouge", "Grippe", "Angine Blanche", "Rhinopharyngite", "Oblomovisme", "Angine", "Angine érythémateuse", "Angine érythémato-pultacée"};
	
	public LaunchMe(/*int n, int borneMin, int borneMax, int k*/){
		this.n= 10;
		this.borneMin = 0;
		this.borneMax = 8;
		this.k = 2;
	}
	

	public void mondrian(ArrayList<Data> liste){
		int dim = chooseDimension(liste);
	}
	
	public int chooseDimension(ArrayList<Data> liste){
		int taille = liste.size();
		int quidT1 = 0;
		int quidT2 = 0;
		int quid1min;
		int quid1max;
		int quid2min;
		int quid2max;
		
		/*for(int i = 0; i < taille; i++){
			if(quidT1 < liste.get(i).getQuid1()){
				quid1min = quidT1;
			}else{
				quid1max = liste.get(i).getQuid1();
			}
			
			if(quidT2 < liste.get(i).getQuid2()){
				quid2min = quidT2;
				System.out.println(quidT2);
			}else{
				quid2max = liste.get(i).getQuid2();
				System.out.println(quid2max);
			}
			System.out.println(quidT2 < liste.get(i).getQuid2());
			System.out.println(quidT2);
			System.out.println(liste.get(i).getQuid2());
			
		}*/
		
		int quid1middle = (this.quid1max - this.quid1min);
		
		int quid2middle = (this.quid2max - this.quid2min);
		
		int dim = 0;
		
		if(quid2middle > quid1middle){
			dim =2;
		}
		else{
			dim=1;
		}
		
		return dim ;
	}
	
	public HashMap<Integer, Integer> frequencySet(ArrayList<Data> liste, int dim){
		
	}
	
	/**
	 * Permet d'effectuer un tirage aléatoire sur une liste de String
	 * @param listeA
	 * @return un string aléatoirement tiré
	 */
	public String tirageRandom(){
		int i = this.borneMax - this.borneMin;
		Random rand = new Random();
		int random = rand.nextInt(i);
		return str[random];
	}
	
	public static void main (String []args) throws IOException{
		LaunchMe lm = new LaunchMe();
		Random rand = new Random();
		int i,random;
		BufferedWriter bw = new BufferedWriter(
				new FileWriter(
						new File("./monJeuDeDonnes.csv"),
						false
				)
		);
		
		
		ArrayList<Data> tab2 = new ArrayList<Data>();
		
		for(i=0;i<lm.n;i++){
			//Recherche d'une valeur aléatoire entre les quid1 min et max
			int quid1 = rand.nextInt((lm.quid1max - lm.quid1min) +1) + lm.quid1min;
			
			//Recherche d'une valeur aléatoire entre les quid2 min et max
			int quid2 = rand.nextInt((lm.quid2max - lm.quid2min) +1) + lm.quid2min;
			
			//Tirage random dans les données sensibles
			String str = lm.tirageRandom();
			
			Data data = new Data(quid1,quid2,str);
			
			tab2.add(data);
			
			//Ecriture du résultat dans un fichier
			//bw.append(data.toString());

			//Affichage dans la console du réusltat
			System.out.println(data.toString());
		}
		
		System.out.println(lm.chooseDimension(tab2));	
		
		
	}

}

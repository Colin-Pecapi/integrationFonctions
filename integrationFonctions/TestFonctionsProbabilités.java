package integrationFonctions;

import static integrationFonctions.FonctionsProbabilites.*;

public class TestFonctionsProbabilites {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		/** Test de la loi de gausse */
//		double gauss = loi_de_gauss(1);
//		//System.out.println("Gauss(1) = " + gauss);
//		//Parametres de la loi normal centré réduite
//		/*double valeur ;
//		double moyenne = 0.0 ;
//		double phi = 1.0 ;
//		double echantillonage = 0.1;
//		double x_min = 0.0 ;
//		double x_max = 3.0;*/
//		
//		//Parametres d'une variable aléatoir suivant la loi normal 
//		double valeur ;
//		double moyenne = 3 ;
//		double phi = 0.2 ;
//		double echantillonage = 0.1;
//		double x_min = 0.0 ;
//		double x_max = 3.0;
//		
//		int taille = (int) (((x_max - x_min)/echantillonage) +1.0);
//		double normal[] = loi_normal( moyenne,  phi,  echantillonage,  x_min, x_max );
//		for(int i = 0; i < taille;i++){
//			valeur = (i*echantillonage) + x_min;
//			//System.out.println("Normal(" + valeur +") = " + normal[i]);
//		}
//		
//		/** Loi du khi deux*/
//		int kkhi = 32;
//		double echantillonagekhi = 0.5;
//		double x_minkhi = 0.0;
//		double x_maxkhi = 2*kkhi;
//		
//		double[] khideux = loi_du_khi_deux(kkhi, echantillonagekhi, x_minkhi, x_maxkhi);
//		
//		int taillekhi = (int) (((x_maxkhi - x_minkhi)/echantillonagekhi)+1);
//		System.out.println("degree de liberté : " + kkhi);
//		for(int i = 0; i < taillekhi;i++){
//			valeur = (i*echantillonagekhi) + x_minkhi;
//			System.out.println("khi_deux(" + valeur +") = " + khideux[i]);
//		}
		double[] k2 =  loi_du_khi_deux(2, 0.5, 0, 4);
		for (int i = 0; i < k2.length; i++) {
			System.out.println("" + (((double) i)/2.0) + " = "  + k2[i]);
		}

	}

}

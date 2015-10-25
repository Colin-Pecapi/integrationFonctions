/**
 * Int�gration de fonctions - 23/10/2015
 * @author SERENE Guilhem
 */
package integrationFonctions;

import static integrationFonctions.MethodesIntegrations.*;


/**
 * Classe permettant de tester les diff�rentes m�thodes int�grations
 */
public class ComparaisonMethodesIntegrations {
	
	/**
	 * Affiche le r�sultat de toutes les m�thodes d'int�grations 
	 * 					ainsi que leur temps d'execution
     * @param a - Borne inf�rieure de l'intervalle 
     * @param b - Borne sup�rieure de l'intervalle
     * @param fx - Images de X
	 * @param resultatExact - R�sultat exact obtenu avec le calcul � la main
	 */
	private static void comparaisonToutesMethodes(double a, double b, double fx[], double resultatExact) {
		
		long duree;

		integrationRectangleSup(a, b, fx); //Calcul Inutile d�gripant le 1er calcul
		
		
		duree = System.nanoTime();
		integrationRectangleSup(a, b, fx);
		duree = System.nanoTime() - duree; 
	    System.out.printf("Rectangle ........ : %.16f en %d ns\n", 
	    		integrationRectangleSup(a, b, fx), duree);
		
		duree = System.nanoTime();
		integrationRectangleAmeliore(a, b, fx);
		duree = System.nanoTime() - duree; 
	    System.out.printf("Rectangle Ameliore : %.16f en %d ns\n", 
	    		integrationRectangleAmeliore(a, b, fx), duree);
		
		duree = System.nanoTime();
		integrationTrapeze(a, b, fx);
		duree = System.nanoTime() - duree; 
	    System.out.printf("Trapeze .......... : %.16f en %d ns\n", 
	    		integrationTrapeze(a, b, fx), duree);

		
		duree = System.nanoTime();
		integrationSimpson(a, b, fx);
		duree = System.nanoTime() - duree; 
	    System.out.printf("Simpson .......... : %.16f en %d ns\n", 
	    		integrationSimpson(a, b, fx), duree);
		

		   
	    System.out.printf("R�sultat exact ... : %.16f\n", resultatExact);
	    
	    
	}
	
	 /**
     * Programme de tests de performance 
     * et de pr�cision de la classe MethodesIntegrations
     * @param args - Non utilis�
     */
    public static void main(String[] args) {
        
        int nbPas;
        double a,b,pas;
        double fx[];
        long duree;
        
        nbPas = 100; //Commun � tous les tests suivants
        
        /* POLYNOMES DE DEGRES 1 */
        //G�n�ration des fx pour la fonction f(x)=(x+1)
        a = 4.0;
        b = 6.0;
        
        fx = new double[nbPas+1];
        pas = (b-a)/((double) nbPas);
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = ((a + pas*(double) i) +1.0) ;  
        }                
        System.out.println("\nInt�gration de f(x)=(x+1) de " + a + " � " + b 
        		+ " avec " + nbPas + " pas par la m�thode du");        
        comparaisonToutesMethodes(a, b, fx, 12.0);
        
        /* POLYNOMES DE DEGRES 2 */
        //G�n�ration des fx pour la fonction f(x)=(-x^2+x+1)
        a = -1.0;
        b = 1.0;
        
        pas = (b-a)/((double) nbPas);
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = (-((a + pas*(double) i)*(a + pas*(double) i))
            		+ (a + pas*(double) i) +1.0) ;  
        }    
        System.out.println("\nInt�gration de f(x)=(-x^2+x+1) de " + a + " � " + b 
        		+ " avec " + nbPas + " pas par la m�thode du");
        comparaisonToutesMethodes(a, b, fx, (4.0/3.0));
        
        /* POLYNOMES DE DEGRES 3+ */
        //G�n�ration des fx pour la fonction f(x)=(x^3)
        a = -100.0;
        b = 100.0;
        
        pas = (b-a)/((double) nbPas);
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = Math.pow((a + pas*(double) i), 3);
        }    
        System.out.println("\nInt�gration de f(x)=(x^3) de " + a + " � " + b 
        		+ " avec " + nbPas + " pas par la m�thode du");
        comparaisonToutesMethodes(a, b, fx, 0.0);
        
        
        /* FONCTIONS ELEMENTAIRES */
        //G�n�ration des fx pour la fonction f(x)=cos(x)
        a = 0.0;
        b = Math.PI;
        
        pas = (b-a)/((double) nbPas);
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = Math.sin(a + pas*((double) i));  
        }
        System.out.println("\nInt�gration de f(x)=sin(x) de " + a + " � " + b 
        		+ " avec " + nbPas + " pas par la m�thode du");
        comparaisonToutesMethodes(a, b, fx, 2.0);
        
        //G�n�ration des fx pour la fonction f(x)=ln(x)
        a = 0.0;
        b = 1.0;
        
        pas = (b-a)/((double) nbPas);
        fx = new double[nbPas+1];
        for(int i=0; i < (nbPas+1); i++) {
            fx[i] = Math.exp(a + pas*((double) i));  
        }
        System.out.println("\nInt�gration de f(x)=e(x) de " + a + " � " + b 
        		+ " avec " + nbPas + " pas par la m�thode du");
        comparaisonToutesMethodes(a, b, fx, Math.exp(1.0) - 1.0);
        
    }
}

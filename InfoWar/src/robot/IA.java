package robot;

import java.util.Random;

import plateau.Plateau;

public class IA {
	private int niveau;
	private Random alea = new Random();;
	
	public IA(int niveau){
		this.niveau = niveau;
	}
	
	public String choixAction(Robot r, Plateau p){
		String actionName;
		int g;
		if(niveau == 1){
			g = alea.nextInt(2);
		
			if(g == 0){
				actionName = "a";
			}
			else{
				actionName = "d";
			}
		}
		//ici vient l'IA intelligente
		else{
			if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).equals(null)
					|| !p.getContenu(r.getCoordonnees().getLargeur()+1, r.getCoordonnees().getHauteur()).equals(null)){
				
				actionName = "a";
			}
			else{
				actionName = "d";
			}
		}		
		return actionName;
	}
	
	public String choixDeplacement(Robot r, Plateau p, String actionName){
		String deplacementName;
		if(niveau == 1){
			int g = alea.nextInt(7);

			if(g == 0){
				deplacementName = "z";
			}
			else if(g == 1){
				deplacementName = "q";
			}
			else if(g == 2){
				deplacementName = "s";
			}
			else if(g == 3){
				deplacementName = "d";
			}
			else if(g == 4){
				deplacementName = "a";
			}
			else if(g == 5){
				deplacementName = "e";
			}
			else if(g == 6){
				deplacementName = "w";
			}
			else{
				deplacementName = "c";
			}
		}
		//ici vient l'IA intelligente
		else{
			if(actionName == "a"){
				if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()+1).equals(null)){
					deplacementName = "z";
				}
				else if(!p.getContenu(r.getCoordonnees().getLargeur(), r.getCoordonnees().getHauteur()-1).equals(null)){
					deplacementName = "s";
				}
				else if(!p.getContenu(r.getCoordonnees().getLargeur()-1, r.getCoordonnees().getHauteur()).equals(null)){
					deplacementName = "q";
				}
				else{
					deplacementName = "d";
				}
			}
			else{
				deplacementName = "z";
			}			
		}
		return deplacementName;
	}
}

package service;



public class Sorts {


	
	
	float poder[] = new float[5];
	String nomeCavaleiros[];
	int auxDificuldade[];
	int ordemNova[] = {0,1,2,3,4,5,6,7,8,9,10,11};
	
	
	
	public Sorts() {
		super();
		
	}
	public int[] sortDificuldadeCasas(int[] dificuldadesCasas){
		
		
		auxDificuldade = dificuldadesCasas;
		//organiza ordem do par das lutas com dificuldades das casas
		boolean troca = true;
	    int aux;
	    int auxIndice;
	    while (troca) {
	    	troca = false;
	    	for (int i = 0; i < auxDificuldade.length - 1; i++) {
	    		if (auxDificuldade[i] > auxDificuldade[i + 1]) {
	    			aux = auxDificuldade[i];
	    			auxDificuldade[i] = auxDificuldade[i + 1];
	    			auxDificuldade[i + 1] = aux;
	            	auxIndice = ordemNova[i];
	            	ordemNova[i] = ordemNova[i + 1];
	            	ordemNova[i + 1] = auxIndice;
	            	troca = true;
	    		}
	     	}
	    }
	    return ordemNova;
		
	}
	public float[] sortPoderCosmico(float[] poder){
		boolean troca = true;
	    float aux;
	    String str = new String();
	    while (troca) {
	    	troca = false;
	    	for (int i = 0; i < poder.length - 1; i++) {
	    		if (poder[i] > poder[i + 1]) {
	    			aux = poder[i];
	    			poder[i] = poder[i + 1];
	    			poder[i + 1] = aux;
	    			str = nomeCavaleiros[i];
	    			nomeCavaleiros[i] = nomeCavaleiros[i + 1];
	    			nomeCavaleiros[i + 1] = str;
	            	troca = true;
	    		}
	     	}
	    }
		 return poder;
	}
	public void setNomeCavaleiros(String[] nomeCavaleiros){
		this.nomeCavaleiros = nomeCavaleiros;
	}
	
}

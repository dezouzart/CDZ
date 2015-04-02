package model;

import javax.swing.JButton;

public class Terreno {
	public int custo;
	public String tipo;
	public JButton bloco;
	
	public Terreno (String tipoTerreno){
		switch (tipoTerreno){
		case "MONTANHA":
			tipo = tipoTerreno;
			custo = 200;
			break;
		case "ROCHA":
			tipo = tipoTerreno;
			custo = 5;
			break;
		case "PLANO":
			tipo = tipoTerreno;
			custo = 1;
			break;
		case "CASA":
			tipo = tipoTerreno;
			custo = 0;
			break;
		case "DESTINO":
			tipo = tipoTerreno;
			custo = 0;
			break;
		case "INICIO":
			tipo = tipoTerreno;
			custo = 0;
			break;
		case "ATENA":
			tipo = tipoTerreno;
			custo = 0;
			break;
		}
	}
}

package model;

import javax.swing.JButton;

public class Terreno {
	public int custo;
	public String tipo;
	public JButton bloco;
	public boolean valido;
	
	public Terreno (String tipoTerreno){
		switch (tipoTerreno){
		case "MONTANHA":
			tipo = tipoTerreno;
			custo = 200;
			valido = true;
			break;
		case "ROCHA":
			tipo = tipoTerreno;
			custo = 5;
			valido = true;
			break;
		case "PLANO":
			tipo = tipoTerreno;
			custo = 1;
			valido = true;
			break;
		case "CASA":
			tipo = tipoTerreno;
			custo = 0;
			valido = true;
			break;
		case "DESTINO":
			tipo = tipoTerreno;
			custo = 0;
			valido = true;
			break;
		case "INICIO":
			tipo = tipoTerreno;
			custo = 0;
			valido = true;
			break;
		case "ATENA":
			tipo = tipoTerreno;
			custo = 0;
			valido = true;
			break;
		}
	}
}

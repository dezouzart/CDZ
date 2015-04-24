package service;

import java.util.ArrayList;
import java.util.Collections;

import model.Casa;
import model.Mapa;
import service.NoBusca;

public class SmartBusca {
	
	ArrayList <NoBusca> openSet = new ArrayList <NoBusca> (); //Nos a serem visitados
	ArrayList <NoBusca> closedSet = new ArrayList <NoBusca> (); //Nos ja visitados
	Boolean chegou = false;
	
	public ArrayList<String> caminho;
	
	Mapa m;
	
	public SmartBusca(Mapa m)
	{
		this.m = m;
	}
	
	public void aEstrela(int xOrigem, int yOrigem, int xDestino, int yDestino, Casa casa)
	{
		int xAtual, yAtual;
		NoBusca aux;
		NoBusca noAtual = new NoBusca(xOrigem, yOrigem); 
		noAtual.setCusto(0); 
		noAtual.setHeuristica(heuristica(xOrigem, yOrigem, xDestino, yDestino));
		noAtual.setCustoTotal(noAtual.getHeuristica());
		openSet.add(noAtual);
		
		while(openSet.size() != 0)
		{
			xAtual = noAtual.getX();
			yAtual = noAtual.getY();
			if(noAtual.getX() == xDestino && noAtual.getY() == yDestino)
	        {
				if(casa != null)
					casa.setCusto(noAtual.getCustoTotal());
				constroiCaminho(noAtual); //Monta lista com dire��es
				chegou = true;
				break;
	        }
			//Checa terreno de cima
			if(m.terrenoValido(xAtual, yAtual-1) && !checaVisitados(xAtual, yAtual-1))
			{
				aux = new NoBusca(xAtual, yAtual-1);
				aux.setNoPai(noAtual);
				aux.setCusto(m.getCusto(xAtual, yAtual-1)) ;
				aux.setHeuristica(heuristica(xAtual, yAtual-1, xDestino, yDestino));
				custoTotal(aux);
				checaNaoVisitados(aux);
			}
			//Checa terreno de baixo
			if(m.terrenoValido(xAtual, yAtual+1) && !checaVisitados(xAtual, yAtual+1))
			{
				aux = new NoBusca(xAtual, yAtual+1);
				aux.setNoPai(noAtual);
				aux.setCusto(m.getCusto(xAtual, yAtual+1)) ;
				aux.setHeuristica(heuristica(xAtual, yAtual+1, xDestino, yDestino));
				custoTotal(aux);
				checaNaoVisitados(aux);
			}
			//Checa terreno da esquerda
			if(m.terrenoValido(xAtual-1, yAtual) && !checaVisitados(xAtual-1, yAtual))
			{
				aux = new NoBusca(xAtual-1, yAtual);
				aux.setNoPai(noAtual);
				aux.setCusto(m.getCusto(xAtual-1, yAtual)) ;
				aux.setHeuristica(heuristica(xAtual-1, yAtual, xDestino, yDestino));
				custoTotal(aux);
				checaNaoVisitados(aux);
			}
			//Checa terreno da direita
			if(m.terrenoValido(xAtual+1, yAtual) && !checaVisitados(xAtual+1, yAtual))
			{
				aux = new NoBusca(xAtual+1, yAtual);
				aux.setNoPai(noAtual);
				aux.setCusto(m.getCusto(xAtual+1, yAtual)) ;
				aux.setHeuristica(heuristica(xAtual+1, yAtual, xDestino, yDestino));
				custoTotal(aux);
				checaNaoVisitados(aux);
			}
			
			closedSet.add(noAtual);
			openSet.remove(0);
			Collections.sort(openSet); //Ordena por menor custo a lista de n�s a serem visitados
			noAtual = openSet.get(0); 
		}
		if (!chegou)
		{
			System.out.println ("Caminho invalido. \n");
		}
	}
	
	public int heuristica(int x1, int y1, int x2, int y2) // Distancia de Manhattan
	{
		return Math.abs(x2-x1) + Math.abs(y2-y1);
	}
	
	public boolean checaVisitados(int x, int y)
	{
		for(int i=0; i<closedSet.size(); i++)
		{
			if(closedSet.get(i).getX() == x && closedSet.get(i).getY() == y)
				return true;
		}
		return false;
	}
	
	public void checaNaoVisitados(NoBusca no)
	{
		int pos = -1;
		for(int i=0; i<openSet.size(); i++)
		{
			if(openSet.get(i).getX() == no.getX() && openSet.get(i).getY() == no.getY())
			{
				pos = i;
				break;
			}
		}
		if(pos != -1)
		{
			if(no.getCustoTotal() < openSet.get(pos).getCustoTotal())
				openSet.get(pos).setNoPai(no.getNoPai());
		}
		else
			openSet.add(no);
	}

    public void constroiCaminho(NoBusca no)
    {
     
        caminho = new ArrayList<String>();
        while(no.getNoPai() != null)
        {
            if(no.getY() - no.getNoPai().getY() == 1)   
                caminho.add(0, "baixo");
            else if(no.getY() - no.getNoPai().getY() == -1)
                caminho.add(0, "cima");
            else if(no.getX() - no.getNoPai().getX() == 1)
                caminho.add(0, "direita");
            else if(no.getX() - no.getNoPai().getX() == -1)
                caminho.add(0, "esquerda");
           
            no = no.getNoPai();
        }
       
    }
	
	public void custoTotal(NoBusca no)
	{
		int ct = no.getCusto() + no.getHeuristica();
		NoBusca aux = no;
		
		while(aux.getNoPai() != null)
		{
			aux = aux.getNoPai();
			ct += aux.getCusto();
		}
		
		no.setCustoTotal(ct);
	}
	
	public void resetarCaminho()
	{
		openSet = new ArrayList <NoBusca> ();
		closedSet = new ArrayList <NoBusca> ();
	}

}

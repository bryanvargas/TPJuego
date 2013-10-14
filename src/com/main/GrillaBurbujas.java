package com.main;

public class GrillaBurbujas {
	
	
	 private ObjetoGrafico[][] matrizBurbujas;
	 private int anchoCelda;
	 private int altoCelda;
	 
	 public GrillaBurbujas(int filas, int columnas, int anchoTotal, int altoTotal) {
		 
		 this.matrizBurbujas = new Burbuja[filas][columnas];
		 this.anchoCelda = anchoTotal / columnas;
		 this.altoCelda = altoTotal / filas;
	 }
	 
	 public void setBurbuja(Burbuja b, int fila, int columna){
		 this.matrizBurbujas[fila][columna] = b;
		 b.x = columna * this.anchoCelda + this.anchoCelda / 2;
		 b.y = fila * this.altoCelda + this.altoCelda / 2;
	 }
	
	 public Burbuja getBurbuja(int fila, int columna){
		 return (Burbuja)matrizBurbujas[fila][columna];
	 }
	
	 public void dibujarGrilla(Entorno ent){
		 
		 for (int fila = 0; fila < filas(); fila++)
			 for (int columna = 0; columna < columnas(); columna++)
				 if (this.matrizBurbujas[fila][columna] != null)
					 this.matrizBurbujas[fila][columna].dibujarAEscala(ent, this.anchoCelda, this.altoCelda);
	 }
	 
	 public int filas(){
		 return matrizBurbujas.length;
	 }
	
	 public int columnas(){
		 return matrizBurbujas[0].length;
	 }
}

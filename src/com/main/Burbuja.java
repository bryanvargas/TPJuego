package com.main;

import java.awt.Image;

import entorno.*;

public class Burbuja {

	double x, y;
	double angulo;
	Image imagen;
	
	Burbuja(double unX, double unY, double unAngulo) {
		this.x = unX;
		this.y = unY;
		this.angulo = unAngulo;
		this.imagen = Herramientas.cargarImagen("img/bubble2.png");
	}
	
	public void dibujar(Entorno ent) {
		ent.dibujarImagen(this.imagen, this.x, this.y, 0, 0.3
				);
	}
	
	public void avanzar(Entorno ent) {
		this.angulo = this.angulo + 0.6*(Math.random()-0.5);
		this.x += Math.cos(angulo);
		this.y += Math.sin(angulo);
	}
}




package com.main;
import java.awt.Image;

import java.util.Random;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	private Entorno entorno;	
	private Image fondo;
	private Flecha flechita;
	private Disparo Metra;
	
	Juego()
	{	
		this.Metra = new Disparo(); 
		
		Random gen = new Random();
		
		this.flechita = new Flecha(800/2, 560, -90);
		//burbujitas = new Burbuja[10];
		//for(int i=0; i<this.burbujitas.length; i++)
			//this.burbujitas[i] = new Burbuja(gen.nextInt(800),
					                    //gen.nextInt(600),
					                    //Math.random()*2*Math.PI);
		this.fondo = Herramientas.cargarImagen("img/fondo.jpg");
		/* 
		 * Es fundamental que al final del constructor de la clase Juego se 
		 * construya un objeto entorno de la siguiente manera.
		 */
		this.entorno = new Entorno(this, 
				                   "Burbujas",
				                   800, 600);
	}
	/*
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		//Actualizo Todo
		if(entorno.estaPresionada(entorno.TECLA_IZQUIERDA))
			this.flechita.girarIzquierda(0.05);
		if(entorno.estaPresionada(entorno.TECLA_DERECHA))
			this.flechita.girarDerecha(0.05);
		this.flechita.avanzar(this.entorno);
		
		if(entorno.estaPresionada(entorno.TECLA_ESPACIO))
			this.Metra.DISPARAR(flechita);
			
		//for(int i=0; i<burbujitas.length; i++)
			//this.burbujitas[i].avanzar(this.entorno);
		
		// Dibujo Todo
		this.entorno.dibujarImagen(this.fondo, 
				                   entorno.getWidth()/2,
				                   entorno.getHeight()/2, 0);
		
		//MOVER DISPAROS
		Metra.MoverDisparo(this.entorno);
		//for(int i=0; i<burbujitas.length; i++)
			//this.burbujitas[i].dibujar(this.entorno);
		this.flechita.dibujar(this.entorno);	
		this.Metra.collisionwithwall(this.entorno);
		//Dibujar Arma
		this.Metra.dibujar(this.entorno);
	
		
	}


	@SuppressWarnings("unused")
	public static void main(String[] args)
	{		
		Juego juego = new Juego();
	}




}

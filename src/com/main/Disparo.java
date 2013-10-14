package com.main;



import java.awt.Color;
import java.awt.Image;
import java.util.Random;



import entorno.Entorno;
import entorno.Herramientas;

public class Disparo {
	double 	x, y, angulo, v, escala = 1, dy, dx;
	boolean habilitado,	Disparando=false, Equipada = true;
	Image 	imagen, Tiro, Impacto;
	long 	tiempoDeAgarre,	tiempoDeEspera, tiempoEntreDisparos;
	static 	Random random=new Random(System.currentTimeMillis());
	double auxX;
	double auxY;
	Bubble shootBubble;
	Bubble firstBubble = new Bubble();
	Bubble secondBubble = new Bubble();
	
	//*****************************
	  int wallLeftX = 0;
	  int wallLeftY = 0;
	  int wallRightX = 0;
	  int wallRightY = 0;

	  int wallTopX = 0;
	  int wallTopY = 0;
	  int dr = 1;
	  int radius = 0;
	  int direction = 0;
	  int dist = 0;
	//*****************************
	
	public Disparo(){
		this.imagen = Herramientas.cargarImagen("img/circulo.PNG");
		this.Tiro = Herramientas.cargarImagen("img/circulo.png");
		//this.Impacto = Herramientas.cargarImagen("img/explosion.gif");
		this.habilitado=false;	
		this.v=30;
		tiempoEntreDisparos=System.currentTimeMillis();
		tiempoDeEspera=1000*(20+random.nextInt(5)); //mil * 'cantidad de segundos';
		tiempoDeAgarre=System.currentTimeMillis()+random.nextInt(5000);
		
		
	}
	public double radio(){
		return 20;
		//return imagen.getWidth(null)*escala/2;
	}
	//public void AgarraArma(Flecha coche){
		//if(this.habilitado==true){
			//double distancia = Math.sqrt(Math.pow(coche.x-this.x, 2)+Math.pow(coche.y-this.y, 2));
			//if(distancia<radio()+coche.radio()){ 
				//this.Equipada=true;		//Equipar Arma en el coche.
				//this.Disparando=false;
				//this.habilitado=false;	//Item para Agarrar el arma desaparece y no se dibuja mas.
				//tiempoDeAgarre=System.currentTimeMillis();
			//}
		//}
	//}
	public void DISPARAR(Flecha flechita) {	
		if (!Disparando) {
			this.dx = flechita.x;
			this.dy = flechita.y;
			this.angulo = flechita.angulo;
			auxX = dx;
			auxY = dy;
			this.Disparando = true;
		}
	}
	
	public void MoverDisparo(Entorno ent){
		if(Equipada && Disparando){
			dy+=Math.sin(this.angulo)*v;
			dx+=Math.cos(this.angulo)*v;
			System.out.println(tiempoEntreDisparos);
			if(tiempoEntreDisparos>100)
			if(dx>ent.ancho() || dx<0 || dy>ent.alto() || dy<0){//y se fuee
				dx=auxX;
				dy=auxY;
				Disparando=false;
				//tiempoEntreDisparos=0;
			}
		}
	}
	public void impactoDisparos(Disparo tiro){
		if(this.Disparando && tiro.Disparando){
			double distancia = Math.sqrt(Math.pow(tiro.dx-this.dx, 2)+Math.pow(tiro.dy-this.dy, 2));
			if(distancia<40){
				tiro.dx=tiro.auxX;
				tiro.dy=tiro.auxY;
				this.dx=this.auxX;
				this.dy=this.auxY;
				this.Disparando=false;
				tiro.Disparando=false;
			}
		}
	}
	//public void impacto(Auto coche2){
		//if(this.Disparando){
			//double distancia = Math.sqrt(Math.pow(coche2.x-this.dx, 2)+Math.pow(coche2.y-this.dy, 2));
			//if(distancia<20+coche2.radio()){
				//this.dx=this.auxX;
				//this.dy=this.auxY;
				//coche2.reducirVida();
				//this.Disparando=false;
			//}
		//}
	//}
	
	void collisionwithwall(Entorno ent)
	  {
	    int cx = this.shootBubble.cx;
	    int cy = this.shootBubble.cy;
	    int r = this.shootBubble.r;

	    if ((cx < this.wallLeftX + r + 3) && (this.direction == 1))
	    {
	      if (this.dr == 1)
	        this.dr = -1;
	      else if (this.dr == -1) {
	        this.dr = 1;
	      }
	      this.x = cx;
	      this.y = cy;
	      this.dist = 0;
	      this.direction = 2;
	    } else if ((cx >= ent.ancho() - r - 3) && (this.direction == 2)) {
	      if (this.dr == 1)
	        this.dr = -1;
	      else if (this.dr == -1) {
	        this.dr = 1;
	      }
	      this.x = cx;
	      this.y = cy;
	      this.dist = 0;
	      this.direction = 1;
	    }
	  }
	public void dibujar(Entorno ent) {
		if(Disparando){
			//ent.dibujarCirculo(dx, dy, radio(), Color.GREEN);  
			ent.dibujarImagen(this.Tiro, this.dx, this.dy, this.angulo, 1);
			}
		if(habilitado && Disparando){
			ent.dibujarCirculo(this.x, this.y, 40 , Color.RED);
			ent.dibujarImagen(this.imagen, this.x, this.y, 0, this.escala);
		}else{
			if (System.currentTimeMillis()-tiempoDeAgarre > tiempoDeEspera){
				//MOVER LAS POSICIONES CUANDO VUELVEN A HABILITARSE
				x=400;
				y=300;
				//x=random.nextInt((int)(ent.ancho()-imagen.getWidth(null)*escala))+imagen.getWidth(null)*escala/2;
				//y=random.nextInt((int)(ent.alto()-imagen.getHeight(null)*escala))+imagen.getHeight(null)*escala/2;
				//Habilita el Arma
				habilitado=true;
			}
		}
	}

	
	

}

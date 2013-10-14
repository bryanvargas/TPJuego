package com.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;



import entorno.Entorno;
import entorno.Herramientas;

public class Flecha {
	double x;
	double y;
	double angulo;
	Image imagen;
	int angle = 90;
	int pointX = 0;
	int pointY = 0;
	Entorno entorno;
	Flecha(double unX, double unY, double unAngulo) {
		this.x = unX;
		this.y = unY;
		this.angulo = unAngulo;
		
		
		
		
		this.imagen = Herramientas.cargarImagen("img/flecha.png");
	}

	
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getAngulo() {
		return angulo;
	}

	public void setAngulo(double angulo) {
		this.angulo = angulo;
	}

	public Image getImagen() {
		return imagen;
	}

	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}

	public int getAngle() {
		return angle;
	}
	public void setAngle(int angle) {
		this.angle = angle;
	}

	public int getPointX() {
		return pointX;
	}

	public void setPointX(int pointX) {
		this.pointX = pointX;
	}

	public int getPointY() {
		return pointY;
	}

	public void setPointY(int pointY) {
		this.pointY = pointY;
	}
	public Entorno getEntorno() {
		return entorno;
	}

	public void setEntorno(Entorno entorno) {
		this.entorno = entorno;
	}

	public void girarDerecha(double anguloDeGiro) {
		
		this.angulo += anguloDeGiro;
	}
	public void girarIzquierda(double anguloDeGiro) {
		this.angulo -= anguloDeGiro;
	}
	public void avanzar(Entorno ent) {
		this.x +=0;
		this.y +=0;
	}
	
	public void dibujar(Entorno ent) {
		
		ent.dibujarTriangulo(this.x, this.y, 40, 10, this.angulo, Color.ORANGE);
		//ent.dibujarImagen(imagen, this.x, this.y, this.angulo);
	}
	
	void draw_arrow(Entorno g)
	  {
		
	    rotateImage(this.imagen, (float)Math.sin(Math.toRadians(this.angle)), (float)Math.cos(Math.toRadians(this.angle)), this.pointX - this.imagen.getWidth(g) / 2, this.pointY - this.imagen.getHeight(g) / 2, g);
	  }
	
	public void rotateImage(Image src, float sinVal, float cosVal, int cx, int cy, Entorno g)
	  {
		g.getWidth();
	    int w1 = 123;
	    int h1 = 133;
	    int x = w1 / 2;
	    int y = h1 / 2;
	    int[] srcMap = new int[w1 * h1];
	    
	    //src.getRGB(srcMap, 0, w1, 0, 0, w1, h1);
	    int dx = x > w1 / 2 ? x : w1 - x;
	    int dy = y > h1 / 2 ? y : h1 - y;
	    double dr = Math.sqrt(dx * dx + dy * dy);
	    int wh2 = (int)(2.0D * dr);
	    int[] destMap = new int[wh2 * wh2];

	    for (int i = 0; i < w1; i++) {
	      for (int j = 0; j < h1; j++) {
	        if (srcMap[(j * w1 + i)] >> 24 != 0) {
	          double destX = dr + (i - x) * cosVal + (j - y) * sinVal;
	          double destY = dr + (j - y) * cosVal - (i - x) * sinVal;
	          destMap[((int)destY * wh2 + (int)destX)] = srcMap[(j * w1 + i)];
	          destMap[(wh2 * (int)destY + (int)destX + 1)] = srcMap[(j * w1 + i)];
	        }
	      }
	    }

	    int[] dd = new int[2];
	    dd[0] = (int)(x - dr);
	    dd[1] = (int)(y - dr);

	    //g.drawRGB(destMap, 0, wh2, dd[0] + cx, dd[1] + cy, wh2, wh2, true);
	  }

}

package Juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Tren {
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double velocidad;
	private Image imagen;

	public Tren(double x, double y, double alto, double ancho) {
		super();
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = 3;
		this.imagen = Herramientas.cargarImagen("tren.png");
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

	public double getAlto() {
		return alto;
	}

	public void setAlto(double alto) {
		this.alto = alto;
	}

	public double getAncho() {
		return ancho;
	}

	public void setAncho(double ancho) {
		this.ancho = ancho;
	}

	void mover() {
		this.x = this.x + velocidad;
	}

	void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.gray);
		entorno.dibujarImagen(this.imagen, x, y, 0, 0.4);
	}

}

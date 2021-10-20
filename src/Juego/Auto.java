package Juego;

import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Auto {
	private double x;
	private double y;
	private double alto;
	private double ancho;
	private double velocidad;
	private double escala;
	private Image imagen;

	public Auto(double x, double y, double alto, double ancho) {
		this.x = x;
		this.y = y;
		this.alto = alto;
		this.ancho = ancho;
		this.velocidad = 1;
		this.escala = 0.6;
		this.imagen = Herramientas.cargarImagen("autoverde.png");
		

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

	public double getAncho() {
		return ancho;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	void moverDerecha() {
		this.x = this.x + velocidad;
	}

	void moverIzquieda() {
		this.x = this.x - velocidad;
	}

	void agregarAuto(Auto[][] auto, int i, int j) {
		if (i == 0 || i == 2 || i == 4 || i == 6) {
			if (j == 0) {
				if (auto[i][1].getX() > 50 && auto[i][2].getX() > 50) {
					auto[i][j].setX(-25);
				} else {
					auto[i][j].setX(-100);
				}
			}
			if (j == 1) {
				if (auto[i][0].getX() > 50 && auto[i][1].getX() > 50) {
					auto[i][j].setX(-25);
				} else {
					auto[i][j].setX(-100);
				}
			}
			if (j == 2) {
				if (auto[i][0].getX() > 50 && auto[i][1].getX() > 50) {
					auto[i][j].setX(-25);
				} else {
					auto[i][j].setX(-100);
				}
			}
		} else {
			if (j == 0) {
				if (auto[i][1].getX() < 750 && auto[i][2].getX() < 750) {
					auto[i][j].setX(825);
				} else {
					auto[i][j].setX(900);
				}
			}
			if (j == 1) {
				if (auto[i][0].getX() < 750 && auto[i][1].getX() > 750) {
					auto[i][j].setX(825);
				} else {
					auto[i][j].setX(900);
				}
			}
			if (j == 2) {
				if (auto[i][0].getX() < 750 && auto[i][1].getX() < 750) {
					auto[i][j].setX(825);
				} else {
					auto[i][j].setX(900);
				}
			}
		}
	}

	void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.BLUE);
		entorno.dibujarImagen(this.imagen, this.x, this.y, 0, this.escala);
	}

}
package Juego;

import java.awt.Color;
import entorno.Entorno;

public class Pantalla {
	private double movimiento;
	private double x;
	private double y;
	private double ancho;
	private double alto;

	public Pantalla(double x, double y, double ancho, double alto) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.movimiento = 0.1;
	}

	public double getY() {
		return y;
	}

	public double getAlto() {
		return alto;
	}

	public void setY(double y) {
		this.y = y;
	}

	void moverPantalla(Conejo conejo, Auto[][] calle, Tren tren, Pantalla cesped1, Pantalla cesped2, Pantalla cesped3,
			Pantalla vias) {
		conejo.setY(conejo.getY() + this.movimiento);
		tren.setY(tren.getY() + this.movimiento);
		vias.setY(vias.getY() + this.movimiento);
		cesped1.setY(cesped1.getY() + this.movimiento);
		cesped2.setY(cesped2.getY() + this.movimiento);
		cesped3.setY(cesped3.getY() + this.movimiento);
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 3; j++) {
				calle[i][j].setY(calle[i][j].getY() + this.movimiento);
			}
		}
	}

	void gameOver(Entorno entorno, int puntos, double tiempo) {
		entorno.cambiarFont(null, 60, Color.RED);
		entorno.escribirTexto("Game Over", 250, 300);
		entorno.cambiarFont(null, 20, Color.red);
		entorno.escribirTexto("Puntos logrados: " + puntos, 300, 400);
		entorno.cambiarFont(null, 20, Color.red);
		entorno.escribirTexto("Tiempo: " + (int) tiempo + " seg", 300, 450);
	}
	
	void ganaste(Entorno entorno, int puntos, double tiempo) {
		entorno.cambiarFont(null, 60, Color.GREEN);
		entorno.escribirTexto("¡¡Ganaste!!", 200, 300);
		entorno.cambiarFont(null, 30, Color.GREEN);
		entorno.escribirTexto("Hiciste  " + puntos + "  puntos!!", 220, 400);
		entorno.cambiarFont(null, 20, Color.GREEN);
		entorno.escribirTexto("Tiempo: " + (int) tiempo + " seg", 250, 450);
	}

	void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.GREEN);
	}

	void dibujarVias(Entorno entorno, Pantalla vias) {
		entorno.dibujarRectangulo(vias.x, vias.y, vias.ancho, vias.alto, 0, Color.gray);
	}

}
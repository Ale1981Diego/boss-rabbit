package Juego;


import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Bola {
	private double x;
	private double y;
	private double diametro;
	private int velocidad;
	private Image imagen;
	private boolean fuego;

	Bola(double e, double d, double diametro) 
	{
		this.x = e;
		this.y = d;
		this.diametro = diametro;
		this.velocidad = +2;
		this.imagen = Herramientas.cargarImagen("fuego101.gif");
		this.fuego = false;
	}

	public void mover() 
	{
		this.x = this.x + this.velocidad;
	}

	public void dibujar(Entorno entorno) 
	{
		entorno.dibujarImagen(imagen, x, y, 0);
	}

	public double getX() 
	{
		return x;
	}

	public double getY() 
	{
		return y;
	}

	public double getDiametro() 
	{
		return diametro;
	}

	public boolean isFuego() 
	{
		return fuego;
	}

	public void setFuego(boolean fuego) 
	{
		this.fuego = fuego;
	}
}

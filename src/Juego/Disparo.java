package Juego;

import java.awt.Image;

import javax.sound.sampled.Clip;

import entorno.Entorno;
import entorno.Herramientas;

public class Disparo {
    private double x;
    private double y;
    private double alto;
    private double ancho;
    private int velocidad;
    private Image imagen;
    private Clip disparo;
    private boolean fuego;

    Disparo(double x, double y, double alto, double ancho) 
    {
        this.x = x;
        this.y = y;
        this.alto = alto;
        this.ancho = ancho;
        this.velocidad = +2;
        this.imagen = Herramientas.cargarImagen("fuego.png");
        this.disparo = Herramientas.cargarSonido("disparo.wav");
        this.fuego = false;
    }

    public Clip getDisparo() {
		return disparo;
	}

	public void mover() 
    {
        this.y = this.y - this.velocidad;
    }

    public void dibujar(Entorno entorno) 
    {
        //entorno.dibujarImagen(imagen, x, y, 0);
        entorno.dibujarImagen(imagen, x, y, 0, 0.1);
    }

    public double getX() 
    {
        return x;
    }

    public double getY() 
    {
        return y;
    }


    public boolean isFuego() 
    {
        return fuego;
    }

    public void setFuego(boolean fuego) 
    {
        this.fuego = fuego;
    }

    
	public double getAlto() {
		return alto;
	}

	
	public double getAncho() {
		return ancho;
	}

	
	public void setY(double y) {
		this.y = y;
	}

	public int getVelocidad() {
		return velocidad;
	} 
		
}
package Juego;

import java.awt.Color;
import entorno.Entorno;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	// Variables
	private Pantalla pantalla;
	private Pantalla cesped1;
	private Pantalla cesped2;
	private Pantalla cesped3;
	private Pantalla vias;
	private Conejo conejo;
	private int puntos = 0;
	
	private Disparo[] disparo;
	private int cantDisparo;
	
	private Auto[][] calle1 = new Auto[8][3];
	private Tren tren;
	private int tiempo = 0;
	private int time = 0;
//-----------------------------------------------------------
	int nivel = 1;
	int tiempo1 = 0;
	int tick = 0;
	boolean contadorTicks;
//-----------------------------------------------------------	
	Juego() {
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Boss Rabbit Rabber - Grupo ... - v1", 800, 600);

		// Inicializacion de objetos
		this.pantalla = new Pantalla(400, 300, 800, 600);
		this.cesped1 = new Pantalla(400, 565, this.entorno.ancho(), 50);
		this.cesped2 = new Pantalla(400, 300, this.entorno.ancho(), 80);
		this.cesped3 = new Pantalla(400, 35, this.entorno.ancho(), 50);
		this.vias = new Pantalla(400, -5, this.entorno.ancho(), 40);
		this.tren = new Tren(-100, -5, 40, 370);
		this.conejo = new Conejo(400, 545, 25, 25);
		
		this.cantDisparo = 1;
		this.disparo = new Disparo[cantDisparo];
		
		

		this.calle1[0][0] = new Auto(350, 500, 40, 50);
		this.calle1[0][1] = new Auto(500, 500, 40, 50);
		this.calle1[0][2] = new Auto(700, 500, 40, 50);
		this.calle1[1][0] = new Auto(150, 460, 40, 50);
		this.calle1[1][1] = new Auto(550, 460, 40, 50);
		this.calle1[1][2] = new Auto(750, 460, 40, 50);
		this.calle1[2][0] = new Auto(200, 420, 40, 50);
		this.calle1[2][1] = new Auto(450, 420, 40, 50);
		this.calle1[2][2] = new Auto(800, 420, 40, 50);
		this.calle1[3][0] = new Auto(250, 380, 40, 50);
		this.calle1[3][1] = new Auto(500, 380, 40, 50);
		this.calle1[3][2] = new Auto(650, 380, 40, 50);
		this.calle1[4][0] = new Auto(250, 220, 40, 50);
		this.calle1[4][1] = new Auto(400, 220, 40, 50);
		this.calle1[4][2] = new Auto(560, 220, 40, 50);
		this.calle1[5][0] = new Auto(300, 180, 40, 50);
		this.calle1[5][1] = new Auto(450, 180, 40, 50);
		this.calle1[5][2] = new Auto(550, 180, 40, 50);
		this.calle1[6][0] = new Auto(100, 140, 40, 50);
		this.calle1[6][1] = new Auto(250, 140, 40, 50);
		this.calle1[6][2] = new Auto(500, 140, 40, 50);
		this.calle1[7][0] = new Auto(50, 100, 40, 50);
		this.calle1[7][1] = new Auto(200, 100, 40, 50);
		this.calle1[7][2] = new Auto(400, 100, 40, 50);
		
		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	// verifica la superposicion de 2 objetos
	boolean colision(double x1, double y1, double ancho1, double alto1, double x2, double y2, double ancho2, double alto2) {
		boolean tx = (x1 + ancho1 / 2 > x2 - ancho2 / 2) && (x1 - ancho1 / 2 < x2 + ancho2 / 2);
		boolean ty = (y1 + alto1 / 2 > y2 - alto2 / 2) && (y1 - alto1 / 2 < y2 + alto2 / 2);
		return tx && ty;
	}
	
	//COLISION DISPARO-AUTO
	boolean colisionDisparoAuto(Disparo d, Auto a) {
			boolean tx = (d.getX()+ d.getAncho()/2 > a.getX() - a.getAncho()/2  &&  d.getX() - d.getAncho()/2 < a.getX() + a.getAncho()/2);
			boolean ty = (d.getY()+ d.getAlto()/2 > a.getY() - a.getAlto()/2  &&  d.getY() - d.getAlto()/2 < a.getY() + a.getAlto()/2);
			return tx && ty;
		}
	
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y por lo
	 * tanto es el método más importante de esta clase. Aquí se debe actualizar el
	 * estado interno del juego para simular el paso del tiempo (ver el enunciado
	 * del TP para mayor detalle).
	 */
//------------------------------------------------------------------------	
	void setnivel(int tiempo) 
	{
		if (tiempo % 1000 == 0 && tiempo < 4000) 
		{
			nivel += 1;	
		}
	}	 
//-------------------------------------------------------------------------	
	public void tick() {
		// Procesamiento de un instante de tiempo
		// ...
		// verifica si el conejo tiene vidas
		
		if (this.conejo.getVidas() > 0)
		{
			// cuenta los segundos
			this.tiempo++;
			this.time++;
			// dibuja los objetos
			this.cesped2.dibujar(this.entorno);
			this.cesped1.dibujar(this.entorno);
			this.cesped3.dibujar(this.entorno);
			this.vias.dibujarVias(entorno, vias);
			this.conejo.dibujar(this.entorno);
			this.tren.dibujar(this.entorno);
			// metodos para mover y objetos y controlar cuando se salgan de pantalla
			this.tren.mover();
			this.pantalla.moverPantalla(this.conejo, this.calle1, this.tren, this.cesped1, this.cesped2, this.cesped3, this.vias);
			
			if (this.tren.getX() > 2000)
			{
				this.tren.setX(-2000);
			}
			
			if (this.tren.getY() - this.tren.getAlto() / 2 > this.entorno.alto())
			{
				this.tren.setY(0);
			}
			
			if (this.vias.getY() - this.vias.getAlto() / 2 > this.entorno.alto()) 
			{
				this.vias.setY(0);
			}
			
			if (this.cesped1.getY() - this.cesped1.getAlto() / 2 > this.entorno.alto())
			{
				this.cesped1.setY(20);
			}
			
			if (this.cesped2.getY() - this.cesped2.getAlto() / 2 > this.entorno.alto())
			{
				this.cesped2.setY(20);
			}
			
			if (this.cesped3.getY() - this.cesped3.getAlto() / 2 > this.entorno.alto())
			{
				this.cesped3.setY(20);
			}

			// verifica la tecla presionada por teclado y realiza la accion
			if (this.entorno.sePresiono(this.entorno.TECLA_ARRIBA) && (this.conejo.getY() - (this.conejo.getAlto() / 2)) > 0)
			{
				this.conejo.moverArriba();
				this.conejo.getSalto().start();
				this.puntos++;
			} 
			else if (this.entorno.sePresiono(this.entorno.TECLA_DERECHA) && (this.conejo.getX() + this.conejo.getAncho() / 2) < this.entorno.ancho())
			{
				this.conejo.moverDerecha();
				this.conejo.getSalto().start();

			} else if (this.entorno.sePresiono(this.entorno.TECLA_IZQUIERDA) && (this.conejo.getX() - this.conejo.getAncho() / 2) > 0)
			{
				this.conejo.moverIzquieda();
				this.conejo.getSalto().start();
			}
			
			// movimiento de los autos a traves de 2 ciclos for
			
			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 3; j++)
				{
					// dibuja los autos
					
					this.calle1[i][j].dibujar(entorno);
					
					// si hay una colicion de conejo/auto o conejo/tren o el conejo se sale de
					// pantalla
					// reinicia los objetos a sus posiciones originales
					
					if (colision(this.conejo.getX(), this.conejo.getY(), this.conejo.getAncho(), this.conejo.getAlto(), this.calle1[i][j].getX(), this.calle1[i][j].getY(), this.calle1[i][j].getAncho(),
							this.calle1[i][j].getAlto()) || colision(this.conejo.getX(), this.conejo.getY(), this.conejo.getAncho(), this.conejo.getAlto(), this.tren.getX(), this.tren.getY(), tren.getAncho(),
									this.tren.getAlto()) || this.conejo.getY() - this.conejo.getAlto() > 590)
					{
						if (conejo.getVidas() > 0)
						{
							conejo.descontarVida();
							this.calle1[0][0] = new Auto(350, 500, 40, 50);
							this.calle1[0][1] = new Auto(500, 500, 40, 50);
							this.calle1[0][2] = new Auto(700, 500, 40, 50);
							this.calle1[1][0] = new Auto(150, 460, 40, 50);
							this.calle1[1][1] = new Auto(550, 460, 40, 50);
							this.calle1[1][2] = new Auto(750, 460, 40, 50);
							this.calle1[2][0] = new Auto(200, 420, 40, 50);
							this.calle1[2][1] = new Auto(450, 420, 40, 50);
							this.calle1[2][2] = new Auto(800, 420, 40, 50);
							this.calle1[3][0] = new Auto(250, 380, 40, 50);
							this.calle1[3][1] = new Auto(500, 380, 40, 50);
							this.calle1[3][2] = new Auto(650, 380, 40, 50);
							this.calle1[4][0] = new Auto(250, 220, 40, 50);
							this.calle1[4][1] = new Auto(400, 220, 40, 50);
							this.calle1[4][2] = new Auto(560, 220, 40, 50);
							this.calle1[5][0] = new Auto(300, 180, 40, 50);
							this.calle1[5][1] = new Auto(450, 180, 40, 50);
							this.calle1[5][2] = new Auto(550, 180, 40, 50);
							this.calle1[6][0] = new Auto(100, 140, 40, 50);
							this.calle1[6][1] = new Auto(250, 140, 40, 50);
							this.calle1[6][2] = new Auto(500, 140, 40, 50);
							this.calle1[7][0] = new Auto(50, 100, 40, 50);
							this.calle1[7][1] = new Auto(200, 100, 40, 50);
							this.calle1[7][2] = new Auto(400, 100, 40, 50);
							this.conejo.setX(400);
							this.conejo.setY(545);
							this.tren = new Tren(-100, -5, 40, 370);
							this.vias = new Pantalla(400, -5, this.entorno.ancho(), 40);
							this.cesped1 = new Pantalla(400, 565, this.entorno.ancho(), 75);
							this.cesped2 = new Pantalla(400, 300, this.entorno.ancho(), 80);
							this.cesped3 = new Pantalla(400, 30, this.entorno.ancho(), 80);
						}
					}
					
					if (this.calle1[i][j].getY() - this.calle1[i][j].getAlto() / 2 > this.entorno.alto())
					{
						this.calle1[i][j].setY(0);
					}
					
					if (i == 0) 
					{
						this.calle1[i][j].moverDerecha();
						if (this.calle1[i][j].getX() > this.entorno.getWidth() + 150)
						{
							this.calle1[i][j].setX(-150);
						}
					}
					
					if (i == 1)
					{
						this.calle1[i][j].moverIzquieda();
						if (this.calle1[i][j].getX() < 0)
						{
							this.calle1[i][j].setX(this.entorno.getWidth());
						}
					}
					
					if (i == 2)
					{
						this.calle1[i][j].moverDerecha();
						if (this.calle1[i][j].getX() > this.entorno.getWidth())
						{
							this.calle1[i][j].setX(0);
						}
					}
					if (i == 3)
					{
						this.calle1[i][j].setVelocidad(2);
						this.calle1[i][j].moverIzquieda();
						if (this.calle1[i][j].getX() < 0)
						{
							this.calle1[i][j].setX(this.entorno.getWidth());
						}
					}
					
					if (i == 4)
					{
						this.calle1[i][j].moverDerecha();
						if (this.calle1[i][j].getX() > this.entorno.getWidth())
						{
							this.calle1[i][j].setX(0);
						}
					}
					
					if (i == 5)
					{
						this.calle1[i][j].moverIzquieda();
						if (this.calle1[i][j].getX() < 0)
						{
							this.calle1[i][j].setX(this.entorno.getWidth());
						}
					}
					
					if (i == 6)
					{
						this.calle1[i][j].setVelocidad(2);
						this.calle1[i][j].moverDerecha();
						if (this.calle1[i][j].getX() > this.entorno.getWidth())
						{
							this.calle1[i][j].setX(0);
						}
					}
					
					if (i == 7)
					{
						this.calle1[i][j].setVelocidad(2);
						this.calle1[i][j].moverIzquieda();
						if (this.calle1[i][j].getX() < 0) 
						{
							this.calle1[i][j].setX(this.entorno.getWidth());
						}
						
					}

				}
				
			}

			// escribe indicadores de tiempo, puntos, vidas en pantalla
			this.entorno.cambiarFont(null, 20, Color.white);
			this.entorno.escribirTexto("Vidas " + conejo.getVidas(), 660, 25);
			this.entorno.escribirTexto("Puntos: " + puntos, 660, 45);
			this.entorno.escribirTexto("Tiempo: " + Math.round(time * 0.01), 660, 65);
			
		}else if(this.puntos >= 10) {
			double tiempoFinal = Math.round(this.time * 0.01);
			this.pantalla.ganaste(this.entorno, this.puntos, tiempoFinal);
		}	
		else {
			// si el conejo no tiene vidas dibuja pantalla final con estadisticas
			double tiempoFinal = Math.round(this.time * 0.01);
			this.pantalla.gameOver(this.entorno, this.puntos, tiempoFinal);

		}
//-----------------------------------------------------------------------------------------------
		// CONTADOR DE TICKS//
				tiempo = tiempo + 1;

				if (contadorTicks == true) 
				{
					tick = tick + 1;
				}

		//VELOCIDAD//
				setnivel(tiempo);

// COLISION DISPARO-AUTO//
		for (int i = 0; i < 8; i++)//recorro autos
				{
					for (int j = 0; j < 3; j++)//recorro autos
					{
						for (int b = 0; b < this.disparo.length; b++) //recorro disparos
						{
							if (this.disparo[b] != null) 
							{						
								if (colisionDisparoAuto(this.disparo[b], this.calle1[i][j])) {

									this.disparo[b] = null;	
									this.calle1[i][j].agregarAuto(calle1, i, j);
								}

							}
						}
					}
				}
		

//DISPARO	// DIBUJA Y MUEVE EL DISPARO//
			if (this.entorno.sePresiono(this.entorno.TECLA_ESPACIO))
			{
				boolean agregueDisparo = false;
				for (int i1 = 0; i1 < this.disparo.length && !agregueDisparo; i1++) 
				{
					if (this.disparo[i1] == null) 
					{
						//conejo.getDisparo().start(); //algo anda mal con el sonido aca,suena solo la 1ra vez
						this.disparo[i1] = this.conejo.Lanzado();
						agregueDisparo = true;
						this.disparo[i1].getDisparo().start();
					}
					else {
						tiempo += 1;
					}
				}
				if (!agregueDisparo && tiempo > 225) { //el tiempo indica cuanto tiempo se mantiene dibujada la bola antes de desaparecer y dejar lanzar otra 
					this.disparo = new Disparo[cantDisparo];
					tiempo = 0;
				}
			
			}

			// Dibuja la bola
			for (int i1 = 0; i1 < this.disparo.length; i1++) 
			{
				if (this.disparo[i1] != null) 
				{
					this.disparo[i1].dibujar(this.entorno);
					this.disparo[i1].mover();
				}
			}	
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}
}

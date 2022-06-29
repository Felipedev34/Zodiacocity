package zodiacocity;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Zodiaco extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;

	private static final int ALTO = 600;

	private static volatile boolean EnFuncionamiento = false;

	private static final String NOMBRE = "Zodiaco";

	private static int aps = 0;
	private static int fps = 0;

	private static JFrame ventana;
	private static Thread thread;

	private Zodiaco() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
	}

	public static void main(String[] args) {
		Zodiaco Zodiaco = new Zodiaco();
		Zodiaco.iniciar();

	}

	private synchronized void iniciar() {
		EnFuncionamiento = true;

		thread = new Thread(this, "Graficos");
		thread.start();
	}

	private synchronized void detener() {
		EnFuncionamiento = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void actualizar() {
		aps++;

	}

	private void mostrar() {
		fps++;

	}

	public void run() {
		final int NS_POR_SEGUNDOS = 100000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDOS / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaContador = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		while (EnFuncionamiento) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;
			}

			mostrar();

			if (System.nanoTime() - referenciaContador > NS_POR_SEGUNDOS) {
				ventana.setTitle(NOMBRE + "|| APS: " + " || FPS: " + fps);
				aps = 0;
				fps = 0;
				referenciaContador = System.nanoTime();
			}
		}
	}
}

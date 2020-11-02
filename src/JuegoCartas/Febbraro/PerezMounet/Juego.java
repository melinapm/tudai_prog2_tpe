package JuegoCartas.Febbraro.PerezMounet;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

import JuegoCartas.Febbraro.PerezMounet.pocimas.Pocima;

public class Juego {

	private Mazo mazoJuego;
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorGanador;
	private int maximoRondas;
	private ArrayList<Pocima> pocimasJuego;
	
	// Constructor de Juego
	// Desde aqui se llama  al cargarMazo para cargar el mazoGeneral
	// Siempre comienza el jugador 1 la ronda
	public Juego (Jugador jugador1, Jugador jugador2, String pathCartas, int maximoRondas) {
		this.mazoJuego = new Mazo();
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.maximoRondas = maximoRondas;
		this.jugadorGanador = jugador1;
		pocimasJuego = new ArrayList<Pocima>();
		cargarMazo(pathCartas);
	}
	
	public void agregarPocima (Pocima pocima) {
		pocimasJuego.add(pocima);
	}
	
	// Metodo principal del Juego
	// Aca se itera por cada ronda y se compara si alguien ya gano
	// o si se llego al maximo de rondas.
	public void Jugar() {
		
		mazoJuego.mezclarMazo();
		
		if (pocimasJuego.size() != 0) {
			Collections.shuffle(pocimasJuego);
			for (int i=0; i < pocimasJuego.size(); i++)
				mazoJuego.tomarCartaPorPosicion(i).setPocima(pocimasJuego.get(i));
		}
			
		repartirCartas(mazoJuego, jugador1, jugador2);
					
		for (int ronda=0 ; ronda <= maximoRondas ; ronda ++ ) {
			if (!jugador1.sinCartas() && !jugador2.sinCartas()) {
				System.out.println ("---------- Ronda " + ronda + " ----------");
				if (jugadorGanador == jugador1) 
					jugarMano(jugador1, jugador2);
				else
					jugarMano(jugador2, jugador1);
			} else if (jugador1.sinCartas()) {
				ronda = maximoRondas;
				System.out.println("------------- FIN DEL JUEGO -------------");
				System.out.println("Gano " + jugador2.getNombre() + " !!!"); 
			} else if (jugador2.sinCartas()){
				ronda = maximoRondas;
				System.out.println("------------- FIN DEL JUEGO -------------");
				System.out.println("Gano " + jugador1.getNombre() + " !!!"); }
		}
		
		if (!jugador1.sinCartas() && !jugador2.sinCartas()) {
			System.out.println("------------- FIN DEL JUEGO -------------");
			System.out.println("Se llego al maximo de rondas");	
		}
		
	}
	
	// Reparte las cartas del mazo general a cada jugador
	// todas las cartas en posicion par van para jugador 1
	// cuando se repartieron todas las cartas se limpia el mazoGeneral
	private void repartirCartas(Mazo mazo, Jugador j1, Jugador j2) {
		for (int i=0; i < mazoJuego.tamanioMazo() ; i++) {
			if (i%2!=0) // Si es par, va al J1
				j1.agregarCartaFinalMazo(mazoJuego.tomarCartaPorPosicion(i));
			else // Si es impar, va al J2
				j2.agregarCartaFinalMazo(mazoJuego.tomarCartaPorPosicion(i));
		}
		mazoJuego.borrarMazo();
	}
	
	// En este metodo el jugador ganador elije el atributo de forma aleatoria
	// se guardan las cartas que van a jugar cada jugador y se compara
	// quien gano
	private void jugarMano(Jugador jugador1, Jugador jugador2) {
		Boolean empate = false;
		
		Carta cartaElegidaJ1 = jugador1.jugarCarta();
		Carta cartaElegidaJ2 = jugador2.jugarCarta();
		int atributoAletorio = posicionAtributo(jugador1.getAtributoAleatorio(), cartaElegidaJ1);
		
		// Si gana el jugador que venia ganando
		if ((cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getValor()) > (cartaElegidaJ2.getAtributoPorPosicion(atributoAletorio).getValor())) {
			jugador1.agregarCartaFinalMazo(cartaElegidaJ1);
			jugador1.agregarCartaFinalMazo(cartaElegidaJ2);
			jugador1.obtenerCartaPorPosicion(0);
			jugador2.obtenerCartaPorPosicion(0);}
		// Si gana el otro jugador
		else if ((cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getValor()) < (cartaElegidaJ2.getAtributoPorPosicion(atributoAletorio).getValor())) {
			jugador2.agregarCartaFinalMazo(cartaElegidaJ2);
			jugador2.agregarCartaFinalMazo(cartaElegidaJ1);
			jugador2.obtenerCartaPorPosicion(0);
			jugador1.obtenerCartaPorPosicion(0);
			jugadorGanador =  jugador2; }
		// En caso de empate
		else if ((cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getValor()) == (cartaElegidaJ2.getAtributoPorPosicion(atributoAletorio).getValor())) {
			jugador1.agregarCartaFinalMazo(cartaElegidaJ1);
			jugador2.agregarCartaFinalMazo(cartaElegidaJ2);
			jugador1.obtenerCartaPorPosicion(0);
			jugador2.obtenerCartaPorPosicion(0);
			empate = true;
		}
		
		// Imprimo por pantalla el detalle de como salio la ronda
		imprimirPorPantalla(jugador1, jugador2,
				cartaElegidaJ1, cartaElegidaJ2, atributoAletorio, empate);
		
	}
	
	
	private int posicionAtributo(String atributoAleatorio, Carta cartaElegidaJG) {
		for (int i=0; i < cartaElegidaJG.getAtributos().size() ; i++)
			if (cartaElegidaJG.getAtributoPorPosicion(i).getNombre().equals(atributoAleatorio))
				return i;
		
		return -1;
	}

	// Metodo que se invoca al comenzar el juego y carga el mazo
	// que se encuentra en el path.
	private void cargarMazo(String jsonFile) {
				
        File jsonInputFile = new File(jsonFile);
        InputStream is;
        try {
            is = new FileInputStream(jsonInputFile);
            // Creo el objeto JsonReader de Json.
            JsonReader reader = Json.createReader(is);
            // Obtenemos el JsonObject a partir del JsonReader.
            JsonArray cartas = (JsonArray) reader.readObject().getJsonArray("cartas");
            // Por cada carta guardo sus atributos en un array y genero la carta
            for (JsonObject carta : cartas.getValuesAs(JsonObject.class)) {
                String nombreCarta = carta.getString("nombre");
                JsonObject atributos = carta.getJsonObject("atributos");
                String nombreAtributoCarta = "";
                int valorAtributoCarta = 0;
                // Creo el array atributo para poder crear la carta
                // Lo borro porque sino me agrega todas las cartas al mismo array
                ArrayList<Atributo> atributosCarta = new ArrayList<Atributo>();
                atributosCarta.clear();
                for (String nombreAtributo:atributos.keySet()) {
                	nombreAtributoCarta = nombreAtributo;
                	valorAtributoCarta = atributos.getInt(nombreAtributo);
                	Atributo nuevoAtributo = new Atributo(nombreAtributoCarta, valorAtributoCarta);
                	atributosCarta.add(nuevoAtributo);
                }
                // Se crea la nueva carta con todos los atributos y la agrego al mazo general
                Carta nuevaCarta = new Carta(nombreCarta, atributosCarta);
                mazoJuego.agregarCarta(nuevaCarta);              
            }

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
	
	// Metodo que imprime por pantalla el resultado de la ronda
	private void imprimirPorPantalla(Jugador j1, 
			Jugador j2, Carta cartaElegidaJ1, Carta cartaElegidaJ2, int atributoAletorio, Boolean empate) {

		System.out.println("El jugador " + j1.getNombre() 
			+ " selecciona para competir por el atributo " 
			+ cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getNombre());
		
		System.out.println("La carta de " + j1.getNombre() 
			+ " es " + cartaElegidaJ1.getNombre()
			+ " con "
			+ cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getNombre() + " "
			+ cartaElegidaJ1.getAtributoPorPosicionSinPocima(atributoAletorio).getValor());

		if (cartaElegidaJ1.getPocima() != null)
			System.out.println("Se aplico la pocima " + cartaElegidaJ1.getPocima().getNombrePocima()
				+ " valor resultante "+ 
				cartaElegidaJ1.getAtributoPorPosicion(atributoAletorio).getValor());
		
		System.out.println("La carta de " + j2.getNombre() 
			+ " es " + cartaElegidaJ2.getNombre()
			+ " con "
			+ cartaElegidaJ2.getAtributoPorPosicion(atributoAletorio).getNombre() + " "
			+ cartaElegidaJ2.getAtributoPorPosicionSinPocima(atributoAletorio).getValor());
		
		if (cartaElegidaJ2.getPocima() != null)
			System.out.println("Se aplico la pocima " + cartaElegidaJ2.getPocima().getNombrePocima()
				+ " valor resultante "+ 
				cartaElegidaJ2.getAtributoPorPosicion(atributoAletorio).getValor());
		
		if (empate)
			System.out.println("Hubo un empate.");
		else
			System.out.println("Gana la ronda " + jugadorGanador.getNombre() + ".");
		
		System.out.println(j1.getNombre()
			+ " posee ahora " + j1.getTamanioMazo() + " cartas y "
			+ j2.getNombre() + " posee ahora " + 
			j2.getTamanioMazo() + " cartas.");
	
	}
		
}

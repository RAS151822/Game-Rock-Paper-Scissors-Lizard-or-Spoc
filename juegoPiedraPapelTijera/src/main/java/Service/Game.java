package Service;

import java.io.PrintStream;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import Model.*;


public class Game {
	
	private String userselection = "";
	private int selection = 0;
	private User user;
	private Scanner entradaEscaner;
	protected ArrayList <User> users;
	protected ArrayList <Option> options;
	protected int powerControler = 0; //Indicador para saber que jugador esta elijiendo opcion
	
	protected static int scoreUser = 0;
	protected static int scoreMatrix = 0;
	protected static int scoreUser2 = 0;
	
	
	
	public void starGame() {
		
		 
		//Instanciamos el array donde almacenaremos los usuarios
		ArrayList <User> users = new ArrayList <User>();
		
		//Instanciamos el array donde almacenaremos las diferentes opciones a elegir
		ArrayList <Option> options = new ArrayList <Option>();
		
    	//Creación de un objeto Scanner
    	entradaEscaner = new Scanner (System.in);
		
		
    	//Almacenamos tambien las opciones en el Array
    	Scissors scissors = new Scissors();
    	Paper paper = new Paper();
    	Rock rock  = new Rock();
    	Spock spock = new Spock();
    	Lizard lizard = new Lizard();
    	
    	options.add(scissors);
    	options.add(paper);
    	options.add(rock);
    	options.add(spock);
    	options.add(lizard);
    	
    	
    	//DEBUG DE ARRAYS
    	/*
    	for(User u: users) {
    		
    		System.out.println ("Usuarios  " + u.getNombre() + "\n");
    		
    	}
		
    	
    	for(Option u: options) {
    		
    		System.out.println ("Opciones  " + u.getName() + " " + u.getSimbolo() + " " + u.getAction() + "\n");
    		
    	}
    	*/
    	
    	System.out.println ("Bienvenido al PIEDRA, PAPEL O TIJERA DE RAULIÑAAA :) \n" );
		System.out.println ("\n" + "Introduzca su nombre de usuario: \n");
		
    	//Captamos los datos introducidos por consola y creamos un nuevo usuario con ellos
    	
    	userselection = entradaEscaner.nextLine ();
    	
    	crearUsuario(users, user);
    	
    	menuPrincipal(userselection, users, options);
    	

	}

//METODOOOS ****************************************************************************************************************************************************************
	
	public void crearUsuario(ArrayList <User> users, User user) {
		
		//Creamos un nuevo usuario con los datos captados por pantalla 
    	user = new User();
    	user.setNombre(userselection);
    	
    	//Almacenamos el usuario nuevo en el Array 
    	users.add(user);
	}
	
	public void mostrarOpciones(ArrayList<Option> options, ArrayList<User> users) {
		
		//Mostramos las opciones por pantalla
    	int numeracionMenu = 0;
    	
    	for(Option u: options) {
    		
    		numeracionMenu++;
    		System.out.println ("Opciones  [" + numeracionMenu + "] " + u.getName() + " " + u.getSimbolo() + " " + u.getAction() + "\n");
    		
    	}
    	
    	//Volvemos a pedir respuesta al usuario 
    	entradaEscaner = new Scanner (System.in);
    	userselection = entradaEscaner.nextLine ();
    	
    	//Almacenamos la opcion elegida por el usuario
    	almacenarOpcionElegida(userselection, options,  users);
    	
	}
	
	public void almacenarOpcionElegida(String userselection, ArrayList<Option> options, ArrayList<User> users) {
		
		//1 seleccionado por el usuario como viene en string hacemos el catch
		int selection = Integer.parseInt(userselection);
		
		users.get(powerControler).setChoseOption(options.get(selection-1).getSimbolo() +  options.get(selection-1).getName());
	
		
		if(powerControler == 0) {
			
			System.out.println("El jugador [" + powerControler + "]" + users.get(powerControler).getNombre() +  " elige = " + users.get(powerControler).getChoseOption());
			
		}
	}
	
	
	//MENU PRINCIPAL O INICIO
	public void menuPrincipal(String userselection, ArrayList<User> users, ArrayList<Option> options) {
		
		System.out.println("\n"  + "Perfecto " + users.get(0).getNombre() +  "! ahora elija uno de los modos de juego" + "\n" );
		System.out.println("\n"  + "Opcion [1] jugar contra MATRIX " + "\n" );
		System.out.println("\n"  + "Opcion [2] jugar con dos jugadores " + "\n" );
		
		
		entradaEscaner = new Scanner (System.in);
		userselection = entradaEscaner.nextLine ();
		
		switch(userselection) {
		    
		    case "1":
		    	
		    	
		    	
		    	System.out.println( "Hola de nuevo! " + users.get(powerControler).getNombre() +  " esta usted en modo 1 jugador contra la MATRIX :) ");
		    	
		    	
		    		do {
		    			
		    			System.out.println ("\n" + "Perfecto! ahora elija una opcion: \n");
				    	
				    	mostrarOpciones(options, users);
				    	
		    			match(users.get(powerControler), options);
		    			
		    			System.out.println("Score User =" + scoreUser + " ScoreMatrix = " + scoreMatrix + " ScoreUser2 = " + scoreUser2);
		    			
//		    			if(scoreUser==3{
//		    				
//		    				break;
//		    			}
		    			
		    		}while(scoreUser != 3 && scoreMatrix != 3);	
		    	
		      break;
		      
		    case "2":
		    	
		    	//System.out.println("\n" + "La maquina elijio " + printMachineSelecction(machineselection));
		    	//match(userselection, selection);
		    	
		    	System.out.println( "Hola de nuevo! " + users.get(powerControler).getNombre() +  " esta usted en modo 2 jugadores ");
		    	System.out.println ("\n" + "Escriba el nombre del segundo jugador : \n");
		    	
		    	entradaEscaner = new Scanner (System.in);
		    	userselection = entradaEscaner.nextLine ();
		    	
		    	crearUsuario(users, user);
		    	
		    	
		    	do {
	    			
	    			System.out.println ("\n" + "Perfecto! ahora elija una opcion: \n");
			    	
			    	mostrarOpciones(options, users);
			    	
	    			match(users.get(powerControler), options);
	    			
	    			
	    			
	    		}while(scoreUser != 3 && scoreMatrix != 3 && scoreUser2 != 3);	
	    	
		      
	    	break;
	    	
		    default:
		    	
		    	
		    	
		    	if(scoreUser == 3) {
		    		
		    		System.out.println("CONGRATULATIONSS!!  " +  users.get(powerControler).getNombre() + " Youu Win!! ");
		    	}
	    		if(scoreMatrix == 3) {
		    		
		    		System.out.println("SAYONARA BABY... MATRIX Win! ");
		    	}
	    		if(scoreUser2 == 3) {
	    			
	    			if(users.size()>=2) {
	    				
	    				powerControler = 2;
	    				
	    				System.out.println("CONGRATULATIONSS!!  " +  users.get(powerControler).getNombre() + " Youu Win!! ");
	    				
	    			}
	    		
	    		}
	    		
	    		
	    		System.out.println("\n" + "El juego finalizo  :) ");
		  }
			
		
	}
	
	
	
	
	//Metodo para comparar la eleccion escogida por la maquina y el usuario para ver quien gana
	
	public void match (User user, ArrayList<Option> options) {
  	  
		    //Damos memoria al randoom seleccion aleatoria de la maquina
		    int machineselection = (int)(Math.random()*4+1);
		
    		
			
			//System.out.println("\n" + "MATRIX elige = " +  (machineselection) + "\n"); 
			
			System.out.println("\n" + "MATRIX elige = " + options.get(machineselection-1).getName() + options.get(machineselection-1).getSimbolo() + "\n"); 
			
			
				
			//SCISSORS
			
			if(user.getChoseOption().contains("Scissors") && (options.get(machineselection-1).getName() .contains("Paper")|| options.get(machineselection-1).getName() .contains("Lizard"))) {
				
				//Sumamos los puntos del usuario
				Game.scoreUser++;
				System.out.println("\n" + "Gano " + user.getNombre() + " con "+ user.getChoseOption());
				
				
				
			}
			
			if(user.getChoseOption().contains("Scissors")  && (options.get(machineselection-1).getName() .contains("Spock") || options.get(machineselection-1).getName() .contains("Rock"))) {  
				
				//Sumamos los puntos del Matrix
				Game.scoreMatrix++;
				System.out.println("\n" + "Gana MATRIX con " + options.get(machineselection-1).getName() + " " + options.get(machineselection-1).getSimbolo() + "\n"); 
				
				
			}
			
			
			if(user.getChoseOption().contains("Scissors")  &&  (options.get(machineselection-1).getName() .contains("Scissors"))) {
				
				System.out.println("\n" + "Empato " + user.getNombre() + " con "+ user.getChoseOption());
				
			}
			
	
			//ROCK
			
			if(user.getChoseOption().contains("Rock")  && (options.get(machineselection-1).getName().contains("Scissors") || options.get(machineselection-1).getName().contains("Lizard"))) {
				
				
				//Sumamos los puntos del usuario
				Game.scoreUser++;
				System.out.println("\n" + "Gano " + user.getNombre() + " con "+ user.getChoseOption());
				
				
				
			}
			
			if(user.getChoseOption().contains("Rock") && (options.get(machineselection-1).getName().contains("Paper") || options.get(machineselection-1).getName().contains("Spock")) ) {
				
				//Sumamos los puntos del Matrix
				Game.scoreMatrix++;
				
				System.out.println("\n" + "Gana MATRIX con " + options.get(machineselection-1).getName() + " " + options.get(machineselection-1).getSimbolo() + "\n"); 
				
				
			}
			
			if(user.getChoseOption().contains("Rock") &&   options.get(machineselection-1).getName().contains("Rock")) {
				
				System.out.println("\n" + "Empato " + user.getNombre() + " con "+ user.getChoseOption());
				
			}
			
			
			
			//PAPER
			
			if(user.getChoseOption().contains("Paper") && (options.get(machineselection-1).getName().contains("Rock") || options.get(machineselection-1).getName().contains("Spock"))) {
				
				
				//Sumamos los puntos del usuario
				Game.scoreUser++;
				
				System.out.println("\n" + "Gano " + user.getNombre() + " con "+ user.getChoseOption());
				
				
				
			}
			
			if(user.getChoseOption().contains("Paper") &&  (options.get(machineselection-1).getName().contains("Lizard")|| options.get(machineselection-1).getName().contains("Scissors"))) {
				
				
				//Sumamos los puntos del Matrix
				Game.scoreMatrix++;
				
				System.out.println("\n" + "Gana MATRIX con " + options.get(machineselection-1).getName() + " " + options.get(machineselection-1).getSimbolo() + "\n"); 
				
			}
			
			if(user.getChoseOption().contains("Paper") && options.get(machineselection-1).getName().contains("Paper")) {
				
				System.out.println("\n" + "Empato " + user.getNombre() + " con "+ user.getChoseOption());
			
				
			}
			
		
			
			//SPOCK
			
			if(user.getChoseOption().contains("Spock") && (options.get(machineselection-1).getName().contains("Scissors") || options.get(machineselection-1).getName().contains("Rock"))) {
				
				//Sumamos los puntos del usuario
				
				Game.scoreUser++;
				
				System.out.println("\n" + "Gano " + user.getNombre() + " con "+ user.getChoseOption());
				
				
				
			}
			
			if(user.getChoseOption().contains("Spock") &&  (options.get(machineselection-1).getName().contains("Paper") || options.get(machineselection-1).getName().contains("Lizard"))) {
				
				//Sumamos los puntos del Matrix
				Game.scoreMatrix++;
				
				System.out.println("\n" + "Gana MATRIX con " + (options.get(machineselection-1).getName() + " " + options.get(machineselection-1).getSimbolo() + "\n")); 
				
				
			}
			
			if(user.getChoseOption().contains("Spock") &&  options.get(machineselection-1).getName().contains("Spock") ) {
				
				System.out.println("\n" + "Empato " + user.getNombre() + " con "+ user.getChoseOption());
			
			}
			
			

			//LAGARTO
			
			if(user.getChoseOption().contains("Lizard")  && (options.get(machineselection-1).getName().contains("Spock") || options.get(machineselection-1).getName().contains("Paper"))) {
				
				
				//Sumamos los puntos del usuario
				Game.scoreUser++;
				
				System.out.println("\n" + "Gano " + user.getNombre() + " con "+ user.getChoseOption());
				
				
				
			}
			
			if(user.getChoseOption().contains("Lizard")  &&  (options.get(machineselection-1).getName().contains("Scissors") || options.get(machineselection-1).getName().contains("Rock"))) {
				
				//Sumamos los puntos del Matrix
				Game.scoreMatrix++;
				System.out.println("\n" + "Gana MATRIX con " + (options.get(machineselection-1).getName() + " " + options.get(machineselection-1).getSimbolo() + "\n")); 
				
			}
			
			if(user.getChoseOption().contains("Lizard")  &&  options.get(machineselection-1).getName().contains("Lizard")) {
				
				System.out.println("\n" + "Empato " + user.getNombre() + " con "+ user.getChoseOption());
				
				
			}
			
			
		
	}
	
	
}

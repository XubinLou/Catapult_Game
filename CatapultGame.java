/*Name: Xubin Lou
 *Lab section: MW 12:30pm
 */
import java.util.Scanner;
public class CatapultGame {
	public static void Game(int bestscore) {
		int bestScore=Catapult.bestScore;  //store the best overall score of each round to the int variable bestScore.
		while(true){
			System.out.println("Welcome to Catapult Game 2020!");
		    Catapult a = new Catapult(45,50); //build an object with default value of angle and velocity
		    a.qualitywords();
			System.out.println(a);
			a.distancewords();
			Scanner s = new Scanner(System.in);
        	String command = "";
         	while(!command.equalsIgnoreCase("quit")){  //use while loop to enter the "What to do?" interface for user to enter command
				System.out.print("What to do?");
				command = s.nextLine();  //read the line of command and store it to the string variable "command"
				Scanner commandS = new Scanner(command);  //scan the line of command
					if(commandS.hasNext()) {  //check whether there's command content
						String command1=commandS.next();  //read the first string of the line command you enter
						//use if condition to recognize the command and execute corresponding actions
						if(command.equalsIgnoreCase("fire!")) {
							a.fire();
						}else if(command.equalsIgnoreCase("score")) {
						    System.out.println("score of this round:"+a.getScore());
						    System.out.println("best score overall:"+Catapult.bestScore);
					    }else if(command.equalsIgnoreCase("quit")) {
					    	System.exit(0); //exit the whole game loop
					    }else if(command.equalsIgnoreCase("reset")) {
					    	Catapult.scores=0; //let score return to 0 when reset a new game.
						    Game(bestScore); //call Game method with stored sum score in the variable bestScore
					    }else if(command.equalsIgnoreCase("inspect")) {
					    	System.out.println("launch angle:"+a.getAngle()+"\n"+"launch velocity:"+a.getVelocity());
					    	a.qualitywords();
						    a.distancewords();
					    }else if(command1.equalsIgnoreCase("set")) { //recognize command starts with "set"
								if(commandS.hasNext()) {
									String command2=commandS.next();
								    if(command2.equalsIgnoreCase("angle")) { //recognize command start with "set" and the second word is "angle"
										if(commandS.hasNext()) {
											String command3 = commandS.next();
											try {
											    double angle = Double.valueOf(command3); //transfer string to double 
												while(!(angle <= 90 && angle >= 0)) {
													System.out.print("Warning! Out of range! Please reenter the value of angle (0-90 degrees):");
												    try {
														command=s.nextLine();
														angle = Double.valueOf(command);
												    }catch(NumberFormatException e){ //if there's input error NumberFormatException, then shows the following sentence.
														System.out.println("This command cannot be understood, please reenter.");
												    }
												}
												a.setAngle(angle);
											    a.getAngle();
											} catch(NumberFormatException e){ //if there's input error NumberFormatException, then shows the following sentence.
												System.out.println("This command cannot be understood, please reenter.");
											}
										}else {
											System.out.println("The command is not intact, please reenter.");
										}
								    }else if(command2.equalsIgnoreCase("velocity")) {  //recognize command starts with "set" and the second word is "velocity"
								    	if(commandS.hasNext()) {
								    		String command3 = commandS.next();
								    	    try {
											    double velocity = Double.valueOf(command3); //transfer string to double 
											    while(!(velocity<=100 && velocity>=0)) {
											    	System.out.print("Warning! Out of range! Please reenter a numeric value of velocity (0-100 m/s):");
											    	try {
											    		command=s.nextLine();
											            velocity = Double.valueOf(command);	
											            
											    	}catch(NumberFormatException e){ //if there's input error NumberFormatException, then shows the following sentence.
														System.out.println("This command cannot be understood, please reenter.");
												    }
											    }
											    a.setVelocity(velocity);
											    a.getVelocity();
											}catch(NumberFormatException e){ //if there's input error NumberFormatException, then shows the following sentence.
											    System.out.println("This command cannot be understood, please reenter");
											}   
								    	}else { //if the command you enter is not intact enough for computer to execute some actions
											System.out.println("The command is not intact, please reenter.");
										}
		
									}else { //if some part of your command is not consistent with the given style of command
										System.out.println("This command cannot be understood, please reenter.");
									}
								}else { //if the command you enter is not intact enough for computer to execute some actions
									System.out.println("The command is not intact, please reenter.");
								}
						   }else if(command1.equalsIgnoreCase("cheat")){  //recognize the command start with "cheat"
							   a.cheat(); //call cheat method to displays catapult quality and target distance numerically.
						       if(commandS.hasNext()){
						    	   String command2=commandS.next();
						      try {
						    	   int x = Integer.parseInt(command2);// transfer string to int value
						    	   a.cheatX(x); //call cheat method to set remaining number of shot
						          }catch(NumberFormatException e){
									System.out.println("This command cannot be understood, please reenter.");
								  }
						    	   if(commandS.hasNext()) {
						    		   String command3=commandS.next();
						    	  try {
						    		   int y = Integer.parseInt(command3);
						    		   a.cheatXY(y); //call cheat method to set catapult quality
						    	      }catch(NumberFormatException e){
										System.out.println("This command cannot be understood, please reenter.");
									  }
						    		   if(commandS.hasNext()) {
						    			   String command4=commandS.next();
						    		  try {
						    			   double z = Double.valueOf(command4);
						    			   a.cheatXYZ(z); //call cheat method to set target distance
						    		      }catch(NumberFormatException e){
											System.out.println("This command cannot be understood, please reenter.");
										  }
						    		   }
						    	   }
						       }
						   
						   }else{ //if the first words of your command is not given command form words
							   System.out.println("what you entered is not command, please reenter.");
						   }
					 				    
				       }else { //if there's no command constent input
					   System.out.println("what you entered is not command, please reenter.");
				       
					commandS.close();
				}

         	}
			s.close();

		}
		}
    //main method
	public static void main(String[] args) { 
		Game(0);
	}
}




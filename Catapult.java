/*Name: Xubin Lou
 *Lab section: MW 12:30pm
 */

import java.util.Random;
import java.util.Scanner;

public class Catapult {
	// variables
	private static double g=9.8;
    private double angle, velocity, distance, location, angle1, velocity1;
	private int quality;
    static int bestScore=0, scores=0;
    protected int countershots=5;
    
    // Catapult constructor
	public Catapult(double angle,double velocity) {
		this.angle=angle;
		this.velocity=velocity;
		quality();
		distance();
	}
	// toString method
	public String toString() {
		return "Launch angle is set to "+angle+"\n"
				+"Launch velocity is set to "+velocity+"\n"
				+"you have "+countershots+" remaining.";
	}
	// create scanner s; random r
	Random r=new Random();
	Scanner s=new Scanner(System.in);

// Methods:	
	// generate setter and getters for angle
	public void setAngle(double angle) {
		this.angle = angle;
	}
	public double getAngle() {
		return angle;
	}
	// generate setter and getter for velocity
	public void setVelocity(double velocity) {
		this.velocity=velocity;	
	}
	public double getVelocity() {
		return velocity;
	}
	
	// randomly choose a numeric value of distance from given intervals 50m-1000m
	public void distance() {
		this.distance=50+(1000-50)*r.nextDouble();
	}
	// define method distancewords with a if loop, informing user the target distance of the catapult in words
	public void distancewords() {
		if(distance==50) {
			System.out.println("The target is so close");
		}else if(distance>50&&distance<=300) {
			System.out.println("The target is below midrange");
		}else if(distance>300&&distance<=550){
			System.out.println("The target is at midrange");
		}else if(distance>550&&distance<=750){
			System.out.println("The target is above midrange");
		}else {
			System.out.println("The target is so far");
		}	
	}
	public double getDistance() {
		return distance;
	}
	
	// randomly choose a numeric value of quality from given intervals 1-10
	public void quality() {
		this.quality=1+r.nextInt(10);
	}
	// define method qualitywords with if loop, informing user the quality of the catapult in words
	public void qualitywords() {
		if(quality>=1&&quality<3) {
			System.out.println("The catapult has bad quality");
		}else if(quality<5&&quality>=3) {
			System.out.println("The catapult is below average quality");
		}else if(quality==5) {
			System.out.println("The catapult is on average quality");
		}else if(quality>5&&quality<=8){
			System.out.println("The catapult is above average quality");
		}else{
			System.out.println("The catapult is very good");
		}
	}
	public int getQuality() {
		return quality;
	}
	
	// calculate the real angle value which will be used to calculate the hit location in each shots.
	// catapult quality will affect the real value of angle.
	public void realvalueangle(double angle) {
		angle1= angle+ (10-quality)*r.nextGaussian();
	}
	public double angle1() {
		return angle1;
	}
	// calculate the real velocity value which will be used to calculate the hit location in each shots.
	// catapult quality will affect the real value of velocity.
	public void realvaluevelocity(double velocity) {
		velocity1=velocity+ (10-quality)*r.nextGaussian();
	}
	public double velocity1() {
		return velocity1;
	}
	//use the physical function to calculate the hit location of each launch
	public double location() {                                                                                                                                     
		location=Math.pow(velocity1, 2)*Math.sin(2*(angle1*Math.PI/180))/g;
		return location;
	}
	//launch the shot
	public void fire() {
		if(countershots>0) {
		    realvalueangle(getAngle());
		    angle1();
		    realvaluevelocity(getVelocity());
		    velocity1();
		    location();
		    score(location,distance);
		    //best score overall
		    if(bestScore<=scores) {
		    	bestScore=scores;
		    }
	        if(countershots==1) {
		    	System.out.println("Round complete!"+"\n"+"Your score this round was "+scores+"\n"+"Best score overall:"+bestScore);
	        }
	    }else if(countershots<=0) {
	    	System.out.println("The round is over. You can reset to a new game if you want.");
	    }
		countershots-=1;
	}
    //show the feedback of each shot and calculate the sum score of this round.
	public void score(double location, double distance) {
		double difference=location-distance;
		if(difference>=50) {
			System.out.println("You missed — way too far!");
		}else if(difference>=10&&difference<50) {
			System.out.println("You missed — too far!");
		}else if(difference<=-50) {
			System.out.println("You missed — way too short!");
		}else if(difference<=-10&&difference>-50) {
			System.out.println("You missed — too short!");
		}else if(Math.abs(difference)<=2) {
			System.out.println("Perfect hit!");
			scores=scores+10;
		}else if(Math.abs(difference)>=2&&Math.abs(difference)<5) {
			System.out.println("Good hit!");
			scores=scores+7;
		}else if(Math.abs(difference)>=5&&Math.abs(difference)<10){
			System.out.println("Hit!");
			scores=scores+3;
		}
	}
	public int getScore() {
		return scores;
	}
//cheat method
	public void cheat() {
		System.out.println("The quality of the catapult:" +getQuality()+"\n"
				+"distance to the target:"+getDistance());
	}
	public void cheatX(int x) {
		countershots=x;
	}
	public void cheatXY(int y) {
		while(y>10||y<1) {
			System.out.print("The quality you entered is out of range,reenter a number from 1-10 please:");
			y=s.nextInt();
		}
		quality=y;
	}
	public void cheatXYZ(double z) {
		while(z>1000||z<50) {
			System.out.print("The distance you entered is out of range,reenter a number from 50-1000 please:");
			z=s.nextDouble();
		}
		distance=z;
	}
	
}
	

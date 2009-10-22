package org.ltwitter.main;

import org.ltwitter.gui.*;
import winterwell.jtwitter.*;
//Application launcher class

public class Main {
	public static void main(String[] args){
		
//		Twitter twitter = new Twitter("luckydev","imlooking4iit");
//		twitter.setStatus("Can this be a JDK error..i get a URLHttpConnection exception..");	
		
	
		Client lTwitter = new Client();
		lTwitter.showForm();
	}
}

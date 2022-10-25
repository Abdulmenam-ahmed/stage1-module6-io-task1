package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;


public class FileReader {

    public Profile getDataFromFile(File file) throws IOException ,Exception {
    	BufferedReader inputStream= 
			new BufferedReader (
			new java.io.FileReader(file));
	String s;
	Profile profile=new Profile();
	while ((s= inputStream.readLine()) !=null) {
		int cut= s.indexOf(":");
		
		if (s.contains("Name")) {
			profile.setName(s.substring(cut+2));
		}
		else if (s.contains("Age")) {
			try {
		profile.setAge(Integer.parseInt(s.substring(cut+2)));
			} catch (Exception ex) {
				//
			}
		}
		else if (s.contains("Email")) {
		profile.setEmail(s.substring(cut+2));
		}
		else {
			try {
			profile.setPhone(Long.parseLong(s.substring(cut+2)));
			} catch (Exception ex) {
				//
			}
		}
	
	}
	System.out.println(profile.getName());
	System.out.println(profile.getAge());
	System.out.println(profile.getEmail());
	System.out.println(profile.getPhone());
	inputStream.close();
	return  new Profile(profile.getName(),
			     profile.getAge(),
			     profile.getEmail(),
			     profile.getPhone());
	
}
    }


//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez
//		* Student Number: 101314570,
//		* Date:
//		* Description: <describe the java file and its purpose briefly only – 1 or 2 lines>

package com.a1.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class CookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}

}

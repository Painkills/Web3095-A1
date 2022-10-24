//* Project: < cookbook.a1.com >
//		* Assignment: Comp 3095 #1
//		* Author(s): David Fortich, Mitesh Mitry, Ronal Rodriguez, Lemuel Javier
//		* Student Number: 101314570, 101248745, 101314540, 101168735
//		* Date: October 14, 2022
//		* Description: This basically just tells Spring where to start scanning and runs the app itself.

package com.a1.cookbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CookbookApplication {

	public static void main(String[] args) {
		SpringApplication.run(CookbookApplication.class, args);
	}

}

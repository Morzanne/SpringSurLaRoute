package com.wildcodeschool.SpringSurLaRoute;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.server.ResponseStatusException;

@Controller
@SpringBootApplication
public class SpringSurLaRouteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSurLaRouteApplication.class, args);
	}

	@RequestMapping("/doctor/{number}")
	@ResponseBody
	public Doctor newDoc(@PathVariable int number, @RequestParam(required = false) boolean details) {


		if(details == true){
			if (number == 9) {
				return new Doctor("Christopher Eccleston", 9, 13, 41);
			} else if (number == 10) {
				return new Doctor("David Trennant", 10, 47, 38);
			} else if (number == 11) {
				return new Doctor("Matt Smith", 11, 44, 27);
			} else if (number == 12) {
				return new Doctor("Peter capaldi", 12, 40, 55);
			} else if (number == 13) {
				return new Doctor("Jodie Whittaker", 13, 11, 35);
			}
		}else if(details == false){
			if (number == 9) {
				return new Doctor("Christopher Eccleston", 9);
			} else if (number == 10) {
				return new Doctor("David Trennant", 10);
			} else if (number == 11) {
				return new Doctor("Matt Smith", 11);
			} else if (number == 12) {
				return new Doctor("Peter capaldi", 12);
			} else if (number == 13) {
				return new Doctor("Jodie Whittaker", 13);
			}

		}
		if (number > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
		}
		throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Look for something else");


		/*if (number < 8) {

			throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Look for something else");
		}

		if (number > 13) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Impossible de récupérer l'incarnation " + number);
		}

		if (details == true) {

			if (number < 8) {

				throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Look for something else");
			} else if (number == 9) {
				return new Doctor("Christopher Eccleston", 9, 13, 41);
			} else if (number == 10) {
				return new Doctor("David Trennant", 10, 47, 38);
			} else if (number == 11) {
				return new Doctor("Matt Smith", 11, 44, 27);
			} else if (number == 12) {
				return new Doctor("Peter capaldi", 12, 40, 55);
			} else if (number == 13) {
				return new Doctor("Jodie Whittaker", 13, 11, 35);
			}

		} else if (details == false) {


			if (number < 8) {

				throw new ResponseStatusException(HttpStatus.SEE_OTHER, "Look for something else");
			} else if (number == 9) {
				return new Doctor("Christopher Eccleston", 9);
			} else if (number == 10) {
				return new Doctor("David Trennant", 10);
			} else if (number == 11) {
				return new Doctor("Matt Smith", 11);
			} else if (number == 12) {
				return new Doctor("Peter capaldi", 12);
			} else if (number == 13) {
				return new Doctor("Jodie Whittaker", 13);
			}

		}*/

	}

}




class Doctor{

	private String name;
	private int number;
	private int numberOfEpisodes;
	private int ageAtStart;

	public Doctor(String name, int number, int numberOfEpisodes, int ageAtStart ){
		this.name=name;
		this.number=number;
		this.numberOfEpisodes=numberOfEpisodes;
		this.ageAtStart=ageAtStart;
	}

	public Doctor(String name, int number){
		this.name=name;
		this.number=number;
	}

	public String getName(){
		return this.name;
	}

	public int getNumber(){
		return this.number;
	}

	public int getNumberOfEpisodes(){
		return this.numberOfEpisodes;
	}

	public int getAgeAtStart(){
		return this.ageAtStart;
	}

}

/*class otherDoct{

	private String name;
	private int number;

	public otherDoct(String name, int number){
		this.name=name;
		this.number=number;
	}
	public String getName(){
		return this.name;
	}
	public String getNumber(){
		return this.number;
	}
}*/
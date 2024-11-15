package com.webapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@GetMapping(value = "/getHello")
	public String get() {
		return "Hello";
	}


@GetMapping(value ="/getName/{a}")
public String getName(@PathVariable String a)
{
	return "Hello" + a;
}

@GetMapping(value = "/getAdd/{b}/{c}")
public int getAdd(@PathVariable int b,@PathVariable int c)
{
	return b+c;
}

@GetMapping(value ="/getLength/{a}")
public int getLength(@PathVariable String a)
{
	return a.length();
}


@GetMapping(value ="/great")  //http://localhost:8080/great?num1=1&num2=10
public String findGreatest(@RequestParam int num1,@RequestParam int num2)
{
	if(num1>num2)
	{
		return "The Greatest number is "+num1;
	}
	else 
	{
		return "The Greatest value is "+num2;
	}
}

@GetMapping(value ="/getCombine")   //http://localhost:8080/getCombine
public String getCombine(@RequestParam(defaultValue="birunda") String name1,@RequestParam(defaultValue="kavin") String name2)
{
	if(name1.length()>name2.length())
	{
		return name1.concat(name2);
	}
	else
	{
		return name1;
	}
}
	
@GetMapping(value ="/getMiddle/{a}") 
public String getMiddle(@PathVariable String a)
{
	String temp="";
	for(int i=0;i<a.length()-1;i++) {
	if(a.length()%2==0)
	{
		return temp=temp+a.substring(a.length()/2-1,a.length()/2+1)+" ";
	}
	else
	{
		return temp=temp+a.charAt(a.length()/2)+" ";
	}
	}
	return temp;  
}



@GetMapping(value ="/getCredential/{username}/{password}")
public String getCredential(@PathVariable String username,@PathVariable String password)
{
	if(username.equals("BIRUNDA") && password.equals("Janu123"))
	{
		return "login successfull";
	}
	else
	{
		return "login failed";
	}
}

}


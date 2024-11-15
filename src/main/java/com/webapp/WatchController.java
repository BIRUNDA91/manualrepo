package com.webapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WatchController {
	@GetMapping(value = "/getWatch")
	public Watch getWatch(@RequestBody Watch w) {
		return w;
	}

  @GetMapping(value ="/getWatches")
  public List<Watch> getWatches(@RequestBody List<Watch> a)
  {
	 // List<Watch> m = a.stream().collect(Collectors.toList());
	 // return m;
	  for(Watch x:a)
	  {
		  x.setId(x.getId());
		  x.setBrand(x.getBrand());
		  x.setPrice(x.getPrice());
	  }
	  return a;
  }
  
  @GetMapping(value ="/getgreater")
  public List<Integer> getgreater(@RequestBody List<Watch> watches)
  {
	  List<Integer> great=new ArrayList<>();
	  for(Watch x:watches)
	  {
		  if(x.getPrice()>1500)
		  {
			  great.add(x.getPrice());
		  }
	  }
	  return great;
  }
  
  @GetMapping(value ="/getMax")
  public Watch getMax(@RequestBody List<Watch> watches1)
  {
	  Watch max=watches1.get(0);
	  for(Watch x:watches1)
	  {
		  if(x.getPrice()>max.getPrice())
		  {
			  max=x;
		  }
	  }
	  return max;
  }
  
  @GetMapping(value ="/getBrands")
  public String getBrands(@RequestBody List<Watch> watches2)
  {
	  String temp="";
	  for(Watch x:watches2)
	  {
		  temp=temp+x.getBrand()+" ";
	  }
	  return temp;
  }
  
  @GetMapping(value ="/getBrandlength")
  public String getBrandLength(@RequestBody List<Watch> watches3)
  {
	  String temp="";
	  for(Watch x:watches3)
	  {
		  if(x.getBrand().length()>5)
		  {
			  temp=temp+x.getBrand()+" ";
		  }
	  }
	  return temp;
  }
  
  @GetMapping(value ="/getBrandmin")
  public Watch getBrandmin(@RequestBody List<Watch> watches4)
  {
	  Watch min=watches4.get(0);
	  for(Watch x:watches4)
	  {
		  if(x.getBrand().length()<min.getBrand().length())
		  {
			  min=x;
		  }
	  }
	  return min;
  }
  
  @GetMapping(value ="/getAddPrice")
  public List<Integer> getAddPrice(@RequestBody List<Watch> watches5)
  {
	  List<Integer> priceadd=new ArrayList<>();
	  Integer value=watches5.stream().map(x->x.getPrice()).distinct().collect(Collectors.summingInt(Integer::intValue));
	  priceadd.add(value);
      return priceadd;
  }
  
  @GetMapping(value ="/getNamecount")
  public Map<String,Long> getNamecount(@RequestBody List<Watch> watches6)
  {
	Map<String,Long> w=watches6.stream().collect(Collectors.groupingBy(Watch::getBrand,Collectors.counting()));  
	return w;
  }
  
  @GetMapping(value ="/getMid")	
  public String getMid(@RequestBody List<Watch> watches6)
  {
	  String temp="";
	 for(Watch x:watches6)
	 {
		 if(x.getBrand().length()%2==0)
		 {
			//temp=temp+x.getBrand().charAt(x.getBrand().length()/2-1)+x.getBrand().charAt(x.getBrand().length()/2)+" ";
		  temp=temp+x.getBrand().substring(x.getBrand().length()/2-1,x.getBrand().length()/2+1)+" ";
		 }
		 else
		 {
		  temp=temp+x.getBrand().charAt(x.getBrand().length()/2)+" ";
		 }
	 }
	 return temp;
  }
   
  @GetMapping(value ="/getID")
  public Map<Integer,Integer> getID(@RequestBody List<Watch> watches7)
  {
	  Map<Integer,Integer> countid=watches7.stream().collect(Collectors.toMap(x->x.getId(),y->y.getPrice()));
     return countid;
  }
  
  @GetMapping(value ="/getNetprice")
  public List<Integer> getNetprice(@RequestBody List<Watch> watches8)
  {
	  List<Integer> w=watches8.stream().map(x->{
		  if(x.getPrice()>1500)
	  {
		  return x.getPrice()+(x.getPrice()*15/100);
	  }
	  else
	  {
		  return x.getPrice();
	  }
	  }).collect(Collectors.toList());
	  return w;
  }
  
  @GetMapping(value ="/getSecMax")
  public Watch getSecMax(@RequestBody List<Watch> watches9)
  {
	  Watch maxsec=watches9.stream().sorted(Comparator.comparing(Watch::getPrice).reversed()).distinct()
			                  .skip(1).findFirst().get();
	  return maxsec;
  }
  
  @GetMapping(value ="/getDuplicate")
  public Map<String,Long> getDuplicate(@RequestBody List<Watch> watches10)
  {
	  Map<String, Long> dup=watches10.stream().filter(x->Collections.frequency(watches10,x.getBrand())>1).collect(Collectors.groupingBy(x->x.getBrand(),Collectors.counting()));
	  return dup;
  }
}















//get all the watches whose price is greater than 1500
//find  the watch which has the maximum price
//find all the brands of the watches.
//find all the watch in which brand length>5 
//find the watch which has min length of brand


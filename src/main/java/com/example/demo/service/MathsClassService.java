package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.example.demo.model.MathsClass;
import com.example.demo.repository.MathsClassRepository;

import jakarta.annotation.PostConstruct;

@Service
public class MathsClassService{
	
	@Autowired
	private MathsClassRepository repo;
	
	private List<MathsClass> mathsClass;
	
    @PostConstruct
    public void init() {
        // Load data from the database when the application starts
    	mathsClass = repo.findAll();  // Or your custom query
        
        System.out.println("Maths Classes Loaded.");
                
    }
    
	public List<MathsClass> loadedMathsClasses(){
		
		 return mathsClass;
	}
	
	public List<MathsClass> listAll(){
		
		 return repo.findAll();
	}
	
	
	public void save(MathsClass msc) {
		
		  repo.save(msc);
	}
	
	public void delete(MathsClass msc) {
		
		repo.delete(msc);
		
	}
	
	
	public MathsClass findOneClass(Long id) {
		
		 Optional<MathsClass> onClass = repo.findById(id);
		 
		 MathsClass oneClass = onClass.get();
		      
		    return oneClass;
		
		}
	
	@Async
	public void update(Long id) {
	       
		 Optional<MathsClass> onClass = repo.findById(id);
		 
		 if (onClass.isPresent()){
			 
			 MathsClass oneClass = onClass.get();

			 oneClass.setAction("Opened");
			  
	            repo.save(oneClass);
	            
	            // Update the object in the list
	            for (MathsClass css : mathsClass) {
	            	
	                if (css.equals(oneClass)) {
	                    css.setAction("Opened");
	                    break;
	                }
	            }
	            
       }
        
	 }
	
	public void reloadClasses() {
	    this.mathsClass = repo.findAll();
	}
	
	
	
}
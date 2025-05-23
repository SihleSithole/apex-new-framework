package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.BecomeTutor;
import com.example.demo.repository.BecomeTutorRepository;

import jakarta.annotation.PostConstruct;

@Service
public class BecomeTutorService {
	
	@Autowired
	private BecomeTutorRepository repo;
	
	private List<BecomeTutor> tutors;
	
    @PostConstruct
    public void init() {
        // Load data from the database when the application starts
    	tutors = repo.findAll();  // Or your custom query
        
        System.out.println("Tutors Application Loaded.");
                
    }
    
	public List<BecomeTutor> loadedTutors(){
		
		 return tutors;
	}
	
	
	public List<BecomeTutor> listAll(){
		
		 return repo.findAll();
	}
	
	public void save(BecomeTutor msc) {
		
		  repo.save(msc);
	}
	
	public void delete(BecomeTutor msc) {
		
		repo.delete(msc);
		
	}
	
	public BecomeTutor findOneTutor(String email) {
		
	 Optional<BecomeTutor> onClass = repo.findById(email);
	 
	 BecomeTutor oneTutor = onClass.get();
	      
	    return oneTutor;
	
	}
	
	

}
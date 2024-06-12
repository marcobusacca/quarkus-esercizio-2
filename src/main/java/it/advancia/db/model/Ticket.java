package it.advancia.db.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Ticket {
	
    @Id
    @GeneratedValue()
    private Long id;
    
    @Column(length = 20)
    private String name;
    
    @Column(length = 3)
    private String seat;
   
    public Ticket() {}
    public Ticket(String name, String seat) {
    	this.name = name;
    	this.seat = seat;
    }
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSeat() {
		return seat;
	}
	public void setSeat(String seat) {
		this.seat = seat;
	}
}
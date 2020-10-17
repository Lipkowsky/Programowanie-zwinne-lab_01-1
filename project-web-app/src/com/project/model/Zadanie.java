package com.project.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="zadanie")
public class Zadanie {
@Id
@GeneratedValue
@Column(name="zadanie_id")
private Integer zadanieId;
@ManyToOne
@JoinColumn(name = "projekt_id")
private Projekt projekt;
@Column(nullable = false, length = 50)
private String nazwa;
@Column
private int kolejnosc;
@Column(length = 1000)
private String opis;
@Column(name = "dataczas_dodania")
private LocalDateTime dataDodania;

@OneToMany(mappedBy = "projekt")
private List<Zadanie> zadania;

public Integer getZadanieId() {
	return zadanieId;
}
public void setZadanieId(Integer zadanieId) {
	this.zadanieId = zadanieId;
}
public Projekt getProjekt() {
	return projekt;
}
public void setProjekt(Projekt projekt) {
	this.projekt = projekt;
}
public String getNazwa() {
	return nazwa;
}
public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}
public int getKolejnosc() {
	return kolejnosc;
}
public void setKolejnosc(int kolejnosc) {
	this.kolejnosc = kolejnosc;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}
public LocalDateTime getDataDodania() {
	return dataDodania;
}
public void setDataDodania(LocalDateTime dataDodania) {
	this.dataDodania = dataDodania;
}

public Zadanie()
{
	
}
public List<Zadanie> getZadania() {
	return zadania;
}
public void setZadania(List<Zadanie> zadania) {
	this.zadania = zadania;
}


}

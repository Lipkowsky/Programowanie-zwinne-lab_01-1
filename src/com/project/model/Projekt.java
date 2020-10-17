package com.project.model;


import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name="projekt") //potrzebne tylko je¿eli nazwa tabeli w bazie danych ma byæ inna od nazwy klasy
public class Projekt {
@Id
@GeneratedValue
@Column(name="projekt_id") //tylko je¿eli nazwa kolumny w bazie danych ma byæ inna od nazwy zmiennej
private Integer projektId;
@Column(nullable = false, length = 50)
private String nazwa;
@Column(length = 1000)
private String opis;
@CreationTimestamp
@Column(name = "dataczas_utworzenia", nullable = false, updatable = false)
private LocalDateTime dataCzasUtworzenia;
@UpdateTimestamp
@Column(name = "dataczas_modyfikacji", nullable = false)
private LocalDateTime dataCzasModyfikacji;
@ManyToMany
@JoinTable(name = "projekt_student",
joinColumns = {@JoinColumn(name="projekt_id")},
inverseJoinColumns = {@JoinColumn(name="student_id")})
private Set<Student> studenci;


public Projekt(){
}
public Integer getProjektId() {
return projektId;
}
public void setProjektId(Integer projektId) {
this.projektId = projektId;
}
public String getNazwa() {
return nazwa;
}
public void setNazwa(String nazwa) {
this.nazwa = nazwa;
}
public String getOpis() {
	return opis;
}
public void setOpis(String opis) {
	this.opis = opis;
}
public LocalDateTime getDataCzasUtworzenia() {
	return dataCzasUtworzenia;
}
public void setDataCzasUtworzenia(LocalDateTime dataCzasUtworzenia) {
	this.dataCzasUtworzenia = dataCzasUtworzenia;
}
public LocalDateTime getDataCzasModyfikacji() {
	return dataCzasModyfikacji;
}
public void setDataCzasModyfikacji(LocalDateTime dataCzasModyfikacji) {
	this.dataCzasModyfikacji = dataCzasModyfikacji;
}
public Set<Student> getStudenci() {
	return studenci;
}
public void setStudenci(Set<Student> studenci) {
	this.studenci = studenci;
}



}
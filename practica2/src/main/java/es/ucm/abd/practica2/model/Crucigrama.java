package es.ucm.abd.practica2.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Crucigrama {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String titulo;
	@Column
	private Date fecha;
	
	@OneToMany(mappedBy = "crucigrama",cascade = CascadeType.ALL)
	private List<Contiene> palabras;

	public Crucigrama() {
		
	}
	public Crucigrama(Integer id, String titulo , Date fecha) {
		this.id = id;
		this.titulo = titulo;
		this.fecha = fecha;
		this.palabras = new ArrayList<Contiene>();
	}
	
	public Crucigrama(String titulo , Date fecha) {
		this.titulo = titulo;
		this.fecha = fecha;
		this.palabras = new ArrayList<Contiene>();
	}
	
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	
	public String getTitulo(){
		return titulo;
	}
	public void setTitulo(String titulo){
		this.titulo = titulo;
	}
	
	public Date getFecha(){
		return fecha;
	}
	public void setFecha(Date fecha){
		this.fecha = fecha;
	}
	public List<Contiene> getPalabras() {
		return palabras;
	}

	public void setPalabras(List<Contiene> palabras) {
		this.palabras = palabras;
	}
	public void addPalabra(Contiene palabra){
		palabras.add(palabra);
		
	}
	public String toString(){
		return "Crucigrama [IdCrucigrama= " + id + ", Titulo= " + titulo
		+ ", Fecha=" + fecha + "]";	
	}
}

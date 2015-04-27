package es.ucm.abd.practica2.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ContieneClave.class)
public class Contiene {
	
	@Id
	@ManyToOne
	private Crucigrama crucigrama;
	@Id
	@ManyToOne
	private Definicion definicion;
	@Column
	private Integer x;
	@Column
	private Integer y;
	@Enumerated(EnumType.ORDINAL)
	private Orientation orientacion;
	public Contiene() {
	
	}
	public Contiene(Crucigrama crucigrama,Definicion definicion, Integer x,
			Integer y, Orientation orientacion) {
		
		this.crucigrama = crucigrama;
		this.definicion = definicion;
		this.x = x;
		this.y = y;
		this.orientacion = orientacion;
	}
	public Crucigrama getCrucigrama() {
		return crucigrama;
	}
	public void setCrucigrama(Crucigrama crucigrama) {
		this.crucigrama = crucigrama;
	}
	public Definicion getDefinicion() {
		return definicion;
	}
	public void setDefinicion(Definicion definicion) {
		this.definicion = definicion;
	}
	public Integer getX() {
		return x;
	}
	public void setX(Integer x) {
		this.x = x;
	}
	public Integer getY() {
		return y;
	}
	public void setY(Integer y) {
		this.y = y;
	}
	public Orientation getOrientacion() {
		return orientacion;
	}
	public void setOrientacion(Orientation orientacion) {
		this.orientacion = orientacion;
	}
	@Override
	public String toString() {
		return "Contiene [Crucigrama=" + crucigrama + ", Definicion="
				+ definicion + ", x=" + x + ", y=" + y + ", orientacion="
				+ orientacion + "]";
	}
	
	
	
	
}

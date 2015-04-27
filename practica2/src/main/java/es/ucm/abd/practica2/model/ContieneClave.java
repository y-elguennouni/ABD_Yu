package es.ucm.abd.practica2.model;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ContieneClave  implements Serializable{
	
	
	private Crucigrama crucigrama;
	private Definicion definicion;
	public ContieneClave(Crucigrama crucigrama, Definicion definicion) {
		this.crucigrama = crucigrama;
		this.definicion = definicion;
	}
	public ContieneClave() {
		
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
	@Override
	public String toString() {
		return "ContieneClave [crucigrama=" + crucigrama + ", definicion="
				+ definicion + "]";
	}
	
	
	

	
	


}

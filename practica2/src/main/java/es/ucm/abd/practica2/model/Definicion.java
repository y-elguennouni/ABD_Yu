package es.ucm.abd.practica2.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OrderColumn;

@Entity
public class Definicion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column
	private String enunciado;
	@Column
	private String respuesta;
	@Lob
	private byte[] imagen;
	
	@OrderColumn(name = "orden")
	@ElementCollection
	private String[] etiquetas;

	
	public Definicion() {
		
	}
	public Definicion(Integer id, String enunciado, String respuesta,
			byte[] imagen, String[] etiquetas) {
		super();
		this.id = id;
		this.enunciado = enunciado;
		this.respuesta = respuesta;
		this.imagen = imagen;
		this.etiquetas = etiquetas;
	}
	
	public Definicion(String enunciado, String respuesta, String[] etiquetas) {
		this.enunciado = enunciado;
		this.respuesta = respuesta;
		this.etiquetas = etiquetas;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public String getRespuesta() {
		return respuesta;
	}

	@Override
	public String toString() {
		return "Definicion [id=" + id + ", enunciado=" + enunciado
				+ ", respuesta=" + respuesta + ", imagen="
				+ Arrays.toString(imagen) + ", etiquetas="
				+ Arrays.toString(etiquetas) + "]";
	}

	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}

	public byte[] getImagen() {
		return imagen;
	}

	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}

	public String[] getEtiquetas() {
		return etiquetas;
	}

	public void setEtiquetas(String[] etiquetas) {
		this.etiquetas = etiquetas;
	}


}

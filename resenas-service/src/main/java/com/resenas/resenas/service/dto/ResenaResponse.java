package com.resenas.resenas.service.dto;

public class ResenaResponse {
	private int id;
	private String comentario;
	private int calificacion;
	private int peliculaId;
	
	public ResenaResponse() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public int getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}

	public int getPeliculaId() {
		return peliculaId;
	}

	public void setPeliculaId(int peliculaId) {
		this.peliculaId = peliculaId;
	}
	
	
}

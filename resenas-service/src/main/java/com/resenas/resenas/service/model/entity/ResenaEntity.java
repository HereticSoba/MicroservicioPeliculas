package com.resenas.resenas.service.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name="tb_resena")
public class ResenaEntity {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int id;
		private String comentario;
		private int calificacion;
		private int peliculaId;
		
		public ResenaEntity() {
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

package com.distribuida.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "factura_detalle")
public class DetalleFactura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_factura_detalle")
	private int idDetalleFactura;
	@Column(name = "cantidad")
	private int cantidad;
	@Column(name = "subtotal")
	private double subTotal;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_factura")
	private Factura factura;
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "id_libro")
	private Libro libro;

	public DetalleFactura() {}

	public DetalleFactura(int idDetalleFactura, int cantidad, double subTotal, Factura factura, Libro libro) {
		this.idDetalleFactura = idDetalleFactura;
		this.cantidad = cantidad;
		this.subTotal = subTotal;
		this.factura = factura;
		this.libro = libro;
	}

	public int getIdDetalleFactura() {
		return idDetalleFactura;
	}

	public void setIdDetalleFactura(int idDetalleFactura) {
		this.idDetalleFactura = idDetalleFactura;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}


	@Override
	public String toString() {
		return "DetalleFactura [idDetalleFactura=" + idDetalleFactura + ", cantidad=" + cantidad + ", subTotal="
				+ subTotal + ", factura=" + factura + ", libro=" + libro + "]";
	}
}

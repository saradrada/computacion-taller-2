package icesi.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


/**
 * The persistent class for the tmio1_servicios database table.
 * 
 */
@Entity
@Table(name="tmio1_servicios")
@NamedQuery(name="Tmio1Servicio.findAll", query="SELECT t FROM Tmio1Servicio t")
public class Tmio1Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date tmioFechaInicio;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date tmioFechaFin;
	
	@EmbeddedId
	private Tmio1ServicioPK id;
	
	private Integer id_hash;

	//bi-directional many-to-one association to Tmio1Bus
	@ManyToOne
	@JoinColumn(name="id_bus", insertable=false, updatable=false)
	@NotNull
	private Tmio1Bus tmio1Bus;

	//bi-directional many-to-one association to Tmio1Conductore
	@ManyToOne
	@JoinColumn(name="cedula_conductor", insertable=false, updatable=false)
	@NotNull
	private Tmio1Conductore tmio1Conductore;

	//bi-directional many-to-one association to Tmio1Ruta
	@ManyToOne
	@JoinColumn(name="id_ruta", insertable=false, updatable=false)
	@NotNull
	private Tmio1Ruta tmio1Ruta;

	public Tmio1Servicio() {
	}

	public Tmio1ServicioPK getId() {
		return this.id;
	}

	public void setId(Tmio1ServicioPK id) {
		this.id = id;
	}

	public Tmio1Bus getTmio1Bus() {
		return this.tmio1Bus;
	}

	public void setTmio1Bus(Tmio1Bus tmio1Bus) {
		this.tmio1Bus = tmio1Bus;
	}

	public Tmio1Conductore getTmio1Conductore() {
		return this.tmio1Conductore;
	}

	public void setTmio1Conductore(Tmio1Conductore tmio1Conductore) {
		this.tmio1Conductore = tmio1Conductore;
	}

	public Tmio1Ruta getTmio1Ruta() {
		return this.tmio1Ruta;
	}

	public void setTmio1Ruta(Tmio1Ruta tmio1Ruta) {
		this.tmio1Ruta = tmio1Ruta;
	}

	public Date getTmioFechaInicio() {
		return tmioFechaInicio;
	}

	public void setTmioFechaInicio(Date tmioFechaInicio) {
		this.tmioFechaInicio = tmioFechaInicio;
	}

	public Date getTmioFechaFin() {
		return tmioFechaFin;
	}

	public void setTmioFechaFin(Date tmioFechaFin) {
		this.tmioFechaFin = tmioFechaFin;
	}

	public Integer getId_hash() {
		return id_hash;
	}

	public void setId_hash(Integer id_hash) {
		this.id_hash = id_hash;
	}

}
package icesi.edu.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the tmio1_servicios_sitios database table.
 * 
 */
@Entity
@Table(name="tmio1_servicios_sitios")
@NamedQuery(name="Tmio1ServiciosSitio.findAll", query="SELECT t FROM Tmio1ServiciosSitio t")
public class Tmio1ServiciosSitio implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Tmio1ServiciosSitioPK id;

	@Column(name="hora_real")
	private BigDecimal horaReal;

	private String realizado;

	//bi-directional many-to-one association to Tmio1Bus
	@ManyToOne
	@JoinColumn(name="id_bus", insertable=false, updatable=false)
	private Tmio1Bus tmio1Bus;

	//bi-directional many-to-one association to Tmio1Conductore
	@ManyToOne
	@JoinColumn(name="cedula_conductor", insertable=false, updatable=false)
	private Tmio1Conductore tmio1Conductore;

	//bi-directional many-to-one association to Tmio1Ruta
	@ManyToOne
	@JoinColumn(name="id_ruta", insertable=false, updatable=false)
	private Tmio1Ruta tmio1Ruta;

	//bi-directional many-to-one association to Tmio1Sitio
	@ManyToOne
	@JoinColumn(name="id_sitios", insertable=false, updatable=false)
	private Tmio1Sitio tmio1Sitio;

	public Tmio1ServiciosSitio() {
	}

	public Tmio1ServiciosSitioPK getId() {
		return this.id;
	}

	public void setId(Tmio1ServiciosSitioPK id) {
		this.id = id;
	}

	public BigDecimal getHoraReal() {
		return this.horaReal;
	}

	public void setHoraReal(BigDecimal horaReal) {
		this.horaReal = horaReal;
	}

	public String getRealizado() {
		return this.realizado;
	}

	public void setRealizado(String realizado) {
		this.realizado = realizado;
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

	public Tmio1Sitio getTmio1Sitio() {
		return this.tmio1Sitio;
	}

	public void setTmio1Sitio(Tmio1Sitio tmio1Sitio) {
		this.tmio1Sitio = tmio1Sitio;
	}

}
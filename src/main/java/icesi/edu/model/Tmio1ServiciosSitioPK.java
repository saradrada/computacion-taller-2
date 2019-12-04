package icesi.edu.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tmio1_servicios_sitios database table.
 * 
 */
@Embeddable
public class Tmio1ServiciosSitioPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="id_ruta", insertable=false, updatable=false)
	private Integer idRuta;

	@Column(name="id_sitios", insertable=false, updatable=false)
	private Integer idSitios;

	@Column(name="cedula_conductor", insertable=false, updatable=false)
	private String cedulaConductor;

	@Column(name="id_bus", insertable=false, updatable=false)
	private Integer idBus;

	@Temporal(TemporalType.DATE)
	private java.util.Date fecha;

	@Column(name="hora_programada")
	private long horaProgramada;

	public Tmio1ServiciosSitioPK() {
	}
	public Integer getIdRuta() {
		return this.idRuta;
	}
	public void setIdRuta(Integer idRuta) {
		this.idRuta = idRuta;
	}
	public Integer getIdSitios() {
		return this.idSitios;
	}
	public void setIdSitios(Integer idSitios) {
		this.idSitios = idSitios;
	}
	public String getCedulaConductor() {
		return this.cedulaConductor;
	}
	public void setCedulaConductor(String cedulaConductor) {
		this.cedulaConductor = cedulaConductor;
	}
	public Integer getIdBus() {
		return this.idBus;
	}
	public void setIdBus(Integer idBus) {
		this.idBus = idBus;
	}
	public java.util.Date getFecha() {
		return this.fecha;
	}
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}
	public long getHoraProgramada() {
		return this.horaProgramada;
	}
	public void setHoraProgramada(long horaProgramada) {
		this.horaProgramada = horaProgramada;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Tmio1ServiciosSitioPK)) {
			return false;
		}
		Tmio1ServiciosSitioPK castOther = (Tmio1ServiciosSitioPK)other;
		return 
			this.idRuta.equals(castOther.idRuta)
			&& this.idSitios.equals(castOther.idSitios)
			&& this.cedulaConductor.equals(castOther.cedulaConductor)
			&& this.idBus.equals(castOther.idBus)
			&& this.fecha.equals(castOther.fecha)
			&& (this.horaProgramada == castOther.horaProgramada);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.idRuta.hashCode();
		hash = hash * prime + this.idSitios.hashCode();
		hash = hash * prime + this.cedulaConductor.hashCode();
		hash = hash * prime + this.idBus.hashCode();
		hash = hash * prime + this.fecha.hashCode();
		hash = hash * prime + ((int) (this.horaProgramada ^ (this.horaProgramada >>> 32)));
		
		return hash;
	}
}
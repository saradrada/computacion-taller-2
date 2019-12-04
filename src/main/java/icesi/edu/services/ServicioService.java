package icesi.edu.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.exceptions.BusNullException;
import icesi.edu.exceptions.ConductorNullException;
import icesi.edu.exceptions.FechasNoConsistentesException;
import icesi.edu.exceptions.RutaNullException;
import icesi.edu.exceptions.ServicioNullException;
import icesi.edu.model.Tmio1Servicio;
import icesi.edu.model.Tmio1ServicioPK;
import icesi.edu.repositories.ServiciosRepository;

@Service
public class ServicioService {

	@Autowired
	private ServiciosRepository repository;

	public Tmio1Servicio save(Tmio1Servicio servicio) throws BusNullException, ConductorNullException,
			RutaNullException, FechasNoConsistentesException, ServicioNullException {

		if (servicio == null) {
			throw new ServicioNullException();
		} else {

			Tmio1ServicioPK pk = new Tmio1ServicioPK();
			pk.setCedulaConductor(servicio.getTmio1Conductore().getCedula());
			pk.setFechaFin(servicio.getTmioFechaFin());
			pk.setFechaInicio(servicio.getTmioFechaInicio());
			pk.setIdBus(servicio.getTmio1Bus().getId());
			pk.setIdRuta(servicio.getTmio1Ruta().getId());

			servicio.setId(pk);
			servicio.setId_hash(pk.getHashCode());
		}

		if (servicio.getTmio1Bus() == null) {
			throw new BusNullException();
		} else if (servicio.getTmio1Conductore() == null) {
			throw new ConductorNullException();
		} else if (servicio.getTmio1Ruta() == null) {
			throw new RutaNullException();
		} else if (servicio.getTmioFechaInicio().compareTo(servicio.getTmioFechaFin()) == 1) {
			throw new FechasNoConsistentesException();
		} else if (servicio.getTmio1Conductore().getFechaContratacion().compareTo(servicio.getTmioFechaInicio()) == 1) {
			throw new FechasNoConsistentesException();
		} else {
			return repository.save(servicio);
		}
	}

	public Iterable<Tmio1Servicio> findAll() {
		return repository.findAll();
	}

	public Optional<Tmio1Servicio> findById(Tmio1ServicioPK id) {
		return repository.findById(id);
	}

	public void delete(Tmio1Servicio servicio) {
		repository.delete(servicio);
	}

	public Iterable<Tmio1Servicio> filter(Date inicio, Date fin) {

		Iterable<Tmio1Servicio> lista = this.findAll();
		ArrayList<Tmio1Servicio> resultado = new ArrayList<>();
		for (Tmio1Servicio t : lista) {
			if (t.getTmioFechaInicio().compareTo(inicio) >= 0 && t.getTmioFechaFin().compareTo(fin) <= 0) {
				resultado.add(t);
			}
		}

		return resultado;
	}

}

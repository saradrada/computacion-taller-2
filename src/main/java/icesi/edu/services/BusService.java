package icesi.edu.services;

import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import icesi.edu.exceptions.BusNullException;
import icesi.edu.exceptions.BusTipoException;
import icesi.edu.exceptions.CapacidadNullException;
import icesi.edu.exceptions.GuardarBusException;
import icesi.edu.exceptions.TipoNullException;
import icesi.edu.model.BusType;
import icesi.edu.model.Tmio1Bus;
import icesi.edu.model.Tmio1Conductore;
import icesi.edu.model.UserType;
import icesi.edu.repositories.BusesRepository;

@Service
public class BusService {

	@Autowired
	private BusesRepository repository;

	public Tmio1Bus save(Tmio1Bus bus)
			throws GuardarBusException, BusNullException, BusTipoException, TipoNullException, CapacidadNullException {

		if (bus == null) {
			throw new BusNullException();
		} else if (bus.getTipo() == null || bus.getTipo().equals("")) {
			throw new TipoNullException();
		} else if (bus.getCapacidad() == null) {
			throw new CapacidadNullException();
		} else if ((bus.getCapacidad().compareTo(new BigDecimal(0)) <= 0)) {
			throw new GuardarBusException();
		} else if (!(bus.getTipo().toString().equals("T") || bus.getTipo().toString().equals("P") || bus.getTipo().toString().equals("A"))) {
			throw new BusTipoException();
		} else {
			repository.save(bus);
			return bus;
		}
	}

	public void setRepository(BusesRepository repository) {
		this.repository = repository;
	}
	
	public Iterable<Tmio1Bus> findAll(){

		return repository.findAll();
	}

	public BusType[] getTypes() {
		return BusType.values();
	}
	
	public Optional<Tmio1Bus> findById(Integer id) {

		return repository.findById(id);
	}

}

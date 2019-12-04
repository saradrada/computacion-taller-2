package icesi.edu;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import icesi.edu.model.BusType;
import icesi.edu.model.Tmio1Bus;
import icesi.edu.model.Tmio1Conductore;
import icesi.edu.model.Tmio1Ruta;
import icesi.edu.model.UserApp;
import icesi.edu.model.UserType;
import icesi.edu.repositories.BusesRepository;
import icesi.edu.repositories.ConductoresRepository;
import icesi.edu.repositories.RutasRepository;
import icesi.edu.repositories.UserRepository;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository userRepository, BusesRepository busRepository, ConductoresRepository conductorRepository,
			RutasRepository rutaRepository) {
		return (args) -> {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	        
			UserApp user = new UserApp();			
			user.setUsername("admin");
			user.setPassword(passwordEncoder.encode("123"));
			user.setType(UserType.admin);
			userRepository.save(user);
			
			UserApp user2 = new UserApp();			
			user2.setUsername("operator");
			user2.setPassword(passwordEncoder.encode("123"));
			user2.setType(UserType.operator);
			userRepository.save(user2);
			
			Tmio1Bus bus = new Tmio1Bus();
			bus.setCapacidad(new BigDecimal(1));
			bus.setTipo(BusType.P);
			bus.setMarca("12");
			bus.setPlaca("AB12");
			bus.setModelo(new BigDecimal("3"));
			busRepository.save(bus);
			
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			Tmio1Conductore conductor = new Tmio1Conductore();
			conductor.setFechaContratacion(format.parse("2008-11-10"));
			conductor.setFechaNacimiento(format.parse("1990-10-22"));
			conductor.setCedula("123456789");
			conductor.setNombre("Sara");
			conductor.setApellidos("Ortiz");
			conductorRepository.save(conductor);
			
			conductor = new Tmio1Conductore();
			conductor.setFechaContratacion(format.parse("2002-2-1"));
			conductor.setFechaNacimiento(format.parse("1991-2-3"));
			conductor.setCedula("987654321");
			conductor.setNombre("Isabella");
			conductor.setApellidos("Ortiz");
			conductorRepository.save(conductor);
			
			Tmio1Ruta ruta = new Tmio1Ruta();
			ruta.setNumero("1");
			ruta.setActiva("Si");
			ruta.setDescripcion("calle 46 hasta calle 102");
			ruta.setDiaInicio(new BigDecimal(3));
			ruta.setDiaFin(new BigDecimal(5));
			ruta.setHoraInicio(new BigDecimal(2));
			ruta.setHoraFin(new BigDecimal(2000));
			rutaRepository.save(ruta);
		};
	}
}

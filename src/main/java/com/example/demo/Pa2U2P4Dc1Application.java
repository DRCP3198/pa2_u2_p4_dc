package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Ciudadano;
import com.example.demo.modelo.Empleado;
import com.example.demo.modelo.Habitacion;
import com.example.demo.modelo.Hotel;
import com.example.demo.service.ICiudadanoService;
import com.example.demo.service.IEmpleadoService;
import com.example.demo.service.IHabitacionService;
import com.example.demo.service.IHotelService;

@SpringBootApplication
public class Pa2U2P4Dc1Application implements CommandLineRunner {

	/*
	 * @Autowired private IEmpleadoService empleadoService;
	 * 
	 * @Autowired private ICiudadanoService ciudadanoService;
	 */

	@Autowired
	private IHotelService hotelService;
    @Autowired
    private IHabitacionService habitacionService;
    
    
	public static void main(String[] args) {
		SpringApplication.run(Pa2U2P4Dc1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		/*
		 * Ciudadano ciudadano = new Ciudadano(); ciudadano.setNombre("Carmen");
		 * ciudadano.setApellido("Jurado"); ciudadano.setCedula("1751452456");
		 * 
		 * Ciudadano ciudadano1 = new Ciudadano(); ciudadano1.setNombre("Anthony");
		 * ciudadano1.setApellido("Narvaez"); ciudadano1.setCedula("1751489898");
		 * 
		 * Empleado empleado = new Empleado(); empleado.setCiudadano(ciudadano1);
		 * empleado.setCargo("Gerente"); empleado.setSueldo(new BigDecimal(2000));
		 * //ciudadano.setEmpleado(empleado); this.ciudadanoService.agregar(ciudadano);
		 * this.ciudadanoService.encontrar(1); this.ciudadanoService.borrar(2);
		 * this.ciudadanoService.modificar(ciudadano);
		 * this.empleadoService.agregar(empleado);
		 * this.ciudadanoService.agregar(ciudadano);
		 */
		
		Hotel hotel = new Hotel();
		hotel.setNombre("Hilton Colon");
		hotel.setDireccion("Av colon y versalles");
		
		List<Habitacion> listaHabitacion= new ArrayList<>();
		Habitacion hab1 = new Habitacion();
		hab1.setNumero("HC2");
		hab1.setValor(new BigDecimal(90
				));
		hab1.setHotel(hotel);
		listaHabitacion.add(hab1);
		hotel.setHabitaciones(listaHabitacion);
		//this.hotelService.agregar(hotel);
		this.habitacionService.agregar(hab1);

	}

}

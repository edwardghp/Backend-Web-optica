package com.sistema.optica;

import com.sistema.optica.entidades.Employee;
import com.sistema.optica.entidades.Rol;
import com.sistema.optica.excepciones.UsuarioFoundException;
import com.sistema.optica.servicios.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SistemaOpticaBackendApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {

        SpringApplication.run(SistemaOpticaBackendApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*try {
			Employee employee = new Employee();
			employee.setNombres("Administrativo");
            //employee.setApellidos("Apellido1");
            employee.setUsername("aministrativo@gmail.com");
            employee.setPassword(bCryptPasswordEncoder.encode("12345"));
            employee.setTelefono("987654321");
            employee.setPerfil("foto.png");

			Rol rol = new Rol();
			rol.setNombre("Administrativo");

			Employee usuarioGuardado = employeeService.guardarEmpleado(employee,"Administrativo");
			System.out.println(usuarioGuardado.getUsername());
		} catch (UsuarioFoundException exception){
			exception.printStackTrace();
		}*/
    }
}

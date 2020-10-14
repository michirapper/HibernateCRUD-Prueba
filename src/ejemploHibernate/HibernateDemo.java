package ejemploHibernate;

import java.util.Scanner;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import modelo.Employee;
import utils.AccesoHibernate;

public class HibernateDemo {

	public static void main(String[] args) {

		AccesoHibernate accesoh;

		try {
			System.out.println("INICIO PRUEBAS BASKET HIBERNATE");

			accesoh = new AccesoHibernate();
			System.out.println("Que quieres hacer");
			Scanner sc = new Scanner(System.in);
			System.out.println("Sacar todos los empleados: 1");
			System.out.println("Buscar por nombre: 2");
			System.out.println("Buscar por id: 3");
			System.out.println("Borrar por id: 4");
			System.out.println("Modificar por id: 5");
			int num = sc.nextInt();
			if (num == 1) {
				accesoh.consultaEmpleado();
			}
			if (num == 2) {
				accesoh.consultaEmpleadoNombre();
			}
			if (num == 3) {
				accesoh.consultaEmpleadoId();
			}
			if (num == 4) {
				accesoh.borrarDatos();
			}
			if (num == 5) {
				accesoh.consultaEmpleadoModId();
			}

			System.out.println("FIN PRUEBAS");
		} catch (Exception ex) {
			System.out.println("EXCEPCION!!!!");
			ex.printStackTrace();
		} finally {
			System.out.println("REQUETEFIN");
			System.exit(0);
		}

//        Employee e= new Employee();
//        e.setEmpId(1);
//        e.setEmpName("Ana");
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session s=sf.openSession();
//        s.beginTransaction();
//        s.save(e);
//        s.getTransaction().commit();
//        s.close();

		System.exit(0);
	}

}
package utils;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.TypedQuery;
import org.hibernate.Query;
import org.hibernate.Session;
import modelo.Employee;

public class AccesoHibernate {
	Session session;

	public AccesoHibernate() {

		HibernateUtil util = new HibernateUtil();

		session = util.getSessionFactory().openSession();

	}

	public void consultaEmpleado() {
		System.out.println("Inicio Consulta");

		Query q = session.createQuery("select jp from Employee jp");
		List results = q.list();

		Iterator jugadoresIterator = results.iterator();

		while (jugadoresIterator.hasNext()) {
			Employee j = (Employee) jugadoresIterator.next();

			System.out.println("El nombre es: " + j.getEmpName() + ", con la descripcion: " + j.getEmpDescripcion());

		}

		System.out.println("Fin Consulta");
	}

	public void consultaEmpleadoNombre() {
		System.out.println("Inicio Consulta");
		Scanner sc = new Scanner(System.in);
		System.out.println("Busqueda por nombre, dinos cual es:");
		String nombre = sc.nextLine();

		// Query q= session.createQuery("from Employee jp WHERE jp.empName = "+ nombre);
		Query q = session.createQuery("FROM Employee jp WHERE jp.empName = '" + nombre + "'");
		List results = q.list();

		Iterator jugadoresIterator = results.iterator();

		while (jugadoresIterator.hasNext()) {
			Employee j = (Employee) jugadoresIterator.next();

			System.out.println("El nombre es: " + j.getEmpName() + ", con la descripcion: " + j.getEmpDescripcion());

		}

		System.out.println("Fin Consulta");
	}

	public void consultaEmpleadoId() {
		System.out.println("Inicio Consulta");
		Scanner sc = new Scanner(System.in);
		System.out.println("Busqueda por id, dinos cual es:");
		int id = sc.nextInt();
		Employee j = (Employee) session.get(Employee.class, id);

		System.out.println("El nombre es: " + j.getEmpName() + ", con la descripcion: " + j.getEmpDescripcion());

		System.out.println("Fin Consulta");
	}

	public void borrarDatos() {
		System.out.println("Inicio Borrado");
		Scanner sc = new Scanner(System.in);
		System.out.println("Borrado por id, dinos cual es:");
		int id = sc.nextInt();

		session.beginTransaction();

		Object persistentInstance = session.load(Employee.class, id);
		if (persistentInstance != null) {
			session.delete(persistentInstance);
		}
		session.getTransaction().commit();
		System.out.println("Fin Borrado");
	}

	public void consultaEmpleadoModId() {
		System.out.println("Inicio Consulta");
		Scanner sc = new Scanner(System.in);
		System.out.println("Modificar por id, dinos cual es:");

		int id = sc.nextInt();
		System.out.println("Nuevo nombre: ");
		String err = sc.nextLine();
		System.out.println("---");
		String nombre = sc.nextLine();
		System.out.println("---");
		System.out.println("Nueva descripcion: ");
		String desc = sc.nextLine();

		Employee j = (Employee) session.get(Employee.class, id);
		
		session.beginTransaction();
		j.setEmpId(j.getEmpId());
		if (desc.equals("")) {
			j.setEmpDescripcion(j.getEmpDescripcion());
		}else {
			j.setEmpDescripcion(desc);
		}	
		if (nombre.equals("")) {
			j.setEmpName(j.getEmpName());
		}else {
			j.setEmpName(nombre);
		}			
		
		session.saveOrUpdate(j);

		session.getTransaction().commit();

		System.out.println("Fin Consulta");
	}
}

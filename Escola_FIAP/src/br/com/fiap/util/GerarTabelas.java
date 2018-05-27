
package br.com.fiap.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class GerarTabelas {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("jpaPU");
		factory.close();
	}
}
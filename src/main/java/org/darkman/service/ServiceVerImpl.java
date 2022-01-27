package org.darkman.service;

import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ServiceVerImpl<T, ID> implements org.darkman.service.ServiceVer<T, ID> {

	@Autowired
	private ApplicationContext context;

	public ServiceVerImpl() {

	}

	CrudRepository<T, ID> dao;

	static {

	}

	@Override
	public <S extends T> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends T> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<T> findById(ID id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean existsById(ID id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<T> findAll() {
		// TODO Auto-generated method stub

		try {
		//	log.info("findalll tamamnio" + context.getBeansOfType(Class.forName("org.darkman.dao.PersonaDAO")).size());
			Map<String, ?> mapa = context.getBeansOfType(Class.forName("org.darkman.dao.PersonaDAO"));
			Iterator<String> it = mapa.keySet().iterator();
			while (it.hasNext()) {
				String clave = it.next();
				Object valor = mapa.get(clave);
				log.info("Clave " + clave);
				log.info("Valor " + valor.getClass().toString());
				log.info("Es Persona DAO " + ((Boolean) (valor instanceof org.darkman.dao.PersonaDAO)).toString());
			}
		} catch (BeansException | ClassNotFoundException e) { 
			e.printStackTrace();
		}

		log.info(((Type) getClass().getGenericSuperclass()).toString());

		dao = (CrudRepository<T, ID>) context.getBean("personaDAO");
		log.info("Service Impl DAO");
		return dao.findAll();
		// return null;
	}

	@Override
	public Iterable<T> findAllById(Iterable<ID> ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void deleteById(ID id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAllById(Iterable<? extends ID> ids) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll(Iterable<? extends T> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

}

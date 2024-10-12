package com.alvimlops.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.alvimlops.erp.model.RomaAtividade;

public class RamoAtividades implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private EntityManager manager;
	
	public RamoAtividades() {
		
	}
	
	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<RomaAtividade> pesquisar(String descricao){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<RomaAtividade> criteriaQuery = criteriaBuilder.createQuery(RomaAtividade.class);
		
		Root<RomaAtividade> root = criteriaQuery.from(RomaAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.get("descricao"), descricao + "%"));
		
		TypedQuery<RomaAtividade> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}

}

package com.alvimlops.erp.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.alvimlops.erp.model.Empresa;
import com.alvimlops.erp.model.RomaAtividade;
import com.alvimlops.erp.model.TipoEmpresa;

public class CamadaPersistence {
	
	public static void main(String[] arg) {
		
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("AlvimCode");

	     EntityManager em = emf.createEntityManager();
	     
	     em.getTransaction().begin();
	     
	     //Declarando os repositorys
	     RamoAtividades ramoAtividades = new RamoAtividades(em);
	     Empresas empresas = new Empresas(em);
	     
	     //Buscando as informações do banco
	     List<RomaAtividade> listaDeRamoAtividade = ramoAtividades.pesquisar("");
	     List<Empresa> listaEmpresa = empresas.pesquisar("");
	     
	     //Criando uma empresa
	     Empresa empresa = new Empresa();
	     empresa.setNomeFantasia("João da silva");
	     empresa.setCpnj("41.952.519/0001-57");
	     empresa.setRazaoSocial("Joao da silva 49191215454564154");
	     empresa.setTipoEmresa(TipoEmpresa.MEI);
	     empresa.setDataFundacao(new Date());
	     empresa.setRamoAtividade(listaDeRamoAtividade.get(0));
	     
	     //salvando a empresa
	     empresas.guardar(empresa);
	     
	     em.getTransaction().commit();
	     
	     //Verificando se a inserção funcionou
	     List<Empresa> listaDeEmpresa2 = empresas.pesquisar("");
	     System.out.println(listaDeEmpresa2);
	     
	     em.close();
	     emf.close();
		
	}
	
	

}

package com.azhar.khalid.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.azhar.khalid.domain.Buku;
import com.azhar.khalid.domain.Kategori;

@Repository
public class BukuDao extends BaseDaoHibernate<Buku> {
	
	@SuppressWarnings("unchecked")
	public List<Buku> getByKategori(Kategori kategori) {
		String hql = "FROM Buku b WHERE b.kategori = :kategori";
		return sessionFactory.getCurrentSession().createQuery(hql)
				.setParameter("kategori", kategori)
				.list();
	}
}

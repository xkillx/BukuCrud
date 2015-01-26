package com.azhar.khalid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azhar.khalid.dao.KategoriDao;
import com.azhar.khalid.domain.Kategori;

@Service
@Transactional
public class KategoriServiceImpl implements KategoriService {
	
	@Autowired
	private KategoriDao kategoriDao;

	public Kategori save(Kategori kategori) {
		return kategoriDao.save(kategori);
	}

	public Kategori delete(Kategori kategori) {
		return kategoriDao.delete(kategori);
	}

	public Kategori getById(Long id) {
		return kategoriDao.getById(id);
	}

	public List<Kategori> getAll() {
		return kategoriDao.getAll();
	}

	public List<Kategori> getAll(int start, int num) {
		return kategoriDao.getAll(start, num);
	}

}

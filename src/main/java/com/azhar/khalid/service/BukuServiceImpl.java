package com.azhar.khalid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.azhar.khalid.dao.BukuDao;
import com.azhar.khalid.domain.Buku;
import com.azhar.khalid.domain.Kategori;

@Service
@Transactional
public class BukuServiceImpl implements BukuService {

	@Autowired
	private BukuDao bukuDao;
	
	public Buku save(Buku buku) {
		return bukuDao.save(buku);
	}

	public Buku delete(Buku buku) {
		return bukuDao.delete(buku);
	}

	public Buku getById(Long id) {
		return bukuDao.getById(id);
	}

	public List<Buku> getAll() {
		return bukuDao.getAll();
	}

	public List<Buku> getAll(int start, int num) {
		return bukuDao.getAll(start, num);
	}

	public List<Buku> getByKategori(Kategori kategori) {
		return bukuDao.getByKategori(kategori);
	}

}

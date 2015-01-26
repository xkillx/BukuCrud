package com.azhar.khalid.service;

import java.util.List;

import com.azhar.khalid.domain.Buku;
import com.azhar.khalid.domain.Kategori;

public interface BukuService {
	Buku save(Buku buku);
	Buku delete(Buku buku);
	Buku getById(Long id);
	List<Buku> getAll();
	List<Buku> getAll(int start, int num);
	List<Buku> getByKategori(Kategori kategori);
}

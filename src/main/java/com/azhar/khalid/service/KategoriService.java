package com.azhar.khalid.service;

import java.util.List;

import com.azhar.khalid.domain.Kategori;

public interface KategoriService {
	Kategori save(Kategori kategori);
	Kategori delete(Kategori kategori);
	Kategori getById(Long id);
	List<Kategori> getAll();
	List<Kategori> getAll(int start, int num);
}

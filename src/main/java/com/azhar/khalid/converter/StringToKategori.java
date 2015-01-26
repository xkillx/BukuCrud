package com.azhar.khalid.converter;

import org.springframework.core.convert.converter.Converter;

import com.azhar.khalid.domain.Kategori;

public class StringToKategori implements Converter<String, Kategori> {

	public Kategori convert(String id) {
		Kategori kategori = new Kategori();
		Long x = Long.parseLong(id);
		kategori.setId(x);
		
		return kategori;
	}

}

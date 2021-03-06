package com.azhar.khalid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.azhar.khalid.domain.Kategori;
import com.azhar.khalid.exception.NotFoundException;
import com.azhar.khalid.service.KategoriService;

@Controller
@RequestMapping(value = "/kategori")
public class KategoriController {

	@Autowired
	private KategoriService kategoriService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String kategori(Model model) {
		model.addAttribute("kategoriList", kategoriService.getAll());
		return "kategori/index";
	}

	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	public String tambahKategori(Model model) {
		model.addAttribute("kategori", new Kategori());
		return "kategori/tambah";
	}

	@RequestMapping(value = "/tambah", method = RequestMethod.POST)
	public String prosesTambahKategori(
			@ModelAttribute("kategori") Kategori kategori) {
		kategoriService.save(kategori);
		return "redirect:/kategori/list";
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id)
			throws NotFoundException {
		Kategori kategori = kategoriService.getById(id);

		if (kategori == null) {
			throw new NotFoundException();
		}

		model.addAttribute("kategori", kategori);
		
		return "kategori/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String prosesEdit(@ModelAttribute("kategori") Kategori kategori) {
		kategoriService.save(kategori);
		return "redirect:/kategori/list";
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long id) {
		Kategori kategori = kategoriService.getById(id);

		if (kategori == null) {
			throw new NotFoundException();
		}

		kategoriService.delete(kategori);
		return "redirect:/kategori/list";
	}
}

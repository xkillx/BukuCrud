package com.azhar.khalid.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.azhar.khalid.domain.Buku;
import com.azhar.khalid.exception.NotFoundException;
import com.azhar.khalid.service.BukuService;
import com.azhar.khalid.service.KategoriService;

@Controller
@RequestMapping(value = "/buku")
public class BukuController {

	@Autowired
	private BukuService bukuService;
	
	@Autowired
	private KategoriService kategoriService;

	/*
	 * @ModelAttribute public Buku testingAja() { Buku buku = new Buku();
	 * buku.setJudul("Judul Buku"); buku.setPengarang("Nama Pengarang");
	 * 
	 * System.out.println("Testing Aja : " + buku);
	 * 
	 * return buku; }
	 */

	@RequestMapping(value = "/list")
	public String index(Model model) {
		model.addAttribute("bukuList", bukuService.getAll());
		return "buku/index";
	}

	@RequestMapping(value = "/tambah", method = RequestMethod.GET)
	public String tambah(Model model) {
		model.addAttribute("buku", new Buku());
		model.addAttribute("kategoriList", kategoriService.getAll());
		return "buku/tambah";
	}

	@RequestMapping(value = "/tambah", method = RequestMethod.POST)
	public String prosesTambah(@ModelAttribute("buku") Buku buku) {
		bukuService.save(buku);
		return "redirect:/buku/list";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(Model model, @RequestParam("id") Long id)
			throws NotFoundException {
		Buku buku = bukuService.getById(id);

		if (buku == null) {
			throw new NotFoundException();
		}

		model.addAttribute("buku", buku);
		return "buku/edit";
	}

	@RequestMapping(value = "/edit", method = RequestMethod.POST)
	public String prosesEdit(@ModelAttribute("buku") Buku buku) {
		bukuService.save(buku);
		return "redirect:/buku/list";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String delete(@RequestParam("id") Long id) {
		Buku buku = bukuService.getById(id);

		if (buku == null) {
			throw new NotFoundException();
		}

		bukuService.delete(buku);
		return "redirect:/buku/list";
	}
}

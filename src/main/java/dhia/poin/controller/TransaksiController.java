package dhia.poin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import dhia.poin.model.NasabahModel;
import dhia.poin.service.NasabahService;
import dhia.poin.service.TransaksiService;

@Controller
public class TransaksiController {
	
	@Autowired
	private TransaksiService transaksiService;
	
	@Autowired 
	private NasabahService nasabahService;
	
	@GetMapping(value = "/transaksi")
	public String viewPage(Model model) throws Exception{
		List<NasabahModel> list = nasabahService.listAll();
		model.addAttribute("listNasabah", list);
		return "nasabah";
	}
	
	@GetMapping(value="/transaksi/create")
	public String showNasabahForm(Model model) throws Exception{
		model.addAttribute("nasabah", new NasabahModel());
		return "nasabahform";
	}
	
	@PostMapping(value="/transaksi/save")
	public String saveNasabah(NasabahModel inputModel) throws Exception{
		
		try {
			nasabahService.create(inputModel);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:/nasabah";
	}
	

}

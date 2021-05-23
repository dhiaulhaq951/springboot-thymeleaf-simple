package dhia.poin.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dhia.poin.model.NasabahModel;
import dhia.poin.service.NasabahService;

@Controller
public class NasabahController {
	
	@Autowired
	private NasabahService nasabahService;
	
	@GetMapping(value = "/nasabah")
	public String viewPage(Model model) throws Exception{
		List<NasabahModel> list = nasabahService.listAll();
		model.addAttribute("listNasabah", list);
		return "nasabah";
	}
	
	@GetMapping(value="/nasabah/create")
	public String showNasabahForm(Model model) throws Exception{
		model.addAttribute("nasabah", new NasabahModel());
		return "nasabahform";
	}
	
	@PostMapping(value="/nasabah/save")
	public String saveNasabah(NasabahModel inputModel) throws Exception{
		
		try {
			nasabahService.create(inputModel);
		} catch (Exception e) {
			throw e;
		}
		return "redirect:/nasabah";
	}

}

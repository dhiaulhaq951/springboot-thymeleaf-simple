package dhia.poin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhia.poin.entity.Nasabah;
import dhia.poin.model.NasabahModel;
import dhia.poin.repository.NasabahRepository;

@Service
public class NasabahService {
	
	@Autowired
	private NasabahRepository nasabahRepo;
	
	public List<NasabahModel> listAll() throws Exception{
		List<NasabahModel> list = new ArrayList<>();
		List<Nasabah> entities = nasabahRepo.findAll();
		
		if(entities != null && !entities.isEmpty()) {
			for(Nasabah nasabah : entities) {
				NasabahModel model = new NasabahModel();
				model.setAccountId(nasabah.getAccountId());
				model.setAccountName(nasabah.getAccountName());
				
				list.add(model);
			}
		}
		
		return list;
	}
	
	public void create(NasabahModel input) throws Exception{
		if(input == null) {
			throw new Exception("Input is empty");
		}
		Nasabah n = new Nasabah();
		n.setAccountName(input.getAccountName());
		
		try {
			nasabahRepo.save(n);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public NasabahModel getSingle(Integer id) throws Exception{
		if(id == null) {
			throw new Exception("Id could not be null");
		}
		
		Optional<Nasabah> entity = nasabahRepo.findById(id);
		if(entity.isPresent()) {
			Nasabah n = entity.get();
			NasabahModel model = new NasabahModel();
			model.setAccountId(n.getAccountId());
			model.setAccountName(n.getAccountName());
			return model;
		}
		else {
			throw new Exception("There's no data nasabah with account id: " + id);
		}
	}
	
	public void delete(Integer accountId) throws Exception{
		try {
			nasabahRepo.deleteById(accountId);
		} catch(Exception e) {
			throw e;
		}
	}

}

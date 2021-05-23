package dhia.poin.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dhia.poin.entity.Nasabah;
import dhia.poin.entity.Transaksi;
import dhia.poin.model.NasabahModel;
import dhia.poin.model.TransaksiModel;
import dhia.poin.repository.NasabahRepository;
import dhia.poin.repository.TransaksiRepository;

@Service
public class TransaksiService {
	
	@Autowired
	private NasabahRepository nasabahRepo;
	
	@Autowired
	private TransaksiRepository transaksiRepo;
	
	public List<TransaksiModel> listAll() throws Exception{
		List<TransaksiModel> list = new ArrayList<>();
		List<Transaksi> entities = transaksiRepo.findAll();
		
		if(entities != null && !entities.isEmpty()) {
			for(Transaksi trx : entities) {
				TransaksiModel model = new TransaksiModel();
				model.setAccountId(constructNasabah(trx.getAccountId()));
				model.setAmount(trx.getAmount());
				model.setDebitCreditStatus(trx.getDebitCreditStatus());
				model.setDescription(trx.getDescription());
				model.setTransactionDate(trx.getTransactionDate());
				model.setTransaksiId(trx.getTransaksiId());
				list.add(model);
			}
		}
		
		return list;
	}
	
	public void create(TransaksiModel input) throws Exception{
		if(input == null) {
			throw new Exception("Input is empty");
		}
		Transaksi n = new Transaksi();
		
		Optional<Nasabah> nasabah = nasabahRepo.findById(input.getAccountId().getAccountId());
		if(nasabah.isPresent()) {
			n.setAccountId(nasabah.get());
		}
		else {
			throw new Exception("Nasabah Id tidak ditemukan");
		}
		
		n.setAmount(input.getAmount());
		n.setDebitCreditStatus(input.getDebitCreditStatus());
		n.setDescription(input.getDescription());
		n.setTransactionDate(input.getTransactionDate());
		
		try {
			transaksiRepo.save(n);
		} catch(Exception e) {
			throw e;
		}
	}
	
	public TransaksiModel getSingle(Integer id) throws Exception{
		if(id == null) {
			throw new Exception("Id could not be null");
		}
		
		Optional<Transaksi> entity = transaksiRepo.findById(id);
		if(entity.isPresent()) {
			Transaksi n = entity.get();
			TransaksiModel model = new TransaksiModel();
			model.setAccountId(constructNasabah(n.getAccountId()));
//			model.set
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
	
	private NasabahModel constructNasabah(Nasabah input) {
		NasabahModel model = new NasabahModel();
		model.setAccountId(input.getAccountId());
		model.setAccountName(input.getAccountName());
		return model;
	}

}

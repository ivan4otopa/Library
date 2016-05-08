package bg.jwd.library.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bg.jwd.library.dao.LendDao;
import bg.jwd.library.entities.Lend;

@Service
public class LendServiceImpl implements LendService {
	@Autowired
	private LendDao lendDao;
	
	@Override
	public List<Lend> getLends() {
		return lendDao.getLends();
	}

	@Override
	public boolean addLend(Lend lend) {
		return lendDao.addLend(lend);
	}

	@Override
	public boolean editLend(Lend lend) {
		return lendDao.editLend(lend);
	}
	
	@Override
	public boolean deleteLend(long id) {
		return lendDao.deleteLend(id);
	}

	@Override
	public List<Lend> searchLends(String criteria, String value) {
		return lendDao.searchLends(criteria, value);
	}

	@Override
	public boolean addReturnDate(long id, String returnDate) {
		return lendDao.addReturnDate(id, returnDate);
	}	
}

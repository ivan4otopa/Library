package bg.jwd.library.services;

import java.util.List;

import bg.jwd.library.entities.Lend;

public interface LendService {
	List<Lend> getLends();
	
	boolean addLend(Lend lend);
	
	boolean editLend(Lend lend);
	
	boolean deleteLend(long id);
	
	List<Lend> searchLends(String criteria, String value);
	
	boolean addReturnDate(long id, String returnDate);
}

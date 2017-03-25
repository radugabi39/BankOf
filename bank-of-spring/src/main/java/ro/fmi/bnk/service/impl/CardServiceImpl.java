package ro.fmi.bnk.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.fmi.bnk.dao.repo.CardDAO;
import ro.fmi.bnk.models.CardsModel;
import ro.fmi.bnk.service.CardService;
import ro.fmi.bnk.service.TransactionService;

@Service("cardService")
public class CardServiceImpl implements CardService {

	@Autowired
	private CardDAO cardDAO;
	@Override
	public List<CardsModel> getCards(String userName) {
		return cardDAO.getCards(userName);
	}

}
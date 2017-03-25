package ro.fmi.bnk.service;

import java.util.List;

import ro.fmi.bnk.models.CardsModel;

public interface CardService {

	public List<CardsModel> getCards(String userName);
}

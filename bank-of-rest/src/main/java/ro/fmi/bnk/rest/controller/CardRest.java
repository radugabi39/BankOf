package ro.fmi.bnk.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ro.fmi.bnk.models.CardsModel;
import ro.fmi.bnk.rest.utils.GenericListResponse;
import ro.fmi.bnk.rest.utils.GenericResponse;
import ro.fmi.bnk.service.CardService;

@RestController
@RequestMapping("/card")
public class CardRest {
	
	@Autowired
	private CardService cardService;

	@RequestMapping(value = "/getCards", method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public GenericListResponse<CardsModel> getCards() {
		GenericListResponse<CardsModel> toReturn = new GenericListResponse<CardsModel>();
		String userName= SecurityContextHolder.getContext().getAuthentication().getName();
		List<CardsModel> obj=cardService.getCards(userName);
		
		toReturn.setData(obj);
		return toReturn;
		
	}
}
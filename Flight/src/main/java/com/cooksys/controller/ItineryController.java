package com.cooksys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cooksys.entity.Itinery;
import com.cooksys.pojo.ItineryReq;
import com.cooksys.repository.ItineryRepository;
import com.cooksys.service.ItineryService;

@RestController
@RequestMapping("itinery")
public class ItineryController {
	@Autowired
	ItineryService itineryService;
	@Autowired
	ItineryRepository itineryRepo;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public List<Itinery> getAll() {
		return itineryRepo.findAll();
	}

	@RequestMapping(value ="/book", method = RequestMethod.POST)
	public Itinery postItinery(@RequestBody ItineryReq itineryReq) {
		return itineryService.getItineryDetails(itineryReq);
	}
}

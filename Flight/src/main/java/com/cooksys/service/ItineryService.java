package com.cooksys.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooksys.entity.Itinery;
import com.cooksys.pojo.ItineryReq;
import com.cooksys.repository.ItineryRepository;

@Service
public class ItineryService {
@Autowired
ItineryRepository itinerRepo;
	
	public Itinery getItineryDetails(ItineryReq itineryReq) {
		Itinery itinery=new Itinery();
		itinery.setDestination(itineryReq.getDestination());
		itinery.setSource(itineryReq.getOrigin());
		itinery.setFlightTime(itineryReq.getFlightTime());
		itinery.setOffset(itineryReq.getOffset());
		System.out.println("offset***************" + itinery.getOffset());
		if(itinery!=null){
			itinerRepo.save(itinery);
		}
	    return  itinery; 
	}

}

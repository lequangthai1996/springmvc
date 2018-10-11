package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserResponse;
import com.example.demo.entity.Team;

@RestController
@RequestMapping("/api")
@Transactional
public class DemoController {
	  private SessionFactory sessionFactory;
		
	  @Autowired
	  public DemoController(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.sessionFactory = factory.unwrap(SessionFactory.class);
	  }	
	
	@GetMapping("/listUser")
	public List<UserResponse> getListUserResponse() {
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("select p.id, p.name, ad.city, dep.id as department_id, dep.name as department_name"
				+ " from person as p"
				+ " left join address as ad on p.id = ad.person_id"
				+ " left join department as dep on p.department_id = dep.id");
		List<Object[]> rows = query.getResultList();
		List<UserResponse> list = new ArrayList<>();
		for (Object[] objects : rows) {
			UserResponse userResponse = new UserResponse();
			userResponse.setId(objects[0].toString());
			userResponse.setName(objects[1].toString());
			if(objects[2] != null) {
				userResponse.setCity(objects[2].toString());
			}else {
				userResponse.setCity(null);
			}
			userResponse.setTeam(new Team(objects[3].toString(), objects[4].toString()));
			list.add(userResponse);
		}
		return list;
	}
}

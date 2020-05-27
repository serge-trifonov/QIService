package cnam.project.QIService.entities;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SearchMethod {
	
	@Autowired
	private EntityManager entityManager;
	
	
			private String city;
			private String country;
			private String level;
			private String faculty;
			private String program;
			private String university;
			
			
			
	
	public List<Program>programFound (SearchParam searchParam) {
		
			
			
			CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();		
			CriteriaQuery<Program> criteriaQuery = criteriaBuilder.createQuery(Program.class);
			
			Root<Program> itemRoot = criteriaQuery.from(Program.class);
			
			Join<Program, Faculty> facultyJoin = itemRoot.join("faculty");
			Join<Faculty, University> universityJoin = facultyJoin.join("university");
			Join<University, Address> address = universityJoin.join("address");
			
			Predicate predicate=criteriaBuilder.isTrue(criteriaBuilder.literal(true));
					
			if(!searchParam.getCity().equals(null)&&!searchParam.getCity().equals("")) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(criteriaBuilder.lower(address.get("city")),searchParam.getCity().toLowerCase()));	
			}
			if(!searchParam.getCountry().equals(null)&&!searchParam.getCountry().equals("")) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(criteriaBuilder.lower(address.get("country")),searchParam.getCountry().toLowerCase()));	
			}
			
			if(!searchParam.getLevel().equals(Level.BAC)) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(itemRoot.get("level"),searchParam.getLevel()));	
			}
			if(!searchParam.getFaculty().equals(null)&&!searchParam.getFaculty().equals("")) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(facultyJoin.get("name"),searchParam.getFaculty()));	
			}
			
			if(!searchParam.getProgram().equals(null)&&!searchParam.getProgram().equals("")) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.like(itemRoot.get("name"),"%"+searchParam.getProgram()+"%"));	
			}
			
			if(!searchParam.getUniversity().equals(null)&&!searchParam.getUniversity().equals("")) {
				predicate = criteriaBuilder.and(predicate,criteriaBuilder.equal(universityJoin.get("name"),searchParam.getUniversity()));	
			}
			
			
			
				
			
			
			
			criteriaQuery.where(predicate);
			
			return entityManager.createQuery(criteriaQuery).getResultList();
			
			
	    	
	    }
}

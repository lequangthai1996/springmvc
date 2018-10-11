package com.example.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.PagingItem;
import com.example.domain.SaleTeam;
import com.example.domain.Staff;
import com.example.dto.DSalePerformanceRepsonse;
import com.example.dto.DSalePerformanceRequest;
import com.example.model.Team;
import com.example.util.DSaleQueryUtil;
import com.example.util.StringUtils;



@Repository
@Transactional
public class DSaleQueryRepositoryImpl {
	  private SessionFactory sessionFactory;
		
	  @Autowired
	  public DSaleQueryRepositoryImpl(EntityManagerFactory factory) {
	    if(factory.unwrap(SessionFactory.class) == null){
	      throw new NullPointerException("factory is not a hibernate factory");
	    }
	    this.sessionFactory = factory.unwrap(SessionFactory.class);
	  }	
	
	  public List<DSalePerformanceRepsonse> getListDSalePerformance() {
		List<DSalePerformanceRepsonse> list = new ArrayList<>();
		list.add(new DSalePerformanceRepsonse("1", "le quang", "DSale001", new SaleTeam(1l, "Java"),
				"7", "5", "20000"));
		return list;
	 }	  
	  
	  
	  
	 public List<DSalePerformanceRepsonse> getListDSalePerformance(DSalePerformanceRequest dsaleRequest,
			 PagingItem pagingItem, Staff staff){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		 String[] columns = {
				 "staff.id",
				 "staff.code",
				 "full_name",
				 "department.id as team_id",
				 "department.name",
				 "application_form",
				 "total_app_approved",
				 "amount_disbursed"
		 };
		 String[] tables = {
				 "staff as staff",
				 "left join department_staff as ds on staff.id = ds.staff_id and (ds.is_deleted is null or ds.is_deleted = 0 )",
				 "left join department on ds.department_id = department.id and (department.is_deleted is null or department.is_deleted = 0)",
				 "left join application_form as af on staff.id = af.created_by and (af.is_deleted is null or af.is_deleted = 0) " + 
						 						   "and str_to_date(af.created_date, '%Y-%m-%d') between str_to_date(':fromDate','%Y-%m-%d') and str_to_date(':toDate', '%Y-%m-%d')"
		 };
		 String[] defaultConditions = {
				 "(staff.is_deleted is null or staff.is_deleted = 0)",
				 "ds.responsible_type = 10"
		 };
		 String[] groupBys = {
				 "staff.id",
				 "staff.code",
				 StringUtils.buildFullNameSQL("staff.last_name", "staff.mid_name", "staff.first_name"),
				 "department.name",
				 "department.id"
		 };
		 String filterCondition = DSaleQueryUtil.createFilterDsalePerformance(dsaleRequest);
		 String orderBy = DSaleQueryUtil.createOrderByDsalePerformance(pagingItem);
		 String sql = StringUtils.buildSelectQuery(columns,tables, defaultConditions) + 
				 		filterCondition +
				 		StringUtils.buildGroupsByQuery(groupBys) + 
				 		orderBy;
		 sql = DSaleQueryUtil.buildFunctionDSaleQueryPerformance(sql);
		 sql = DSaleQueryUtil.addParamsForDSalePerformance(sql, dsaleRequest);
		 String countSql = "select * from ( " + sql + ")"; 
		 System.out.println("SQL :" + sql);
		 Query query = session.createNativeQuery(sql);
		
		 Query countQuery = session.createNativeQuery(countSql);
		 Map<String, Object> params = DSaleQueryUtil.makeParamDSalePerformance(dsaleRequest);
		 params.forEach((key,value) ->{
			 query.setParameter(key, value);
		 });
			
		List<Object[]> result = query.getResultList();
		Long totalRows = (Long) countQuery.getSingleResult();
		List<DSalePerformanceRepsonse> listDSale = new ArrayList<>();
		DSalePerformanceRepsonse dSalePerformanceRepsonse = null;
		for (Object[] objects : result) {
			String id = objects[0].toString();
			String empCode = objects[1].toString();
			String dsaleName = objects[2].toString();
			SaleTeam team = new SaleTeam(Long.valueOf(objects[3].toString()), objects[4].toString());
			String applicationForm = objects[5].toString();
			String totalAppApproved = objects[6].toString();
			String amountDisbursed = objects[7].toString();
			dSalePerformanceRepsonse = new DSalePerformanceRepsonse(id, dsaleName, empCode, team,
					applicationForm, totalAppApproved, amountDisbursed);
			listDSale.add(dSalePerformanceRepsonse);
			
		} 
		pagingItem.setOurRowsNumber(totalRows);
		return listDSale;
	 }
	 
	 
	 public List<DSalePerformanceRepsonse> getListDSalePerformanceHQL(DSalePerformanceRequest dsaleRequest,
			 PagingItem pagingItem, Staff staff){
		Session session = sessionFactory.getCurrentSession();
		Transaction transaction = session.beginTransaction();
		 String[] columns = {
				 "staff.id",
				 "staff.code",
				 "full_name",
				 "department.id as team_id",
				 "department.name",
				 "application_form",
				 "total_app_approved",
				 "amount_disbursed"
		 };
		 String[] tables = {
				 "StaffEntity staff",
				 "left join DepartmentStaffEntity ds on staff.id = ds.staffId and (ds.isDeleted is null or ds.isDeleted = 0 )",
				 "left join DepartmentEntity department on ds.departmentId = department.id and (department.isDeleted is null or department.isDeleted = 0)",
				 "left join ApplicationFormEntity af on staff.id = af.createdBy and (af.isDeleted is null or af.isDeleted = 0) " + 
						 						   "and str_to_date(af.createdDated, '%Y-%m-%d') between str_to_date(':fromDate','%Y-%m-%d') and str_to_date(':toDate', '%Y-%m-%d')"
		 };
		 String[] defaultConditions = {
				 "(staff.isDeleted is null or staff.isDeleted = 0)",
				 "ds.responsibleType = 10"
		 };
		 String[] groupBys = {
				 "staff.id",
				 "staff.code",
				 StringUtils.buildFullNameSQL("staff.lastName", "staff.midName", "staff.firstName"),
				 "department.name",
				 "department.id"
		 };
		 String filterCondition = DSaleQueryUtil.createFilterDsalePerformance(dsaleRequest);
		 String orderBy = DSaleQueryUtil.createOrderByDsalePerformanceHQL(pagingItem);
		 String sql = StringUtils.buildSelectQuery(columns,tables, defaultConditions) + 
				 		filterCondition +
				 		StringUtils.buildGroupsByQuery(groupBys) + 
				 		orderBy;
		 sql = DSaleQueryUtil.buildFunctionDSaleQueryPerformanceHQL(sql);
		 sql = DSaleQueryUtil.addParamsForDSalePerformance(sql, dsaleRequest);
		 String countSql = "select * from ( " + sql + ")"; 
		 System.out.println("SQL :" + sql);
		 Query query = session.createQuery(sql);
		
		 //Query countQuery = session.createNativeQuery(countSql);
		 Map<String, Object> params = DSaleQueryUtil.makeParamDSalePerformance(dsaleRequest);
		 params.forEach((key,value) ->{
			 query.setParameter(key, value);
		 });
			
		List<Object[]> result = query.getResultList();
		//Long totalRows = (Long) countQuery.getSingleResult();
		List<DSalePerformanceRepsonse> listDSale = new ArrayList<>();
		DSalePerformanceRepsonse dSalePerformanceRepsonse = null;
		for (Object[] objects : result) {
			String id = objects[0].toString();
			String empCode = objects[1].toString();
			String dsaleName = objects[2].toString();
			SaleTeam team = new SaleTeam(Long.valueOf(objects[3].toString()), objects[4].toString());
			String applicationForm = objects[5].toString();
			String totalAppApproved = objects[6].toString();
			String amountDisbursed = objects[7].toString();
			dSalePerformanceRepsonse = new DSalePerformanceRepsonse(id, dsaleName, empCode, team,
					applicationForm, totalAppApproved, amountDisbursed);
			listDSale.add(dSalePerformanceRepsonse);
			
		} 
		//pagingItem.setOurRowsNumber(totalRows);
		return listDSale;
	 }
	 
}
















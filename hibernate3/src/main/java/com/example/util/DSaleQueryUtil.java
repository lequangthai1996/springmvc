package com.example.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.event.EventRecodingLogger;

import com.example.constant.ApplicationFormStatus;
import com.example.domain.PagingItem;
import com.example.dto.DSalePerformanceRequest;

public class DSaleQueryUtil {

	public static String createFilterDsalePerformance(DSalePerformanceRequest dsaleRequest) {
		// TODO Auto-generated method stub
		StringBuilder eCondition = new StringBuilder();
		List<String> ids = dsaleRequest.getIds();
		List<String> idsNotNull = new ArrayList<>();
		Long staff_id;
		for (String id : ids) {
			staff_id = StringUtils.convertStringToLongOrNull(id);
			if(null != staff_id) {
				idsNotNull.add(staff_id.toString());
			}
		}
		
		if(idsNotNull.size() > 0) {
			eCondition.append(" AND staff.id in(").append(String.join(", ", idsNotNull)).append(")");
		}
		
		if(dsaleRequest.getDsaleName() != null && !dsaleRequest.getDsaleName().isEmpty()) {
			eCondition.append(" AND " + StringUtils.buildFullNameSQL("","","") + " LIKE :fullName");
		}
		
		if(dsaleRequest.getTeamName() != null && !dsaleRequest.getTeamName().isEmpty()) {
			eCondition.append(" AND "+  "department.name " + " LIKE :teamName");
		}
		
		if(dsaleRequest.getEmpCode() != null && !dsaleRequest.getEmpCode().isEmpty()) {
			eCondition.append(" AND "+ "staff.code" + " LIKE :empCode");
		}		
		
		return eCondition.toString();
	}

	public static String createOrderByDsalePerformance(PagingItem pagingItem) {
		// TODO Auto-generated method stub
    	StringBuilder orderBy = new StringBuilder("");
        if (pagingItem.getOrderBy() == null || pagingItem.getOrderBy().isEmpty()) {
            pagingItem.setOrderBy("staff.id");
        }
        if (pagingItem.getOrderBy() != null && !pagingItem.getOrderBy().isEmpty()) {
            if (pagingItem.getDirectionSort() == null || pagingItem.getDirectionSort().isEmpty()) {
                pagingItem.setDirectionSort("DESC");
            }
            String direction = pagingItem.getDirectionSort();
            orderBy.append(" ORDER BY ");
            if (pagingItem.getOrderBy().equals("staff_id")) {
                orderBy.append("staff.id "+direction);
            } else if (pagingItem.getOrderBy().equals("dsale_name")) {
                orderBy.append(StringUtils.buildFullNameSQL("staff.last_name", "staff.mid_name", "staff.first_name") + " " + direction);
            } else if (pagingItem.getOrderBy().equals("emp_code")) {
                orderBy.append("staff.code " +  direction);
            } else if (pagingItem.getOrderBy().equals("team_name")) {
                orderBy.append("department.name " + direction);
            } else if (pagingItem.getOrderBy().equals("application_form")) {
                orderBy.append("application_form " + direction);
            } else if (pagingItem.getOrderBy().equals("total_app_approved")) {
                orderBy.append("total_app_approved " + direction);
            } else if (pagingItem.getOrderBy().equals("amount_disbursed")) {
                orderBy.append("amount_disbursed " + direction);
            } else {
                return "";
            }
        }
        return orderBy.toString();
	}

	public static String createOrderByDsalePerformanceHQL(PagingItem pagingItem) {
		// TODO Auto-generated method stub
    	StringBuilder orderBy = new StringBuilder("");
        if (pagingItem.getOrderBy() == null || pagingItem.getOrderBy().isEmpty()) {
            pagingItem.setOrderBy("staff.id");
        }
        if (pagingItem.getOrderBy() != null && !pagingItem.getOrderBy().isEmpty()) {
            if (pagingItem.getDirectionSort() == null || pagingItem.getDirectionSort().isEmpty()) {
                pagingItem.setDirectionSort("DESC");
            }
            String direction = pagingItem.getDirectionSort();
            orderBy.append(" ORDER BY ");
            if (pagingItem.getOrderBy().equals("staff_id")) {
                orderBy.append("staff.id "+direction);
            } else if (pagingItem.getOrderBy().equals("dsale_name")) {
                orderBy.append(StringUtils.buildFullNameSQL("staff.lastName", "staff.midName", "staff.firstName") + " " + direction);
            } else if (pagingItem.getOrderBy().equals("emp_code")) {
                orderBy.append("staff.code " +  direction);
            } else if (pagingItem.getOrderBy().equals("team_name")) {
                orderBy.append("department.name " + direction);
            } else if (pagingItem.getOrderBy().equals("application_form")) {
                orderBy.append("application_form " + direction);
            } else if (pagingItem.getOrderBy().equals("total_app_approved")) {
                orderBy.append("total_app_approved " + direction);
            } else if (pagingItem.getOrderBy().equals("amount_disbursed")) {
                orderBy.append("amount_disbursed " + direction);
            } else {
                return "";
            }
        }
        return orderBy.toString();
	}
	public static Map<String, Object> makeParamDSalePerformance(DSalePerformanceRequest dsaleRequest) {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<>();
		if(dsaleRequest.getDsaleName() != null && !dsaleRequest.getDsaleName().isEmpty()) {
			params.put("fullName", "%" + dsaleRequest.getDsaleName() + "%");
		}
		if(dsaleRequest.getTeamName() != null && !dsaleRequest.getTeamName().isEmpty()) {
			params.put("teamName", "%"+ dsaleRequest.getTeamName() + "%");
		}
		if(dsaleRequest.getEmpCode() != null && !dsaleRequest.getEmpCode().isEmpty()) {
			params.put("empCode", dsaleRequest.getEmpCode()+ "%");
		}
		return params;
	}

	public static String buildFunctionDSaleQueryPerformance(String sql) {
		// TODO Auto-generated method stub
		StringBuilder buildQuery = new StringBuilder(sql);
		if(buildQuery.indexOf("full_name") != -1) {
			buildQuery.insert(buildQuery.indexOf("full_name") -1,
					          StringUtils.buildFullNameSQL("staff.last_name", "staff.mid_name", "staff.first_name") +  " as");
		}
		if(buildQuery.indexOf("application_form") != -1) {
			buildQuery.insert(buildQuery.indexOf("application_form") - 1,
					"count(case when af.app_form_status in(:status_new, :status_approved , :status_passed, :status_in_progress, :status_disbursed) then 'x' else null end )" + " as ");
		}
		if(buildQuery.indexOf("total_app_approved") != -1) {
			buildQuery.insert(buildQuery.indexOf("total_app_approved"), "count(case when af.app_form_status in(:status_approved, :status_disbursed) then 'x' else null end)" + " as ");
		}
		if(buildQuery.indexOf("amount_disbursed") != -1) {
			buildQuery.insert(buildQuery.indexOf("amount_disbursed") - 1, "sum(case when af.amount_approved is not null then af.amount_approved else 0 end)" + " as ");
		}
		return buildQuery.toString();
	}

	
	public static String buildFunctionDSaleQueryPerformanceHQL(String sql) {
		// TODO Auto-generated method stub
		StringBuilder buildQuery = new StringBuilder(sql);
		if(buildQuery.indexOf("full_name") != -1) {
			buildQuery.insert(buildQuery.indexOf("full_name") -1,
					          StringUtils.buildFullNameSQLHQL("staff.lastName", "staff.midName", "staff.firstName") +  " as");
		}
		if(buildQuery.indexOf("application_form") != -1) {
			buildQuery.insert(buildQuery.indexOf("application_form") - 1,
					"count(case when af.appFormStatus in(:status_new, :status_approved , :status_passed, :status_in_progress, :status_disbursed) then 'x' else null end )" + " as ");
		}
		if(buildQuery.indexOf("total_app_approved") != -1) {
			buildQuery.insert(buildQuery.indexOf("total_app_approved"), "count(case when af.appFormStatus in(:status_approved, :status_disbursed) then 'x' else null end)" + " as ");
		}
		if(buildQuery.indexOf("amount_disbursed") != -1) {
			buildQuery.insert(buildQuery.indexOf("amount_disbursed") - 1, "sum(case when af.amountApproved is not null then af.amountApproved else 0 end)" + " as ");
		}
		return buildQuery.toString();
	}	
	
	
	public static void main(String[] args) {
		System.out.println(buildFunctionDSaleQueryPerformance("select  full_name, application_form, total_app_approved, amount_disbursed"));
	}

	public static String addParamsForDSalePerformance(String sql, DSalePerformanceRequest dsaleRequest) {
		// TODO Auto-generated method stub
		sql = sql.replaceAll(":status_new", ApplicationFormStatus.NEW.getValue() + "");
		sql = sql.replaceAll(":status_passed", ApplicationFormStatus.PASSED.getValue() + "");
		sql = sql.replaceAll(":status_approved", ApplicationFormStatus.APPROVED .getValue()+ "");
		sql = sql.replaceAll(":status_disbursed", ApplicationFormStatus.DISBURSED.getValue() + "");
		sql = sql.replaceAll(":status_in_progress", ApplicationFormStatus.DISBURSED.getValue() + "");
		sql = sql.replaceAll(":fromDate", dsaleRequest.getFromDate());
		sql = sql.replaceAll(":toDate", dsaleRequest.getToDate());
		return sql;
	}

}

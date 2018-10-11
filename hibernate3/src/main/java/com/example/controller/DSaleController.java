package com.example.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.domain.CustomError;
import com.example.domain.PagingItem;
import com.example.domain.QueryParam;
import com.example.domain.ResponseData;
import com.example.domain.ResultSearch;
import com.example.domain.SaleTeam;
import com.example.domain.Staff;
import com.example.dto.DSalePerformanceRepsonse;
import com.example.dto.DSalePerformanceRequest;
import com.example.repository.DSaleQueryRepositoryImpl;


@RequestMapping("/dsale")
@Controller
public class DSaleController {
	
	@Autowired
	private DSaleQueryRepositoryImpl dsalequeryRepository;
	
	@RequestMapping(value = "/performance", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseData getListDSalePM(@RequestBody QueryParam<DSalePerformanceRequest> param) {
        ResponseData res = new ResponseData();
        DSalePerformanceRepsonse objDsale;
        SaleTeam team = new SaleTeam(2l, "Java");
        List<DSalePerformanceRepsonse> listDsale = new ArrayList<>();
        try {
        	DSalePerformanceRequest query = param.getQuery();
        	//if(query == null) throw new Exception();
        	System.out.println(query);
        	PagingItem pagingItem = param.getPagingItem();
        	System.out.println(pagingItem);
	        listDsale = dsalequeryRepository.getListDSalePerformanceHQL(query,pagingItem, new Staff());
	        ResultSearch<DSalePerformanceRepsonse> result = new ResultSearch<>(listDsale, pagingItem.getOurRowsNumber());
	        res.setData(result.getData());
	        res.setSuccess(true);
	        res.setTotalRows(result.getTotalRows());
        } catch(Exception ex) {            
        	CustomError error = new CustomError("", "C001", ex.getMessage());
        	CustomError[] errors = {error};
        	res.setError(errors);
        	res.setSuccess(false);
        }        	
        return res;
    } 
	
}

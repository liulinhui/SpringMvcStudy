package com.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.bean.Asset;
import com.study.dao.AssetMapper;

@Service
public class AssetService {
	@Autowired
	AssetMapper assetMapper;
	
	public List<Asset> selectAll(String user_code){
		List<Asset>assets=assetMapper.selectAll(user_code);
		return assets;
	}

}

package com.study.dao;

import java.util.List;
import org.springframework.stereotype.Component;
import com.study.bean.Asset;

@Component
public interface AssetMapper {
	List<Asset>selectAll(String user_code);
	List<Asset>selectAvaliable(String user_code);

}

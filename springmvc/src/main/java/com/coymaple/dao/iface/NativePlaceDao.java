package com.coymaple.dao.iface;

import java.util.List;

import com.coymaple.domain.NativePlace;

public interface NativePlaceDao {
	
	public List<NativePlace> getProvinces();
	public List<NativePlace> getCities(String code);
	public List<NativePlace> getCities();
}

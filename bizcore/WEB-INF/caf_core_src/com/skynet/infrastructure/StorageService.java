package com.skynet.infrastructure;

import java.util.Map;

public interface StorageService {
	public Map<String,Object> genToken(Object context);
}

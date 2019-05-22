package com.terapico.utils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RequestUtil {
    public static Object getByName(Map<String, Object> requestParameters, String fieldName) {
        if (requestParameters == null) {
            return null;
        }
        Object value = requestParameters.get(fieldName);
        if (value == null) {
            return null;
        }
        if (value.getClass().isArray()) {
            String[] vals = (String[]) value;
            if (vals.length < 1) {
                return null;
            }
        }
        return value;
    }

    public static Object getSingleByName(Map<String, Object> requestParameters, String fieldName) {
        Object obj = getByName(requestParameters, fieldName);
        if (obj == null) {
            return obj;
        }
        if (obj.getClass().isArray()) {
            Object[] vals = (Object[]) obj;
            if (vals.length < 1) {
                return null;
            }
            return vals[0];
        }
        if (obj instanceof List) {
            if (((List) obj).size() < 1) {
                return null;
            }
            return ((List) obj).get(0);
        }
        return obj;
    }

    public static String getStringInput(Map<String, Object> requestParameters, String fieldName, String defaultValue) {
        Object value = getSingleByName(requestParameters, fieldName);
        if (value == null) {
            return defaultValue;
        }
        return String.valueOf(value);
    }

    public static Date getDateInput(Map<String, Object> requestParameters, String fieldName, Date defaultValue) {
        Object value = getSingleByName(requestParameters, fieldName);
        if (value == null) {
            return defaultValue;
        }
        if (value instanceof Number) {
        	return new Date(((Number) value).longValue());
        }
        if (value instanceof String && ((String)value).matches("\\d{0,14}")) {
        	try {
        		long tsMs = Long.parseLong((String) value);
        		return new Date(tsMs);
        	}catch (Exception e) {
        		// 不行就算了
        	}
        }
        Date date = DateTimeUtil.parseInputDateTime(String.valueOf(value));
        if (date == null) {
            return defaultValue;
        }
        return date;
    }

    public static BigDecimal getBigDecimalInput(Map<String, Object> requestParameters, String fieldName,
            Number defaultValue) {
        Object value = getSingleByName(requestParameters, fieldName);
        if (value == null || TextUtil.isBlank(String.valueOf(value))) {
            if (defaultValue == null) {
                return null;
            }
            return new BigDecimal(defaultValue.toString());
        }
        try {
            return new BigDecimal(TextUtil.onlyNumber(String.valueOf(value)));
        } catch (Exception e) {
            if (defaultValue == null) {
                return null;
            }
            return new BigDecimal(defaultValue.toString());
        }
    }

    public static boolean getBooleanInput(Map<String, Object> requestParameters, String fieldName,
            boolean defaultValue) {
        Object value = getSingleByName(requestParameters, fieldName);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Boolean.parseBoolean(String.valueOf(value));
        } catch (Exception e) {
            return defaultValue;
        }
    }

	public static Double getDoubleInput(Map<String, Object> requestParameters, String fieldName, Double defaultValue) {
		Object value = getSingleByName(requestParameters, fieldName);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Double.parseDouble(String.valueOf(value));
        } catch (Exception e) {
            return defaultValue;
        }
	}

	public static Integer getIntegerInput(Map<String, Object> requestParameters, String fieldName, Integer defaultValue) {
		Object value = getSingleByName(requestParameters, fieldName);
        if (value == null) {
            return defaultValue;
        }
        try {
            return Integer.parseInt(String.valueOf(value));
        } catch (Exception e) {
            // return defaultValue;
        }
        try {
            return (int) Double.parseDouble(String.valueOf(value));
        } catch (Exception e) {
            return defaultValue;
        }
	}

	public static String pickImageByIndex(String[] images, int idx) {
		if(images == null || idx >= images.length) {
			return null;
		}
		return images[idx];
	}

	public static String[] getImagesInput(Map<String, Object> params, String keyName, Object defaultValue) {
		Object obj = getByName(params, keyName);
		if (obj == null) {
			return null;
		}
		if (obj instanceof List) {
			return ((List<String>) obj).toArray(new String[] {});
		}
		if (obj.getClass().isArray()) {
			return (String[]) obj;
		}
		return new String[] {String.valueOf(obj)};
	}
}

package ar.com.fdvs.dj.core;

import net.sf.jasperreports.engine.fill.JRFillParameter;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

public class ParameterMapWrapper implements Map {
	
	private Map map;
    private String reportName;

    public ParameterMapWrapper(Map map){
		this.map = map;
	}

	public ParameterMapWrapper() {
		this.map = Collections.EMPTY_MAP;
	}

	public void clear() {
		map.clear();
	}

    public boolean containsKey(Object key) {
        boolean contains = map.containsKey(key);
        if (!contains)
            return map.containsKey(reportName + "_" + key);
        return contains;
    }

	public boolean containsValue(Object value) {
		throw new DJException("Method not implemented");
	}

	public Set entrySet() {
		return map.entrySet();
	}

	public boolean equals(Object o) {
		return map.equals(o);
	}

    public Object get(Object key) {
        Object value = map.get(key);
        if (value == null){
            value = map.get(reportName + "_" + key);
        }
        if (value == null){
            return null;
        }

        return ((JRFillParameter)value).getValue();
    }

	public int hashCode() {
		return map.hashCode();
	}

	public boolean isEmpty() {
		return map.isEmpty();
	}

	public Set keySet() {
		return map.keySet();
	}

	public Object put(Object arg0, Object arg1) {
		return map.put(arg0, arg1);
	}

	public void putAll(Map arg0) {
		map.putAll(arg0);
	}

	public Object remove(Object key) {
		return map.remove(key);
	}

	public int size() {
		return map.size();
	}

	public Collection values() {
		throw new DJException("Method not implemented");
	}

	public void setMap(Map parsm) {
		this.map = parsm;
		
	}


    public void setReportName(String reportName) {
        this.reportName = reportName;
    }
}

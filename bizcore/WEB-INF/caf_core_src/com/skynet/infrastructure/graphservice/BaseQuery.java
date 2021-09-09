package com.skynet.infrastructure.graphservice;

import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import java.beans.PropertyDescriptor;
import java.util.HashMap;
import java.util.Map;

public class BaseQuery extends QueryImpl {

    public String getProject() {
        return project;
    }

    public void setProject(String pProject) {
        project = pProject;
    }

    private String project;

    private Class lastType;

    private String lastRelation;

    private Map<String, Class> classesMapping = new HashMap<>();
    private static Map<String, String> relationCache = new HashMap<>();

    public BaseQuery(Class startType, String ... pStart) {
        super(startType.getSimpleName(), pStart);
        lastType = startType;
    }

    public BaseQuery want(Class... pClasses){
        for (Class clazz : pClasses){
            classesMapping.put(clazz.getSimpleName(), clazz);
        }
        super.want(pClasses);
        return this;
    }


    public BaseQuery want(String relation, Class type){
        classesMapping.put(relation, type);
        super.want(relation);
        return this;
    }


    public BaseQuery returnType(Class t){
        classesMapping.put(t.getSimpleName(), t);
        super.returnType(t);
        return this;
    }

    public Class findClass(String name){
        return classesMapping.get(name);
    }

    /**
     * used to build the relations
     * @param types
     * @return
     */
    public BaseQuery relation(Class... types){
        for (Class c : types){
            if (lastType == null){
                lastType = c;
                continue;
            }
            String r = calculateRelation(lastType, c);
            addRelation(r);
            lastType = c;
        }
        return this;
    }


    public BaseQuery relation(String relation, Class type){
        addRelation(relation);
        lastType = type;
        return this;
    }


    public BaseQuery relation(String... relation){
        if (relation == null){
            return this;
        }

        lastType = null;

        for (String r: relation){
            addRelation(r);
        }

        return this;
    }

    //add path
    public BaseQuery path(String... relations){
        if (relations == null){
            return this;
        }

        for (String r: relations){
            relation(r);
            if (lastRelation == null){
                getPaths().add(r, null);
                lastRelation = r;
                continue;
            }
            getPaths().add(r, lastRelation);
        }
        return this;
    }


    public BaseQuery path(String next, Class pLastType){
        if (lastRelation == null){
            lastRelation = next;
            getPaths().add(next, null);
        }else{
            path(next);
        }

        lastType = pLastType;
        return this;
    }


    public BaseQuery path(Class... next){
        if(next == null){
            return this;
        }

        for (Class c : next){
            if (lastType == null){
                lastType = c;
                continue;
            }

            String relation = calculateRelation(lastType, c);
            path(relation, c);
        }

        return this;
    }


    public BaseQuery addPath(String pre, String current){
        relation(pre,current);
        getPaths().add(current, pre);
        lastRelation = current;
        return this;
    }


    private String calculateRelation(Class c1, Class c2){
        String key = c1 + ":" + c2;

        if (relationCache.containsKey(key)){
            String relation = relationCache.get(key);

            if (StringUtils.hasText(relation)){

                return relation;
            }
            throw new RuntimeException("cannot use relation for " + c2 + " on " + c1 + ", they don't have relation");
        }

        //try
        String property = null;
        PropertyDescriptor[] c1Properties = BeanUtils.getPropertyDescriptors(c1);
        for (PropertyDescriptor p : c1Properties){
            Class<?> propertyType = p.getPropertyType();

            if (propertyType.equals(c2)){

                if(property == null) {
                    property = p.getName();
                }else {
                    throw new RuntimeException("cannot use path for " + c2 + " on " + c1 + ", they have more than 1 relation" +
                            ", please use relation(String, Class) not relation(Class...)");
                }
            }
        }

        if (property != null){
            String value = c1.getSimpleName() + "$" + property;
            relationCache.put(key, value);
            return value;
        }

        PropertyDescriptor[] c2Properties = BeanUtils.getPropertyDescriptors(c2);
        for (PropertyDescriptor p : c2Properties){
            Class<?> propertyType = p.getPropertyType();

            if (propertyType.equals(c1)){
                if (property == null){
                  property =  p.getName();
                }else{
                    throw new RuntimeException("cannot use path for " + c2 + " on " + c1 + ", they have more than 1 relation" +
                            ", please use relation(String, Class) not relation(Class...)");
                }
            }
        }

        if (property != null){
            String value = c2.getSimpleName() + "$" + property;
            relationCache.put(key, value);
            return value;
        }

        relationCache.put(key, "");
        throw new RuntimeException("cannot use relation for " + c2 + " on " + c1 + ", they don't have relation");
    }



    public BaseQuery limit(int pSize){
         super.limit(0, pSize);
         return this;
    }

    public BaseQuery limit(int pStartNo, int pSize) {
        super.limit(pStartNo, pSize);
        return this;
    }

    public BaseQuery parameter(String key, Object value){
        super.parameter(key, value);
        return this;
    }

    public BaseQuery filter(String pFilter){
        super.filter(pFilter);
        return this;
    }

    public BaseQuery sort(String pSort){
        super.sort(pSort);
        return this;
    }
}

package com.skynet.infrastructure;

import com.terapico.caf.DateTime;
import com.terapico.utils.DateTimeUtil;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.GenericConverter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class ConversionService extends DefaultConversionService {

    @Override
    protected GenericConverter getDefaultConverter(TypeDescriptor sourceType, TypeDescriptor targetType) {
        GenericConverter defaultConverter = super.getDefaultConverter(sourceType, targetType);
        if (defaultConverter != null){
            return defaultConverter;
        }

        return new GenericConverter() {
            @Override
            public Set<ConvertiblePair> getConvertibleTypes() {
                Set<ConvertiblePair> s = new HashSet<>();
                s.add(new ConvertiblePair(sourceType.getType(), targetType.getType()));
                return s;
            }

            @Override
            public Object convert(Object source, TypeDescriptor sourceType, TypeDescriptor targetType) {
                String sourceS = String.valueOf(source);

                //date time
                if (targetType.getType().equals(DateTime.class)) {
                    return DateTime.fromDate(DateTimeUtil.parseInputDateTime(sourceS));
                }

                //try best for object ids
                try {
                    Class<?> type = targetType.getType();
                    Object o = type.newInstance();

                    Method id = type.getMethod("setId", String.class);
                    id.invoke(o, sourceS);
                    return o;
                } catch (Exception e) {
                    e.printStackTrace();
                }

                throw new RuntimeException("TargetType " + targetType.getType() + " is not supported yet in the conversion service");
            }
        };
    }
}

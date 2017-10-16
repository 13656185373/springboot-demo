package com.wz.config;

import com.wz.annotation.EnableCustomService;
import com.wz.service.CoreCustomServiceImpl;
import com.wz.service.SimpleCustomServiceImpl;
import com.wz.utils.Constants;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>根据EnableCustomService注解里的policy加载不同的bean</p>
 *
 * @author wangzi
 */
public class CustomImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        AnnotationAttributes attributes = AnnotationAttributes.fromMap(annotationMetadata.getAnnotationAttributes(
                EnableCustomService.class.getName()));
        String policy = attributes.getString("value");
        if (Constants.POLICY_CORE.equals(policy)){
            return new String[]{CoreCustomServiceImpl.class.getName()};
        }
        return new String[]{SimpleCustomServiceImpl.class.getName()};
    }
}

package com.ecomm.security.utils;

import java.io.IOException;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.lang.Nullable;

public class YamlPropertySourceFactory implements PropertySourceFactory {

    
    /**
     * The createPropertySource function is used to create a PropertySource object from the given resource.
     * The name of the property source will be set to the filename of the resource, and its properties will be
     * loaded from that file. If no properties are found in that file, then null is returned instead.
     
     *
     * @param @Nullable String name Specify the name of the property source
     * @param EncodedResource encodedResource Get the resource
     *
     * @return A propertysource object
     *
     */
    @Override
    public PropertySource<?> createPropertySource(@Nullable String name, EncodedResource encodedResource)
            throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(encodedResource.getResource());

        Properties properties = factory.getObject();

        String filename = encodedResource.getResource().getFilename();
        if (properties != null && filename != null) {
            return new PropertiesPropertySource(filename, properties);
        }
        return null;
    }
}
package com.ambuj.service;

import com.ambuj.domain.GsLookUpDetails;
import com.ambuj.util.ResourceLoadUtil;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class SpaceDiscoveryService {
    public static final String ENVCONFIG_DIR = "envconfig/";

    @Autowired
    private ResourceLoadUtil resourceLoadUtil;

    public List<GsLookUpDetails> gsLookUpDetails() {
        Resource[] confFiles = new Resource[0];
        try {
            confFiles = resourceLoadUtil.loadResources("classpath*:" + ENVCONFIG_DIR + "*.conf");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        List<GsLookUpDetails> lookUpDetailsList = new ArrayList<>();
        for (Resource resource : confFiles) {
            String fileName = resource.getFilename();
            String baseName = fileName.substring(0, fileName.indexOf("."));
            Config config = ConfigFactory.load(ENVCONFIG_DIR + baseName);
            lookUpDetailsList.add(new GsLookUpDetails.GsLookUpDetailsBuilder().withConfig(config).build());
        }
        return lookUpDetailsList;
    }
}

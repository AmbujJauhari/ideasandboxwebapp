package com.ambuj.domain;

import com.typesafe.config.Config;

/**
 * Created by Aj on 24-05-2016.
 */
public class GsLookUpDetails {
    private String envName;
    private String locators;
    private String groups;
    private String userName;
    private String password;

    public String getEnvName() {
        return envName;
    }

    public String getLocators() {
        return locators;
    }

    public String getGroups() {
        return groups;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public static final class GsLookUpDetailsBuilder {
        private Config config;

        public GsLookUpDetailsBuilder withConfig(Config config) {
            this.config = config;
            return this;
        }

        public GsLookUpDetails build() {
            GsLookUpDetails gsLookUpDetails = new GsLookUpDetails();
            gsLookUpDetails.envName = config.getString(ConfigurationProperties.ENV_NAME);
            gsLookUpDetails.locators = config.getString(ConfigurationProperties.ENV_LOCATOR);
            gsLookUpDetails.groups = config.getString(ConfigurationProperties.ENV_GROUP);
            gsLookUpDetails.userName = config.getString(ConfigurationProperties.ENV_USER_NAME);
            gsLookUpDetails.password = config.getString(ConfigurationProperties.ENV_USER_PASSWORD);

            return gsLookUpDetails;
        }
    }

    @Override
    public String toString() {
        return "GsLookUpDetails{" +
                "envName='" + envName + '\'' +
                ", locators='" + locators + '\'' +
                ", groups='" + groups + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
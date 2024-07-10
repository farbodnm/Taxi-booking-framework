package com.taxi.framework.sms.dto;

import java.util.List;

/**
 * Data Transfer Object (DTO) for SMS request.
 * This class encapsulates the details required for sending an SMS message.
 */
public class SmsRequestDTO {

    /**
     * The mobile number to which the SMS will be sent.
     */
    private String mobile;

    /**
     * The template ID used for the SMS message.
     */
    private String templateId;

    /**
     * A list of parameters to be used in the SMS template.
     */
    private List<Parameter> parameters;

    /**
     * Inner class representing a parameter for the SMS template.
     */
    public static class Parameter {

        /**
         * The name of the parameter.
         */
        private String name;

        /**
         * The value of the parameter.
         */
        private String value;

        /**
         * Constructs a new Parameter with the specified name and value.
         *
         * @param name  the name of the parameter
         * @param value the value of the parameter
         */
        public Parameter(String name, String value) {
            this.name = name;
            this.value = value;
        }

        /**
         * Gets the name of the parameter.
         *
         * @return the name of the parameter
         */
        public String getName() {
            return name;
        }

        /**
         * Sets the name of the parameter.
         *
         * @param name the new name of the parameter
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * Gets the value of the parameter.
         *
         * @return the value of the parameter
         */
        public String getValue() {
            return value;
        }

        /**
         * Sets the value of the parameter.
         *
         * @param value the new value of the parameter
         */
        public void setValue(String value) {
            this.value = value;
        }
    }

    /**
     * Gets the mobile number to which the SMS will be sent.
     *
     * @return the mobile number
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile number to which the SMS will be sent.
     *
     * @param mobile the new mobile number
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Gets the template ID used for the SMS message.
     *
     * @return the template ID
     */
    public String getTemplateId() {
        return templateId;
    }

    /**
     * Sets the template ID used for the SMS message.
     *
     * @param templateId the new template ID
     */
    public void setTemplateId(String templateId) {
        this.templateId = templateId;
    }

    /**
     * Gets the list of parameters to be used in the SMS template.
     *
     * @return the list of parameters
     */
    public List<Parameter> getParameters() {
        return parameters;
    }

    /**
     * Sets the list of parameters to be used in the SMS template.
     *
     * @param parameters the new list of parameters
     */
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
}

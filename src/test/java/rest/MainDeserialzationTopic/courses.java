package rest.MainDeserialzationTopic;

import java.util.List;

public class courses {


    public List<rest.MainDeserialzationTopic.webAutomation> getWebAutomation() {
        return webAutomation;
    }

    public void setWebAutomation(List<rest.MainDeserialzationTopic.webAutomation> webAutomation) {
        this.webAutomation = webAutomation;
    }

    private List<webAutomation> webAutomation;

    public List<rest.MainDeserialzationTopic.api> getApi() {
        return api;
    }

    public void setApi(List<rest.MainDeserialzationTopic.api> api) {
        this.api = api;
    }

    private List<api> api;

    public List<rest.MainDeserialzationTopic.mobile> getMobile() {
        return mobile;
    }

    public void setMobile(List<rest.MainDeserialzationTopic.mobile> mobile) {
        this.mobile = mobile;
    }

    private List<mobile>mobile;
}

package net.ericsson.emovs.utilities.models;

/**
 * Created by Joao Coelho on 15/07/2017.
 */

public class EmpCustomer {
    //private String customerId;
    //private String businessUnitId;
    //private String name;
    //private String slogan;
    private String serviceName;
    private String logoUrl;
    private String carouselGroupId;

    public EmpCustomer() {

    }

    public EmpCustomer withLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
        return this;
    }

    public String getLogoUrl() {
        return this.logoUrl;
    }

    public EmpCustomer withServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public String getServiceName() {
        return this.serviceName;
    }


    public String getCarouselGroupId() {
        return this.carouselGroupId;
    }

    public EmpCustomer withCarouselGroupId(String carouselGroupId) {
        this.carouselGroupId = carouselGroupId;
        return this;
    }

}

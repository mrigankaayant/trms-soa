package com.ayantsoft.trms.finance.info;

public class URLInfo {
	
    public static final String ROOTURL = "/account";
	
    public static final String LAZY_PAYMENT_LIST = "/lazy/payment/list";
    public static final String LAZY_CANDIDATE_LIST = "/lazy/candidate/list";
    public static final String COURSE_LIST = "/course/list";
    public static final String VISA_LIST = "/immigration/list";
    public static final String RECRUITMENT_SOURCE_LIST = "/recruitmentsource/list";
    public static final String CANDIDATE_STATUS_LIST = "/candidatestatus/list";
    public static final String CANDIDATE_FIND_BY_PROPERTY = "/candidate/find/{propertyName}/{propertyValue:.+}";
    public static final String PAYMENT_DETAILS_FIND_BY_ID = "/paymentdetails/find/{paymentDetailsId}";
    public static final String UPLOAD_PAYPAL_DOCUMENT = "/upload/paypal/{candidateId}/{candidateName}/{paymentId}";
    public static final String CANDIDATE_FIND_BY_ID = "/candidate/find/{id}";
	
}

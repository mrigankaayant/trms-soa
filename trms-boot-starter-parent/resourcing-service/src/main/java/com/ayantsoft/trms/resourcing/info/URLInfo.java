package com.ayantsoft.trms.resourcing.info;

public class URLInfo {
	
	public static final String ROOTURL = "/resourcing";
	
	public static final String CREATE_CANDIDATE = "/candidate/create";
	public static final String VISA_LIST = "/immigration/list";
	public static final String COURSE_LIST = "/course/list";
	public static final String PREFERRED_LOCATION_LIST = "/preferredLocation/list";
	public static final String RECRUITMENT_SOURCE_LIST = "/recruitmentsource/list";
	public static final String PAY_TYPE_LIST = "/paytype/list";
	public static final String CHECK_EMAIL = "/checkEmail/{email:.+}/{id}";
	public static final String CHECK_PHONE = "/checkMobile/{mobile}/{id}";
	public static final String UPLOAD_RESUME = "/upload/resume/{candidateId}/{candidateName}";
	public static final String DOWNLOAD_RESUME = "/download/resume/{fileName}";
	public static final String CANDIDATE_LAZY_LIST = "/candidate/lazy/list";
	public static final String CANDIDATE_STATUS_LIST = "/candidatestatus/list";
	public static final String CANDIDATE_FIND_BY_ID = "/candidate/find/{id}";
	public static final String UPDATE_CANDIDATE = "/candidate/update";
	public static final String UPDATE_RESUME = "/update/resume/{candidateId}/{candidateName}";
	public static final String FOLLOWUP_LIST = "/followup/list/{candidateId}";
	public static final String PHONE_LOGS_LIST_BY_EMPLOYEE_ID = "/phonelogs/list";
	public static final String PHONE_LOGS_LIST_BY_CANDIDATE_ID = "/phonelogs/list/{candidateId}";
	public static final String CREATE_FOLLOWUP = "/followup/create";
	public static final String FREEPOOL_CANDIDATE_LIST = "/freepool/candidate/list";
	public static final String FREEPOOL_CANDIDATE_TRANSFER = "/freepool/candidate/transfer/{candidateId}";
	public static final String SEARCH_CANDIDATE = "/candidate/search";
	public static final String INCENTIVE_LIST = "/incentive/list/{incentiveFor}";
	public static final String ORGANIZATION_LIST = "/organization";
	public static final String ALL_CANDIDATE_LAZY_LIST = "/all/candidate/lazy/list";
	public static final String CANDIDATE_FIND_BY_PROPERTY = "/candidate/accountverify/{propertyName}/{propertyValue:.+}";
}

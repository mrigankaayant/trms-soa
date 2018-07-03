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
	public static final String CANDIDATE_LIST = "/candidate/list";

}

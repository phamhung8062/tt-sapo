package springboot.constant;

public class SystemConstant {
	
	public static final int ACTIVE_STATUS = 1;
	public static final int INACTIVE_STATUS = 0;
	
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 360000000;
	public static final String SIGNING_KEY = "springboot";
	public static final String TOKEN_PREFIX = "Bearer ";
	public static final String HEADER_STRING = "Authorization";
	public static final String AUTHORITIES_KEY = "scopes";

}

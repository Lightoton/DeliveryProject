package de.telran.deliveryproject.security.security_util;

public class RoleAuthList {

    public static final String CLIENT = "CLIENT";
    public static final String ADMIN = "ADMIN";

    public static final String[] CLIENT_LIST = {
            "/swagger-ui/",
            "/swagger-ui/**",
            "/courier/**",
            "/client/**",
            "/department/**",
            "/food_category/**",
            "/food/**",
            "/manager/**",
            "/menu/**",
            "/order/**",
            "/restaurant/**",
            "/support_manager/**",
            "/user_info/**"
    };
    public static final String[] ADMIN_LIST = {
            "/swagger-ui/",
            "/swagger-ui/**",
            "/courier/**",
            "/client/**",
            "/department/**",
            "/food_category/**",
            "/food/**",
            "/manager/**",
            "/menu/**",
            "/order/**",
            "/restaurant/**",
            "/support_manager/**",
            "/user_info/**"
    };
}

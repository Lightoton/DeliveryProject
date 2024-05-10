package de.telran.deliveryproject.configuration;

//import de.telran.deliveryproject.security.AuthTokenFilter;
import com.nimbusds.jose.jwk.JWK;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jose.jwk.source.ImmutableJWKSet;
import de.telran.deliveryproject.security.UserDetailsServiceImpl;
import de.telran.deliveryproject.security.security_util.RoleAuthList;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtEncoder;
import org.springframework.security.oauth2.server.resource.web.access.BearerTokenAccessDeniedHandler;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.oauth2.server.resource.web.BearerTokenAuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

import static de.telran.deliveryproject.security.security_util.RoleAuthList.CLIENT_LIST;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    private final RsaKeyProperties jwtConfigProperties;

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    public SecurityConfig(RsaKeyProperties jwtConfigProperties, UserDetailsServiceImpl userDetailsServiceImpl) {
        this.jwtConfigProperties = jwtConfigProperties;
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }
//
//    private final AuthTokenFilter authTokenFilter;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getAuthProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsServiceImpl);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        HttpSecurity httpSecurity = http
                .cors(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth ->
                        auth
                                .requestMatchers(CLIENT_LIST).hasRole(RoleAuthList.CLIENT))
                .sessionManagement(sessionManagement ->
                        sessionManagement
                                .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
                .exceptionHandling(
                        (ex) -> ex.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
                                //Обработка исключений для управления точками входа аутентификации и обработчиками доступа.
                                .accessDeniedHandler(new BearerTokenAccessDeniedHandler()))
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

//        http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
        return httpSecurity.build();
    }

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http
//                ////CSRF: Настройка CSRF (Cross-Site Request Forgery) защиты.
//                // В REST API обычно CSRF защита отключается, поскольку аутентификация основана на токенах.
//                .csrf(AbstractHttpConfigurer::disable)
//                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                //OAuth2 Resource Server: конфигурация для работы с OAuth 2.0, где токены JWT используются для аутентификации и авторизации.
//                .oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt)
//                .exceptionHandling(
//                        (ex) -> ex.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint())
//                                //Обработка исключений для управления точками входа аутентификации и обработчиками доступа.
//                                .accessDeniedHandler(new BearerTokenAccessDeniedHandler()))
//                .build();
//    }

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Bean
    public SecurityFilterChain tokenSecurityFilterChain(HttpSecurity http) throws Exception {
        return http
                //ограничивает эту конфигурацию только запросами на конкретный путь, что упрощает защиту специфических функций.
                .securityMatcher(new AntPathRequestMatcher("/token"))
                //убеждается, что только аутентифицированные пользователи могут выполнять операции с токенами.
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())

                //Конфигурация создания сессий (SessionCreationPolicy.STATELESS указывает, что сервер не будет создавать или использовать сессию).
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                //CSRF: Настройка CSRF (Cross-Site Request Forgery) защиты.
                // В REST API обычно CSRF защита отключается, поскольку аутентификация основана на токенах.
                .csrf(AbstractHttpConfigurer::disable)
                .exceptionHandling(ex -> {
                    ex.authenticationEntryPoint(new BearerTokenAuthenticationEntryPoint());
                    ex.accessDeniedHandler(new BearerTokenAccessDeniedHandler());
                })
                .httpBasic(withDefaults())
                .build();
    }

    @Bean
    public JwtDecoder jwtDecoder() {
        return NimbusJwtDecoder.withPublicKey(jwtConfigProperties.publicKey()).build();
    }

    @Bean
    public JwtEncoder jwtEncoder() {
        JWK jwk = new RSAKey.Builder(jwtConfigProperties.publicKey()).privateKey(jwtConfigProperties.privateKey()).build();
        return new NimbusJwtEncoder(new ImmutableJWKSet<>(new JWKSet(jwk)));
    }

    // определяет, какие источники, заголовки и методы разрешены для кросс-доменных запросов.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        //Allowed Origins: Список источников, которые могут отправлять кросс-доменные запросы
        configuration.setAllowedOrigins(List.of("https://localhost:8080"));
        //Список заголовков, которые разрешено использовать при кросс-доменных запросах. List.of("*") означает, что разрешены все заголовки.
        configuration.setAllowedHeaders(List.of("*"));
        //Список HTTP методов, которые разрешено использовать при кросс-доменных запросах. В данном случае только метод GET.
        configuration.setAllowedMethods(List.of("GET"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Вызов source.registerCorsConfiguration("/**", configuration) регистрирует созданную конфигурацию CORS для всех путей в приложении (/**).
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
}

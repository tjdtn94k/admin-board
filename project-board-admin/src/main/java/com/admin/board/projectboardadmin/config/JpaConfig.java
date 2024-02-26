package com.admin.board.projectboardadmin.config;

import com.admin.board.projectboardadmin.dto.security.BoardAdminPrincipal;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;
/**
 * **클래스 설명:**
 *
 *   이 클래스는 JPA 엔티티의 감사(auditing) 기능을 활성화하고 구성합니다.
 *  `@EnableJpaAuditing` 어노테이션은 JPA 엔티티에 대한 감사 기능을 설정합니다.
 *  `@Configuration` 어노테이션은 이 클래스가 Spring 애플리케이션의 구성 클래스임을 나타냅니다.
 * 이 메소드는 현재 로그인한 사용자의 이름을 반환하는 AuditorAware 구현체를 생성합니다.
 * AuditorAware는 JPA에서 누가 데이터를 생성하거나 수정했는지 추적하는 데 사용됩니다.
 * 이 구현체는 Spring Security에서 현재 로그인한 사용자의 정보를 가져와 사용합니다.
 *
 **로직 설명:**

 1. `SecurityContextHolder.getContext()`: 현재 Spring Security 컨텍스트를 가져옵니다.
 2. `map(SecurityContext::getAuthentication)`: 컨텍스트로부터 인증 정보를 가져옵니다.
 3. `filter(Authentication::isAuthenticated)`: 인증된 사용자인지 확인합니다.
 4. `map(Authentication::getPrincipal)`: 인증된 사용자의 Principal 객체를 가져옵니다.
 5. `map(BoardAdminPrincipal.class::cast)`: Principal 객체를 `BoardAdminPrincipal` 타입으로 캐스팅합니다.
 6. `map(BoardAdminPrincipal::getUsername)`: `BoardAdminPrincipal`의 `username` 속성을 가져옵니다.

 **요약:**

 * 이 설정은 JPA 엔티티의 생성 및 수정 시, 현재 로그인한 사용자의 이름을 자동으로 저장하도록 합니다.
 * 이 정보는 데이터의 변경 이력을 추적하고 감사하는 데 유용합니다.

 **추가 정보:**

 * `@CreatedBy` 및 `@LastModifiedBy` 어노테이션을 사용하여 JPA 엔티티에 감사 정보(생성자 및 마지막 수정자)를 추가할 수 있습니다.
 * `AuditorAware` 인터페이스를 구현하여 사용자 정의 감사 로직을 제공할 수 있습니다.
 */
@EnableJpaAuditing
@Configuration
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAware() {
        return () -> Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(BoardAdminPrincipal.class::cast)
                .map(BoardAdminPrincipal::getUsername);
    }

}

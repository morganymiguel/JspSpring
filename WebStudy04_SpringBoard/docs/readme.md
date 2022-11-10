
#### Spring Security 보강 1차

##### 1. 의존성 추가 : pom.xml

*   spring-security-config
*   spring-security-taglibs
*	spring-security-messagging

##### 2. Filter Proxy활용 : web.xml -> DelegatingFilterProxy
springSecurityFilterChain 이 스프링 컨테이너 내부에서 동작함.

##### 3. security-context.xml 에 스프링 시큐리티 기본 설정 등록.

*	security:http auto-config : springSecurityFilterChain 구성
*	security:authentication-manager : 인증 객체 관리자
*	accessDecisionManager(intercept-url) : 접근 허용 여부 결정

>	in memory user service(사용자 정보 수집, User) -> authenticationProvider(인증 여부 판단, Authentication) -> authenticationManager (인증 객체 관리)

>	DB user service(사용자 정보 수집, User) -> authenticationProvider( 인증 여부 판단, Authentication) -> authenticationManager (인증 객체 관리)

##### 4. 인증객체 확보

*	Authentication(Principal)' s property : principal(User)
*	security custom tag :

	<security:authorize access="spEL"> (조건문, 선택적 UI 랜더링)
	<security:authentication property="principal"> (SpringSecurityContext 내부에 생성된 인증 객체)

##### 5. logout : 인증 관련된 모든 요청은 POST : CSRF 방어(csrf 토큰)

	1. <form:form>
	2. <form><security:csrfInput /></form>

##### 6. 보호자원 기반의 접근 제어 :  accessDecisionManager(intercept-url)

	<inputcept-url pattern="/board/**" access="spEL"/>
	

#### Spring Security 보강 2차


*   사전준비


	CREATE TABLE AUTHORITIES
	AS
	SELECT MEM_ID, MEM_ROLE AUTHORITY
	FROM MEMBER;
	INSERT INTO AUTHORITIES
	VALUES	
	('c001', 'ROLE_USER');
	COMMIT;


##### 1. 사용자 정보를 데이터베이스 기반 으로 관리 :  UserDetailService, UserDetailManager(MemberServiceImpl)

>	datasource user service(custom User) -> authenticationProvider -> authenticationManager

>	MemberVO -> MemberDAO -> MemberDAO.xml(has many) -> MemberVOWrapper(User) -> MemberServiceImpl

##### 2. Backend 에서 인증객체 확보 : Principal 구현체(Authentication), custom User 객체 확보

>	HandlerAdapter 활용 : Principal, Authentication ( 's principal : MemberVOWrapper -> realUser)

>	POJO  에서 인증객체 확보 : SecruityContextHolder.getContext().getAuthentication()

##### 3. custom login configuration

	<http>
		<form-login 
			login-page 
			username-parameter 
			password-parameter 
			login-processing-url 
			authentication-success-handler
			authentication-failure-handler	
		/>
		<logout 
			logout-url
			logout-success-url
			success-handler
		/>
	</http>


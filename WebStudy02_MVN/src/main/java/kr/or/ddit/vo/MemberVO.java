package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * 회원 관리(Domain Layer)
 * 
 * 한사람의 회원에 대한 정보(구매기록이 포함)
 * 	has 관계 
 *  has A (1:1)
 *  has Many (1:N)
 *
 *  2개 이상의 테이블을 조인하고 결과 바인딩하는 방법.
 *  1. 대상 테이블 간의 관계 파악.
 *  	MEMBER(1) : PROD(N)
 *  	PROD(1) : BUYER(1)
 *  	PROD(1) : MEMBER(N)
 *  2. 각 테이블로부터 데이터를 바인딩할 VO 정의
 *     해당 VO 간의 관계를 형성.
 *     MemberVO has Many ProdVO
 *     ProdVO has A BuyerVO
 *     ProdVO has Many MemberVO
 *  3. 조인 쿼리 작성
 *  4. resultMap 을 사용하여 결과 바인딩(수동)
 *  	has Many ->  collection   
 *  	has A -> association
 */
@Data
@EqualsAndHashCode(of="memId")
@ToString(exclude = {"memPass", "memRegno1", "memRegno2"})
public class MemberVO implements Serializable{
	private String memId;
	@JsonIgnore
	private transient String memPass;
	private String memName;
	@JsonIgnore
	private transient String memRegno1;
	@JsonIgnore
	private transient String memRegno2;
	private String memBir;
	private String memZip;
	private String memAdd1;
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	private Integer memMileage;
	private Boolean memDelete;
	
	private Set<ProdVO> prodList; // has Many
}














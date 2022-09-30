package kr.or.ddit.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.validate.DeleteGroup;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
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
	
	private int rnum;
	
	@NotBlank(groups = {Default.class, DeleteGroup.class})
	private String memId;
	
	@NotBlank(groups = {Default.class, DeleteGroup.class})
	@Size(min = 4, max = 12, groups = {Default.class, DeleteGroup.class})
	@JsonIgnore
	private transient String memPass;
	@NotBlank
	private String memName;
	@NotBlank(groups = {InsertGroup.class})
	@JsonIgnore
	private transient String memRegno1;
	@NotBlank(groups = {InsertGroup.class})
	@JsonIgnore
	private transient String memRegno2;
	private String memBir;
	@NotBlank
	private String memZip;
	@NotBlank
	private String memAdd1;
	@NotBlank
	private String memAdd2;
	private String memHometel;
	private String memComtel;
	private String memHp;
	@Email
	@NotBlank
	private String memMail;
	private String memJob;
	private String memLike;
	private String memMemorial;
	private String memMemorialday;
	@Min(0)
	private Integer memMileage;
	private Boolean memDelete;
	
	private Set<ProdVO> prodList; // has Many
	
	
	public String getMemTest() {
		return "테스트";
	}
}














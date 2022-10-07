package kr.or.ddit.sample.dao;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Repository("dao_oracle")
public class SampleDAOImpl_Oracle implements SampleDAO{
	
	private static final Map<Integer, String[]> TEAMTABLE= new LinkedHashMap<>();
	
	
	public SampleDAOImpl_Oracle() {
		super();
		log.info("{} 객체 생성", this);
		TEAMTABLE.put(1, new String[] {"이유화_Oracle","오용택_Oracle","정경환_Oracle","윤정식_Oracle","이원걸_Oracle","이찬솔_Oracle"});
		TEAMTABLE.put(2, new String[] {"김호겸_Oracle","임찬우_Oracle","장혜연_Oracle","임지수_Oracle","이주원_Oracle","장윤식_Oracle"});
		TEAMTABLE.put(3, new String[] {"이유영_Oracle","방형준_Oracle","강은비_Oracle","김건호_Oracle","최현우_Oracle","구지현_Oracle"});
		TEAMTABLE.put(4, new String[] {"최지훈_Oracle","홍무곤_Oracle","정요한_Oracle","강명범_Oracle","김유리_Oracle","조수빈_Oracle"});
	}

	public void start() {
		log.info("{} 초기화 완료.", this);
	}
	
	public void stop() {
		log.info("{} 객체 소멸.", this);
	}
	
	@Override
	public String[] selectTeam(Integer teamNumber) {
		return TEAMTABLE.get(teamNumber);
	}

}

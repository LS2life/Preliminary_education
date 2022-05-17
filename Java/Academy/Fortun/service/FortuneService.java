package service;

import java.util.List;

import dto.FortuneVO;

public interface FortuneService {

	List<FortuneVO> getFortuneList();

	//C->사용자 입력(관리자, 일반사용자)
	void createFortune(int id, String name, String fortuneStr);

	//U
	void putFortune(FortuneVO fortuneVO);

	//D
	void deleteFortune(FortuneVO fortuneVO);

}
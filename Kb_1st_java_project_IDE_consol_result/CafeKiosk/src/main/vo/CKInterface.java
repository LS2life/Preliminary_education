package main.vo;

import dto.CKDataTo;
import java.util.ArrayList;
import java.util.List;

public interface CKInterface {
    List<CKDataTO> getMemberList();

    // login
    int login(String id, String password);

    // 특정 회원정보 검색
    void searchMember (String id);

    // 관리자 등록 정보 검색
    void searchAdmin (boolean admin);

    // 전체 회원정보 검색
    void searchMemberS(ArrayList<CKDataTO> memberList)

    // 회원정보 생성
    void create (String id, String password, String name, 
                String birthday, long phone);
                
    // 회원정보 수정
    void modificationInfo(CKDataTO ckdto);

    // 회원정보 삭제
    void delete(CKDataTO ckdto);

}

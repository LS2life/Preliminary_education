package Interface;

import dto.CafeAppDTO;

import java.util.ArrayList;
import java.util.List;

public interface CafeAppInterface {
    List<CafeAppDTO> getMemberList();

    // login
    int login(String id, String password);

    // 특정 회원정보 검색
    void searchOne (String id);

    // 관리자 등록 정보 검색
    void searchAdmin (boolean admin);
    // 전체 회원정보 검색
    void search(ArrayList<CafeAppDTO> memberList);

    // 회원정보 생성
    void create (String id, String password,
                        String name, String birthday,
                        long phone);

    // 회원정보 수정
    void ModificationInfo(CafeAppDTO cafeAppDTO);

    // 회원정보 삭제
    void delete(CafeAppDTO cafeAppDTO);
}
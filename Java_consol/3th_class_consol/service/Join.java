package service;

import dto.CafeManagerDTO;

import java.io.FileWriter;
import java.util.Scanner;

public class Join extends CafeManagerIO {

	CafeManagerIO cafeMemberIO = new CafeManagerIO();

	public CafeManagerIO getCafeIO() {
		return cafeMemberIO;
	}

	Scanner sc = new Scanner(System.in);
	final String only_number = "[0-9]+";

	//회원 가입
	public int regist() throws NumberFormatException  {
		CafeManagerDTO cafeDTO = new CafeManagerDTO();

		String uid;
		boolean  alreadyExists= true;

		do {
			System.out.println("\n<회원가입 메뉴입니다.>");
			System.out.println("원하시는 ID를 입력해 주세요");
			System.out.print("ID : ");
			uid = sc.nextLine();
			for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
				if (uid.equals(CafeArrayList.memberList.get(i).getId())) {
					alreadyExists = false;
					System.out.println("중복된 아이디 입니다.\n");
					break;
				} else {
					alreadyExists = true;
				}

			}
		} while (alreadyExists == false);
		if ( alreadyExists== true) {
			cafeDTO.setId(uid);
		}

		System.out.println("비밀번호를 입력해주세요.");
		System.out.print("비밀번호 : ");
		cafeDTO.setPassword(sc.nextLine());

		System.out.println("이름을 입력해주세요.");
		System.out.print("이름 : ");
		cafeDTO.setName(sc.nextLine());

		String resist_age;
		while (true) {
			System.out.println("주민등록번호 앞자리의 생일 6자리를 입력해주세요.");
			System.out.print("생년월일 : ");
			resist_age = sc.nextLine();

			if (resist_age.matches(only_number)) {
				break;
			} else {
				System.out.println("숫자만 입력가능합니다.");
			}
		}
		cafeDTO.setBirthday(resist_age);

// 성공적인 회원가입 시
		System.out.println("\n회원가입 완료");
		System.out.println("로그인 화면으로 돌아갑니다.\n");
		System.out.println("-----------------------\n");

		// 임시 데이터 추가
		CafeArrayList.memberList.add(cafeDTO);

//		// 파일에 데이터 추가
//		cafeIO.writeFile(service.ArrayMemberList.memberList);

//		// 임시 데이터 삭제
//		service.ArrayMemberList.memberList.remove(0);

		// 덮어쓰기
		try (FileWriter directfw = new FileWriter(directFile)) {
			// 저장할 정보들
			for (int i = 0; i < memberList.size(); i++) {
				String writeML = memberList.get(i).getId() + "," + memberList.get(i).getPassword() + ","
						+ memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
						+ memberList.get(i).getPhone() + "," + memberList.get(i).getRewardsPoint() + ","
						+ memberList.get(i).getGrade() + "," + memberList.get(i).getDateOfJoin() + "\n";

				// 파일로 출력
				directfw.write(writeML);
				directfw.flush();
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return -1;
	}
}

package service;

import java.io.FileWriter;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import dto.CafeManagerDTO;

public class Login extends CafeManagerIO {
	CafeManagerDTO cafedto = new CafeManagerDTO();
	Scanner sc = new Scanner(System.in);
	int ididx = 0;
	int gradeidx;

	// 로그인
	public int login() throws NumberFormatException{
		String loginId = "";
		String loginPw = "";

		// 일치 시 - true / 불일치 시 - false
		boolean id_pass = false;
		boolean pw_pass = false;

//		// 배열 작동 확인
//		try {
//			System.out.println(ArrayMemberList.memberList.size());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		do {
			System.out.print("아이디 : ");
			loginId = sc.nextLine();

			if(Objects.equals(CafeManagerDTO.getSuperUser(), loginId)) {
				id_pass = true;
				System.out.println("\nSuper User Login");
				break;

			}else {

				for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
					// System.out.println("for 진입");
					if (loginId.equals(CafeArrayList.memberList.get(i).getId())) {
						id_pass = true;
						System.out.println("아이디 확인");
						ididx = i;
						break;
					}
				}

				if (id_pass == false) {
					int choice = -1;

					try {
						System.out.println("없는 아이디 입니다.");
						System.out.println("메인으로 돌아가시려면 0번을 입력해주세요.\n");
						System.out.print("0. 메인메뉴 : ");
						choice = sc.nextInt();
						sc.nextLine();

					}catch (InputMismatchException e) {
						System.out.println("잘못 누르셨습니다.");
						System.out.println("메뉴번호를 입력해주세요.\n");

					}
					if (choice == 0) {
						gradeidx = -1;
						id_pass = false;
						return gradeidx;
					}
				}
			}
		} while (id_pass == false);

		do {
			try {
				System.out.print("비밀번호 : ");
				loginPw = sc.nextLine();

				if (Objects.equals(CafeManagerDTO.getSuperPass(),loginPw)) {
					gradeidx = 1;
					pw_pass = true;
					cafedto.setAdmin(true);

				}else {
					for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
						if (loginPw.equals(CafeArrayList.memberList.get(i).getPassword()) && (i == ididx)) {
							pw_pass = true;
							gradeidx = CafeArrayList.memberList.get(i).getGrade();
							System.out.println("등급 : " + gradeidx);
							if (gradeidx == 2) {
								gradeidx = 3;
							} else {
								gradeidx = 2;
							}
							break;
						}
					}
				}
			} catch (NumberFormatException e) {

			}
			if (pw_pass == false) {
				System.out.println("비밀번호를 다시 확인해 주세요.\n");
				sc.nextLine();
			}

		} while (pw_pass == false);

		System.out.println("로그인 성공\n");
		return gradeidx;
	}


	// 개인 조회
	public String search() {
		// 개인조회
		String search_id = "";
		boolean search_pass = false;
		String memberName = null;
		System.out.print("ID 검색 : ");
		search_id = sc.nextLine();
		try {
			for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
				if (search_id.equals(CafeArrayList.memberList.get(i).getId())) {
					System.out.println("\n < " + CafeArrayList.memberList.get(i).getId() + " >");
					System.out.println("이름 : " + CafeArrayList.memberList.get(i).getName());
					System.out.println("생년월일 : " + CafeArrayList.memberList.get(i).getBirthday());
					System.out.println("전화번호 : " + CafeArrayList.memberList.get(i).getPhone());
					System.out.println("포인트 : " + CafeArrayList.memberList.get(i).getRewardsPoint());
					System.out.println("관리자 : " + CafeArrayList.memberList.get(i).getAdmin());
					System.out.println("등급 : " + CafeArrayList.memberList.get(i).getGrade());
					search_pass = true;

				}
			}
			if (search_pass == false) {
				System.out.println("ID를 찾을 수 없습니다.\n");
			}
		}catch (InputMismatchException e) {
			System.out.println("확인된 ID가 없습니다.");
		}
		return search_id;
	}

	// 서브메니저 리스트 출력.
	public int subManagerList() {
		if (CafeArrayList.memberList.size() != 0) {
			System.out.println("지정된 매니저가 없습니다.");

		} else {
			for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
				if (Objects.equals(true, CafeArrayList.memberList.get(i).getAdmin())) {
					System.out.println("ID : " + CafeArrayList.memberList.get(i).getId());
					System.out.println("이름 : " + CafeArrayList.memberList.get(i).getName());
					System.out.println("생년월일 : " + CafeArrayList.memberList.get(i).getBirthday());
					System.out.println("등급 : " + CafeArrayList.memberList.get(i).getGrade());
					System.out.println("가입일 : " + CafeArrayList.memberList.get(i).getDateOfJoin());

				} else {
					System.out.println("지정된 매니저가 없습니다.");
				}
			}

		}
		return CafeArrayList.memberList.size();
	}

	// ID 삭제
	public int Delete() {
		String deleteid=null;

		try {
			System.out.print("ID를 입력하세요 : ");
			deleteid = sc.nextLine();

		}catch (InputMismatchException e) {
			System.out.println("ID를 다시 확인해 주세요.\n");
		}

		if (deleteid.equals(CafeArrayList.memberList.get(ididx).getId())) {
			CafeArrayList.memberList.remove(ididx);

			// 덮어쓰기
			try (FileWriter directFileWrite = new FileWriter(directFile)) {
				// 저장할 정보들
				for (int i = 0; i < memberList.size(); i++) {
					String writeML = memberList.get(i).getId() + "," + memberList.get(i).getPassword() + ","
							+ memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
							+ memberList.get(i).getPhone() + "," + memberList.get(i).getRewardsPoint() + ","
							+ memberList.get(i).getAdmin() + "," + memberList.get(i).getGrade() + ","
							+ memberList.get(i).getDateOfJoin() + "\n";

					// 파일로 출력
					directFileWrite.write(writeML);
					directFileWrite.flush();
				}
			} catch (Exception e) {
				e.getMessage();
			}

			System.out.println("ID 삭제 완료.\n");
		}

		else {
			System.out.println("없는 ID입니다.\n");
		}
		return 1;
	}

	// 등급 변경
	public int Update() {
		int choice = -1;
		int update_grade;
		String search_id = "";
		boolean search_pass = false;
		System.out.print("ID 검색 : ");
		search_id = sc.nextLine();

		for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
			if (search_id.equals(CafeArrayList.memberList.get(i).getId())) {
				System.out.println("\n이름 : " + memberList.get(i).getName());
				System.out.println("생년월일 : " + CafeArrayList.memberList.get(i).getBirthday());
				System.out.println("전화번호 : " + CafeArrayList.memberList.get(i).getPhone());
				System.out.println("포인트 : " + CafeArrayList.memberList.get(i).getRewardsPoint());
				System.out.println("관리자 : " + CafeArrayList.memberList.get(i).getAdmin());
				System.out.println("등급 : " + CafeArrayList.memberList.get(i).getGrade());
				search_pass = true;

			}
		}
		if (search_pass == false) {
			System.out.println("ID 를 찾을 수 없습니다.\n");
		}else if (search_pass == true) {
			do {
				System.out.println("회원 등급을 선택해주세요.");
				System.out.println("1. 매니저");
				System.out.println("2. 일반회원");
				System.out.print("등급 변경 : ");
				update_grade = sc.nextInt();
				sc.nextLine();
				if (update_grade == 1) {
					update_grade = 2;
				} else {
					update_grade = 3;
				}

			} while (update_grade == 2 || update_grade == 3);
			cafedto.setId(memberList.get(ididx).getId());
			cafedto.setPassword(memberList.get(ididx).getPassword());
			cafedto.setName(memberList.get(ididx).getName());
			cafedto.setBirthday(memberList.get(ididx).getBirthday());
			cafedto.setPhone(memberList.get(ididx).getPhone());
			cafedto.setRewardsPoint(memberList.get(ididx).getRewardsPoint());
			cafedto.setAdmin(memberList.get(ididx).getAdmin());
			cafedto.setGrade(update_grade);
			cafedto.setDateOfJoin(memberList.get(ididx).getDateOfJoin());

			memberList.set(ididx, cafedto);
			choice = -1;

			// 덮어쓰기
			try (FileWriter directfw = new FileWriter(directFile)) {
				// 저장할 정보들
				for (int i = 0; i < memberList.size(); i++) {
					String writeML = memberList.get(i).getId() + "," + memberList.get(i).getPassword() + ","
							+ memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
							+ memberList.get(i).getPhone() + "," + memberList.get(i).getRewardsPoint() + ","
							+ memberList.get(i).getAdmin() + "," + memberList.get(i).getDateOfJoin() + "\n";

					// 파일로 출력
					directfw.write(writeML);
					directfw.flush();
				}
			} catch (Exception e) {
				e.getMessage();
			}
		}
		return choice;
	}

	// 리워드 포인트 변경
	// ToDo 변경은 불필요 예상. 포인트 합산만.
	public int changeRewards() {

		int choice;
		int update_grade;
		String search_id = "";
		boolean search_pass = false;
		System.out.print("ID 검색 : ");
		search_id = sc.nextLine();

		for (int i = 0; i < CafeArrayList.memberList.size(); i++) {
			if (search_id.equals(CafeArrayList.memberList.get(i).getId())) {
				System.out.println("\n이름 : " + memberList.get(i).getName());
				System.out.println("생년월일 : " + CafeArrayList.memberList.get(i).getBirthday());
				System.out.println("전화번호 : " + CafeArrayList.memberList.get(i).getPhone());
				System.out.println("리워드 포인트 : " + CafeArrayList.memberList.get(i).getRewardsPoint());
				System.out.println("등급 : " + CafeArrayList.memberList.get(i).getGrade());
				search_pass = true;

			}
		}
		if (search_pass == false) {
			System.out.println("없는 ID 입니다");
		}
		return 0;
	}
}

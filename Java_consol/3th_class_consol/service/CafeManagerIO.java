package service;

import dto.CafeManagerDTO;

import java.io.*;
import java.util.ArrayList;

public class CafeManagerIO extends CafeArrayList {

	// DB대용 파일 주소
	File directFile = new File(".\\src\\database\\cafeMemberDB.txt");

	// 출력 스트림
	public void writeFile(ArrayList<CafeManagerDTO> memberList)  {

		try (FileWriter directfw = new FileWriter(directFile, true)) {
			if(directFile.createNewFile()){
				System.out.println("파일이 생성되었습니다.");

			}else {
				System.out.println("가입이 완료되었습니다.\n");
			}
			// 저장할 정보들
//			for (int i = 0; i < memberList.size(); i++) {
//				String writeML = memberList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
//						+ memberList.get(i).getDateOfJoin() + "," + memberList.get(i).getId() + ","
//							+ memberList.get(i).getPassword() + "," + memberList.get(i).getGrade() + "\n";
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
	}

	// 입력 스트림
	public ArrayList<CafeManagerDTO> readReader() {
		memberList.clear();
		try {
			FileReader fileReader = new FileReader(directFile);
			try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
				String str;

				while (true) {
					// 한문장 읽기
					str = bufferedReader.readLine();
					// 읽을 줄 없을 시
					if (str == null) {
						break;
					}

					String[] writeMLar = str.split(",");

					// 테스트용
					// System.out.println(str);

					// 배열 수 불일치 시
					if (writeMLar.length != 6)
						continue;

					CafeManagerDTO cafedto = new CafeManagerDTO();

					// 각 정보 저장
					cafedto.setId(writeMLar[0]);
//					System.out.print(cafedto.getName());

					cafedto.setPassword(writeMLar[1]);
//					System.out.print(cafedto.getBirthday());

					cafedto.setName(writeMLar[2]);
//					System.out.print(cafedto.getDateOfJoin());

					cafedto.setBirthday(writeMLar[3]);
//					System.out.print(cafedto.getId());

					cafedto.setPhone(Long.parseLong(writeMLar[4]));
//					System.out.print(cafedto.getPassword());

					cafedto.setGrade(Integer.parseInt(writeMLar[5]));
//					System.out.println(cafedto.getGrade());

					memberList.add(cafedto);
				}
			}

		} catch (Exception e) {
			e.getMessage();
		}
		return memberList;
	}

}

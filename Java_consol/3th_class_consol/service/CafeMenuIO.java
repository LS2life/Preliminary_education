package service;

import dto.CafeMenuDTO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CafeMenuIO extends CafeArrayList {

    // DB 파일 주소
    File menuFile = new File(".\\src\\database\\cafeMenuDB.txt");

    // 출력 스트림
    public void writeFile(ArrayList<CafeMenuDTO> menuList)  {

        try (FileWriter menuWriteFile = new FileWriter(menuFile, true)) {
            if(menuFile.createNewFile()){
                System.out.println("파일이 생성되었습니다.");

            }else {
                System.out.println("가입이 완료되었습니다.\n");
            }
            // 저장할 정보들
//			for (int i = 0; i < menuList.size(); i++) {
//				String writeML = menuList.get(i).getName() + "," + memberList.get(i).getBirthday() + ","
//						+ menuList.get(i).getDateOfJoin() + "," + memberList.get(i).getId() + ","
//							+ menuList.get(i).getPassword() + "," + memberList.get(i).getGrade() + "\n";
            for (int i = 0; i < menuList.size(); i++) {
                String writeML = menuList.get(i).getNo() + "," + menuList.get(i).getMenu() + ","
                        + menuList.get(i).getKcal() + "," + menuList.get(i).getPrice() + "\n";

                // 파일로 출력
                menuWriteFile.write(writeML);
                menuWriteFile.flush();
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    // 입력 스트림
    public ArrayList<CafeMenuDTO> readReader() {
        menuList.clear();
        try {
            FileReader fileReader = new FileReader(menuFile);
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

                    CafeMenuDTO cmd = new CafeMenuDTO();

                    // 각 정보 저장
                    cmd.setNo(Integer.parseInt(writeMLar[0]));
//					System.out.print(cmd.getName());

                    cmd.setMenu(writeMLar[1]);
//					System.out.print(cmd.getBirthday());

                    cmd.setKcal(Integer.parseInt(writeMLar[2]));
//					System.out.print(cmd.getDateOfJoin());

                    cmd.setPrice(Integer.parseInt(writeMLar[3]));
//					System.out.print(cmd.getId());

                    menuList.add(cmd);
                }
            }

        } catch (Exception e) {
            e.getMessage();
        }
        return menuList;
    }
}

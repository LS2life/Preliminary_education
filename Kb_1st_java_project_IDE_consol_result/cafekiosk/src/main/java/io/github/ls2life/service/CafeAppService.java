package io.github.ls2life.service;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import io.github.ls2life.dto.CafeAppDTO;
import io.github.ls2life.interface.CafeAppInterface;

public class CafeAppService implements CafeAppInterface {

    LocalDateTime loginTime = LocalDateTime.now();
    private List<CafeAppDTO> memberList = null;
    private Path memberDb = Paths.get("./database/CafeMemberDB.txt");
    private Path menuDb = Paths.get("./database/CafeMenuDB.txt");

    // MemberList
    @Override
    public List<CafeAppDTO> getMemberList() {
        return memberList;
    }
    public void setMemberList(List<CafeAppDTO> memberList) {
        this.memberList = memberList;
    }

    // Cafe Application createDB file and Input file
    public void cafeAppCNI() {
        // Member file create and load.
        createFileAndLoad();

        // read file
        readFile();
    }

    // Member file create and load.
    public void createFileAndLoad() {
        try {
            memberDb = Files.createFile(memberDb);
            System.out.println("최초 실행이거나 회원파일을 찾을 수 없습니다.");
            System.out.println("새로운 데이터 파일을 생성합니다.");
            System.out.println(memberDb);
        } catch (IOException e) {
            System.out.println("회원정보 파일이 확인되었습니다.");
            System.out.println(memberDb);
        }
    }

    // read file
    public void readFile() {
        try (ObjectInputStream checkMember =
                     new ObjectInputStream(
                             Files.newInputStream(memberDb))) {
            memberList = (List<CafeAppDTO>) checkMember.readObject();
        } catch (ClassNotFoundException e) {
            System.out.print("저장된 정보가 없습니다");
            System.out.println(memberList);
        } catch (IOException e) {
            System.out.print("생성된 회원 목록이 없습니다.");
            System.out.println(memberList);
        }
        // Beginning run
        if (memberList == null) {
            memberList = new ArrayList<>();
        }
    }


    // same ID
    public void sameId (String id) {
        Iterator<CafeAppDTO> sameid = memberList.iterator();
        while (sameid.hasNext()) {
            CafeAppDTO findSameId = sameid.next();
            if (Objects.equals(findSameId.getId(), id)) {
                System.out.println(findSameId.getId() + "는 있는 ID입니다.");
            }else {
                System.out.println("사용 가능한 ID 입니다.");
            }
        }
    }


    // One member search
    @Override
    public void searchOne (String id) {
        Iterator<CafeAppDTO> checkMember = memberList.iterator();
        while (checkMember.hasNext()) {
            CafeAppDTO find = checkMember.next();
            if (Objects.equals(find.getId(), id)) {
                System.out.println(find.getId());
                System.out.println(find.getName());
                System.out.println(find.getBirthday());
                System.out.println(find.getPhone());
                System.out.println(find.getEtc());
                System.out.println(find.getAdmin());
                System.out.println(LocalDateTime.now() + "회원정보를 검색했습니다.");
            }else {
                System.out.println("일치하는 회원 정보가 없습니다.");
            }
        }
    }

    // All member search
    public void search(ArrayList<CafeAppDTO> memberList) {
        for (int i = 0; i < memberList.size(); i++) {
            System.out.println(memberList.get(i).getId());
            System.out.println(memberList.get(i).getName());
            System.out.println(memberList.get(i).getBirthday());
            System.out.println(memberList.get(i).getPhone());
            System.out.println(memberList.get(i).getEtc());
            System.out.println(memberList.get(i).getAdmin());
            System.out.println(memberList.get(i).getDateOfJoin());
        }
    }

    // admin member search
    @Override
    public void searchAdmin (boolean admin) {
        Iterator<CafeAppDTO> checkMember = memberList.iterator();
        while (checkMember.hasNext()) {
            CafeAppDTO find = checkMember.next();
            if (Objects.equals(find.getAdmin(), admin)) {
                System.out.println(find.getId());
                System.out.println(find.getName());
                System.out.println(find.getBirthday());
                System.out.println(find.getPhone());
                System.out.println(find.getEtc());
                System.out.println(find.getAdmin());
                System.out.println(LocalDateTime.now() + "회원정보를 검색했습니다.");
            }else {
                System.out.println("일치하는 회원 정보가 없습니다.");
            }
        }
    }
    // login
    @Override
    public int login(String id, String password) {
        Iterator<CafeAppDTO> checkMember = memberList.iterator();
        int gread = -1;

        while (checkMember.hasNext()) {
            CafeAppDTO checkId = checkMember.next();

            if (Objects.equals(CafeAppDTO.getSuperUser(), id)
                    && Objects.equals(CafeAppDTO.getSuperPass(), password)) {
                System.out.println(" !-- Super User Login --! ");
                System.out.println(checkId.getId() +"  "+ checkId.getName() + "  " + checkId.getAdmin());
                System.out.println("접속시간 : " + loginTime);
                System.out.println("최고관리자 로그인 되었습니다.\n");
                checkId.setAdmin(true);
                gread = 1;

            } else if (!Objects.equals(CafeAppDTO.getSuperUser(), id)) {
                if (Objects.equals(checkId.getId(), id) &&
                        Objects.equals(checkId.getPassword(), password) &&
                        !checkId.getAdmin()) {
                    checkId.setLocalDateTime(loginTime);
                    System.out.println(checkId.getAdmin());
                    System.out.println("접속시간 : " + loginTime);
                    System.out.println(checkId.getName() + " Manager 접속 확인");
                    System.out.println("관리자로 로그인 승인되었습니다.\n");
                    gread = 2;

                } else if (Objects.equals(checkId.getId(), id) &&
                        Objects.equals(checkId.getPassword(), password) &&
                        checkId.getAdmin()) {
                    checkId.setLocalDateTime(loginTime);
                    System.out.println(checkId.getAdmin());
                    System.out.println("접속시간 : " + loginTime);
                    System.out.println(checkId.getId() + " 회원님 어서오세요.");
                    System.out.println("로그인 되었습니다.\n");
                    gread = 3;

                } else {
                    System.out.println("회원정보가 없습니다.\n");
                }
            }
            System.out.println("가입된 아이디가 없습니다.");
        }
        return gread;
    }

    // Create member
    @Override
    public void create (String id, String password, String name, String birthday,long phone) {
        CafeAppDTO cafeAppDTO = new CafeAppDTO();
        cafeAppDTO.setId(id);
        cafeAppDTO.setPassword(password);
        cafeAppDTO.setName(name);
        cafeAppDTO.setBirthday(birthday);
        cafeAppDTO.setPhone(phone);
        cafeAppDTO.setAdmin(false);
        cafeAppDTO.setEtc("");
        cafeAppDTO.setAdmin(false);
        cafeAppDTO.setLocalDateTime(LocalDateTime.now());
        memberList.add(cafeAppDTO);
        System.out.println(cafeAppDTO.getId());
        System.out.println(cafeAppDTO.getName());
        System.out.println(cafeAppDTO.getBirthday());
        System.out.println(cafeAppDTO.getPhone());
        System.out.println(cafeAppDTO.getLocalDateTime());
        System.out.println("가입이 완료되었습니다.");
        saveMember();
    }

    // Modification information
    @Override
    public void ModificationInfo (CafeAppDTO cafeAppDTO) {
        Iterator<CafeAppDTO> checkMember = memberList.iterator();
        while (checkMember.hasNext()) {
            CafeAppDTO arrCafeAppDTO = checkMember.next();
            if (Objects.equals(arrCafeAppDTO.getId(), cafeAppDTO.getId())) {
                arrCafeAppDTO.setName(cafeAppDTO.getName());
                arrCafeAppDTO.setPhone(cafeAppDTO.getPhone());
                arrCafeAppDTO.setBirthday(cafeAppDTO.getBirthday());
                arrCafeAppDTO.setLocalDateTime(LocalDateTime.now());
                System.out.println(LocalDateTime.now() + "회원정보가 변경되었습니다.");
            }
        }
        // Save file
        saveMember();
    }


    // Save file
    public void saveMember () {
        try (ObjectOutputStream saveMem =
                     new ObjectOutputStream(Files.newOutputStream(memberDb))) {
            saveMem.writeObject(memberList);
            System.out.println("저장 되었습니다.");
        } catch (IOException e) {
            System.out.println("취소 되었습니다.");
        }
    }

    // Delete member and save file
    @Override
    public void delete (CafeAppDTO cafeAppDTO){
        Iterator<CafeAppDTO> deletMem = memberList.iterator();
        while (deletMem.hasNext()) {
            CafeAppDTO arrCafeAppDTO = deletMem.next();
            if (Objects.equals(arrCafeAppDTO.getId(), arrCafeAppDTO.getId())) {
                deletMem.remove();
            }
        }
        saveMember();
    }
}
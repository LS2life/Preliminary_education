package service;

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

import dto.FortuneVO;

//+ �������丮 �÷���->���� �б�
//+ �������丮2 �÷���->db
public class FortuneRepository implements service.FortuneService {
	private List<FortuneVO> fortuneList=null;
	private Path fortuneFile=Paths.get("fortunes.bin");
	
	public FortuneRepository() {
		//���� �� �� ���� ���� �Ǵ� �ε�
		loadFile();
		//������ �Ǽ� FortuneRepository�ν��Ͻ� ���� �ɶ� ���� �б�
		readFortunes();
	}
	
	@Override
	public List<FortuneVO> getFortuneList() {
		return fortuneList;
	}

	public void setFortuneList(List<FortuneVO> fortuneList) {
		this.fortuneList = fortuneList;
	}
	
	//C->����� �Է�(������, �Ϲݻ����)
	@Override
	public void createFortune(
			int id,
			String name,
			String fortuneStr) {
		FortuneVO fortuneVO=new FortuneVO();
		fortuneVO.setId(id);
		fortuneVO.setName(name);
		fortuneVO.setFortuneStr(fortuneStr);
		fortuneVO.setLocalDateTime(LocalDateTime.now());
		fortuneList.add(fortuneVO);
		System.out.println(fortuneVO.toString()+" FortuneVO ���� �Ϸ�");
		//���Ϸ� ����
		writeFortunes();
	}
	
	//U
	@Override
	public void putFortune(FortuneVO fortuneVO) {
		Iterator<FortuneVO> itr=fortuneList.iterator();
		while(itr.hasNext()) {
			FortuneVO arrFortuneVO=itr.next();
			if(arrFortuneVO.getId()==fortuneVO.getId()) {
				arrFortuneVO.setName(fortuneVO.getName());
				arrFortuneVO.setFortuneStr(fortuneVO.getFortuneStr());
				arrFortuneVO.setLocalDateTime(LocalDateTime.now());
			}
		}
		//���Ϸ� ����
		writeFortunes();
	}
	
	//D
	@Override
	public void deleteFortune(FortuneVO fortuneVO) {
		Iterator<FortuneVO> itr=fortuneList.iterator();
		while(itr.hasNext()) {
			FortuneVO arrFortuneVO=itr.next();
			if(arrFortuneVO.getId()==fortuneVO.getId()) {
				itr.remove();
			}
		}
		//���Ϸ� ����
		writeFortunes();
	}

	//+ ���� ���� �� �ε�
	public void loadFile() {
		try {
			fortuneFile=Files.createFile(fortuneFile);
			System.out.println("���� ���� ����");
		} catch (IOException e) {
			System.out.println("���� �ε� ����");
		}
	}
		
	//+ ���� ����
	public void writeFortunes() {
		try(ObjectOutputStream oo=
				new ObjectOutputStream(
						Files.newOutputStream(fortuneFile))){
			oo.writeObject(fortuneList);
			System.out.println("���� ���� ����");
		}catch(IOException e) {
			System.out.println("���� ���� ����");
		}
	}
	
	//+ ���� �б�
	public void readFortunes() {
		try(ObjectInputStream oi=
				new ObjectInputStream(
						Files.newInputStream(fortuneFile))){
			fortuneList=(List<FortuneVO>)oi.readObject();
		}catch(ClassNotFoundException e) {
			System.out.println("���� ���� �� ���� �����ϴ�");
		}catch(IOException e) {
			System.out.println("����� ���� ���ų� ���� �б� ����");
		}
		//ó�� �����Ͽ� ����� ���� ���� ��
		if(fortuneList==null) {
			fortuneList=new ArrayList<>();
		}
	}
}

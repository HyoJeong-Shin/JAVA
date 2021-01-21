package ch16.hw;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

// 중재자 역할을 하는 클래스
public class LoginFrame extends JFrame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;	///구성요소들 먼저 선언 ///check박스라는 걸 명시해주기 ex_ checkGuest

	private ColleagueCheckbox checkLogin;
	
	private ColleagueCheckbox checkMember; //효정: 구성요소 checkMember 선언

	private ColleagueTextField textUser;

	private ColleagueTextField textPass;
	
	private ColleagueTextField textIdcard; //효정: 구성요소 textIdcard 선언

	private ColleagueButton buttonOk;

	private ColleagueButton buttonCancel;

	// 생성자
	// Colleague들을 생성해서 배치한 후에 표시를 실행한다.
	public LoginFrame(String title) {
		super(title);	///super부르는 부분 맨 첫줄에 놓지 않으면 컴파일 오류 발생함
		// 배경색의 설정(setBackground( ) 이용) ///부모인 frame에 있는 메소드 
		setBackground(Color.GRAY); //효정: 배경 회색으로 
		// 레이아웃 매니저: 프레임을 구성하는 구성 요소의 배치를 결정한다.
		// 그리드 레이아웃 매니저를 사용해서 5*3의 그리드를 만든다.
		// 즉, 프레임 영역을 5행 3열로 나눔
		setLayout(new GridLayout(5,3)); //효정: 프레임 영역 5행 3열로 나눔 
		
		// Colleague들의 생성
		createColleagues();
		
		// 생성된 Colleague들을 frame에 붙임 
		add(checkGuest);
		add(checkLogin);
		add(checkMember);
		
		add(new Label("Username:"));
		add(textUser);
		add(new Label("          ")); //효정: 빈 문자열을 추가하여 비어있는 것처럼 보이게 함
		
		add(new Label("Password:"));
		add(textPass);
		add(new Label("          ")); //효정: 빈 문자열을 추가하여 비어있는 것처럼 보이게 함
		
		JLabel label = new JLabel("주민등록번호:");
		add(label); //효정 : 주민등록번호 라벨 추가
		add(textIdcard); //효정: 주민등록번호 텍스트필드 추가 
		add(new Label("         ")); //효정: 빈 문자열을 추가하여 비어있는 것처럼 보이게 함
		
		add(buttonOk);
		add(buttonCancel);
		
		// 각 체크박스 유효/무효를 초기화한다.
		colleagueChanged(checkGuest);
		
		// 표시
		pack(); // 포함된 컴포넌트들의 레이아웃(배치 상태)에 맞게 윈도우 크기를 조정한다.
		//show(); // 윈도우를 보여준다.
		setVisible(true); //까지 해줘야 보임 
	}

	// Colleague들을 생성한다.
	public void createColleagues() {
		// 생성
		// Checkbox 생성 
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);	///같은 그룹에 속해야 여러개 중에 하나만 선택할 수 있음 
		checkLogin = new ColleagueCheckbox("Login", g, false);
		checkMember = new ColleagueCheckbox("Member", g, false); //효정: 멤버에 대한 체크박스 생성
		
		textUser = new ColleagueTextField("", 10); ///초기값 10칸으로 넣음 
		textPass = new ColleagueTextField("", 10);
		textIdcard = new ColleagueTextField("", 10); //효정: 주민등록번호 텍스트필드 생성
		textPass.setEchoChar('*');
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediator를 설정한다. 각 GUI 컴포넌트의 중재자는 현재 클래스 자신이다.
		checkGuest.setMediator(this);	///중재가 누구인지 설정해줌 ///this는 현재 만들고있는 loginframe객체임 
		checkLogin.setMediator(this);
		checkMember.setMediator(this); //효정: 중재자 설정
		textUser.setMediator(this);
		textPass.setMediator(this);
		textIdcard.setMediator(this); //효정: 중재자 설정
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listener들을 설정한다. ///리스너 설정 안하면, 껍데기 뿐 인 것이 되어버림 
		checkGuest.addItemListener(checkGuest); // 자신이 이벤트 리스너가 된다
		checkLogin.addItemListener(checkLogin); // 자신이 이벤트 리스너가 된다
		checkMember.addItemListener(checkMember); //효정: 이벤트 리스너 설정
		textUser.addTextListener(textUser); // 자신이 이벤트 리스너가 된다
		textPass.addTextListener(textPass); // 자신이 이벤트 리스너가 된다
		textIdcard.addTextListener(textIdcard); //효정: 이벤트 리스너 설정
		buttonOk.addActionListener(listener);
		buttonCancel.addActionListener(this);
	}

	// colleague의 상태가 변화했을 때, 호출되는 메소드
	// Colleague로부터의 통지가 오면, 통지의 종류를 파악하여 각 Colleague의 유효/무효를 판정한다.
	// colleague의 상태 변화에 따라 해당 colleague의 상태를 
	// 어떻게 변화시킬 것인가에 대한 로직을 가지고 있다.
	public void colleagueChanged(Colleague c) {
		// 어떤 colleague에서 통지가 왔는지 결정
		if(c == checkGuest || c == checkLogin || c == checkMember) {
			// 체크박스에서 통지가 왔다면...
			if(checkGuest.getState()) {	// guest 체크박스가 선택되었다면 
				textUser.setColleagueEnabled(false);
				textPass.setColleagueEnabled(false);
				textIdcard.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(true);
			}else if(checkLogin.getState()){ // login 체크박스가 선택되었다면
				textUser.setColleagueEnabled(true);
				textIdcard.setColleagueEnabled(false);
				userpassChanged();
			}else { //효정: member 라디오 버튼이 선택 되었다면
				textUser.setColleagueEnabled(true);
				usermemberChanged();
			}
		}else if(c==textUser || c == textPass) {
			if(checkMember.getState())
				usermemberChanged();
			else
				userpassChanged();
		}else if(c==textIdcard) {
			usermemberChanged();
		}
		else {//불가능한 경우
			System.out.println("오류: unknown colleague");
		}
	}

	// TextField 상태 변화에 따라 버튼 활성화/비활성화한다.
	private void userpassChanged() {
		if (textUser.getText().length() > 0) { // textUser(유저네임)에 값이 들어가 있다면... ///연습문제 16-1은 여기 코드 >0을 >=4로 바꾸면 됨
			textPass.setColleagueEnabled(true); // textPass를 유효화 시킨다.
			if (textPass.getText().length() > 0) { // textPass(패스워드)에 값이 들어가 있다면... ///연습문제 16-1은 여기 코드 >0을 >=4로 바꾸면 됨
				buttonOk.setColleagueEnabled(true); // buttonOk를 유효화시킨다.
			} else {
				buttonOk.setColleagueEnabled(false); // textPass에 값이 들어가 있지 않다면...
				textIdcard.setColleagueEnabled(false); //
			}
		} else { // textUser에 값이 들어가 있지 않다면... textPass와 buttonOk를 무효화시킨다.
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	
	//효정: 주민등록번호에 대한 TextField 상태 변화에 따른 버튼 및 텍스트 필드 활성화/비활성화
	private void usermemberChanged() {
		
		if (textUser.getText().length() > 0) { // textUser(유저네임)에 값이 들어가 있다면... ///연습문제 16-1은 여기 코드 >0을 >=4로 바꾸면 됨
			textPass.setColleagueEnabled(true); // textPass를 유효화 시킨다.
			if (textPass.getText().length() > 0) { // textPass(패스워드)에 값이 들어가 있다면... ///연습문제 16-1은 여기 코드 >0을 >=4로 바꾸면 됨
				textIdcard.setColleagueEnabled(true);
				buttonOk.setColleagueEnabled(false);
				if(textIdcard.getText().length()>0)
					memberlogic();
			} else {
				textIdcard.setColleagueEnabled(false);
				buttonOk.setColleagueEnabled(false); // textPass에 값이 들어가 있지 않다면...
			}
		} else { // textUser에 값이 들어가 있지 않다면... textPass와 buttonOk를 무효화시킨다.
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	
	private void memberlogic() {
		String textid=textIdcard.getText();
		for(int i=0; i<textid.length(); i++) 
		{
			char ch=textid.charAt(i);
			if(Character.isDigit(ch)==false) {
				JOptionPane.showMessageDialog(this, "주민등록번호는 모두 숫자로 이루어져야 합니다!", "경고", JOptionPane.WARNING_MESSAGE);
				textIdcard.setText(textid.substring(0,i));
				textIdcard.setCaretPosition(i);
			}
		}
		
		if(textid.length()==13) {
			if (textid.charAt(6)=='3'||textid.charAt(6)=='4') 
				buttonOk.setColleagueEnabled(true);
			else 
				buttonOk.setColleagueEnabled(false);
		}
	}

	// OK, Cancel 버튼이 눌러졌을 때 실행되는 메소드
	private ActionListener listener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(checkMember.getState()) {
				String user=textUser.getText();
				int countDigit =0;
				int countUpper =0;
				int countLower = 0; 
				for(int i=0; i<user.length(); i++) 
				{
					char ch=user.charAt(i);
					if(Character.isDigit(ch)==true) 
						countDigit++;
					if(Character.isUpperCase(ch)==true)
						countUpper++;
					if(Character.isLowerCase(ch)==true)
						countLower++;
				}
				if(countDigit ==0 || countUpper==0 || countLower==0) {
					JOptionPane.showMessageDialog(LoginFrame.this, "Username은 알파벳 소문자, 대문자, 숫자를 적어도 1개씩 포함해야합니다.", "경고", JOptionPane.WARNING_MESSAGE);
					textUser.setText("");
					textUser.requestFocus();
					
				}else {
					System.out.println("" + e); // 발생된 이벤트에 대한 설명을 화면에 출력하고
					System.exit(0); // 프로그램을 종료한다. ///정상적으로 종료된다는 숫자로 0을 넣어줌
				}
			
			}
			else {
			System.out.println("" + e); // 발생된 이벤트에 대한 설명을 화면에 출력하고
			System.exit(0); // 프로그램을 종료한다. ///정상적으로 종료된다는 숫자로 0을 넣어줌
		
			}
		}
	
		
	};
	
	public void actionPerformed(ActionEvent e) { // 버튼이 눌려지면
		System.out.println("" + e); // 발생된 이벤트에 대한 설명을 화면에 출력하고
		System.exit(0); // 프로그램을 종료한다. ///정상적으로 종료된다는 숫자로 0을 넣어줌
	}
}

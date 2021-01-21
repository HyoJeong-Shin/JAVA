package ch16.hw;

import java.awt.Button;

public class ColleagueButton extends Button implements Colleague { ///버튼 중에서도 특수한 버튼이면서, colleague역할하는 버튼
	private Mediator mediator;

	public ColleagueButton(String caption) { ///caption: 버튼에 달리는 ok나 cancel 같은 것
		super(caption);
	}

	// 입력 인자로 들어온 Mediator를 멤버 변수인 mediator에 할당함
	public void setMediator(Mediator mediator) { 
		this.mediator = mediator;
	}

	// Button 클래스에서 물려받은 setEnabled(boolean)를 호출하여 유효/무효를 설정한다.
	public void setColleagueEnabled(boolean enabled) { ///true 또는 false
		setEnabled(enabled); // setEnabled( )는 부모인 Button 클래스로부터 물려받은 메소드이다. ///버튼 활성화할지 비활성화 할지 결정 
	}
}

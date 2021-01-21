package ch16.hw;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ColleagueCheckbox extends Checkbox implements ItemListener,
		Colleague {
	private Mediator mediator;

	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) { // 생성자 //caption은 체크박스 옆에 쓰이는 문자열, 마지막 state는 체크유무 초기값 설정 
		super(caption, group, state);
	}

	public void setMediator(Mediator mediator) { // Mediator를 보관
		this.mediator = mediator;
	}
	
	//중재자가 지시할 때 사용하는 메소드
	// “카운셀러가 내리는 지시”에 해당함
	public void setColleagueEnabled(boolean enabled) { 
		setEnabled(enabled);
	}

	//중재자에게 통지하는 메소드
	// 라디오버튼의 상태가 바뀌었을 때, ItemEvent가 발생되고, 
	// 등록된 ItemListener의 이 메소드가 자동으로 호출된다.
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged(this);  // 상태가 변하면 Mediator에게 통지한다. ///this는 자기 자신을 넘겨주기 위해서 this를 인자로 줌(상황이 바뀌거나 변화가 일어났을 때 내가 변함을 알려줌)
	}
}

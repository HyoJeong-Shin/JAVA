import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
// 메뉴 다이얼로그 
public class FinalTest_1 extends JFrame {
	private JLabel textLabel = new JLabel("Text");	// 초기 label 값 "Text"
	Container c ;
	public FinalTest_1() {
		setTitle("20181030 신효정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(textLabel);	// 라벨 FlowLayout.CENTER
		
		textLabel.setToolTipText("편집에 따라 변경될 영역입니다");	// 라벨에 대한 툴팁 설정 
		
		createMenu();	// 메뉴 만들어서 등록
		
		setSize(400, 300);
		setVisible(true);
	}
	class MyDialog extends JDialog{
		JLabel la1 = new JLabel("폰트 종류");
		
		String [] font_type = {"굴림", "돋움", "고딕", "명조"}; // 콤보박스의 아이템
		JComboBox<String> strCombo = new JComboBox<String>(font_type); // 문자열 콤보박스 
		
		JLabel la2 = new JLabel("폰트 스타일");
		
		JCheckBox bold = new JCheckBox("BOLD");
		JCheckBox italic = new JCheckBox("ITALIC");
		int valBold = Font.PLAIN;	// 체크박스 선택하지 않았을 때 기본 설정값
		int valItalic = Font.PLAIN; // 체크박스 선택하지 않았을 때 기본 설정값
		
		JLabel la3 = new JLabel("폰트 크기");
		
		JTextField tf = new JTextField(12);
		
		JButton ok = new JButton("설정");
		
		String font;	// 폰트 타입 변수
		int size;		// 폰트 크기 변수 
		
		public MyDialog(JFrame frame, String title) {
			super(frame, title, true);	// 모달 다이얼로그 설정
			setLayout(new BorderLayout());
			JPanel panel = new JPanel(new GridLayout(3,1));	// 폰트 종류, 스타일, 크기 패널을 그리드 레이아웃으로 붙여줌
			
			// 폰트 종류에 대한 패널	// 레이블은 서쪽에, 그에 해당하는 내용은 센터로 설정하여 구현함
			JPanel p1 = new JPanel(new BorderLayout());
			JPanel p1_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p1_1.add(la1);
			p1.add(p1_1, BorderLayout.WEST);
			JPanel p1_2 = new JPanel(new FlowLayout());
			strCombo.setPreferredSize(new Dimension(120,20));
			p1_2.add(strCombo);
			p1.add(p1_2, BorderLayout.CENTER);
			panel.add(p1);
			
			// 폰트 스타일에 대한 패널	// 레이블은 서쪽에, 그에 해당하는 내용은 센터로 설정하여 구현함
			JPanel p2 = new JPanel(new BorderLayout());
			JPanel p2_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p2_1.add(la2);
			p2.add(p2_1, BorderLayout.WEST);
			JPanel p2_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p2_2.add(bold); p2_2.add(italic);
			p2.add(p2_2, BorderLayout.CENTER);
			panel.add(p2);
			
			// 폰트 크기에 대한 패널	// 레이블은 서쪽에, 그에 해당하는 내용은 센터로 설정하여 구현함
			JPanel p3 = new JPanel(new BorderLayout());
			JPanel p3_1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
			p3_1.add(la3);
			p3.add(p3_1, BorderLayout.WEST);
			JPanel p3_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
			p3_2.add(tf);
			p3.add(p3_2, BorderLayout.CENTER);
			panel.add(p3);
			

			add(panel, BorderLayout.NORTH);
			
			// 설정 버튼에 대한 패널 
			JPanel p4 = new JPanel(new FlowLayout());
			p4.add(ok);
			add(p4, BorderLayout.SOUTH);
			
			setSize(230, 200);
			
			// 폰트 종류(콤보박스)에 대한 이벤트 처리
			strCombo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JComboBox<String> cb = (JComboBox<String>)e.getSource(); 
					int index = cb.getSelectedIndex();  // 선택된 콤보박스의 인덱스 값 가져옴
					font = font_type[index];	// 폰트 타입 배열에 선택된 인덱스에 해당하는 값을 가져와 font 변수에 저장
				}
			});
			
			// 폰트 크기 (textfield)에 대한 이벤트 처리
			tf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JTextField t = (JTextField)e.getSource();
					size = Integer.parseInt(t.getText());	// Jtextfield에 입력한 텍스트 값을 가져옴 	// 이때 폰트 크기는 int값이어야 하므로 Integet.parseInt를 통해 정수 변환을 해줌
				}
			});
			
			// bold 폰트 스타일 (체크박스)에 대한 이벤트 처리
			bold.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) { 	// 선택시,
						valBold = Font.BOLD;  	// bold 설정
					} else {        // 해제시,                                            
						valBold = Font.PLAIN;	// 기본값으로 설정
					}
				}
			});
			
			// italic 폰트 스타일 (체크박스)에 대한 이벤트 처리
			italic.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					if (e.getStateChange() == ItemEvent.SELECTED) {	// 선택시,
						valItalic = Font.ITALIC;	// Italic체 설정
					} else {			// 해제시,
						valItalic = Font.PLAIN;		// 기본값으로 설정
					}
				}
			});
			
			// 설정 버튼 클릭에 대한 이벤트 처리
			ok.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					setVisible(false);	// 다이얼로그 안보이게 함
					textLabel.setFont(new Font(font, valBold + valItalic, size));	// 이벤트 처리로 저장해 놓은 변수들을 사용하여 textLabel 폰트 설정
				}
			});
		}
	}
	void createMenu() {
		JMenuBar mb = new JMenuBar();	// 메뉴바 생성
		
		JMenuItem [] menuItem = new JMenuItem[3];
		JMenuItem [] menuItem3 = new JMenuItem[1]; 
		String[] itemTitle1 = {"열기", "저장", "종료"};
		String[] itemTitle2 = {"색 선택", "폰트", "텍스트 변경"};
		String[] itemTitle3 = {"버전 정보"};
		
		// 메뉴  파일, 편집, 도움말 3개 구성
		JMenu fMenu = new JMenu("파일");
		JMenu eMenu = new JMenu("편집");
		JMenu hMenu = new JMenu("도움말");
		
		MyListener ml = new MyListener();
		
		// 파일 메뉴에 메뉴 아이템 등록
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle1[i]);
			menuItem[i].addActionListener(ml);
			fMenu.add(menuItem[i]);
			if(i==1) fMenu.addSeparator();	// 구분선 표시

		}
		
		// 편집 메뉴에 메뉴 아이템 등록
		for(int i=0; i<menuItem.length; i++) {
			menuItem[i] = new JMenuItem(itemTitle2[i]);
			menuItem[i].addActionListener(ml);
			eMenu.add(menuItem[i]);
		}
		
		// 도움말 메뉴에 메뉴 아이템 등록
		for(int i=0; i<menuItem3.length; i++) {
			menuItem3[i] = new JMenuItem(itemTitle3[i]);
			menuItem3[i].addActionListener(ml);
			hMenu.add(menuItem3[i]);
		}
		
		// 메뉴바에 메뉴 등록
		mb.add(fMenu);
		mb.add(eMenu);
		mb.add(hMenu);
		
		setJMenuBar(mb);
	}
	class MyListener implements ActionListener{
		JFileChooser fc = new JFileChooser();
		
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			switch(cmd) {	// switch case를 통한 문자열 비교
			case "열기":
				int ret = fc.showOpenDialog(null);
				if(ret == JFileChooser.APPROVE_OPTION) {	// 열기 버튼을 눌렀다면
					String filePath = fc.getSelectedFile().getPath();	// 선택한 파일의 경로 읽어옴
					textLabel.setText(filePath + "파일이 선택 되었습니다");	// 선택한 파일의 경로로 텍스트 라벨 변경함
				}
				else {	// 취소 버튼을 눌렀다면
					JOptionPane.showMessageDialog(null, "파일 열기가 취소되었습니다.");
				}
				break;
			case "저장":
				ret = fc.showSaveDialog(null);
				if(ret == JFileChooser.APPROVE_OPTION) {	// 저장 버튼을 눌렀다면
					String filePath = fc.getSelectedFile().getPath();	// 파일을 저장할 경로 읽어옴
					textLabel.setText(filePath + "파일에 저장 되었습니다");	// 파일을 저장할 경로로 텍스트 라벨 변경함
				}
				else {	// 취소 버튼을 눌렀다면
					JOptionPane.showMessageDialog(null, "파일 열기가 취소되었습니다.");
				}
				break;
			case "종료":
				// 확인 다이얼로그 	// 사용자로부터 Yes/No 등 확인 입력 받음
				int res = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?", "종료 확인", JOptionPane.YES_NO_OPTION);
				if(res == JOptionPane.YES_OPTION)	// "예" 버튼을 누르면 프로그램 종료
					System.exit(0);
				break;
			case "색 선택":
				// 컬러 선택기 보여주기
				Color color = JColorChooser.showDialog(null, "색상 선택", Color.gray);
				// 선택된 색상으로 textLabel 글자색 변경하기
				if(color != null) {
					textLabel.setForeground(color);
				}
				break;
			case "폰트":
				MyDialog dialog = new MyDialog(null, "");	// 대화상자 생성
				dialog.setVisible(true);	// 다이얼로그 띄움
				break;
			case "텍스트 변경":
				// 입력 다이얼로그	// 한 줄을 입력 받음
				String chtext = JOptionPane.showInputDialog("변경할 텍스트를 입력하세요");	// chtext에 입력값 리턴함
				if(chtext != null) {
					textLabel.setText(chtext);	// 입력 다이얼로그에서 입력한 텍스트로 텍스트 라벨 변경함
				}
				break;
			case "버전 정보":
				// 메시지 다이얼 로그 	// 단순 메시지 출력
				JOptionPane.showMessageDialog(null, "테스트 v1.0", "버전 정보", JOptionPane.INFORMATION_MESSAGE);
				break;
			}
		}
	}
	
	
	public static void main(String[] args) {
		new FinalTest_1();
	}

}

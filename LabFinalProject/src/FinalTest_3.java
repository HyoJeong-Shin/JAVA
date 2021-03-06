import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Vector;
// 산성비 게임 
public class FinalTest_3 extends JFrame {
	private GamePanel gamePanel = null;
	private ControlPanel controlPanel = null;
	int score = 0;	// 점수
	int level = 1;	// 레벨 
	private JLabel scoreLabel;
	private JLabel levelLabel;
	
	public FinalTest_3() {
		super("20181030 신효정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		gamePanel = new GamePanel();
		c.add(gamePanel,  BorderLayout.CENTER); // GamePanel을 컨텐트팬의 CENTER에 배치한다.
		controlPanel = new ControlPanel(gamePanel);		
		c.add(controlPanel,  BorderLayout.SOUTH); // GamePanel을 컨텐트팬의 SOUTH에 배치한다.
		
		setSize(400,400);
		setVisible(true);
		
		gamePanel.startGame();
	}
	
	class ControlPanel extends JPanel {
		private GamePanel gamePanel;
		private JTextField input = new JTextField(15); // 사용자가 단어를 입력하는 창
		
		public ControlPanel(GamePanel gamePanel) {
			this.gamePanel = gamePanel;
			this.setLayout(new FlowLayout());
			this.setBackground(Color.LIGHT_GRAY);
			add(input);
			
			input.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					//JTextField tf = (JTextField)e.getSource();
					String text = input.getText();
					if(text.equals("그만"))
						System.exit(0); // 프로그램 종료
					
					if(!gamePanel.isGameOn())	// 게임 중이 아니라면
						return;		// 이벤트 처리 코드 종료
						
					// 떨어지는 문자열이 입력한 문자열과 동일한지 비교 
					boolean match = gamePanel.matchWord(text);
					if(match == true) {
						gamePanel.printResult("성공");
						gamePanel.stopGame(); // 게임 중지 (프로그램 종료가 아님)
						gamePanel.startGame(); // 새 단어 시작(다음 단어)
						input.setText(""); // 창에 입력된 텍스트 지우기
						score += 10;	// 단어를 정확한 문자열로 입력할 시 점수 10점씩 증가
						if(level==1&&score>=50) {	// level이 1이고 점수가 50이상이 되면,
							scoreLabel.setText("Score: " + score);
							level++;	// level2로 올라감
							score = 0;	// score는 다시 0으로 설정
							// 레벨 올라가는 메시지 다이얼로그 출력
							JOptionPane.showMessageDialog(null, "레벨 2로 이동합니다", "Message", JOptionPane.INFORMATION_MESSAGE);
							levelLabel.setText("Level: " + level);
						}else if(level==2 && score==100) {	// level 2이고 점수가 100이 되면,
							scoreLabel.setText("Score: " + score);
							// 게임이 종료되는 메시지 다이얼로그 출력
							JOptionPane.showMessageDialog(null, "게임이 성공적으로 종료되었습니다", "Message", JOptionPane.INFORMATION_MESSAGE);
							System.exit(0);	// OK버튼 누를시 프로그램 종료
						}
						scoreLabel.setText("Score: " + score);
					}
					else {
						gamePanel.printResult(input.getText()+ " 틀림");	
						input.setText(""); // 창에 입력된 텍스트 지우기
						score -= 10;	// 입력한 단어가 틀릴 시 점수 10점씩 감점
						scoreLabel.setText("Score: " + score);
					}
				}
			});
		}
	}
	
	// 컨텐트팬을 사용되는 패널 클래스
	class GamePanel extends JPanel {
		private JLabel label = new JLabel(); // 떨어지는 단어 1
		private JLabel resLabel = new JLabel(); // 성공 실패를 나타내는 레이블
		
		private Words words = null;
		private String fallingWord = null;
		private FallingThread thread = null; 
		private boolean gameOn = false;
		
		public GamePanel() {
			setLayout(null); // 배치관리자를 사용하지 않고 절대 위치에 컴포넌트를 배치한다.			
			add(label); // 레이블을 부착한다.			
			
			resLabel.setLocation(0, 0);
			resLabel.setSize(100, 30);
			add(resLabel);		// 성공 실패 레이블 부착
			
			levelLabel = new JLabel("Level: " + level);	// 게임 레벨 나타내는 레이블
			levelLabel.setLocation(200, 0);
			levelLabel.setSize(100, 30);
			add(levelLabel);	// 레벨 레이블 부착
			
			
			scoreLabel = new JLabel("Score: " + score); 	// 스코어 기록 나타내는 레이블
			scoreLabel.setLocation(300, 0);		
			scoreLabel.setSize(100, 30);
			add(scoreLabel);	// 스코어 기록 레이블 부착
			
			
			// 파일로부터 단어들을 읽어와서 Vector에 저장하는 클래스 
			words = new Words("words.txt");
		}
		
		public boolean isGameOn() {
			return gameOn;
		}
		
		public void stopGame() {
			if(thread == null)
				return; // 스레드가 없음 
			thread.interrupt(); // 스레드 강제 종료
			thread = null;
			gameOn = false;
		}
		
		public void stopSelfAndNewGame() { // 스레드가 바닥에 닿아서 실패할 때 호출
			startGame();			
		}
		
		public void printResult(String text) {
			resLabel.setText(text);
		}
		
		public void startGame() {
			// 색상 랜덤색 설정
			int r = (int)(Math.random()*256);	
            int g = (int)(Math.random()*256);
            int b = (int)(Math.random()*256);

			fallingWord = words.getRandomWord();
			label.setText(fallingWord);
			label.setSize(200, 30); // 레이블 크기
			label.setLocation((int)(Math.random()*260), 0); // 레이블 위치
			label.setForeground(new Color(r,g,b)); //레이블의 글자 색을 설정한다. (랜덤색으로 설정)				
			label.setFont(new Font("Tahoma", Font.ITALIC, 20)); // 레이블 글자의 폰트를 설정한다.	

			thread = new FallingThread(this, label); // 게임 스레드
			thread.start();
			gameOn = true;
		}
		
		public boolean matchWord(String text) {
			if(fallingWord != null && fallingWord.equals(text))
				return true;
			else
				return false;
		}
		
		class FallingThread extends Thread {
			private GamePanel panel;
			private JLabel label; //게임 숫자를 출력하는 레이블
			private long delay = (int)(Math.random()*303 + 200); // 지연 시간 값 200~500 사이의 랜덤 값 설정
			private boolean falling = false; // 떨이지고 있는지. 초깃값 = false
			
			public FallingThread(GamePanel panel, JLabel label) {
				this.panel = panel;
				this.label = label;
			}
			
			public boolean isFalling() {
				return falling; 
			}	
			
			@Override
			public void run() {
				falling = true;
				while(true) {
					try {
						sleep(delay);
						int y = label.getY() + 5; //5픽셀 씩 아래로 이동
						if(y >= panel.getHeight()-label.getHeight()) {	// 패널을 벗어나면 
							falling = false;
							label.setText("");
							panel.printResult("시간초과실패");
							score -= 10;	// 단어가 바닥에 떨어지면 점수 10점씩 줄어듦
							scoreLabel.setText("Score:" + score);
							panel.stopSelfAndNewGame();
							break; // 스레드 종료
						}
						
						label.setLocation(label.getX(), y);
						GamePanel.this.repaint();
					} catch (InterruptedException e) {
						falling = false;
						return; // 스레드 종료
					}
				}
			}	
		}
	}
	
	// words.txt 파일을 읽고 벡터에 저장하고 벡터로부터 랜덤하게 단어를 추출하는 클래스
	class Words {
		private Vector<String> wordVector = new Vector<String>();

		public Words(String fileName) {
			try {
				Scanner scanner = new Scanner(new FileReader(fileName));
				while(scanner.hasNext()) { // 파일 끝까지 읽음
					String word = scanner.nextLine(); // 한 라인을 읽고 '\n'을 버린 나머지 문자열만 리턴
					wordVector.add(word); // 문자열을 벡터에 저장
				}
				scanner.close();
			}
			catch(FileNotFoundException e) {
				System.out.println("file not found error");
				System.exit(0);
			}
		}
		
		public String getRandomWord() {
			final int WORDMAX = wordVector.size(); // 총 단어의 개수
			int index = (int)(Math.random()*WORDMAX);
			return wordVector.get(index);
		}	
	}

	
	public static void main(String[] args) {
		new	FinalTest_3();
	}
}


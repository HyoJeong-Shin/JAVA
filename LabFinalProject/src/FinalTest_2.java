import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JToolBar;
// 그래픽 그리기 
public class FinalTest_2 extends JFrame {
	Container c ;
	Color color;	// colorchooser 선택 컬러 저장 변수
	int x1, y1, x2, y2;
	JButton btn1, btn2, btn3, btn4;
	String btn;		// 어느 버튼이 클릭되었는지를 구분해주기 위한 변수
	
	public FinalTest_2() {
		setTitle("20181030 신효정");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		c = getContentPane();
		c.add(new MyCanvas());	// MyCanvas panel 컨테이너에 부착 
		
		createToolBar();	// 툴바 만들어서 등록
		addMouseListener(new MyMouseListener());
		
		setSize(500, 400);
		setVisible(true);
	}
	
	class MyMouseListener extends MouseAdapter{	// 마우스어댑터를 상속 받은 MyMouseListener 클래스
		@Override
		public void mouseDragged(MouseEvent e) {	// 마우스 드래그시,
			super.mouseDragged(e);
			x2 = e.getX();	// 드래그 하는 지점의 x값 저장
			y2 = e.getY();	// 드래그 하는 지점의 y값 저장
			
			repaint();		// 패널의 다시 그리기를 요청
		}

		@Override
		public void mousePressed(MouseEvent e) {	// 마우스 누를 시,
			super.mousePressed(e);
			x1 = e.getX();	// 누르는 지점의 x값 저장
			y1 = e.getY();	// 누르는 지점의 y값 저장
		}
	}
	
	class MyCanvas extends JPanel{	// JPanel을 상속받은 Canvas 클래스 (그림을 그릴 수 있는 패널 구현)
		
		MyMouseListener mymlistener = new MyMouseListener();	// 마우스 리스너
		
		//마우스 리스너 불러줌
		public MyCanvas(){
			addMouseListener(mymlistener);
			addMouseMotionListener(mymlistener);
		}

		//새로 그림 그리는 곳 
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(btn!=null) {	// 버튼이 눌렸을 때
				if(btn.equals("button1")) {	// 선 그리기 버튼을 눌렀을 때
					g.setColor(color);			// colorchooser 변수 가져와 그 값으로 색상 설정
					g.drawLine(x1,y1,x2,y2);	// 직선 그리기 
				}else if(btn.equals("button2")) {	// 사각형 그리기 버튼을 눌렀을 때
					g.setColor(color);
					// 시작 지점에 따라 달라지는 drawRect
					if(x2>x1) {	
						if(y1>y2) {
							g.drawRect(x1, y2,x2-x1,y1-y2);	// 시작지점이 왼쪽 하단일 때
						}else {
							g.drawRect(x1, y1,x2-x1,y2-y1);	// 시작지점이 왼쪽 상단일 때
						}
					}else {
						if(y1>y2) {
							g.drawRect(x2, y2, x1-x2, y1-y2);	// 시작지점이 오른쪽 하단일 때
						}else {
							g.drawRect(x2, y1, x1-x2, y2-y1);	// 시작지점이 오른쪽 상단일 때
						}
					}
				}else if(btn.equals("button3")) {	// 타원 그리기 버튼을 눌렀을 때
					g.setColor(color);
					// 시작 지점에 따라 달라지는 drawOval
					if(x2>x1) {
						if(y1>y2) {
							g.drawOval(x1, y2,x2-x1,y1-y2);	// 시작지점이 왼쪽 하단일 때
						}else {
							g.drawOval(x1, y1,x2-x1,y2-y1);	// 시작지점이 왼쪽 상단일 때
						}
					}else {
						if(y1>y2) {
							g.drawOval(x2, y2, x1-x2, y1-y2);	// 시작지점이 오른쪽 하단일 때
						}else {
							g.drawOval(x2, y1, x1-x2, y2-y1);	// 시작지점이 오른쪽 상단일 때
						}
					}
				}else if(btn.equals("button4")) {	// 삼각형 그리기 버튼을 눌렀을 때
					g.setColor(color);
					// 시작 지점에 따라 달라지는 fillPolygon
					if(x1>x2) {
						if(y1>y2) {	// 시작지점이 오른쪽 하단일 때
							int[] point_x = {x1,(x1+x2)/2,x2};	// 삼각형의 꼭짓점이 될 3개의 x좌표 값
							int[] point_y = {y1, y2, y1};		// 삼각형의 꼭짓점이 될 3개의 y좌표 값
							g.fillPolygon(point_x, point_y, 3);	// fillPolygon : 내부 색칠되는 다각형 그림 	// 3 : 삼각형 그림
						}else {		// 시작지점이 오른쪽 상단일 때
							int[] point_x = {x2,(x1+x2)/2,x1};
							int[] point_y = {y2, y1, y2};
							g.fillPolygon(point_x, point_y, 3);
						}
					}else {
						if(y1>y2) {	// 시작지점이 왼쪽 하단일 때
							int[] point_x = {x1,(x1+x2)/2,x2};
							int[] point_y = {y1, y2, y1};
							g.fillPolygon(point_x, point_y, 3);
						}else {		// 시작지점이 왼쪽 상단일 때 
							int[] point_x = {x2,(x1+x2)/2,x1};
							int[] point_y = {y2, y1, y2};
							g.fillPolygon(point_x, point_y, 3);
						}
					}
				}
			}
		}
	}

	
	class ButtonAction implements ActionListener{	// 액션리스너 구현한 버튼 ButtonAction 클래스
		public void actionPerformed (ActionEvent e) {
			JButton jb = (JButton)e.getSource();	// 누른 버튼 
			
			if(jb == btn1) {		// 누른 버튼이 btn1일 경우,
				btn = "button1";	// 어느 버튼이 클릭되었는지 구분해주기 위한 변수에 button1 값 넣어줌
				addMouseListener(new MyMouseListener());	// 마우스 리스너 연결
			}else if(jb== btn2) {	// 누른 버튼이 btn2일 경우,
				btn = "button2";	// button2 값 넣어줌
				addMouseListener(new MyMouseListener());
			}else if(jb==btn3) {	// 누른 버튼이 btn3일 경우,
				btn = "button3";	// button3 값 넣어줌
				addMouseListener(new MyMouseListener());
			}else if(jb==btn4) {	// 누른 버튼이 btn4일 경우,
				btn = "button4";	// button4 값 넣어줌
				addMouseListener(new MyMouseListener());
			}
		}
	}
	
	void createToolBar() {
		JToolBar bar = new JToolBar("graphic");		// JToolBar 생성
		
		JLabel label1 = new JLabel("도형");
		
		btn1 = new JButton(new ImageIcon("images/line.png"));	// 선 이미지가 담긴 버튼 생성
		btn1.addActionListener(new ButtonAction());		// btn1에 ButtonAction 액션리스너 연결
		btn2 = new JButton(new ImageIcon("images/rect.png"));	// 사각형 이미지가 담긴 버튼 생성
		btn2.addActionListener(new ButtonAction());
		btn3 = new JButton(new ImageIcon("images/oval.png"));	// 타원 이미지가 담긴 버튼 생성
		btn3.addActionListener(new ButtonAction());
		btn4 = new JButton(new ImageIcon("images/triangle.png"));	// 삼각형 이미지가 담긴 버튼 생성
		btn4.addActionListener(new ButtonAction());
		
		JLabel label2 = new JLabel("색 선택");
		JButton btn5 = new JButton(new ImageIcon("images/color.png"));	// 색 선택 이미지가 담긴 버튼 생성
		
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Color", Color.black);	// 컬러 선택기 보여주기	// Default 색상 : 검정색	// 선택한 색상 color 변수에 저장
			}
		});
		
		// 툴바에 부착
		bar.add(label1); bar.add(btn1); bar.add(btn2); bar.add(btn3); bar.add(btn4); 
		bar.add(label2); bar.add(btn5);
		
		// 컨테이너에 툴바 부착
		c.add(bar, BorderLayout.NORTH);
	}
	
	public static void main(String[] args) {
		new FinalTest_2();
	}

}


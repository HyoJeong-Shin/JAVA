package ch22.hw;
import ch22.hw.command.*;
import ch22.hw.drawer.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {
    // 그리기 이력
    private MacroCommand history = new MacroCommand();
    //  그리기 영역
    private DrawCanvas canvas = new DrawCanvas(400, 400, history);
    // 제거 버튼
    private JButton clearButton  = new JButton("clear");
    // 빨간 버튼                                           
    private JButton redButton  = new JButton("red");        
    // 녹색 버튼                                           
    private JButton greenButton  = new JButton("green");    
    // 파란 버튼                                          
    private JButton blueButton  = new JButton("blue");  
    
    private JButton undoButton  = new JButton("undo");
    
    private JButton redoButton  = new JButton("redo");

    // 생성자
    public Main(String title) {
        super(title);

        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);
        redButton.addActionListener(this);      
        greenButton.addActionListener(this);    
        blueButton.addActionListener(this); 
        redoButton.addActionListener(this);
        undoButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        buttonBox.add(redButton);   
        buttonBox.add(greenButton); 
        buttonBox.add(blueButton);  
        buttonBox.add(undoButton);
        buttonBox.add(redoButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        getContentPane().add(mainBox);
        
        Command cmd = new ColorCommand(canvas, Color.red);  
        history.append(cmd); 
        
        pack();
        setVisible(true);
    }

    // ActionListener용
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton) {
            history.clear();
            canvas.init();                                      
            canvas.repaint();
        } else if (e.getSource() == redButton) {                
            Command cmd = new ColorCommand(canvas, Color.red);  
            history.append(cmd);                                
            cmd.execute();                                      
        } else if (e.getSource() == greenButton) {              
            Command cmd = new ColorCommand(canvas, Color.green);
            history.append(cmd);                                
            cmd.execute();                                      
        } else if (e.getSource() == blueButton) {               
            Command cmd = new ColorCommand(canvas, Color.blue); 
            history.append(cmd);                                
            cmd.execute();                                      
        }else if (e.getSource() == undoButton) {       
            history.undo();                             
            canvas.repaint();                           
        }else if (e.getSource() == redoButton) {       
            history.redo();                             
            canvas.repaint();                           
        }
    }

    // MouseMotionListener용
    public void mouseMoved(MouseEvent e) {
    }
    public void mouseDragged(MouseEvent e) {
        Command cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    // WindowListener용
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
    public void windowActivated(WindowEvent e) {}
    public void windowClosed(WindowEvent e) {}
    public void windowDeactivated(WindowEvent e) {}
    public void windowDeiconified(WindowEvent e) {}
    public void windowIconified(WindowEvent e) {}
    public void windowOpened(WindowEvent e) {}

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}


/**
 * Write a description of class View here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class View extends JFrame
{
    // This panel is used to hold the current page title and remaining points
    JPanel pageStartPanel;
    // This panel is renewed when new things are shown so the reference is needed. 
    JPanel cards;
    // This label is used to hold the remainging points
    JLabel points;
    JLabel currentPaneTitle;
    Controller controller;
    // constructor
    public View(Controller controller)
    {
        this.controller = controller;
        // initialize the page start panel and add a border
        pageStartPanel = new JPanel(new BorderLayout());
        pageStartPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        
        // Initial points to 100
        points = new JLabel("Calculating Points...");
        // intialize to begin screen title
        currentPaneTitle = new JLabel("Starting up...");
        
        // add the points and title label to the pageStartPanel
        pageStartPanel.add(points, BorderLayout.LINE_END);
        pageStartPanel.add(currentPaneTitle, BorderLayout.LINE_START);
        
        // initialize the centerPanel
        cards = new JPanel(new CardLayout());
        
        this.getContentPane().add(cards, BorderLayout.CENTER);
        this.getContentPane().add(pageStartPanel, BorderLayout.PAGE_START);
        
        
        
       
        
        
        this.setTitle("Delayed Consequence");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(600, 600));
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
        // frame.setUndecorated(true);
        this.setVisible(true);
    }
    
    public void setCurrentTitle(String title)
    {
        currentPaneTitle.setText(title);
    }
    
    public void setPoints(int points)
    {
        this.points.setText("Remaining Points: " + points);
    }
    
    public void showInstructionSheet()
    {
         JPanel newPanel = new JPanel(new BorderLayout());
         newPanel.setBorder(new EmptyBorder(50,50,50,50));
        JTextArea textArea = new JTextArea("Once you begin the computer program you will be exposed to a variety of different choice options.  Please select the option you most prefer, although you may change your decision at any time.  After you select a shape, you will occasionally be given material to read. Continue selecting shapes and reading material until this program automatically ends." + 
        "\n\nAt the top of your screen (top right), you will see a number of points.  These points correspond to raffle tickets.  The more points you have, the more raffle tickets you will have and the better your chances will be of winning the prize (Kindle Fire).  The choices you make on the computer will affect the number of points you have.  You cannot earn points; you can only lose points.  You may leave at any time, but you must complete the program to retain any points." + 
        "\n\nParticipation in this study will take approximately 2 hours.  Once you begin this program, you should continue and refrain from talking to other participants." + 
        "\n\nWhen you are ready to begin the program, press begin");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        textArea.setBackground(new Color(0,0,0,0));
        
      
        JPanel beginButtonPanel = new JPanel(new BorderLayout());
        JButton beginButton = new JButton("Begin");
        beginButton.addActionListener(new BeginButtonAction());
        
        newPanel.add(textArea, BorderLayout.CENTER);
        beginButtonPanel.add(beginButton, BorderLayout.LINE_END);
        newPanel.add(beginButtonPanel, BorderLayout.PAGE_END);
        cards.add(newPanel, "Instruction Sheet");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
   
    
    public void establishPreference(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
         JPanel newPanel = new JPanel(new GridLayout(1,2,10,10));
         newPanel.setBorder(new EmptyBorder(50,50,50,50));
            
        
         JButton left = new JButton("" + leftButtonChar);
         JButton right = new JButton("" + rightButtonChar);
         left.setFont(new Font("Dialog", Font.BOLD, 200));
         left.addActionListener(new ButtonAction(group, leftIndex));
         right.addActionListener(new ButtonAction(group, rightIndex));
         right.setFont(new Font("Dialog", Font.BOLD, 200));
         
         newPanel.add(left);
         newPanel.add(right);
         
         cards.add(newPanel, "Baseline Condition");
         CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    
    
    
    // nested class
    public class BeginButtonAction implements ActionListener
    {
       
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("DEBUG: BeginButtonAction.actionPerformed() - begin button clicked, invoke getBaselineCondition().");
            controller.getBaselineCondition();
        }
    }
    
    public class ButtonAction implements ActionListener
    {
        int group;
        int index;
        // constructor
        public ButtonAction(int group, int index)
        {
            this.group = group;
            this.index = index;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            System.out.println("DEBUG - ButtonAction.actionPerformed() - Symbol clicked incrementHitCount(" + group + "," + index + ")");
            controller.incrementHitCount(group, index);
            System.out.println("DEBUG - ButtonAction.actionPerformed() - invokeContinueBaselineCondition");
            controller.continueBaselineCondition();
        }
    }
    
}

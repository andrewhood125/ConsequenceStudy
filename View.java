/**
 * View handles the presentation and flow of the program once in
 * a specified part of the presentation. Once done it hands back 
 * control of the flow of the program back to the controller.
 * 
 * @author Andrew Hood, Neal Patel
 * Copyright (c) 2013 Andrew Hood, Neal Patel
 * 
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
import java.io.File;

import java.util.ArrayList;
import java.util.Random;
import java.util.Queue;

import javax.sound.sampled.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JViewport;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Scrollbar;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;

import javax.imageio.ImageIO;


public class View extends javax.swing.JFrame
{
    // This panel is used to hold the current page title and remaining points
    private JPanel pageStartPanel;
    // This panel is renewed when new things are shown so the reference is needed. 
    private JPanel cards;
    // This label is used to hold the remainging points
    private JLabel points;
    private JLabel currentPaneTitle;
    private Controller controller;
    private JScrollPane sp;
    private JTextArea reading;
    private boolean showHint = false;
    private int currX = 0, line = 0;
    // constructor
    public View(Controller controller)
    {
        this.controller = controller;
        // initialize the page start panel and add a border
        pageStartPanel = new JPanel(new BorderLayout());
        pageStartPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        // Initial points to 100
        points = new JLabel("Calculating Points...");
        points.setFont(new Font("Dialog", Font.PLAIN, 32));
        // add the points and title label to the pageStartPanel
        pageStartPanel.add(points, BorderLayout.LINE_END);
        // initialize the centerPanel
        cards = new JPanel();
        cards.setLayout(new java.awt.CardLayout());
        reading = new JTextArea();
        this.getContentPane().add(cards, BorderLayout.CENTER);
        this.getContentPane().add(pageStartPanel, BorderLayout.PAGE_START);
        this.setTitle("");
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });
        this.setSize(800, 600);
        this.setMinimumSize(new Dimension(800, 600));
        // frame.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setLocationRelativeTo(null);
        // frame.setUndecorated(true);
        this.setVisible(true);
        //this.setResizable(false);
    }
    
    public void exitProcedure()
    {
        controller.closeCSV();
        System.exit(0);
    }
    
    public void crashDialog(String errorMessage)
    {
        JOptionPane.showMessageDialog(this, errorMessage,  "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    
    
    public void setBeginPanelColorDefault()
    {
        pageStartPanel.setBackground(javax.swing.UIManager.getColor ( "Panel.background" ));
    }
    
    public void gameOver(int points)
    {
        pageStartPanel.setBackground(javax.swing.UIManager.getColor ( "Panel.background" ));
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBorder(new EmptyBorder(50,50,50,50));  
        JTextArea reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, Setup.getFeedbackFont()));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        JScrollPane sp = new javax.swing.JScrollPane(reading,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportView(reading);
        reading.setEditable(false);
        reading.append("You managed to save " + points + " points.");
        controller.writePreferences();
        controller.writeToCSV("Points left: " + points);
        newPanel.add(reading, BorderLayout.CENTER);
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards); 
        
    }
        
    public void setPoints(int points)
    {
        this.points.setText("Remaining Points: " + points);
    }
    
    public void showInstructionSheet()
    {
        JPanel newPanel = new JPanel(new BorderLayout());         
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        JTextArea introTextArea = new JTextArea();
        introTextArea.setWrapStyleWord(true);
        introTextArea.setLineWrap(true);
        introTextArea.setEditable(false);
        introTextArea.setFont(new Font("Dialog", Font.PLAIN, 14));
        newPanel.add(introTextArea);
        JScrollPane sp = new javax.swing.JScrollPane(introTextArea,JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setViewportView(introTextArea);
        ArrayList<String> introduction = Setup.getITS();
        introTextArea.setEditable(false);
        for(int i = 0; i < introduction.size(); i++)
        {
            introTextArea.append(introduction.get(i));
            introTextArea.append("\n");
        }
        JPanel beginButtonPanel = new JPanel(new BorderLayout());
        JButton beginButton = new JButton("Begin");
        beginButton.addActionListener(new BeginButtonAction());        
        newPanel.add(introTextArea, BorderLayout.CENTER);
        beginButtonPanel.add(beginButton, BorderLayout.LINE_END);
        newPanel.add(beginButtonPanel, BorderLayout.PAGE_END);
        cards.add(newPanel, "Instruction Sheet");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    } 
    
     // nested class
    public class BeginButtonAction implements ActionListener
    {

        public void actionPerformed(ActionEvent e)
        {
            if(Setup.isRandomPres())
            {
                 controller.getBaselineCondition();
            } else {
                controller.manualProgram();
            }
           
        }
    }
    
   
    
    public void establishPreference(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();  
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        
        newPanel.setBorder(new EmptyBorder(50,50,50,50));   
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new ButtonAction(group, leftIndex, rightIndex, left));
        right.addActionListener(new ButtonAction(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        Random rand = new Random();
        int which = rand.nextInt(9);
        switch(which)
        {
            case 0: newPanel.add(left);
                    newPanel.add(right);
                    newPanel.add(leftFiller);
                    newPanel.add(rightFiller); break;
            case 1: newPanel.add(rightFiller);
                    newPanel.add(left);
                    newPanel.add(right);
                    newPanel.add(leftFiller); break;
            case 2: newPanel.add(leftFiller);
                    newPanel.add(rightFiller);
                    newPanel.add(left);
                    newPanel.add(right); break;
            case 3: newPanel.add(right);
                    newPanel.add(leftFiller);
                    newPanel.add(rightFiller);
                    newPanel.add(left); break;
            case 4: newPanel.add(rightFiller);
                    newPanel.add(right);
                    newPanel.add(leftFiller);
                    newPanel.add(left);break;
            case 5: newPanel.add(left);
                    newPanel.add(rightFiller);
                    newPanel.add(right);
                    newPanel.add(leftFiller);break;
            case 6: newPanel.add(leftFiller);
                    newPanel.add(left);
                    newPanel.add(rightFiller);
                    newPanel.add(right);break;
            case 7: newPanel.add(right);
                    newPanel.add(leftFiller);
                    newPanel.add(left);
                    newPanel.add(rightFiller);break;
            case 8: newPanel.add(rightFiller);
                    newPanel.add(left);
                    newPanel.add(leftFiller);
                    newPanel.add(right);break;
            case 9: newPanel.add(left);
                    newPanel.add(right);
                    newPanel.add(leftFiller);
                    newPanel.add(rightFiller);break;
            case 10:newPanel.add(left);
                    newPanel.add(rightFiller);
                    newPanel.add(leftFiller);
                    newPanel.add(right);break;
            case 11:newPanel.add(left);
                    newPanel.add(leftFiller);
                    newPanel.add(right);
                    newPanel.add(rightFiller);break;
            case 12:newPanel.add(left);
                    newPanel.add(leftFiller);
                    newPanel.add(rightFiller);
                    newPanel.add(right);break;
            case 13:newPanel.add(right);
                    newPanel.add(left);
                    newPanel.add(rightFiller);
                    newPanel.add(leftFiller);break;
            case 14:newPanel.add(right);
                    newPanel.add(left);
                    newPanel.add(leftFiller);
                    newPanel.add(rightFiller);break;
            case 15:newPanel.add(left);
                    newPanel.add(rightFiller);
                    newPanel.add(left);
                    newPanel.add(leftFiller);break;
            case 16:newPanel.add(right);
                    newPanel.add(rightFiller);
                    newPanel.add(leftFiller);
                    newPanel.add(left);break;
            case 17:newPanel.add(right);
                    newPanel.add(rightFiller);
                    newPanel.add(leftFiller);
                    newPanel.add(left);break;
            case 18:newPanel.add(rightFiller);
                    newPanel.add(right);
                    newPanel.add(left);
                    newPanel.add(leftFiller);break;
            case 19:newPanel.add(rightFiller);
                    newPanel.add(leftFiller);
                    newPanel.add(left);
                    newPanel.add(right);break;
            case 20:newPanel.add(rightFiller);
                    newPanel.add(leftFiller);
                    newPanel.add(right);
                    newPanel.add(left);break;
            case 21:newPanel.add(leftFiller);
                    newPanel.add(left);
                    newPanel.add(right);
                    newPanel.add(rightFiller);break;
            case 22:newPanel.add(rightFiller);
                    newPanel.add(right);
                    newPanel.add(left);
                    newPanel.add(leftFiller);break;
            case 23:newPanel.add(leftFiller);
                    newPanel.add(right);
                    newPanel.add(rightFiller);
                    newPanel.add(left);break;
            case 24:newPanel.add(leftFiller);
                    newPanel.add(rightFiller);
                    newPanel.add(right);
                    newPanel.add(left);break;
            
        }
        
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }    
    
    public void presentCondition(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(1,2,40,40));
        newPanel.setBorder(new EmptyBorder(50,50,50,50));   
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD, Setup.getSymbolSize()));
        left.addActionListener(new ButtonAction(group, leftIndex, rightIndex, left));
        right.addActionListener(new ButtonAction(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
     public class ButtonAction implements ActionListener
    {
        int group;
        int index;
        int otherIndex;
        JButton button;
        // constructor
        public ButtonAction(int group, int index, int otherIndex, JButton button)
        {
            this.group = group;
            this.index = index;
            this.otherIndex = otherIndex;
            this.button = button;
        }
        public void actionPerformed(ActionEvent e)
        {
            controller.writeToCSV("Group: " + group + "," + Model.getMyShape(group,index) + "," + Model.getMyShape(group, otherIndex) + "," + "Hit: " + Model.getMyShape(group,index));
            button.setEnabled(false);
            
            ActionListener taskPerformer = new ActionListener() { 
            public void actionPerformed(ActionEvent evt) {
                controller.incrementHitCount(group, index);
                if(Setup.isRandomPres()) 
                {
                    controller.continueBaselineCondition();
                } else {
                    controller.manualProgram();
                }
                
                }
            };
            
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();       
        
            
        }
    }
    
    /**
     * DVRC VIEW SEQUENCE ******************************************************************************
     */
    
    public void dvrc(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(142,180,227));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        pageStartPanel.setBackground(new Color(142,180,227));        
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new dvrcButtonOne(group, leftIndex, rightIndex, left));
        right.addActionListener(new dvrcButtonOne(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dvrc2()
    {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(240,240,240));
        pageStartPanel.setBackground(new Color(240,240,240)); 
        reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, 14));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        final ArrayList<String> introduction = Setup.getRI();
        reading.setEditable(false);
        int charCount = 0;
        for(int i = 0; i < introduction.size(); i++)
        {
            for(int j = 0; j < introduction.get(i).length(); j++)
            {
                charCount++;
            }
            reading.append(introduction.get(i));
            reading.append("\n");
           
            if(i == line)
            {
                if(charCount < 1000)
                {
                    currX = charCount;
                } else {
                    currX = charCount+1250;
                }
                
             
            }
        }       
        
        sp = new JScrollPane(reading);
        newPanel.add(sp, BorderLayout.CENTER);
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
        reading.setCaretPosition(currX);
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                line = (int) (sp.getVerticalScrollBar().getValue()/(reading.getHeight()/introduction.size()));
                dvrc3(controller.getCharCubeChar(Model.DVRC_ENUM, controller.getDVRCleft()), controller.getCharCubeChar(Model.DVRC_ENUM, controller.getDVRCright()), Model.DVRC_ENUM, controller.getDVRCleft(), controller.getDVRCright());
            }
        };
        Timer timer = new Timer(Setup.getRD(), taskPerformer);
        timer.setRepeats(false);
        timer.start();       
    }
    
    public void dvrc3(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(217,150,148));
        pageStartPanel.setBackground(new Color(217,150,148));        
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new dvrcButtonTwo(group, leftIndex, rightIndex, left));
        right.addActionListener(new dvrcButtonTwo(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dvrc4()
    {
        final JPanel newPanel = new JPanel(new BorderLayout());
        controller.updatePoints();
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(179,162,199));
        pageStartPanel.setBackground(new Color(179,162,199));   
        JTextArea reading   = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, Setup.getFeedbackFont()));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        reading.setEditable(false);        
        
        if(showHint)
        {
             reading.append(Setup.getDvrcLeastTXT());
        } else {
            reading.append(Setup.getDvrcMostTXT());
        }
        
        newPanel.add(reading, BorderLayout.CENTER);
        showHint = false;
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards); 
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton continueButton = new JButton("Continue");
                continueButton.addActionListener(new feedbackContinueButton());
                newPanel.add(continueButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
            }
        };
        Timer timer = new Timer(Setup.getFeedbackDelay(), taskPerformer);
        timer.setRepeats(false);
        timer.start();       
    }
    
    public class feedbackContinueButton implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            if(Setup.isRandomPres()) {
                controller.presentCondition();
            } else {
                controller.manualProgram();
            }  
        }
    }
    
    public class dvrcButtonTwo implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        
        public dvrcButtonTwo(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            button.setEnabled(false);
            
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                  controller.incrementConditionCount(Model.DVRC_ENUM,index);
                  controller.writeToCSV("DVRC SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                  dvrc4();
                }
            };
            
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();   
        }
    }
    
    public class dvrcButtonOne implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        
        public dvrcButtonOne(int group, int index, int indexOther,  JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            
            button.setEnabled(false);
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(index == controller.dvrcMostPreferred)
                    {
                        showHint = true;
                    }  
                    controller.incrementConditionCount(Model.DVRC_ENUM, index);
                    controller.calculatePointLoss(group, index);
                    controller.writeToCSV("DVRC SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    dvrc2();
                }
            };
            
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();       
        }
    }
    
     /**
     * DVR VIEW SEQUENCE ******************************************************************************
     */
    public void dvr(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(255,255,0));
        pageStartPanel.setBackground(new Color(255,255,0));  
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new dvrButtonOne(group, leftIndex, rightIndex, left));
        right.addActionListener(new dvrButtonOne(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dvr2()
    {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(240,240,240));
        pageStartPanel.setBackground(new Color(240,240,240)); 
        reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, 14));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        sp = new JScrollPane(reading);
        final ArrayList<String> introduction = Setup.getRI();
        reading.setEditable(false);
        
        int charCount = 0;
        for(int i = 0; i < introduction.size(); i++)
        {
            for(int j = 0; j < introduction.get(i).length(); j++)
            {
                charCount++;
            }
            reading.append(introduction.get(i));
            reading.append("\n");
           
            if(i == line)
            {
                if(charCount < 1000)
                {
                    currX = charCount;
                } else {
                    currX = charCount+1250;
                }
            }
        }       
        
        
        
        reading.setCaretPosition(currX);
        newPanel.add(sp, BorderLayout.CENTER);
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);  
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                line = (int) (sp.getVerticalScrollBar().getValue()/(reading.getHeight()/introduction.size()));
                dvr3(controller.getCharCubeChar(Model.DVR_ENUM, controller.getDVRleft()), controller.getCharCubeChar(Model.DVR_ENUM, controller.getDVRright()), Model.DVR_ENUM, controller.getDVRleft(), controller.getDVRright());
            }
        };
        Timer timer = new Timer(Setup.getRD(), taskPerformer);
        timer.setRepeats(false);
        timer.start();       
    }
    
    public void dvr3(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(195,214,155));
        pageStartPanel.setBackground(new Color(195,214,155));        
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new dvrButtonTwo(group, leftIndex, rightIndex, left));
        right.addActionListener(new dvrButtonTwo(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dvr4()
    {
        final JPanel newPanel = new JPanel(new BorderLayout());
        controller.updatePoints();
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(196,189,151));
        pageStartPanel.setBackground(new Color(196,189,151));   
        JTextArea reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, Setup.getFeedbackFont()));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        reading.setEditable(false);
        if(showHint)
        {
            reading.append(Setup.getDvrMostTXT());
        } else {
            reading.append(Setup.getDvrLeastTXT());
        }
        newPanel.add(reading, BorderLayout.CENTER);
        showHint = false;
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards); 
           
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton continueButton = new JButton("Continue");
                continueButton.addActionListener(new feedbackContinueButton());
                newPanel.add(continueButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
            }
        }
        ;
        Timer timer = new Timer(Setup.getFeedbackDelay(), taskPerformer);
        timer.setRepeats(false);
        timer.start();           
    }
    
    public class dvrButtonTwo implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        // constructor
        public dvrButtonTwo(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        public void actionPerformed(ActionEvent e)
        {
            button.setEnabled(false);
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    controller.incrementConditionCount(Model.DVR_ENUM,index);
                    controller.writeToCSV("DVR SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    dvr4();
                }
            };
            
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();    
        }
    }
    
     public class dvrButtonOne implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        // constructor
        public dvrButtonOne(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        public void actionPerformed(ActionEvent e)
        {
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(index == controller.dvrMostPreferred)
                    {
                        showHint = true;
                    }  
                    controller.calculatePointLoss(group, index);
                    controller.writeToCSV("DVR SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    controller.incrementConditionCount(Model.DVR_ENUM, index);
                    dvr2();
                }
            };
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();   
        }
    }
    
    
    /**
     * DC VIEW SEQUENCE ******************************************************************************
     */
    public void dc(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(166,166,166));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        pageStartPanel.setBackground(new Color(166,166,166));        
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new dcButtonOne(group, leftIndex, rightIndex, left));
        right.addActionListener(new dcButtonOne(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dc2()
    {
        JPanel newPanel = new JPanel(new BorderLayout());
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(240,240,240));
        pageStartPanel.setBackground(new Color(240,240,240)); 
        reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, 14));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        sp = new JScrollPane(reading);
        final ArrayList<String> introduction = Setup.getRI();
        reading.setEditable(false);
        
        int charCount = 0;
        for(int i = 0; i < introduction.size(); i++)
        {
            for(int j = 0; j < introduction.get(i).length(); j++)
            {
                charCount++;
            }
            reading.append(introduction.get(i));
            reading.append("\n");
           
            if(i == line)
            {
                if(charCount < 1000)
                {
                    currX = charCount;
                } else {
                    currX = charCount+1250;
                }
            }
        }           
        reading.setCaretPosition(currX);
        newPanel.add(sp, BorderLayout.CENTER);
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);  
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                line = (int) (sp.getVerticalScrollBar().getValue()/(reading.getHeight()/introduction.size()));
                dc3(controller.getCharCubeChar(Model.DC_ENUM, controller.getDCleft()), controller.getCharCubeChar(Model.DC_ENUM, controller.getDCright()), Model.DC_ENUM, controller.getDCleft(), controller.getDCright());
           }
        };
        Timer timer = new Timer(Setup.getRD(), taskPerformer);
        timer.setRepeats(false);
        timer.start();       
    }
    
    public void dc3(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(152,72,7));
        pageStartPanel.setBackground(new Color(152,72,7));        
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD, Setup.getSymbolSize()));
        left.addActionListener(new dcButtonTwo(group, leftIndex, rightIndex, left));
        right.addActionListener(new dcButtonTwo(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void dc4()
    {
        final JPanel newPanel = new JPanel(new BorderLayout());
        controller.updatePoints();
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(255,255,255));
        pageStartPanel.setBackground(new Color(255,255,255));   
        JTextArea reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, Setup.getFeedbackFont()));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        reading.setEditable(false);
        
        
        if(showHint)
        {
            reading.append(Setup.getDcMostTXT());
        } else {
            reading.append(Setup.getDcLeastTXT());
        }
        
        newPanel.add(reading, BorderLayout.CENTER);
        showHint = false;
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards); 
          
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton continueButton = new JButton("Continue");
                continueButton.addActionListener(new feedbackContinueButton());
                newPanel.add(continueButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
            }
        };
        Timer timer = new Timer(Setup.getFeedbackDelay(), taskPerformer);
        timer.setRepeats(false);
        timer.start();          
    }
    
    public class dcButtonTwo implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        // constructor
        public dcButtonTwo(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        public void actionPerformed(ActionEvent e)
        {
            button.setEnabled(false);
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    controller.incrementConditionCount(Model.DC_ENUM,index);
                    controller.writeToCSV("DC SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    dc4();
                }
            };
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();   
        }
    }
    
    public class dcButtonOne implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        
        public dcButtonOne(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button = button;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(index == controller.dcMostPreferred)
                    {
                        showHint = true;
                    }  
                     controller.writeToCSV("DC SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    controller.calculatePointLoss(group, index);
                    controller.incrementConditionCount(Model.DC_ENUM, index);
                    dc2();
                }
            };
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();
        }
    }
    
    /**
     * IC VIEW SEQUENCE ******************************************************************************
     */
    public void ic(char leftButtonChar, char rightButtonChar, int group, int leftIndex, int rightIndex)
    {
        JPanel newPanel = new JPanel(new GridLayout(2,2,10,10));
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(250,192,144));
        pageStartPanel.setBackground(new Color(250,192,144));
        JLabel leftFiller = new JLabel();
        JLabel rightFiller = new JLabel();
        newPanel.add(leftFiller);
        newPanel.add(rightFiller);
        JButton left = new JButton("" + leftButtonChar);
        JButton right = new JButton("" + rightButtonChar);
        left.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        left.addActionListener(new icButtonOne(group, leftIndex,rightIndex, left));
        right.addActionListener(new icButtonOne(group, rightIndex, leftIndex, right));
        right.setFont(new Font("Dialog", Font.BOLD,  Setup.getSymbolSize()));
        newPanel.add(left);
        newPanel.add(right);
        cards.add(newPanel, "Baseline Condition");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
    }
    
    public void ic2()
    {
        final JPanel newPanel = new JPanel(new BorderLayout());
        controller.updatePoints();
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        newPanel.setBackground(new Color(217,217,217));
        pageStartPanel.setBackground(new Color(217,217,217));   
        JTextArea reading = new JTextArea();
        reading.setWrapStyleWord(true);
        reading.setLineWrap(true);
        reading.setEditable(false);
        reading.setFont(new Font("Dialog", Font.PLAIN, Setup.getFeedbackFont()));
        reading.setBounds(10, 0, 774, 496);
        newPanel.add(reading);
        reading.setEditable(false);
        
        if(showHint)
        {
            reading.append(Setup.getIcMostTXT());
        } else {
            reading.append(Setup.getIcLeastTXT());
        }
        
        newPanel.add(reading, BorderLayout.CENTER);
        showHint = false;
        cards.add(newPanel, "Read now!");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards); 
          
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                JButton continueButton = new JButton("Continue");
                continueButton.addActionListener(new feedbackContinueButton());
                newPanel.add(continueButton, BorderLayout.SOUTH);
                revalidate();
                repaint();
            }
        };
        Timer timer = new Timer(Setup.getFeedbackDelay(), taskPerformer);
        timer.setRepeats(false);
        timer.start();            
    }
    
    
    public class icButtonOne implements ActionListener
    {
        int group;
        int index;
        int indexOther;
        JButton button;
        public icButtonOne(int group, int index, int indexOther, JButton button)
        {
            this.group = group;
            this.index = index;
            this.indexOther = indexOther;
            this.button  = button;
        }
        
        public void actionPerformed(ActionEvent e)
        {
            button.setEnabled(false);
            ActionListener taskPerformer = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    if(index == controller.icMostPreferred)
                    {
                        showHint = true;
                    }  
                    
                    controller.writeToCSV("IC SEQUENCE: " + group + "," + Model.getMyShape(group, index) + "," + Model.getMyShape(group, indexOther) + ",Hit: " + Model.getMyShape(group,index));
                    controller.calculatePointLoss(group, index);
                    controller.incrementConditionCount(Model.IC_ENUM, index);
                    ic2();
                }
            };
            int[] backgroundColor = Setup.getBaseColor();
            button.setBackground(new Color(backgroundColor[0], backgroundColor[1], backgroundColor[2]));
            button.setOpaque(true);
            button.setBorderPainted(false);
            Timer timer = new Timer(Setup.getBasePause(), taskPerformer);
            timer.setRepeats(false);
            timer.start();   
        }
    }
    
    /**
     * END SEQUENCES *********************
     */
     public static void playWinSound(){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("winning.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();   
        } catch(Exception e) {
            System.out.println(e);
        }
     }
     
     public static void playLossSound(){
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(new File("losing.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audio);
            clip.start();
        } catch(Exception e) {
            System.out.println(e);
        }
     }    
     
    public void delayView(int sleepTime)
    {
        JPanel newPanel = new JPanel(new BorderLayout());         
        newPanel.setBorder(new EmptyBorder(50,50,50,50));
        cards.add(newPanel, "Waiting...");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.next(cards);
        
        ActionListener taskPerformer = new ActionListener() { 
            public void actionPerformed(ActionEvent evt) {
                if(Setup.isRandomPres()) 
                {
                    controller.continueBaselineCondition();
                } else {
                    controller.manualProgram();
                }
                
                }
            };
       
        Timer timer = new Timer(sleepTime, taskPerformer);
        timer.setRepeats(false);
        timer.start(); 
    }
    
    public void timerScreen(int a)
    {
        Timer timer = new Timer( 1000, new ActionListener() {
                    public void actionPerformed( ActionEvent e ){
                        CardLayout cl = (CardLayout) cards.getLayout();
                        cl.next(cards);
                    }
        } );
        timer.start();
        timer.setRepeats(false);
    }
   
}


import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.Timer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author
 * Neal
 */
public class CardsGUI extends javax.swing.JFrame {

    /**
     * Creates
     * new
     * form
     * CardsGUI
     */
    public CardsGUI() {
	initComponents();
	setIntro();
    }

    /**
     * This
     * method
     * is
     * called
     * from
     * within
     * the
     * constructor
     * to
     * initialize
     * the
     * form.
     * WARNING:
     * Do
     * NOT
     * modify
     * this
     * code.
     * The
     * content
     * of
     * this
     * method
     * is
     * always
     * regenerated
     * by
     * the
     * Form
     * Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        intro = new javax.swing.JPanel();
        instructionLab = new javax.swing.JLabel();
        numOfPtLab = new javax.swing.JLabel();
        remainingPtLab = new javax.swing.JLabel();
        beginBut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        introTextArea = new javax.swing.JTextArea();
        basisScreen = new javax.swing.JPanel();
        basisLab = new javax.swing.JLabel();
        leftButBasis = new javax.swing.JButton();
        rightButBasis = new javax.swing.JButton();
        dvrcScreen1 = new javax.swing.JPanel();
        screen1Lab = new javax.swing.JLabel();
        leftButScreen1DVRC = new javax.swing.JButton();
        RightButScreen1DVRC = new javax.swing.JButton();
        dvrcScreen2 = new javax.swing.JPanel();
        screen2LabDVRC = new javax.swing.JLabel();
        jScrollPane3DVRC = new javax.swing.JScrollPane();
        readingAreaDVRC = new javax.swing.JTextArea();
        dvrcScreen3 = new javax.swing.JPanel();
        screen3LabDVRC = new javax.swing.JLabel();
        leftButScreen3DVRC = new javax.swing.JButton();
        rightButScreen3DVRC = new javax.swing.JButton();
        dvrcScreen4 = new javax.swing.JPanel();
        screen4LabDVRC = new javax.swing.JLabel();
        scrollPaneDVRC = new javax.swing.JScrollPane();
        screen4ConTextDVRC = new javax.swing.JTextArea();
        dvrScreen1 = new javax.swing.JPanel();
        screen1Lab1DVR = new javax.swing.JLabel();
        leftButScreen2DVR = new javax.swing.JButton();
        RightButScreen2DVR = new javax.swing.JButton();
        dvrScreen2 = new javax.swing.JPanel();
        screen2Lab1DVR = new javax.swing.JLabel();
        jScrollPane5DVR = new javax.swing.JScrollPane();
        readingAreaDVR = new javax.swing.JTextArea();
        dvrScreen3 = new javax.swing.JPanel();
        screen3Lab1DVR = new javax.swing.JLabel();
        leftButScreen4DVR = new javax.swing.JButton();
        rightButScreen4DVR = new javax.swing.JButton();
        dvrScreen4 = new javax.swing.JPanel();
        screen4Lab1DVR = new javax.swing.JLabel();
        jScrollPane6DVR = new javax.swing.JScrollPane();
        screen4ConTextDVR = new javax.swing.JTextArea();
        dcScreen1 = new javax.swing.JPanel();
        screen1Lab1DC = new javax.swing.JLabel();
        leftButScreen1DC = new javax.swing.JButton();
        RightButScreen1DC = new javax.swing.JButton();
        dcScreen2 = new javax.swing.JPanel();
        screen2Lab1DC = new javax.swing.JLabel();
        jScrollPaneDC = new javax.swing.JScrollPane();
        readingAreaDC = new javax.swing.JTextArea();
        dcScreen3 = new javax.swing.JPanel();
        screen3LabDC = new javax.swing.JLabel();
        leftButScreen3DC = new javax.swing.JButton();
        rightButScreen3DC = new javax.swing.JButton();
        dcScreen4 = new javax.swing.JPanel();
        screen4LabDC = new javax.swing.JLabel();
        jScrollPane4DC = new javax.swing.JScrollPane();
        screen4ConTextDVR1 = new javax.swing.JTextArea();
        icScreen1 = new javax.swing.JPanel();
        screen1LabIC = new javax.swing.JLabel();
        leftButScreen1IC = new javax.swing.JButton();
        rightButScreen1IC = new javax.swing.JButton();
        icScreen2 = new javax.swing.JPanel();
        screen2LabIC = new javax.swing.JLabel();
        jScrollPane2IC = new javax.swing.JScrollPane();
        screen2ConTextIC = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setResizable(false);

        jPanel1.setLayout(new java.awt.CardLayout());

        intro.setBackground(new java.awt.Color(156, 181, 228));

        instructionLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        instructionLab.setText("Introduction Sheet");

        numOfPtLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        remainingPtLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        remainingPtLab.setText("Remaining Points = ");

        beginBut.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        beginBut.setText("Begin");
        beginBut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beginButActionPerformed(evt);
            }
        });

        introTextArea.setEditable(false);
        introTextArea.setColumns(20);
        introTextArea.setLineWrap(true);
        introTextArea.setRows(5);
        jScrollPane2.setViewportView(introTextArea);

        javax.swing.GroupLayout introLayout = new javax.swing.GroupLayout(intro);
        intro.setLayout(introLayout);
        introLayout.setHorizontalGroup(
            introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(introLayout.createSequentialGroup()
                        .addComponent(instructionLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                        .addComponent(remainingPtLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numOfPtLab, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(beginBut, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        introLayout.setVerticalGroup(
            introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(introLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(introLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionLab)
                    .addComponent(numOfPtLab)
                    .addComponent(remainingPtLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(beginBut)
                .addContainerGap())
        );

        jPanel1.add(intro, "card2");

        basisScreen.setBackground(new java.awt.Color(0, 153, 153));

        basisLab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        basisLab.setText("Basis Condition");

        leftButBasis.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButBasis.setText("Left");
        leftButBasis.setFocusable(false);
        leftButBasis.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButBasis.setMaximumSize(new java.awt.Dimension(57, 23));
        leftButBasis.setMinimumSize(new java.awt.Dimension(57, 23));
        leftButBasis.setPreferredSize(new java.awt.Dimension(57, 23));
        leftButBasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButBasisActionPerformed(evt);
            }
        });

        rightButBasis.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButBasis.setText("Right");
        rightButBasis.setFocusable(false);
        rightButBasis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rightButBasisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout basisScreenLayout = new javax.swing.GroupLayout(basisScreen);
        basisScreen.setLayout(basisScreenLayout);
        basisScreenLayout.setHorizontalGroup(
            basisScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basisScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(basisScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basisLab)
                    .addComponent(leftButBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        basisScreenLayout.setVerticalGroup(
            basisScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(basisScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basisLab)
                .addGap(18, 18, 18)
                .addGroup(basisScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButBasis, javax.swing.GroupLayout.DEFAULT_SIZE, 543, Short.MAX_VALUE)
                    .addComponent(leftButBasis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(basisScreen, "card3");

        dvrcScreen1.setBackground(new java.awt.Color(142, 180, 227));
        dvrcScreen1.setPreferredSize(new java.awt.Dimension(800, 600));

        screen1Lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen1Lab.setText("Screen 1");

        leftButScreen1DVRC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen1DVRC.setText("Left");
        leftButScreen1DVRC.setFocusable(false);
        leftButScreen1DVRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButScreen1DVRC.setMaximumSize(new java.awt.Dimension(57, 23));
        leftButScreen1DVRC.setMinimumSize(new java.awt.Dimension(57, 23));
        leftButScreen1DVRC.setPreferredSize(new java.awt.Dimension(57, 23));
        leftButScreen1DVRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen1DVRCActionPerformed(evt);
            }
        });

        RightButScreen1DVRC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        RightButScreen1DVRC.setText("Right");
        RightButScreen1DVRC.setFocusable(false);
        RightButScreen1DVRC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RightButScreen1DVRC.setMaximumSize(new java.awt.Dimension(57, 23));
        RightButScreen1DVRC.setMinimumSize(new java.awt.Dimension(57, 23));
        RightButScreen1DVRC.setPreferredSize(new java.awt.Dimension(57, 23));
        RightButScreen1DVRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButScreen1DVRCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dvrcScreen1Layout = new javax.swing.GroupLayout(dvrcScreen1);
        dvrcScreen1.setLayout(dvrcScreen1Layout);
        dvrcScreen1Layout.setHorizontalGroup(
            dvrcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen1Lab)
                    .addComponent(leftButScreen1DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(RightButScreen1DVRC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dvrcScreen1Layout.setVerticalGroup(
            dvrcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen1Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dvrcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightButScreen1DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(leftButScreen1DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dvrcScreen1, "card4");

        screen2LabDVRC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen2LabDVRC.setText("Screen 2");

        readingAreaDVRC.setEditable(false);
        readingAreaDVRC.setColumns(20);
        readingAreaDVRC.setRows(5);
        jScrollPane3DVRC.setViewportView(readingAreaDVRC);

        javax.swing.GroupLayout dvrcScreen2Layout = new javax.swing.GroupLayout(dvrcScreen2);
        dvrcScreen2.setLayout(dvrcScreen2Layout);
        dvrcScreen2Layout.setHorizontalGroup(
            dvrcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dvrcScreen2Layout.createSequentialGroup()
                        .addComponent(screen2LabDVRC)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        dvrcScreen2Layout.setVerticalGroup(
            dvrcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen2LabDVRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(dvrcScreen2, "card5");

        dvrcScreen3.setBackground(new java.awt.Color(217, 150, 148));

        screen3LabDVRC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen3LabDVRC.setText("Screen 3");

        leftButScreen3DVRC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen3DVRC.setText("Left");
        leftButScreen3DVRC.setFocusable(false);
        leftButScreen3DVRC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen3DVRCActionPerformed(evt);
            }
        });

        rightButScreen3DVRC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButScreen3DVRC.setText("Right");
        rightButScreen3DVRC.setFocusable(false);

        javax.swing.GroupLayout dvrcScreen3Layout = new javax.swing.GroupLayout(dvrcScreen3);
        dvrcScreen3.setLayout(dvrcScreen3Layout);
        dvrcScreen3Layout.setHorizontalGroup(
            dvrcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen3LabDVRC)
                    .addComponent(leftButScreen3DVRC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButScreen3DVRC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dvrcScreen3Layout.setVerticalGroup(
            dvrcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen3LabDVRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dvrcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButScreen3DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButScreen3DVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dvrcScreen3, "card6");

        dvrcScreen4.setBackground(new java.awt.Color(179, 162, 199));

        screen4LabDVRC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen4LabDVRC.setText("Screen 4");

        screen4ConTextDVRC.setEditable(false);
        screen4ConTextDVRC.setColumns(20);
        screen4ConTextDVRC.setRows(5);
        scrollPaneDVRC.setViewportView(screen4ConTextDVRC);

        javax.swing.GroupLayout dvrcScreen4Layout = new javax.swing.GroupLayout(dvrcScreen4);
        dvrcScreen4.setLayout(dvrcScreen4Layout);
        dvrcScreen4Layout.setHorizontalGroup(
            dvrcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dvrcScreen4Layout.createSequentialGroup()
                        .addComponent(screen4LabDVRC)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(scrollPaneDVRC))
                .addContainerGap())
        );
        dvrcScreen4Layout.setVerticalGroup(
            dvrcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrcScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen4LabDVRC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneDVRC, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(dvrcScreen4, "card7");

        dvrScreen1.setBackground(new java.awt.Color(255, 255, 0));
        dvrScreen1.setPreferredSize(new java.awt.Dimension(800, 600));

        screen1Lab1DVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen1Lab1DVR.setText("Screen 1");

        leftButScreen2DVR.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen2DVR.setText("Left");
        leftButScreen2DVR.setFocusable(false);
        leftButScreen2DVR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButScreen2DVR.setMaximumSize(new java.awt.Dimension(57, 23));
        leftButScreen2DVR.setMinimumSize(new java.awt.Dimension(57, 23));
        leftButScreen2DVR.setPreferredSize(new java.awt.Dimension(57, 23));
        leftButScreen2DVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen2DVRActionPerformed(evt);
            }
        });

        RightButScreen2DVR.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        RightButScreen2DVR.setText("Right");
        RightButScreen2DVR.setFocusable(false);
        RightButScreen2DVR.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RightButScreen2DVR.setMaximumSize(new java.awt.Dimension(57, 23));
        RightButScreen2DVR.setMinimumSize(new java.awt.Dimension(57, 23));
        RightButScreen2DVR.setPreferredSize(new java.awt.Dimension(57, 23));
        RightButScreen2DVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButScreen2DVRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dvrScreen1Layout = new javax.swing.GroupLayout(dvrScreen1);
        dvrScreen1.setLayout(dvrScreen1Layout);
        dvrScreen1Layout.setHorizontalGroup(
            dvrScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen1Lab1DVR)
                    .addComponent(leftButScreen2DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(RightButScreen2DVR, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dvrScreen1Layout.setVerticalGroup(
            dvrScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen1Lab1DVR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dvrScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightButScreen2DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(leftButScreen2DVR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dvrScreen1, "card4");

        screen2Lab1DVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen2Lab1DVR.setText("Screen 2");

        readingAreaDVR.setEditable(false);
        readingAreaDVR.setColumns(20);
        readingAreaDVR.setRows(5);
        jScrollPane5DVR.setViewportView(readingAreaDVR);

        javax.swing.GroupLayout dvrScreen2Layout = new javax.swing.GroupLayout(dvrScreen2);
        dvrScreen2.setLayout(dvrScreen2Layout);
        dvrScreen2Layout.setHorizontalGroup(
            dvrScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dvrScreen2Layout.createSequentialGroup()
                        .addComponent(screen2Lab1DVR)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        dvrScreen2Layout.setVerticalGroup(
            dvrScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen2Lab1DVR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(dvrScreen2, "card5");

        dvrScreen3.setBackground(new java.awt.Color(195, 214, 155));

        screen3Lab1DVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen3Lab1DVR.setText("Screen 3");

        leftButScreen4DVR.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen4DVR.setText("Left");
        leftButScreen4DVR.setFocusable(false);
        leftButScreen4DVR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen4DVRActionPerformed(evt);
            }
        });

        rightButScreen4DVR.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButScreen4DVR.setText("Right");
        rightButScreen4DVR.setFocusable(false);

        javax.swing.GroupLayout dvrScreen3Layout = new javax.swing.GroupLayout(dvrScreen3);
        dvrScreen3.setLayout(dvrScreen3Layout);
        dvrScreen3Layout.setHorizontalGroup(
            dvrScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen3Lab1DVR)
                    .addComponent(leftButScreen4DVR, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButScreen4DVR, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dvrScreen3Layout.setVerticalGroup(
            dvrScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen3Lab1DVR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dvrScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButScreen4DVR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButScreen4DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dvrScreen3, "card6");

        dvrScreen4.setBackground(new java.awt.Color(196, 189, 151));

        screen4Lab1DVR.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen4Lab1DVR.setText("Screen 4");

        screen4ConTextDVR.setEditable(false);
        screen4ConTextDVR.setColumns(20);
        screen4ConTextDVR.setRows(5);
        jScrollPane6DVR.setViewportView(screen4ConTextDVR);

        javax.swing.GroupLayout dvrScreen4Layout = new javax.swing.GroupLayout(dvrScreen4);
        dvrScreen4.setLayout(dvrScreen4Layout);
        dvrScreen4Layout.setHorizontalGroup(
            dvrScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dvrScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dvrScreen4Layout.createSequentialGroup()
                        .addComponent(screen4Lab1DVR)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(jScrollPane6DVR))
                .addContainerGap())
        );
        dvrScreen4Layout.setVerticalGroup(
            dvrScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dvrScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen4Lab1DVR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6DVR, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(dvrScreen4, "card7");

        dcScreen1.setBackground(new java.awt.Color(166, 166, 166));
        dcScreen1.setPreferredSize(new java.awt.Dimension(800, 600));

        screen1Lab1DC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen1Lab1DC.setText("Screen 1");

        leftButScreen1DC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen1DC.setText("Left");
        leftButScreen1DC.setFocusable(false);
        leftButScreen1DC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButScreen1DC.setMaximumSize(new java.awt.Dimension(57, 23));
        leftButScreen1DC.setMinimumSize(new java.awt.Dimension(57, 23));
        leftButScreen1DC.setPreferredSize(new java.awt.Dimension(57, 23));
        leftButScreen1DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen1DCActionPerformed(evt);
            }
        });

        RightButScreen1DC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        RightButScreen1DC.setText("Right");
        RightButScreen1DC.setFocusable(false);
        RightButScreen1DC.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RightButScreen1DC.setMaximumSize(new java.awt.Dimension(57, 23));
        RightButScreen1DC.setMinimumSize(new java.awt.Dimension(57, 23));
        RightButScreen1DC.setPreferredSize(new java.awt.Dimension(57, 23));
        RightButScreen1DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButScreen1DCActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dcScreen1Layout = new javax.swing.GroupLayout(dcScreen1);
        dcScreen1.setLayout(dcScreen1Layout);
        dcScreen1Layout.setHorizontalGroup(
            dcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen1Lab1DC)
                    .addComponent(leftButScreen1DC, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(RightButScreen1DC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dcScreen1Layout.setVerticalGroup(
            dcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen1Lab1DC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dcScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightButScreen1DC, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                    .addComponent(leftButScreen1DC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dcScreen1, "card4");

        screen2Lab1DC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen2Lab1DC.setText("Screen 2");

        readingAreaDC.setEditable(false);
        readingAreaDC.setColumns(20);
        readingAreaDC.setRows(5);
        jScrollPaneDC.setViewportView(readingAreaDC);

        javax.swing.GroupLayout dcScreen2Layout = new javax.swing.GroupLayout(dcScreen2);
        dcScreen2.setLayout(dcScreen2Layout);
        dcScreen2Layout.setHorizontalGroup(
            dcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dcScreen2Layout.createSequentialGroup()
                        .addComponent(screen2Lab1DC)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPaneDC, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        dcScreen2Layout.setVerticalGroup(
            dcScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen2Lab1DC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPaneDC, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(dcScreen2, "card5");

        dcScreen3.setBackground(new java.awt.Color(152, 72, 7));

        screen3LabDC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen3LabDC.setText("Screen 3");

        leftButScreen3DC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen3DC.setText("Left");
        leftButScreen3DC.setFocusable(false);
        leftButScreen3DC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen3DCActionPerformed(evt);
            }
        });

        rightButScreen3DC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButScreen3DC.setText("Right");
        rightButScreen3DC.setFocusable(false);

        javax.swing.GroupLayout dcScreen3Layout = new javax.swing.GroupLayout(dcScreen3);
        dcScreen3.setLayout(dcScreen3Layout);
        dcScreen3Layout.setHorizontalGroup(
            dcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen3LabDC)
                    .addComponent(leftButScreen3DC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButScreen3DC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        dcScreen3Layout.setVerticalGroup(
            dcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen3LabDC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dcScreen3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButScreen3DC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButScreen3DC, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(dcScreen3, "card6");

        dcScreen4.setBackground(new java.awt.Color(255, 255, 255));

        screen4LabDC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen4LabDC.setText("Screen 4");

        screen4ConTextDVR1.setEditable(false);
        screen4ConTextDVR1.setColumns(20);
        screen4ConTextDVR1.setRows(5);
        jScrollPane4DC.setViewportView(screen4ConTextDVR1);

        javax.swing.GroupLayout dcScreen4Layout = new javax.swing.GroupLayout(dcScreen4);
        dcScreen4.setLayout(dcScreen4Layout);
        dcScreen4Layout.setHorizontalGroup(
            dcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dcScreen4Layout.createSequentialGroup()
                        .addComponent(screen4LabDC)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(jScrollPane4DC))
                .addContainerGap())
        );
        dcScreen4Layout.setVerticalGroup(
            dcScreen4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dcScreen4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen4LabDC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4DC, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(dcScreen4, "card7");

        icScreen1.setBackground(new java.awt.Color(250, 192, 144));

        screen1LabIC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen1LabIC.setText("Screen 3");

        leftButScreen1IC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen1IC.setText("Left");
        leftButScreen1IC.setFocusable(false);
        leftButScreen1IC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen1ICActionPerformed(evt);
            }
        });

        rightButScreen1IC.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButScreen1IC.setText("Right");
        rightButScreen1IC.setFocusable(false);

        javax.swing.GroupLayout icScreen1Layout = new javax.swing.GroupLayout(icScreen1);
        icScreen1.setLayout(icScreen1Layout);
        icScreen1Layout.setHorizontalGroup(
            icScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(icScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen1LabIC)
                    .addComponent(leftButScreen1IC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButScreen1IC, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        icScreen1Layout.setVerticalGroup(
            icScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icScreen1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen1LabIC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(icScreen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButScreen1IC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButScreen1IC, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(icScreen1, "card6");

        icScreen2.setBackground(new java.awt.Color(217, 217, 217));

        screen2LabIC.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen2LabIC.setText("Screen 4");

        screen2ConTextIC.setEditable(false);
        screen2ConTextIC.setColumns(20);
        screen2ConTextIC.setRows(5);
        jScrollPane2IC.setViewportView(screen2ConTextIC);

        javax.swing.GroupLayout icScreen2Layout = new javax.swing.GroupLayout(icScreen2);
        icScreen2.setLayout(icScreen2Layout);
        icScreen2Layout.setHorizontalGroup(
            icScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(icScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(icScreen2Layout.createSequentialGroup()
                        .addComponent(screen2LabIC)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(jScrollPane2IC))
                .addContainerGap())
        );
        icScreen2Layout.setVerticalGroup(
            icScreen2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(icScreen2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen2LabIC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2IC, javax.swing.GroupLayout.DEFAULT_SIZE, 550, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(icScreen2, "card7");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void beginButActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beginButActionPerformed
        CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
    }//GEN-LAST:event_beginButActionPerformed

    private void leftButBasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButBasisActionPerformed
//        if(Setup.getBasisCount() != Setup.getBasis().size() ) {
//	    Setup.addBasisCounter();
//	}
//	if(Setup.getBasisCount() == Setup.getBasis().size() ) {
//	    CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
//	    cardLayout.next(jPanel1);
//	}
	CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
    }//GEN-LAST:event_leftButBasisActionPerformed

    private void rightButBasisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rightButBasisActionPerformed
        if(Setup.getBasisCount() < 20 ) {
	    Setup.addBasisCounter();
	}
	if(Setup.getBasisCount() == 20 ) {
	    CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
	    cardLayout.next(jPanel1);
	}
    }//GEN-LAST:event_rightButBasisActionPerformed

    private void leftButScreen3DVRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen3DVRCActionPerformed
        CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
    }//GEN-LAST:event_leftButScreen3DVRCActionPerformed

    private void RightButScreen1DVRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButScreen1DVRCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightButScreen1DVRCActionPerformed

    private void leftButScreen1DVRCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen1DVRCActionPerformed
        CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
        setReading();
    }//GEN-LAST:event_leftButScreen1DVRCActionPerformed

    private void leftButScreen2DVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen2DVRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftButScreen2DVRActionPerformed

    private void RightButScreen2DVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButScreen2DVRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightButScreen2DVRActionPerformed

    private void leftButScreen4DVRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen4DVRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftButScreen4DVRActionPerformed

    private void leftButScreen3DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen3DCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftButScreen3DCActionPerformed

    private void RightButScreen1DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButScreen1DCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightButScreen1DCActionPerformed

    private void leftButScreen1DCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen1DCActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftButScreen1DCActionPerformed

    private void leftButScreen1ICActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen1ICActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_leftButScreen1ICActionPerformed

    /**
     * @param
     * args
     * the
     * command
     * line
     * arguments
     */
    public static void main(String args[]) {
	/* Set the Nimbus look and feel */
	//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
	 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
	 */
	try {
	    for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		if ("Nimbus".equals(info.getName())) {
		    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		    break;
		}
	    }
	} catch (ClassNotFoundException ex) {
	    java.util.logging.Logger.getLogger(CardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(CardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(CardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(CardsGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
	//</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    @Override
	    public void run() {
		new CardsGUI().setVisible(true);
	    }
	});
    }
    
    private void setIntro() {
	    numOfPtLab.setText(String.valueOf(Setup.getPoints()));
	    introTextArea.setWrapStyleWord(true);
	    ArrayList<String> introduction = Setup.getITS();
	    for(int i = 0; i < introduction.size(); i++){
		introTextArea.setWrapStyleWord(true);
		introTextArea.append(introduction.get(i));
		introTextArea.append("\n");
	}
    }
        
    private void setBasis() {
	
    }
    
    private void setReading() {
	    readingAreaDVRC.setWrapStyleWord(true);
	    ArrayList<String> introduction = Setup.getRI();
	    for(int i = 0; i < introduction.size(); i++){
		readingAreaDVRC.append(introduction.get(i));
		readingAreaDVRC.append("\n");
	    }
	    Timer timer = new Timer( 1000, new ActionListener(){
	    @Override
	    public void actionPerformed( ActionEvent e ){
		    CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
		    cardLayout.next(jPanel1);
	    }
	  } );
	  timer.start();
	  timer.setRepeats(false);
    }
        
    private void lostPointsScreen4() {
	screen4ConTextDVRC.setWrapStyleWord(true);
	screen4ConTextDVRC.append("You shouldn’t have chosen the shape you chose on the blue screen - you have lost two points ");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RightButScreen1DC;
    private javax.swing.JButton RightButScreen1DVRC;
    private javax.swing.JButton RightButScreen2DVR;
    private javax.swing.JLabel basisLab;
    private javax.swing.JPanel basisScreen;
    private javax.swing.JButton beginBut;
    private javax.swing.JPanel dcScreen1;
    private javax.swing.JPanel dcScreen2;
    private javax.swing.JPanel dcScreen3;
    private javax.swing.JPanel dcScreen4;
    private javax.swing.JPanel dvrScreen1;
    private javax.swing.JPanel dvrScreen2;
    private javax.swing.JPanel dvrScreen3;
    private javax.swing.JPanel dvrScreen4;
    private javax.swing.JPanel dvrcScreen1;
    private javax.swing.JPanel dvrcScreen2;
    private javax.swing.JPanel dvrcScreen3;
    private javax.swing.JPanel dvrcScreen4;
    private javax.swing.JPanel icScreen1;
    private javax.swing.JPanel icScreen2;
    private javax.swing.JLabel instructionLab;
    private javax.swing.JPanel intro;
    private javax.swing.JTextArea introTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane2IC;
    private javax.swing.JScrollPane jScrollPane3DVRC;
    private javax.swing.JScrollPane jScrollPane4DC;
    private javax.swing.JScrollPane jScrollPane5DVR;
    private javax.swing.JScrollPane jScrollPane6DVR;
    private javax.swing.JScrollPane jScrollPaneDC;
    private javax.swing.JButton leftButBasis;
    private javax.swing.JButton leftButScreen1DC;
    private javax.swing.JButton leftButScreen1DVRC;
    private javax.swing.JButton leftButScreen1IC;
    private javax.swing.JButton leftButScreen2DVR;
    private javax.swing.JButton leftButScreen3DC;
    private javax.swing.JButton leftButScreen3DVRC;
    private javax.swing.JButton leftButScreen4DVR;
    private javax.swing.JLabel numOfPtLab;
    private javax.swing.JTextArea readingAreaDC;
    private javax.swing.JTextArea readingAreaDVR;
    private javax.swing.JTextArea readingAreaDVRC;
    private javax.swing.JLabel remainingPtLab;
    private javax.swing.JButton rightButBasis;
    private javax.swing.JButton rightButScreen1IC;
    private javax.swing.JButton rightButScreen3DC;
    private javax.swing.JButton rightButScreen3DVRC;
    private javax.swing.JButton rightButScreen4DVR;
    private javax.swing.JLabel screen1Lab;
    private javax.swing.JLabel screen1Lab1DC;
    private javax.swing.JLabel screen1Lab1DVR;
    private javax.swing.JLabel screen1LabIC;
    private javax.swing.JTextArea screen2ConTextIC;
    private javax.swing.JLabel screen2Lab1DC;
    private javax.swing.JLabel screen2Lab1DVR;
    private javax.swing.JLabel screen2LabDVRC;
    private javax.swing.JLabel screen2LabIC;
    private javax.swing.JLabel screen3Lab1DVR;
    private javax.swing.JLabel screen3LabDC;
    private javax.swing.JLabel screen3LabDVRC;
    private javax.swing.JTextArea screen4ConTextDVR;
    private javax.swing.JTextArea screen4ConTextDVR1;
    private javax.swing.JTextArea screen4ConTextDVRC;
    private javax.swing.JLabel screen4Lab1DVR;
    private javax.swing.JLabel screen4LabDC;
    private javax.swing.JLabel screen4LabDVRC;
    private javax.swing.JScrollPane scrollPaneDVRC;
    // End of variables declaration//GEN-END:variables
}

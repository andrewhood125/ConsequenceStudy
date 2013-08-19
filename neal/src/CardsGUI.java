
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
        jPanel2 = new javax.swing.JPanel();
        instructionLab = new javax.swing.JLabel();
        numOfPtLab = new javax.swing.JLabel();
        remainingPtLab = new javax.swing.JLabel();
        beginBut = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        introTextArea = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        basisLab = new javax.swing.JLabel();
        leftButBasis = new javax.swing.JButton();
        rightButBasis = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        screen1Lab = new javax.swing.JLabel();
        leftButScreen1 = new javax.swing.JButton();
        RightButScreen1 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        screen2Lab = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        readingArea = new javax.swing.JTextArea();
        jPanel6 = new javax.swing.JPanel();
        screen3Lab = new javax.swing.JLabel();
        leftButScreen3 = new javax.swing.JButton();
        rightButScreen3 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        screen4Lab = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        screen4ConText = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanel1.setLayout(new java.awt.CardLayout());

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(instructionLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 503, Short.MAX_VALUE)
                        .addComponent(remainingPtLab)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numOfPtLab, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(beginBut, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(instructionLab)
                    .addComponent(numOfPtLab)
                    .addComponent(remainingPtLab))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(beginBut)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, "card2");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(basisLab)
                    .addComponent(leftButBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButBasis, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(basisLab)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButBasis, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
                    .addComponent(leftButBasis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel3, "card3");

        jPanel4.setPreferredSize(new java.awt.Dimension(800, 600));

        screen1Lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen1Lab.setText("Screen 1");

        leftButScreen1.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen1.setText("Left");
        leftButScreen1.setFocusable(false);
        leftButScreen1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        leftButScreen1.setMaximumSize(new java.awt.Dimension(57, 23));
        leftButScreen1.setMinimumSize(new java.awt.Dimension(57, 23));
        leftButScreen1.setPreferredSize(new java.awt.Dimension(57, 23));
        leftButScreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen1ActionPerformed(evt);
            }
        });

        RightButScreen1.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        RightButScreen1.setText("Right");
        RightButScreen1.setFocusable(false);
        RightButScreen1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        RightButScreen1.setMaximumSize(new java.awt.Dimension(57, 23));
        RightButScreen1.setMinimumSize(new java.awt.Dimension(57, 23));
        RightButScreen1.setPreferredSize(new java.awt.Dimension(57, 23));
        RightButScreen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RightButScreen1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen1Lab)
                    .addComponent(leftButScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(RightButScreen1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen1Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(RightButScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                    .addComponent(leftButScreen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel4, "card4");

        screen2Lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen2Lab.setText("Screen 2");

        readingArea.setEditable(false);
        readingArea.setColumns(20);
        readingArea.setRows(5);
        jScrollPane3.setViewportView(readingArea);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(screen2Lab)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 780, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen2Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel5, "card5");

        screen3Lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen3Lab.setText("Screen 3");

        leftButScreen3.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        leftButScreen3.setText("Left");
        leftButScreen3.setFocusable(false);
        leftButScreen3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                leftButScreen3ActionPerformed(evt);
            }
        });

        rightButScreen3.setFont(new java.awt.Font("Tahoma", 0, 100)); // NOI18N
        rightButScreen3.setText("Right");
        rightButScreen3.setFocusable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(screen3Lab)
                    .addComponent(leftButScreen3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addComponent(rightButScreen3, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen3Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightButScreen3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftButScreen3, javax.swing.GroupLayout.DEFAULT_SIZE, 558, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel1.add(jPanel6, "card6");

        screen4Lab.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        screen4Lab.setText("Screen 4");

        screen4ConText.setEditable(false);
        screen4ConText.setColumns(20);
        screen4ConText.setRows(5);
        jScrollPane4.setViewportView(screen4ConText);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(screen4Lab)
                        .addGap(0, 726, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(screen4Lab)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 553, Short.MAX_VALUE)
                .addGap(16, 16, 16))
        );

        jPanel1.add(jPanel7, "card7");

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

    private void leftButScreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen1ActionPerformed
        CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
	setReading();
    }//GEN-LAST:event_leftButScreen1ActionPerformed

    private void RightButScreen1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RightButScreen1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RightButScreen1ActionPerformed

    private void leftButScreen3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_leftButScreen3ActionPerformed
        CardLayout cardLayout = (CardLayout) jPanel1.getLayout();
        cardLayout.next(jPanel1);
    }//GEN-LAST:event_leftButScreen3ActionPerformed

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
	    readingArea.setWrapStyleWord(true);
	    ArrayList<String> introduction = Setup.getRI();
	    for(int i = 0; i < introduction.size(); i++){
		readingArea.append(introduction.get(i));
		readingArea.append("\n");
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
	screen4ConText.setWrapStyleWord(true);
	screen4ConText.append("You shouldn’t have chosen the shape you chose on the blue screen - you have lost two points ");
    }
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RightButScreen1;
    private javax.swing.JLabel basisLab;
    private javax.swing.JButton beginBut;
    private javax.swing.JLabel instructionLab;
    private javax.swing.JTextArea introTextArea;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton leftButBasis;
    private javax.swing.JButton leftButScreen1;
    private javax.swing.JButton leftButScreen3;
    private javax.swing.JLabel numOfPtLab;
    private javax.swing.JTextArea readingArea;
    private javax.swing.JLabel remainingPtLab;
    private javax.swing.JButton rightButBasis;
    private javax.swing.JButton rightButScreen3;
    private javax.swing.JLabel screen1Lab;
    private javax.swing.JLabel screen2Lab;
    private javax.swing.JLabel screen3Lab;
    private javax.swing.JTextArea screen4ConText;
    private javax.swing.JLabel screen4Lab;
    // End of variables declaration//GEN-END:variables
}

package 김원식;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainClass extends JFrame implements ActionListener {
	ProgTest1 pt1 = new ProgTest1();
	ProgTest2 pt2 = new ProgTest2();

	JPanel[] jp;
	String[] jpString = { "회원등록, 삭제, 조회", "구구단", "결과" };
	JLabel[] jl;
	String[] jlString = { "회원ID : ", "회원이름 : ", "전화번호 : ", "성별 : " };
	JTextField[] tf;
	JRadioButton[] jrb;
	String[] jrbString = { "남", "여" };
	JButton[] jbt;
	String[] jbtString = { "회원등록", "회원삭제", "전체회원조회", "구구단보기" };
	JTextArea ta;
	ButtonGroup bg;
	String str = "회원ID\t회원이름\t전화번호\t 성별\n";

	MainClass() {
		super("프로그래밍언어활용평가");

		jp = new JPanel[jpString.length];
		for (int i = 0; i < jpString.length; i++) {
			jp[i] = new JPanel();
			jp[i].setBorder(new TitledBorder(new EtchedBorder(), jpString[i]));
		}

		jl = new JLabel[jlString.length];
		tf = new JTextField[jl.length - 1];
		jrb = new JRadioButton[jrbString.length];
		Box hBox = Box.createHorizontalBox();
		hBox.add(Box.createHorizontalGlue());
		for (int i = 0; i < jlString.length; i++) {
			if (i < tf.length) {
				jl[i] = new JLabel(jlString[i]);
				tf[i] = new JTextField(10);
				hBox.add(jl[i]);
				hBox.add(tf[i]);
				hBox.add(Box.createHorizontalStrut(10));
			} else {
				jl[i] = new JLabel(jlString[i]);
				hBox.add(jl[i]);
				hBox.add(Box.createHorizontalStrut(10));
			}
		}
		bg = new ButtonGroup();
		for (int i = 0; i < jrbString.length; i++) {
			jrb[i] = new JRadioButton(jrbString[i]);
			bg.add(jrb[i]);
			hBox.add(jrb[i]);
		}
		hBox.add(Box.createHorizontalGlue());

		jbt = new JButton[jbtString.length];
		Box hhBox = Box.createHorizontalBox();
		hhBox.add(Box.createHorizontalGlue());
		for (int i = 0; i < jbtString.length; i++) {
			if (i < jbtString.length - 1) {
				jbt[i] = new JButton(jbtString[i]);
				jbt[i].addActionListener(this);
				hhBox.add(jbt[i]);
				hhBox.add(Box.createHorizontalStrut(5));
			} else {
				jbt[i] = new JButton(jbtString[i]);
				jbt[i].addActionListener(this);
				jp[1].add(jbt[i]);
			}
		}
		hhBox.add(Box.createHorizontalGlue());

		Box vBox = Box.createVerticalBox();
		vBox.add(Box.createVerticalGlue());
		vBox.add(hBox);
		vBox.add(Box.createVerticalStrut(20));
		vBox.add(hhBox);
		vBox.add(Box.createVerticalGlue());

		jp[0].add(vBox);
		ta = new JTextArea(6, 70);
		ta.setEditable(false);
		ta.setText(str);
		jp[2].add(ta);

		Box vvBox = Box.createVerticalBox();
		vvBox.add(Box.createVerticalGlue());
		for (int i = 0; i < jpString.length; i++) {
			vvBox.add(jp[i]);
		}
		vvBox.add(Box.createVerticalGlue());

		add(vvBox, "Center");
	}

	public static void main(String[] args) {
		MainClass mc = new MainClass();
		mc.setVisible(true);
		mc.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mc.setSize(800, 400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String memberID, name, tel, gender = "";
		ArrayList<MemberData> list = pt2.getMapList();
		String str = "회원ID\t회원이름\t전화번호\t 성별\n";
		ta.setText(str);
		
		if (e.getActionCommand().equals("회원등록")) {
			memberID = tf[0].getText();
			name = tf[1].getText();
			tel = tf[2].getText();

			Enumeration<AbstractButton> em = bg.getElements();
			while (em.hasMoreElements()) {
				JRadioButton rb = (JRadioButton) em.nextElement();
				if (rb.isSelected()) {
					gender = rb.getText();
				}
			}
			int con = JOptionPane.showConfirmDialog(this, "회원을 등록하시겠습니까?", "회원등록", 0);
			if(con == 0) {
				pt2.mapListAdd(memberID, name, tel, gender);
				for(int i = 0; i < tf.length; i++) {
					tf[i].setText("");
				}
			}
		}
		if(e.getActionCommand().equals("회원삭제")) {
			memberID = tf[0].getText();
			int con = JOptionPane.showConfirmDialog(this, "회원을 삭제하시겠습니까?", "회원삭제", 0);
			if(con == 0) {
				pt2.mapListRemove(memberID);
			}
			jbt[2].doClick();
		}
		if(e.getActionCommand().equals("전체회원조회")) {
			for(MemberData md : list) {
				str += md.getMemberID() + "\t" + md.getName() + "\t" + md.getTel() + "\t " + md.getGender() + "\n";
			}
			ta.setText(str);
		}
		if(e.getActionCommand().equals("구구단보기")) {
			String dan = JOptionPane.showInputDialog("몇단을 보시겠습니까?");
			ta.setText(pt1.getGugudan(Integer.parseInt(dan)));
		}
	}
}

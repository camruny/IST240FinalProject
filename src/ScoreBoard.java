/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RyanS
 */
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ScoreBoard extends JPanel {

	public ScoreBoard(){
		Vector<ScoreBean> scorelist = XMLUtils.readXML();
		
		setLayout(new BorderLayout());
		JPanel inner = new JPanel();
		inner.setLayout(new GridLayout(0, 1));
		for(ScoreBean bean : scorelist) {
			String scoreText = bean.getName()+" - "+bean.getValue();
			JLabel label = new JLabel(scoreText);
			label.setSize(100, 30);
			inner.add(label);
		}
		add(inner, BorderLayout.NORTH);
	}
}

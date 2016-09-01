package br.com.biavan.game2048.view;

import java.awt.EventQueue;
import java.net.URL;
import java.net.URLClassLoader;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import br.com.biavan.game2048.core.Direction;
import br.com.biavan.game2048.core.SquareArea;
import br.com.biavan.game2048.core.Tile;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Game2048 {

	private JFrame frame;
	private SquareArea squareArea = null;
	private JLabel[][] viewArea = new JLabel[SquareArea.SIZE][SquareArea.SIZE];
	private static JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game2048 window = new Game2048();
					window.frame.setVisible(true);
					textField.requestFocus();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Game2048() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 526, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		squareArea = new SquareArea();

		JLabel a1 = new JLabel("");
		a1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		a1.setHorizontalAlignment(SwingConstants.CENTER);
		a1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		a1.setBounds(12, 7, 120, 120);
		panel.add(a1);
		viewArea[0][0] = a1;

		JLabel a2 = new JLabel("");
		a2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		a2.setHorizontalAlignment(SwingConstants.CENTER);
		a2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		a2.setBounds(140, 7, 120, 120);
		panel.add(a2);
		viewArea[0][1] = a2;

		JLabel a3 = new JLabel("");
		a3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		a3.setHorizontalAlignment(SwingConstants.CENTER);
		a3.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		a3.setBounds(268, 7, 120, 120);
		panel.add(a3);
		viewArea[0][2] = a3;

		JLabel a4 = new JLabel("");
		a4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		a4.setHorizontalAlignment(SwingConstants.CENTER);
		a4.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		a4.setBounds(396, 7, 120, 120);
		panel.add(a4);
		viewArea[0][3] = a4;

		JLabel b1 = new JLabel("");
		b1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		b1.setHorizontalAlignment(SwingConstants.CENTER);
		b1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		b1.setBounds(12, 134, 120, 120);
		panel.add(b1);
		viewArea[1][0] = b1;

		JLabel b2 = new JLabel("");
		b2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		b2.setHorizontalAlignment(SwingConstants.CENTER);
		b2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		b2.setBounds(140, 134, 120, 120);
		panel.add(b2);
		viewArea[1][1] = b2;

		JLabel b3 = new JLabel("");
		b3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		b3.setHorizontalAlignment(SwingConstants.CENTER);
		b3.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		b3.setBounds(268, 134, 120, 120);
		panel.add(b3);
		viewArea[1][2] = b3;

		JLabel b4 = new JLabel("");
		b4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		b4.setHorizontalAlignment(SwingConstants.CENTER);
		b4.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		b4.setBounds(396, 134, 120, 120);
		panel.add(b4);
		viewArea[1][3] = b4;

		JLabel c1 = new JLabel("");
		c1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		c1.setHorizontalAlignment(SwingConstants.CENTER);
		c1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		c1.setBounds(12, 261, 120, 120);
		panel.add(c1);
		viewArea[2][0] = c1;

		JLabel c2 = new JLabel("");
		c2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		c2.setHorizontalAlignment(SwingConstants.CENTER);
		c2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		c2.setBounds(140, 261, 120, 120);
		panel.add(c2);
		viewArea[2][1] = c2;

		JLabel c3 = new JLabel("");
		c3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		c3.setHorizontalAlignment(SwingConstants.CENTER);
		c3.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		c3.setBounds(268, 261, 120, 120);
		panel.add(c3);
		viewArea[2][2] = c3;

		JLabel c4 = new JLabel("");
		c4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		c4.setHorizontalAlignment(SwingConstants.CENTER);
		c4.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		c4.setBounds(396, 261, 120, 120);
		panel.add(c4);
		viewArea[2][3] = c4;

		JLabel d1 = new JLabel("");
		d1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		d1.setHorizontalAlignment(SwingConstants.CENTER);
		d1.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		d1.setBounds(12, 388, 120, 120);
		panel.add(d1);
		viewArea[3][0] = d1;

		JLabel d2 = new JLabel("");
		d2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		d2.setHorizontalAlignment(SwingConstants.CENTER);
		d2.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		d2.setBounds(140, 388, 120, 120);
		panel.add(d2);
		viewArea[3][1] = d2;

		JLabel d3 = new JLabel("");
		d3.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		d3.setHorizontalAlignment(SwingConstants.CENTER);
		d3.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		d3.setBounds(268, 388, 120, 120);
		panel.add(d3);
		viewArea[3][2] = d3;

		JLabel d4 = new JLabel("");
		d4.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		d4.setHorizontalAlignment(SwingConstants.CENTER);
		d4.setFont(new Font("DejaVu Sans Mono", Font.BOLD, 45));
		d4.setBounds(396, 388, 120, 120);
		panel.add(d4);
		viewArea[3][3] = d4;

		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyCode = e.getKeyCode();
				switch( keyCode ) { 
				case KeyEvent.VK_UP:
					squareArea.calculate(Direction.UP);
					break;
				case KeyEvent.VK_DOWN:
					squareArea.calculate(Direction.DOWN);
					break;
				case KeyEvent.VK_LEFT:
					squareArea.calculate(Direction.LEFT);
					break;
				case KeyEvent.VK_RIGHT:
					squareArea.calculate(Direction.RIGHT);
					break;
				}
				updateView();
			}
		});
		textField.setBounds(0, 535, 114, 19);
		panel.add(textField);
		textField.setColumns(10);

		updateView();
	}

	private void updateView() {
		newValues();
		for(int x = 0; x < 4; x++) {
			for(int y = 0; y < 4; y++) {
				if(squareArea.getTileAt(x, y).getValue() == 0) {
					viewArea[x][y].setText("");
				} else {
					viewArea[x][y].setText(squareArea.getTileAt(x, y).toString());
//					changeColor(y, x);
				}
			}
		}
	}

	private void newValues() {
		int x, y;

		if (squareArea.hasBlank()) {
			do {
				x = squareArea.generateRandonPosition();
				y = squareArea.generateRandonPosition();

			} while(squareArea.hasTileAt(x, y));
			squareArea.setTileAt(new Tile(2), x, y);
			viewArea[x][y].setText("2");
		} else {
			JOptionPane.showMessageDialog(frame,"GAME OVER");
		}
	}

	private void changeColor(int x, int y) {
		int value = squareArea.getTileAt(x, y).getValue(); 

		Color color = Color.BLACK;
		switch(value) {
		case 2:
			color = Color.WHITE;
			break;
		case 4:
			color = Color.YELLOW;
			break;
		case 8:
			color = Color.GREEN;
			break;
		case 16:
			color = Color.CYAN;
			break;
		case 32:
			color = Color.DARK_GRAY;
			break;
		case 64:
			color = Color.BLUE;
			break;
		case 128:
			color = Color.MAGENTA;
			break;
		case 256:
			color = Color.PINK;
			break;
		case 512:
			color = Color.YELLOW;
			break;
		case 1024:
			color = Color.ORANGE;
			break;
		case 2048:
			color = Color.RED;
			break;
		default:
			color = Color.BLACK;
		}

		viewArea[x][y].setForeground(color);
		viewArea[x][y].setBorder(new LineBorder(color));
	}

}

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tamagochi extends JPanel {
	
	JFrame f;
	JPanel p;
	//переменная, которая отвечает за выбранное действие
	int action;
	//метка для вывода сообщений
	JLabel lm;

	public static void main(String[] args) {
		new Tamagochi();
	}

	Tamagochi() {
		f = new JFrame();
		f.setSize(600, 400);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createGridBagLayout();
		f.setVisible(true);
	}

	public void createGridBagLayout() {
		// создать объект менеджера компоновки
		GridBagLayout gbl = new GridBagLayout();
		f.setLayout(gbl);

		// создать вспомогательный объект для размещения отдельных компонент
		GridBagConstraints c = new GridBagConstraints();

		// значения полей для отдельных компонент
		// выравнивание компоненты внутри пространства
		c.anchor = GridBagConstraints.NORTH;
		// как компонента занимает отведенное пространство
		c.fill = GridBagConstraints.HORIZONTAL;
		// сколько ячеек займет компонента по высоте
		c.gridheight = 1;
		// сколько ячеек займет компонента по ширине
		c.gridwidth = 1;
		// отступы компоненты от полей
		c.insets = new Insets(10, 10, 10, 10);

		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 3;
		c.gridheight = 4;// для кнопки "b7"
		this.setPreferredSize(new Dimension(300, 300));
		this.setMinimumSize(new Dimension(300, 300));
		gbl.setConstraints(this, c);
		f.add(this);

		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth = 1;
		c.gridheight = 1;
		JButton b1 = new JButton("Играть");
		b1.addActionListener(new B1Listener());
		gbl.setConstraints(b1, c);
		f.add(b1);

		c.gridx = 0;
		c.gridy = 1;
		JButton b2 = new JButton("Туалет");
		
		gbl.setConstraints(b2, c);
		f.add(b2);

		c.gridx = 0;
		c.gridy = 2;
		JButton b3 = new JButton("Стричь когти");
		
		gbl.setConstraints(b3, c);
		f.add(b3);

		c.gridx = 0;
		c.gridy = 3;
		JButton b7 = new JButton("Говорить");
		
		gbl.setConstraints(b7, c);
		f.add(b7);

		c.gridx = 5;
		c.gridy = 0;
		JButton b4 = new JButton("Читать");
		
		gbl.setConstraints(b4, c);
		f.add(b4);

		c.gridx = 5;
		c.gridy = 1;
		JButton b5 = new JButton("Охотиться");
		b5.addActionListener(new B5Listener());
		gbl.setConstraints(b5, c);
		f.add(b5);

		c.gridx = 5;
		c.gridy = 2;
		JButton b6 = new JButton("Праздновать");
		b6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				action = 6;
				repaint();
			}
		});
		gbl.setConstraints(b6, c);
		f.add(b6);

		c.gridx = 0;
		c.gridy = 5;
		c.gridwidth = 5;
		lm = new JLabel("Привет! Я твой питомец, позаботься обо мне :)");
		gbl.setConstraints(lm, c);
		f.add(lm);
	}

	//метод отрисовки
	public void paintComponent(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(0, 0, 200, 200);

		//получаем спрайт питомца
		ImageIcon i1 = new ImageIcon(getClass().getResource("img/chihuahua-icon.png"));
		Image tam = i1.getImage();
		//рисуем питомца
		g.drawImage(tam, getWidth() / 2, getHeight() / 2, 90, 90, null);

		//КОМАНДНАЯ РАБОТА
		// какая кнопка была нажата
		switch (action) {
		//разработчик: katenech. Задача: кнопка Играть.
		case 1:
			ImageIcon i11 = new ImageIcon(getClass().getResource("/img/play.png"));
			Image ing1 = i11.getImage();
			g.drawImage(ing1, 100, 150, 50, 50, null);
			break;
		//разработчик: ______________
		//разработчик: DivanisAnatoly.Задача: кнопка Охотиться.
		case 3:
			ImageIcon i13 = new ImageIcon(getClass().getResource("/img/mouse.png"));
			Image ing3 = i13.getImage();
			g.drawImage(ing3, 100, 150, 50, 50, null);
		}
		//разработчик: ______________
		
		}

	

	//слушатель кнопки Играть
	class B1Listener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ee) {			
			action = 1;
			lm.setText("Minecraft рулит!");
			repaint();			
		}		
	}
	//слушатель кнопки Охотиться
	class B5Listener implements ActionListener{
		public void actionPerformed(ActionEvent eo) {
			action = 3;
			lm.setText("arghhh");
			repaint();
		}	
	}
}

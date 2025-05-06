package Screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class startscreen extends JFrame{

    public startscreen(){
        this.setTitle("Tela Inicial");
        this.setSize(600,400);
        this.setResizable(false);
		this.setLocationRelativeTo(null);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        JLabel apresentacao = new JLabel("Selecione abaixo qual unidade deseja converter!");
        JPanel panelN = new JPanel();
        JPanel panelC = new JPanel();
        c.add(panelN, BorderLayout.NORTH);
        c.add(panelC, BorderLayout.CENTER);

        JButton Bdistancia = new JButton("Distancia");
        JButton Bmass = new JButton("Massa");
        JButton Bvol = new JButton("Volume(litros)");
        JButton Bvolm = new JButton("Volume(m³)");

        panelC.setLayout(new GridLayout(3,2,5,5));
        panelC.add(Bdistancia);
        panelC.add(Bmass);
        panelC.add(Bvol);
        panelC.add(Bvolm);

        panelN.add(apresentacao);



    }
    

    
}

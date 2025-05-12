package Screen;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

public class startscreen extends JFrame{

    public startscreen(){

        this.setTitle("Tela Inicial");
        this.setSize(400,200);
        this.setResizable(false);
		this.setLocationRelativeTo(null);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());

        // JPANEL
        JPanel panelN = new JPanel();
        c.add(panelN, BorderLayout.NORTH);
        JPanel panelC = new JPanel();
        c.add(panelC, BorderLayout.CENTER);
        panelC.setLayout(new BorderLayout());
        JPanel panelCN = new JPanel();
        JPanel panelCW = new JPanel();
        panelCW.setLayout(new BoxLayout(panelCW, BoxLayout.Y_AXIS));
        JPanel panelCC = new JPanel();
        panelCC.setLayout(new BorderLayout());
        JPanel panelCE = new JPanel();
        panelCE.setLayout(new BoxLayout(panelCE, BoxLayout.Y_AXIS));

        panelC.add(panelCN, BorderLayout.NORTH);
        panelC.add(panelCW, BorderLayout.WEST);
        panelC.add(panelCE, BorderLayout.EAST);
        panelC.add(panelCC, BorderLayout.CENTER);

        // JLABEL
        JLabel apresentacao = new JLabel("Selecione abaixo qual unidade deseja converter!");
        apresentacao.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 16));
        panelN.add(apresentacao);
        JLabel igualdade = new JLabel("=");
        igualdade.setHorizontalAlignment(JLabel.CENTER);
        igualdade.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 30));
        panelCC.add(igualdade, BorderLayout.CENTER);
        
        // JTEXTFIELD
        JTextField conversorField = new JTextField(5);
        panelCW.add(conversorField);
        JTextField convertidoField = new JTextField(5);
        panelCE.add(convertidoField);
        
        //JBUTTON
        JButton converter = new JButton("Converter");
        panelCC.add(converter, BorderLayout.SOUTH);

        //VETORS
        String[] tipoDado = {"Volume","Distancia","Massa","Ângulo"};

        String[] Volume = {"Quilômetro cúbico","Hectômetro cúbico","Decâmetro cúbico",
        "Metro cúbico","Decímetro cúbico","Centímetro cúbico","Milímetro cúbico"};

        String[] Distancia = {"Quilômetro","Hectômetro","Decâmetro",
        "Metro","Decímetro","Centímetro","Milímetro"};

        String[] Massa = {"Tonelada","Quilograma","grama"};

        String[] Angulo = {"Graus", "Radianos"};

        //combobox
        
        JComboBox<String> tipo = new JComboBox<>(tipoDado);
        tipo.setSelectedItem(null);
        panelCN.add(tipo);

        JComboBox<String> conversor = new JComboBox<>();
        panelCW.add(conversor, FlowLayout.CENTER);

        JComboBox<String> convertido = new JComboBox<>();
        panelCE.add(convertido, FlowLayout.CENTER);
        
        //acionamento do combobox item
        tipo.addItemListener(new ItemListener(){
           
            public void itemStateChanged(ItemEvent e) {
            
                if(e.getStateChange() == ItemEvent.SELECTED){
                    conversor.removeAllItems();
                    convertido.removeAllItems();
                    switch (tipo.getSelectedIndex()) {
                        case 0:
                            for(String item: Volume){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            conversor.setSelectedItem(null);
                            convertido.setSelectedItem(null);
                            System.out.println("conversor: "+conversor.getItemCount());
                            System.out.println("convertido: "+convertido.getItemCount());
                            break;
                    
                        case 1:
                            for(String item: Distancia){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            conversor.setSelectedItem(null);
                            convertido.setSelectedItem(null);
                            System.out.println("conversor: "+conversor.getItemCount());
                            System.out.println("convertido: "+convertido.getItemCount());
                            break;
                        
                        case 2:
                            for(String item: Massa){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            conversor.setSelectedItem(null);
                            convertido.setSelectedItem(null);
                            System.out.println("conversor: "+conversor.getItemCount());
                            System.out.println("convertido: "+convertido.getItemCount());
                            break;

                        case 3:
                            for(String item: Angulo){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            conversor.setSelectedItem(null);
                            convertido.setSelectedItem(null);
                            System.out.println("conversor: "+conversor.getItemCount());
                            System.out.println("convertido: "+convertido.getItemCount());
                            break;

                    }
                }
            }
            
        });


    }

    
}

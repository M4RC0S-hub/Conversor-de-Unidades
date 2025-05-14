package Screen;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import model.converter;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class startscreen extends JFrame{
    private int numerodoconversor=-1,numerodoconvertido=-1;
    private String Tipo;
    private float numero;
    
    public startscreen(){

        this.setTitle("Conversor de Unidades");
        this.setSize(400,200);
        this.setResizable(false);
		this.setLocationRelativeTo(null);
        Container c = this.getContentPane();
        c.setLayout(new BorderLayout());
        ImageIcon icone = new ImageIcon("Conversor_de_Unidades/src/image/6739346.png");
		setIconImage(icone.getImage());

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
        convertidoField.setEditable(false);
        convertidoField.setBackground(Color.WHITE);
        
        //JBUTTON
        JButton converter = new JButton("Converter");
        panelCC.add(converter, BorderLayout.SOUTH);

        //VETORS
        String[] tipoDado = {"Volume","Distância","Massa","Ângulo"};

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
                    convertidoField.setText("");
                    conversor.removeAllItems();
                    convertido.removeAllItems();
                    Tipo = (String) tipo.getSelectedItem();
                    System.out.println(Tipo);
                    switch (tipo.getSelectedIndex()) {
                        case 0:
                            for(String item: Volume){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            break;
                    
                        case 1:
                            for(String item: Distancia){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            break;
                        
                        case 2:
                            for(String item: Massa){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            break;

                        case 3:
                            for(String item: Angulo){
                                conversor.addItem(item);
                                convertido.addItem(item);
                            }
                            break;

                    }
                    conversor.setSelectedItem(null);
                    convertido.setSelectedItem(null);
                    numerodoconversor=-1;
                    numerodoconvertido=-1;
                }
            }
            
        });

        conversor.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){

                if(e.getStateChange() == ItemEvent.SELECTED){
                numerodoconversor = conversor.getSelectedIndex();
                System.out.println(numerodoconversor);

                }
                
            }
        });

        convertido.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e){

                if(e.getStateChange() == ItemEvent.SELECTED){
                numerodoconvertido = convertido.getSelectedIndex();
                System.out.println(numerodoconvertido);

                }
                
            }
        });

        converter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String teste = conversorField.getText();
                if(numerodoconversor==-1 || numerodoconvertido==-1){
                    JOptionPane.showMessageDialog(null, "Selecione a unidade de medida.");
                }
                else{
                    if(teste.isEmpty()){
                        JOptionPane.showMessageDialog(null, "Insira um número para conversão.");
                    }
                    else{
                       
                        try {
                            numero = Float.parseFloat(teste);
                            System.out.println(numero);
                            converter objConverter = new converter();
                            convertidoField.setText(objConverter.calcular(numerodoconversor, numerodoconvertido, numero, Tipo));
                            
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Não é possível converter letras, apenas numeros.");                        
                        }
                        
                    }
                }
                
            }
            
        });


    }

    
}

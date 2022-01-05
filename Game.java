package com.company;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import javax.swing.JButton;
import java.awt.event.ActionListener;

class Game extends JFrame implements ActionListener {
    JLabel adversar,rezultat;
    JLabel ScorAdversar,ScorJucator;
    JButton button1=new JButton("Reincepe jocul");
    int Scor_Adversar=0;
    int Scor_Jucator=0;
    ImageIcon piatra,hartie,foarfeca;
    public void setup(){
        piatra=new ImageIcon(new ImageIcon("piatra.png").getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
        hartie=new ImageIcon(new ImageIcon("hartie.png").getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
        foarfeca=new ImageIcon(new ImageIcon("foarfeca.png").getImage().getScaledInstance(80,80,Image.SCALE_DEFAULT));
        button1.addActionListener(this);
        button1.setBounds(400,500,150,30);
        add(button1);
        JLabel scor=new JLabel("Scor");
        scor.setBounds(500,0,100,100);
        ScorAdversar=new JLabel();
        ScorAdversar.setText("Calculator : 0");
        ScorAdversar.setBounds(500,15,100,100);
        ScorJucator=new JLabel();
        ScorJucator.setText("Jucator : 0");
        ScorJucator.setBounds(500,30,100,100);
        adversar=new JLabel();
        adversar.setHorizontalTextPosition(JLabel.CENTER);
        adversar.setVerticalTextPosition((JLabel.BOTTOM));
        adversar.setBounds(250,90,100,100);

        JLabel label_calculator=new JLabel();
        label_calculator.setText("Calculator");
        label_calculator.setBounds(260,180,100,100);

        JLabel label_versus=new JLabel();
        label_versus.setText("VS");
        label_versus.setBounds(280,200,100,100);

        JLabel label_jucator=new JLabel();
        label_jucator.setText("Jucator");
        label_jucator.setBounds(264,220,100,100);
        rezultat=new JLabel();
        rezultat.setFont(new Font("Serif",Font.BOLD,20));
        rezultat.setBounds(250,450,100,100);

        JLabel label_piatra=new JLabel();
        label_piatra.setText("Piatra");
        label_piatra.setIcon(piatra);
        label_piatra.setHorizontalTextPosition(JLabel.CENTER);
        label_piatra.setVerticalTextPosition(JLabel.BOTTOM);
        label_piatra.setBounds(100,300,100,100);


        JLabel label_hartie=new JLabel();
        label_hartie.setText("Hartie");
        label_hartie.setIcon(hartie);
        label_hartie.setHorizontalTextPosition(JLabel.CENTER);
        label_hartie.setVerticalTextPosition(JLabel.BOTTOM);
        label_hartie.setBounds(250,300,100,100);

        JLabel label_foarfeca=new JLabel();
        label_foarfeca.setText("Foarfeca");
        label_foarfeca.setIcon(foarfeca);
        label_foarfeca.setHorizontalTextPosition(JLabel.CENTER);
        label_foarfeca.setVerticalTextPosition(JLabel.BOTTOM);
        label_foarfeca.setBounds(400,300,100,100);


        label_piatra.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                calculate(label_piatra.getText());

            }
        });
        label_foarfeca.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                calculate(label_foarfeca.getText());

            }
        });
        label_hartie.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                calculate(label_hartie.getText());

            }
        });
        add(label_piatra);
        add(label_hartie);
        add(label_foarfeca);
        add(adversar);
        add(rezultat);
        add(scor);
        add(ScorAdversar);
        add(ScorJucator);
        add(label_calculator);
        add(label_versus);
        add(label_jucator);
        setLayout(null);
    }
    public void calculate(String Jucator){
        String[] list={"Piatra","Hartie","Foarfeca"};
        int random=(int)((Math.random()*10)%3);
        String calculator=list[random];
        adversar.setText(calculator);
        if(random==0){
            adversar.setIcon(piatra);
        }
        else if(random==1){
            adversar.setIcon(hartie);
        }
        else
        {
            adversar.setIcon(foarfeca);
        }
        String rez="";
        if(Jucator.equals(calculator)){
            rez="Egalitate";
        }
        else if(Jucator.equals("Piatra")) {
            if (calculator.equals(("Hartie"))) {
                rez = "Ai pierdut!";
                Scor_Adversar++;
            } else {
                rez = "Ai castigat!";
                Scor_Jucator++;
            }
        }
        else if(Jucator.equals("Hartie")){
            if(calculator.equals("Foarfeca")){
                rez="Ai pierdut!";
                Scor_Adversar++;
            }
            else{
                rez="Ai castigat!";
                Scor_Jucator++;
            }
        }
        else{
            if(calculator.equals("Piatra")){
                rez="Ai pierdut!";
                Scor_Adversar++;
            }
            else{
                rez="Ai castigat!";
                Scor_Jucator++;

            }
        }
        rezultat.setText(rez);
        ScorJucator.setText("Jucator : "+Scor_Jucator);
        ScorAdversar.setText("Calculator : "+Scor_Adversar);
    }
    public static void main(String[] args){
        Game g=new Game();
        g.setTitle("Piatra Hartie Foarfeca");
        g.setBounds(200,200,600,600);
        g.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        g.getContentPane().setBackground(Color.WHITE);
        g.setup();
        g.setResizable(false);
        g.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==button1)
        {
            Scor_Adversar=0;
            Scor_Jucator=0;
            ScorJucator.setText("Jucator : "+Scor_Jucator);
            ScorAdversar.setText("Calculator : "+Scor_Adversar);
        }
    }
}


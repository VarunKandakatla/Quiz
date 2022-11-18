import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        frameClass x=new frameClass();

        String Questions[]={    "Q1.Who is the President of India?",
                "Q2.Who is the Father of our Nation?",
                "Q3.Name the National river in India?",
                "Q4.Name the Biggest Continent in the World?",
                "Q5.Name the Longest river in the Earth?",
                "Q6.Who is the First Prime Minister of India?",
                "Q7.How many Millimeters are their in a Centimeter?",
                "Q8.Name the largest Democratic Country in the World?",
                "Q9.Which festival is known as festival of lights?",
                "Q10.Name the Capital of India?"};

        String Answers[]={"smt.Droupadhi Murmu","Mahathma Gandhi","Ganga",
                "Asia","Nile","Jawaharlal Nehru","10 millimeters",
                "India","Diwali","New Delhi"};

        List<String> list=new ArrayList<>();
        list.add("Narendra Modi,Pranab Mukherje,smt.Droupadhi Murmu,Ramnath Kovind");
        list.add("Jawaharlal Nehru,Mahathma Gandhi,Sardar Vallabai Patel,Vajpayee");
        list.add("Brahmaputra,Krishna,Kaveri,Ganga");
        list.add("Russia,Asia,Africa,America");
        list.add("Nile,Amazon,Krishna,Niagara");
        list.add("Dr.Rajendra Prasad,Jawaharlal Nehru,A.P.J Abdul Kalam,Indira Gandhi");
        list.add("12 millimeters,15 millimeters,11 millimeters,10 millimeters");
        list.add("Russia,India,America,Canada");
        list.add("Holi,Shivrathri,Diwali,Krishnastami");
        list.add("Mumbai,Delhi,Dilli,New Delhi");

        x.hm=new HashMap<>();

        for(int i=0;i<Questions.length;i++)
        {
            x.hm.put(Questions[i], list.get(i));
        }

        x.Q=Questions;
        x.Ans=Answers;

    }
}

class frameClass implements ActionListener {

    //creating Frame
    JFrame frame;
    JButton next;
    JRadioButton A,B,C,D;

    //Title
    JLabel l;
    //indexes
    static int j=0;

    //Score
    static int count=0;
    //Questions String
    static String Q[];
    //Answers String
    static String Ans[];
    //HashMap<Question,Option list>
    static HashMap<String,String> hm;

    //CONSTRUCTOR
    frameClass()
    {

        frame=new JFrame("Quiz");
        frame.setVisible(true);
        frame.setLayout(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(3);
        //Setting BackGround
        Container cnt=frame.getContentPane();
        cnt.setBackground(Color.BLACK);

        //LENGTHS OF FRAME
        int x=frame.getWidth();
        int y=frame.getHeight();

        //Next Button-start-Score Button
        next=new JButton("Next");
        next.setBounds(x-200,y-200,100,40);
        frame.add(next);

        //if 0 == Welcome && Q.length+1==Score
        if(j==0 || j==Q.length+1)
        {
            //setting Font
            Font f4=new Font("",Font.BOLD,80);
            //label
            l=new JLabel();
            l.setBounds(x/3,y/4,800,300);
            l.setFont(f4);
            l.setForeground(Color.yellow);
            frame.add(l);

            //Welcome
            if(j==0)
            {
                l.setText("Welcome");
                next.setText("Start");
            }
            else        //last Score
            {
                l.setText("Your Score: "+count+"/"+Q.length);
                next.setText("Restart");
            }
        }
        //Questions
        if(j>=1 && j<= Q.length)
        {
            String Ques=Q[j-1];
            //converting string to options
            String ans=hm.get(Ques);
            String arr[]=ans.split(",");

            A=new JRadioButton(arr[0]);
            B=new JRadioButton(arr[1]);
            C=new JRadioButton(arr[2]);
            D=new JRadioButton(arr[3]);

            ButtonGroup bg=new ButtonGroup();

            bg.add(A);
            bg.add(B);
            bg.add(C);
            bg.add(D);
            //Setting Fonts to Question and Options
            Font f=new Font("",Font.CENTER_BASELINE,40);
            Font f1=new Font("",Font.LAYOUT_LEFT_TO_RIGHT | Font.BOLD,20);

            //Question and Options height and Width Setting
            l=new JLabel(Ques);
            l.setBounds(50,40,x-60,100);
            l.setFont(f);
            l.setForeground(Color.white);

            A.setBounds(120,150,300,50);
            B.setBounds(500,150,300,50);
            C.setBounds(120,220,300,50);
            D.setBounds(500,220,300,50);

            //Setting BackGround of button
//            A.setBackground(Color.BLACK);
//            B.setBackground(Color.BLACK);
//            C.setBackground(Color.BLACK);
//            D.setBackground(Color.BLACK);

            //Setting Button Text Color
//            A.setForeground(Color.white);
//            B.setForeground(Color.white);
//            C.setForeground(Color.white);
//            D.setForeground(Color.white);


            A.setFont(f1);
            B.setFont(f1);
            C.setFont(f1);
            D.setFont(f1);

            frame.add(A);
            frame.add(B);
            frame.add(C);
            frame.add(D);

            frame.add(l);

            A.addActionListener(this);
            B.addActionListener(this);
            C.addActionListener(this);
            D.addActionListener(this);

        }
        next.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //checking and Increment the nextbutton and Indexes
        if(e.getSource()==next) {
            //increment index
            j++;
            //creating new frame
            new frameClass();
            //disposing previous frame
            frame.dispose();
        }
        //for Displaying Score --> Q.length+1
        if(Q.length+1==j)
        {
            j=0;
            count=0;
        }
        //Score Counting
        if(e.getActionCommand().equals(Ans[j - 1]))
        {
            count++;
        }

    }

}
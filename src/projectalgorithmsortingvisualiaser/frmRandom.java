package projectalgorithmsortingvisualiaser;


import projectalgorithmsortingvisualiaser.auth.ConnToDB;
import projectalgorithmsortingvisualiaser.sortingAlgorithms.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class frmRandom extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    static Thread thrd;
    pnlAnimation ani;
    JButton btnStart;
    JButton btnReset;
    JComboBox<String> cmbSort;
    frmRandom obj;
    boolean thrdRun=false;
    boolean running=false;
    boolean reset=true;
    boolean start=false;
    String lastPicked="";
    String sel;

    public frmRandom() {
        obj=this;
        init();
        init2();
        Toolkit tkt= Toolkit.getDefaultToolkit();
        setSize(tkt.getScreenSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    public final void init() {
        getContentPane().setBackground(Color.DARK_GRAY);
        cmbSort = new javax.swing.JComboBox<>();
        cmbSort.setEnabled(false);
        btnStart = new javax.swing.JButton();
        btnReset= new JButton("Reset");
        ani=new pnlAnimation();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        btnStart.setText("Start");

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
                { " ","BubbleSort", "InsertionSort", "MergeSort", "SelectionSort", "HeapSort",
                        "QuickSort","CountSort","RadixSort","CycleSort","PancakeSort","BitonicSort","CombSort",
                        "StoogeSort","GnomeSort"}));

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                dispose();
                Constant.frmSelector.setVisible(true);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(ani, javax.swing.GroupLayout.PREFERRED_SIZE, 1500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE).addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cmbSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnStart))
                                .addComponent(btnReset)
                                .addComponent(ani, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(18, Short.MAX_VALUE))
        );
    }

    public final void init2() {

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(false);
                reset=false;
                cmbSort.setEnabled(true);
                if(!thrdRun) {
                    thrd = new Thread(obj);
                    thrd.start();
                    thrdRun=true;
                }
                else {
                    System.out.println("Start");
                }
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnStart.setEnabled(true);
                thrdRun=false;
                thrd.stop();
                reset=true;
                thrd= new Thread(obj);
                thrd.start();
            }
        });

        cmbSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String temp=String.valueOf(cmbSort.getSelectedItem());
                int choice = JOptionPane.showConfirmDialog(null,
                        "Are you sure with your selection "+ ConnToDB.user.getFirstName()+"?","Are you sure?"
                        ,JOptionPane.YES_NO_OPTION);
                if(choice==0) {
                    sel=temp;
                    cmbSort.setEnabled(false);
                    if(sel.equals(lastPicked)) {
                        JOptionPane.showMessageDialog(null, "You picked correct algorithm, Congrats!");
                        ConnToDB cc = new ConnToDB("");
                        System.out.println("User email "+ConnToDB.user.getEmail());
                        cc.updateLeaderBoard(ConnToDB.user.getEmail());
                    }
                    else {
                        JOptionPane.showMessageDialog(null,
                                "You have selected "+sel+"\n"+"But answer is "+lastPicked);
                    }
                }
                else {
                    System.out.println(sel);
                }
            }
        });
    }

    @Override
    public void run() {
        if(reset) {
            ani.reset();
            reset=false;
        }
        else {
            try  {
                ani.reset();
                Thread.sleep(2000);
                Random rnd = new Random();
                int random= rnd.nextInt(15);
                System.out.println(random);
                switch(random) {
                    case 0:
                        lastPicked="BitonicSort";
                        new BitonicSort(ani).sort();
                        break;
                    case 1:
                        lastPicked="BubbleSort";
                        new BubbleSort(ani).sort();
                        break;
                    case 2:
                        lastPicked="CombSort";
                        new CombSort(ani).sort();
                        break;
                    case 3:
                        lastPicked="CountSort";
                        new CountSort(ani).sort();
                        break;
                    case 4:
                        lastPicked="CycleSort";
                        new CycleSort(ani).sort();
                        break;
                    case 5:
                        lastPicked= "GnomeSort";
                        new GnomeSort(ani).sort();
                        break;
                    case 6:
                        lastPicked="HeapSort";
                        new HeapSort(ani).sort();
                        break;
                    case 7:
                        lastPicked="InsertionSort";
                        new InsertionSort(ani).sort();
                        break;
                    case 8:
                        lastPicked="MergeSort";
                        new MergeSort(ani).sort();
                        break;
                    case 9:
                        lastPicked="PancakeSort";
                        new PancakeSort(ani).sort();
                        break;
                    case 10:
                        lastPicked="QuickSort";
                        new QuickSort(ani).sort();
                        break;
                    case 11:
                        lastPicked="RadixSort";
                        new RadixSort(ani).sort();
                        break;
                    case 12:
                        lastPicked="SelectionSort";
                        new SelectionSort(ani).sort();
                        break;
                    case 13:
                        lastPicked="StoogeSort";
                        new StoogeSort(ani).sort();
                        break;
                }
                ani.finalise();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

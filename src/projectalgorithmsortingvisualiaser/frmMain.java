package projectalgorithmsortingvisualiaser;

import projectalgorithmsortingvisualiaser.sortingAlgorithms.*;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * frmMain
 */
public class frmMain extends JFrame implements Runnable {
    private static final long serialVersionUID = 1L;
    static Thread thrd;
    pnlAnimation ani;
    JComboBox<String> cmbSort;
    JButton btnStart;
    JButton btnReset;
    String sel="";
    boolean thrdRun=false;
    boolean running=false;
    frmMain obj;
    boolean reset=true;
    boolean start=false;
    
    public frmMain() {
        obj=this;
        init();
        init2();
        Toolkit tkt= Toolkit.getDefaultToolkit();
        setSize(tkt.getScreenSize());
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        sel=String.valueOf(cmbSort.getSelectedItem());
    }
    
    public final void init() {
        getContentPane().setBackground(Color.DARK_GRAY);
        cmbSort = new javax.swing.JComboBox<>();
        btnStart = new javax.swing.JButton();
        btnReset= new JButton("Reset");
        ani=new pnlAnimation();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
                { "BubbleSort", "InsertionSort", "MergeSort", "SelectionSort", "HeapSort",
                        "QuickSort","CountSort","RadixSort","CycleSort","PancakeSort","BitonicSort"," " }));

        btnStart.setText("Start");

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
        
        cmbSort.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sel=String.valueOf(cmbSort.getSelectedItem());
                System.out.println(sel);
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
                new frmMain();
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
                if(sel.equals("BubbleSort")) {
                    new BubbleSort(ani).sort();
                    ani.resetColors();
                }
                else if(sel.equals("InsertionSort")) {
                    new InsertionSort(ani).sort();
                }
                else if(sel.equals("SelectionSort")){
                    new SelectionSort(ani).sort();
                }
                else if(sel.equals("HeapSort")) {
                    new HeapSort(ani).sort();
                }
                else if(sel.equals("MergeSort")) {
                    new MergeSort(ani).sort();
                }
                else if(sel.equals("QuickSort")) {
                    new QuickSort(ani).sort();
                }
                else if(sel.equals("CountSort")) {
                    new CountSort(ani).sort();
                }
                else if(sel.equals("RadixSort")) {
                    new RadixSort(ani).sort();
                }
                else if(sel.equals("CycleSort")) {
                    new CycleSort(ani).sort();
                }else if(sel.equals("PancakeSort")) {
                    new PancakeSort(ani).sort();
                }else if(sel.equals("BitonicSort")) {
                    new BitonicSort(ani).sort();
                }
                ani.finalise();
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }
        }
        
    }
}
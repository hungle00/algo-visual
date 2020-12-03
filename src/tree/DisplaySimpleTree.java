package tree;

import javax.swing.*;
//import javax.swing.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class DisplaySimpleTree extends JFrame {

    private static final long serialVersionUID = 1L;
    
    JScrollPane scrollpane;
    DisplayPanel panel;
  

    public DisplaySimpleTree() {
        MyTree t = buildTree();
        panel = new DisplayPanel(t);
        panel.setPreferredSize(new Dimension(500, 500));
        scrollpane = new JScrollPane(panel);
        getContentPane().add(scrollpane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        pack();  // cleans up the window panel
    }

    public static MyTree buildTree() {
      MyTree t = new MyTree(); // t is Binary tree we are displaying
      BufferedReader diskInput;
      String word;
      try { //reads in words from a file
        diskInput = new BufferedReader(new InputStreamReader(new FileInputStream(new File("input.txt"))));
        Scanner input = new Scanner(diskInput);
        while (input.hasNext()) { 
          word=input.next();
          word=word.toLowerCase(); // use lower case only
          t.root = t.insert(t.root, word);  //insert word into Binary Search Tree
          t.inputString= t.inputString + " " + word; // add word to input string
        }
      }
      catch (IOException e) {
          System.out.println("io exception");
        }

      t.computeNodePositions(); //finds x,y positions of the tree nodes
      t.maxheight=t.treeHeight(t.root);
      
      return t;
    }
    public static void main(String[] args) {

      DisplaySimpleTree dt = new DisplaySimpleTree();//get a display panel
      dt.setVisible(true); //show the display
      dt.setTitle("Binary tree");
    }
}

class DisplayPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    MyTree t;
    int xs;
    int ys;

    public DisplayPanel(MyTree t) {
      this.t = t; // allows dispay routines to access the tree
      setBackground(Color.white);
      setForeground(Color.blue);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(getBackground()); //colors the window
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(getForeground()); //set color and fonts
      Font MyFont = new Font("SansSerif",Font.PLAIN,12);
      g.setFont(MyFont);
      xs=20;   //where to start printing on the panel
      ys=20;
      g.drawString("Binary Search tree for the input string:\n",xs,ys);
      ys = ys + 10;
      int start=0;
      //  print input string on panel, 150 chars per line
      // if string longer than 23 lines don't print
      if(t.inputString.length() < 23*150){
           while((t.inputString.length()-start)>150){
              g.drawString(t.inputString.substring(start,start+150),xs,ys);        
              start+=151;
              ys+=15;
           }
           g.drawString(t.inputString.substring(start,t.inputString.length()),xs,ys);
      }
      xs = xs + 10;
      MyFont = new Font("SansSerif",Font.BOLD,30); //bigger font for tree
      g.setFont(MyFont);
      this.drawTree(g, t.root); // draw the tree
      revalidate(); //update the component panel
    }

    public void drawTree(Graphics g, Node root) {//actually draws the tree
      Graphics2D g2D = (Graphics2D) g;
      g2D.setStroke(new BasicStroke(3));
      g.setColor(Color.GRAY);
      int dx, dy, dx2, dy2;
      int SCREEN_WIDTH=1000; //screen size for panel
      int SCREEN_HEIGHT=700;
      int XSCALE, YSCALE;  
      XSCALE=(SCREEN_WIDTH)/t.totalnodes; //scale x by total nodes in tree
      YSCALE=(SCREEN_HEIGHT-ys)/(t.maxheight+1); //scale y by tree height
      System.out.println(xs);
      if (root != null) { // inorder traversal to draw each node
        drawTree(g, root.left); // do left side of inorder traversal 
        dx = root.xpos * XSCALE; // get x,y coords., and scale them 
        dy = root.ypos * YSCALE + ys;
        String s = (String) root.data; //get the word at this node
        g.drawString(s, dx - 5, dy - 5); // draws the word
        g.drawOval(dx-2, dy-2, 7, 7);
        if(root.left!=null){ //draws the line to left child if it exists
          dx2 = root.left.xpos * XSCALE; 
          dy2 = root.left.ypos * YSCALE +ys;
          g.drawLine(dx,dy,dx2,dy2);
        }
        if(root.right!=null){ //draws the line to right child if it exists
          dx2 = root.right.xpos * XSCALE;//get right child x,y scaled position
          dy2 = root.right.ypos * YSCALE + ys;
          g.drawLine(dx,dy,dx2,dy2);
        }
        drawTree(g, root.right); //now do right side of inorder traversal 
      }
    }
}
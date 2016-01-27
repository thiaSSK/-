import javax.swing.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TreeSet;

public class SwingTest extends JFrame{

	/*  public static void main(String[] args){
            //ディレクトリ指定
            String path = "/Users/Rokuden/Documents";
            File dir = new File(path);
            
            //フルパスで取得
            System.out.println("--ファイル一覧(フルパス)--");
            File[] files1 = dir.listFiles();
            for (int i = 0; i < files1.length; i++) {
               File file = files1[i];
               if (files1[i].isFile()){
                   //ファイル名表示
                    System.out.println(file);
               }else if (files1[i].isDirectory()){
                   //ディレクトリ名表示(※１)
                   System.out.println(file);
                }
            }
        }
}*/


  private String[][] tabledata = {
    {"日本", "3勝", "0敗", "1分"},
    {"クロアチア", "3勝", "1敗", "0分"},
    {"ブラジル", "1勝", "2敗", "1分"},
    {"オーストラリア", "2勝", "2敗", "0分"}};

  private String[] columnNames = {"FILE", "ID"};

  public static void main(String[] args){
    SwingTest test = new SwingTest("SwingTest");

    test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    test.setVisible(true);
  }
  

  SwingTest(String title){
    setTitle(title);
    setBounds( 10, 10, 300, 200);
    
    String path = "/Users/Rokuden/Documents";
    File dir = new File(path);
    
    //フルパスで取得
    //System.out.println("--ファイル一覧(フルパス)--");

    File[] files1 = dir.listFiles();
    
    Object[][] obj = new Object[files1.length][2];
    
    for (int i = 0; i < files1.length; i++) {
    	/*
       File file = files1[i];
       if (files1[i].isFile()){
           //ファイル名表示
            System.out.println(file);
       }else if (files1[i].isDirectory()){
           //ディレクトリ名表示(※１)
           System.out.println(file);
        }
        */

    	obj[i][0] = i;
    	obj[i][1] = files1[i];

    }
    JTable table = new JTable(obj, columnNames);

    JScrollPane sp = new JScrollPane(table);
    sp.setPreferredSize(new Dimension(800, 70));

    JPanel p = new JPanel();
    p.add(sp);

    getContentPane().add(p, BorderLayout.CENTER);
  }
}

class TableContents {
	public File file;
	public int id;
	
	TableContents(File f, int i) {
		file = f;
		id = i;
	}
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package imageencrypt;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;   
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.*;
import java.io.BufferedWriter;
    
/**
 
 * @author Deepanker01
 */
public class ImageEncrypt {

    public String enc[]=new String[81];
    public String[][] finalarr  = {{"", "","", "","","","","","",""}, {"", "","","","","","","","",""}
   ,{"", "","","","","","","","",""},{"", "","","","","","","","",""},{"", "","","","","","","","",""}
   ,{"", "","","","","","","","",""},{"", "","","","","","","","",""},{"", "","","","","","","","",""}
    ,{"", "","","","","","","","",""}   };
     public String[][] finalarr2  = {{"", "","", "","","","","","",""}, {"", "","","","","","","","",""}
   ,{"", "","","","","","","","",""},{"", "","","","","","","","",""},{"", "","","","","","","","",""}
   ,{"", "","","","","","","","",""},{"", "","","","","","","","",""},{"", "","","","","","","","",""}
    ,{"", "","","","","","","","",""}   };

    String new1 = new String();
   String[] newarr = new String [100];
String [] dnastringdec = new String[100];
String decrpytbinary = new String();
    private String fsignString2;

        public void convertToBinary() throws IOException{
            
            System.out.println("hello");
                try {
                     FileWriter fw = new FileWriter("pingresult.txt");
             BufferedWriter bw = new BufferedWriter(fw);

                BufferedImage image = ImageIO.read(new File("bill.jpg"));
                ByteArrayOutputStream b = new ByteArrayOutputStream();
                ImageIO.write(image, "jpg", b);
            
                byte[] jpgByteArray = b.toByteArray();
                StringBuilder sb = new StringBuilder();
                for (byte by : jpgByteArray)
                 sb.append(Integer.toBinaryString(by & 0xFF));
                new1 = sb.toString();
                bw.write(new1);
             
                    } catch (IOException e) {
                }
    
		 
    }
        
    public void encryption() throws IOException
    {
     
   String temp = new String();  
        String arr[] = new String[100000];
       System.out.println(new1);
    
        for(int  i=0; i<(new1.length())/100;i++)
    {
    arr[i]= new1.substring(i*100,(i+1)*100);
        System.out.println(arr[i] + "\t");
       
       newarr[i]=converttodna(arr[i]);
    }
         String abc = new1.substring(6700, 6738);
   newarr[67] = converttodna(abc);
   
    System.out.println(newarr.length);
    System.out.println(newarr[67]);

    // for(int b=0;b<newarr.length;b++)
//  System.out.println(newarr[b]);
//  System.out.println(newarr[67]);
  matrixinput(); 
 encryptinmatrix();
    stringtomatrix();
    mstringtoastring();
    
    System.out.println(dnastringdec[0]);
    System.out.println(dnastringdec.length);
    
    for(int z=0;z<dnastringdec.length;z++)
    {   
    String pure = dnastringdec[0];
     temp = dnatobinary(pure);
     decrpytbinary = decrpytbinary + temp;
    }
     
 System.out.println("decrypt is " + decrpytbinary);
  System.out.println("decryptlength is " + decrpytbinary.length());
 
   
    }
   
    
    public String converttodna(String a ) throws IOException
    {

   	String fsignString="";
       
        for( int k=0; k<a.length()/2;k++)
	{   

            if("00".equals(a.substring(k*2,(k+1)*2)))
                fsignString = fsignString + "G";
            if("01".equals(a.substring(k*2,(k+1)*2)))
                fsignString = fsignString + "A";
            if("10".equals(a.substring(k*2,(k+1)*2)))
                fsignString = fsignString + "T";
            if("11".equals(a.substring(k*2,(k+1)*2)))
                fsignString = fsignString + "C";
                }
        
         return fsignString;
     }
    
    void matrixinput()
    {
    finalarr[0][0]= "0";
    finalarr[0][1]= "0";
    finalarr[0][2]= "0";
    finalarr[0][3]= "0";
    
    for(int z=0;z<9;z++)
      finalarr[8][z]= "0";
    
    for(int z=4;z<9;z++)
    finalarr[0][z] = newarr[z-4];
    
    
    
    for(int z=0;z<9;z++)
    finalarr[1][z] = newarr[z+5];
    
    //System.out.println(finalarr[1][0]);
    for(int z=0;z<9;z++)
    finalarr[2][z] = newarr[z+14];
    
    for(int z=0;z<9;z++)
    finalarr[3][z] = newarr[z+23];
    
    for(int z=0;z<9;z++)
     finalarr[4][z] = newarr[z+32];
    
    for(int z=0;z<9;z++)
      finalarr[5][z] = newarr[z+41];
    
     for(int z=0;z<9;z++)
      finalarr[6][z] = newarr[z+50];
    
     for(int z=0;z<9;z++)
      finalarr[7][z] = newarr[z+59];
                    

  
  for(int p=0;p<9;p++)
  {
  for(int q=0;q<9;q++)
  {
  System.out.println(finalarr[p][q]);
  }
  }
    }
    
    public void encryptinmatrix()
    {
  int h=0;
       
        for(int i=0;i<9;i++)
        enc[h++]=finalarr[0][i];
    
        
        for(int i=1;i<9;i++)
        {
            enc[h++]=finalarr[i][8];
        }
        
       for(int j=7;j>=0;j--)
        {
        enc[h++]=finalarr[8][j]; 
        }
           for(int i=7;i>=1;i--)
        {
        enc[h++]=finalarr[i][1]; 
        }
      
           for(int j=1;j<=7;j++)
        {
        enc[h++]=finalarr[1][j]; 
        }
           
           for(int i=2;i<=7;i++)
        {
        enc[h++]=finalarr[i][7]; 
        }
          
     for(int j=6;j>=1;j--)
        {
        enc[h++]=finalarr[7][j]; 
        }

     for(int i=6;i>=2;i--)
        {
        enc[h++]=finalarr[i][1]; 
        }
     
     for(int j=2;j<=6;j++)
        {
        enc[h++]=finalarr[2][j]; 
        }
     
       for(int i=3;i<=6;i++)
        {
        enc[h++]=finalarr[i][6]; 
        }
     
     for(int j=5;j>=2;j--)
        {
        enc[h++]=finalarr[6][j]; 
        }
     
      for(int j=5;j>=3;j--)
        {
        enc[h++]=finalarr[j][2]; 
        }
    
      for(int i=3;i<=5;i++)
        {
        enc[h++]=finalarr[3][i]; 
        }
          for(int i=4;i<=5;i++)
        {
        enc[h++]=finalarr[i][5]; 
        }
     
     for(int j=4;j>=3;j--)
        {
        enc[h++]=finalarr[5][j]; 
        }
     
     enc[h++]=finalarr[4][3];
     
     enc[h]=finalarr[4][4];
     
     System.out.println(h);
     
     for(int z=0;z<enc.length;z++)
     {
         System.out.println(enc[z]);
     }
    
    }
    
    
    public void stringtomatrix()
    {
    int q=78;
    finalarr2[4][4]= enc[80];
finalarr2[4][3] = enc[79];
        
        for(int i=3;i<=5;i++)
        {
        finalarr2[5][i] = enc[q--]; 
        }   
          for(int i=4;i>=3;i--)
        {
        finalarr2[i][5] = enc[q--]; 
        }   
         for(int i=4;i>=2;i--)
        {
        finalarr2[3][i] = enc[q--]; 
        }   
          for(int i=4;i<=6;i++)
        {
        finalarr2[i][2] = enc[q--]; 
        }   
         for(int i=3;i<=6;i++)
        {
        finalarr2[6][i] = enc[q--]; 
        }   
           for(int i=5;i>=2;i--)
        {
        finalarr2[i][6] = enc[q--]; 
        }   
           for(int i=5;i>=1;i--)
        {
        finalarr2[2][i] = enc[q--]; 
        }   
  
           for(int i=3;i<=7;i++)
        {
        finalarr2[i][1] = enc[q--]; 
        }   
  
           for(int i=2;i<=7;i++)
        {
        finalarr2[7][i] = enc[q--]; 
        }   
                for(int i=6;i>=1;i--)
        {
        finalarr2[i][7] = enc[q--]; 
        }   
             for(int i=6;i>=0;i--)
        {
        finalarr2[1][i] = enc[q--]; 
        }   
            for(int i=2;i<=8;i++)
        {
        finalarr2[i][0] = enc[q--]; 
        }   
             for(int i=1;i<=8;i++)
        {
        finalarr2[8][i] = enc[q--]; 
        }   
             for(int i=7;i>=0;i--)
        {
        finalarr2[i][8] = enc[q--]; 
        }   
             for(int i=7;i>=0;i--)
        {
        finalarr2[0][i] = enc[q--]; 
        }   
  
    }
    
    
    public void mstringtoastring()
    {
        int r=0;
     for(int z=4;z<9;z++)
    dnastringdec[r++] = finalarr2[0][z];
    
    System.out.println("r is " + r);
    
    for(int z=1;z<=7;z++)
    {
    for(int t=0;t<=8;t++)
    {
    dnastringdec[r++] = finalarr2[z][t];
    }
     }
    System.out.println("r is " + r);
     System.out.println("last is " + dnastringdec[67]);
    }
    
    
    public String dnatobinary(String s)
    {
        fsignString2 = new String();
        char[] carr = new char[10000];
        
carr = s.toCharArray();

    for(int k=0; k<carr.length;k++)
    {
        if(carr[k]=='A')
          fsignString2 = fsignString2 + "01";
         
        if(carr[k]=='T')
         fsignString2 = fsignString2 + "10";
        
        if(carr[k]=='G')
          fsignString2 = fsignString2 + "00";
        
        if(carr[k]=='C')
          fsignString2 = fsignString2 + "11";
 //System.out.println("k is " + k);
    }
   
return fsignString2;    
    
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
    ImageEncrypt ob = new ImageEncrypt();
//image to binary
        ob.convertToBinary();
        
        //all functions
           ob.encryption();
           
    
        // TODO code application logic here
    }

    private void String() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

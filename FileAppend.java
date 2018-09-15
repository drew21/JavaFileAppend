import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileAppend {

    public static void main(String[] args) {
        
        File f=new File("C:\\Users\\Drew\\Documents\\lmco\\test.txt");
        
        FileInputStream fs = null;
        InputStreamReader in = null;
        BufferedReader br = null;
        
        StringBuffer sb = new StringBuffer();
        
        String textinLine;
        
        try {
             fs = new FileInputStream(f);
             in = new InputStreamReader(fs);
             br = new BufferedReader(in);
            
			String str = "cleartool mv ";
            while(true)
            {
                textinLine=br.readLine();
                if(textinLine==null)
				{
					sb.append("\n");
                    break;
				}
				else if(textinLine.endsWith("x"))
				{
					sb.append(str);
					// take out x
					String strnox = textinLine.substring(0,textinLine.length()-1);
					sb.append(strnox);
					sb.append(" ");
					sb.append(textinLine);
					sb.append("\n");
				}
            } // ends while

              fs.close();
              in.close();
              br.close();

            } catch (FileNotFoundException e) {
              e.printStackTrace();
            } catch (IOException e) {
              e.printStackTrace();
            }
            
            try{
                FileWriter fstream = new FileWriter(f);
                BufferedWriter outobj = new BufferedWriter(fstream);
                outobj.write(sb.toString());
                outobj.close();
                
            }catch (Exception e){
              System.err.println("Error: " + e.getMessage());
            }
    }// main
}
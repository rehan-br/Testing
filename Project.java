import java.io.*;
import java.util.StringTokenizer;

public class Project{
    public static void main(String[] args){
        File fl = new File("pics.csv");
        File fl1 = new File("Project.MD");

        try{
            if(fl1.exists()){
                System.out.println("File exists");
            }else{
                fl1.createNewFile();
            }
        }
        catch(Exception e){
            System.out.println(e);
        }

        try{
            if(fl.exists()){
                BufferedReader br = new BufferedReader(new FileReader(fl));
                BufferedWriter bw = new BufferedWriter(new FileWriter(fl1, true));
                String str = "";
                while((str = br.readLine()) != null){
                    StringTokenizer st = new StringTokenizer(str, ",");
                    
                    String link = st.nextToken();

                    System.out.println("Link: " + link);

                    bw.write("\n![Image](" + link + ")");
                }

                br.close();
                bw.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
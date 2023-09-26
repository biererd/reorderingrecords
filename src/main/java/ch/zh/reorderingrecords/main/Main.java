package ch.zh.reorderingrecords.main;

import java.io.*;
import java.nio.charset.StandardCharsets.*;
import java.util.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main
    {
    
    private static final Logger LOGGER = LogManager.getLogger(Main.class);
    
    
    public static void main(String[] args) throws Exception
        {
        
        try
            {
        
            Conf conf = Conf.getConf(args[0]);
            String fileInput  = conf.fileInput();
            String fileOutput = conf.fileOutput();
            
            
            String headline1 = null;
            String headline2 = null;
            ArrayList<Line> lineRecords = new ArrayList<Line>();
    
            LOGGER.info("Reading the input file");
            FileInputStream   fis = new FileInputStream(fileInput);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader    br  = new BufferedReader(isr);
            try 
                {
                headline1 = br.readLine();
                headline2 = br.readLine();
                
                String line;
                
                while ((line = br.readLine()) != null)
                    {
                    String identifier = line.split("\\|")[1];
                    Line lineRecord = new Line(identifier,line);
                    lineRecords.add(lineRecord);
                    }
                }
           catch(Exception e)
               {
               log(e);
               }
           finally
               {
               br.close();
               isr.close();
               fis.close();
               }

            LOGGER.info("Reordering");
            Collections.sort(lineRecords);
            
            
            
            LOGGER.info("Writing the output file");
            for(int i=0;i<lineRecords.size();i++)
                {
                LOGGER.info(lineRecords.get(i).line());
                }
            
            FileOutputStream fos = new FileOutputStream(fileOutput);
            OutputStreamWriter writer = new OutputStreamWriter(fos,"UTF-8");
            try
                {
                
                }
            catch(Exception e)
                {
                log(e);
                }
            finally
                {
                writer.close();
                fos.close();
                }
            
            }
        catch(Exception e)
            {
            log(e);
            }
        }
    
    
    private static void log(Exception e)
        {
        LOGGER.error(e);
        StackTraceElement[] elements = e.getStackTrace();
        for (int i = 0; i < elements.length; i++)
            {
            LOGGER.error(elements[i]);
            }
        }
        
        
    }

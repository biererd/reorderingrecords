package ch.zh.reorderingrecords.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

public record Conf(
    
    String fileInput,
    String fileOutput
    )

    {
    public static Conf getConf(String propertiesFile) throws Exception
        {
        Properties properties = new Properties();
        
        FileInputStream input = new FileInputStream(new File(propertiesFile));
        properties.load(new InputStreamReader(input, Charset.forName("UTF-8")));
        
        String fileInput  = properties.getProperty("fileInput").trim();
        String fileOutput = properties.getProperty("fileOutput").trim();
        
        return new Conf(fileInput,fileOutput);
        }
    }


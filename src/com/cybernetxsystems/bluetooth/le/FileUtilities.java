package com.cybernetxsystems.bluetooth.le;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

class FileUtilities {
  //private Writer writer;
  private String absolutePath;
  private final Context context;
  
  private static BufferedWriter sBufferedWriter;
  private static String obt;
  
  public FileUtilities(Context context) {
    super();
    this.context = context;
  }

//  public void write(String fileName, String data) {  
//          obt = fileName + ".txt"; 
//	File root = Environment.getExternalStorageDirectory();
//    File outDir = new File(root.getAbsolutePath() + File.separator + "EZ_time_tracker");
//    if (!outDir.isDirectory()) {
//      outDir.mkdir();
//    }
//    try {
//      if (!outDir.isDirectory()) {
//        throw new IOException(
//            "Unable to create directory EZ_time_tracker. Maybe the SD card is mounted?");
//      }
//      File outputFile = new File(outDir, obt);
//      sBufferedWriter = new BufferedWriter(new FileWriter(outputFile));
//      sBufferedWriter.write(data);
//     // Toast.makeText(context.getApplicationContext(),
//     //     "Report successfully saved to: " + outputFile.getAbsolutePath(),
//     //     Toast.LENGTH_LONG).show();
////      writer.close();
//    } catch (IOException e) {
//      Log.w("eztt", e.getMessage(), e);
//      Toast.makeText(context, e.getMessage() + " Unable to write to external storage.",
//          Toast.LENGTH_LONG).show();
//    }
//
//  }
  
 // public static void open( String fileName )
  public static void open()
  {
	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
     String currentDateandTime = sdf.format(new Date());
     obt = currentDateandTime + ".txt";
      
	 File root = Environment.getExternalStorageDirectory();
	 File outDir = new File(root.getAbsolutePath() + File.separator + "BLE-Tracker");
	    
	 if (!outDir.isDirectory()) 
	 {
	    outDir.mkdir();
	 }
	 
	 try 
	 {
	   if (!outDir.isDirectory()) 
	   {
	      throw new IOException(
	        "Unable to create directory BLE-Tracker. Maybe the SD card is mounted?");
	   }
	   File outputFile = new File(outDir, obt); 
	   sBufferedWriter = new BufferedWriter(new FileWriter(outputFile));
	   
	 } 
	 catch (IOException e) 
	 {
	     
	    //  Toast.makeText(context, e.getMessage() + " Unable to write to external storage.",
	    //      Toast.LENGTH_LONG).show();
	 }
  }
  
  public static void close()
  {
	  try
	  {
	     if ( sBufferedWriter != null )
	     {
	       sBufferedWriter.newLine( );
	       sBufferedWriter.flush( );
	       sBufferedWriter.close( );
	     }
	  }
	  catch ( IOException e )
	  {
	     Log.e( "FileLog", Log.getStackTraceString( e ) );
	  }
  }
  
  public static void write2(String data) 
  {  
	try {
		sBufferedWriter.write(data);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


  }

  public Writer getWriter() {
    return sBufferedWriter;
  }

  public String getAbsolutePath() {
    return absolutePath;
  }
  
//  public void writeStream(String fileName, String data) 
//  {  
//		
//	 
//			File file = new File("c:/newfile.txt");
//			String content = "This is the text content";
//	 
//			try (FileOutputStream fop = new FileOutputStream(file)) {
//	 
//				// if file doesn't exists, then create it
//				if (!file.exists()) {
//					file.createNewFile();
//				}
//	 
//				// get the content in bytes
//				byte[] contentInBytes = content.getBytes();
//	 
//				fop.write(contentInBytes);
//				fop.flush();
//				fop.close();
//	 
//				//System.out.println("Done");
//	 
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		
//	}
  
  
  

}

package com.example.glidden;

import android.app.Activity;
import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class CameraActivity extends Activity {
	  private Camera mCamera;
	  private CameraPreview mPreview;
	  private Button captureButton;
	  Context context = getApplicationContext();
	 
	  @Override
	  public void onCreate(Bundle savedInstanceState)
	  {
		  super.onCreate(savedInstanceState);
		  setContentView(R.layout.activity_camera);
		  
		  captureButton = (Button) findViewById(R.id.button1);
		  
		  // Create an instance of Camera
		  mCamera = getCameraInstance();

		  // Create our Preview view and set it as the content of our activity.
		  mPreview = new CameraPreview(this, mCamera);
		  FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
		  preview.addView(mPreview); 
	  }
	  
	  /** A safe way to get an instance of the Camera object. */
	  public Camera getCameraInstance(){
	      Camera c = null;
	      
	      try 
	      {
	          c = Camera.open(); // attempt to get a Camera instance
	      }
	      
	      catch (Exception e)
	      {
	    	  Toast.makeText(context, "No camera on this device", Toast.LENGTH_LONG).show();
	      }
	      
	      return c; // returns null if camera is unavailable
	  }
}


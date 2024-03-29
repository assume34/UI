package cossm.example.ui;


import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements SensorEventListener{
   TextView tv;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText text = (EditText)findViewById(R.id.editText1);

        SensorManager mgr = (SensorManager) this.getSystemService(SENSOR_SERVICE);

        List<android.hardware.Sensor> sensors = mgr.getSensorList(android.hardware.Sensor.TYPE_ALL);

        StringBuilder message = new StringBuilder(2048);
        message.append("The sensors on this device are:\n");
        
        for(android.hardware.Sensor sensor : sensors) {
          message.append(sensor.getName() + "\n");
          message.append("  Type: " + sensorTypes.get(sensor.getType()) + "\n");
          message.append("  Vendor: " + sensor.getVendor() + "\n");
          message.append("  Version: " + sensor.getVersion() + "\n");
          message.append("  Resolution: " + sensor.getResolution() + "\n");
          message.append("  Max Range: " + sensor.getMaximumRange() + "\n");
          message.append("  Power: " + sensor.getPower() + " mA\n");
        }
        text.setText(message);
    }
   public void onAccuracyChanged(android.hardware.Sensor sensor, int accuracy) {
      // TODO Auto-generated method stub
      
   }
   public void onSensorChanged(SensorEvent event) {
      // TODO Auto-generated method stub
      
   }
   private HashMap<Integer, String> sensorTypes = new HashMap<Integer, String>();

    { // Initialize the map of sensor type values and names
      sensorTypes.put(android.hardware.Sensor.TYPE_ACCELEROMETER, "TYPE_ACCELEROMETER"); // 1
      sensorTypes.put(android.hardware.Sensor.TYPE_GYROSCOPE, "TYPE_GYROSCOPE"); // 4
      sensorTypes.put(android.hardware.Sensor.TYPE_LIGHT, "TYPE_LIGHT"); // 5
      sensorTypes.put(android.hardware.Sensor.TYPE_MAGNETIC_FIELD, "TYPE_MAGNETIC_FIELD"); // 2
      sensorTypes.put(android.hardware.Sensor.TYPE_ORIENTATION, "TYPE_ORIENTATION"); // 3
      sensorTypes.put(android.hardware.Sensor.TYPE_PRESSURE, "TYPE_PRESSURE"); // 6
      sensorTypes.put(android.hardware.Sensor.TYPE_PROXIMITY, "TYPE_PROXIMITY"); // 8
      sensorTypes.put(android.hardware.Sensor.TYPE_TEMPERATURE, "TYPE_TEMPERATURE"); // 7
      sensorTypes.put(android.hardware.Sensor.TYPE_GRAVITY, "TYPE_GRAVITY"); // 9
      sensorTypes.put(android.hardware.Sensor.TYPE_LINEAR_ACCELERATION,"TYPE_LINEAR_ACCELERATION"); // 10
      sensorTypes.put(android.hardware.Sensor.TYPE_ROTATION_VECTOR,"TYPE_ROTATION_VECTOR"); // 11
    }
}

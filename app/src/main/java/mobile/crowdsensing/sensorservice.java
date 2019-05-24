package mobile.crowdsensing;

import android.app.Service;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

public class sensorservice   extends Service implements SensorEventListener {
    private SensorManager mSensorManager;
    private Sensor mSensor;

    @Nullable

    public void onCreate() {
        super.onCreate();
        // Get sensor manager on starting the service.
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        // Registering...
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);
        // Get default sensor type
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    public IBinder onBind(Intent intent) {
        throw new UnsupportedOperationException("Not Yet Implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Get sensor manager on starting the service.
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        // Registering...
        mSensorManager.registerListener(this, mSensor, SensorManager.SENSOR_DELAY_NORMAL);

        // Get default sensor type
        mSensor = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        return START_STICKY;

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {

        if (mSensor.getType() == Sensor.TYPE_ACCELEROMETER) {

            float[] values = sensorEvent.values;
            float x = values[0];
            float y = values[1];
            float z = values[2];
            Toast.makeText(this,"Accelerometer service is started"+Float.toString(x),Toast.LENGTH_SHORT).show();
            Log.i("kkkkkkkkkkkk", "MyClass.getView() — get item number " + values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

//    start service: startService(new Intent(this, MyService.class));
//    stop service :  stopService(new Intent(this, MyService.class));

}

package mobile.crowdsensing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SensorRestartBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = "kkkkkkkkkkkkkkkk";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i(TAG, "Service Stops, let's restart again.");
        context.startService(new Intent(context, SensorService.class));
    }
}

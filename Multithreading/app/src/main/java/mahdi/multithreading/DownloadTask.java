package mahdi.multithreading;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.lang.ref.WeakReference;

/**
 * Created by mahijazi on 15/11/16.
 */

public class DownloadTask extends AsyncTask<Void, Void, String> {
	public DownloadTask() {
		Log.d("Background Operation", "start download task");
	}

	@Override
	protected String doInBackground(Void... voids) {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "content downloaded";
	}

	@Override
	protected void onPostExecute(String s) {
		super.onPostExecute(s);
		EventBus.getDefault().postSticky(s);
	}
}
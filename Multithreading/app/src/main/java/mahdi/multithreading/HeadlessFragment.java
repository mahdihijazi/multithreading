package mahdi.multithreading;

import android.app.Fragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by mahijazi on 15/11/16.
 */

public class HeadlessFragment extends Fragment {
	public static final String TAG = HeadlessFragment.class.getSimpleName();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

		new DownloadTask().execute();
	}

	class DownloadTask extends AsyncTask<Void, Void, String> {
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
			((AsyncTask4)getActivity()).setText(s);
		}
	}
}

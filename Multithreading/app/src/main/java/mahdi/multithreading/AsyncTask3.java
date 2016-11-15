package mahdi.multithreading;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by mahijazi on 15/11/16.
 */

public class AsyncTask3 extends Activity {
	TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("AsyncTask3");
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);

		new DownloadTask(contentTextView).execute();

	}

	static class DownloadTask extends AsyncTask<Void, Void, String> {
		WeakReference<TextView> contentTextView;

		public DownloadTask(TextView contentTextView) {
			Log.d("Background Operation", "start download task");
			this.contentTextView = new WeakReference<TextView>(contentTextView);
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
			if(contentTextView.get() != null) {
				contentTextView.get().setText(s);
			}
		}
	}
}

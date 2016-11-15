package mahdi.multithreading;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by mahijazi on 15/11/16.
 */

public class AsyncTask2 extends Activity {
	TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("AsyncTask2");
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);

		new DownloadTask(contentTextView).execute();

	}

	static class DownloadTask extends AsyncTask<Void, Void, String> {
		TextView contentTextView;

		public DownloadTask(TextView contentTextView) {
			this.contentTextView = contentTextView;
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
			contentTextView.setText(s);
		}
	}
}

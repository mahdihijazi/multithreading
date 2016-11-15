package mahdi.multithreading;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;


public class AsyncTask1 extends Activity {

	TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("AsyncTask1");
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);

		new DownloadTask().execute();

	}

	class DownloadTask extends AsyncTask<Void, Void, String> {
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

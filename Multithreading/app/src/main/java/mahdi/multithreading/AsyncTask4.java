package mahdi.multithreading;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by mahijazi on 15/11/16.
 */

public class AsyncTask4 extends Activity {
	TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("AsyncTask4");
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);

		FragmentManager fragmentManager = getFragmentManager();
		HeadlessFragment fragment = (HeadlessFragment) fragmentManager
				.findFragmentByTag(HeadlessFragment.TAG);
		if(fragment==null) {
			fragment = new HeadlessFragment();
			fragmentManager.beginTransaction().add(fragment,
					HeadlessFragment.TAG).commit();
		}
	}

	public void setText(String content) {
		contentTextView.setText(content);
	}

}

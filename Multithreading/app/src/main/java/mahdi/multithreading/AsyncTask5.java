package mahdi.multithreading;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.lang.ref.WeakReference;

/**
 * Created by mahijazi on 15/11/16.
 */

public class AsyncTask5 extends Activity {
	TextView contentTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setTitle("AsyncTask3");
		setContentView(R.layout.activity_main);
		contentTextView = (TextView) findViewById(R.id.content);

		findViewById(R.id.downlaod).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				new DownloadTask().execute();
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		EventBus.getDefault().register(this);
	}

	@Override
	protected void onStop() {
		EventBus.getDefault().unregister(this);
		super.onStop();
	}

	@Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
	public void setContent(String content) {
		contentTextView.setText(content);
	}
}

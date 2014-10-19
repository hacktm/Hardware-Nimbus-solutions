package com.solutions.nimbus.doorbell.util.http;

import android.os.AsyncTask;
import android.widget.TextView;

class WraperWebRequest extends AsyncTask<String, String, String> {

	private TextView textView;
	private int nrRequests;

	public WraperWebRequest(TextView tv) {
		// TODO Auto-generated constructor stub
		this.textView = tv;
		this.nrRequests = 0;
	}

	@Override
	protected String doInBackground(String... uri) {
		for (int i = 0; i < 10; i++) {
			new WebRequest(this.textView).execute(uri[0]);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return "Hallo";
	}

	@Override
	protected void onPostExecute(String result) {
		super.onPostExecute(result);
		textView.setText(result);
		// Do anything with response..
	}
}
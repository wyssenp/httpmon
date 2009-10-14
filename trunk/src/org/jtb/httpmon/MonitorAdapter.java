package org.jtb.httpmon;

import java.util.ArrayList;

import org.jtb.httpmon.model.Monitor;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonitorAdapter extends ArrayAdapter {
	private LayoutInflater inflater;
	private ArrayList<Monitor> mMonitors;

	MonitorAdapter(Activity context, ArrayList<Monitor> monitors) {
		super(context, R.layout.monitor_row, monitors);
		this.inflater = context.getLayoutInflater();
		this.mMonitors = monitors;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		Monitor monitor = mMonitors.get(position);
		View view = inflater.inflate(R.layout.monitor_row, null);

		ImageView statusImg = (ImageView) view.findViewById(R.id.status_img);
		int state = monitor.getState();
		int id;
		if (state == Monitor.STATE_INVALID) {
			id = R.drawable.invalid;
		} else if (state == Monitor.STATE_VALID) {
			id = R.drawable.valid;
		} else if (state == Monitor.STATE_RUNNING) {
			id = R.drawable.running;
		} else {
			id = R.drawable.stopped;
		}
		statusImg.setImageResource(id);

		TextView nameText = (TextView) view.findViewById(R.id.name_text);
		nameText.setText(monitor.getName());

		return view;
	}
}
